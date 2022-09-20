package com.example.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @ : 어노테이션
// ctrl + F11 실행 할 때 spring 엔진이 class에 있는 어노테이션을 스캔한다. (없으면 작동 안함)
@RestController
public class HomeController {

	/* public : 접근지정자
	 * String : 리턴라입
	 * callHello : 메소드이름
	 * () : 파라미터
	 * @GetMapping : 주소(자원) 조회
	 * ("/hello") : /hello 라는 url 주소가 됨
	 * http://localhost/ : 내 PC 주소
	 * localhost는 자기 IP를 의미함.
	 * IP접속 vs localhost입력 정답은 localhost
	 * why? IP는 매번 바뀌기 때문에 localhost라고 입력하는게 더 좋다.
	 */
	
	@GetMapping("/hello")
	public String callHello() {
		return "Hello World";
	}

	@GetMapping("/test")
	public Map<String, Object> callTest() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", "곱창");
		map.put("2", "삼겹살");
		map.put("3", "목살");
		map.put("4", "순대");
		
		return map;
	}
	
	/* public : 접근지정자
	 * List<String> : 리턴라입
	 * callFood : 메소드이름
	 * () : 파라미터
	 * @GetMapping : 주소(자원) 조회
	 * ("/food") : /food 라는 url 주소가 됨
	 * http://localhost/ : 내 PC 주소
	 * localhost는 자기 IP를 의미함.
	 * IP접속 vs localhost입력 정답은 localhost
	 * why? IP는 매번 바뀌기 때문에 localhost라고 입력하는게 더 좋다.
	 */
	@GetMapping("/food/kyungjung")
	public List<String> callFood() {
		List<String> list = new ArrayList<String>();
		list.add("멜론");
		list.add("포도");
		list.add("키위");
		return list;
	}
	
	
	/*status
	* HTTP 오류
	* 404 : 페이지를 찾을 수 없음 - 경로(URL) 잘못 씀
	* 500 : 개발자 실수 (프로그래밍 오류) - String인데 Int로 되어있다던지 하는식의 오류
	* 401 : 권한 없음 (권한이 없어서 해당 URL에 접속 불가능)
	* 200 : 성공
	*/
	
	
	
	
}
