package com.callor.book.controller;

 

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.callor.book.models.naver.NBookVO;
import com.callor.book.models.naver.NBooks;

@CrossOrigin(origins= {"http://localhost:3000","*"})
@Controller
@RequestMapping(value = "/naver")
public class NaverController {

	private final RestTemplate restTemplate;

	public NaverController(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	/*
	 * ViewResolver 를 통하지 않고, Rrturn 되는 값을 그대로 Response 하라 라는 의미
	 */
	@ResponseBody
	@RequestMapping(value = "/name", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String home(String name) {
		return "홍길동";
	}

	@ResponseBody
	@RequestMapping(value = "/books/{title}", method = RequestMethod.GET,produces ="application/json;charset=UTF-8")
	public List<NBookVO> book(@PathVariable(name = "title") String title) {
		
		String KEY_Naver_Client_Id="X-Naver-Client-Id";
		String KEY_Naver_Client_Secret= "X-Naver-Client-Secret";
		
		String VALUE_Naver_Client_Id="sKKWWcjzXxqbTzOHN4_R";
		String VALUE_Naver_Client_Secret= "61Sd023mqB";
		
//		Map<String,String> params = new HashMap<String, String>();
//		params.put(KEY_Naver_Client_Id, VALUE_Naver_Client_Id);
//		params.put(KEY_Naver_Client_Secret, VALUE_Naver_Client_Secret);
		
		// 헤더에 아이디랑 시크릿 값을 설정하기
		//org.spring...import
		HttpHeaders headers = new HttpHeaders();
		headers.set(KEY_Naver_Client_Id, VALUE_Naver_Client_Id);
		headers.set(KEY_Naver_Client_Secret, VALUE_Naver_Client_Secret);
		
		HttpEntity<String> params=new HttpEntity<String>("parameter", headers);
		
		String naver_book_url = "https://openapi.naver.com/v1/search/book.json?query="+title;
		
		/*
		 * RestTemplate.exchange()함수
		 * GET,POST,PUSH,DELETE 등 모든 REST 방식의 method 에 공통적으로 사용하는 함수
		 * getForce**(),postFor**() 함수들은 개별적으로 GET,POST method 에서 사용하는 함수
		 * naver 의 API(대부분의 open API)들은 요청을 할때  get method 방식을 사용해야한다.
		 * 그래서 getfor**함수를 사용하지만 getfor**() 함수는 http 프로토콜의 header에 값을 담아서 보낼 수 없다.
		 * 여기에서는 getFor**() 대신에 exchange()함수를 사용한다.
		 * exchange()함수는 전송method 를 지정해야 담아서 보낼 수 있다.
		 */
		
		ResponseEntity<NBooks> result= restTemplate.exchange(
				naver_book_url,HttpMethod.GET,params, NBooks.class);
		
		return result.getBody().items;
	}

}
