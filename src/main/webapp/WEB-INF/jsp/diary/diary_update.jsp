<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
 
 <head>
   <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
   <title>写日记</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ueditor/themes/default/css/ueditor.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ueditor.config.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ue.image.upload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ueditor/lang/zh-cn/zh-cn.js"></script>

 </head>
 
 
 <body>
 
   <div class="easyui-panel">
   
     <form action="">
     <input type="hidden" id="id" value="${id}">
       <table>
        <tr>
         <td>天气情况:</td>
         <td><input type="text" id="weather" value="${weather}"></td>
        <td>作者:</td>
         <td><input id="author" value="${author }"></td>
         
        </tr>
      
      
       
       </table>
     <span>文章标题:</span>  <input type="text" id="title" size="100" value="${title }">
     <script id="container" name="content" type="text/plain"style="width:900px;height:240px;">
 ${content}
                </script>
                
                <script type="text/javascript">
               var editor = UE.getEditor('container');
           </script>
           
           <a class="easyui-linkbutton" onclick="saveDiary();">保存</a>
     
     </form>
   
   </div>
   
   <script type="text/javascript">
   //保存内容 
    function saveDiary(){
	   //获取百度编辑器的内容 
    	var art = editor.getContent();
    	
    	$.post("${pageContext.request.contextPath}/diary/updateDiary.htm",
    			{
    		    content:art,
    		    id:$("#id").val(),
    		    title:$("#title").val(),
    		    weather:$("#weather").val(),
    		    author:$("#author").val()
    		 
    			},
    			function(data){
    				
    				if (data.result){
    					$.messager.alert("info",data.msg);
    				}else{
    					$.messager.alert("info",data.msg);
    				}
    				
    			},
    			"json");
    }
   
   </script>
 
 </body>

</html>