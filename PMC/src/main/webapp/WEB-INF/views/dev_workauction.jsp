<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<style>
#input_button {text-align:right;}
.td_right {width:15%;}
#team_info {width:100%; text-align:center;}
#developerlist {width:100%;}
.td-background-color {background-color:EEEEEE;}
#myModal {text-align:left;}
</style>
<script>
	var data = [{sn:'123',name:'영희',expert:'웹',cost:'300'},{sn:'1234',name:'쿠키',expert:'디비',cost:'300'},{sn:'13253',name:'영수',expert:'디비',cost:'300'},{sn:'19123',name:'구슬',expert:'웹',cost:'300'},{sn:'323',name:'고기',expert:'웹',cost:'300'},{sn:'1823',name:'용지',expert:'웹',cost:'300'},{sn:'1723',name:'방패',expert:'웹',cost:'300'},{sn:'12233',name:'꽃',expert:'디비',cost:'300'},{sn:'223',name:'냠냠',expert:'기타',cost:'300'},{sn:'1123',name:'레포트',expert:'디비',cost:'300'},{sn:'125',name:'철수',expert:'java',cost:'1000'}];
	var developers;
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
		$('#developerList > tbody > tr:hidden').removeClass('hide');
		if(v.value!=0){
			jQuery("#developerList > tbody").children("tr").each(function(){
				if($(this).children('td:first').attr('id')!=v.value){
					$(this).addClass('hide');
				}
			});
		}
	}
	/*
	function selectAll(){
		jQuery("#developerList > tbody").children("tr").each(function(){
			if(!($(this).attr('class'))){
				$(this).addClass('info');
			}
		});
	}
	function deselectAll(){
		jQuery("#developerList > tbody").children("tr").each(function(){
			if($(this).attr('class')=='info'){
				$(this).removeClass('info');
			}
		});
	}
	*/
	function save_selected_developers(){
		var temp = '';
		jQuery("#developerList > tbody").children("tr").each(function(){
			if($(this).attr('class')=='info' || $(this).attr('class')=='info hide'){
				temp+=$(this).attr('id')+';';
			}
		});
		$("#selectedDeveloperList").val(temp);
		alert($("#selectedDeveloperList").val());
		//alert(temp.length);
	}
	function form_submit(){
		var form = document.forms['team_input'];
		alert('submit');
		save_selected_developers();

		//<input id="selectedDeveloperList" type="hidden" 얘를 전송함
		form.submit();
	}
</script>


<h1>프로젝트이름</h1>
<hr>
<div id="project_info">
<table class="table table-bordered">
		        	<tr>
		        		<td class="td-background-color" style="width:100px">용역 이름
		        		</td>
		        		<td>Facebook 연동 mobile application 개발</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">개발내용
		        		</td>
		        		<td>Facebook의 기능과 mobile의 기능이 연동되는 application
	Facebook application 형태로 패키징하여 facebook에 등록</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">기간
		        		</td>
		        		<td>2012.12 ~ 2013.2 (3개월)</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">인센티브
		        		</td>
		        		<td>3000</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">전문분야
		        		</td>
		        		<td>HTML/CSS/Javascript를 이용한 web programming 기술</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">세부분야
		        		</td>
		        		<td>HTML/CSS/Javascript를 이용한 web programming 기술</td>
		        	</tr>
		        	<tr>
		        		<td class="td-background-color" style="width:100px">첨부파일
		        		</td>
		        		<td>
		        		<a href="#" class="btn btn-primary">Download</a>
		        		</td>
		        	</tr>
		        </table>
		        </div>
<div id="input_button">
	<form class="bid">
	  <div class="input-append">
	    <input type="text" class="span2">
	    <span class="add-on">원</span>
	    <button type="submit" class="btn btn-danger">입찰하기</button>
	  </div>
	</form>

	<!-- 둘 중 하나 띄우게 -->
	<!-- 팀 있으면 -->
	<div id="my_team_info">
		<span><b>My Team : </b> 팀이름(팀원1,팀원2,팀원3,팀원4)</span>
	</div>
	<!-- 팀 없으면 -->
	<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2 -->
	<div id="team_create">
		<a href="#myModal" role="button" class="btn btn-success" data-toggle="modal"><b>팀 생성</b></a>
	 	
		<!-- Modal -->
		<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    	<h3 id="myModalLabel">Developer List</h3>
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
					<table class="table table-hover table-condensed table-bordered" id="developerList">
							<tr class="warning">
								<td><b>Name</b></td>
								<td><b>Expert</b></td>
								<td><b>Location</b></td>
							</tr>
							<c:forEach items="${allDev }" var="dev">
								<tr id="${dev.sn }" onclick="$(this).toggleClass('info');">
									<td id="${dev.expert_part_name}">${dev.name}</td>
									<td>${dev.expert_part_name}</td>
									<td>${dev.address}</td>
								</tr>
							</c:forEach>
					</table>
				</div>
			</div>
			<div class="modal-footer">
				<form id="team_input" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/func/insertTeam">
				<div class="input-prepend input-append">
					<span class="add-on">팀 이름</span>
					<input id="selectedDeveloperList" type="hidden" name="developers">
				    <input type="text" id="team_name" class="span5">
				    <button type="submit" class="btn btn-danger" data-dismiss="modal">생성</button>
				</div>
				</form>
			</div>
		</div>
	</div>
<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2 -->
</div>
<hr>
<div id="auction_list">

<!-- 여기부터 -->
	<div class="well">
		<table id="team_info">
			<tr>
				<th>TEAM REAL</th>
				<th class="td_right">입찰가</th>
			</tr>
			<tr>
				<td>이한솔 김상훈 김원석 노원우</td>
				<td class="td_right">2400</td>
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