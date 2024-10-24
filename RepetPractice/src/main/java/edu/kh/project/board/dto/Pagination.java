package edu.kh.project.board.dto;

/* Pagination 뜻 : 목록을 일정 페이지로 분할해서
 *                원하는 페이지를 볼 수 있게 하는 것
 *                == 페이징 처리
 *                
 *  Pagination 객체 : 페이징 처리에 필요한 값을 모아두고, 계산하는 객체
 */

public class Pagination {

	private int page;		// 현재 페이지 번호
	private int listCount;			// 전체 게시글 수
	
	private int recordSize = 5;			// 한 페이지 목록에 보여지는 게시글 수
	private int pageSize = 5;		// 보여질 페이지 번호 개수
	
	private int maxPage;			// 마지막 페이지 번호
	private int startPage;			// 보여지는 맨 앞 페이지 번호 
	private int endPage;			// 보여지는 맨 뒤 페이지 번호
	
	private int prevPage;			// 이전 페이지 모음의 마지막 번호 
	private int nextPage;			// 다음 페이지 모음의 시작 번호 
	

	//기본 생성자 X
	
	public Pagination(int page, int listCount) {
		super();
		this.page = page;
		this.listCount = listCount;
		
		calculate();
	}
	
	public Pagination(int page, int listCount, int recordSize, int pageSize) {
		super();
		this.page = page;
		this.listCount = listCount;
		this.recordSize = recordSize;
		this.pageSize = pageSize;
		
		calculate(); // 필드 계산 메서드 호출
	}


	public int getpage() {
		return page;
	}


	public int getListCount() {
		return listCount;
	}


	public int getrecordSize() {
		return recordSize;
	}


	public int getPageSize() {
		return pageSize;
	}


	public int getMaxPage() {
		return maxPage;
	}


	public int getStartPage() {
		return startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public int getPrevPage() {
		return prevPage;
	}


	public int getNextPage() {
		return nextPage;
	}


	public void setpage(int page) {
		this.page = page;
		calculate(); // 필드 계산 메서드 호출
	}


	public void setListCount(int listCount) {
		this.listCount = listCount;
		calculate(); // 필드 계산 메서드 호출
	}


	public void setrecordSize(int recordSize) {
		this.recordSize = recordSize;
		calculate(); // 필드 계산 메서드 호출
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		calculate(); // 필드 계산 메서드 호출
	}



	@Override
	public String toString() {
		return "Pagination [page=" + page + ", listCount=" + listCount + ", recordSize=" + recordSize
				+ ", pageSize=" + pageSize + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + "]";
	}


	
	/**
	 * 페이징 처리에 필요한 값을 계산해서 
	 * 필드에 대입하는 메서드
	 * (maxPage, startPage, endPage, prevPage, nextPage)
	 */
	private void calculate() {
		
		// maxPage : 최대 페이지 == 마지막 페이지 == 총 페이지 수
		
		// 한 페이지에 게시글이 5개씩 보여질 경우
		// 게시글 수 : 100개 -> 20 page
		// 게시글 수 : 96개 -> 20 page
		// 게시글 수 : 95개 -> 19 page
		
		maxPage = (int)Math.ceil( (double)listCount/recordSize );
		// 전체 게시글 수 / 한 페이지 목록에 보여지는 게시글 수
		
		// startPage : 페이지 번호 목록의 시작 번호
		
		// 페이지 번호 목록이 5개(pageSize)씩 보여질 예정
		
		// 현재 페이지가 1 ~ 5 : 1 page
		// 현재 페이지가 6 ~ 10 : 6 page
		startPage = (page - 1) / pageSize * pageSize + 1;
		
		// endPage : 페이지 번호 목록의 끝 번호
		
		// 현재 페이지가 1 ~ 5 : 5 page
		endPage = pageSize - 1 + startPage;
		
		// prevPage : "<" 클릭 시 이동할 페이지 번호
		//            (이전 페이지 번호 목록 중 끝 번
		
		// 페이지 끝 번호가 최대 페이지 수를 초과한 경우
		if(endPage > maxPage) endPage = maxPage;
		
		if(page < pageSize) {
			prevPage = 1;
		
		} else {
			prevPage = startPage - 1;
		}
		
		
		// 더 이상 넘어갈 페이지가 없을 경우
		if(endPage == maxPage) {
			nextPage = maxPage;
		
		} else {
			nextPage = endPage + 1;
		}
		
	}







































}
