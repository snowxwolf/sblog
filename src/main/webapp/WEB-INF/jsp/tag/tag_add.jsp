<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"s%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<title>标签添加</title>
<script type="text/javascript">
//保存标签
 function saveTag(){
	 var name = $("#name").val();
	 var desc = $("#desc").val();
	 if (name==null||name==''){
		 
		 $.messager.alert("提示","标签名称不能为空","warning");
		 return ;
	 }
    if (desc==null||desc ==''){
		 
		 $.messager.alert("提示","标签描述不能为空","warning");
		 return ;
	 }
    
    $("#tagForm").form("submit",{
    	url:'${pageContext.request.contextPath}/tag/saveTag.htm',
    	onSubmit:function(){
    		var valid = $("#tagForm").form("validate");
    		return valid;
    	},
    	success:function(info){
    		var data = eval('('+info+')');
    		if (data.result){
        		$.messager.alert("提示",data.msg,"info");
        		window.location.href="${pageContext.request.contextPath}/tag/toTagList.htm";
        	}else{
        		$.messager.alert("提示",data.msg,"error");
        	}
    	}
    });
   
 }
 
 //重置 
 function reset(){
	 
	 $("#tagForm").form("reset");
	 
 }

</script>

</head>

<body style="text-align: center;">

  <div class="easyui-panel" 
        title="My Panel"     
        style="width:270px;height:150px;background:#fafafa;"   
        data-options="iconCls:'icon-save',closable:true,    
                collapsible:true,minimizable:true,maximizable:true"> 
     
     <form  id="tagForm"  >
      <table>
      
        <tr>
         <td>标签名称:</td>
         <td><input id="name" name="name" class="easyui-validatebox" ></td>
        </tr>
        
        <tr>
         <td>标签描述:</td>
         <td><input id="desc" name="desc"  class="easyui-validatebox"  ></td>
        </tr>
        
        <tr>
         <td></td>
         <td><a class="easyui-linkbutton" onclick="saveTag();" >保存 </a>
         &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
         <a class="easyui-linkbutton" onclick="reset();" >重置</a></td>
        </tr>
      </table>
  
  </form>
  </div>

  

</body>

</html>