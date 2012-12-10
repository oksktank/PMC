<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<style>
.td_right {width:15%;}
.work_description {padding-left:30px;}
#work_info {width:100%;}
#work_info td {padding:5px;}
#work_header {font-size:20px; color:#BB0000; font-weight:bold;}
#work_em {font-size:20px; color:#003A9A; font-weight:bold;}
</style>
<h1>개발 진행중인 Works</h1>
<hr>

<div id="onwork_list">
	<div class="well">
		<table id="work_info">
			<tr>
				<td><span id="work_header">웹서버 세팅</span></td>
				<td class="td_right">
				<button class="btn btn-warning"><b>Work 완료</b></button>
				</td>
			</tr>
			<tr>
				<td colspan="2"><span class="work_description">
				여기는 설명 ㅇㅇㅇ ㅇ ㅇ ㅇ ㅇ
				spring framework 기반 웹 서버 세팅 ㅋ
				</span></td>
			</tr>
			<tr>
				<td colspan="2">
				<span id="work_em">평가의뢰</span>
				
				<!-- 동적 생성 ㅇ ㅇㅇㅇ ㅇ 평가자 -->
				
				도라에몽, 잡스
				<button class="btn btn-info"><b>+</b></button>
				</td>
			</tr>
		</table>
	</div>
	<div class="well">
	안녕
	</div>
	<div class="well">
	안녕
	</div>

</div>