package org.ks.note.test;

import org.junit.Assert;
import org.junit.Test;
import org.ks.note.dao.UserDao;
import org.ks.note.entity.User;
import org.ks.note.util.NoteUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
	@Test
	public void TestLogin(){
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao=ac.getBean("userDao",UserDao.class);
		User user=dao.findByName("����");
		//����
		Assert.assertEquals("С��1", user.getCn_user_desc());
	}
	@Test
	public void testInsert(){
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao=ac.getBean("userDao",UserDao.class);
		User user=new User();
		user.setCn_user_id(NoteUtil.createId());//����ID
		user.setCn_user_name("����");
		user.setCn_user_password(NoteUtil.md5("123456"));//��������
		user.setCn_user_desc("С��");
		int i=dao.insert(user);//ע���û�
		Assert.assertEquals(1, i);
	}
}
