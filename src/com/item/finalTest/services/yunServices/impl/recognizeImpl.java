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
	 * ����ʶ�����ʵ�ַ���
	 */
	@Override
	public String getSoundDate(String soundUrl) throws Exception {
		String result=WebIATWS.soundResult;
		if(StringUtil.isBlank(soundUrl)) {
			throw new Exception("param is null");
		}
		System.out.println(soundUrl);
		//��ȡ�����ļ�
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/configuration/yunservices.properties"));
		String soundHostUrl = prop.getProperty("soundHostUrl");
		String soundAppid = prop.getProperty("soundAppid");
		String soundApiKey = prop.getProperty("soundApiKey");
		String soundApiSecret = prop.getProperty("soundApiSecret");
		if(!StringUtil.isBlank(soundHostUrl)&&!StringUtil.isBlank(soundUrl)&&!StringUtil.isBlank(soundAppid)&&!StringUtil.isBlank(soundApiKey)&&!StringUtil.isBlank(soundApiSecret)) {
			WebIATWS.file=soundUrl;
			WebIATWS.appid=soundAppid;
			// ������Ȩurl
	        String authUrl = WebIATWS.getAuthUrl(soundHostUrl, soundApiKey, soundApiSecret);
	        OkHttpClient client = new OkHttpClient.Builder().build();
	        //��url�е� schema http://��https://�ֱ��滻Ϊws:// �� wss://
	        String url = authUrl.toString().replace("http://", "ws://").replace("https://", "wss://");
	        //System.out.println(url);
	        Request request = new Request.Builder().url(url).build();
	        // System.out.println(client.newCall(request).execute());
	        //System.out.println("url===>" + url);
	        WebSocket webSocket = client.newWebSocket(request, new WebIATWS());
		}else {
			throw new Exception("�Ʒ���ӿ������ļ�������");
		}
		return result;
	}
	/**
	 * ͼ��ʶ�����ʵ�ַ���
	 */
	@Override
	public String getImageDate(String imageUrl) throws Exception {
		String result = null;
		if (StringUtil.isBlank(imageUrl)) {
			throw new Exception("param is null");
		}
		// ��ȡ�����ļ�
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/configuration/yunservices.properties"));
		String imageAppId = prop.getProperty("imageAppId");
		String imageApiKey = prop.getProperty("imageApiKey");
		String imageSecretKey = prop.getProperty("imageSecretKey");
		if (!StringUtil.isBlank(imageAppId) && !StringUtil.isBlank(imageApiKey)
				&& !StringUtil.isBlank(imageSecretKey)) {
			// ��ʼ��һ��AipImageClassifyClient
			AipImageClassify client = new AipImageClassify(imageAppId, imageApiKey, imageSecretKey);
			// �����ѡ�������ýӿ�
			HashMap<String, String> options = new HashMap<String, String>();
			JSONObject res = client.logoSearch(imageUrl, options);
			options.put("custom_lib", "false");
//			System.out.println(res.toString(2));
//			System.out.println(res.getString("error_code"));
			// ��ȡʶ��������ʶ�������ʱ��ȡʶ�������
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
			throw new Exception("�Ʒ���ӿ������ļ�������");
		}
		return result;
	}

}
