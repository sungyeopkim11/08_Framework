package edu.kh.project.board.service;

import java.util.Map;

public interface BoardService {

	/** 게시글 목록 조회
	 * @param boardCode
	 * @param cpage
	 * @return map
	 */
	Map<String, Object> selectBoardList(int boardCode, int cpage);

}
