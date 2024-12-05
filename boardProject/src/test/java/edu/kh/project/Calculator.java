package edu.kh.project;

public class Calculator {
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public int subtract(int a, int b) {
		return a - b;
	}
	
	public int multiply(int a, int b) {

		return a * b;

		}
	
	public int divide(int a, int b) throws IllegalAccessException {
		
		if(b == 0) {
			// IllegalAccessException : 매개변수가 옳지 않음
			throw new IllegalAccessException("0으로 나머지 붙음");
		}
		
		return a / b;
	}

}
