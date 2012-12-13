<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script src="/PMC/script/jquery-1.8.0.min.js"></script>
<script>var loginUser=${loginUser};

$(function(){
	setUser();
});
function signIn(){
	$.ajax({
		url: "${pageContext.request.contextPath}/func/signIn",
		data:{
			username:$("#loginForm #username").val(),
			password:$("#loginForm #password").val()
		},
		success:function(data){
			var json=jQuery.parseJSON(data);
			if(json.result==true){
				
				loginUser=json.data;
				var contextUrl='${pageContext.request.contextPath}';
				if(loginUser['role']==1){

					location.href=contextUrl+'/dev/';  
				}else if(loginUser['role']==2){

					location.href=contextUrl+'/evaluator/';  
				}else if(loginUser['role']==3){
					location.href=contextUrl+'/admin/';  
				}
			}else{
				alert('로그인 실패');
			}
		}
	});
}
function setUser(){
	if(loginUser!=null){
		var loginForm=$("#loginForm");
		loginForm.empty();
		var signOut='<a href="/PMC/func/signOut">[로그아웃]</a>';
		loginForm.html(loginUser['username']+"님 환영합니다. "+signOut);
	}
}</script>
<script src="/PMC/script/common.js"></script>
<script src="/PMC/script/bootstrap.min.js"></script>
<script src="/PMC/script/bootstrap-datepicker.js"></script>
<!-- 
<script src="/PMC/script/jquery-ui-1.9.2.custom.min.js"></script>
<script src="/PMC/script/jquery.tools.min.js"></script>
 -->
<meta charset="utf-8">
<title>Project Mental Care[관리자]</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Le styles -->
<link href="/PMC/style/bootstrap.css" rel="stylesheet">
<link href="/PMC/style/jquery-ui-1.9.2.custom.min.css" rel="stylesheet">
<link href="/PMC/style/datepicker.css" rel="stylesheet">
<!-- 
<link href="/PMC/style/flight-calendar.css" rel="stylesheet">
<link href="/PMC/style/flight.css" rel="stylesheet">
<link href="/PMC/style/standalone.css" rel="stylesheet">
 -->
<style>
body {
	padding-top: 60px; /* 60px to make the container go all the way
      	to the bottom of the topbar */
}
.sidemenu {font-size:15px;}
</style>
<link href="/PMC/style/bootstrap-responsive.css" rel="stylesheet">
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
				<a class="brand" href="/PMC/admin/"> Project Mental Care </a>
				<ul class="nav">
					<li><a href="/PMC/admin/"> Home </a></li>
					<li><a href="#"> About </a></li>
					<li><a href="#"> Contact </a></li>
				</ul>
				<div id="loginForm" class="pull-right">
            		<input id="username" type="text" placeholder="Username" class="span2">
            		<input id="password" type="password" placeholder="Password" class="span2">
            		<button class="btn" onClick="signIn()">
	              		Sign in
            		</button>
          		</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
	  <div class="row-fluid">
	    <div class="span3">
	      <div class="well sidebar-nav">
	        <ul class="nav nav-list">
	          <li class="nav-header">
	            <h3>
	              Admin
	            </h3>
	          </li>
	          <li class="sidemenu">
	          	<a href="/PMC/admin/">
	              내 정보
	            </a>
	          </li>
	          <li class="sidemenu">
	          	<a href="/PMC/admin/workadd">
	              신규 Work 등록
	            </a>
	          </li>
	          <li class="sidemenu">
	          	<a href="/PMC/admin/auction_list">
	              경매 진행중인 Work
	            </a>
	          </li>
	          <li class="sidemenu">
	          	<a href="/PMC/admin/on_work">
	              개발 완료된 Work
	            </a>
	          </li>
	        </ul>
	      </div>
	    </div>
	    <div class="span9">
			<decorator:body />
			<div>
	        © Project Metal Care 2012
	        </div>
	    </div>
	  </div>
	</div>
</body>
</html>
