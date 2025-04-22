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
		<form class="pure-form pure-form-stacher" method="POST"  action"/JavaWeb/user/">
		 <fieldset>				
					<br><br>
					<label>留言:</label>
					<br><br>
					<input name="message" type="text" required />
					

					

					
					<button type="submit" class="pure-form pure-form-primary">送出</button>
		 </fieldset>
		</form>
	</div>
</body>
</html>