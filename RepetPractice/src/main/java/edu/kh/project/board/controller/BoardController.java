package edu.kh.project.board.controller;

import org.springframework.stereotype.Controller;

import edu.kh.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoardController {

	private final BoardService service;
}
