package edu.kh.project.board.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.kh.project.board.dto.Comment;
import edu.kh.project.board.service.CommentService;
import edu.kh.project.member.dto.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController // @Controller + @ResponseBody
                // 비동기 요청 처리 전용 컨트롤러
               //  return 되는 모든 값을 있는 그대로 호출부로 반환
@RequiredArgsConstructor
@Slf4j
public class CommentController {

	private final CommentService service;
	
	
	
	/** 댓글 삽입
	 * @param comment : 요청 시 body에 JSON 형태로 담겨져 제출된 데이터를
	 *                 HTTPMessageConverter가 DTO로 변환한 객체
	 *                 (boardNo, commentContent, parentCommentNo)
	 * @param loginMember : 로그인한 회원 정보
	 * @return commentNo : 삽입된 댓글 번호
	 */
	@PostMapping("comment") // POST == CREATE/INSERT 의미
	public int commentInsert(
			@RequestBody Comment comment,
			@SessionAttribute("loginMember") Member loginMember
			) {
		
		// 로그인된 회원 번호를 comment에 세팅
		comment.setMemberNo(loginMember.getMemberNo());
		
		return service.commentInsert(comment);
	}
	
	/** 댓글 수정
	 * @return
	 */
	@PutMapping("comment")
	public int commentUpdate(
			@RequestBody Comment comment,
			@SessionAttribute("loginMember") Member loginMember
			) { // PUT == UPDATE
		
		comment.setMemberNo(loginMember.getMemberNo());
		
		return service.commentUpdate(comment);
	}
	
	
	/** 댓글 삭제
	 * @param commentNo : 삭제하려는 댓글 번호
	 * @param loginMember : 로그인한 회원 정보
	 * @return
	 */
	@DeleteMapping("comment") // DELETE == DELETE
	public int commentDelete(
			@RequestBody int commentNo,
			@SessionAttribute("loginMember") Member loginMember
			) { 
		return service.commentDelete(commentNo, loginMember.getMemberNo());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
