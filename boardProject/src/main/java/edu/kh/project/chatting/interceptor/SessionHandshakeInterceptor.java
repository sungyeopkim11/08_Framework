package edu.kh.project.chatting.interceptor;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import jakarta.servlet.http.HttpSession;

/** SessionHandshakeInterceptor
 * - websoketHandler(웹소켁 동작 객체) 길핼 전.후에
 *  연결된 클라이언트의 HTTP 세션을 가로채서
 *  Websoket에서 사용 가능한 형태로 변환하는 객체
 * 
 */

@Component // 빈 등록
public class SessionHandshakeInterceptor implements HandshakeInterceptor {

	// 핸들러 동작 전 가로채기
	@Override
	public boolean beforeHandshake(
			ServerHttpRequest request, 
			ServerHttpResponse response, 
			WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		
			// ServerHttpRequest   : HttpServletRequest의 부모 인터페이스
			// ServerHttpResponse  : HttpServletResponse의 부모 인터페이스
			
			// attributes : 해당 맵에 세팅된 속성(데이터)은
			//				다음에 동작할 Handler 객체에게 전달됨
			// (HandshackeInterceptor -> Handler 데이터 전달하는 역할)
		
		// ServletServerHttpRequest 상속 관계가 맞을 경우
		if(request instanceof ServletServerHttpRequest) {
			
			// 다운 캐스팅
			ServletServerHttpRequest serverRequest
				= (ServletServerHttpRequest) request;
			
			// HTTP session 얻어오기
			HttpSession session = serverRequest.getServletRequest().getSession();
			
			attributes.put("session", session);
			
		}
		
		return true; // 가로챈 데이터를 핸들러로 전달할지 결정
	}
	
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		
	}
















}
