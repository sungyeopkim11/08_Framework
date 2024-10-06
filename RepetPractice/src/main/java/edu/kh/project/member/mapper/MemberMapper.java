package edu.kh.project.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.dto.Member;

@Mapper
public interface MemberMapper {

	/** 로그인 
	 * @param memberId
	 * @return
	 */
	Member memberLogin(String memberId);

}
