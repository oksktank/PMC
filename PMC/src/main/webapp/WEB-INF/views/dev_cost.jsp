<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<h1>${developer.name }의&nbsp;단가&nbsp;통계</h1>
<hr>
<p>단가 평균: ${average }</p>
<p>단가 분산: ${variance }</p>
<div id="container" style="min-width: 200px; height: 400px; margin: 0 auto">
	<script>
	$(function () {
	    var chart;
	    $(document).ready(function() {
	        chart = new Highcharts.Chart({
	            chart: {
	                renderTo: 'container',
	                type: 'line',
	                marginRight: 130,
	                marginBottom: 25
	            },
	            credits: {
					enabled:false
				},
	            title: {
	                text: '${developer.name}님의 개발단가변화입니다',
	                x: -20 //center
	            },
	            xAxis: {
	               
	            },
	            yAxis: {
	                title: {
	                    text: '개발단가'
	                },
	                plotLines: [{
	                    value: 0,
	                    width: 1,
	                    color: '#808080'
	                }]
	            },
	            tooltip: {
	                formatter: function() {
	                        return '<b>'+ this.series.name +'</b><br/>'+
	                        this.x +': '+ this.y ;
	                }
	            },
	            legend: {
	                layout: 'vertical',
	                align: 'right',
	                verticalAlign: 'top',
	                x: -10,
	                y: 100,
	                borderWidth: 0
	            },
	            series: [{
	                name: '${developer.name}',
	                data: ${costList}
	            }]
	        });
	    });
	    
	});
	</script>
</div>
