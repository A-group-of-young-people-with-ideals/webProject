package com.item.finalTest.services.interfaces;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

/**
 * �ļ�������ؽӿ�
 * @author hemb
 * @date   2019��9��30��
 */
public interface IFileCSV {
	
	/**
	 * �ϴ��ļ��ӿ�
	 * @throws Exception 
	 */
	public String UpLoadFile(List<FileItem> list,String fileType,String basePath) throws Exception;

}
