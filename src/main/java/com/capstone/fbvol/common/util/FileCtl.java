package com.capstone.fbvol.common.util;

import java.io.File;


public class FileCtl{
	
	String fileTemp = "";

	public FileCtl(){}

	public static int fileMoves(String fileText, String saveDirReal){
		try{
			AttachFileUtil afu = new AttachFileUtil();

			String tempDir = saveDirReal+"/temp";
					
			String[] arrFiles = fileText.split("_@_");
			
			File file = null;
			for( int i=0 ; i<arrFiles.length ; i++ ){
				file = new File(tempDir,arrFiles[i]);
				if( file.exists() ){
					file.renameTo( new File( saveDirReal,file.getName() ) );
				}
			}

			return 1;
		}catch(Exception e){
			System.out.print(e.toString()+"FileCtl:fileMove(String files)");
			return -1;
		}
	}

	public static String getString(String[] filesText,String retVal){
		try{
			String val = "";
			if( filesText == null ){
				return retVal;
			}

			for( int i=0 ; i<filesText.length ; i++ ){
				if( KUtil.nchk(filesText[i]).length() > 0 ){
					val += KUtil.nchk(filesText[i])+"_@_";
				}
			}

			return val;
		}catch(Exception e){
			System.out.print(e.toString()+"FileCtl:getString(String[] filesText)");
			return null;
		}
	}
	
	/**
	 * 파일 삭제 
	 * @param fileNames - 파일명
	 * @param retval - 에러 리턴 값
	 * @param seq - 일련번호 
	 * @param dbtb - db 테이블명
	 * @param seperator - 구분자 <PRE><BR></PRE>
	 * @param isDelBtn - 삭제 여부
	 * @return String - 리턴값
	 */
	public static String fileViewLink(	String fileNames, 
									  	String retval, 
									  	int seq, 
									  	String dbtb, 
									  	String seperator, 
									  	int isDelBtn) {
		
		StringBuffer sbf = new StringBuffer();

		try{
			if( KUtil.nchk(fileNames).length() < 1 ) return retval;
			
			String[] filesText = fileNames.split("_@_");
			for( int i=0 ; i<filesText.length ; i++ ){
				if(filesText[i] != null && filesText[i].length() > 15){
					if( i > 0 ) sbf.append(seperator+" ");
					sbf.append("<a href=\"/download.jsp?fn="+java.net.URLEncoder.encode(filesText[i])+"\" target='_nlink'>");
					sbf.append(filesText[i].substring(filesText[i].indexOf("_")+1,filesText[i].length()));
					sbf.append("</a>");
					if( isDelBtn==1 ){
						sbf.append("<A HREF=\"/main/file_DBD.jsp?fname="
									+java.net.URLEncoder.encode(filesText[i])+"&seq="+seq+"&dbnm="+dbtb+"\"  target='_blank'><FONT color=#81A5B4>[삭제]</FONT></A>");
					}
				}				
			}
			return sbf.toString();	
		}catch(Exception e){
			System.out.print(e.toString());
			return null;
		}
		
	}

	public static boolean fileDel(String dir, String fileName){
		if(dir == null || fileName == null || dir.length() < 1 || fileName.length() < 1){
			return false;
		}
		File file = new File(dir, fileName);
		return file.delete();

	}

	public static boolean filesDel(String dir, String fileNames){
		try{
			if(dir == null || fileNames == null || dir.length() < 1 || fileNames.length() < 1){
				return false;
			}
			String[] filesText = fileNames.split("_@_");
			for( int i=0 ; i<filesText.length ; i++ ){
				File file = new File(dir, filesText[i]);	
				file.delete();
			}
			
			return true;
		}catch(Exception e){
			System.out.print(e.toString());
			return false;
		}
	}

}// class