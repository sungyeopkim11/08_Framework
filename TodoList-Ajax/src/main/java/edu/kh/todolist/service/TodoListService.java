package edu.kh.todolist.service;

import java.util.Map;

import edu.kh.todolist.dto.Todo;

public interface TodoListService {

	/** 할 일 목록 조회 + 완료된 할 일 개수
	 * @return map 
	 */
	Map<String, Object> selectTodoList();

	
	/** 할 일 추가
	 * @param todo
	 * @return result
	 */
	int todoAdd(Todo todo);


	/** 상세 조회
	 * @param todoNo
	 * @return todo
	 */
	Todo todoDetail(int todoNo);


	/** 상세 조회
	 * @param todoNo
	 * @return
	 */
	int todoComplete(int todoNo);


	/** 수정
	 * @param todoNo
	 * @return
	 */
	int updateTodo(Todo todo);


	/** 할 일 삭제
	 * @param todoNo
	 * @return result	
	 */
	int todoDelete(int todoNo);


	String searchTitle(int todoNo);

}
