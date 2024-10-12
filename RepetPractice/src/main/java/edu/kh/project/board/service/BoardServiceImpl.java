package edu.kh.project.board.service;

import org.springframework.stereotype.Service;

import edu.kh.project.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardMapper mapper;
}
