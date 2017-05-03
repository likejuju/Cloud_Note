package org.ks.note.service;

import org.ks.note.entity.Note;
import org.ks.note.util.NoteResult;
import org.ks.note.util.PageUtil;

public interface ShareService {
	//���ݱʼ�id��ȡ����ʼ���Ϣ
	public NoteResult findByNoteid(String noteid);
	//����ʼǣ�����һ������ʼ�
	public NoteResult shareNote(String noteid);
	//���ݱʼ�id��ȡ�ʼ���Ϣ
	public Note findNoteById(String id);
	//�ʼ��Ѿ������ʱ��ִ�и��±ʼǲ���
	public void update(String noteid);
	public NoteResult loadNoteByTitle(String cn_share_title);
	public NoteResult findUsePage(PageUtil page);
}
