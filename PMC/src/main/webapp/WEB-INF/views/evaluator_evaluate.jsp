<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<style>
.td_right {width:25%;}
.work_description {padding-left:30px; padding-bottom:20px;}
#work_info {width:100%;}
#work_info td {padding:5px;}
#work_header {font-size:20px; color:#BB0000; font-weight:bold;}
#work_em {font-size:20px; color:#003A9A; font-weight:bold; margin-right:30px;}
</style>
<h1>평가하기</h1>
<hr>

<div id="develop">
<!-- 여기부터 -->
	<div class="well">
		<table id="work_info">
			<tr>
			<!-- wid로 구분 work/?wid=xxxx -->
				<td colspan="2"><a href="/PMC/evaluator/work"><span id="work_header">웹서버 세팅</span></a></td>
			</tr>
			<tr>
				<td colspan="2"><div class="work_description">
				여기는 설명 ㅇㅇㅇ ㅇ ㅇ ㅇ ㅇ
				spring framework 기반 웹 서버 세팅 ㅋ
				</div></td>
			</tr>
			<tr>
				<td>
				<span id="work_em">개발 결과물</span>
				<a href="#" class="btn btn-primary">Download</a>
				<td>
				</td>
				<td>
					<div class="input-append">
					    <input type="text" id="grade3242" class="span5">
					    <button type="submit" class="btn btn-info" data-dismiss="modal">평가</button>
					</div>
				</td>
			</tr>
		</table>
	</div>
<!-- 여기까지 반복 -->
	<div class="well">
	안녕
	</div>
	<div class="well">
	안녕
	</div>

</div>