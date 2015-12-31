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
<title>菜单添加</title>
<script type="text/javascript">

   $(function(){
	   //初始化上一级菜单 
	   $("#parent").combobox({
		   url:"${pageContext.request.contextPath}/menu/getParentMenu.htm",
		   valueField:'id',    
		   textField:'name',
		   onSelect:function(data){
			  $("#parent_menu_id").val(data.id);
		   }
		   
	   });
   });
  
   
   //保存菜单项 
   function saveMenu(){
	   
	   $("#menuForm").form("submit",{
		   url:'${pageContext.request.contextPath}/menu/addMenu.htm',
		   onSubmit:function(){
			   var valid =$("#menuForm").form("validate"); 
			   return valid;
		   },
		   success:function(info){
			   var data =eval('('+info+')');
			   if (data.success){
				   $.messager.alert("info",data.msg);
				   window.location.href="${pageContext.request.contextPath}/menu/menuList.htm";
			   }else{
				   $.messager.alert("info",data.msg);
			   }
		   }
		   
	   });
	   
	   
   }

</script>
</head>

<body>

   <div class="easyui-panel" title="添加菜单" fit="true"   
    data-options="closable:true,collapsible:true,minimizable:true,maximizable:true"
    style="margin:0 auto;">
   
     <form id="menuForm">
       
        <table>
          <tr>
          <td>菜单名称:</td>
          <td><input id="name" name="name" class="easyui-validatebox" required="true" ></td>
          </tr>
          
          <tr>
          <td>对应路径:</td>
          <td><input id="url" name="url" class="easyui-validatebox" required="true"></td>
          </tr>
          
          <tr>
          <td>图标:</td>
          <td><input id="icon" name="icon"></td>
          </tr>
          
          <tr>
          <td>上级菜单:</td>
          <td><input id="parent" name="parent"><span style="color:red;">* 默认值为当前添加的菜单项为父项菜单</span>
          <input type="hidden" id="parent_menu_id" value="0" name="parentId">
          </td>
          </tr>
          
          <tr>
          <td><a class="easyui-linkbutton" onclick="saveMenu();">保存</a></td>
          <td><a class="easyui-linkbutton" onclick="reset();">重置</a></td>
          </tr>
        
        </table>
     
     
     </form>
   
   </div>

</body>

</html>