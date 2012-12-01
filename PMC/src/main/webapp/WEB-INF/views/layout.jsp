<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<html>
<head>
<script src="/PMC/script/jquery-1.8.0.min.js"></script>
<script src="/PMC/script/bootstrap.min.js"></script>
<meta charset="utf-8">
<title>Project Mental Care</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Le styles -->
<link href="/PMC/style/bootstrap.css" rel="stylesheet">
<style>
body {
	padding-top: 60px; /* 60px to make the container go all the way
      	to the bottom of the topbar */
}
</style>
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
      	</script>
    	<![endif]-->
<style>
undefined
</style>
</head>
<body>
	<div class="navbar navbar-fixed-top navbar-inverse">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#"> Project Mental Care </a>
				<ul class="nav">
					<li><a href="#"> Home </a></li>
					<li><a href="#"> About </a></li>
					<li><a href="#"> Contact </a></li>
				</ul>
				<form class="navbar-form pull-right">
            		<input name="textinput1" type="email" placeholder="Email" class="span2">
            		<input name="textinput2" type="password" placeholder="Password" class="span2">
            		<button class="btn">
	              		Sign in
            		</button>
          		</form>
			</div>
		</div>
	</div>
	<div class="container">
		<decorator:body />
	</div>
</body>
</html>
