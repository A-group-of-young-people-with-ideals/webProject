package com.item.finalTest.services.yunServices.interfaces;



/**
 * 集成了云服务接口包括图像识别、语音识别等
 * @author hemb
 * @date   2019年9月21日
 */
public interface recognizes {
	
	/**
	 * 图像识别接口
	 * @param imageUrl  图片路径
	 * @return
	 * @throws Exception 
	 */
	public String getImageDate(String imageUrl) throws Exception;
	
	public String getSoundDate(String soundUrl) throws Exception;
	
	
	
	
}
