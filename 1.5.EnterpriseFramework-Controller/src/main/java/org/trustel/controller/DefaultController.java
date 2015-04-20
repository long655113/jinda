package org.trustel.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tools.zip.ZipFile;
import org.springframework.web.multipart.MultipartFile;

public class DefaultController extends CommonController implements Identifiable {
	
	protected Log logger = LogFactory.getLog(getClass());

	public String getPrivilegeCode() {
		return getClass().getSimpleName();
	}

	/**
	 * �ļ��ϴ����÷���
	 * 
	 * @param file
	 * @param fullFileName
	 * @return �ϴ��������
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public boolean uploadFile(MultipartFile file, String fullFileName)
			throws IllegalStateException, IOException {
		logger.info("�ϴ��ļ���" + fullFileName);
		if (file == null || fullFileName == null
				|| "".equals(fullFileName.trim())) {
			logger.info("�ϴ��ļ����ļ�����Ϊ�ջ��ļ���Ϊ�գ�");
			return false;
		}
		file.transferTo(new File(fullFileName));
		// } catch (Exception e) {
		// logger.error(e.getMessage(), e);
		// return false;
		// }
		logger.info("�ϴ��ļ�:�ɹ�!");
		return true;
	}

	/**
	 * ɾ���ϴ����ļ����÷���
	 * 
	 * @param fullFileName
	 *            �ļ��洢�ľ���·��
	 * @return
	 */
	public boolean deleteFile(String fullFileName) {
		logger.info("ɾ���ļ���" + fullFileName);
		if (fullFileName == null || "".equals(fullFileName.trim())) {
			logger.info("ɾ���ļ����ļ�������Ϊ�գ�");
			return false;
		}
		File file = new File(fullFileName);
		if (!file.isDirectory() && file.exists())
			// try {
			file.delete();
		// } catch (Exception e) {
		// logger.error(e.getMessage(), e);
		// return false;
		// }
		logger.info("ɾ���ļ���ɾ���ɹ���");
		return true;
	}

