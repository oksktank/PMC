<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<style>
.sidemenu{font-size:15px;}
.td-background-color {background-color:EEEEEE;}
</style>

<div class="container-fluid">
  <div class="row-fluid">
<h1>New Works</h1>
<hr>
     
<script>
	/*var data = [{sn:'123',name:'영희',expert:'웹',cost:'300'},{sn:'1234',name:'쿠키',expert:'디비',cost:'300'},{sn:'13253',name:'영수',expert:'디비',cost:'300'},{sn:'19123',name:'구슬',expert:'웹',cost:'300'},{sn:'323',name:'고기',expert:'웹',cost:'300'},{sn:'1823',name:'용지',expert:'웹',cost:'300'},{sn:'1723',name:'방패',expert:'웹',cost:'300'},{sn:'12233',name:'꽃',expert:'디비',cost:'300'},{sn:'223',name:'냠냠',expert:'기타',cost:'300'},{sn:'1123',name:'레포트',expert:'디비',cost:'300'},{sn:'125',name:'철수',expert:'java',cost:'1000'}];

	$(function(){
		jQuery.each(data, function(i,val) {
			var output='';
			output += '<div class="accordion-group"><div class="accordion-heading">';
			output += '<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse'+i+'">'+val.name+'</a></div>';
			output += '<div id="collapse'+i+'" class="accordion-body collapse"><div class="accordion-inner"><table class="table table-bordered">';
			output += '<tr><td class="td-background-color" style="width:100px">이름</td><td>'+val.w_name+'</td></tr>';
			output += '<tr><td class="td-background-color" style="width:100px">설명</td><td>'+val.description+'</td></tr>';
			output += '<tr><td class="td-background-color" style="width:100px">전문분야</td><td>'+val.expert_part+'</td></tr>';
			output += '<tr><td class="td-background-color" style="width:100px">세부분야</td><td>'+val.detail_part+'</td></tr>';
			output += '<tr><td class="td-background-color" style="width:100px">기간</td><td>'+val.w_name+'</td></tr>';
			output += '<tr><td class="td-background-color" style="width:100px">첨부 파일</td>';
			output += '<td><button class="btn btn-primary" onclick=다운로드파일ㅋㅅㅋ(i);>Download</button></td></tr>';
			output += '</div>';
	       	$(output).appendTo('.newworks>#accordion2');
	    });
	});*/

</script>
<style>
	.td-background-color {background-color:EEEEEE;}
</style>

      <!-- 추후 동적생성으로 -->
      <div class="newworks">
      	<div class="accordion" id="accordion2">
      		<c:forEach items="${recentWork }" var="work">
      		<div class="accordion-group">
		    <div class="accordion-heading">
		      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse${work.num }">
		        ${work.w_name }
		      </a>
		    </div>
		    <div id="collapse${work.num }" class="accordion-body collapse">
		      <div class="accordion-inner">
		        <table class="table table-bordered">
		        	<tr>
		        		<td class="td-background-color" style="width:100px">용역 이름
		        		</td>
		        		<td>${work.w_name }</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">개발 내용
		        		</td>
		        		<td>${work.description }</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">기간
		        		</td>
		        		<td>${work.start_period } ~ ${work.end_period } </td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">인센티브
		        		</td>
		        		<td>${work.cost } </td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">전문 분야
		        		</td>
		        		<td>${work.expert_part_name }</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">세부 분야
		        		</td>
		        		<td>${work.detail_part_name }</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">첨부파일
		        		</td>
		        		<td><a class="btn btn-primary" href="${pageContext.request.contextPath }/func/download?filePath=${work.file_path }&fileName=${work.file_name}">Download</a></td>
		        	</tr>
		        </table>
		      </div>
		    </div>
		  </div>
      		</c:forEach>
		  
      
      </div>

      <hr>
      <div>
        © Company 2012
      </div>
    </div>
  </div>