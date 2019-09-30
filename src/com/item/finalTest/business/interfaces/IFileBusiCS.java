package com.item.finalTest.business.interfaces;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

public interface IFileBusiCS {

	String upLoad(List<FileItem> list, String fileType, String basePath) throws Exception;

}
