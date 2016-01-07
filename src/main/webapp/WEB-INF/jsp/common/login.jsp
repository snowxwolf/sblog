<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
    <c:set var="tgt" value="${pageContext.request.contextPath}"></c:set>
     <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
<script type="text/javascript" src="${tgt}/js/jquery-2.1.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
     
    <title>登录</title>
    <script type="text/javascript">
  
      
      function login(){
    	  $("#loginForm").form("submit",{
    		  url:"${pageContext.request.contextPath}/login.htm",
    		  onSubmit:function(){
    			  
    			  return   $("#loginForm").form("validate");
    		  },
    		  success:function(info){
    			  
    			  var  data = eval("("+info+")");
    			  
    			  if (data.success){
        			  $.messager.alert("提示","用户登录成功","info");
        			  
        			  //到首页  
        			  window.location.href="${pageContext.request.contextPath}/index.htm";
        		  }else{
        			  $.messager.alert("提示","用户登录失败","info");
        		  }
    			  
    		  }
    		  
    		  
    	  });
    	/*   $.post("${pageContext.request.contextPath}/login.htm",
    			  $("#loginForm").serialize(),
    			  function(data){
    		  if (data.success){
    			  $.messager.alert("提示","用户登录成功","info");
    		  }else{
    			  $.messager.alert("提示","用户登录失败","info");
    		  }
    		  
    	  },
    	 "json"); */
    	  
      }
    
      // 重置 
    function reset(){
    	
    $("#loginForm").form("reset");	
    	
    }
    
    </script>
    </head>
    
    <body>
      
      <div id="loginWin" class="easyui-window" title="登录"     
        style="width:350px;height:300px;background:#fafafa;"   
        data-options="modal:true,draggable:true,inline:true">
       
       <form id="loginForm" class="easyui-form" style="margin-left: 40px;margin-top:30px;">
         <table>
          <tr>
           <td>用户名:</td>
           <td>
            <input type="text" class="easyui-validatebox" name="name" required="true" missingMessage="用户名不能为空" data-options="validType:length[0,100]">
           </td>
          </tr>
          
           <tr>
           <td>密码:</td>
           <td>
            <input type="password" class="easyui-validatebox" name="pwd" required="true" missingMessage="密码不能为空" data-options="validType:length[0,100]">
           </td>
          </tr>
          
          <tr>
          <td></td>
          <td><a class="easyui-linkbutton" onclick="login();">登录</a>&nbsp;&nbsp;
           <a class="easyui-linkbutton" onclick="reset();" >重置</a>
          </td>
          </tr>
         </table>
        
       
       </form>
      </div>
    </body>

</html>