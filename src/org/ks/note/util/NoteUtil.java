package org.ks.note.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;


public class NoteUtil {
	/**
	 * �û�����ļ��ܴ���
	 * 
	 * md5���ܵ��ص㣺
	 * 1.������
	 * 2.�������ĵĳ����Ƿ�һ�£����ܺ�����ĵĳ��ȶ�һ��
	 * @param msg ����
	 * @return ����
	 * @throws NoSuchAlgorithmException 
	 */
	public static String md5(String msg){
		//���صĶ����Ǿ���md5�㷨�Ķ���
		try {
			MessageDigest md=
					MessageDigest.getInstance("MD5");
			byte[] input=msg.getBytes();
			//�Դ�����ֽ�������м��ܲ�����
			byte[] output=md.digest(input);
			//md5�����Ľ��ת��Ϊ�ַ��������룬
			//��base64�㷨���,��Ҫ������ص�jar��
			String str=Base64.encodeBase64String(output);
			return str;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��������쳣");
			return "";
		}
	}
	/*
	 * ����ID�ķ���
	 * ���ظ�,������
	 */
	public static String createId(){
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}
	public static void main(String[] args) {
//		System.out.println(md5("1234"));//gdyb21LQTcIANtvYMT7QVQ==
		System.out.println(createId());
	}
}
