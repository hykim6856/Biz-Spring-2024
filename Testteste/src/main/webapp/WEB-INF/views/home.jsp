<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
      $(document).ready(function() {
        // 입력 필드에 입력 중일 때 밑줄 추가
        $('#inputText').on('input', function() {
          var inputText = $(this).val();
          addUnderline(inputText);
        });

        // 텍스트에 밑줄 추가하는 함수
        function addUnderline(text) {
          $('#displayText').html('<span style="text-decoration: underline red;">' + text + '</span>');
        }
      });
    </script>
  </head>
  <body>
    <h1>Hello!! Korea</h1>
    <textarea id="inputText" style="width: 500px; height: 500px;"></textarea>
    <div id="displayText"></div>
  </body>
</html>
