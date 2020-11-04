package com.gisarmory.common.utils;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 文件处理帮助类
 * @author 
 *
 */
public class FileToolsUtil {

	// 验证字符串是否为正确路径名的正则表达式   
	@SuppressWarnings("unused")
	private static String matches = "[A-Za-z]:\\\\[^:?\"><*]*";   
	// 通过 sPath.matches(matches) 方法的返回值判断是否正确   
	// sPath 为路径字符串 
    /**
     *  根据路径删除指定的目录或文件，无论存在与否
     *@param sPath  要删除的目录或文件
     *@return 删除成功返回 true，否则返回 false。
     */
	private boolean flag;
	private File file;
	public static String ROOT;//file项目配置
	public static String TMPPATH;// 临时文件路径
	static{
		
	}
    /**
     *  根据路径删除指定的目录或文件，无论存在与否
     *@param sPath  要删除的目录或文件
     *@return 删除成功返回 true，否则返回 false。
     */
    public boolean DeleteFolder(String sPath) {
        flag = false;
        file = new File(sPath);
        // 判断目录或文件是否存在
        if (!file.exists()) {  // 不存在返回 false
            return flag;
        } else {
            // 判断是否为文件
            if (file.isFile()) {  // 为文件时调用删除文件方法
                return deleteFile(sPath);
            } else {  // 为目录时调用删除目录方法
                return deleteDirectory(sPath);
            }
        }
    }
    
