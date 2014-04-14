package com.capstone.fbvol.common.util;


public class Per{

	public static int ipCheck(javax.servlet.http.HttpServletRequest request){
		try{
			//���� ������
			PropsUtil pu = new PropsUtil();
			String saveDir = request.getRealPath("/WEB-INF/classes/dbmanager");
			pu.readProps(saveDir, "cominfo.properties");
			String serverIp = pu.getValue("serverIp");
			//System.out.println("serverIp::"+serverIp);

			String clientIp = request.getRemoteAddr();
			String clientIpCut = clientIp.substring(0,clientIp.lastIndexOf("."));
			
			//System.out.println(clientIpCut);
			//System.out.println(serverIp.indexOf(clientIpCut));
			if( serverIp.indexOf(clientIpCut)<0 ){
				return 103;//"�ܺ����ӺҰ�";
				//return 1;	//���߿� �����
			}
			return 1;
		}catch(Exception e){
			System.out.print(e.toString());
			return 103;
		}
	}

}
