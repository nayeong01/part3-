<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content= "text/html; charset=UTF-8">

<title>Insert title here</title>

<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
<link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">
<link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>
<body>
   <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
					<form method = 'post' action="/login">
					<fieldset>
					<div class="form-group">
						<input class="form-control" placeholder="userid" name="username" type="text" autofocus>
					</div>
					<div class="form-group">
						<input class="form-control" placeholder="Password" name="password" type="password" value="">
					</div>
					<div class="checkbox">
						<label><input name="remember-me" type="checkbox">Remember Me</label>
					</div>
					<a href= "index.html" class="btn btn-lg btn-success btn-block">Login</a>
					</fieldset>
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
					</form>
				</div>
            </div>
        </div>
    </div>
</div>
<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>

<script src="/resources/vendor/jquery/jquery.min.js"></script>
<script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/dist/js/sb-admin-2.js"></script>

<script>
	$(".btn-success").on("click",function(e){
		e.perventDefault();
		$("form").submit();
	});
</script>
</body>
</html>