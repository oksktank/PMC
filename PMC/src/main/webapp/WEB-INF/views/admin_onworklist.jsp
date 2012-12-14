<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!-- 동작 방식

+ 버튼은 여러개 이지만 modal은 하나라서

+버튼을 누를 때 하당 wid를 기록함 (전역변수 var wid)

그리고 modal에서 의뢰 버튼을 누르면 wid랑 선택된평가자들을 request()함수에서 서버로 보내야됨

-->
<style>
.td_right {width:15%;}
.work_description {padding-left:30px; padding-bottom:20px;}
#work_info {width:100%;}
#work_info td {padding:5px;}
#work_header {font-size:20px; color:#BB0000; font-weight:bold;}
#work_em {font-size:20px; color:#003A9A; font-weight:bold; margin-right:30px;}
</style>

<script>
	var data = [{sn:'123',name:'영희',expert:'웹',cost:'300'},{sn:'1234',name:'쿠키',expert:'디비',cost:'300'},{sn:'13253',name:'영수',expert:'디비',cost:'300'},{sn:'19123',name:'구슬',expert:'웹',cost:'300'},{sn:'323',name:'고기',expert:'웹',cost:'300'},{sn:'1823',name:'용지',expert:'웹',cost:'300'},{sn:'1723',name:'방패',expert:'웹',cost:'300'},{sn:'12233',name:'꽃',expert:'디비',cost:'300'},{sn:'223',name:'냠냠',expert:'기타',cost:'300'},{sn:'1123',name:'레포트',expert:'디비',cost:'300'},{sn:'125',name:'철수',expert:'java',cost:'1000'}];
	var evaluators;
	var wid;
	/*
	if(jQuery.isEmptyObject(dList)){
		alert('asdf');
	}
	*/
	$(function(){
		/*jQuery.each(data, function(i,val) {
			var output='';
			output += '<tr id='+val.sn+' onclick="$(this).toggleClass(\'info\');">';
			output += '<td id='+val.expert+'>'+val.name+'</td>';
			output += '<td>'+val.expert+'</td>';
			output += '<td>'+val.cost+'</td>';
			output += '</td></tr>';
	       	$(output).appendTo('#developerList');
	    });*/
	});
	
	function part_change(v){
		$('#evaluatorList > tbody > tr:hidden').removeClass('hide');
		if(v.value!=0){
			jQuery("#evaluatorList > tbody").children("tr").each(function(){
				if($(this).children('td:first').attr('id')!=v.value){
					$(this).addClass('hide');
				}
			});
		}
	}
	function work_complete(v){
		alert(v+' '+evaluators);
		if(v!=''&&evaluators!=''){
		$.ajax({
			url: "${pageContext.request.contextPath}/admin/toEvaluator",
			type:'POST',
			data:{
				dt_num:v,
				evaluators:evaluators
			},
			success:function(data){
				if(data=='Success'){
					location.reload();
				}else{
					alert('평가 요청이 실패했습니다.');
				}
			}
		});
		}
	}
	function set_target(v){
		wid=v;
	}
	
	function request(){
		evaluators='';
		var evaluator='';
		$("#evaluators").html(evaluator);
		jQuery("#evaluatorList > tbody").children("tr").each(function(){
			if($(this).attr('class')=='info' || $(this).attr('class')=='info hide'){
				evaluators+=$(this).attr('id')+';';
				if(evaluator==''){
					evaluator+=$(this).find('.name').html();	
				}else{
					evaluator+=','+$(this).find('.name').html();
				}
				
				$("#evaluators").html(evaluator);
			}
		});
		
		//w랑 temp 서버로 전송해서 평가의뢰
		//location.href="/PMC/admin/on_work";
	}
	
</script>

<h1>평가의뢰대기Works</h1>
<hr>

<div id="onwork_list">
<!-- 여기부터 -->
	<c:forEach items="${onWorkList }" var="work">
		<div class="well">
		<table id="work_info">
			<tr>
				<td><span id="work_header"><a href="${pageContext.request.contextPath }/admin/work?id=${work.dt_num}">${work.w_name }</a></span></td>
				<td class="td_right">
				<button class="btn btn-warning" onclick="work_complete('${work.dt_num}');"><b>평가 의뢰</b></button>
				</td>
			</tr>
			<tr>
				<td colspan="2"><div class="work_description">
				${work.description }<br/><br/><b>결과물</b> : <a href="${pageContext.request.contextPath }/func/download?fileName=${work.result_file_name }" class="btn btn-success">다운로드</a>
				</div></td>
			</tr>
			<tr>
				<td colspan="2">
				<span id="work_em">평가의뢰</span>
				<span id="evaluators"></span>
				<a href="#myModal" class="btn btn-info" onclick="set_target(wid);" data-toggle="modal"><b>+</b></a>
				</td>
			</tr>
		</table>
		</div>
	</c:forEach>
	
<!-- 여기까지 반복 -->

</div>


		<!-- Modal -->
		<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    	<h3 id="myModalLabel">Evaluator List</h3>
			</div>
			
			<div class="modal-body">
				<div class="modal-body-option">
					<div style="float:left">
						<select onchange="part_change(this)">
							<option value="0">분야선택</option>
							<c:forEach items="${expertField }" var="field">
								<option value="${field.name }">${field.name }</option>
							</c:forEach>
						</select>
					</div>
					<!--
					<div style="float:right">
						<a href="#" role="button" class="btn btn-info" onclick="selectAll()">SelectAll</a>
						<a href="#" role="button" class="btn btn-inverse" onclick="deselectAll()">DeselectAll</a>
					</div>
					 -->
				</div>
				<div class="modal-body-list">
				<!-- 동적 생성 -->
					<table class="table table-hover table-condensed table-bordered" id="evaluatorList">
							<tr class="warning">
								<td><b>Name</b></td>
								<td><b>Expert</b></td>
								<td><b>Detail</b></td>
							</tr>
							<c:forEach items="${allEva }" var="eva">
								<tr id="${eva.sn }" onclick="$(this).toggleClass('info');">
									<td id="${eva.expert_part_name}" class="name">${eva.name}</td>
									<td>${eva.expert_part_name}</td>
									<td>${eva.detail_part_name}</td>
								</tr>
							</c:forEach>
					</table>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary"  data-dismiss="modal" onclick="request()">의뢰</button>
			</div>
		</div>