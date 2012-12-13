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
<script>
	function evaluateGrade(r_num){
		
		var grade=$("#grade"+r_num).val();
		if(grade<0||grade>100){
			alert('올바른 범위의 점수를 입력해주세요(0~100)');
		}else{
			if(r_num!=''){
				$.ajax({
					url: "${pageContext.request.contextPath}/func/evaluate",
					type:'POST',
					data:{
						r_num:r_num,
						grade:grade
					},
					success:function(data){
						if(data=='Success'){
							location.reload();
						}else{
							alert('평가에 실패하였습니다.');
						}
					}
				});
			}
		}
	}
</script>
<h1>평가하기</h1>
<hr>

<div id="develop">
<c:forEach items="${evaluateJobList }" var="work">
<!-- 여기부터 -->
	<div class="well">
		<table id="work_info">
			<tr>
			<!-- wid로 구분 work/?wid=xxxx -->
				<td colspan="2" width="500"><a href="/PMC/dev/work?id=${work.dt_num }"><span id="work_header">${work.w_name }</span></a></td>
			</tr>
			<tr>
				<td colspan="2"><div class="work_description">
				${work.description }
				</div></td>
			</tr>
			<tr>
				<td>
				<span id="work_em">개발 결과물</span>
				<a href="${pageContext.request.contextPath }/func/download?fileName=${work.result_file_name}" class="btn btn-primary">Download</a>
				<td>
				</td>
				<td>
					<div class="input-append">
					    <input type="text" placeholder="점수(0~100)" id="grade${work.r_num }" class="span5">
					    <button type="button" class="btn btn-info" onClick="evaluateGrade('${work.r_num}')">평가</button>
					</div>
				</td>
			</tr>
		</table>
	</div>
<!-- 여기까지 반복 -->
</c:forEach>

</div>