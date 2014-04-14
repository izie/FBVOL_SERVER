package com.capstone.fbvol.common.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropsUtil{
	private Properties props;

	public PropsUtil(){}
	public PropsUtil(Properties props){
		this.props = props;
	}

	//���� �о����
	public boolean readProps(String path, String fileName) throws Exception { 
     
		Properties props1 = new Properties(); 
		File file = new File(path, fileName); 
		FileInputStream is = null;

		try { 
			is = new FileInputStream(file); 
			props1.load(is); 
		}catch(Exception e){ 
			return false; 
		}finally{
			is.close(); 
		}
        
		this.props = props1;

		return true; 
	}
	

	//�� �Է�
	public boolean setValue(String key, String value){
		
		if(props == null){
			return false;
		}

		try{ 
			props.setProperty(key, value);
		}catch(Exception e){
		    return false;
		}
		
		return true;
	}
	

	//�� ��������
	public String getValue(String key){
		return props.getProperty(key);
	}

	
	// ����
	public synchronized boolean saveProps(String path, String fileName) throws Exception {

		File file = new File(path, fileName);
		FileOutputStream os = null;		
		try{
			os = new FileOutputStream(file);
			props.store(os, null);
		}catch(Exception e){
			return false;
		}finally{
			os.close();
		}

		return true;
	}

}
