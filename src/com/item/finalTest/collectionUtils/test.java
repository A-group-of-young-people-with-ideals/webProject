package com.item.finalTest.collectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.item.finalTest.domain.userVO;

public class test {
	
	@Test
	public void testConversion() {
//		Map map=new HashMap();
//		List<userVO> list=new ArrayList<userVO>();
//		userVO userVO=new userVO();
//		userVO.setUserId(1L);
//		userVO.setName("Mike");
//		
//		userVO userVO2=new  userVO();
//		userVO2.setUserId(2L);
//		userVO2.setName("Dany");
//		list.add(userVO);
//		list.add(userVO2);
//		
//		map=TypeConversionUtil.list2Map(list, "name");
//		
//		System.out.println(map.get("Mike").toString());
		
		
		
		   String addressCode="10101;121213;11115";
	        String[] split = addressCode.split(";");
	        int length = split.length;
	        System.out.println(length);
	        System.out.println(split[0]);
	        System.out.println(split[1]);
	        System.out.println(split[2]);
	     
	}

}
