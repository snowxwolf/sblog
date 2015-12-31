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
<title>标签列表</title>
<script type="text/javascript">

  function updateTag(){
	  
	  $("#tagForm").form("submit",{
	    	url:'${pageContext.request.contextPath}/tag/updateTag.htm',
	    	onSubmit:function(){
	    		var valid = $("#tagForm").form("validate");
	    		return valid;
	    	},
	    	success:function(info){
	    		var data = eval('('+info+')');
	    		if (data.result){
	        		$.messager.alert("info",data.msg);
	        		window.location.href="${pageContext.request.contextPath}/tag/toTagList.htm";
	        	}else{
	        		$.messager.alert("info",data.msg);
	        	}
	    	}
	    });
	  
  }

  

</script>

</head>

<body>

    <div  class="easyui-panel" fit="true">   
      
      <form id="tagForm" >
      <input  type="hidden" name="id" value="${tag.id}">
      <table>
      
       <tr>
       <td>标签名称:</td>
       <td><input name="name" class="easyui-validatebox" value="${tag.name}"></td>
       </tr>
       
        <tr>
       <td>标签描述:</td>
       <td><input name="desc" class="easyui-validatebox" value="${tag.desc}"></td>
       </tr>
       
        <tr>
       <td><a class="easyui-linkbutton" onclick="updateTag();">保存</a></td>
       <td><a class="easyui-linkbutton" onclick="reset();">重置</a></td>
       </tr>
      
      </table>
    </form>
    </div>   
    

</body>

</html>