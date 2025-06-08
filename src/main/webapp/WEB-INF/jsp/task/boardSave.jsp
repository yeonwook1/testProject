<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 작성</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
<div id="root">
	<header>
		<h2>게시판 등록</h2>
	</header>
	<hr/>
	<form id="form">
		<table>
			<colgroup>
				<col width="15%">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th scope="row">제목</th>
					<td><input type="text" id="title" name="title" value="${map.TITLE}"></td>
				</tr>
				<tr>
					<th scope="row">내용</th>
					<td colspan="2">
						<textarea rows="10" cols="50" id="content" name="content">${map.CONTENT}</textarea>
					</td>
				</tr>
			</tbody>			
		</table>
		<input type="button" id="saveBoard" value="게시판 등록"/>
		<input type="button" id="backBoard" value="뒤로가기"/>
		<!-- button type을 꼭 주자 button의 디폴트 타입은 submit이다. -->
	</form>	
</div>

</body>
<script type="text/javascript">
/* $(document).ready( function() {
$("#saveBoard").on('click',function(){
	if($('input[id="title"]').val().length == 0){
		alert("제목을 입력하세요.");
		$('input[id="title"]').focus();
	} 
	else if ($('textarea[id="content"]').val().length == 0){
				alert("내용을 입력하세요.")
				$('textarea[id="content"]').focus();
	}
	else {
		$('#form').attr("method", "POST");
		$('#form').attr("action", "/insert.do");
		$('#form').submit();
	}
});
} */
$(document).ready(function () {
	$("input[id='saveBoard']").click(function () {
		if($('input[id="title"]').val().length == 0){
			alert("제목을 입력하세요.");
			$('input[id="title"]').focus();
		} 
		else if ($('textarea[id="content"]').val().length == 0){
					alert("내용을 입력하세요.")
					$('textarea[id="content"]').focus();
		}
		else {
			$('#form').attr("method", "POST");
			$('#form').attr("action", "/insert.do");
			$('#form').submit();
		}
	});
	
	$("input[id='backBoard']").click(function (){
		$(location).attr("href", "/index");
	});
});
</script>
</html>