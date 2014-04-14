/*
 * @(#)AttachFileUtil.java	1.00 2002/11/05
 *
 * Copyleft 2001-2002 choi eui youb. All Rights Reserved.
 * 
 * This software is the proprietary information of choi eui youb  
 * Use is subject to license terms.
 * 
 * Written By: choi eui youb
 *
 */

/*******************************************************************************
 * Module Title  : 공통모듈<p>
 * Module Content: 파일을 이동시킨다.<p>
 * .listFiles()은 파일/디렉토리 구분없이 생성된 순서대로 소트시킨다. 따라서
 * 파일과 디렉토리를 이동/복사 할때 처리를 잘해줘야지 원본 디렉토리 구조와 
 * 다르게 복사/이동 될수 있다.<p>
 * 사용예<p>
 * 일반적으로 1)번을 호출하면 1)번이 2)번을 호출하여 작업한다.<p>
 * ******************파일저장********************<p>
 *(원본파일디렉토리,저장될원본파일명,목적지디렉토리,복사/이동여부)
 * 1) writeFile("d:\\test\\","test.txt","d:\\test\\test1\\","cp");<p>
 *(파일객체,파일이저장될목적지디렉토리,복사/이동여부)
 * 2) writeFile(file,"d:\\test\\test1\\","cp");<p>
 * **************디렉토리이동/복사****************<p>
 * (이동/복사할 원본 디렉토리패스, 목적지 디렉토리패스,복사/이동여부)<p>
 * 1) moveDir(String oldPath, String newPath, String cp)<p>
 * (디렉토리-파일객체 목록,목적지 디렉토리,원본 root디렉토리명,복사/이동여부)<p>
 *  c:\test1포함하여 하위의 디렉토리를 d:\temp 의 하위로 복사/이동 한다면<p>
 * target은 d:\temp\test1이 되며, root는 test1이 된다.<p>
 * 2) public void mvDir(File fl[],String target,String root,String cp)<p>
 * ****************디렉토리 삭제*****************<p>
 * (삭제할 디렉토리 패스)<p>
 * 1) delDir(String path)<p>
 * (삭제할 디렉토리 객체 배열)
 * 2) delDir(File fl[])<p>
 * *************디렉토리내 파일들을 지정 디렉토리로 이동/복사 **************<p>
 원본디렉토리(d:\\xxx\zzz\),목적지디렉토리(d:\\xxx\yyy\),이동("mv")/복사("cp")
 copyDir(String oldPath, String newPath, String cp)
******************************************************************************/

