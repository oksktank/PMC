<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<h1>
	용역 입력
</h1>
<hr>

<div >
	<form id='work_input' method="post" action="${pageContext.request.contextPath}/func/insertWork">
	<p>
	<button class="btn btn-large btn-block btn-primary" onclick="form_submit()">등록</button>
	</p>
	
	<p>
	용역이름
	<input type="text" name="w_name">
	</p>
	
	<p>
	용역설명
	<textarea rows="3" name="description"></textarea>
	</p>
	
	<p>
	전문분야
	<select name="expert_part">
  <option value="1">1</option>
  <option>2</option>
  <option>3</option>
  <option>4</option>
  <option>5</option>
</select>
	</p>
	
	<p>
	세부분야
	<select name="detail_part">
  <option value="1">1</option>
  <option>2</option>
  <option>3</option>
  <option>4</option>
  <option>5</option>
</select>
	</p>
	
	<p>
	개발자 초대기능
	<a href="#myModal" role="button" class="btn btn-danger" data-toggle="modal">개발자  선택</a>
 	</p>
 	
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
						<option value="디비">디비</option>
						<option value="웹">웹</option>
						<option>4</option>
						<option>5</option>
					</select>
				</div>
				<div style="float:right">
					<a href="#" role="button" class="btn btn-info" onclick="selectAll()">SelectAll</a>
					<a href="#" role="button" class="btn btn-inverse" onclick="deselectAll()">DeselectAll</a>
				</div>
			</div>
			<hr>
<script>
	var data = [{sn:'123',name:'영희',expert:'웹',cost:'300'},{sn:'1234',name:'쿠키',expert:'디비',cost:'300'},{sn:'13253',name:'영수',expert:'디비',cost:'300'},{sn:'19123',name:'구슬',expert:'웹',cost:'300'},{sn:'323',name:'고기',expert:'웹',cost:'300'},{sn:'1823',name:'용지',expert:'웹',cost:'300'},{sn:'1723',name:'방패',expert:'웹',cost:'300'},{sn:'12233',name:'꽃',expert:'디비',cost:'300'},{sn:'223',name:'냠냠',expert:'기타',cost:'300'},{sn:'1123',name:'레포트',expert:'디비',cost:'300'},{sn:'125',name:'철수',expert:'java',cost:'1000'}];
	var developers;
	/*
	if(jQuery.isEmptyObject(dList)){
		alert('asdf');
	}
	*/
	$(function(){
		jQuery.each(data, function(i,val) {
			var output='';
			output += '<tr id='+val.sn+' onclick="$(this).toggleClass(\'info\');">';
			output += '<td id='+val.expert+'>'+val.name+'</td>';
			output += '<td>'+val.expert+'</td>';
			output += '<td>'+val.cost+'</td>';
			output += '</td></tr>';
	       	$(output).appendTo('#developerList');
	    });
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
		var form = document.forms['work_input'];
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

<style>
	#developerlist {width:100%;}
</style>

			<div class="modal-body-list">
			<!-- 동적 생성 -->
				<table class="table table-hover table-condensed table-bordered" id="developerList">
						<tr class="warning">
							<td><b>Name</b></td>
							<td><b>Expert</b></td>
							<td><b>Location</b></td>
						</tr>
				</table>
			</div>
		</div>
		<div class="modal-footer">
	    	<button class="btn btn-primary" data-dismiss="modal">Close</button>
		</div>
	</div>
	 
	<input id="selectedDeveloperList" type="text" name="developers">
	
	<p>
	비용 설정
	<input type="text" name="cost">
	</p>
	<p>
	 	<input name="fileData" type="file"/>
	</p>
	<p>
	기간설정
	</p>
	
	
	<div>
	<div id="flight">

   <label> 
   	Start<br />  
   	<input type="date" name="start_period" /> 
   </label>
   
   <label> 
   	End<br /> 
   	<input type="date" name="end_period" data-value="7" /> 
   </label>
	</div>
	</div>
	</form>
	<script>
$(":date").dateinput({ trigger: true, format: 'yyyymmdd', min: -1 })

// use the same callback for two different events. possible with bind
$(":date").bind("onShow onHide", function()  {
	$(this).parent().toggleClass("active");
});

// when first date input is changed

$(":date:first").data("dateinput").change(function() {
	// we use it's value for the seconds input min option
	$(":date:last").data("dateinput").setMin(this.getValue(), true);
});
</script>

	
</div>