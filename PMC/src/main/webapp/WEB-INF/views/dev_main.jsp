<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<style>
.sidemenu {font-size:15px;}
#my_info {width:100%;}
#my_info td {padding:10px;}
.td-background-color {background-color:EEEEEE;}
</style>
<script>
	var data = [{sn:'123',name:'영희',expert:'웹',cost:'300'},{sn:'1234',name:'쿠키',expert:'디비',cost:'300'},{sn:'13253',name:'영수',expert:'디비',cost:'300'},{sn:'19123',name:'구슬',expert:'웹',cost:'300'},{sn:'323',name:'고기',expert:'웹',cost:'300'},{sn:'1823',name:'용지',expert:'웹',cost:'300'},{sn:'1723',name:'방패',expert:'웹',cost:'300'},{sn:'12233',name:'꽃',expert:'디비',cost:'300'},{sn:'223',name:'냠냠',expert:'기타',cost:'300'},{sn:'1123',name:'레포트',expert:'디비',cost:'300'},{sn:'125',name:'철수',expert:'java',cost:'1000'}];

	$(function(){
		jQuery.each(data, function(i,val) {
			var output='';
			output += '<div class="accordion-group"><div class="accordion-heading">';
			output += '<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse'+i+'">'+val.name+'</a></div>';
			output += '<div id="collapse'+i+'" class="accordion-body collapse"><div class="accordion-inner"><table class="table table-bordered">';
			output += '<tr><td class="td-backgorund-color" style="width:100px">용역  이름</td><td>'+val.name+'</td></tr>';
			output += '<tr><td class="td-background-color" style="width:100px">용역  이름</td><td>'+val.name+'</td></tr>';
			output += '<tr><td class="td-background-color" style="width:100px">용역  이름</td><td>'+val.name+'</td></tr>';
			output += '<tr><td class="td-background-color" style="width:100px">첨부 파일</td>';
			output += '<td><button class="btn btn-primary" onclick=다운로드파일ㅋㅅㅋ(i);>Download</button></td></tr>';
			output += '</div>';
	       	$(output).appendTo('.newworks>#accordion2');
	    });
	});
	
	
	//게시판
	$(function(){
		jQuery.each(data, function(i,val) {
			var output='';
			output += '<div class="accordion-group"><div class="accordion-heading">';
			output += '<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse'+i+'">'+val.name+'</a></div>';
			output += '<div id="collapse'+i+'" class="accordion-body collapse"><div class="accordion-inner"><table class="table table-bordered">';
			output += '<tr><td class="table-left-name" style="width:100px">용역  이름</td><td>'+val.name+'</td></tr>';
			output += '<tr><td class="table-left-name" style="width:100px">용역  이름</td><td>'+val.name+'</td></tr>';
			output += '<tr><td class="table-left-name" style="width:100px">용역  이름</td><td>'+val.name+'</td></tr>';
			output += '<tr><td class="table-left-name" style="width:100px">첨부 파일</td>';
			output += '<td><button class="btn btn-primary" onclick=다운로드파일ㅋㅅㅋ(i);>Download</button></td></tr>';
			output += '</div>';
	       	$(output).appendTo('.board');
	    });
	});

</script>
<div>
      <div class="hero-unit">
        <table id="my_info">
        <tr>
	        <td>
	        	<h1>이름</h1>
	       	</td>
	       	<td>
	       		<b>전문분야 세부분야</b>
	        </td>
        </tr>
        <tr>
        	<td>
        	초대받은 works <a href="#">3</a>건
        	</td>
        	<td>
        	010-xxxx-xxxx
        	</td>
        </tr>
        <tr>
        	<td></td>
        	<td>전문성 등급 <b>2등급</b></td>
        </tr>
        <tr>
        	<td>
        	<div class="well sidebar-nav">
		        <ul class="nav nav-list">
		          <li class="nav-header">
		          My Works
		          </li>
        		  <li><button class="btn btn-primary">REAL</button></li>
        		  <li><button class="btn btn-primary">PMC</button></li>
        		</ul>
        	</div>
        	</td>
        	<td>
        	</td>
        </tr>
        </table>
	  </div>
      <hr>

      <!-- 추후 동적생성으로 -->
      <div class="newworks">
      	<div class="accordion" id="accordion2">
		  <div class="accordion-group">
		    <div class="accordion-heading">
		      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
		        	곰인형 로봇을 사용한 교육용 PC Application Game 개발
		      </a>
		    </div>
		    <div id="collapseOne" class="accordion-body collapse in">
		      <div class="accordion-inner">
		        <table class="table table-bordered">
		        	<tr>
		        		<td class="asdf" style="width:100px">용역 이름
		        		</td>
		        		<td>샬라샬라</td>
		        	</tr>
		        </table>
		      </div>
		    </div>
		  </div>
		  <div class="accordion-group">
		    <div class="accordion-heading">
		      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
		        Facebook 연동 mobile application 개발
		      </a>
		    </div>
		    <div id="collapseTwo" class="accordion-body collapse">
		      <div class="accordion-inner">
		        <table class="table table-bordered">
		        	<tr>
		        		<td class="asdf" style="width:100px">용역 이름
		        		</td>
		        		<td>Facebook 연동 mobile application 개발</td>
		        	</tr>
		        	<tr>
		        		<td class="asdf" style="width:100px">기간
		        		</td>
		        		<td>2012.12 ~ 2013.2 (3개월)</td>
		        	</tr>
		        	<tr>
		        		<td class="asdf" style="width:100px">자격요건
		        		</td>
		        		<td>HTML/CSS/Javascript를 이용한 web programming 기술</td>
		        	</tr>
		        	<tr>
		        		<td class="asdf" style="width:100px">개발내용
		        		</td>
		        		<td>Facebook의 기능과 mobile의 기능이 연동되는 application
	Facebook application 형태로 패키징하여 facebook에 등록</td>
		        	</tr>
		        	<tr>
		        		<td class="asdf" style="width:100px">첨부파일
		        		</td>
		        		<td><button class="btn btn-primary">Download</button></td>
		        	</tr>
		        </table>
		      </div>
		    </div>
		  </div>
		  <div class="accordion-group">
		    <div class="accordion-heading">
		      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
		        내일로 여행을 위한 여행 가이드 Mobile Application 개발
		      </a>
		    </div>
		    <div id="collapseThree" class="accordion-body collapse">
		      <div class="accordion-inner">
		        Anim pariatur cliche...
		      </div>
		    </div>
		  </div>
		  <div class="accordion-group">
		    <div class="accordion-heading">
		      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFour">
		        수학 함수 그래프 이해를 돕는 교육용 게임 개발
		      </a>
		    </div>
		    <div id="collapseFour" class="accordion-body collapse">
		      <div class="accordion-inner">
		        Anim pariatur cliche...
		      </div>
		    </div>
		  </div>
		  <div class="accordion-group">
		    <div class="accordion-heading">
		      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFive">
		        Real time Web based Game
		      </a>
		    </div>
		    <div id="collapseFive" class="accordion-body collapse">
		      <div class="accordion-inner">
		        Anim pariatur cliche...
		      </div>
		    </div>
		  </div>
		</div>
      
      </div>

      <hr>
</div>