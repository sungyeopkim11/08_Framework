package edu.kh.project.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter


@AllArgsConstructor
@NoArgsConstructor

@ToString
@Builder
public class Board {


//BOARD 테이블 컬럼과 매핑되는 필드

//행 번호
	private int rnum;
	
	// BOARD 테이블 컬럼과 매핑되는 필드

	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriteDate;
	private String boardUpdateDate;
	private int readCount;
	private String boardDelFl;
	private int memberNo;
	private int boardCode;
	
}
