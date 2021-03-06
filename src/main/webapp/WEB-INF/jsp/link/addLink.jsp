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
<title>菜单添加</title>
<script type="text/javascript">

   $(function(){
	   //初始化上一级菜单 
	   $("#parent").combobox({
		   url:"${pageContext.request.contextPath}/link/getParentLink.htm",
		   valueField:'id',    
		   textField:'name',
		   onSelect:function(data){
			  $("#parent_id").val(data.id);
		   }
		   
	   });
   });
  
   
   //保存链接 
   function saveLink(){
	   
	   $("#linkForm").form("submit",{
		   url:'${pageContext.request.contextPath}/link/addLink.htm',
		  
		   onSubmit:function(){
			 
			   var valid =$("#linkForm").form("validate"); 
			   return valid;
		   },
		   success:function(data){
			//TODO 为何data为空 
			   if (data.success){
				   $.messager.alert("info","链接添加成功!");
				   window.location.href="${pageContext.request.contextPath}/link/toLinkList.htm";
			   }else{
				   $.messager.alert("info","链接添加失败!");
			   }
			   window.location.href="${pageContext.request.contextPath}/link/toLinkList.htm";
		   }
		   
	   });
	   
	   
   }

</script>
</head>

<body>

   <div class="easyui-panel" title="添加链接" fit="true"   
    data-options="closable:true,collapsible:true,minimizable:true,maximizable:true"
    style="margin:0 auto;">
   
     <form id="linkForm">
       
        <table>
          <tr>
          <td>链接名称:</td>
          <td><input id="name" name="name" class="easyui-validatebox" required="true" ></td>
          </tr>
          
          <tr>
          <td>链接地址:</td>
          <td><input id="url" name="url" class="easyui-validatebox" data-options="validType:'url'"></td>
          </tr>
          
          <tr>
          <td>描述:</td>
          <td><input id="descr" name="descr"></td>
          </tr>
          
          <tr>
          <td>上级菜单:</td>
          <td><input id="parent" name="parent"><span style="color:red;">* 默认值为当前添加的菜单项为父项菜单</span>
          <input type="hidden" id="parent_id" value="0" name="parentId">
          </td>
          </tr>
          
          <tr>
          <td><a class="easyui-linkbutton" onclick="saveLink();">保存</a></td>
          <td><a class="easyui-linkbutton" onclick="reset();">重置</a></td>
          </tr>
        
        </table>
     
     
     </form>
   
   </div>

</body>

</html>