package edu.kh.project.board.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.project.board.service.BoardService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

	private final BoardService service;
	
	/** 게시글 목록 조회
	 * @param boardCode : 게시판 번호
	 * @param cpage : 현재 조회하려는 목록의 페이지 번호 (필수 아님, 없으면 1) 
	 * @param model : forward 시 데이터 전달하는 용도의 객체(request)
	 * @return
	 */
	@GetMapping("{boardCode}")
	public String selectBoardList(
			@PathVariable("boardCode") int boardCode,
			@RequestParam(value = "cpage", required = false, defaultValue = "1") int cpage,
			Model model
			) {
		
		// 서비스 호출 후 결과 반환 받기
	  // - 목록 조회인데 Map으로 반환 받는 이유?
		//  -> 서비스에서 여러 결과를 만들어 내야되는데
		//     메서드는 반환을 1개만 할 수 있기 때문에
		//     Map으로 묶어서 반환 받을 예정
		Map<String, Object> map = service.selectBoardList(boardCode, cpage);
		
		return "board/boardList";
	}
	
	@PostMapping("write")
	public String boardWrite() {
		return "board/boardWrite";
	}
	
	@GetMapping("detail")
	public String boardDetail() {
		return "board/boardDetail";
	}
	
@GetMapping("reportPopup")
public String pop() {
	return "board/reportPopup";
}
















}