package com.capstone.fbvol.common.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class AttachFileUtil
{
	public AttachFileUtil()
   	{
        fileName = "";
        ismove =true;
   	}

    FileUtil fu = new FileUtil();

    private String fileName;
    private boolean ismove = false;

    
   	/****************************************************************
   	* 파일 하나를 저장한다.<p>
   	*@ param  oldPath 기존 파일패스<p>
   	*@ param  fname 기존 파일명<p>
   	*@ param  path 파일이 새로 저장될 패스<p>
   	*@ param  cp cp : 카피 , mv:이동<p>
   	*@ return 파일이름<p>
   	****************************************************************/
	public String writeFile(String oldPath,String fname,String path,String cp)
    {
        File file;
        try
        {
            if(fname.length() < 1) return "";

            if(fu.existFile(oldPath,fname))
            {
                fileName = fname;
                file = new File(oldPath,fname);

                writeFile(file,path,cp);
            }
            else
            {
                fileName = "";
            }
        }
        catch(Exception e)
        {
        }

        return fileName;
    }

    /****************************************************************
    * 파일 하나를 저장한다.<p>
    *@ param  file 기존 파일<p>
    *@ param  path 파일이 새로 저장될 패스<p>
   	*@ param  cp cp : 카피 , mv:이동<p>
    *@ return 파일이름<p>
    ****************************************************************/
	public String writeFile(File file,String path,String cp)
    {

        try
        {
             if(file == null) return "";

             fileName = fu.getFileName(file);

             if(cp.equals("mv"))
             {
                 moveFile(file,path);
             }
             else
             {
                 copyFile(file,path,cp);
             }
        }
        catch(Exception e)
        {

        }
        return fileName;
    }


   /****************************************************************
    * 디렉토리를 삭제한다.<p>
   	*@ param path 현재 파일패스<p>
    *@ param <p>
   	*@ param <p>
   	*@ return <p>
	****************************************************************/   
    public boolean delDir(String path)
    {
        String newDirectory = "";
        int i = 0;
        try
        {
            if(fu.existDirectory(path))
            {
                //지울 디렉토리 객체를 생성한다.
                File f = new File(path);
                
                //디렉토리 삭제 작업을 시작한다.
                delDir(f.listFiles());
                
                //최종적으로 루트 디렉토리를 지운다.
                if(ismove)
                {
                    ismove = f.delete();
                }
            }
        }
        catch(Exception e)
        {
            ismove = false;
        }
        return ismove;
    }

    /****************************************************************
    * 디렉토리 삭제 시킨다.<p>
   	*@ param fl[] 파일과 디렉토리 목록<p>
    *@ param <p>
    *@ param <p>
   	*@ param <p>
   	*@ return <p>
	****************************************************************/   
    public void delDir(File fl[]) throws Exception
    {
        String currentName = "";
        String newp = "";
        int idx = 0;
        try
        {
            for(int j=0; ismove && j < fl.length; j++)
            {
                if(fl[j].isDirectory())
                {
                    //자신을 다시 호출한다.
                    delDir(fl[j].listFiles());
                    //디렉토리를 지운다.
                    ismove = fl[j].delete();                
                }
                else
                { 
                    //파일을 지운다.
                    ismove = fl[j].delete();
                }
                
            }
            ismove = true;
            
        }
        catch(Exception e)
        {
            ismove =false;
        }
    }


    /****************************************************************
    * 디렉토리 이동/복사시킨다(지정한 패스가 루트 패스가 된다).<p>
   	*@ param oldPath 현재 파일패스<p>
    *@ param newPath 이동할 파일패스<p>
   	*@ param  cp- cp:카피 , mv:이동<p>
   	*@ return ismove: true:작업성공, false:작업실패<p>
	****************************************************************/   
    public boolean moveDir(String oldPath, String newPath, String cp)
    {
        String newDirectory = "";
        int i = 0;
        try
        {
            if(fu.existDirectory(oldPath))
            {
                i = oldPath.lastIndexOf(File.separator);
                //복사/이동할 루트 디렉토리명을 찾는다.
                newDirectory = oldPath.substring(i+1);

                //원본 디렉토리 객체를 생성한다.
                File oldFile = new File(oldPath);
                //파일패스 뒤에 separator가 있는지 확인한다.
                newPath = chkSeparator(newPath);
                newPath = newPath + newDirectory; 

                //목적지에 루트디렉토리를 만든다.
                fu.createDirectory(newPath);
                //복사/이동 작업을 시작한다.
                mvDir(oldFile.listFiles(),newPath,newDirectory,cp);

                //이동이면 최종적으로 원본 루트 디렉토리는 지운다.
                if(cp.equals("mv"))
                {
                    fu.delDirectory(oldPath);
                }
            }
        }
        catch(Exception e)
        {
            ismove = false;
        }
        return ismove;
    }

    /****************************************************************
    * 디렉토리 이동/복사 시킨다.<p>
   	*@ param fl[] 파일과 디렉토리 목록<p>
    *@ param target 이동할 위치의 root패스<p>
    *@ param root 원본 폴더의 최상위 디렉토리<p>
   	*@ param  cp- cp:카피 , mv:이동<p>
   	*@ return <p>
	****************************************************************/   
    public void mvDir(File fl[],String target,String root,String cp)
    {
        String currentName = "";
        String newp = "";
        int idx = 0;
        try
        {
            for(int j=0; j < fl.length; j++)
            {
                if(fl[j].isDirectory())
                {
                    //원본 디렉토리명을 구한다.
                    currentName = fl[j].getAbsolutePath();
                    idx = currentName.indexOf(root);
                    currentName = currentName.substring(idx+root.length()+1);

                    //새 디렉토리패스를 만든다
                    //파일패스 뒤에 separator가 있는지 확인한다.
                    target = chkSeparator(target);
                    newp = target + currentName; 
                    //새 디렉토리를 생성한다.
                    ismove = fu.createDirectory(newp);

                    //자신을 다시 호출한다.
                    mvDir(fl[j].listFiles(),target,root,cp);
                    //이동일때 디렉토리를 지운다.
                    if(cp.equals("mv"))
                    {
                        fl[j].delete();
                    }
                }
                else
                {
                    //복사할 파일명을 구한다.
                    fileName = fl[j].getName();
                    //파일이 복사될 패스를 찾는다.
                    idx =  fl[j].getAbsolutePath().indexOf(root);
                    String temppath = fl[j].getAbsolutePath().substring(idx+root.length(),fl[j].getAbsolutePath().length()-(fileName.length()+1));
                    
                    //파일을 복사하는 메서드 호출
                    //target은 복사될 목적지 root이며 여기에 temppath붙이면 파일
                    //이 복사될 위치가 된다.
                    if(cp.equals("cp"))
                    {
                        //파일 복사
                        copyFile(fl[j],target + temppath,cp);
                    }
                    else
                    {
                        //파일 이동
                        moveFile(fl[j],target + temppath);
                    }
                }
                
            }
            ismove = true;
        }
        catch(Exception e)
        {
            ismove =false;
        }
    }


    /****************************************************************
    * 디렉토리 내의 파일들을 지정한 디렉토리로 이동/복사시킨다.<p>
   	*@ param oldPath 현재 파일패스(d:\\xxx\zzz\)<p>
    *@ param newPath 이동할 파일패스(d:\\xxx\yyy\)<p>
   	*@ param  cp- cp:카피 , mv:이동<p>
   	*@ return ismove: true:작업성공, false:작업실패<p>
	****************************************************************/   
    public boolean copyDir(String oldPath, String newPath, String cp)
    {
        boolean ismove = true;
        int i = 0;

        try
        {

            if(fu.existDirectory(oldPath))
            {
                //원본 디렉토리 객체를 생성한다.
                File oldFile = new File(oldPath);

                //원본 디렉토리에서 파일 리스트를 가져온다.
                File f2[] = oldFile.listFiles();

                //목적지에 디렉토리를 만든다.
                fu.createDirectory(newPath);

                if(f2 != null && f2.length > 0)
                {
                    for(int j=0; j < f2.length; j++)
                    {
                        
                        //파일의 갯수만큼 파일을 복사한다.
                        copyFile(f2[j],newPath,cp);
                    }
                }
            }
        }
        catch(Exception e)
        {
            ismove = false;
        }
        return ismove;
    }

    /****************************************************************
    * 첨부파일을 이동시킨다.<p>
   	*@ param file 파일<p>
    *@ param path 파일이 저장될 패스<p>
   	*@ return <p>
	****************************************************************/    
    public void moveFile(File file,String path) throws Exception
    {
        String fileName2 = "";
        try
        {
            //파일패스 뒤에 separator가 있는지 확인한다.
            path = chkSeparator(path);

            //복사할 곳에 디렉토리가 있는지 확인한다.
       		if(!fu.existDirectory(path))
        	{
			    //디렉토리가 없으면 만든다.
                fu.createDirectory(path);
        	}

            if(fu.existFile(path,fileName)) 
            {
                 //파일을 복사하려는 곳에 같은 이름의 파일이 있으면 새로 만든다.
                 fileName2 = makeFileName(path,fileName);
              
                while(fu.existFile(path,fileName2))
                {
                     //파일 이름이 겹치면 계속해서 새 이름을 만든다.
                     fileName2 = makeFileName(path,fileName2);
                }
            }
            else
            {
                 fileName2 = fileName;    
            }

            File file2 = new File(path,fileName2);

            file.renameTo(file2);  //파일을 이동시킨다.

        }
        catch(Exception e)
        {

        }
    }

    /****************************************************************
    * 첨부파일을 복사시킨다.<p>
   	*@ param file 파일<p>
    *@ param path 파일이 저장될 패스<p>
   	*@ param  cp cp : 카피 , mv:이동<p>
   	*@ return <p>
	****************************************************************/
   	public void copyFile(File file,String path,String cp)
   	{
        boolean imsi = true;
  		String fileName2 = "";

      	try 
        {
       	    //한글 파일의 경우 아래와 같이 해야 한글이 깨지지 않는다.
            //fileName = new String(di.getOldFileName().getBytes("euc-kr"),"8859_1");
            fileName = file.getName();

            //파일패스 뒤에 separator가 있는지 확인한다.
            path = chkSeparator(path);
            
            //파일이 들어갈 배열의 선언과 크기 설정
            /*
            byte[] bytestream = new byte[(int)file.length()];

            FileInputStream filestream = new FileInputStream(file);

    	    int i = 0, j = 0;

            while((i = filestream.read()) != -1) 
            {
                bytestream[j] = (byte)i;
                j++;
            }
            */


            //복사할 곳에 디렉토리가 있는지 확인한다.
       		if(!fu.existDirectory(path))
        	{
			    //디렉토리가 없으면 만든다.
                fu.createDirectory(path);
        	}

            if(fu.existFile(path,fileName)) 
            {
                fileName2 = makeFileName(path,fileName);
                while(fu.existFile(path,fileName2))
                {
                     //파일 이름이 겹치면 계속해서 새 이름을 만든다.
                     fileName2 = makeFileName(path,fileName2);
                }
            }
            else
            {
                 fileName2 = fileName;    
            }

		    //복사될 파일 객체를 만든다.
         	//File file2 = new File(path +fileName);

         	FileInputStream filestream = new FileInputStream(file);
            FileOutputStream outStream = new FileOutputStream(path + fileName2);

            byte [] b = new byte[1024];
            int numRead = filestream.read(b);
            
            while(numRead  != -1 ){
                outStream.write(b, 0, numRead);
                numRead = filestream.read(b);
            }
            
            outStream.flush();
            outStream.close();
            if(filestream != null) filestream.close(); 

            //출력 스트림을 선언한다.
            /*
            FileOutputStream outStream = new FileOutputStream(path + fileName2);

            //내용을 출력한다.
            outStream.write(bytestream);

            //출력스트림을 닫는다.
            outStream.close();
            bytestream = null;
            if(filestream != null) filestream.close();
            */

            //이동일경우 기존의 파일을 삭제한다.
            if(cp.equals("mv"))
            {
                file.delete();
            }
        }
        catch(Exception e)
        {
        }
       	finally 
        {
	    }
    }

    /****************************************************************
    * 해당 디렉토리에 같은 이름이 있을경우 파일 이름을 바꾸는 메서드.<p>
    * 파일명의 뒤에 _002에서 _999 까지를 붙인다.<p>
   	*@ param fname 원본파일이름<p>
    *@ param <p>
   	*@ return newName 고쳐진 파일이름<p>
	****************************************************************/
   	public String makeFileName(String path,String fname)
   	{
        String newName = "";
        String tt = "000";
        int i = 0;
        int j = 0;

        try
        {

            i = fname.lastIndexOf("_");
            j = fname.lastIndexOf(".");

            if(fname.lastIndexOf("_") < 0)
            {
                //최초에는 001을 붙여준다.
                newName = fname.substring(0,j) + "_002" + fname.substring(j);
            }
            else
            {
                //버젼 숫자를 잘라낸다.
                int k = Integer.parseInt(fname.substring(i+1,j));
                k += 1;  //버젼 숫자에 1을 더한다.
                tt = tt + Integer.toString(k); 
                //자리수를 맞춰서 버젼을 만든다.
                tt = "_" +tt.substring(tt.length()-3);  

                //새 파일 이름을 만든다.
                newName = fname.substring(0,i) + tt + fname.substring(j);
            }

        }
        catch(Exception e)
        {
            try
            {
                //새 파일 이름을 만든다.
                newName = fname.substring(0,j) + "_002" + fname.substring(j);
            }
            catch(Exception ee)
            {
                newName = fname;
            }

            
        }
        return newName;
    }

    /****************************************************************
    * 파일 패스 뒤에 \ 혹은 / 이 없으면 붙여주는 메서드<p>
   	*@ param path 파일패스<p>
    *@ param <p>
   	*@ return tempp 고쳐진 파일 패스<p>
	****************************************************************/
    public String chkSeparator(String path)
    {
        String tempp = "";
        try
        {
            tempp = path;
            if(!tempp.substring(tempp.length()-1,tempp.length()).equals(File.separator))
            {
                tempp = tempp + File.separator;
            }
        }
        catch(Exception e)
        {

        }
        return tempp;
    }
}
