package test;

import java.io.File;

import org.junit.Test;

import com.item.finalTest.collectionUtils.sqlUtil;
import com.item.finalTest.services.yunServices.impl.recognizeImpl;
import com.item.finalTest.services.yunServices.interfaces.recognizes;

public class test {
	
	@Test
	public void testQueryUserById() throws Exception {
//		File file=new File("C:\\eclipse2019\\workspace\\Demo\\src\\com\\item\\finalTest\\collectionUtils\\SUtil.java");
//		file.setReadOnly();
//		file.setWritable(false);
//		System.out.println(file.canWrite());
//		file.setWritable(true);
//		System.out.println(file.canWrite());
		recognizes recognizes=new recognizeImpl();
//		recognizes.getImageDate("C:\\Users\\zydx\\Desktop\\1.jpg");
	    recognizes.getSoundDate("src\\upload\\sounds\\16k_10.pcm");
	}
}
