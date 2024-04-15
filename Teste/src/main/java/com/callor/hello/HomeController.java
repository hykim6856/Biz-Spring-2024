package com.callor.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.service.GrammarCheckRequest;
import com.callor.hello.service.GrammarCheckResponse;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<GrammarCheckResponse> checkGrammar(@RequestBody GrammarCheckRequest request) {
        // 클라이언트가 보낸 텍스트를 가져와서 처리합니다.
        String text = request.getText();
        
        // 여기에 문법 검사 로직을 추가하고, 검사 결과에 따른 응답을 생성합니다.
        boolean hasError = grammarCheckLogic(text); // 문법 검사 로직
        
        // 검사 결과에 따른 응답을 생성합니다.
        GrammarCheckResponse response = new GrammarCheckResponse(hasError);
        
        // ResponseEntity를 사용하여 응답을 반환합니다.
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	private boolean grammarCheckLogic(String text) {
		// TODO Auto-generated method stub
		return true;
	}

    // GrammarCheckRequest 및 GrammarCheckResponse 클래스는 이전 코드와 동일합니다.
}
