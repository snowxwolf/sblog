<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
isELIgnored="false" %>
<html>
 
 <head>
   <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
   <title>内容列表页面</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
  <style type="text/css">
  a{
  text-decoration:none;
  }
  </style>
  <script type="text/javascript">
   $(function(){
	   $("#artList").datagrid({
		   url:'${pageContext.request.contextPath}/article/findArticles.htm',    
		   pagination:true,
		   fitColumns:true,
		   height:400,
		   rownumbers:true,
		   checkOnSelect:false,
		   singleSelect:true,
		   nowrap:true,
		   pageSize:10,
		   pageList:[10,20,30,50],
		   toolbar:[{
			   iconCls:'icon-add',
			   text:'添加文章',
			   handler:function(){
				   window.location.href="${pageContext.request.contextPath}/article/toAddArticle.htm";
			   }
		   },{
			   iconCls:'icon-remove',
			   text:'删除',
			   handler:function(){
				   
			   }
		   },{
			   iconCls:'icon-edit',
			   text:'发布文章',
			   handler:function(){
				   
			   }
		   }
		   ],
		    columns:[[ 
		              {field:'ck',checkbox:true},      
		        {field:'title',title:'标题 ',width:100,align:'center',
		            	    formatter:function(value,rowData,index){
		            return "<a href='#' onclick='findArticleById("+rowData.id+");'> "+rowData.title+"</a>";	    	
		        	
		        }},    
		        {field:'publishTime',title:'发布时间',width:100,
		        	formatter:function(value,rowData,index){
		        	var date = new Date(value);
		        	var year = date.getFullYear();
		        	var month = date.getMonth()+1;
		        	var day = date.getDate();
		        	var hour = date.getHours();
		        	var minutes = date.getMinutes();
		        	var seconds = date.getSeconds();
		        	if (month<10){
		        		month='0'+month;
		        	}
		        	if (day<10){
		        		day = '0'+day;
		        	}
		        	if (hour<10){
		        		hour = '0'+hour;
		        	}
		        	if (minutes<10){
		        		minutes = '0'+minutes;
		        	}
		        	if (seconds<10){
		        		seconds = '0'+seconds;
		        	}
		        	return year+"-"+month+"-"+day+" "+hour+":"+minutes+":"+seconds;
		        }},    
		        {field:'status',title:'状态',width:100,align:'center',
		        	formatter:function(value,rowData,index){
		        	return rowData.status==0?"待发布":rowData.status==1?"已发布":'未知';
		        }} ,
		        {field:'act',title:'操作',width:100,align:'center',
		        	formatter:function(value,rowData,index){
		        		
		        		return "<a href='#' onclick='updateById("+rowData.id+");' >修改 </a>  <a href='#' onclick='deleteById("+rowData.id+");'>删除</a>";
		        	}
		        }
		    ]]    

	   });
   });
   
   //根据 id查询文章内容 
   function findArticleById(id){
	   
	    window.location.href="${pageContext.request.contextPath}/article/getContentById.htm?id="+id;
   }
   
   //更新 文章内容 
   function updateById(id){
	   
	    window.location.href="${pageContext.request.contextPath}/article/toUpdate.htm?id="+id;
   }
  </script>
 </head>
 
 <body>
 
    <div  class="easyui-layout" fit="true">   
   
    <div data-options="region:'center',title:'文章列表'" style="background:#eee;">
       <form action="">
       <table>
       <tr>
       <td>
       <span>标题:</span><input id="title">
        <span>类型:</span><input id="type">
         <span>发布时间:</span><input id="start" class="easyui-datebox" data-options="editor:false">
         <span>-</span><input id="end" class="easyui-datebox" data-options="editor:false">
         
         <a class="easyui-linkbutton">查询</a>
          <a class="easyui-linkbutton">重置</a>
       </td>
       
       
       </tr>
       </table>
     </form>
        <div id="artList"></div>
    
    </div>   
</div>  
    
   
 
  
 </body>

</html>