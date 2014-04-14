package com.capstone.fbvol.common.util;


import com.capstone.fbvol.common.util.text.StringUtil;
import com.capstone.fbvol.model.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 -- ---------- ---------------------------------------------------------
 -- PGM �̸� : EntityToXmlUtil
 -- PGM ���� : Entity��ü���� XML�� String���� ��ȯ �ϴ� ��ü�� ��
 -- ---------- ---------------------------------------------------------
 -- PGM �̷� : ��������   ������   ���泻��
 -- ---------- ---------- -------- -------------------------------------
               2009.07.14 ���   ����
               2008.04.10 ���ع�   ����
  -- ---------- ---------- -------- -------------------------------------
*/
public class EntityToXmlUtil extends HashMap implements Serializable {

	private static final long serialVersionUID = 1L;
	private Entity vo = null;
	private List<Entity> dataList =null;
	public EntityToXmlUtil(){}

	public EntityToXmlUtil(Entity _vo)   {
		this.vo = _vo ;
	}

	public EntityToXmlUtil(List<Entity> _dataList)  {
		 this.dataList = _dataList;
	}
	 public String parseXml()   {
		 String sRet="";
		 StringBuilder sb = new StringBuilder(); 
		 String key = "";
	    String val = "";
		 // Entity ��ü ���ν�
		  if(this.vo !=null)
		  {
			  sb.append("<TABLE> \r\n");
			  sb.append("<RECORD id=\"1\"> \r\n");
			  Iterator it = vo.keySet().iterator(); 
		    	 
		    	while(it.hasNext()) {
		    		key = it.next().toString();
		    		val = StringUtil.nvl(vo.get(key), "");
		    	 	sb.append("<"+key+">"+val+"</"+key+"> \r\n");
		    		 
		    	}
			  sb.append("</RECORD> \r\n");
			  sb.append("</TABLE> \r\n");
			  
		  }
		 
		   // Entity ��ü ����Ʈ  ���ν�
		  if(dataList !=null)
		  {
			  if(dataList .size()>0)
			  {
				  int i=0;
			  sb.append("<TABLE> \r\n");
				for( Entity eVo : dataList)
				{
					i++;
					sb.append("<RECORD id=\""+(String.valueOf(i))+"\"> \r\n");
					Iterator it = eVo.keySet().iterator();  
			    	while(it.hasNext()) {
	 		    		key = it.next().toString();
			    		val = StringUtil.nvl(eVo.get(key), "");
			    		// <> </>
			    		sb.append("<"+key+">"+val+"</"+key+"> \r\n");
			    		//System.out.println(key + " : " + val);
	 		    		//setValue(key, val);
			    	}
			    	sb.append("</RECORD> \r\n");
	 			}
			  sb.append("</TABLE> \r\n");
			  }
		  }
		 return sb.toString();
	 }
	 public static void main(String[] args) {
		  List<Entity> lst = new ArrayList<Entity>();
		  Entity vo = new Entity();
		   vo.setValue("ONE", "1");
		   String snull ="";
		   vo.setValue("TWO",snull);
		   vo.setValue("THE", "3");
		   vo.setValue("FOR", "4");
		   vo.setValue("FIV", "5");
		   
		   EntityToXmlUtil ftx = new EntityToXmlUtil(vo);
		   System.out.println(ftx.parseXml());
		   lst.add(vo);
		   lst.add(vo);
		   lst.add(vo);
		   lst.add(vo);
		   lst.add(vo);
		   Entity vo1 = new Entity();
		   vo1.setValue("ONE", "1"); 
		   vo1.setValue("TWO","2");
		   vo1.setValue("THE", "3");
		   vo1.setValue("FOR", "4");
		   vo1.setValue("FIV", "5");
		   lst.add(vo1);
		   EntityToXmlUtil ftx2 = new EntityToXmlUtil(lst);
		   System.out.println(ftx2.parseXml());
	 }
}
