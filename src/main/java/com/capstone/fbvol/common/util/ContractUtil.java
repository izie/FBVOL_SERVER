package com.capstone.fbvol.common.util;

public class ContractUtil {

	private static final int SUFFIX_LENGTH = 4;
/*
	*//** 계약번호를 만들어 준다
	 *
	 * @param seqNoStr : "04"
	 * @return ex) IBB20090419-0004
	 * @throws Exception
	 *//*
	public static String createContractCode(int seqNoStr) throws Exception {

		if (seqNoStr == 0) {
			seqNoStr++;
		}

		String suffix = Long.toString(seqNoStr);

		for(int i=suffix.length(); i < SUFFIX_LENGTH; i++) {
			suffix = "0" + suffix;
		}


		return "IBB" +  DateUtil.getDate("yyyyMMdd") + "-" + suffix + "00";
	}*/


}
