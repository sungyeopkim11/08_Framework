package edu.kh.project.board.dto;

<<<<<<< HEAD
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
=======
public class Pagination {
	
	private int currentPage; // 현재 페이지 번호
	private int boardListCount; // 전체 게시글 수
	
	private int recordSize = 10; // 한 페이지에 보여질 게시글 수
	private int pageSize = 5; // 화면 하단에 출력할 페이지 사이즈
	
	private int lastPage;
	private int startPage;
	private int endPage;
	
	private int prevPage;
	private int nextPage;
	
	public Pagination(int currentPage, int boardListCount) {
		super();
		this.currentPage = currentPage;
		this.boardListCount = boardListCount;
>>>>>>> 68245c4d9801f48ca384be814054882a47d4a80e
		
		calculate();
	}
	
<<<<<<< HEAD
	public Pagination(int page, int listCount, int recordSize, int pageSize) {
		super();
		this.page = page;
		this.listCount = listCount;
=======
	public Pagination(int currentPage, int boardListCount, int recordSize, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.boardListCount = boardListCount;
>>>>>>> 68245c4d9801f48ca384be814054882a47d4a80e
		this.recordSize = recordSize;
		this.pageSize = pageSize;
		
		calculate(); // 필드 계산 메서드 호출
	}


<<<<<<< HEAD
	public int getpage() {
		return page;
	}


	public int getListCount() {
		return listCount;
=======
	public int getcurrentPage() {
		return currentPage;
	}


	public int getboardListCount() {
		return boardListCount;
>>>>>>> 68245c4d9801f48ca384be814054882a47d4a80e
	}


	public int getrecordSize() {
		return recordSize;
	}


<<<<<<< HEAD
	public int getPageSize() {
=======
	public int getpageSize() {
>>>>>>> 68245c4d9801f48ca384be814054882a47d4a80e
		return pageSize;
	}


<<<<<<< HEAD
	public int getMaxPage() {
		return maxPage;
	}


	public int getStartPage() {
=======
	public int getlastPage() {
		return lastPage;
	}


	public int getstartPage() {
>>>>>>> 68245c4d9801f48ca384be814054882a47d4a80e
		return startPage;
	}


<<<<<<< HEAD
	public int getEndPage() {
=======
	public int getendPage() {
>>>>>>> 68245c4d9801f48ca384be814054882a47d4a80e
		return endPage;
	}


<<<<<<< HEAD
	public int getPrevPage() {
=======
	public int getprevPage() {
>>>>>>> 68245c4d9801f48ca384be814054882a47d4a80e
		return prevPage;
	}


<<<<<<< HEAD
	public int getNextPage() {
=======
	public int getnextPage() {
>>>>>>> 68245c4d9801f48ca384be814054882a47d4a80e
		return nextPage;
	}


<<<<<<< HEAD
	public void setpage(int page) {
		this.page = page;
=======
	public void setcurrentPage(int currentPage) {
		this.currentPage = currentPage;
>>>>>>> 68245c4d9801f48ca384be814054882a47d4a80e
		calculate(); // 필드 계산 메서드 호출
	}


<<<<<<< HEAD
	public void setListCount(int listCount) {
		this.listCount = listCount;
=======
	public void setboardListCount(int boardListCount) {
		this.boardListCount = boardListCount;
>>>>>>> 68245c4d9801f48ca384be814054882a47d4a80e
		calculate(); // 필드 계산 메서드 호출
	}


	public void setrecordSize(int recordSize) {
		this.recordSize = recordSize;
		calculate(); // 필드 계산 메서드 호출
	}


<<<<<<< HEAD
	public void setPageSize(int pageSize) {
=======
	public void setpageSize(int pageSize) {
>>>>>>> 68245c4d9801f48ca384be814054882a47d4a80e
		this.pageSize = pageSize;
		calculate(); // 필드 계산 메서드 호출
	}



	@Override
	public String toString() {
<<<<<<< HEAD
		return "Pagination [page=" + page + ", listCount=" + listCount + ", recordSize=" + recordSize
				+ ", pageSize=" + pageSize + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + "]";
	}


=======
		return "Pagination [currentPage=" + currentPage + ", boardListCount=" + boardListCount + ", recordSize=" + recordSize
				+ ", pageSize=" + pageSize + ", lastPage=" + lastPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + "]";
	}
	
	
>>>>>>> 68245c4d9801f48ca384be814054882a47d4a80e
	
	/**
	 * 페이징 처리에 필요한 값을 계산해서 
	 * 필드에 대입하는 메서드
<<<<<<< HEAD
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
=======
	 * (lastPage, startPage, endPage, prevPage, nextPage)
	 */
	private void calculate() {
		
		
		// lastPage : 최대 페이지 == 마지막 페이지 == 총 페이지 수
		
		// 한 페이지에 게시글이 10개씩 보여질 경우
		//  게시글 수 :  95개 -> 10 currentPage 
		//  게시글 수 : 100개 -> 10 currentPage
		//  게시글 수 : 101개 -> 11 currentPage
		
		lastPage = (int)Math.ceil( (double)boardListCount / recordSize );
		
		
		// startPage : 페이지 번호 목록의 시작 번호
		
		// 페이지 번호 목록이 10개(pageSize) 씩 보여질 경우
		
		// 현재 페이지가  1 ~ 10 :   1 currentPage
		// 현재 페이지가 11 ~ 20 :  11 currentPage
		startPage = (currentPage - 1) / pageSize * pageSize + 1;
		
		
		
		// endPage : 페이지 번호 목록의 끝 번호
		
		// 현재 페이지가  1 ~ 10 :  10 currentPage
		// 현재 페이지가 11 ~ 20 :  20 currentPage
		// 현재 페이지가 21 ~ 30 :  30 currentPage
		endPage = pageSize - 1 + startPage;
		
		
		// 페이지 끝 번호가 최대 페이지 수를 초과한 경우
		if(endPage > lastPage)	endPage = lastPage;
		
		
		
		
		// prevPage : "<" 클릭 시 이동할 페이지 번호
		//			 (이전 페이지 번호 목록 중 끝 번호)
		
		// 더 이상 뒤로갈 페이지가 없을 경우
		if(currentPage < pageSize) {
			prevPage = 1; 
>>>>>>> 68245c4d9801f48ca384be814054882a47d4a80e
		
		} else {
			prevPage = startPage - 1;
		}
		
		
<<<<<<< HEAD
		// 더 이상 넘어갈 페이지가 없을 경우
		if(endPage == maxPage) {
			nextPage = maxPage;
=======
		
		// nextPage : ">" 클릭 시 이동할 페이지 번호
		//			 (다음 페이지 번호 목록 중 시작 번호)
		
		// 더 이상 넘어갈 페이지가 없을 경우
		if(endPage == lastPage) {
			nextPage = lastPage;
>>>>>>> 68245c4d9801f48ca384be814054882a47d4a80e
		
		} else {
			nextPage = endPage + 1;
		}
<<<<<<< HEAD
		
	}







































=======
	}

	
	
>>>>>>> 68245c4d9801f48ca384be814054882a47d4a80e
}
