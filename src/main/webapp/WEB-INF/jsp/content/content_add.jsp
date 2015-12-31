<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
 
 <head>
   <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
   <title>内容添加页面</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ueditor/themes/default/css/ueditor.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ueditor.config.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ue.image.upload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/lang/zh-cn/zh-cn.js"></script>

 </head>
 
 
 <body>
 
   <div class="easyui-panel">
   
     <form action="">
     
       <table>
        <tr>
         <td>文章分类:</td>
         <td><input type="text" id="type"></td>
        
         <td>文章标题:</td>
         <td><input type="text" id="title"></td>
        </tr>
        
        <tr>
         <td>来源:</td>
         <td><input id="org"/></td>
       
         <td>来源的地址链接:</td>
         <td><input id="url"></td>
        </tr>
        
        <tr>
         <td>作者:</td>
         <td><input id="author"></td>
        
         <td>发布时间:</td>
         <td><input id="publishTime" class="easyui-date"></td>
        </tr>
       
       </table>
       
     <script id="container" name="content" type="text/plain"style="width:900px;height:240px;">
                       <p style="line-height: 1.75em; margin-top: 15px; margin-bottom: 5px;"><span style="font-family: 宋体,SimSun;"></span></p>
                </script>
                
                <script type="text/javascript">
               var editor = UE.getEditor('container');
           </script>
     
     
     
     </form>
   
   </div>
 
 
   
 
 
 </body>

</html>