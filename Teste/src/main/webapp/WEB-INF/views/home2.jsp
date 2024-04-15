<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />

<title>Grammar Check</title>
<script>
        let timeout;

        function checkGrammar() {
            clearTimeout(timeout);
            timeout = setTimeout(() => {
                const text = document.getElementById('inputText').value;
                fetch('/hello', {
                    method: 'POST',
                    body: JSON.stringify({ text: text }),
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                .then(response => response.json())
                .then(data => {
                    if (data.hasError) {
                        document.getElementById('inputText').classList.add('error');
                    } else {
                        document.getElementById('inputText').classList.remove('error');
                    }
                });
            }, 2000);
        }
    </script>
<style>
.error {
	border-bottom: 1px solid red;
}
</style>
</head>
<body>
	<textarea id="inputText" oninput="checkGrammar()"></textarea>
</body>
</html>
