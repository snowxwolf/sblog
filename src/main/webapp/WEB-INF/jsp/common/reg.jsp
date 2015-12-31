<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  
    <head>
  
     <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>

    <title>注册页面</title>

    </head>
    
    <body style="background-image: url('images/bg.jpg') ;">
     <div id="regWin" class="easyui-window" title="注册"     
        style="width:350px;height:300px;background:#fafafa;"   
        data-options="modal:true,draggable:true,inline:true">   
     
      <form class="easyui-form" id="regForm" style="margin-left: 40px;margin-top:30px;">
          
          <table>
           <tr>
            <td><span style="color:red;" id="msg"></span></td>
           </tr>
           <tr>
           <td>用户名:</td>
            <td><input type="text" class="easyui-validatebox" required="true" missingMessage="用户名不能为空" id="name" validType="length[0,30]" invalidMessage="最大长度为30" name="name"></td>
           </tr>
           
            <tr>
           <td>密码:</td>
            <td><input type="password"  class="easyui-validatebox" required="true" missingMessage="密码不能为空" id="pwd" name="pwd" validType="length[0,30]" invalidMessage="最大长度为30" ></td>
           </tr>
           
            <tr>
           <td>重复密码:</td>
            <td><input type="password"  class="easyui-validatebox" required="true" missingMessage="密码不能为空" id="pwd2" validType="length[0,30]" invalidMessage="最大长度为50"></td>
           </tr>
         
             <tr>
             
             <td></td>
             
           <td>
           
           <a id="regBtn" class="easyui-linkbutton" onclick="reg();">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <a class="easyui-linkbutton" onclick="reset();">重置</a>
           </td>
            
           </tr>
          
          </table>
        
        </form>
     
</div> 
       
    
    
    </body>
    <script type="text/javascript">
      
      function reg(){
    	  
    	   $("#regForm").form("submit",{
    		   
    		   url:"${pageContext.request.contextPath}/reg.htm",
    		   onSubmit:function(){
    			   
    			 
    			   var pwd1 = $("#pwd").val();
    		    	  var pwd2 = $("#pwd2").val();
    		    	  if (pwd1!=pwd2){
    		    		 $.messager.alert("提示","两次密码必须相同","warn");
    		    		  return false;
    		    	  }
    		    	  return  $("#regForm").form("validate");
    		   },
    		   success:function(info){
    			 var  data=eval("("+info+")");
    			   if (data.success){
    				   //登陆成功后禁用 按钮
    				   $("#regBtn").linkbutton("disable");
    	    			  $("#msg").html("用户注册成功");
    	    		  }else{
    	    			  $("#msg").html("用户注册失败");
    	    		  }
    			   
    			   
    		   }
    		   
    		   
    	   });
    	 /*  $.post("${pageContext.request.contextPath}/reg.htm",
    			  $("#regForm").serialize(),
    			  function(data){
    		  if (data.success){
    			  $("#msg").html("用户注册成功");
    		  }else{
    			  $("#msg").html("用户注册失败");
    		  }
    		  
    	  },
    			  "json"); */
    	  
      }
      
      //重置 
      function reset(){
    	  
    	  $("#regForm").form("reset");
      }
    
    
    </script>
</html>