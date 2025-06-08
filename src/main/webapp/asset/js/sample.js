//-------------------------------------------------------------------
// 화면 구성 준비
//-------------------------------------------------------------------	
function initGrid() {
  var sampleGrid = new tui.Grid({
    el: document.getElementById('grid'),
    scrollX: false,
    scrollY: false,
    columns: [
		{header: 'NO', name: 'BOARD_NO'}
	   ,{header: '게시판 제목', name: 'TITLE'}
	   ,{header: '게시판 내용', name: 'CONTENT'}
	   ,{header: '작성자', name: 'WRITER'}
	   ,{header: '수정자', name: 'UPD_ID'}
	   ,{header: '수정 일자', name: 'UPD_DTM'}
	   ,{header: '등록자', name: 'REG_ID'}
	   ,{header: '등록 일자', name: 'REG_DTM'}
   	]
  });
  return sampleGrid;
}

window.onload = function(){

	var createGrid = initGrid();
	
	$.ajax({
		url: "/testList.do",
		type: "POST", 
		dataType: "json",
		contentType: "application/json",
		success : function(data){
			createGrid.resetData(data);
		},
		error :function(){
			alert("request error!");
		}
		
	});
	
	
	createGrid.on('click', function(){
		var rowKey = createGrid.getFocusedCell().rowKey;
		var rows = createGrid.getRow(rowKey);
		var BoardNo = rows.BOARD_NO;
		var TITLE = rows.TITLE;
		
		$.ajax({
			url: "/boardItem.do",
			type: "POST",
			dataType: "text",
			data: {"board_no":BoardNo,
				   "title":TITLE},
			success: function(data){
				console.log(data);
				var url = "/boardSave";
				location.replace(url);
			},
			erorr: function(){
				alert("에러");
			}
		});	
		
	});
/*	appenRow할때
	document.getElementById("addRowBtn").addEventListener("click", function(){
		createGrid.appendRow({ID: 'New', PASSWORD: 'NewPASSWORD'});

	});*/
};
//-------------------------------------------------------------------
// 로우 행 추가
//-------------------------------------------------------------------	
function addRow(){

};



$(document).ready(function(){
	/*initEvent();*/
	/*addRow();*/	
});

