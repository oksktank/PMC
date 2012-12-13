<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<style>
.sidemenu {font-size:15px;}
#my_info {width:100%;}
#my_info td {padding:10px;}
.td-background-color {background-color:EEEEEE;}
</style>
<div>
      <div class="hero-unit">
        <table id="my_info">
        <tr>
	        <td>
	        	<h1>${evaluator.name }</h1>
	       	</td>
	       	<td>
	       	<b>전문분야:</b>${evaluator.expert_part_name }<br/><b>세부분야:</b>${evaluator.detail_part_name }
	       	</td>
        </tr>
        <tr>
        	<td>
        	평가의뢰 <a href="/PMC/evaluator/evaluate">${evCount }</a>건
        	</td>
        </tr>
        </table>
	  </div>
      <hr>
      
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
		        		<td><a class="btn btn-primary" href="${pageContext.request.contextPath }/func/download?fileName=${work.file_name}">Download</a></td>
		        	</tr>
		        </table>
		      </div>
		    </div>
		  </div>
      		</c:forEach>
		  
      </div>
      </div>
</div>