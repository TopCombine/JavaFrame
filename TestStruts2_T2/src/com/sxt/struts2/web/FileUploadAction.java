package com.sxt.struts2.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
	
	private String userName;
	
	private File file;
	//要得文件名     文件+[FileName]
	private String fileFileName;
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public File getFile() {
		return file;
	}



	public void setFile(File file) {
		this.file = file;
	}



	@Override
	public String execute() throws Exception {
		System.out.println("文件长度="+file.length());
		
		/*
		//==========================初始化输入输出流==========================
		//输入流
		FileInputStream fis=new FileInputStream(file);
		
		//输出流
		File outFile=new File("c:\\"+fileFileName);
		FileOutputStream fos=new FileOutputStream(outFile);
		//=========================工作===========================
		//新建一个字节数组
		byte[] buf=new byte[1024];
		//抽水机原理
		while(fis.read(buf)!=-1){
			fos.write(buf);
		}
		//========================关闭============================
		fis.close();
		fos.close();
		//======================================================
		*/
		
		//取得当前项目的目录名
		String path=ServletActionContext.getServletContext().getRealPath("/upload");
		System.out.println(path+fileFileName);
		//新建文件
		File destFile=new File(path+"/"+fileFileName);
		//拷贝文件
		FileUtils.copyFile(file, destFile);
		return "success";
		
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

}
