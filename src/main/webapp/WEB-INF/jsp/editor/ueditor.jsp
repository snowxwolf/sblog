<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
 
 <head>
 
   <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
   <title>百度编辑器整合测试</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ueditor/themes/default/css/ueditor.css">
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ueditor.config.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ue.image.upload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/lang/zh-cn/zh-cn.js"></script>

 
 
 </head>
 
 
 <body>
 
 <script id="container" name="content" type="text/plain"style="width:900px;height:240px;">
                       <p style="line-height: 1.75em; margin-top: 15px; margin-bottom: 5px;"><span style="font-family: 宋体,SimSun;"></span></p>
                </script>
                
                <script type="text/javascript">
               var editor = UE.getEditor('container');
           </script>
   
 
 
 </body>

</html>