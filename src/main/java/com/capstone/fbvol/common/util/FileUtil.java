/*
 * @(#)FileUtil.java	1.00 2002/11/05<p>
 *
 * Copyleft 2001-2002  All Rights Reserved.<p>
 * 
 * This software is the proprietary information of choi eui youb  
 * Use is subject to license terms.<p>
 * 
 * Written By: choi eui youb ^^<p>
 *
 */
/*******************************************************************************
 * Module Title  : 공통모듈<p>
 * Module Content: 파일을 컨트롤 한다.<p>
******************************************************************************/
package com.capstone.fbvol.common.util;


import java.io.File;

public class FileUtil
{

    public FileUtil()
    {
    }

    

    /****************************************************************
    * 파일을 리턴한다.<p>
    *@ param path 파일패스<p>
    *@ param fname 파일이름<p>
    *@ return f : 파일 , null : 파일 없음<p>
    ****************************************************************/
    public File getFile(String path,String fname)
    {
        try
        {
            if (existFile(path,fname))
            {
                File f = new File(path,fname);

                return f;
            }
            else 
            {
                return null;
            }
        }
        catch(Exception e)
        {
            return null;
        }
    }

    /****************************************************************
    * 디렉토리가 있는지 확인한다.<p>
    *@ param path 파일패스<p>
    *@ return true:디렉토리 있음, false:디렉토리없음<p>
    ****************************************************************/
    public boolean existDirectory(String path)
    {
        boolean i = false;

        try
        {
            File f = new File(path);
            i = f.exists();
        }
        catch(Exception e)
        {
            i = false;
        }
        return i;
	   }
	
    /****************************************************************
    * 파일이 존재하는지 확인한다.<p>
    *@ param path 파일패스<p>
    *@ param filename 파일이름<p>
    *@ return true:파일존재,false:파일없음<p>
    ****************************************************************/
    public boolean existFile(String path, String filename)
    {
        boolean i =false;
       
        try
        {
            File f = new File(path, filename);
            i = f.exists();
        }
        catch(Exception e)
        {
            i = false;
        }
        return i;
    }
	
    /****************************************************************
    * 디렉토리를 생성한다.<p>
    *@ param path 파일패스<p>
    *@ return true:성공,false:실패<p>
    ****************************************************************/
    public boolean createDirectory(String path)
    {
        boolean i = false;

        try
        {
            File f = new File(path);
      	    i = f.mkdir();
        }
        catch(Exception e)
        {
            i =false;
        }
        return i;
    }

    /****************************************************************
    * 파일을 삭제한다.<p>
    *@ param path 파일패스<p>
    *@ param name 파일이름<p>
    *@ return i 파일 삭제 성공여부를 리턴한다.<p>
    ****************************************************************/
    public boolean delFile(String path,String name)
    {
        boolean i = false; 
        try
        {
            File f = new File(path+name);

            if(existFile(path,name))
            {
                f.delete();
                i = true;
            }
        }
        catch(Exception e)
        {
            i = false;
        }
        return i;
    }

    /****************************************************************
    * 디렉토리를 삭제한다.<p>
    *@ param path 파일패스<p>
    *@ param <p>
    *@ return i 디렉토리 삭제 성공여부 리턴<p>
    ****************************************************************/
    public boolean delDirectory(String path)
    {
        boolean i = false;
        try
        {
        	File f = new File(path);

            if(existDirectory(path))
            {
                f.delete();
                i = true;
            }
        }
        catch(Exception e)
        {
            i = false;
        }
        return i;
    }

    /****************************************************************
    * 파일크기를 리턴한다.<p>
    *@ param path 파일패스<p>
    *@ param name 파일이름<p>
    *@ return 파일사이즈<p>
    ****************************************************************/
    public long getFileSize(String path,String name)
    {
         long i=0;
         if(name.equals("") || name == null || name.toUpperCase().equals("NULL")) return 0;

         try
         {
             File f = new File(path+name);

             if(existFile(path,name))
             {
                 i = f.length();
             }
             else
             {
                 i = 0;
             }      
         }
         catch(Exception e)
         {
             i = 0;
         }

         return i;
    }

    /****************************************************************
    * 파일이름을 리턴한다.<p>
    *@ param file 파일<p>
    *@ return 파일이름<p>
    ****************************************************************/
    public String getFileName(File file)
    {
         String FName = "";
         try
         {
             if(file == null) return "";

             if(file.exists())
             {
                 FName = file.getName();
             }
             else
             {
                 FName= "";
             }
         }
         catch(Exception e)
         {
             FName = "";
         }      
         return FName;
    }
}
