/*
 * author:jys
 */
var toolJYS;


function ToolJYS() {
		
	this.dateValue;
	
	this.back = function () {
		window.history.go(-1);
	}

	this.initDateValueRange=function (id,value) {
    	//初始化时间控件
		layui.use('laydate', function() {
		    var laydate=layui.laydate;
		    laydate.render({
		        elem: id, //指定元素
		        format:'yyyy-MM-dd',
//			        type: 'date',//format替代了
		        range:true,
		        value:value,
		        done: function(value, date, endDate){
					toolJYS.dateValue=value;
	            }
		    });
		});
	}

	this.initDateValue=function (id,value) {
    	//初始化时间控件
		layui.use('laydate', function() {
		    var laydate=layui.laydate;
		    laydate.render({
		        elem: id, //指定元素
//			        format:'yyyy-MM-dd',
		        type: 'date',//format替代了
		        range:false,
		        value:value,
		        done: function(value, date, endDate){
					toolJYS.dateValue=value;
		        }
		    });
		});
	}
	
	this.getQueryParameter=function (parameter){
           var query = window.location.search.substring(1);
           var vars = query.split("&");
           for (var i=0;i<vars.length;i++) {
                   var pair = vars[i].split("=");
                   if(pair[0] == parameter){return decodeURIComponent(pair[1]);}
           }
           return(false);
    }

	this.getTime=function (dateStr) {
    			if(dateStr.indexOf("-")==-1){
    				dateStr=dateStr.substring(0,4)+"-"+dateStr.substring(4,6)+"-"+dateStr.substring(6,8);
    			}
    	        var date = new Date(dateStr);
    	        var getTime_year = date.getFullYear();
    	        var getTime_month = (date.getMonth() + 1)<10?"0"+(date.getMonth() + 1):(date.getMonth() + 1);
    	        var getTime_date = date.getDate()<10?"0"+date.getDate():date.getDate();
    	        var getTime_day = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")[date.getDay()];
    	        var getTime_hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
    	        var getTime_minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
    	        var getTime_second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
    			var getTime_showTime = getTime_year+"-"+getTime_month+"-"+getTime_date;
    			var getTimeData={
    				year:getTime_year,
    				month:getTime_month,
    				date:getTime_date,
    				day:getTime_day,
    				hour:getTime_hour,
    				minute:getTime_minute,
    				second:getTime_second,
    				showTime:getTime_showTime
    			}
    			return getTimeData;
	}
}

	
$(function() {
	toolJYS = new ToolJYS();
});
