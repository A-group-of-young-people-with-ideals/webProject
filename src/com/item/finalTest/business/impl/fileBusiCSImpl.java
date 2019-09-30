package com.item.finalTest.business.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.item.finalTest.business.interfaces.IFileBusiCS;
import com.item.finalTest.collectionUtils.DateUtil;
import com.item.finalTest.collectionUtils.StringUtil;
import com.item.finalTest.constant.finalTest;

public class fileBusiCSImpl implements IFileBusiCS {
	@Override
	public String upLoad(List<FileItem> list, String fileType, String basePath) throws Exception {
		String result="";
	    String realPathHead=basePath+"src\\upload";
//	    System.out.println(basePath);
		if(list==null) {
			throw new Exception("上传文件为空");
		}
		//根据不同文件类型存放不同位置
		for (FileItem fileItem : list) {
			if(fileItem.isFormField()) {
				//获取表单字段
				String fileName=fileItem.getFieldName();
				String value=fileItem.getString("UTF-8");
				System.out.println(fileName+"="+value);
			}else {
				// 得到上传的文件名称，
				String filename = fileItem.getName();
//				System.out.println(filename);
				if (filename == null || filename.trim().equals("")) {
					continue;
				}
				//处理获取到的上传文件名的绝对路径，只保留文件名部分
			    filename=filename.substring(filename.lastIndexOf("\\")+1);
			    //得到上传文件的扩展名
			    String fileExtName=filename.substring(filename.lastIndexOf(".")+1);
			    //获取上传的输入流
			    InputStream in=fileItem.getInputStream();
			    //文件上传后保存的名称
			    String saveFileName=makeFileName(filename);
			    String realPath=realPathHead;
			    if(!StringUtil.isBlank(fileType)) {
			    	
			    	if(fileType.equals(finalTest.fileType.IMAGE_TYPE)) {
			    		// 如果是图片类型存放位置为src\\upload\\photos
			    		realPath=makeSavePath(realPathHead+"\\photos\\");
			    		
			    	}else if (fileType.equals(finalTest.fileType.SOUND_TYPE)) {
			    		//如果是音频类型存放在src\\upload\\sounds
			    		 realPath=makeSavePath(realPathHead+"\\sounds\\");
						
					}else {
						//其他类型文件存放在src\\upload\\file
						realPath=makeSavePath(realPathHead+"\\file\\");
					}
			    }
			    FileOutputStream out = new FileOutputStream(realPath + "\\" + saveFileName);
			    byte buffer[] = new byte[1024];
				// 判断输入流中的数据是否已经读完的标识
				int len = 0;
				// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
				while ((len = in.read(buffer)) > 0) {
					// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
					out.write(buffer, 0, len);
				}
				// 关闭输入流
				in.close();
				// 关闭输出流
				out.close();
				System.out.println("=============>>>>>第一个文件上传成功========>>>>>>");
			}
			System.out.println("=============>>>>>表单中所有文件上传成功=====>>>>>>");
			 result="上传成功";
		}
		return result;
	}
	private String makeSavePath(String string) throws Exception {
		String date=DateUtil.getDateString(DateUtil.YYYYMMDD);
		String dir=string+date;
		System.out.println(dir);
		File file=new File(dir);
		if (!file.exists()) {
			// 创建目录
			file.mkdirs();
		}
		return dir;
	}

	private String makeFileName(String filename) throws Exception {
		String date=DateUtil.getDateString(DateUtil.YYYYMMDDHHMM);
		return date+filename;
	}

	

}
