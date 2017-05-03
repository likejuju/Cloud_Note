package org.ks.note.controller.note;

import javax.annotation.Resource;

import org.ks.note.service.NoteService;
import org.ks.note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class AddNoteController {
	private NoteService noteService;
	public NoteService getNoteService() {
		return noteService;
	}
	@Resource(name="noteService")
	public void setNoteService(NoteService noteService) {
		this.noteService = noteService;
	}
	/**
	 * ���һ���ʼ�
	 * @param bookid
	 * @param userid
	 * @param title
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add.do")
	public NoteResult add(String bookid,String userid,String title){
		return noteService.add(bookid, userid, title);
	}
	/**
	 * �ղرʼ�
	 * @param noteid
	 * @param userid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addLike.do")
	public NoteResult addLike(String noteid,String userid){
		return noteService.addLike(noteid, userid);
	}
	/**
	 * ��ʾ�ղصıʼ�
	 */
	@ResponseBody
	@RequestMapping("showLike.do")
	public NoteResult showLike(String userid){
		return noteService.findByUserid(userid);
	}
	
}
