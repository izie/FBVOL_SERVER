package com.capstone.fbvol.common.util;

public class NumUtil{
	//
	public static String strToKor1(String gab,String retVal){	
		try{
			if( KUtil.nchk(gab).length()<1 ){
				return retVal;
			}

			int qu	= gab.length() / 4;
			int re	= gab.length() % 4;

			int	sutja		= 0;
			String sutja_rd	= "";
			String sutja_jr	= "";

			String read		= "";


			for(int i=0;i<gab.length();i++) { 
				sutja	= Integer.parseInt(gab.substring(i,i+1));
				
				if(sutja == 1)	sutja_rd = "일";
				else if(sutja == 2)	sutja_rd = "이";
				else if(sutja == 3)	sutja_rd = "삼";
				else if(sutja == 4)	sutja_rd = "사";
				else if(sutja == 5)	sutja_rd = "오";
				else if(sutja == 6)	sutja_rd = "육";
				else if(sutja == 7)	sutja_rd = "칠";
				else if(sutja == 8)	sutja_rd = "팔";
				else if(sutja == 9)	sutja_rd = "구";
				else				sutja_rd = "";
				
				switch((gab.length() - i -1) % 4 +1) {
					case(2):	sutja_jr = "십";break;
					case(3):	sutja_jr = "백";break;
					case(4):	sutja_jr = "천";break;
					default:	sutja_jr = "";
				}
				
				if(sutja_rd != "")	read	+= sutja_rd + sutja_jr;
				
				if((gab.length() - i - 1) % 4 == 0) {
					switch((gab.length() - i - 1) / 4) {
						case(1):	read += "만 ";break;
						case(2):	read += "억 ";break;
						case(3):	read += "조 ";break;
						default:	break;
					}
				}
			}
			return read;
		}catch(Exception e){
			System.out.println(e.toString());
			return retVal;
		}
	}//method strToKor

	public static String longToKor1(long longgab,String retVal){	
		try{
			if( longgab<1 ){
				return retVal;
			}
			String gab = Long.toString(longgab);
			int qu	= gab.length() / 4;
			int re	= gab.length() % 4;

			int	sutja		= 0;
			String sutja_rd	= "";
			String sutja_jr	= "";

			String read		= "";


			for(int i=0;i<gab.length();i++) { 
				sutja	= Integer.parseInt(gab.substring(i,i+1));
				
				if(sutja == 1)	sutja_rd = "일";
				else if(sutja == 2)	sutja_rd = "이";
				else if(sutja == 3)	sutja_rd = "삼";
				else if(sutja == 4)	sutja_rd = "사";
				else if(sutja == 5)	sutja_rd = "오";
				else if(sutja == 6)	sutja_rd = "육";
				else if(sutja == 7)	sutja_rd = "칠";
				else if(sutja == 8)	sutja_rd = "팔";
				else if(sutja == 9)	sutja_rd = "구";
				else				sutja_rd = "";
				
				switch((gab.length() - i -1) % 4 +1) {
					case(2):	sutja_jr = "십";break;
					case(3):	sutja_jr = "백";break;
					case(4):	sutja_jr = "천";break;
					default:	sutja_jr = "";
				}
				
				if(sutja_rd != "")	read	+= sutja_rd + sutja_jr;
				
				if((gab.length() - i - 1) % 4 == 0) {
					switch((gab.length() - i - 1) / 4) {
						case(1):	read += "만 ";break;
						case(2):	read += "억 ";break;
						case(3):	read += "조 ";break;
						default:	break;
					}
				}
			}
			return read;
		}catch(Exception e){
			System.out.println(e.toString());
			return retVal;
		}
	}//method strToKor
	

