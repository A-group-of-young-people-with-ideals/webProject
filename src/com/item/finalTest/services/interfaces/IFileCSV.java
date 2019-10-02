package com.item.finalTest.services.interfaces;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

/**
 * 文件操作相关接口
 * @author hemb
 * @date   2019年9月30日
 */
public interface IFileCSV {
	
	/**
	 * 上传文件接口
	 * @throws Exception 
	 */
	public String UpLoadFile(List<FileItem> list,String fileType,String basePath) throws Exception;

}

