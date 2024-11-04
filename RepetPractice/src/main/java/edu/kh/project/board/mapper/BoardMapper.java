package edu.kh.project.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import edu.kh.project.board.dto.Board;

@Mapper
public interface BoardMapper {

	
	/** boardCode가 일치하는 게시글의 전체 개수 조회
	 * @param boardCode
	 * @return result
	/** boardCode가 일치하는 게시글 전체 대수 조회
	 * @param boardCode
	 * @return
	 */
	int getListCount(int boardCode);

	
	/**
	 * 
	 * @param boardCode
	 * @param rowBounds
	/** 지정된 페이지 분량의 게시글 목록 조
	 * @param rowBounds
	 * @param boardCode
	 * @return
	 */
	List<Board> selectBoardList(int boardCode, RowBounds rowBounds);
	
}
