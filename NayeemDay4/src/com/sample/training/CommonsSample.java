package com.sample.training;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsSample {
	private static final Log log = LogFactory.getLog(CommonsSample.class);

	public static void main(String[] args) {
		log.error("-----Commons Lang-------");
		log.info(StringUtils.leftPad("ab", 10, "0"));
		log.info(StringUtils.trim("     ab      "));
		log.info(StringUtils.remove("00000ab00", "0"));
		log.info(StringUtils.replace("abbbabbababbbabbba", "ab", "c"));
		log.error("-----Commons Codec-------");
		log.info(Base64.encodeBase64String("aweffrhhyjdtjdutkdyfh".getBytes()));
		log.info(new String(Base64.decodeBase64("YXdlZmZyaGh5amR0amR1dGtkeWZo".getBytes())));
		log.info(Md5Crypt.md5Crypt("SecetPassword".getBytes()));
	}
}
