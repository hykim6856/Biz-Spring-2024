package com.callor.hello;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Locale locale, Model model) {
        // checkGrammar 메서드를 호출하여 문법 검사를 실행합니다.
        // 이 메서드는 서버 시작 후 최초 한 번만 호출되므로 실시간 검사를 위해서는
        // 클라이언트 측에서 추가적인 요청이 필요합니다.
        checkGrammar(new GrammarCheckRequest("")); // 빈 텍스트로 호출하면 됩니다.
        
       
        return "home";
    }

    @PostMapping("/")
    @ResponseBody
    public GrammarCheckResponse checkGrammar(@RequestBody GrammarCheckRequest request) {
        // 여기서는 간단히 예제로 true나 false를 랜덤하게 반환합니다.
        boolean hasError = Math.random() < 0.5; // 예제에서는 50%의 확률로 오류 발생
        return new GrammarCheckResponse(hasError);
    }

    static class GrammarCheckRequest {
        private String text;

        public GrammarCheckRequest(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    static class GrammarCheckResponse {
        private boolean hasError;

        public GrammarCheckResponse(boolean hasError) {
            this.hasError = hasError;
        }

        public boolean isHasError() {
            return hasError;
        }

        public void setHasError(boolean hasError) {
            this.hasError = hasError;
        }
    }
}
