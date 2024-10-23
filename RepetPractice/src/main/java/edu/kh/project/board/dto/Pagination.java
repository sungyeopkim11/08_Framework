package edu.kh.project.board.dto;

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
		
		calculate();
	}
	
	public Pagination(int currentPage, int boardListCount, int recordSize, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.boardListCount = boardListCount;
		this.recordSize = recordSize;
		this.pageSize = pageSize;
		
		calculate(); // 필드 계산 메서드 호출
	}


	public int getcurrentPage() {
		return currentPage;
	}


	public int getboardListCount() {
		return boardListCount;
	}


	public int getrecordSize() {
		return recordSize;
	}


	public int getpageSize() {
		return pageSize;
	}


	public int getlastPage() {
		return lastPage;
	}


	public int getstartPage() {
		return startPage;
	}


	public int getendPage() {
		return endPage;
	}


	public int getprevPage() {
		return prevPage;
	}


	public int getnextPage() {
		return nextPage;
	}


	public void setcurrentPage(int currentPage) {
		this.currentPage = currentPage;
		calculate(); // 필드 계산 메서드 호출
	}


	public void setboardListCount(int boardListCount) {
		this.boardListCount = boardListCount;
		calculate(); // 필드 계산 메서드 호출
	}


	public void setrecordSize(int recordSize) {
		this.recordSize = recordSize;
		calculate(); // 필드 계산 메서드 호출
	}


	public void setpageSize(int pageSize) {
		this.pageSize = pageSize;
		calculate(); // 필드 계산 메서드 호출
	}



	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", boardListCount=" + boardListCount + ", recordSize=" + recordSize
				+ ", pageSize=" + pageSize + ", lastPage=" + lastPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + "]";
	}
	
	
	
	/**
	 * 페이징 처리에 필요한 값을 계산해서 
	 * 필드에 대입하는 메서드
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
		
		} else {
			prevPage = startPage - 1;
		}
		
		
		
		// nextPage : ">" 클릭 시 이동할 페이지 번호
		//			 (다음 페이지 번호 목록 중 시작 번호)
		
		// 더 이상 넘어갈 페이지가 없을 경우
		if(endPage == lastPage) {
			nextPage = lastPage;
		
		} else {
			nextPage = endPage + 1;
		}
	}

	
	
}
