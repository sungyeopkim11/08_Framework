package edu.kh.project.myPage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.kh.project.member.dto.Member;

//@Mapper
//- Mybatis 제공 어노테이션
//- 해당 인터페이스를 상속 받은 클래스 자동 구현 +  Bean 등록

@Mapper // 상속 받은 클래스 자동 구현 +  Bean 등록
public interface MyPageMapper {

	/** 화원 정보 수정
	 * @param inputMember
	 * @return
	 */
	int updateInfo(Member inputMember);

	/* (비동기) 닉네임 중복 검사
	 * @param input
	 * @return
	 */
	int checkNickname(String input);

	
	/** 비밀번호 변경
	 * @param memberPw
	 * @param encPw
	 * @return result
	 */
	int changePw(
			@Param("memberNo")int memberNo,
			@Param("encPw") String encPw);

	
	/** 회원 탈퇴
	 * @param memberPw
	 * @param memberNo
	 * @return
	 */
	int secession(int memberNo);
	
	/* 마이바티스 Mapper 인터페이스 메서드 호출 시
	 * 별도의 어노테이션이 없다면
	 * 첫 번째 매개 변수 만
	 * mapper.xml 파일에 전달되는 parameter로 인식된다!
	 * 
	 * [해결 방법]
	 * 1. DTO, 컬렉션을 이용해 묶어서 전달
	 * 2. @Param 어노테이션을 이용해 파라미터로 인식
	 * 
	 * @Param("Key") 자료형 변수명
	 * - SQL 중 #{KEY} 자리에 들어가 값을 지정
	 */
























}
