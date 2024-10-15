package edu.kh.project.board.controller;

import org.springframework.stereotype.Controller;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> fb0d019497f5bffa427d496b24ee6ed5fefd859a
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

	private final BoardService service;
	
	@GetMapping("boardCode")
	public String selectBoardList(
			
			) {
		
		return "board/boardList";
	}
}
