package org.ks.note.controller.note;

import javax.annotation.Resource;

import org.ks.note.service.ShareService;
import org.ks.note.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class ShareController {
	private ShareService shareService;
	public ShareService getShareService() {
		return shareService;
	}
	@Resource(name="shareService")
	public void setShareService(ShareService shareService) {
		this.shareService = shareService;
	}
	/**
	 * ��֤�ʼ��Ƿ�����
	 * �����������͸��·���
	 * ���û�У���ִ������Ĳ������ĺ���
	 * @param noteid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateShare.do")
	public NoteResult updateShare(String noteid){
		System.err.println(noteid);
		return shareService.findByNoteid(noteid);
	}
	/**
	 * ����ʼǣ�����һ������
	 * @param noteid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("shareNote.do")
	public NoteResult shareNote(String noteid){
		return shareService.shareNote(noteid);
	}
	/**
	 * ���ݱʼǱ���ģ����ѯ
	 */
	@ResponseBody
	@RequestMapping("searchNote.do")
	public NoteResult searchNote(String title){
		System.err.println(title);
		NoteResult result=shareService.loadNoteByTitle(title);
		return result;
	}
}
