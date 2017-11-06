/**
 *@Copyright:Copyright (c) 2015
 *@Company:SHUTO
 */
package org.shoukaiseki.jfinal.kernel.utils;

import com.alibaba.druid.util.StringUtils;
import com.jfinal.kit.PathKit;
import com.jfinal.log.Log;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/** org.shoukaiseki.jfinal.kernel.utils.FileUtils
 * <br>
 *  读取文件的公用类
 * <br>
 * @author 蒋カイセキ    Japan-Tokyo  2017年3月26日
 * <br>
 * ブログ http://shoukaiseki.blog.163.com/
 * <br>
 * E-メール jiang28555@Gmail.com
 */
public class FileUtils {

	static int classcount=0;

    /**
    * @deprecated
	**/
	protected static final Logger log = Logger.getLogger(FileUtils.class);
	
	/**文字列にファイルを読み込む
	 * @param fileName	ファイル名
	 * @param codeName	コーディング
	 * @return
	 */
	public static String readFileToString(String fileName, String codeName) {
		String content = "";
		try {
			FileInputStream in = new FileInputStream(fileName);

			byte[] bytes = new byte[in.available()];
			while ((in.read(bytes)) != -1)
				;

			content = new String(bytes, codeName).replaceAll("\r", "");// 按照文件编码格式进行转换为系统编码
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return content;
	}

	public static ByteArrayOutputStream readFileToByteArrayOutputStream(String filename){
		File file=new File(filename);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = null;  
		try {  
			// 根据文件创建文件的输入流  
			in = new FileInputStream(file);  
			// 创建字节数组  
			// 读取内容，放到字节数组里面  
			byte[] buffer = new byte[256];
			int n;
			while ((n = in.read(buffer)) >= 0) {
				out.write(buffer, 0, n);
			}
			;
		} catch (Exception e) {  
			e.printStackTrace();  
		} finally {  
			try {  
				// 关闭输入流  
				in.close();  
			} catch (Exception e) {  
				e.printStackTrace();  
			}  
		}  
		return out;
	}

	   

	/**
	 * 向指定目录写入指定文件名和内容的文件
	 * 
	 * @param dirFile
	 * @param fileName
	 * @param content
	 * @throws IOException
	 * @Description:
	 */
	public static void writeFile(File dirFile, String fileName, byte[] bytes)
			throws IOException {
		// 如果文件名不存在，则创建文件夹
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		File crashFile = new File(dirFile, fileName);
		// 将错误报告写入文件
		FileOutputStream fous = new FileOutputStream(crashFile);
		fous.write(bytes,0,bytes.length);
		fous.flush(); 
		fous.close();
		
	}

	/**
	 * 向指定目录写入指定文件名和内容的文件
	 * 
	 * @param dirFile
	 * @param fileName
	 * @param content
	 * @throws IOException
	 * @Description:
	 */
	public static void writeFile(File dirFile, String fileName, String content)
			throws IOException {
		// 如果文件名不存在，则创建文件夹
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		File crashFile = new File(dirFile, fileName);
		// 将错误报告写入文件
		FileOutputStream fous = new FileOutputStream(crashFile);
		BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(
				fous, "UTF-8"));
		bufWriter.write(content);
		bufWriter.flush();
		fous.close();
		bufWriter.close();
	}

	/**
	 * 得到系统存放临时文件目录，这里约定在系统目录的上层，建立{TMP_DIRNAME}名称的目录
	 * 
	 * @param fn
	 *            如果没有指定目录，则默认以 getWebRootPath为定位
	 * @return
	 * @Description:
	 */
	public static String getTempRoot(String fn) {
		if (StringUtils.isEmpty(fn)) {
			fn = PathKit.getWebRootPath();
		}
		if (fn.lastIndexOf("\\\\") > 0) {
			fn = fn.substring(0, fn.lastIndexOf("\\\\"));
			fn = fn + "tmp";
		}
		return fn;
	}

	/**
	 * 取得当前类所在的文件
	 * 
	 * @param clazz
	 * @return
	 */
	public static File getClassFile(Class clazz) {
		URL path = clazz.getResource(clazz.getName().substring(
				clazz.getName().lastIndexOf(".") + 1)
				+ ".classs");
		if (path == null) {
			String name = clazz.getName().replaceAll("[.]", "/");
			path = clazz.getResource("/" + name + ".class");
		}
		log.debug(" getClassFile : path=" + path);
		return new File(path.getFile());
	}

