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
<title>文章类别更新</title>
<script type="text/javascript">
  
  $(function(){
	  
	  $("#parent").combobox({
		  url:"${pageContext.request.contextPath}/type/getParentType.htm",
		   valueField:'id',    
		   textField:'name',
		   onSelect:function(data){
			  $("#parent_id").val(data.id);
		   }
	  });
	  
	  $("#parent").combobox('setValue',$("#pid").val());
	  $("#parent_id").val($("#pid").val());
  });
  
  function addType(){
	  
	  $("#typeForm").form("submit",{
		  url:'${pageContext.request.contextPath}/type/updateType.htm',
		  onSubmit:function(){
			  var valid =$("#typeForm").form("validate");
			  return valid;
		  },
		  success:function(info){
			  var data  = eval('('+info+')');
			  if(data.result){
				  $.messager.alert("info",data.msg);
				 window.location.href= "${pageContext.request.contextPath}/type/toTypeList.htm";
			  }else{
				  $.messager.alert("info",data.msg);
			  }
		  }
		  
		  
	  });
	  
  }
</script>

</head>

<body>

   <div class="easyui-panel" fit="true" >
      
       <form id="typeForm">
         <input type="hidden" name="id" value="${type.id}" >
          <input type="hidden"id="pid" value="${type.parentId}" >
         <table>
          <tr>
          <td>文章类别名称:</td>
           <td><input name="name" value="${type.name}" class="easyui-validatebox" required="true"></td>
          </tr>
          
          <tr>
           <td>文章类别描述:</td>
           <td><input name="descr" value="${type.descr}" class="easyui-validatebox" required="true"></td>
          </tr>
          
          <tr>
           <td>文章类别上一级菜单:</td>
           <td><input name="parent" id="parent">
            <input type="hidden" id="parent_id" value="0" name="parentId" >
           </td>
          
          </tr>
         
          <tr>
          <td><a class="easyui-linkbutton" onclick="addType();">保存</a>
          <a class="easyui-linkbutton" onclick="reset();">重置</a>
          </td>
          </tr>
         
         </table>
       
       
       </form>
   
   </div>
</body>

</html>