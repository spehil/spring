<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시판</title>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>

</head>
<body>

	<jsp:include page="/WEB-INF/views/comm/menu.jsp" />

	<h1>게시글변경</h1>

	<form action='${pageContext.request.contextPath}/bbs/edit.do'
		method='post'>
		<table border="1">
			<tbody>
				<tr>
					<th>글번호</th>
					<td><input type='text' name='bbsNo' value="${bbsVo.bbsNo}"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type='text' name='bbsTitle'
						value="${bbsVo.bbsTitle}" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name='bbsContent' rows="10" cols="20">${bbsVo.bbsContent}</textarea>
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><c:out value="${bbsVo.bbsWriter}" /></td>
				</tr>
				<tr>
					<th>작성일</th>
					<td><fmt:formatDate value="${bbsVo.bbsRegDate}"
							pattern="yyyy년MM월dd일 HH시mm분ss초" /></td>
				</tr>
			</tbody>
		</table>
		<input type='submit' value="저장" /> <a
			href='${pageContext.request.contextPath}/bbs/del.do?bbsNo=${bbsVo.bbsNo}'><button
				type="button">삭제</button></a><br>
	</form>

	<hr />
	<form action="${pageContext.request.contextPath}/reply/add.do"
		method="post">
		<input type="hidden" name="repBbsNo" value="${bbsVo.bbsNo}" />
		<textarea name="repContent" rows="10" cols="50"></textarea>
		<input type="button" value="저장" id="saveBtn" />
	</form>
	<script type="text/javascript">
		$.ajax({
			url : "${pageContext.request.contextPath}/reply/list.do",//요청주소
			method : "GET",//요청방식
			data : {

				repBbsNo : $('[name="repBbsNo"]').val()
				
			},//파라미터

			dataType : "json"//요청의 결과(서버의 응답)으로 받을 데이터의 형식 

		}).done(function(msg) {//요청에 대한 응답을 성공적으로 받았을때 실행할 함수

			console.log(msg);//1
			for(var i = 0; i<msg.length; i++){
				var vo = msg[i];
				console.log(vo.repNo, vo.repContent, vo.repWriter, repRegDate);
			}
		}).fail(function(jqXHR, textStatus) {//요청이 실패한 경우 실행할 함수 
			alert("Request failed: " + textStatus);
		});

		$('#saveBtn').on('click', function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/reply/add.do",//요청주소
				method : "POST",//요청방식
				data : {

					repBbsNo : $('[name="repBbsNo"]').val(),
					repContent : $('[name="repContent"]').val()
				},//파라미터
				//data: $('#replyForm').serialize(), //폼 내부의 입력요소들을 파라미터 문자열로 
				dataType : "json"//요청의 결과(서버의 응답)으로 받을 데이터의 형식 
			//,successs:function(msg){}//요청시 실행할 함수 
			//,error: function (jqXHR,testStatus){}//실패시 실행할함수 
			//,complete.function(){}//성공하든 실패하든 항상 실행할 함수 - 예전에 많이 쓰인 방법
			}).done(function(msg) {//요청에 대한 응답을 성공적으로 받았을때 실행할 함수
				//서버로부터 받은 응답이 인자로 전달된다. 

				//alert(msg);// '{"no":1}'
				// var data = JSON.parse(msg);  '{"no" : 1}' -> {"no" : 1}
				alert(msg.no + '개의 댓글을 저장했습니다.');//1
				$('[name="repContent"]').val('');
			}).fail(function(jqXHR, textStatus) {//요청이 실패한 경우 실행할 함수 
				alert("Request failed: " + textStatus);
			}).always(function() {//성공하든 실패하든 요청처리가 끝나면 항상 실행할 함수 
				console.log("complete");// 최근에 많이 사용하는 방법 
			});
		});
	</script>
</body>
</html>







