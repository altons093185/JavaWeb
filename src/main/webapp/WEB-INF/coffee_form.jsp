<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		<h2>咖啡表單</h2>
		<form class="pure-form pure-form-stacher" method="POST"  action"/JavaWeb/user/">
		 <fieldset>
		 	<legend>Coffee Form</legend>
					
					<br><br>
					<label>請輸入牛奶毫升數:</label>
					<input name="milk" type="number" min="0" max="1000" required />
					
					<label>請輸入咖啡毫升數:</label>
					<input name="coffee" type="number" min="0" max="1000" required />
					

					
					<button type="submit" class="pure-form pure-form-primary">送出</button>
		 </fieldset>
		</form>
	</div>
</body>
</html>