	/**
	 * 取得当前类所在的ClassPath目录，比如tomcat下的classes路径
	 * 
	 * @param clazz
	 * @return
	 */
	public static File getClassPathFile(Class clazz) {
		File file = getClassFile(clazz);
		for (int i = 0, count = clazz.getName().split("[.]").length; i < count; i++)
			file = file.getParentFile();
		if (file.getName().toUpperCase().endsWith(".JAR!")) {
			file = file.getParentFile();
		}
		log.debug(" getClassPathFile : " + file.getAbsolutePath());
		return file;
	}

	/**
	 * 取得当前类所在的ClassPath路径
	 * 
	 * @param clazz
	 * @return
	 */
	public static String getClassPath(Class clazz) {
		try {
			return java.net.URLDecoder.decode(getClassPathFile(clazz)
					.getAbsolutePath(), "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 得到类的根目录，例如mobileservice\WebRoot\WEB-INF\classes
	 * 由于部署在websphere下，改用兼容不同环境下代码实现
	 * 
	 * @return
	 * @Description:
	 */
	public static File loadRootfile() {
		/*
		 * String classRootPath =
		 * FileUtils.class.getClassLoader().getResource("") .getFile(); try {
		 * classRootPath = java.net.URLDecoder.decode(classRootPath, "UTF-8"); }
		 * catch (UnsupportedEncodingException e) { e.printStackTrace();
		 * log.error("获取classRootPath异常"); } log.info("loadRootfile：" +
		 * classRootPath); File file = new File(classRootPath);
		 */
		File file = getClassPathFile(FileUtils.class);
		
		return file;
	}

	/**
	 * 加载目录下所有Controller的类
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static List<Class<?>> loadControllerFile(){
		classcount=0;
		return findClasses(loadRootfile(), ".class");
	}

	/**
	 * 加载目录下所有Model的类
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @Description:
	 */
	public static List<Class<?>> loadModelClass() throws ClassNotFoundException {
		return findClasses(loadRootfile(), "model");
	}


	/**
	 * 迭代查找*Controller.class的类
	 * 
	 * @param dir
	 * @param pk
	 * @return
	 * @throws ClassNotFoundException
	 */
	private static List<Class<?>> findClasses(File dir, String classprex) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		if (!dir.exists()) {
			return classes;
		}

		String rootStr=loadRootfile().getAbsolutePath()+"\\";
		log.debug("rootStr="+rootStr);
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				classes.addAll(findClasses(f, classprex));
				continue;
			}
			String name = f.getAbsolutePath();
			if(name.indexOf(".class")<0){
				continue;
			}
			classcount++;
			log.debug(classcount+" findClasses : " + name);
			log.debug("classname1="+name.substring(name.indexOf(rootStr)));
			log.debug("classname2="+name.substring(name.indexOf(rootStr)+rootStr.length()));
//			name = name.substring(name.indexOf("com"));
			name = name.substring(name.indexOf(rootStr)+rootStr.length());
			name = name.replaceAll("\\\\", ".");
			name = name.replaceAll("/", ".");
			// System.out.println("name=" + name);
			if ((name.endsWith(classprex) || name.contains(classprex))
					&& name.endsWith(".class")) {
				log.debug(" CLASS NAME=" + name);
				try {
					classes.add(Class.forName(name.substring(0,
							name.length() - 6)));
				} catch (Exception e) {
					e.printStackTrace();
					log.error("类不存在？" + name + " | " + e.getMessage());
				}
			}
		}
		return classes;
	}

	public static void main(String[] args) throws IllegalArgumentException,
			IllegalAccessException {

		// List<File> fs = loadSqlFile();
		// System.out.println("file=" + fs.size());
		File f = loadRootfile();
		System.out.println(f.getPath());
		System.out.println(PathKit.getWebRootPath());
	}
	
	
	/**
	 * 加载目录下所有sql的xml文件
	 * @param directory 	classes下面的目录,默认为 classes/sql/
	 * @return
	 */
	public static List<File> loadSqlFile(String directory) {
		String fold=directory==null?"/sql":directory;
		List<File> files=null;
		String foldname = PathKit.getRootClassPath()+fold;
		log.debug("foldname="+foldname);
		files=findFiles(new File(foldname), ".xml");
		return files;
	}

	/**
	 * 递归查找文件,文件后缀以 .sql.xml区分
	 * 
	 * @param baseFile
	 * @param sqlXmlFiles
	 */
	private static List<File> findFiles(File baseFile, String fileprex) {
		List<File> sqlXmlFiles=new ArrayList<File>();
			File[] fileList = baseFile.listFiles();
			for (File file : fileList) {
				log.debug("filename="+file.getName()+",issql="+file.getName().endsWith(fileprex));
				
				if (file.getName().endsWith(fileprex)) {
					sqlXmlFiles.add(file);
				}
			}
		return sqlXmlFiles;
	}
	
	
	
}