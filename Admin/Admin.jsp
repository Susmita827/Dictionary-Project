<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
function valid(){  
var name=document.form.un.value;  
var password=document.form.pw.value;  
    if(name!="Admin" && password!="Admin123"){
     alert("invalid Credential");
     return true;
  }
}
</style>
<link rel="stylesheet" href="Admin.css">
</head>
<body>
<form name="form" action="AdminSession"   method="post"  >
<div class="box">
<div class="container">
<div class="head">
<header>Login</header>
</div>
<div class="inputt">
<input type="text" name="un" class="user" placeholder="Username">
</div>
<div class="input">
<input type="password" name="pw" class="user" placeholder="Password">
</div>
<div class="input">
<input type="submit" onclick="return valid()" value="Login" class="submit">
</div>
</div>
</div>
</form>

</body>
</html>