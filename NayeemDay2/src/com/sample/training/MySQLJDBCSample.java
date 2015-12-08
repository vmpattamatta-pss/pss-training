package com.sample.training;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

import com.mysql.jdbc.Driver;

public class MySQLJDBCSample {
	public static void main(String[] args) throws Exception {
		MySQLJDBCSample sample = new MySQLJDBCSample();
		sample.loadFile("C:\\Java\\io\\filesrc.txt");
		sample.calculateResult();
	}

	protected void registerDriver() throws Exception {
		DriverManager.registerDriver(new Driver());
	}

	protected void loadDriver() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
	}

	private Connection getConnection(String user, String password, String url) throws Exception {
		loadDriver();
		return DriverManager.getConnection(url, user, password);
	}

	private void closeConnection(Connection conn) throws Exception {
		conn.close();
	}

	private void loadFile(String src) throws IOException, Exception {
		File srcFile = new File(src);
		BufferedReader reader = new BufferedReader(new FileReader(srcFile));
		Connection conn = getConnection("root", "password", "jdbc:mysql://localhost:3306/java_training");
		conn.createStatement().execute("delete from  `java_training`.`calc`");
		while (true) {
			String dataLine = reader.readLine();
			if (dataLine == null || dataLine.trim().length() == 0)
				break;
			String[] values = dataLine.split(",");
			if (values.length != 3)
				continue;
			if (Integer.parseInt(values[0]) < 1 || Integer.parseInt(values[0]) > 5)
				continue;
			PreparedStatement statement = conn.prepareStatement("insert into `java_training`.`calc` values(?,?,?,0,?)");
			statement.setInt(1, Integer.parseInt(values[1]));
			statement.setInt(2, Integer.parseInt(values[2]));
			statement.setInt(3, Integer.parseInt(values[0]));
			statement.setString(4, UUID.randomUUID().toString());
			System.out.println(statement.execute());
			statement.close();
		}
		closeConnection(conn);
		reader.close();
	}

	private void calculateResult() throws Exception {
		Connection conn = getConnection("root", "password", "jdbc:mysql://localhost:3306/java_training");
		Statement statement = conn.createStatement();
		ResultSet set = statement.executeQuery("SELECT * FROM java_training.calc");
		while (set.next()) {
			Calculator calculator = new Calculator(set.getInt(1), set.getInt(2), set.getInt(3));
			PreparedStatement updateStatement = conn
					.prepareStatement("update `java_training`.`calc` set res=? where id=?");
			updateStatement.setInt(1, calculator.calculate());
			updateStatement.setString(2, set.getString(5));
			System.out.println(updateStatement.executeUpdate());
		}
		closeConnection(conn);
	}
}
