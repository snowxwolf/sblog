<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<title>文章类别列表</title>
<script type="text/javascript">
$(function(){
	 $('#tt').treegrid({    
		    url:'${pageContext.request.contextPath}/type/typeList.htm', 
		    height:450,
	        nowrap: false,
	        singleSelect:true,
	        striped: true,
	        fitColumns: true,
	    	animate:true,
		    idField:'id',    
		    treeField:'name', 
		    toolbar:[{
		    	iconCls: 'icon-add',
		    	text:'添加',
				handler: function(){
					
					window.location.href="${pageContext.request.contextPath}/type/toAddType.htm";
				}
		    	
		    }],
		    columns:[[    
		        {title:'类别名称',field:'name',width:180,align:'left'},    
		        {field:'descr',title:'描述',width:60,align:'center'},    
		        {
		        	field:'action',title:'操作',align:'center',width:120,
		        	formatter:function(value,rowData,index){
		        		return "<a href='#' onclick='deleteType("+rowData.id+");'>删除</a>"+
		        		"&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='updateType("+rowData.id+");'>修改</a>";
		        	}
		        }
		    ]]    
		});  

});
  
  function deleteType(id){
	  var r = window.confirm("您确定要删除该分类吗?");
	  if(r){
		  
		  $.post("${pageContext.request.contextPath}/type/deleteType.htm",
				  {id:id},
				  function(data){
					  if(data.result){
						  $.messager.alert("info",data.msg);
						 window.location.href= "${pageContext.request.contextPath}/type/toTypeList.htm";
					  }else{
						  $.messager.alert("info",data.msg);
					  }
				  },
				  "json");
	  }
	 
	  
  }
  //更新 
  function updateType(id){
	  window.location.href="${pageContext.request.contextPath}/type/toUpdateType.htm?id="+id;
  }
</script>

</head>

<body>

   <table id="tt" fit="true"></table>
</body>

</html>