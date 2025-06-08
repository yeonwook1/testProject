<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>example</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>
<link rel="stylesheet" href="https://uicdn.toast.com/grid/latest/tui-grid.css" />
<script src="<c:url value="/asset/js/sample.js" />"></script>
</head>
<body>
<div id="root">
	<header>
		<h2>게시판 등록</h2>
	</header>
	<div id="grid"></div>
	<button id="boardInsert">게시물 등록</button>
	<button id="boardUpdate">게시물 수정</button>
	<button id="boardDelet">게시물 삭제</button>	
</div>
</body>
<script type="text/javascript">
document.getElementById("boardInsert").addEventListener("click", function(){
	location.href="/boardSave";
});
</script>
</html>