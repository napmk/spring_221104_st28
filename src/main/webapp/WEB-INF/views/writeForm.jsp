<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한 줄 게시판 글쓰기</title>
</head>
<body>
	<h2>한 줄 게시판 글쓰기</h2>
	<hr>
	<table border="1" cellpadding="0" cellspacing="0" width="1000">
		<form action="write">
			<tr>
				<th>글쓴이</th>
				<td width="900"><input type="text" name="mwriter" size="60"></td>
			</tr>
			<tr>
				<th>한줄 쓰기</th>
				<td><input type="text" name="mcontent" size="100"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="한줄입력">
					<input type="button" value="목록보기" onclick="javascrip:window.location='list'">
				</td>
			</tr>
		
		</form>
	
	</table>
</body>
</html>