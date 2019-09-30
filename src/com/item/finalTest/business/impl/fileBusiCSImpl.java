package com.item.finalTest.business.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.item.finalTest.business.interfaces.IFileBusiCS;
import com.item.finalTest.collectionUtils.DateUtil;
import com.item.finalTest.collectionUtils.StringUtil;
import com.item.finalTest.constant.finalTest;

public class fileBusiCSImpl implements IFileBusiCS {
	@Override
	public String upLoad(List<FileItem> list, String fileType, String basePath) throws Exception {
		String result="";
	    String realPathHead=basePath+"src\\upload";
//	    System.out.println(basePath);
		if(list==null) {
			throw new Exception("�ϴ��ļ�Ϊ��");
		}
		//���ݲ�ͬ�ļ����ʹ�Ų�ͬλ��
		for (FileItem fileItem : list) {
			if(fileItem.isFormField()) {
				//��ȡ���ֶ�
				String fileName=fileItem.getFieldName();
				String value=fileItem.getString("UTF-8");
				System.out.println(fileName+"="+value);
			}else {
				// �õ��ϴ����ļ����ƣ�
				String filename = fileItem.getName();
//				System.out.println(filename);
				if (filename == null || filename.trim().equals("")) {
					continue;
				}
				//�����ȡ�����ϴ��ļ����ľ���·����ֻ�����ļ�������
			    filename=filename.substring(filename.lastIndexOf("\\")+1);
			    //�õ��ϴ��ļ�����չ��
			    String fileExtName=filename.substring(filename.lastIndexOf(".")+1);
			    //��ȡ�ϴ���������
			    InputStream in=fileItem.getInputStream();
			    //�ļ��ϴ��󱣴������
			    String saveFileName=makeFileName(filename);
			    String realPath=realPathHead;
			    if(!StringUtil.isBlank(fileType)) {
			    	
			    	if(fileType.equals(finalTest.fileType.IMAGE_TYPE)) {
			    		// �����ͼƬ���ʹ��λ��Ϊsrc\\upload\\photos
			    		realPath=makeSavePath(realPathHead+"\\photos\\");
			    		
			    	}else if (fileType.equals(finalTest.fileType.SOUND_TYPE)) {
			    		//�������Ƶ���ʹ����src\\upload\\sounds
			    		 realPath=makeSavePath(realPathHead+"\\sounds\\");
						
					}else {
						//���������ļ������src\\upload\\file
						realPath=makeSavePath(realPathHead+"\\file\\");
					}
			    }
			    FileOutputStream out = new FileOutputStream(realPath + "\\" + saveFileName);
			    byte buffer[] = new byte[1024];
				// �ж��������е������Ƿ��Ѿ�����ı�ʶ
				int len = 0;
				// ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
				while ((len = in.read(buffer)) > 0) {
					// ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\" + filename)����
					out.write(buffer, 0, len);
				}
				// �ر�������
				in.close();
				// �ر������
				out.close();
				System.out.println("=============>>>>>��һ���ļ��ϴ��ɹ�========>>>>>>");
			}
			System.out.println("=============>>>>>���������ļ��ϴ��ɹ�=====>>>>>>");
			 result="�ϴ��ɹ�";
		}
		return result;
	}
	private String makeSavePath(String string) throws Exception {
		String date=DateUtil.getDateString(DateUtil.YYYYMMDD);
		String dir=string+date;
		System.out.println(dir);
		File file=new File(dir);
		if (!file.exists()) {
			// ����Ŀ¼
			file.mkdirs();
		}
		return dir;
	}

	private String makeFileName(String filename) throws Exception {
		String date=DateUtil.getDateString(DateUtil.YYYYMMDDHHMM);
		return date+filename;
	}

	

}
