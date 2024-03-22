<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><title>getBoard.jsp</title>
<script src="${pageContext.request.contextPath}/scripts/jquery-3.2.1.min.js"></script>
<script>
$(function(){	
	// ajax 로 게시글 로딩
	function getCommentsList() {
		var requestData = {"boardSeq": "${board.seq}" };		
		//json
 		$.ajax({
			url : "../getCommentsList",
			data : requestData,
			dataType : 'json',
			success : function(data) {				
				for( i=0; i< data.length; i++) {
					var html = '<div class="article" id="'
								+ data[i].seq + '">'
								+ data[i].name 
								+ data[i].content
								+ '</div>';
					$("#commentList").append(html);	
				}
			}
		}); 
		

	}
	
	//댓글등록
	$("#btnCommentAdd").click(function(){
		var requestData = {name:    $("[name=name]").val(), 
						   content: $("[name=content]").val(), 
						   boardSeq:"${board.seq}" };
/* 		requestData = $("#commentFrm").serialzie();
		requestData.boardSeq = "${board.seq}" ; */
		$.ajax({
			url : "../insertComments",
			data : requestData,
			dataType : 'json',
		}).then( data => {				
			var html = '<div class="article" id="'
				+ data.seq + '">'
				+ data.name 
				+ data.content
				+ '</div>';
			$("#commentList").append(html);	
		});		
	});
	
	getCommentsList();
});
</script>
</head>
<body>

<hr>
	제목: ${board.title} <br>
	작성자: ${board.writer} <br>
	내용: ${board.content} <br>
	첨부파일 : <a href="downloadBoard?seq=${vo.seq}">${vo.uploadfile}</a> <br>
	
	<a href="../updateBoard">수정</a>
	
	<hr>
	<div style="border:1px solid green">
		<form id="commentFrm">
			<input name="name" size="10">
			<input name="content" size="50">
			<input type="button" id="btnCommentAdd" value="댓글등록"/>
		</form>
	</div>	
	<div id="commentList"></div>
</body>
</html>




