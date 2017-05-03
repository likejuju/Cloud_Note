package org.ks.note.dao;

import java.util.List;
import java.util.Map;

import org.ks.note.entity.Note;
import org.ks.note.entity.Share;
import org.ks.note.util.IMyBatisUtil;
import org.ks.note.util.PageUtil;

@IMyBatisUtil
public interface ShareDao {
	public List<Share> findByNoteid(String noteid);
	public int insert(Share share);
	//���ݱʼ�id��ȡ�ʼ���Ϣ
	public Note findNoteById(String noteid);
	public int update(Map<String, Object> map);
	//ģ����ѯ
	public List<Share> findByTitle(Map<String, String> map);
	public List<Share> findUsePage(PageUtil page);
}
