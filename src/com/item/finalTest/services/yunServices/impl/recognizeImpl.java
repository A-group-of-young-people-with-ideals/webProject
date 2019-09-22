package com.item.finalTest.services.yunServices.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.FileInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

import com.baidu.aip.imageclassify.AipImageClassify;
import okhttp3.*;
import java.util.*;
import com.item.finalTest.collectionUtils.StringUtil;
import com.item.finalTest.services.yunServices.interfaces.recognizes;



public class recognizeImpl extends WebSocketListener implements recognizes {
	
	/**
	 * 声音识别具体实现方法
	 */
	@Override
	public String getSoundDate(String soundUrl) throws Exception {
		String result=WebIATWS.soundResult;
		if(StringUtil.isBlank(soundUrl)) {
			throw new Exception("param is null");
		}
		System.out.println(soundUrl);
		//读取配置文件
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/configuration/yunservices.properties"));
		String soundHostUrl = prop.getProperty("soundHostUrl");
		String soundAppid = prop.getProperty("soundAppid");
		String soundApiKey = prop.getProperty("soundApiKey");
		String soundApiSecret = prop.getProperty("soundApiSecret");
		if(!StringUtil.isBlank(soundHostUrl)&&!StringUtil.isBlank(soundUrl)&&!StringUtil.isBlank(soundAppid)&&!StringUtil.isBlank(soundApiKey)&&!StringUtil.isBlank(soundApiSecret)) {
			WebIATWS.file=soundUrl;
			WebIATWS.appid=soundAppid;
			// 构建鉴权url
	        String authUrl = WebIATWS.getAuthUrl(soundHostUrl, soundApiKey, soundApiSecret);
	        OkHttpClient client = new OkHttpClient.Builder().build();
	        //将url中的 schema http://和https://分别替换为ws:// 和 wss://
	        String url = authUrl.toString().replace("http://", "ws://").replace("https://", "wss://");
	        //System.out.println(url);
	        Request request = new Request.Builder().url(url).build();
	        // System.out.println(client.newCall(request).execute());
	        //System.out.println("url===>" + url);
	        WebSocket webSocket = client.newWebSocket(request, new WebIATWS());
		}else {
			throw new Exception("云服务接口配置文件不完整");
		}
		return result;
	}
	/**
	 * 图像识别具体实现方法
	 */
	@Override
	public String getImageDate(String imageUrl) throws Exception {
		String result = null;
		if (StringUtil.isBlank(imageUrl)) {
			throw new Exception("param is null");
		}
		// 读取配置文件
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/configuration/yunservices.properties"));
		String imageAppId = prop.getProperty("imageAppId");
		String imageApiKey = prop.getProperty("imageApiKey");
		String imageSecretKey = prop.getProperty("imageSecretKey");
		if (!StringUtil.isBlank(imageAppId) && !StringUtil.isBlank(imageApiKey)
				&& !StringUtil.isBlank(imageSecretKey)) {
			// 初始化一个AipImageClassifyClient
			AipImageClassify client = new AipImageClassify(imageAppId, imageApiKey, imageSecretKey);
			// 传入可选参数调用接口
			HashMap<String, String> options = new HashMap<String, String>();
			JSONObject res = client.logoSearch(imageUrl, options);
			options.put("custom_lib", "false");
//			System.out.println(res.toString(2));
//			System.out.println(res.getString("error_code"));
			// 获取识别结果，当识别结果多个时，取识别率最高
			if (res.isNull("result")) {
				result = null;
			} else {
				JSONArray ja = res.getJSONArray("result");
				if (ja.isNull(0))
					result = null;
				else {
					JSONObject jo = ja.getJSONObject(0);
					result = jo.getString("name");
//                 	for (int i = 0; i < ja.length(); i++) {
//                         JSONObject jo = ja.getJSONObject(i);
//                         result = jo.getString("name");
//                         System.out.println(result);
//                     }	
				}
			}
		} else {
			throw new Exception("云服务接口配置文件不完整");
		}
		return result;
	}

}
