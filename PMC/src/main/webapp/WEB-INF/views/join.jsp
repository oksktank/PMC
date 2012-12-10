<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<style>
.td-background-color {background-color:EEEEEE;}
</style>

<script>
	function form_submit(){
		var form = document.forms['user_input'];
		alert('submit');
		save_selected_developers();
		
		form.submit();
		/*
		$.ajax({
			type:'POST',
			url:'${pageContext.request.contextPath}/func/insertWork',
			data:{
				name: w_name.value,
				description: description.value,
				expert_part: expert_part.value,
				detail_part: detail_part.value,
				developers: developers,
				cost: cost.value,
				start_period: start_period.value,
				end_period: end_period.value
			}
			
		});
		*/
	}
</script>

<h1>
	회원 가입
</h1>
<hr>

<div>
	<form id='user_input'  enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/func/insertUser">
		<table class="table table-bordered">
			<tr>
				<td class="td-background-color">역할</td>
				<td>
					<label class="radio">
					  <input type="radio" name="role" id="optionsRadios1" value="1">
					  개발자
					</label>
					<label class="radio">
					  <input type="radio" name="role" id="optionsRadios2" value="2">
					  평가자
					</label>
					<label class="radio">
					  <input type="radio" name="role" id="optionsRadios3" value="3">
					  관리자
					</label>
				</td>
			</tr>
			<tr>
				<td class="td-background-color">이름</td>
				<td><input type="text" name="w_name"></td>
			</tr>
			<tr>
				<td class="td-background-color">비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td class="td-background-color">전화번호</td>
				<td><input type="tel" name="w_name"></td>
			</tr>
			<tr>
				<td class="td-background-color">거주지</td>
				<td><input type="text" name="w_name"></td>
			</tr>
			<tr>
				<td class="td-background-color">전문분야</td>
				<td>
					<select name="expert_part">
					<c:forEach items="${expertField }" var="field">
						<option value="${field.id }">${field.name }</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td class="td-background-color">세부분야</td>
				<td>
					<select name="detail_part">
				  	<c:forEach items="${detailField }" var="field">
						<option value="${field.id }">${field.name }</option>
					</c:forEach>
					</select>
				</td>
			</tr>
		</table>
		<p>
			<button class="btn btn-large btn-block btn-primary" onclick="form_submit()">회원가입</button>
		</p>
	</form>


	
</div>
