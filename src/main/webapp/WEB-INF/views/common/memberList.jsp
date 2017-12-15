<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<c:forEach items="${list}" var="dto">
	<ul>
		<li>${dto.id}</li>
  		<li>${dto.name}</li>
  		<li>${dto.phone}</li>
	</ul>
</c:forEach>
