<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		 	<legend>guest book Form</legend>
					
					<br><br>
					<label>guest book result</label>
						本次留言: ${ message }<p />
						歷史留言: ${ guestbooks }<p />
					<a href="/JavaWeb/guestbook" class="pure-button pure-button-primary">返回</a>
					
					

					
		 </fieldset>
		</form>
	</div>
</body>
</html>