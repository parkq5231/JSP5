<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 보기</title>
<script type="text/javascript">
	function deleteAlert() {
		var yn = confirm("정말 삭제하시겠습니까?");
		if (yn) {
			frm.action = "boardDelete.do";
			frm.submit();
		}
	}//end of func
	function editAlert() {
		frm.action = "boardUpdate.do";
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 상세 보기</h1>
		</div>
		<form id="frm" name="frm" method="post">
			<input type="hidden" id="bId" name="bId" value="${vo.bId}">
			<div>
				<table border="1">
					<tr>
						<th width="100">작성자</th>
						<td width="120">${vo.bName}</td>
						<th width="100">작성일자</th>
						<td width="120" align="center">${vo.bDate}</td>
						<th width="100">조회수</th>
						<td width="100" align="center">${vo.bHit}</td>
					</tr>
					<tr>
						<th width="100">제 목</th>
						<td colspan="5">${vo.bTitle}</td>
					</tr>
					<tr>
						<th width="100">내 용</th>
						<td colspan="5"><textarea rows="7" cols="78" id="bContent"
								name="bContent">${vo.bContent}</textarea></td>
					</tr>
				</table>
				<br>
			</div>
			<div>
				<button type="button" onclick="editAlert()">수정</button>
				&nbsp;&nbsp;
				<button type="button" onclick="deleteAlert()">삭제</button>
				&nbsp;&nbsp;
				<button type="button" onclick="location.href='boardList.do'">목록</button>
			</div>
		</form>
	</div>
</body>
</html>