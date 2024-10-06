package edu.kh.project.member.service;


import org.springframework.stereotype.Service;

import edu.kh.project.member.dto.Member;
import edu.kh.project.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

	private final MemberMapper mapper;
	
	
	
	// 로그인
	@Override
	public Member memberLogin(String memberId, String memberPw) {
		
		// 1) memberId가 일치ㅏ는 회원의 정보를 DB에서 조회
		Member loginMember = mapper.memberLogin(memberId);
		
		// 2) 아이디 일치하는 회원 정보가 없을 경우
		if(loginMember == null) return null;
		
		// 3) DB에서 조회된 비밀번호와 입력 받은 비밀 번호가 같은지 확인
//		log.debug("비밀번호 일치 ? : {}", encoder.matches(memberPw, loginMember.getMemberPw()) );
		
		return null;
	}
	











}
