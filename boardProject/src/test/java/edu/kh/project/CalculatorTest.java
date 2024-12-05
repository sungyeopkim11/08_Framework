package edu.kh.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

// 클래스 단위로 테스트를 수행
// - 내부 모든 메서드 테스트 수행
@Slf4j
public class CalculatorTest {
	
	// 테스트에 사용할 객체 필드에 생성
	private Calculator calculator = new Calculator();

	@BeforeAll // 모든 메서드 테스트가 수행되기 전에 실행, 무조건 static
	public static void setUp() {
		log.info("테스트 시작!");
	}
	
	@AfterAll // 모든 메서드 테스트가 수행된 후 실행, 무조건 static
	public static void tearDown() {
		log.info("모든 테스트 완료!");
	}
	
	@Test // 테스트를 수행할 메서드에 작성하는 어노테이션
	public void testadd() {
		
		// calculator.add(10, 20) 의 결과가 30과 같은지 테스트
		assertEquals(5, calculator.add(2, 3));
		 // 10 + 20 = 30
	}
	
	
	@Test
	public void testSubtract() {
		assertEquals(1, calculator.subtract(3, 2));
	}
	
	@Test

	public void testMultiply() {

	assertEquals(6, calculator.multiply(2, 3));

	}
	
	
	@Test
	public void testDivide() throws IllegalAccessException {
		assertEquals(2, calculator.divide(6, 3));
	}

	@Test
	public void testDivideByZero() {
		// assertThrows(예외, 람다식) 메서드에서 지정된 예외가 발생하는지 확인
		assertThrows(IllegalAccessException.class,() -> calculator.divide(8, 1));
		// 0으로 나누면 성공
		// 0이 아닌 수 또는 던져진 예외가 다르면 실패
	}







}
