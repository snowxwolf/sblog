<%@page import="java.net.InetAddress"%>
<%@page import="java.util.Properties"%>
<%@page contentType="text/html; charset=utf-8" 
language="java" pageEncoding="utf-8" isELIgnored="false"%>
<html>
   <head>
      <title>监控-服务器信息</title>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/bootstrap/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/highcharts/highcharts.js"></script>
      <script type="text/javascript">
      <%
      Properties p =System.getProperties();
      InetAddress ip=InetAddress.getLocalHost();
      Runtime r = Runtime.getRuntime();
      %>
      
      $(function () {
    	  
    	    $(document).ready(function() {
    	        Highcharts.setOptions({
    	            global: {
    	                useUTC: false
    	            }
    	        });
    	    
    	        var chart;
    	        $('#lineChart').highcharts({
    	            chart: {
    	                type: 'spline',
    	                //animation: Highcharts.svg, // don't animate in old IE
    	                marginRight: 10,
    	                events: {
    	                    load: function() {
    	                        // set up the updating of the chart each second
    	                        var series = this.series[0];
    	                        setInterval(function() {
    	                            var x = (new Date()).getTime(), // current time
    	                                y =<%=r.totalMemory()/(1024*1024)%>;
    	                            series.addPoint([x, y], true, true);
    	                        }, 1000);
    	                    }
    	                }
    	            },
    	             title:{
    	            	text:"JVM内存使用情况"
    	            },
    	            xAxis: {
    	            	title:{
    	            		text:"时间"
    	            	},
    	                type: 'datetime',
    	                tickPixelInterval: 150
    	            },
    	            yAxis: {
    	                title: {
    	                    text: 'JVM 内存使用情况(M)'
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
    	                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
    	                        Highcharts.numberFormat(this.y, 2);
    	                }
    	            },
    	            legend: {
    	                enabled: false
    	            },
    	            exporting: {
    	                enabled: false
    	                
    	            },
    	            credits:{
    	            	enabled:false
    	            },
    	            series: [{
    	                name: '使用内存',
    	                data: (function() {
    	                    var data = [],
    	                        time = (new Date()).getTime(),
    	                        i;
    	    
    	                    for (i = -19; i <= 0; i++) {
    	                        data.push({
    	                            x: time + i * 1000,
    	                            y:<%=r.totalMemory()/(1024*1024)%>
    	                        });
    	                    }
    	                    return data;
    	                })()
    	            }]
    	        });
    	    });
    	    
    	    $("#pg").propertygrid();
       	   
         	 var row1 = {    
         			  name:'a.操作系统',    
         			  value:'<%=p.getProperty("os.name")%>',    
         			  group:'Marketing Settings'
         			};    
         			$('#pg').propertygrid('appendRow',row1);  
         			
         			 var row2 = {    
         	      			  name:'b.主机IP',    
         	      			  value:'<%=ip.getHostAddress().toString()%>',    
         	      			  group:'Marketing Settings'
         	      			};    
         	      			$('#pg').propertygrid('appendRow',row2);  
         	      			
         	      		 var row3 = {     
         	       			  name:'c.应用服务器',    
         	       			  value:'<%=pageContext.getServletContext().getServerInfo()%>',    
         	       			  group:'Marketing Settings'
         	       			};    
         	       			$('#pg').propertygrid('appendRow',row3);  
         	       			
         	       		 var row4 = {    
         	       			  name:'d.监听端口',    
         	       			  value:'<%=request.getServerPort()%>',    
         	       			  group:'Marketing Settings'
         	       			};    
         	       			$('#pg').propertygrid('appendRow',row4);  
         	       			
         	       			
         	       			
         	       		 var row5 = {    
         	       			  name:'e.Web根路径',    
         	       			  value:'<%=System.getenv("CATALINA_HOME")%>',    
         	       			  group:'Marketing Settings'
         	       			};    
         	       			$('#pg').propertygrid('appendRow',row5);  
         	       		
         	       			
         	       		 var row6 = {    
         	       			  name:'f.servlet版本',    
         	       			  value:'<%=pageContext.getServletContext().getMajorVersion()%>',    
         	       			  group:'Marketing Settings'
         	       			};    
         	       			$('#pg').propertygrid('appendRow',row6);  
         	       			
         	       			
         	       		 var row7 = {    
         	       			  name:'g.JVM版本',    
         	       			  value:'<%=p.getProperty("java.vm.version")%>',    
         	       			  group:'Marketing Settings'
         	       			};    
         	       			$('#pg').propertygrid('appendRow',row7);  
         	       			
         	       		 var row8 = {    
         	       			  name:'h.JVM提供商',    
         	       			  value:'<%=p.getProperty("java.vm.vendor")%>',    
         	       			  group:'Marketing Settings'
         	       			};    
         	       			$('#pg').propertygrid('appendRow',row8); 
         	       			
         	       		 var row9 = {    
         	       			  name:'i.JVM 安装路径',    
         	       			  value:'<%=p.getProperty("java.home")%>',    
         	       			  group:'Marketing Settings'
         	       			//  editor:"text"
         	       			 
         	       			}; 
         	       		 
         	       			$('#pg').propertygrid('appendRow',row9);  
         	       			
         	       		 var row10 = {    
         	       			  name:'j.JVM最大可用内存',    
         	       			  value:'<%=r.maxMemory()/(1024*1024)%>'+"M",    
         	       			  group:'Marketing Settings'
         	       			};    
         	       			$('#pg').propertygrid('appendRow',row10);  
    	    
    	});
      
    
      </script>
     
   </head>
   
   <body>
        
       <div id="cc" class="easyui-layout" fit="true">   
   
   
    <div data-options="region:'west',title:'服务器信息',split:true" style="width:360px" >
      
    <table id="pg" fit="true" >
    
    </table>  

    
    </div>  
     
    <div data-options="region:'center'">
    
      <div id="lineChart"></div>
    
    </div>  
     
      </div>  
     
   </body>


</html>