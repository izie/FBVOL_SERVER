package com.capstone.fbvol.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Message extends Message_Common
{
	
	Socket					sendSocket = null ;
	BufferedInputStream	 	bis = null ;
	BufferedOutputStream	bos = null ;
	DataOutputStream		dos = null ;
	String[]				smsFieldData = null ;
	String[]				urlFieldData = null ;
	String 					smsResponse = null ;
	int[]				    smsFieldLength  ;
	int[]				    urlFieldLength  ;
	
	//�޾ƾ��� parameter��....
	private 	String  	member ;						//Client�� key�Ϸù�ȣ
	private 	String 		usercode = null ; 				//����� �߽� �ڵ�
	private 	String		username = null ;				//����ڸ�
	private 	String 		callphone1 = null ; 			//ȣ�� ��ȣ #1	
	private 	String 		callphone2 = null ;				//ȣ�� ��ȣ #2
	private 	String 		callphone3 = null ;				//ȣ�� ��ȣ #3
	private 	String 		callmessage = null ;			//ȣ�� �޽���
	private 	String 		rdate = null ;					//�޽��� ��� ��������
	private 	String 		rtime = null ;					//�޽��� ��� ����ð� 
	private 	String 		reqphone1 = null ;				//ȸ�� ��ȣ#1
	private 	String 		reqphone2 = null ;				//ȸ�� ��ȣ#2 
	private 	String 		reqphone3 = null ;				//ȸ�� ��ȣ#3
	private 	String 		callname = null ;				
	private 	String 		deptcode = null ;				//ȸ�� �ڵ�
	private 	String 		deptname = null ;				//ȸ���
	private 	String 		callurl = null ;				//CallUrl
	private		String		status  = null ;

	public Message(){
	}
	public String sendMain( String member, String usercode, String username, String callphone1,
						  String callphone2, String callphone3, String callmessage, String rdate,
						  String rtime, String reqphone1, String reqphone2, String reqphone3,
						  String callname, String deptcode, String deptname )
   {
   		//�Ķ���ͷ� �������� ���� ������ setting
   		this.member			= 	member ;
   		this.usercode 		= 	usercode ;
   		this.username		=	username ;
   		this.callphone1 	= 	callphone1 ;
   		this.callphone2 	= 	callphone2 ;
   		this.callphone3 	= 	callphone3 ;
   		this.callmessage 	= 	callmessage ;
   		this.rdate			=	rdate ;
   		this.rtime			=	rtime ;
   		this.reqphone1		=	reqphone1 ;
   		this.reqphone2		=	reqphone2 ;
   		this.reqphone3		=	reqphone3 ;
   		this.callname		= 	callname ;
   		this.deptcode		=	deptcode ;
   		this.deptname		=	deptname ;
   		
   		
		//smsFieldData = new String[ smsFieldName.length ] ;
		smsFieldData = new String[ 22 ] ;
		setSMSFieldData( smsFieldData ) ;		//SMS Packet �� �� �ʵ带 setting  �ϴ� �޼ҵ� 
		
		try 
		{
			sendSocket = Sconnect() ;		//Ŭ���̾�Ʈ�� ��Ĺ ��
			
			bos = new BufferedOutputStream( sendSocket.getOutputStream() ) ;
			bis = new BufferedInputStream( sendSocket.getInputStream() ) ;
			dos = new DataOutputStream( bos ) ;
			
			smsFieldLength = new int[22] ;
			setSMSFieldInfo( smsFieldLength ) ;	
		
		
			/////������ SMS request �� send..../
			sendSMSRequest( dos, smsFieldData ) ;	
			
			//////������ ���� ������ �޾ƿ� /////
			smsResponse = reciveSMSResponse( bis ) ;
			
		}
		catch( IOException e )
		{
			System.out.println( "sendMain() �κ� ���� : " + e ) ;
		}
		finally
		{
			try
			{
				if( dos != null )
						dos.close() ;
				if( bos != null ) 
						bos.close() ;
				if( bis != null )
						 bis.close() ;		
				if( sendSocket != null ) 
						sendSocket.close() ;
			}
			catch( Exception e ) 
			{
				System.out.println( "sendMain() �� ��Ʈ���� ���ϰ�ü �ݳ��κ� ���� : " + e ) ;
			}
		}
		System.out.println("sendmain succ");
		return smsResponse;
	}
	
	//SMS Packet �� �ʵ��� Length�� Setting
	
	public void setSMSFieldInfo( int[] smsFieldLength ) 
	{
		smsFieldLength[0]  = 1 ;				 	//char
		smsFieldLength[1]  = 1 ;					//char
		smsFieldLength[2]  = 10 ;					//char[10]
		smsFieldLength[3]  = 8 ;					//char[8]
		smsFieldLength[4]  = 30 ;					//char[30]
		smsFieldLength[5]  = 16 ;					//char[16]
		smsFieldLength[6]  = 12 ;					//char[12]	
		smsFieldLength[7]  = 16 ;					//char[16]
		smsFieldLength[8]  = 1 ;					//char
		smsFieldLength[9]  = 4 ;					//char[4]
		smsFieldLength[10] = 4 ;					//char[4]
		smsFieldLength[11] = 4 ;					//char[4]
		smsFieldLength[12] = 120 ;					//char[120]
		smsFieldLength[13] = 10 ;					//char[10]
		smsFieldLength[14] = 8 ;					//char[8]
		smsFieldLength[15] = 3 ;					//char[3]
		smsFieldLength[16] = 8 ;					//long
		smsFieldLength[17] = 4 ;					//char[4]
		smsFieldLength[18] = 4 ;					//char[4]
		smsFieldLength[19] = 4 ;					//char[4]	
		smsFieldLength[20] = 32 ;					//char[32]
		smsFieldLength[21] = 32 ;					//char[32]
		
	}      
	
		
	//SMS Packet�� �� �ʵ带 Setting
	public void setSMSFieldData( String[] smsFieldData ) 
	{
		
		smsFieldData[0]  = "B" ;						//Command
		smsFieldData[1]  = "O" ;						//Type
		smsFieldData[2]  = rdate ;						//Date
		smsFieldData[3]  = rtime ;						//Time
		smsFieldData[4]  = usercode ;					//UserCode
		smsFieldData[5]  = username ;					//UserName
		smsFieldData[6]  = deptcode ;				    //DeptCode
		smsFieldData[7]  = deptname ;			     	//DeptName

		if (rdate.equals("00000000")){
			smsFieldData[8]  = "" ;							//Status			
		}else{
			smsFieldData[8]  = "R" ;						//Status
		}
		
		//CallPhoneó�� '011-123-4567' --> '011', '123', 4567'�� �и�	
		smsFieldData[9]  = callphone1 ;					//CallPhone1 
		smsFieldData[10] = callphone2 ;					//CallPhone2
		smsFieldData[11] = callphone3 ;					//CallPhone3
		
		smsFieldData[12] = callmessage ;		    	//CallMessage
		smsFieldData[13] = rdate ;						//Rdate
		smsFieldData[14] = rtime ;						//Rtime
		smsFieldData[15] = "" ;							//Dummy
		smsFieldData[16] = member ;		        		//Ŭ���̾�Ʈ�� �Ϸ� ��ȣ
		
		//ReqPhoneó�� '011-123-4567' --> '011', '123', 4567'�� �и�	
		smsFieldData[17] = reqphone1  ;					//reqphone1 
		smsFieldData[18] = reqphone2  ;					//reqphone2
		smsFieldData[19] = reqphone3  ;					//reqphone3
		smsFieldData[20] = callname  ;					//reqname
		smsFieldData[21] = "" ;							//reserved
	}	
		
	//SureM.COM������ SMS  request �� send.....
	public void sendSMSRequest( DataOutputStream dos, String[] smsFieldData ) throws IOException
	{
		
		StringBuffer strBuff = new StringBuffer() ;
		byte[] byteBuff = null ;
		
		try 
		{
			for( int inx = 0 ; inx < 16 ; inx++ ) {
				appendToBuffer( strBuff, smsFieldData[inx], smsFieldLength[inx] ) ;
				System.out.println( inx + " : " +  strBuff.toString().getBytes()  ) ;
			}	
				
			byteBuff = strBuff.toString().getBytes() ;
			dos.write( byteBuff, 0 , byteBuff.length ) ;
			strBuff.delete( 0, strBuff.length() ) ;
			dos.writeInt( int2byte(Integer.parseInt( smsFieldData[16] )) ) ;
		
			for( int inx = 17 ; inx < 22 ; inx++ ) {
				appendToBuffer( strBuff, smsFieldData[inx], smsFieldLength[inx] ) ;
				System.out.println( inx + " : " +  strBuff.toString().getBytes()  ) ;
			}

			byteBuff = strBuff.toString().getBytes() ;
			dos.write( byteBuff, 0 , byteBuff.length ) ;
			dos.flush() ;
		} 
		catch( IOException e ) 
		{
			throw e ;
		}
	}			
			
	//SureM.COM ������ ���� SMS response�� receive...
	public String reciveSMSResponse( BufferedInputStream bis )
	{
		byte[] byteBuff = new byte[1024] ;
		String strReceivedMsg = null ;
		int[] intArray = new int[4];
	
		try 
		{
			int iReadCount = bis.read( byteBuff ) ;
			if( iReadCount > 0 ) {
//				strReceivedMsg = new String( byteBuff, 0 , iReadCount ) ;
				status = new String(byteBuff,94,1);
// ������� ���� ��� ����
//				for(int i=0; i< 4; i++) intArray[i] = (int)byteBuff[i+248];
//				System.out.println("member�� : "+Result_int( intArray ));
// ������� ���� ��� ��
				writeFile("command=["+ smsFieldData [0] +"]	usercode=["+ smsFieldData [4] +"]	username=["+ smsFieldData [5] +"]	callphone1=["+ smsFieldData [9] +"]	callphone2=["+ smsFieldData [10] +"]	callphone3=["+ smsFieldData [11] +"]	callmessage=["+ smsFieldData [12] +"]	rdate=["+ smsFieldData [13] +"]	rtime=["+ smsFieldData [14] +"]	reqphone1=["+ smsFieldData [17] +"]	reqphone2=["+ smsFieldData [18] +"]	reqphone3=["+ smsFieldData [18] +"]	status=["+ status +"]\n");
			}
		}
		catch( IOException e ) 
		{
			System.out.println( "������ ���� ������ �޾ƿ��µ� ���� : " + e ) ;
		}
		
		return status ;
	}
				

//		
// URL ���
//
		
	public String sendURLMain( String member, String usercode, String username, String callphone1,
						  String callphone2, String callphone3, String callmessage, String rdate,
						  String rtime, String reqphone1, String reqphone2, String reqphone3,
						  String callname, String deptcode, String deptname, String callurl )
   {
   		//�Ķ���ͷ� �������� ���� ������ setting
   		this.member			= 	member ;
   		this.usercode 		= 	usercode ;
   		this.username		=	username ;
   		this.callphone1 	= 	callphone1 ;
   		this.callphone2 	= 	callphone2 ;
   		this.callphone3 	= 	callphone3 ;
   		this.callmessage 	= 	callmessage ;
   		this.rdate			=	rdate ;
   		this.rtime			=	rtime ;
   		this.reqphone1		=	reqphone1 ;
   		this.reqphone2		=	reqphone2 ;
   		this.reqphone3		=	reqphone3 ;
   		this.callname		= 	callname ;
   		this.deptcode		=	deptcode ;
   		this.deptname		=	deptname ;
   		this.callurl		=	callurl ;
   		
   		
		//smsFieldData = new String[ smsFieldName.length ] ;
		urlFieldData = new String[ 25 ] ;
		setURLFieldData( urlFieldData ) ;		//SMS Packet �� �� �ʵ带 setting  �ϴ� �޼ҵ� 
		
		try 
		{
			sendSocket = Sconnect() ;		//Ŭ���̾�Ʈ�� ��Ĺ ��
		
			/********��Ʈ�� �� ***********************/
			bos = new BufferedOutputStream( sendSocket.getOutputStream() ) ;
			bis = new BufferedInputStream( sendSocket.getInputStream() ) ;
			dos = new DataOutputStream( bos ) ;
			
			urlFieldLength = new int[25] ;
			setURLFieldInfo( urlFieldLength ) ;	
		
		
			/****������ SMS request �� send....****/
			sendURLRequest( dos, urlFieldData ) ;	
			
			/****������ ���� ������ �޾ƿ� ********/
			smsResponse = reciveURLResponse( bis ) ;
			
		}
		catch( IOException e )
		{
			System.out.println( "sendURLMain() �κ� ���� : " + e ) ;
		}
		finally
		{
			try
			{
				if( dos != null )
						dos.close() ;
				if( bos != null ) 
						bos.close() ;
				if( bis != null )
						 bis.close() ;		
				if( sendSocket != null ) 
						sendSocket.close() ;
			}
			catch( Exception e ) 
			{
				System.out.println( "sendURLMain() �� ��Ʈ���� ���ϰ�ü �ݳ��κ� ���� : " + e ) ;
			}
		}
		return smsResponse;
	}
	
	//SMS Packet �� �ʵ��� Length�� Setting
	
	public void setURLFieldInfo( int[] urlFieldLength ) 
	{	
		urlFieldLength[0]  = 1 ;				 	//char
		urlFieldLength[1]  = 1 ;					//char
		urlFieldLength[2]  = 10 ;					//char[10]
		urlFieldLength[3]  = 8 ;					//char[8]
		urlFieldLength[4]  = 30 ;					//char[30]
		urlFieldLength[5]  = 16 ;					//char[16]
		urlFieldLength[6]  = 12 ;					//char[12]	
		urlFieldLength[7]  = 16 ;					//char[16]
		urlFieldLength[8]  = 1 ;					//char
		urlFieldLength[9]  = 4 ;					//char[4]
		urlFieldLength[10] = 4 ;					//char[4]
		urlFieldLength[11] = 4 ;					//char[4]
		urlFieldLength[12] = 80 ;					//char[80]
		urlFieldLength[13] = 62 ;					//char[62]
		urlFieldLength[14] = 10 ;					//char[10]
		urlFieldLength[15] = 8 ;					//char[8]
		urlFieldLength[16] = 4 ;					//char[4]
		urlFieldLength[17] = 4 ;					//char[4]
		urlFieldLength[18] = 4 ;					//char[4]	
		urlFieldLength[19] = 32 ;					//char[32]
		urlFieldLength[20]  = 1 ;					//char
		urlFieldLength[21] = 4 ;					//char[4]
		urlFieldLength[22] = 4 ;					//char[4]
		urlFieldLength[23] = 4 ;					//char[4]
		urlFieldLength[24] = 4 ;					//char[4]
	}      
	
		
	//SMS Packet�� �� �ʵ带 Setting
	public void setURLFieldData( String[] urlFieldData ) 
	{
		urlFieldData[0]  = "I" ;						//Command
		urlFieldData[1]  = "O" ;						//Type
		urlFieldData[2]  = rdate ;						//Date
		urlFieldData[3]  = rtime ;						//Time
		urlFieldData[4]  = usercode ;					//UserCode
		urlFieldData[5]  = username ;					//UserName
		urlFieldData[6]  = deptcode ;				    //DeptCode
		urlFieldData[7]  = deptname ;			     	//DeptName
		if (rdate.equals("00000000")){
			urlFieldData[8]  = "" ;						//Status
		}else{
			urlFieldData[8]  = "R" ;					//Status
		}
		
		//CallPhoneó�� '011-123-4567' --> '011', '123', 4567'�� �и�	
		urlFieldData[9]  = callphone1 ;					//CallPhone1 
		urlFieldData[10] = callphone2 ;					//CallPhone2
		urlFieldData[11] = callphone3 ;					//CallPhone3
		
		urlFieldData[12] = callmessage ;		    	//CallMessage
		urlFieldData[13] = callurl ;		  		  	//CallURL
		urlFieldData[14] = rdate ;						//Rdate
		urlFieldData[15] = rtime ;						//Rtime
		
		//ReqPhoneó�� '011-123-4567' --> '011', '123', 4567'�� �и�	
		urlFieldData[16] = reqphone1  ;					//reqphone1 
		urlFieldData[17] = reqphone2  ;					//reqphone2
		urlFieldData[18] = reqphone3  ;					//reqphone3
		urlFieldData[19] = callname  ;					//reqname
		urlFieldData[20] = "" ;							//Dummy
		urlFieldData[21] = member ;		        		//Ŭ���̾�Ʈ�� �Ϸ� ��ȣ
		
		urlFieldData[22] = "0" ;							//TotalPrice
		urlFieldData[23] = "0" ;							//CallPrice
		urlFieldData[24] = "0" ;							//reserved
	}	

		
	//SureM.COM������ URL  request �� send.....
	public void sendURLRequest( DataOutputStream dos, String[] urlFieldData ) throws IOException
	{
		
		StringBuffer strBuff = new StringBuffer() ;
		byte[] byteBuff = null ;
		
		try 
		{
			for( int inx = 0 ; inx < 21 ; inx++ ) {
				appendToBuffer( strBuff, urlFieldData[inx], urlFieldLength[inx] ) ;
				System.out.println( inx + " : " +  strBuff.toString().getBytes()  ) ;
			}	
				
			byteBuff = strBuff.toString().getBytes() ;
			dos.write( byteBuff, 0 , byteBuff.length ) ;
			strBuff.delete( 0, strBuff.length() ) ;

			for( int inx = 21 ; inx <= 24 ; inx++ ) {
				dos.writeInt( int2byte(Integer.parseInt( urlFieldData[inx] )) ) ;			
				System.out.println( inx + " : " +  urlFieldData[inx]  ) ;
			}			
//			byteBuff = strBuff.toString().getBytes() ;
//			dos.write( byteBuff, 0 , byteBuff.length ) ;
			dos.flush() ;
		} 
		catch( IOException e ) 
		{
			throw e ;
		}
	}			
			
	//SureM.COM ������ ���� SMS response�� receive...
	public String reciveURLResponse( BufferedInputStream bis )
	{
		byte[] byteBuff = new byte[1024] ;
		String strReceivedMsg = null ;
		
		try 
		{
			int iReadCount = bis.read( byteBuff ) ;
			if( iReadCount > 0 ) {
				//	strReceivedMsg = new String( byteBuff, 0 , iReadCount ) ;
				status = new String(byteBuff,94,1);
				writeFile("command=["+ urlFieldData [0] +"]	usercode=["+ urlFieldData [4] +"]	username=["+ urlFieldData [5] +"]	callphone1=["+ urlFieldData [9] +"]	callphone2=["+ urlFieldData [10] +"]	callphone3=["+ urlFieldData [11] +"]	callmessage=["+ urlFieldData [12] +"]	callurl=["+ urlFieldData[13] +"]	rdate=["+ urlFieldData [14] +"]	rtime=["+ urlFieldData [15] +"]	reqphone1=["+ urlFieldData [16] +"]	reqphone2=["+ urlFieldData [17] +"]	reqphone3=["+ urlFieldData [19] +"]	status=["+ status +"]\n");
			}
		}
		catch( IOException e ) 
		{
			System.out.println( "������ ���� ������ �޾ƿ��µ� ���� : " + e ) ;
		}
		
		return status ;
	}

}			 						
			
		
							
							
			
