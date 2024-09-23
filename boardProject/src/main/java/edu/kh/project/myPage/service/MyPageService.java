package edu.kh.project.myPage.service;

import edu.kh.project.member.dto.Member;

public interface MyPageService {

	int updateInfo(Member inputmember);

	/** (비동기) 닉네임 중복 검사
	 * @param input
	 * @return
	 */
	int checkNickname(String input);

	
	/** 비밀번호 변경
	 * @param currentPw
	 * @param newPw
	 * @param loginMember
	 * @return result
	 */
	int changePw(String currentPw, String newPw, Member loginMember);

	
	/** 회원 탈퇴
	 * @param memberPw
	 * @param loginMember
	 * @return
	 */
	int secession(String memberPw, Member loginMember);

}
