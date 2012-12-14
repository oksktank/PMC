<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<style>
#input_button {text-align:right;}
.td_right {width:15%;}
.team_info {width:100%;}
.td-background-color {background-color:EEEEEE;}
</style>
<h1>프로젝트이름</h1>
<hr>
<div id="project_info">
<table class="table table-bordered">
		        	<tr>
		        		<td class="td-background-color" style="width:100px">용역 이름
		        		</td>
		        		<td>${work.w_name }</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">개발내용
		        		</td>
		        		<td>${work.description }</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">기간
		        		</td>
		        		<td>${work.start_period } ~ ${work.end_period }</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">인센티브
		        		</td>
		        		<td>${work.cost } → ${team.cost }</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">전문분야
		        		</td>
		        		<td>${work.expert_part_name }</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">세부분야
		        		</td>
		        		<td>${work.detail_part_name }</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">첨부파일
		        		</td>
		        		<td>
		        		<a href="${pageContext.request.contextPath }/func/download?fileName=${work.file_name}" class="btn btn-primary">Download</a>
		        		</td>
		        	</tr>
		        </table>
		        </div>
		        
<div id="team_member">
	<table class="table table-bordered">
		<tr class="td-background-color">
			<th>NO</th>
			<th>이름</th>
			<th>전문분야</th>
			<th>세부분야</th>
			<th>전문성</th>
		</tr>
		<!-- 팀원 리스트 동적생성 -->
		<c:forEach items="${team.devList }" var="dev" varStatus="i">
		<tr>
			<td>${i.index+1 }</td>
			<td>${dev.name }</td>
			<td>${dev.expert_part_name }</td>
			<td>${dev.detail_part_name }</td>
			<td>${dev.gradeLevel }등급</td>
		</tr>
		</c:forEach>
		
	</table>
</div>


<c:if test="${myTeam ne null }">

<!-- !!!!!%#^^%@@@@@@@@@@#$@#$@ -->
<!-- 자기 프로젝트일때만 밑에 div 보이도록 (개발 결과물 파일 업로드임) -->
<div class="well">
	<p><b>결과 파일 업로드</b></p>
	<c:if test="${myResult ne null }">
		<p>현재 결과 파일: <a href="${pageContext.request.contextPath }/func/download?fileName=${myResult.file_name }">${myResult.file_name }</a></p>
	</c:if>
	<form enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/func/insertResult">
	 	<input name="fileData" type="file"/>
	 	<input type="hidden" name="w_num" value="${work.num }"/>
	 	<input type="hidden" name="dt_num" value="${myTeam.dt_number }"/>
	 	<input type="submit" class="btn btn-success" value="Upload">
	</form>
</div>
</c:if>