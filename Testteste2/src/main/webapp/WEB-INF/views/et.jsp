<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Morphological Analysis</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <h1>Morphological Analysis</h1>
    <form id="analyzeForm">
        <textarea id="inputText" rows="5" cols="50"></textarea><br>
        <button type="submit">Analyze</button>
    </form>

    <div id="result"></div>

    <script>
        $(document).ready(function () {
            $("#analyzeForm").submit(function (event) {
                event.preventDefault();
                var text = $("#inputText").val();
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "/hello/analyze",
                    data: JSON.stringify(text),
                    dataType: 'json',
                    success: function (result) {
                        displayResult(result);
                    },
                    error: function (e) {
                        console.log("ERROR : ", e);
                    }
                });
            });
        });

        function displayResult(result) {
            $("#result").empty();
            $.each(result.nouns, function (index, noun) {
                $("#result").append("<p>Noun: " + noun + "</p>");
            });
            $.each(result.verbs, function (index, verb) {
                $("#result").append("<p>Verb: " + verb + "</p>");
            });
            $.each(result.entities, function (index, entity) {
                $("#result").append("<p>Entity: " + entity + "</p>");
            });
        }
    </script>
</body>
</html>