	public static String strToKor(String gab,String retVal){	
		try{
			if( KUtil.nchk(gab).length()<1 ){
				return retVal;
			}

			int qu	= gab.length() / 4;
			int re	= gab.length() % 4;

			int	sutja		= 0;
			String sutja_rd	= "";
			String sutja_jr	= "";

			String read		= "";


			for(int i=0;i<gab.length();i++) { 
				sutja	= Integer.parseInt(gab.substring(i,i+1));
				
				if(sutja == 1){
					if( i==0 || ((gab.length() - i -1) % 4) ==0){
						sutja_rd = "일";
					}else sutja_rd="";
					
				}else if(sutja == 2)	sutja_rd = "이";
				else if(sutja == 3)	sutja_rd = "삼";
				else if(sutja == 4)	sutja_rd = "사";
				else if(sutja == 5)	sutja_rd = "오";
				else if(sutja == 6)	sutja_rd = "육";
				else if(sutja == 7)	sutja_rd = "칠";
				else if(sutja == 8)	sutja_rd = "팔";
				else if(sutja == 9)	sutja_rd = "구";
				else				sutja_rd = "";
				
				switch((gab.length() - i -1) % 4 +1) {
					case(2):	sutja_jr = "십";break;
					case(3):	sutja_jr = "백";break;
					case(4):	sutja_jr = "천";break;
					default:	sutja_jr = "";
				}
				
				if(sutja != 0)	read	+= sutja_rd + sutja_jr;
				
				if((gab.length() - i - 1) % 4 == 0) {
					switch((gab.length() - i - 1) / 4) {
						case(1):	read += "만 ";break;
						case(2):	read += "억 ";break;
						case(3):	read += "조 ";break;
						default:	break;
					}
				}
			}
			return read;
		}catch(Exception e){
			System.out.println(e.toString());
			return retVal;
		}
	}//method strToKor

	public static String strToKor(long longgab,String retVal){	
		try{
			if( longgab<1 ){
				return retVal;
			}
			
			String gab = Long.toString(longgab);
			int qu	= gab.length() / 4;
			int re	= gab.length() % 4;

			int	sutja		= 0;
			String sutja_rd	= "";
			String sutja_jr	= "";

			String read		= "";


			for(int i=0;i<gab.length();i++) { 
				sutja	= Integer.parseInt(gab.substring(i,i+1));
				
				if(sutja == 1){
					if( i==0 || ((gab.length() - i -1) % 4) ==0){
						sutja_rd = "일";
					}else sutja_rd="";
					
				}else if(sutja == 2)	sutja_rd = "이";
				else if(sutja == 3)	sutja_rd = "삼";
				else if(sutja == 4)	sutja_rd = "사";
				else if(sutja == 5)	sutja_rd = "오";
				else if(sutja == 6)	sutja_rd = "육";
				else if(sutja == 7)	sutja_rd = "칠";
				else if(sutja == 8)	sutja_rd = "팔";
				else if(sutja == 9)	sutja_rd = "구";
				else				sutja_rd = "";
				
				switch((gab.length() - i -1) % 4 +1) {
					case(2):	sutja_jr = "십";break;
					case(3):	sutja_jr = "백";break;
					case(4):	sutja_jr = "천";break;
					default:	sutja_jr = "";
				}
				
				if(sutja != 0)	read	+= sutja_rd + sutja_jr;
				
				if((gab.length() - i - 1) % 4 == 0) {
					switch((gab.length() - i - 1) / 4) {
						case(1):	read += "만 ";break;
						case(2):	read += "억 ";break;
						case(3):	read += "조 ";break;
						default:	break;
					}
				}
			}
			return read;
		}catch(Exception e){
			System.out.println(e.toString());
			return retVal;
		}
	}//method strToKor


