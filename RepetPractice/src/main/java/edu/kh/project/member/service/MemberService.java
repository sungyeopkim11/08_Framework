package edu.kh.project.member.service;

import edu.kh.project.member.dto.Member;

public interface MemberService {

	/** 로그인
	 * @param memberId
	 * @param memberPw
	 * @return
	 */
	Member memberLogin(String memberId, String memberPw);

}
