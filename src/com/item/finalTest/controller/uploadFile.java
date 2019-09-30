package com.item.finalTest.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.item.finalTest.services.impl.fileCSVImpl;
import com.item.finalTest.services.interfaces.IFileCSV;

/**
 * Servlet implementation class uploadFile
 */
@WebServlet("/uploadFile")
public class uploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
    	String realPath = this.getServletContext().getRealPath("/");
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			// 创建临时目录
			tmpFile.mkdir();
		}
		String message="";
		// 使用Apache文件上传组件处理文件上传步骤：
		// 1、创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
		factory.setSizeThreshold(1024 * 100);// 设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
		// 设置上传时生成的临时文件的保存目录
		factory.setRepository(tmpFile);
		// 2、创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");
		// 3、判断提交上来的数据是否是上传表单的数据
//		if (!ServletFileUpload.isMultipartContent(request)) {
//			// 按照传统方式获取数据
//			return;
//		}
		 try {
			List<FileItem> list = upload.parseRequest(request);
			IFileCSV iFileCSV=new fileCSVImpl();
			message=iFileCSV.UpLoadFile(list, "0", realPath);
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }
}
