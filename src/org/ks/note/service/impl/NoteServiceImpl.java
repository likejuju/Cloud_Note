package org.ks.note.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.ks.note.dao.NoteDao;
import org.ks.note.entity.Note;
import org.ks.note.entity.Share;
import org.ks.note.service.NoteService;
import org.ks.note.util.NoteResult;
import org.ks.note.util.NoteUtil;
import org.springframework.stereotype.Service;

@Service("noteService")
public class NoteServiceImpl implements NoteService{
	private NoteDao noteDao;
	public NoteDao getNoteDao() {
		return noteDao;
	}
	@Resource(name="noteDao")
	public void setNoteDao(NoteDao noteDao) {
		this.noteDao = noteDao;
	}

	/**
	 * ���ݱʼǱ�ID��ѯ�ʼ�
	 */
	@Override
	public NoteResult loadNotes(String bookid) {
		// TODO Auto-generated method stub
		NoteResult result=new NoteResult();
		List<Note> notes=noteDao.findByNoteBookId(bookid);
		if(notes.size()>0){
			result.setStatus(0);
			result.setMsg("��ѯ�ʼǳɹ�");
			result.setData(notes);
			return result;
		}else{
			result.setStatus(1);
			result.setMsg("��ѯ�ʼ��쳣");
			result.setData(null);
			return result;
		}
	}
	/**
	 * ���ݱʼ�id��ѯ�ʼ���Ϣ
	 */
	@Override
	public NoteResult loadBody(String noteid) {
		NoteResult result=new NoteResult();
		Note note=noteDao.findByNoteId(noteid);
		if(note!=null){
			result.setStatus(0);
			result.setMsg("���رʼ����ݳɹ�");
			result.setData(note);
			return result;
		}else{
			result.setStatus(1);
			result.setMsg("���رʼ������쳣");
			result.setData(null);
			return result;
		}
	}
	/**
	 * ���һ���ʼ�
	 */
	@Override
	public NoteResult add(String bookid, String userid, String title) {
		// TODO Auto-generated method stub
		Note note=new Note();
		note.setCn_note_body("");
		note.setCn_note_create_time(System.currentTimeMillis());
		String noteid=NoteUtil.createId();
		note.setCn_note_id(noteid);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		note.setCn_note_status_id("1");
		note.setCn_note_title(title);
		note.setCn_note_type_id("5");
		note.setCn_notebook_id(bookid);
		note.setCn_user_id(userid);
		noteDao.save(note);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setMsg("��ӱʼǳɹ�");
		result.setData(noteid);
		return result;
	}
	/**
	 * ���±ʼǵı��������
	 */
	@Override
	public NoteResult update(String noteid, String title, String body) {
		Map<String, Object> note=new HashMap<String, Object>();
		note.put("cn_note_title", title);
		note.put("cn_note_body", body);
		note.put("cn_note_last_modify_time", System.currentTimeMillis());
		note.put("cn_note_id", noteid);
		noteDao.modify(note);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setMsg("����ɹ�");
		return result;
	}
	/**
	 * ���±ʼ�״̬,�� ���ʼǷ������վ
	 */
	@Override
	public NoteResult updateStatus(String noteid) {
		NoteResult result=new NoteResult();
		noteDao.updateStatus(noteid);
		result.setStatus(0);
		result.setMsg("�ʼ��ѷ������վ");
		result.setData(null);
		return result;
	}
	/**
	 * �ƶ��ʼǣ����±ʼǵ�cn_notebook_id
	 */
	@Override
	public NoteResult moveNote(String noteid, String bookid) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("cn_note_id", noteid);
		map.put("cn_notebook_id", bookid);
		map.put("cn_note_last_modify_time", System.currentTimeMillis());
		noteDao.move(map);//�ƶ��ʼ�
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setMsg("�ƶ��ʼǳɹ�");
		return result;
	}
	/**
	 * ��ѯ����վ�ʼ�
	 */
	@Override
	public NoteResult loadDisableNotes(String userid) {
		NoteResult result=new NoteResult();
		List<Note> notes=noteDao.findDisableNote(userid);
		result.setStatus(0);
		result.setData(notes);
		return result;
	}
	/**
	 * ����ɾ���ʼ�
	 */
	@Override
	public NoteResult delete(String noteid) {
		NoteResult result=new NoteResult();
		noteDao.delete(noteid);
		result.setStatus(0);
		return result;
	}
	/**
	 * �ָ��ʼ�
	 */
	@Override
	public NoteResult replay(String bookid, String noteid) {
		NoteResult result=new NoteResult();
		Map<String,String> map=new HashMap<String,String>();
		map.put("cn_notebook_id", bookid);//���ò���
		map.put("cn_note_id", noteid);
		noteDao.replayNote(map);//�ָ��ʼ�
		result.setStatus(0);
		result.setMsg("�ָ��ʼǳɹ�");
		return result;
	}
	/**
	 * ���ݱʼ�ID��ȡ������еıʼ���Ϣ
	 */
	@Override
	public Share findByNoteIdFromShare(String noteid) {
		Share share=noteDao.findByNoteIdFromShare(noteid);
		return share;
	}
	/**
	 * ����ղرʼǵ��ղر�
	 */
	@Override
	public NoteResult addLike(String noteid,String userid) {
		NoteResult result=new NoteResult();
		Share share=findByNoteIdFromShare(noteid);
		Note note=new Note();
		String id=NoteUtil.createId();
		note.setCn_note_body(share.getCn_share_body());
		note.setCn_note_create_time(System.currentTimeMillis());
		note.setCn_note_id(id);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		note.setCn_note_status_id("3");
		note.setCn_note_title(share.getCn_share_title());
		note.setCn_note_type_id("5");
		note.setCn_user_id(userid);
		noteDao.save(note);//����
		result.setStatus(0);
		result.setMsg("�ղسɹ�");
		return result;
	}
	/**
	 * �����û�ID��ѯ
	 */
	@Override
	public NoteResult findByUserid(String userid) {
		NoteResult result=new NoteResult();
		List<Note> notes=noteDao.findByUserid();
		System.err.println(notes.size());
		result.setStatus(0);
		result.setData(notes);
		return result;
	}
}
