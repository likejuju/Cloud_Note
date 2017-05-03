package org.ks.note.controller.note;

import javax.annotation.Resource;

import org.ks.note.service.NoteService;
import org.ks.note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class NoteController {
	private NoteService noteService;
	public NoteService getNoteService() {
		return noteService;
	}
	@Resource(name="noteService")
	public void setNoteService(NoteService noteService) {
		this.noteService = noteService;
	}
	/**
	 * ���ݱʼǱ�ID��ѯ�ʼ��б�,����json��ʽ����
	 * @param bookid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("loadNotes.do")
	public NoteResult loadNotes(String bookid){
		System.err.println(bookid);
		return noteService.loadNotes(bookid);
	}
	/**
	 * ���ݱʼ�ID��ѯ�ʼ�
	 * @param noteid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("loadBody.do")
	public NoteResult loadBody(String noteid){
//		System.err.println(noteid);
		return noteService.loadBody(noteid);
	}
	/**
	 * ���ػ���վ�ʼ�
	 * @param userid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("loadDisableNotes.do")
	public NoteResult loadDisableNote(String userid){
		return noteService.loadDisableNotes(userid);
	}
	/**
	 * ����ɾ���ʼ�
	 * @param noteid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteRollbackNote.do")
	public NoteResult deleteRollbackNote(String noteid){
		return noteService.delete(noteid);
	}
	/**
	 * �ָ��ʼ�
	 * @param bookid
	 * @param noteid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("sureReplay.do")
	public NoteResult sureReplay(String bookid,String noteid){
		return noteService.replay(bookid, noteid);
	}
}
