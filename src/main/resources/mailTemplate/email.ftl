<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title th:remove="all">Template for HTML email with inline image</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<p th:text="#{greeting(${name})}">
    Hello, Peter Static!
</p>
<p th:if="${name.length() > 10}">
    Wow! You've got a long name (more than 10 chars)!
</p>
<p>
    You have been successfully subscribed to the <b>Fake newsletter</b> on
    <span th:text="${#dates.format(subscriptionDate)}">28-12-2012</span>
</p>
<p>Your hobbies are:</p>
<ul th:remove="all-but-first">
    <li th:each="hobby : ${hobbies}" th:text="${hobby}">Reading</li>
    <li>Writing</li>
    <li>Bowling</li>
</ul>
<p>
    You can find <b>your inlined image</b> just below this text.
</p>
<p>
    Regards, <br />
    <em>The Thymeleaf Team</em>
</p>
</body>
</html>