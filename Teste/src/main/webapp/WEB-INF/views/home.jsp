<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Grammar Check</title>
<style>
    .error {
        border-bottom: 1px solid red;
    }
</style>
<script>
    let timeout;

    function checkGrammar() {
        clearTimeout(timeout);
        timeout = setTimeout(() => {
            const text = document.getElementById('inputText').value;
            // 서버로 텍스트를 전송하여 문법을 검사합니다.
            fetch('/', {
                method: 'POST',
                body: JSON.stringify({ text: text }),
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(response => response.json())
            .then(data => {
                // 서버로부터 받은 결과에 따라 텍스트 입력창을 처리합니다.
                if (data.hasError) {
                    document.getElementById('inputText').classList.add('error');
                } else {
                    document.getElementById('inputText').classList.remove('error');
                }
            })
            .catch(error => console.error('Error:', error));
        }, 5000); // 5초마다 실행
    }

    // 페이지 로드 시 자동으로 실행합니다.
    window.onload = function() {
        checkGrammar();
    };
</script>
</head>
<body>
    <!-- 텍스트 입력창 -->
    <textarea id="inputText" oninput="checkGrammar()"></textarea>
</body>
</html>
