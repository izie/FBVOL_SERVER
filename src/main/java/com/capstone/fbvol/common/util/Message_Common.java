package com.capstone.fbvol.common.util;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.Vector;

public class  Message_Common
{
	Socket			  sendSocket = null ;
	InputStreamReader inputReader = null ;
	BufferedReader	  buffReader  = null ;
	StringTokenizer   strTocken   = null ;
	String			  readLine	  = null ;
	String			  smsServerIP1	  = "messenger.surem.com" ;
	String			  smsServerIP2	  = "messenger3.surem.com" ;
	int				  smsServerPort	  = 8080 ;
	Vector			  vec		  = null ;

	
	//StringBuffer�� �� �ʵ��� ����Ÿ�� append
	public void appendToBuffer( StringBuffer strBuff, String fieldData, int fieldLength )
	{
		int fieldDataLength = fieldData.getBytes().length ;
		strBuff.append( fieldData ) ;
		
		for( int inx = fieldLength - fieldDataLength ; inx > 0 ; inx-- )
			strBuff.append( '\0' ) ;
	}
			
	public Vector readFile( String filename, String type){
		int		startidx = 0 ;
		int		endidx   = 0 ;
		String  temp	 = "" ;
		vec				 = new Vector() ;
		if (filename.length()==0)
		{
			if (type.equals("S"))
			{
				filename = "sms.txt";
			}else{
				filename = "url.txt";
			}
		}
		try{
			inputReader = new InputStreamReader(new FileInputStream(filename));
			buffReader  = new BufferedReader(inputReader);
			
			while ( buffReader.ready() )
			{	
				readLine = buffReader.readLine();
				strTocken		 = new StringTokenizer(readLine,"	");
				vec.addElement(strTocken);
			}//end while
		}catch(ArrayIndexOutOfBoundsException ie){
			System.out.println( "ArrayIndexOutOfBoundsException : " +  ie);
		}catch(IOException ie){
			System.out.println( "IOException : " +  ie);
		}catch(Exception ne){
			System.out.println( "StringIndexOutOfBoundsException : " +  ne);
		}//end try
		
		return vec;
	}//end writeFile

	public void writeFile( String str ){
		SimpleDateFormat dfDate = new SimpleDateFormat( "yyyyMMdd" ) ;
		java.util.Date currTime	= new java.util.Date() ;		
		File file = null;
		FileOutputStream fos = null;
		int c;

		try{
			//file = new File("c:/Temp/",dfDate.format( currTime )+".LOG");
			fos = new FileOutputStream("e:/web/WEB-INF/logs/sms_" + dfDate.format( currTime ) + ".log", true);
			fos.write( (str).getBytes());
		
		}catch(IOException e){
			System.out.println("File Writer Error : " + e);
		}finally{
			try{
				if(fos != null){
					fos.close();
				}	
			}catch(Exception e){
				System.out.println("File Writer Error : " + e);
			}
		}
	}

    public int int2byte( int i ) {

		i=(((i>>24)&0xFF)|((i>>8)&0xFF00)|((i<<8)&0xFF0000)|((i<<24)&0xFF000000));

        return i;
    }

	public int Result_int(int[] intArray){
		int money = 0;
		int temp = 0;

		for ( int i=0 ; i<3 ; i++ )
		{
			if ( intArray[i]<0 )
			{
				temp = 256 + intArray[i];
			}else{
				temp = intArray[i];
			}

			if (i==0){
				temp = temp * 1;
			}else if(i==1){
				temp = temp * 256;
			}else {
				temp = temp * 65536;
			}
			money = money + temp;
		}

		return money;
	}

	public Socket Sconnect() throws SocketException{

		try{
			sendSocket = new Socket( smsServerIP1, smsServerPort ) ;		//Ŭ���̾�Ʈ�� ��Ĺ ��			
		}catch (IOException e){
			//sendSocket.close();
			try{
				sendSocket = new Socket( smsServerIP2, smsServerPort ) ;		//Ŭ���̾�Ʈ�� ��Ĺ ��							
			}catch (IOException se){
				//sendSocket.close();
				throw new SocketException(se.getMessage());
			}
		}

		return sendSocket;
	}

}
