package org.ks.note.util;

public class PageUtil {
	private int currentPage;//�ڼ�ҳ
	private int pageSize;//ÿҳ��¼��
	
	public int getBegin(){
		int begin=(currentPage-1)*pageSize;
		return begin;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