    public static boolean copyFile(String fromPath,String toPath) throws IOException {
       
    	File file = new File(fromPath);
        File tofile = new File(toPath);
        // 判断目录或文件是否存在
//        if (file.exists() && file.isFile()) {  // 不存在返回 false
//        	
//        	if(!tofile.getParentFile().exists()){
//        		tofile.getParentFile().mkdirs();
//        	}
//        	if (!tofile.exists()){
//        		tofile.createNewFile();
//        	}
//        	
//        	copyFile(file,tofile);
//         	return true;
//        }
        
        
        if(!file.exists() || !file.isFile()){// 判断被拷贝的目录或文件是否存在
        	System.out.println("被拷贝的目录或文件不存在："+file.getPath());
        	return false;
        }
        if(!tofile.getParentFile().exists()){
        	tofile.getParentFile().mkdirs();
        }
        if (!tofile.exists()){
    		tofile.createNewFile();
    	}
        
        copyFile(file,tofile);
        return true;
    }
 // 复制文件
    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[1024];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
            b = null;
        } finally {
            // 关闭流
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }
    
    


    /**
     * 删除单个文件
     * @param   sPath    被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public boolean deleteFile(String sPath) {
        flag = false;
        file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }
    public static List<File> getDirectoryFiles(String sPath){
    	File file = new File(sPath);
    	File[] files = file.listFiles();
    	List<File> flist = new ArrayList<File>();
    	for (int i = 0; i < files.length; i++) {
    	  if(!files[i].isDirectory()){
    		  flist.add(files[i]);
    	  }
    	}
    	return flist;
    }
    /**
     * 删除目录（文件夹）以及目录下的文件
     * @param   sPath 被删除目录的文件路径
     * @return  目录删除成功返回true，否则返回false
     */
    public boolean deleteDirectory(String sPath) {
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        //如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        flag = true;
        //删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            //删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag) break;
            } //删除子目录
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag) break;
            }
        }
        if (!flag) return false;
        //删除当前目录
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static String getRootPath(){
    	URL resource = FileToolsUtil.class.getResource("/");
//    	resource.getPath();
//    	System.out.println(resource.getPath()); 
    	try {
			System.out.println(getPathFromClass(FileToolsUtil.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return resource.getPath();
    }
    /**
    * 获取路径
    * @author liujunliang
    * @creaetime Jul 2, 2011 9:55:25 AM
    * @param cls 类位置
    * @return String 返回值
    * @throws IOException 异常
    */
    @SuppressWarnings("unchecked")
	public static String getPathFromClass(Class cls) throws Exception {
      String path = null;
      if (cls == null) {
          throw new NullPointerException();
      }
      URL url = getClassLocationURL(cls);
      if (url != null) {
       path = url.getPath();
       path = java.net.URLDecoder.decode(url.getPath(), "utf-8");
       File file = new File(path.replaceAll("%20", " "));
       path = file.getCanonicalPath();
      }
      return path;
    }

    /**
    * 获取类的class文件位置的URL。这个方法是本类最基础的方法，供其它方法调用。
    * @author liujunliang
    * @creaetime Jul 2, 2011 9:59:39 AM
    * @param cls 类位置
    * @return URL 返回值
    */
    @SuppressWarnings("unchecked")
	private static URL getClassLocationURL(final Class cls) throws Exception{
       if (cls == null) {
         throw new IllegalArgumentException("class that input is null");
        }
        URL result = null;
        final String clsAsResource = cls.getName().replace('.', '/')
    .concat(".class");
       
        final ProtectionDomain pd = cls.getProtectionDomain();

        if (pd != null) {
          final CodeSource cs = pd.getCodeSource();
          if (cs != null) {
    result = cs.getLocation();

          }
        }

        if (result == null) {
         final ClassLoader clsLoader = cls.getClassLoader();
         result = clsLoader != null ? clsLoader.getResource(clsAsResource)
    : ClassLoader.getSystemResource(clsAsResource);
         }
         return result;
    } 
    
    public static String getWebRootPath(){
    	try {
			return FileToolsUtil.ROOT;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
    }
    
    public static void uploadFile(InputStream in,String fileName,String toDir) throws Exception{   
    	uploadFile( in, fileName,new File(toDir));
    }
    
	public static void uploadFile(InputStream in,String fileName,File toDir) throws Exception{   
	    
		FileOutputStream fs = null;
		
		try{
			
			if (!toDir.exists()) {
				toDir.mkdirs();
			}
			String topath= toDir.getPath()+File.separator+fileName;
			
			fs = new FileOutputStream(topath);   
			byte[] buffer = new byte[1024];   
//			int bytesum = 0;   
			int byteread = 0;   
			
			while ((byteread = in.read(buffer)) != -1) {   
//				bytesum += byteread;   
				fs.write(buffer, 0, byteread);   
				
			}   
			fs.flush();
			buffer = null;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			if(fs !=null ){
				fs.close();
				fs = null;
			}
			if(in !=null ){
				in.close();
				in = null;
			}
		}
	}
	
    
    /**
     * 文件转换成字节流
     * @param sourceFile
     * @return
     * @throws IOException
     */
    public static byte[] file2Byte(File sourceFile) throws IOException {
    	
    	 FileInputStream fis = null;
    	 ByteArrayOutputStream bos = null;
    	 
         try {  
            
             fis = new FileInputStream(sourceFile);  
             bos = new ByteArrayOutputStream(1000);  
             byte[] b = new byte[1000];  
             int n;  
             while ((n = fis.read(b)) != -1) {  
                 bos.write(b, 0, n);  
             }  

             return bos.toByteArray();  
             
         }finally {
             // 关闭流
             if (fis != null)
            	 fis.close();
             
             if (bos != null)
            	 bos.close();
         }  
     }  

	/**
	 * 创建文件，并写入内容
	 */
	public static boolean createParentFolder(String filePath) {
        try{
        	File file=new File(filePath);
        	File fileParentPath = file.getParentFile();
        	if(!fileParentPath.exists()){
        		boolean isok = fileParentPath.mkdirs();
        		if(isok == false){
        			String parentPath = fileParentPath.getParentFile().getPath();
        			createParentFolder(parentPath);
        		}else{
        			return true;
        		}
        	}
        }catch(Exception e){
        	e.printStackTrace();
        	return false;
        }
        return true;
    }

    
    public static void main(String[] args) throws Exception {
//    	FileToolsUtil.getRootPath();
    }
}
