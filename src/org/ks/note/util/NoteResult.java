package org.ks.note.util;

/**
 * ��Ϊ�������������ݸ�ʽ��Լ���Ķ���
 * @author Cappuccino
 *
 */
public class NoteResult {
	private Integer status;//���ص�״̬
	private String msg;//���ص���Ϣ
	private Object data;//���ص�����
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
