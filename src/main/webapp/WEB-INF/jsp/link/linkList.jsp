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
<title>标签列表</title>
<style type="text/css">
 a{
 text-decoration:none;
 }
</style>
<script type="text/javascript">

  $(function(){
	  
	  $("#linkList").treegrid({
		  url:'${pageContext.request.contextPath}/link/linkList.htm',    
		  nowrap: false,
	        singleSelect:true,
	        striped: true,
	        fitColumns: true,
	    	animate:true,
		    idField:'id',    
		    treeField:'name',
		   toolbar:[{
			   iconCls:'icon-add',
			   text:'添加新链接',
			   handler:function(){
				   window.location.href="${pageContext.request.contextPath}/link/toAddLink.htm";
			   }
		   }
		   ],
		    columns:[[ 
		                 
		        {field:'name',title:'链接名称 ',width:100,align:'left',
		            	    formatter:function(value,rowData,index){
		            return "<a href='#' onclick='findTagById("+rowData.id+");'> "+rowData.name+"</a>";	    	
		        	
		        }},  
		        {field:'url',title:'链接',width:100,align:'center',formatter:function(value,rowData,index){
		        	
		        	return "<a href="+rowData.url+" target='blank'>"+rowData.url+"</a>";
		        }},
	             {field:'descr',title:'描述',width:100,align:'center'},
		        {field:'act',title:'操作',width:100,align:'center',
		        	formatter:function(value,rowData,index){
		        		
		        		return "<a href='#' onclick='updateById("+rowData.id+");' >修改 </a>  <a href='#' onclick='deleteById("+rowData.id+");'>删除</a>";
		        	}
		        }
		    ]]    
		  
	  });
	  
  });
  //查看详情 
  function findTagById(id){
	  window.location.href="${pageContext.request.contextPath}/link/toLinkDetail.htm?id="+id;  
  }
  //修改 
  function updateById(id){
	 window.location.href="${pageContext.request.contextPath}/link/toUpdateLink.htm?id="+id; 
  }
  //删除 
  function deleteById(id){
	var r = window.confirm("您确定要删除该链接吗?");  
	if (r){
		$.post('${pageContext.request.contextPath}/link/deleteLink.htm',
				{id:id},
				function(data){
			if (data.result){
				$.messager.alert("info",data.msg);
				window.location.href="${pageContext.request.contextPath}/link/toLinkList.htm";
			}else{
				$.messager.alert("info",data.msg);
			}
		},
		"json");
	}
  }

</script>

</head>

<body>

   <div  class="easyui-layout" fit="true">   
    <div data-options="region:'center',title:'链接列表'" style="background:#eee;">
     
        <div id="linkList"></div>
    
    </div>   
</div>  

 
</body>

</html>