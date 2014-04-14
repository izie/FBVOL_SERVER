package com.capstone.fbvol.common.util;


public class ChkPer{

	/**
	 * ����üũ
	 * @param permission
	 * @param nPage
	 * @return
	 */
	public static char getPer( String permission, char nPage ){
		try{
			if( permission == null || permission.length() < 4 ){
				return 'N';
			}
			
			char retVal = 'N';

			if( nPage == 'R' ){
				if( permission.charAt(0)=='1' ){
					retVal = 'Y';
				}
			}else if( nPage == 'W' ){
				if( permission.charAt(1)=='1' ){
					retVal = 'Y';
				}
			}else if( nPage == 'M' ){
				if( permission.charAt(2)=='1' ){
					retVal = 'Y';
				}
			}else if( nPage == 'D' ){
				if( permission.charAt(3)=='1' ){
					retVal = 'Y';
				}
			}

			return retVal;
		}catch(Exception e){
			System.out.print(e.toString());
			return 'N';
		}finally{
			
		}
	}


}//class
