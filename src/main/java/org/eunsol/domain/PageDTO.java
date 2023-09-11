package org.eunsol.domain;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int total;
	private Criteria cri;
	
	//생성자
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		//전체 체코드 수
		this.total = total;
		//밑에 페이지 나타내는 것.(10페이지씩 보이게 할것이다.)
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0)) * 10;
		this.startPage = this.endPage -9;
		//전체 마지막 게시글 
		 int realEnd = (int) (Math.ceil((total*1.0)/ cri.getAmount()));
		 //마지막 페이지보다 페이징 마지막번호가 크면 페이징 마지막번호에 실제 마지막 번호를 할당
		 if(realEnd < this.endPage) {
			 this.endPage = realEnd;
		 }
		 //시작페이지 번호가 1보다 크면 prev는 true
		 this.prev = this.startPage > 1;
		 //마지막 페이지 번호가 실제 마지막 페이지 번호보다 작으면 next  true
		 this.next = this.endPage < realEnd;
	}
}
