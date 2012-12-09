<!-- work별 페이지 
	초대된 개발자들끼리 이 페이지에 접속해서
	그룹도 만들고 경매도 함
	
	용역의뢰자는 여기서 구경하다 개발자팀을 선택할 수 있음 -->
	<style>
	.asdf{background-color:EEEEEE;}
	</style>
<div style="width:900px">
	<h1>
		New Works
	</h1>
	<hr>
	
	
	<div class="accordion" id="accordion2">
	  <div class="accordion-group">
	    <div class="accordion-heading">
	      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
	        	곰인형 로봇을 사용한 교육용 PC Application Game 개발
	      </a>
	    </div>
	    <div id="collapseOne" class="accordion-body collapse in">
	      <div class="accordion-inner">
	        <table class="table table-bordered">
	        	<tr>
	        		<td class="asdf" style="width:100px">용역 이름
	        		</td>
	        		<td>샬라샬라</td>
	        	</tr>
	        </table>
	      </div>
	    </div>
	  </div>
	  <div class="accordion-group">
	    <div class="accordion-heading">
	      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
	        Facebook 연동 mobile application 개발
	      </a>
	    </div>
	    <div id="collapseTwo" class="accordion-body collapse">
	      <div class="accordion-inner">
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
	    </div>
	  </div>
	  <div class="accordion-group">
	    <div class="accordion-heading">
	      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
	        내일로 여행을 위한 여행 가이드 Mobile Application 개발
	      </a>
	    </div>
	    <div id="collapseThree" class="accordion-body collapse">
	      <div class="accordion-inner">
	        Anim pariatur cliche...
	      </div>
	    </div>
	  </div>
	  <div class="accordion-group">
	    <div class="accordion-heading">
	      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse4">
	        수학 함수 그래프 이해를 돕는 교육용 게임 개발
	      </a>
	    </div>
	    <div id="collapse4" class="accordion-body collapse">
	      <div class="accordion-inner">
	        Anim pariatur cliche...
	      </div>
	    </div>
	  </div>
	  <div class="accordion-group">
	    <div class="accordion-heading">
	      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse5">
	        Real time Web based Game
	      </a>
	    </div>
	    <div id="collapse5" class="accordion-body collapse">
	      <div class="accordion-inner">
	        Anim pariatur cliche...
	      </div>
	    </div>
	  </div>
	</div>

</div>
<p>
<button class="btn btn-primary">　　　　　</button>
</p>
<p>
<button class="btn btn-inverse">　　　　　</button>
</p>
<p>
<button class="btn btn-success">　　　　　</button>
</p>
<p>
<button class="btn btn-info">　　　　　</button>
</p>
<p>
<button class="btn btn-warning">　　　　　</button>
</p>
<p>
<button class="btn btn-danger">　　　　　</button>
</p>

<style>
div {border:1px;}
</style>
<div class='row'>
	<div id='left' class='span2'>
		<div id='my_team'>
			내 정보 + 팀 정보
			+	팀삭제버튼
		</div>
	</div>
	
	
	<div id='right' class='span7'>
		<div id='work_info'>
			워ㅡ 워크 워크 다이나믹 프로그래밍으로 만드렴
		</div>
	
		<div id='auction_board'>
			100원
			200원
			300원
			400원
			500원
		</div>
	
	</div>
</div>



<div>
	<form id='work_input' method="post" action="${pageContext.request.contextPath}/func/insertWork">

	<p>
	개발자 초대기능
	<a href="#myModal" role="button" class="btn btn-danger" data-toggle="modal">팀 만들기</a>
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
				<div id="selectedList"></div>
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
	    	<button class="btn btn-primary" data-dismiss="modal">팀 만들기</button>
		</div>
	</div>
	 
	<input id="selectedDeveloperList" type="text" name="developers">
	
</div>