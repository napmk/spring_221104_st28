<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한줄 게시판 글목록</title>
</head>
<body>
	<h2>한줄 게시판</h2>
	<hr>
	<table border="1" cellpadding="0" cellspacing="0" width="1000">
		<tr>
			<th>번호</th>
			<th>글쓴이</th>
			<th>한줄내용</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${list }" var="dto">
		<tr align="center">
			<td>${dto.mid }</td>
			<td>${dto.mwriter}</td>
			<td align="left" width="700">${dto.mcontent}</td>
			<td><input type="button" value="×" onclick="javascrpit:window.location='delete?mid=${dto.mid }'" ></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="한줄쓰기" onclick="javascrpit:window:location='writeForm'">
			</td>
		</tr>
	</table>
</body>
</html>