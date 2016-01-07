<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
isELIgnored="false"%>
<html>
 
 <head>
   <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
   <title>内容详情页面</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
<script type="text/javascript"> 
//语法高亮 
SyntaxHighlighter.all();       
</script>
 <style type="text/css">
  
  div{
  margin:0 auto;
  }
  a{
  text-decoration:none;
  }
 
 </style>
 </head>
 
 
 <body>
 
    <div class="easyui-panel" fit="true">
        
        <h2 style="text-align:center;">${title}</h2>
        
        <div style="text-align:center;">
        <span>作者:</span>【${author}】<span>来源:</span><a href="${url}" target="blank">${url }<a><span>发布时间:</span>${publishDate}
        
        </div>
        <div >
         ${content}
        </div>
    
    </div>

 
 </body>

</html>