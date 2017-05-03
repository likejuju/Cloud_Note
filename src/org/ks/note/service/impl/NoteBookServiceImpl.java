package org.ks.note.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.ks.note.dao.NoteBookDao;
import org.ks.note.entity.NoteBook;
import org.ks.note.service.NoteBookService;
import org.ks.note.util.NoteResult;
import org.ks.note.util.NoteUtil;
import org.springframework.stereotype.Service;

@Service(value="noteBookService")
public class NoteBookServiceImpl implements NoteBookService {
	private NoteBookDao noteBookDao;
	public NoteBookDao getNoteBookDao() {
		return noteBookDao;
	}
	//ע��Dao
	@Resource(name="noteBookDao")
	public void setNoteBookDao(NoteBookDao noteBookDao) {
		this.noteBookDao = noteBookDao;
	}
	/**
	 * �����û�ID�������бʼǱ�
	 */
	@Override
	public NoteResult loadNoteBook(String userId) {
		// TODO Auto-generated method stub
		List<NoteBook> notebooks=noteBookDao.findByUserId(userId);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setMsg("��ѯ�ɹ�");
		result.setData(notebooks);
		return result;
	}
	/**
	 * ���һ���ʼǱ�
	 */
	@Override
	public NoteResult add(String bookname, String userid) {
		// TODO (����׷�ӱʼǱ�������֤)
		NoteResult result=new NoteResult();
		NoteBook book=new NoteBook();
		book.setCn_notebook_name(bookname);
		book.setCn_user_id(userid);
		String bookid=NoteUtil.createId();
		book.setCn_notebook_id(bookid);
		book.setCn_notebook_desc("");
		book.setCn_notebook_type_id("5");
		book.setCn_notebook_create_time(new Timestamp(System.currentTimeMillis()));
		noteBookDao.save(book);
		result.setStatus(0);
		result.setMsg("�����ʼǱ��ɹ�");
		result.setData(bookid);//���½��ıʼǱ���ID����
		return result;
	}
	/**
	 * �ʼǱ���������
	 */
	@Override
	public NoteResult updateNoteBookName(String notebookName, String notebookId) {
		NoteResult result=new NoteResult();
		Map<String, Object> notebook=new HashMap<String,Object>();
		//���ò���
		notebook.put("cn_notebook_id", notebookId);
		notebook.put("cn_notebook_name",notebookName);
		//������
		noteBookDao.updateNoteBookName(notebook);
		result.setStatus(0);
		result.setMsg("�ʼǱ��������ɹ�");
		return result;
	}
	/**
	 * ɾ���ʼǱ�,�ʼǱ�Ϊ�յ������ɾ��
	 */
	@Override
	public NoteResult delNoteBook(String notebookid) {
		NoteResult result=new NoteResult();
		noteBookDao.delete(notebookid);
		result.setStatus(0);
		result.setMsg("ɾ���ʼǱ��ɹ�");
		return result;
	}
	
}
