package kr.mentalcare.project.util;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	 
    private FileOutputStream fos;
    public static String filePath="d:\\upload\\sw_work";
    public void writeFile(MultipartFile file, String path, String fileName){
         
        try{
         
            byte fileData[] = file.getBytes();
             
            fos = new FileOutputStream(path + "\\" + fileName);
             
            fos.write(fileData);
            
        }catch(Exception e){
             
            e.printStackTrace();
             
        }finally{
             
            if(fos != null){
                 
                try{
                    fos.close();
                }catch(Exception e){}
                 
                }
        }// try end;
         
    }// wirteFile() end;
    
    public static boolean deleteFile(String fileName){
    	File f=new File(filePath+"\\"+fileName);
    	return f.delete();
    }
}