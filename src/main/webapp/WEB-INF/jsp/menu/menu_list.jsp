<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<title>菜单列表</title>
 <script type="text/javascript">
 
 $(function(){
	 $('#tt').treegrid({    
		    url:'${pageContext.request.contextPath}/menu/findAllMenusTree.htm', 
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
					
					window.location.href="${pageContext.request.contextPath}/menu/toAddMenu.htm";
				}
		    	
		    }],
		    columns:[[    
		        {title:'菜单名称',field:'name',width:180,align:'left'},    
		        {field:'icon',title:'对应图标',width:60,align:'center'},    
		        {field:'url',title:'对应的链接',width:80,align:'center'},    
		        {field:'createTime',title:'创建日期',align:'center',width:80,formatter:function(value,rowData,index){
		        	if (value==null)
		        		return "";
		        	var date = new Date(value);
		        	var year = date.getFullYear();
		        	var month =date.getMonth()+1;
		        	var day = date.getDate();
		        	return year+"-"+month+"-"+day;
		        }} ,
		        {
		        	field:'action',title:'操作',align:'center',width:120,
		        	formatter:function(value,rowData,index){
		        		return "<a href='#' onclick='deleteMenu("+rowData.id+");'>删除</a>"+
		        		"&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='updateMenu("+rowData.id+");'>修改</a>";
		        	}
		        }
		    ]]    
		});  

 });
 
 // 删除此菜单项 
  function deleteMenu(id){
	var r = window.confirm("您确定要删除此菜单项吗?可能会删除级联的所有子菜单.");
	if (r){
		$.post("${pageContext.request.contextPath}/menu/deleteMenuById.htm",{id:id},function(data){
			if (data.sucess){
			$.messager.alert("info",data.msg);
			}else{
				$.messager.alert("info",data.msg);
			}
			$("#tt").treegrid("reload");
		},"json");
	}
  }
 // 更新菜单项 
 function updateMenu(id){
	 window.location.href="${pageContext.request.contextPath}/menu/updateMenu.htm?id="+id;
 }

 </script>
</head>
<body>
 
   <table id="tt" fit="true"></table> 
   
  

</body>
</html>