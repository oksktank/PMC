<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<style>
#search {text-align:right;}
.td-background-color {background-color:EEEEEE;}
.page_move {cursor:pointer;}
</style>
<h1>평가완료Works</h1>
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
		<th>인센티브</th>
		<th>기간</th>
	</tr>
	<!-- 여기부터 동적생성 wid->work의pk-->
	<!-- onclick 해서 admin/auction?wid=xxxx로 이동할거임 -->
	<c:forEach items="${evaluateEndList }" var="work" varStatus="i">
		<tr class="page_move" onclick="location.href='/PMC/admin/work?id=${work.dt_num}';">
		<td>${i.index+1 }</td>
		<td>${work.w_name }</td>
		<td>${work.expert_part_name }</td>
		<td>${work.cost }</td>
		<td>${work.start_period }~${work.end_period }</td>
	</tr>
	</c:forEach>
	
	<!-- 여기까지 -->
</table>
</div>