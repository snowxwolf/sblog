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


</head>

<body>

   <div  class="easyui-panel" fit="true">   
   
      <table>
      
       <tr>
       <td>标签名称:</td>
       <td><input value="${tag.name}"></td>
       </tr>
       
        <tr>
       <td>标签描述:</td>
       <td><input value="${tag.desc}"></td>
       </tr>
       
        <tr>
       <td></td>
       <td><input type="button" value="关闭" onclick="javascript:window.close();"></td>
       </tr>
      
      </table>
    
    </div>   
</div>  
    

</body>

</html>