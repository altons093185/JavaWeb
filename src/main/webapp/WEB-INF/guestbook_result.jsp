<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css" integrity="sha384-X38yfunGUhNzHpBaEBsWLO+A0HDYOQi8ufWDkZ0k9e0eXz/tH3II7uKZ9msv++Ls" crossorigin="anonymous">
<style>
.form_container{
	max-width: 500px;
	margin: 50px auto;
	padding: 20px;
}
h2{
text-align: center;
}
</style>
</head>
<body>
	<div class='form-container'>
		<h2>留言表單</h2>
		<form class="pure-form pure-form-stacher" method="POST"  action"/JavaWeb/guestbook/">
		 <fieldset>
		 	<legend>guest book result</legend>
					
					<br><br>
						本次留言: ${ message }<p />
						歷史留言: ${ guestbooks }<p />
					<ol>
					<c:forEach var="gb" items="${ guestbooks }">
						<li>${ gb.message } ${ gb.date }</li>
					</c:forEach>
					</ol>	
					
					<p />
					目前留言筆數: ${fn:length(guestbooks)}
					<table class="pure-table pure-table-bordered">
						<thead>
							<tr>
								<th>No</th>
								<th>留言內容</th>
								<th>留言時間</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach varStatus="i" var="gb" items="${ guestbooks }">
								<tr>
									<td>${ i.index + 1 }</td>
									<td>${ gb.message }</td>
									<td>
										<!-- 格式化日期 -->
										<fmt:formatDate value="${ gb.date }" pattern="yyyy-MM-dd" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>	
						
					<a href="/JavaWeb/guestbook" class="pure-button pure-button-primary">返回</a>
					
					

					
		 </fieldset>
		</form>
	</div>
</body>
</html>