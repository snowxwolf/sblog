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
	  
	  $("#tagList").datagrid({
		  url:'${pageContext.request.contextPath}/tag/tagList.htm',    
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
			   text:'添加新标签',
			   handler:function(){
				   window.location.href="${pageContext.request.contextPath}/tag/toAddTag.htm";
			   }
		   }
		   ],
		    columns:[[ 
		                 
		        {field:'name',title:'标签名称 ',width:100,align:'center',
		            	    formatter:function(value,rowData,index){
		            return "<a href='#' onclick='findTagById("+rowData.id+");'> "+rowData.name+"</a>";	    	
		        	
		        }},    
	             {field:'desc',title:'描述',width:100,align:'center'},
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
	  window.location.href="${pageContext.request.contextPath}/tag/toTagDetail.htm?id="+id;  
  }
  //修改 
  function updateById(id){
	 window.location.href="${pageContext.request.contextPath}/tag/toUpdateTag.htm?id="+id; 
  }
  //删除 
  function deleteById(id){
	var r = window.confirm("您确定要删除该标签吗?");  
	if (r){
		$.post('${pageContext.request.contextPath}/tag/deleteTag.htm',
				{id:id},
				function(data){
			if (data.result){
				$.messager.alert("info",data.msg);
				window.location.href="${pageContext.request.contextPath}/tag/toTagList.htm";
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
   
    <div data-options="region:'center',title:'标签列表'" style="background:#eee;">
     
        <div id="tagList"></div>
    
    </div>   
</div>  

 
</body>

</html>