	 public  File changeToFile(MultipartFile file, String outputDirectory){
		 File f = new File(outputDirectory+"/"+file.getOriginalFilename());
		 try {
			f.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		 try {
			InputStream in = file.getInputStream();
			FileOutputStream out=new FileOutputStream(f);
			byte[] by = new byte[1024];
	        int c;
	        while ( (c = in.read(by)) != -1) {
	             out.write(by, 0, c);
	        }
           out.close();
           in.close();
	         
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return f;
	 }

		public String checkZip(File file)throws IOException {
			boolean hasImages = false;
			boolean hasHtml = false;
			String path="";
			ZipFile zipFile=null;
			 try {
			      zipFile = new ZipFile(file);
			      java.util.Enumeration e = zipFile.getEntries();
			      org.apache.tools.zip.ZipEntry zipEntry = null;
			      String s="";
			      while (e.hasMoreElements()) {
			         zipEntry = (org.apache.tools.zip.ZipEntry) e.nextElement();
			         if (zipEntry.isDirectory()) {
			        	 s = zipEntry.getName();
			        	 int index_images = s.indexOf("images/");
			        	 if(index_images!=-1){
			        		 if(s.equals("images/") && s.indexOf("images/")==0){
			        			 //��һ��Ŀ¼����images�ļ���
								 hasImages = true;
							 }
			        		 else if(s.contains("/images/")){
			        			 //�ڶ���Ŀ¼����images�ļ���
			        			 hasImages = true;
			        		 }
			        	 }
						 
						 continue;
			         }
			         else {
			        	 s = zipEntry.getName();
						 if(s.contains(".html")){
							 path = zhTOen(s);
							 hasHtml = true;
						 }
			         }
			       }
			   }
			     catch (Exception ex) {
			    	 logger.error(ex.getMessage());
			     }finally{
			    	 if(zipFile!=null){
				    	  zipFile.close();
				    	 }
				     }
			if(!hasImages && !hasHtml){
				path="noimagesAndnohtml";
			}
			else if(!hasImages){
				path="noimages";
			}
			else if(!hasHtml){
				path="nohtml";
			}
			
			return path;
		}

		//������ת��ΪӢ��
		private  String zhTOen(String name) {
	         HanyuPinyinOutputFormat pyFormat = new HanyuPinyinOutputFormat();
	         pyFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
	         pyFormat.setVCharType(HanyuPinyinVCharType.WITH_V);

	         try {
				return PinyinHelper.toHanyuPinyinString(name, pyFormat, "");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         return "";
	    }
		
		 /**
		 * ��ѹ��zipFile
		 * @param file
		 *            Ҫ��ѹ��zip�ļ�����
		 * @param outputDirectory
		 *            Ҫ��ѹ��ĳ��ָ����Ŀ¼��
		 * @throws IOException
		 */
	 public void unZip(File file, String outputDirectory) throws IOException {
		 org.apache.tools.zip.ZipFile zipFile=null;
	     try {
	      zipFile = new ZipFile(file);
	      java.util.Enumeration e = zipFile.getEntries();
	      org.apache.tools.zip.ZipEntry zipEntry = null;
	      String s="";
	      outputDirectory = zhTOen(outputDirectory);
	      //String srmc = outputDirectory.replace("eshop.war/WEB-INF/templates", "SRMC.war");
	      String srmc = outputDirectory;
	      while (e.hasMoreElements()) {
	         zipEntry = (org.apache.tools.zip.ZipEntry) e.nextElement();
	         if (zipEntry.isDirectory()) {
	    		 continue;
	         }
	         else {
	        	 s = zhTOen(zipEntry.getName());
	        	 s = s.replace('\\', '/');
	    		 if(s.contains(".html")){
		             if (s.indexOf("/") != -1)
		             {
		                 createDirectory(outputDirectory,s.substring(0, s.lastIndexOf("/")));
		             }
	    			File f = new File(outputDirectory + File.separator + s);
	 	            f.createNewFile();
	    	         InputStreamReader ir = new InputStreamReader(zipFile.getInputStream(zipEntry),"utf-8");
	    	         BufferedReader br = new BufferedReader(ir);
	    	         OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f),"utf-8");
	    	         BufferedWriter bw=new BufferedWriter(osw);
		  	         String line;
		  	         while ( (line = br.readLine()) != null) {
		  	        	if(line.contains("src=\"") && !line.contains("src=\"http://") 
		  	        			&& !line.contains("src=\"https://")){
		  	        		 int sindex = srmc.indexOf("/Merchant/");
		  	        		 String tmp = s.substring(0, s.lastIndexOf("/"));
		  	        		 String src = srmc.substring(sindex, srmc.length())+"/" + tmp+"/";
		  	        		 String str = "src=\"/SRMC"+src;
		  	        		 line = line.replaceAll("src=\"", str);
		  	        	 }
		  	        	if(line.contains("src='")  && !line.contains("src='http://")
		  	        			 && !line.contains("src='https://") && !line.contains("src='")){
		  	        		 int sindex = srmc.indexOf("/Merchant/");
		  	        		 String tmp = s.substring(0, s.lastIndexOf("/"));
		  	        		 String src = srmc.substring(sindex, srmc.length()) +"/" + tmp+"/";
		  	        		 String str = "src='/SRMC"+src;
		  	        		line = line.replaceAll("src='", str);
		  	        	 }
		  	        	if(line.contains("href=\"") && !line.contains("href=\"http://")  && !line.contains("href=\"#")
		  	        			&& !line.contains("href=\"https://") && !line.contains("href=\"javascript")){
		  	        		 int sindex = srmc.indexOf("/Merchant/");
		  	        		 String tmp = s.substring(0, s.lastIndexOf("/"));
		  	        		 String href = srmc.substring(sindex, srmc.length())+"/" + tmp+"/";
		  	        		 String str = "href=\"/SRMC"+href;
		  	        		line = line.replaceAll("href=\"", str);
		  	        	 }
		  	        	if(line.contains("href='")  && !line.contains("href='http://")
		  	        			&& !line.contains("href='https://") && !line.contains("href='javascript")
		  	        			&& !line.contains("href='") && !line.contains("href='#")){
		  	        		 int sindex = srmc.indexOf("/Merchant/");
		  	        		 String tmp = s.substring(0, s.lastIndexOf("/"));
		  	        		 String href = srmc.substring(sindex, srmc.length()) +"/" + tmp+"/";
		  	        		 String str = "href='/SRMC"+href;
		  	        		 line = line.replaceAll("href='", str);
		  	        	 }
		  	        	 if(line.contains("<head>")){
		  	        		 int index = line.indexOf("<head>");
		  	        		 String left = line.substring(0, index);
		  	        		 String right = line.substring(index+6, line.length());
//		  	        		 String str = "<head>"+
//		  	        				 "<link type='text/css' rel='stylesheet' media='all' href='/SRMC/model/css/base.css' />"+
//		  	        				 "<link type='text/css' rel='stylesheet' media='all' href='/SRMC/model/css/account.css' />"+
//		  	        				 "<link type='text/css' rel='stylesheet' media='all' href='/SRMC/model/css/ui.datepicker.css' />";
		  	        		 String str = "<head>";
		  	        		 line = left + str + right;
		  	        	 }
		  	        	/*if(line.contains("<body>")){
		  	        		 int index = line.indexOf("<body>");
		  	        		 String left = line.substring(0, index);
		  	        		 String right = line.substring(index+6, line.length());
		  	        		 String str = "<body><#if '${includeStatus==0}'>"+
		  	        				 		"<#include '/ctf2/include/common/common_header.html' />"+
		  	        				 		"</#if>";
		  	        		 line = left + str + right;
		  	        	 }
		  	        	if(line.contains("</body>")){
		  	        		 int index = line.indexOf("</body>");
		  	        		 String left = line.substring(0, index);
		  	        		 String right = line.substring(index+7, line.length());
		  	        		 String str = "<#if '${includeStatus==0}'>"+
		  	        				 		"<#include '/ctf2/include/common/common_footer.html' />"+
		  	        				 		"</#if></body>";
		  	        		 line = left + str + right;
		  	        	 }*/
		  	        	
		  	        	 bw.write(line+"\r\n");
		  	         }
		  	         bw.flush();
		  	         bw.close();
		  	         br.close();
		  	         ir.close();
		  	         continue;
	    		 }
	    		 else{
		             if (s.indexOf("/") != -1)
		             {
		                 createDirectory(srmc,s.substring(0, s.lastIndexOf("/")));
		             }
		             File f2 = new File(srmc + File.separator + s);
			         f2.createNewFile();
		    		 InputStream in = zipFile.getInputStream(zipEntry);
		  	         FileOutputStream out=new FileOutputStream(f2);

		  	         byte[] by = new byte[1024];
		  	         int c;
		  	         while ( (c = in.read(by)) != -1) {
		  	        	 out.write(by, 0, c);
		  	         }
		  	         out.flush();
		  	         out.close();
		  	         in.close();
	    		 }
	         }
	       }
	        }
	     catch (Exception ex) {
	       System.out.println(ex.getMessage());
	     }finally{
	    	 if(zipFile!=null){
	    	  zipFile.close();
	    	 }
	     }
     }
	 
	/**
	 * �����ļ���
	 * @param directory
	 * @param subDirectory
	 */
	private void createDirectory(String directory, String subDirectory) {
	     String dir[];
	     File fl = new File(directory);
	     try {
	       if (subDirectory == "" && fl.exists() != true)
	         fl.mkdir();
	       else if (subDirectory != "") {
	         dir = subDirectory.replace('\\', '/').split("/");
	         for (int i = 0; i < dir.length; i++) {
	           File subFile = new File(directory + File.separator + dir[i]);
	           if (subFile.exists() == false)
	             subFile.mkdir();
	           directory += File.separator + dir[i];
	         }
	       }
	     }
	     catch (Exception ex) {
	    	 logger.error(ex.getMessage());
	     }
	   }
}