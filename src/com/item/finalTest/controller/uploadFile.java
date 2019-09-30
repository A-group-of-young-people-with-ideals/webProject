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
			// ������ʱĿ¼
			tmpFile.mkdir();
		}
		String message="";
		// ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
		// 1������һ��DiskFileItemFactory����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ���ù����Ļ������Ĵ�С�����ϴ����ļ���С�����������Ĵ�Сʱ���ͻ�����һ����ʱ�ļ���ŵ�ָ������ʱĿ¼���С�
		factory.setSizeThreshold(1024 * 100);// ���û������Ĵ�СΪ100KB�������ָ������ô�������Ĵ�СĬ����10KB
		// �����ϴ�ʱ���ɵ���ʱ�ļ��ı���Ŀ¼
		factory.setRepository(tmpFile);
		// 2������һ���ļ��ϴ�������
		ServletFileUpload upload = new ServletFileUpload(factory);
		// ����ϴ��ļ�������������
		upload.setHeaderEncoding("UTF-8");
		// 3���ж��ύ�����������Ƿ����ϴ���������
//		if (!ServletFileUpload.isMultipartContent(request)) {
//			// ���մ�ͳ��ʽ��ȡ����
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