	public static String strToKor(double longgab,String retVal){	
		try{
			if( longgab<1 ){
				return retVal;
			}
			
			String gab		= NumUtil.numToFmt(longgab, "##","0");
			String realGab  = NumUtil.numToFmt(longgab, "##.##","0");
			String gabdot	= "";
			if( realGab.indexOf(".") != -1 ){
				gabdot	= realGab.substring( realGab.indexOf(".")+1, realGab.length() );
			}
			System.out.println("gab"+gab);
			System.out.println("gabdot"+gabdot);
			
			int qu	= gab.length() / 4;
			int re	= gab.length() % 4;

			int	sutja		= 0;
			String sutja_rd	= "";
			String sutja_jr	= "";

			String read		= "";


			for( int i=0 ; i<gab.length() ; i++ ) { 
				System.out.println("B");
				sutja	= Integer.parseInt(gab.substring(i,i+1));
				
				if(sutja == 1){
					if( i==0 || ((gab.length() - i -1) % 4) ==0){
						sutja_rd = "일";
					}else sutja_rd="";
					
				}else if(sutja == 2)	sutja_rd = "이";
				else if(sutja == 3)	sutja_rd = "삼";
				else if(sutja == 4)	sutja_rd = "사";
				else if(sutja == 5)	sutja_rd = "오";
				else if(sutja == 6)	sutja_rd = "육";
				else if(sutja == 7)	sutja_rd = "칠";
				else if(sutja == 8)	sutja_rd = "팔";
				else if(sutja == 9)	sutja_rd = "구";
				else				sutja_rd = "";
				
				switch((gab.length() - i -1) % 4 +1) {
					case(2):	sutja_jr = "십";break;
					case(3):	sutja_jr = "백";break;
					case(4):	sutja_jr = "천";break;
					default:	sutja_jr = "";
				}
				
				if(sutja != 0)	read	+= sutja_rd + sutja_jr;
				
				if((gab.length() - i - 1) % 4 == 0) {
					switch((gab.length() - i - 1) / 4) {
						case(1):	read += "만 ";break;
						case(2):	read += "억 ";break;
						case(3):	read += "조 ";break;
						default:	break;
					}
				}
			}

			if( gabdot.length()>0  ){
				read += ".";
				for( int j=0 ; j<gabdot.length() ; j++ ){
					System.out.println("gabdot.length()"+gabdot.length());
					System.out.println("A"+j);
					sutja	= Integer.parseInt(gabdot.substring(j,j+1));
					if(sutja == 0)		sutja_rd = "공";
					else if(sutja == 1)	sutja_rd = "일";
					else if(sutja == 2)	sutja_rd = "이";
					else if(sutja == 3)	sutja_rd = "삼";
					else if(sutja == 4)	sutja_rd = "사";
					else if(sutja == 5)	sutja_rd = "오";
					else if(sutja == 6)	sutja_rd = "육";
					else if(sutja == 7)	sutja_rd = "칠";
					else if(sutja == 8)	sutja_rd = "팔";
					else if(sutja == 9)	sutja_rd = "구";
					
					read += sutja_rd;

				}//for
				System.out.println("read1::::"+read);
				boolean flag = true;
				while( flag ){
					if( read.charAt(read.length()-1)=='공' || read.charAt(read.length()-1)=='.' ){
						read = read.substring( read.length()-1 , read.length() );
					}else{
						flag = false;
					}
				}
			}
			System.out.println("read::::"+read);
			return read;
		}catch(Exception e){
			System.out.println(e.toString());
			return retVal;
		}
	}//method strToKor
	
	public static String numToFmt(Object obj, String fmt,String retVal){
		

		try{
			if( obj == null || fmt==null || KUtil.nchk(fmt).length()<1 ){
				return retVal;
			}

			java.text.DecimalFormat df = new java.text.DecimalFormat(fmt); 
			
			return df.format(obj);
			
		}catch(Exception e){
			System.out.print(e.toString());
			return retVal;
		}
		
	}
	// ###,###.##
	public static String numToFmt(double val, String fmt,String retVal){
		

		try{
			if( fmt==null || KUtil.nchk(fmt).length()<1 ){
				return retVal;
			}

			java.text.DecimalFormat df = new java.text.DecimalFormat(fmt); 
			
			return df.format(val);
			
		}catch(Exception e){
			System.out.print(e.toString());
			return retVal;
		}
		
	}

}//class
