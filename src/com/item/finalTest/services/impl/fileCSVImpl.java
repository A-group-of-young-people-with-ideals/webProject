package com.item.finalTest.services.impl;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.item.finalTest.business.impl.fileBusiCSImpl;
import com.item.finalTest.business.impl.userBusiCSImpl;
import com.item.finalTest.business.interfaces.IFileBusiCS;
import com.item.finalTest.business.interfaces.IUserBusiCS;
import com.item.finalTest.services.interfaces.IFileCSV;

public class fileCSVImpl implements IFileCSV {

	@Override
	public String UpLoadFile(List<FileItem> list,String fileType,String basePath) throws Exception {
		IFileBusiCS  iFileBusiCS=new fileBusiCSImpl();
		return iFileBusiCS.upLoad(list,fileType,basePath);
	}

}
