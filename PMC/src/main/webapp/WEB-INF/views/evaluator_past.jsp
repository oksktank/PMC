<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<style>
#search {text-align:right;}
.td-background-color {background-color:EEEEEE;}
.page_move {cursor:pointer;}
</style>
<h1>과거 평가 내역</h1>
<hr>

<div id="search">
<form class="form-search">
  <div class="input-append">
    <input type="text" class="span9 search-query">
    <button type="submit" class="btn">Search</button>
  </div>
</form>
</div>
<div id="board">
<table class="table table-hover table-bordered table-striped">
	<tr>
		<th>No</th>
		<th>이름</th>
		<th>전문분야</th>
		<th>평가점수</th>
	</tr>
	<c:forEach items="${evaluatedList }" var="work" varStatus="i">
	<!-- 여기부터 동적생성 wid->work의pk-->
	<!-- onclick 해서 evaluator/work?wid=xxxx로 이동할거임 -->
	<tr class="page_move" onclick="location.href='/PMC/evaluator/work?id=${work.dt_num}';">
		<td>${i.index+1 }</td>
		<td>${work.w_name }</td>
		<td>${work.expert_part_name }</td>
		<td>${work.grade }</td>
	</tr>
	<!-- 여기까지 -->
	</c:forEach>
	
</table>
</div>