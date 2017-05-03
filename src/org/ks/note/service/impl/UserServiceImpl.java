package org.ks.note.service.impl;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.ks.note.dao.UserDao;
import org.ks.note.entity.User;
import org.ks.note.service.UserService;
import org.ks.note.util.NoteResult;
import org.ks.note.util.NoteUtil;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 * ����û���½
	 */
	@Override
	public NoteResult checkLogin(String cn_user, String cn_password) {
		NoteResult result=new NoteResult();
		User user=userDao.findByName(cn_user);
		//����û�
		if(user==null){
			//״̬��0���ɹ�,1:�û�������ȷ,2:���벻��ȷ
			result.setStatus(1);
			result.setMsg("�û��������ڣ�");
			return result;
		}
		//��������������
		if(!user.getCn_user_password().equals(NoteUtil.md5(cn_password))){
			//���벻��ȷ
			result.setStatus(2);
			result.setMsg("���벻��ȷ��");
			return result;
		}
		//�û��������붼��ȷ
		result.setStatus(0);
		result.setMsg("��½�ɹ���");
		result.setData(user.getCn_user_id());
		return result;
	}
	//ע��
	@Override
	public NoteResult registe(String username,String password,String nickname) {
		// TODO Auto-generated method stub
		NoteResult result=new NoteResult();
		//����û����Ƿ�ע��
		User dbuser=userDao.findByName(username);
		if(dbuser!=null){
			result.setStatus(1);
			result.setMsg("�û�����ע��!!");
			return result;
		}
		//ִ��ע��
		User user=new User();
		user.setCn_user_id(NoteUtil.createId());
		user.setCn_user_name(username);
		user.setCn_user_password(NoteUtil.md5(password));
		user.setCn_user_token(null);
		user.setCn_user_desc(nickname);
		userDao.insert(user);
		result.setStatus(0);
		result.setMsg("ע��ɹ�!!");
		return result;
	}
	/**
	 * �޸�����
	 */
	@Override
	public NoteResult changePwd(String lastpwd, String newpwd,String id) {
		NoteResult result=new NoteResult();
		Map<String, Object> ma=new HashMap<String,Object>();
		ma.put("cn_user_password", NoteUtil.md5(newpwd));
		ma.put("cn_user_id", id);
		userDao.changePassword(ma);
		result.setStatus(0);
		result.setMsg("�޸�����ɹ�");
		return result;
	}
	/**
	 * ����ID�����û�
	 */
	@Override
	public NoteResult findById(String id,String pwd) {
		NoteResult result=new NoteResult();
		User user=userDao.findById(id);
		pwd=NoteUtil.md5(pwd);
		System.err.println(user.getCn_user_password());
		System.err.println(pwd);
		if(!pwd.equals(user.getCn_user_password())){
			result.setStatus(1);
			result.setMsg("*ԭʼ���벻��ȷ");
			return result;
		}
		result.setStatus(0);
		return result;
	}
	
	
}
