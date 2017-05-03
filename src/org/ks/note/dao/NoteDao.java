package org.ks.note.dao;

import java.util.List;
import java.util.Map;

import org.ks.note.entity.Note;
import org.ks.note.entity.Share;
import org.ks.note.util.IMyBatisUtil;

@IMyBatisUtil
public interface NoteDao {
	//���ݱʼǱ�ID��ѯ��ǰ�ʼǱ��еıʼ�
	public List<Note> findByNoteBookId(String bookid);
	//���ݱʼ�ID��ѯ�ʼ�
	public Note findByNoteId(String noteid);
	//����ʼ�
	public int save(Note note);
	//����ʼ�
	public int modify(Map<String, Object> map);
	//���ʼǷ������վ
	public int updateStatus(String noteid);
	//�ƶ��ʼǣ����±ʼǵ�cn_notebook_id
	public int move(Map<String, Object> map);
	//��ѯ����վ�ʼ�
	public List<Note> findDisableNote(String userid);
	//����ɾ���ʼ�
	public int delete(String noteid);
	//�ָ��ʼ�
	public int replayNote(Map<String,String> map);
	//���ݱʼ�ID��ȡ������еıʼ���Ϣ
	public Share findByNoteIdFromShare(String noteid);
	public List<Note> findByUserid();
}
