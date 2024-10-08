package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 요청응답 ㅈ[어하는 Controller 역할 명시 + Bean 등록
public class MainController {
	
	@RequestMapping("/") // "/" 요청 매핑(method 가리지 않음)
	public String mainPage() {
		
		// 접두사 : classpath:/templates/
		// 접미사 : .html
		// -> forward 하ㅕ는 파일의 ThymeLeaf
		//   접미사, 접두사를 제외한 경로 작성
		
		return "common/main";
	}
	
}
