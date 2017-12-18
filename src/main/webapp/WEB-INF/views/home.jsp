<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="notice/noticeList">Notice</a>
<a href="qna/qnaList">QnA</a>
<c:if test="${member eq null}">
	<a href="member/memberJoin">Join</a>
	<a href="member/memberLogin">Login</a>
</c:if>
<c:if test="${member ne null}">
	<a href="member/memberView">My Page</a>
	<a href="member/memberLogout">Logout</a>
</c:if>
<!-- 
<div ng-app="">
<input type="text" ng-model="name">
<p ng-bind="name"></p>
 -->
</body>
</html>
