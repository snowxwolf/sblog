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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/flexpaper/flexpaper_handlers.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/flexpaper/flexpaper_handlers_debuger.js"></script>
<title>office在线预览</title>
</head>
<body>

  <div class="easyui-panel" title="文件上传">
    
    <form id="uploadForm" class="easyui-form" enctype="multipart/form-data">
      <table>
        <input type="hidden" name="userId" value="${user.id}"> 
         <tr>
         
          <td>文件：</td>
          <td> <input type="file" name="file" class="easyui-validatebox" required="true" missingMessage="请选择要上传的文件"></td>
        
          <td>备注：</td>
          <td> <input type="text" name="remark" class="easyui-validatebox" ></td>
         </tr>
         
         <tr>
         
           <td></td>
           <td>
           <a class="easyui-linkbutton" onclick="upload();">上传</a>
            <a class="easyui-linkbutton" onclick="cancel();">取消</a>
           </td>
         
         </tr>
      
      </table>
    
    </form>
  
  </div>

</body>
</html>