package edu.kh.project.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.kh.project.member.dto.Member;


@Mapper // 인터페이스 상속 클래스
public interface MainMapper {

	
	/** 전체 회원 조회
	 * @return
	 */
	List<Member> selectMemberList();

	// 빠른 로그인
	Member directLogin(int memberNo);

	// 비밀번호 초기화
	int resetPw(
			@Param("memberNo") int memberNo, 
			@Param("enc") String enc);

	// 탈퇴 유뮤 변경
	int changeStatus(int memberNo);






















}
