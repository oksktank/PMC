
	$(function(){
		setUser();
	});
	function signIn(){
		$.ajax({
			url: "${pageContext.request.contextPath}/func/signIn",
			data:{
				username:$(".navbar-form #username").val(),
				password:$(".navbar-form #password").val()
			},
			success:function(data){
				var json=jQuery.parseJSON(data);
				if(json.result==true){
					
					loginUser=json.data;
					setUser();
				}else{
					//로그인 실패
				}
			}
		});
	}
	function setUser(){
		if(loginUser!=null){
			var loginForm=$("#loginForm");
			loginForm.empty();
			loginForm.html(loginUser['username']+"님 환영합니다.");
		}
	}