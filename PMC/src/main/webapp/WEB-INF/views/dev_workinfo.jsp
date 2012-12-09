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
<div id="team_member">
	<table class="table table-bordered">
		<tr class="td-background-color">
			<th>NO</th>
			<th>이름</th>
			<th>전문분야</th>
			<th>세부분야</th>
			<th>전문성</th>
		</tr>
		<tr>
			<td>1</td>
			<td>강개리</td>
			<td>랩</td>
			<td>격투</td>
			<td>2등급</td>
		</tr>
	</table>
</div>
		        
<div class="well">
	<form>
	 		<input name="fileData" type="file"/>
	</form>
</div>