package edu.kh.project.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import edu.kh.project.board.dto.Board;
import edu.kh.project.board.dto.Pagination;
import edu.kh.project.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardMapper mapper;

	
	// 게시글 목록 조회
	@Override
	public Map<String, Object> selectBoardList(int boardCode, int cpage) {
		
		// 1) boardCode가 일치하는 게시글의 전체 개수 조회
		int result = mapper.getListCount(boardCode);
		
		// 2) cpage를 이용해서 조회될 목록 페이지, 출력할 
		//   페이지네이션의 값을 계산할 pagination 객체 생성
		Pagination pagination = new Pagination(cpage, result);
		
		// 3) DB에서 cpage에 해당하는 행을 조회
		int recodeSize = pagination.getrecordSize();
		int offset     = (cpage -1) * recodeSize;
		
		RowBounds rowBounds = new RowBounds(offset, recodeSize);
		
		List<Board> boardList = mapper.selectBoardList(boardCode, rowBounds);
		
		// 4) 목록 조회 결과 + Pagination 객체를 Map으로 묶어서 반환
		Map<String, Object> map = Map.of("boardList", boardList, "pagination", pagination);
		
		
		
		
		return map;
	}
	


















}
