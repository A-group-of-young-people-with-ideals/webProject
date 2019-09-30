package test;

import static org.hamcrest.CoreMatchers.is;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.junit.Test;

import com.item.finalTest.collectionUtils.StringUtil;
import com.item.finalTest.collectionUtils.sqlUtil;
import com.item.finalTest.domain.emailVO;
import com.item.finalTest.services.impl.emailCSVImpl;
import com.item.finalTest.services.impl.fileCSVImpl;
import com.item.finalTest.services.impl.userCSVImpl;
import com.item.finalTest.services.interfaces.IEmailCSV;
import com.item.finalTest.services.interfaces.IFileCSV;
import com.item.finalTest.services.interfaces.IUserCSV;
import com.item.finalTest.services.yunServices.impl.recognizeImpl;
import com.item.finalTest.services.yunServices.interfaces.recognizes;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class test {
	
	@Test
	public void testQueryUserById() throws Exception {
//		 IUserCSV iUserCSV=new userCSVImpl();
//		  iUserCSV.queryUserById(1);
//		File file=new File("C:\\eclipse2019\\workspace\\Demo\\src\\com\\item\\finalTest\\collectionUtils\\SUtil.java");
//		file.setReadOnly();
//		file.setWritable(false);
//		System.out.println(file.canWrite());
//		file.setWritable(true);
//		System.out.println(file.canWrite());
//		recognizes recognizes=new recognizeImpl();
////		recognizes.getImageDate("C:\\Users\\zydx\\Desktop\\1.jpg");
//	    recognizes.getSoundDate("src\\upload\\sounds\\example.m4a");
		
//		List<FileItem> list=new ArrayList<FileItem>();
//		File file=new File("C:\\Users\\zydx\\Desktop\\1189688.jpg");
//		FileItem fileItem=new FileInputStream(file);
//	
//		list.add(fileItem);
//		IFileCSV iFileCSV=new fileCSVImpl();
//		iFileCSV.UpLoadFile(list, "0");
		
		File file=new File("C:\\Users\\zydx\\Desktop\\1189688.jpg");
		System.out.println(new FileInputStream(file));
	  
	}
}
