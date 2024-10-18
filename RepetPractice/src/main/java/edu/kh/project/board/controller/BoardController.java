package edu.kh.project.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
<<<<<<< HEAD

=======
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> cfcfca52c48a4558b2b27fd239ad7cd6a26e6446
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
	
	@PostMapping("write")
	public String boardWrite() {
		return "board/boardWrite";
	}

















}
