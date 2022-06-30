package com.exam.exspring.bbs;

public class BbsVo {

	//게시글목록(글번호, 글제목, 작성자, 작성일) bbs/list.do
	//게시글추가(글제목, 글내용, 작성자)/bbs/add.do
	//게시글 변경(제목, 내용)/bbs/edit.do
	//게시글 삭제 ( 변경화면에 삭제버튼 클릭시) bbs/del.do
	//BbsController, BbsService, BbsServiceImpl, BbsDao,
	//BbsMapper.xml
	//bbsList.jsp,bbsAdd.jsp, bbsEdit.jsp
	
	
	
	
        private int bbsNo;
        private String bbsTitle;
        private String bbsContent;
        private String bbsWrit; 
		public int getBbsNo() {
			return bbsNo;
		}
		public void setBbsNo(int bbsNo) {
			this.bbsNo = bbsNo;
		}
		public String getBbsTitle() {
			return bbsTitle;
		}
		public void setBbsTitle(String bbsTitle) {
			this.bbsTitle = bbsTitle;
		}
		public String getBbsContent() {
			return bbsContent;
		}
		public void setBbsContent(String bbsContent) {
			this.bbsContent = bbsContent;
		}
		public String getBbsWrit() {
			return bbsWrit;
		}
		public void setBbsWrit(String bbsWrit) {
			this.bbsWrit = bbsWrit;
		}
		public String getBbsRegDate() {
			return bbsRegDate;
		}
		public void setBbsRegDate(String bbsRegDate) {
			this.bbsRegDate = bbsRegDate;
		}
		public String getBbsCount() {
			return bbsCount;
		}
		public void setBbsCount(String bbsCount) {
			this.bbsCount = bbsCount;
		}
		private String bbsRegDate; 
		private String bbsCount;

	}


