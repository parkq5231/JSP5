<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<div align="center">
			<div><h1>게시글 작성</h1></div>
		<form id="frm" name="frm" action="boardInsert.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="100">작성자</th>
						<td width="150"><input type="text" id="bName" name="bName" size=20 required="required"></td>
						<th width="100">작성일자</th>
						<td width="150"><input type="Date" id="bDate" name="bDate" size=20 required="required"></td>
					</tr>
					<tr>
						<th width="100">제 목</th>
						<td colspan="3"><input type="text" id="bTitle" name="bTitle" size=78 required="required"></td>
					</tr>
					<tr>
						<th width="100">내 용</th>
						<td colspan="3"><textarea id="bContent" name="bContent" rows="7" cols="80" required="required"></textarea></td>
					</tr>
				</table>
			</div><br>
			<div>
				<button type="submit">등 록</button>&nbsp;&nbsp;
				<button type="reset">취 소</button>&nbsp;&nbsp;
				<button type="button" onclick="location.href='boardList.do'">목 록</button>
			</div>
		</form>
	</div>
</body>
</html>