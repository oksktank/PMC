<h1>
	용역 입력
</h1>
<hr>

<div id='work_input'>
	<form>
	<p>
	용역이름
	<input type="text" placeholder="asdf">
	</p>
	
	<p>
	용역설명
	<textarea rows="3"></textarea>
	</p>
	
	<p>
	전문분야
	<select>
  <option>1</option>
  <option>2</option>
  <option>3</option>
  <option>4</option>
  <option>5</option>
</select>
	</p>
	
	<p>
	세부분야
	<select>
  <option>1</option>
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
					<a href="#" role="button" class="btn btn-info" data-dismiss="modal">SelectAll</a>
					<a href="#" role="button" class="btn btn-inverse" data-dismiss="modal">DeselectAll</a>
				</div>
			</div>
			<hr>
<script>
	var data = [{sn:'123',name:'영희',expert:'웹',cost:'300'},{sn:'1234',name:'쿠키',expert:'디비',cost:'300'},{sn:'13253',name:'영수',expert:'디비',cost:'300'},{sn:'19123',name:'구슬',expert:'웹',cost:'300'},{sn:'323',name:'고기',expert:'웹',cost:'300'},{sn:'1823',name:'용지',expert:'웹',cost:'300'},{sn:'1723',name:'방패',expert:'웹',cost:'300'},{sn:'12233',name:'꽃',expert:'디비',cost:'300'},{sn:'223',name:'냠냠',expert:'기타',cost:'300'},{sn:'1123',name:'레포트',expert:'디비',cost:'300'},{sn:'125',name:'철수',expert:'java',cost:'1000'}];
	var dList = new Array;
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
		$('tr:hidden').show();
		if(v.value!=0){
			jQuery("#developerList > tbody").children("tr").each(function(){
				if($(this).children('td:first').attr('id')!=v.value){
					$(this).hide();
				}
			});
		}
	}
	
	function save_selected_developers(){
		var temp = new Array();
		jQuery("#developerList > tbody").children("tr").each(function(){
			if($(this).attr('class')){
				temp.push($(this).attr('id'));
			}
		});
		dList = temp;
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
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
	    	<button class="btn btn-primary" data-dismiss="modal" onclick="save_selected_developers()">Save changes</button>
		</div>
	</div>
	<!-- 
	<input id="selectedDeveloperList" type="text" name="obj">
	 -->
	<div>
		<table class="table table-hover" id="selectedDeveloperList"></table>
	</div>
	
	<p>
	비용 설정
	?????????
	</p>
	
	<p>
	기간설정
	??????
	</p>
	<p>
	<button class="btn btn-large btn-block btn-primary" type="submit">등록</button>
	</p>
	</form>
</div>