package edu.kh.project.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.dto.Member;
import edu.kh.project.member.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
@Slf4j
public class MemberController {

	private final MemberService service;
	
	@PostMapping("login")
	public String memberLogin(
			@RequestParam("memberId") String memberId,
			@RequestParam("memberPw") String memberPw,
			RedirectAttributes ra
			) {
		
//		log.debug(memberId);
//		log.debug(memberPw);
		
		Member loginMember = service.memberLogin(memberId, memberPw);
		
		return "redirect:/";
	}
	












}
