<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
isELIgnored="false"%>
<html>
 
 <head>
   <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
   <title>内容添加页面</title>
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
 
 <script type="text/javascript">
  
 $(function(){
	 
	 $("#tag").combobox({
		  url:"${pageContext.request.contextPath}/tag/findTagTree.htm",
		  valueField:'id',
		  textField:'text'
	  });
	 
 });
  
 
 </script>
 </head>
 
 
 <body>
 
  
   
     <form  class="easyui-form" id="artForm"  >
     
       <table>
        <tr>
         <td>文章分类:</td>
         <td><input class="easyui-validatebox" type="text" name="type"  id="type"></td>
        <td>作者:</td>
         <td><input  class="easyui-validatebox"id="author" required="true" disabled="disabled" value="${user.username}"></td>
         
        </tr>
        
        <tr>
         <td>标签:</td>
         <td><input class="easyui-combobox" name="tag" id="tag"  /></td>
       
         <td>来源的地址链接:</td>
         <td><input class="easyui-validatebox" name="url" id="url" data-options="validType:'url'"></td>
        </tr>
      
       <tr>
       
       <td>文章标题:</td>
       
       <td>
         <input class="easyui-validatebox" required="true" type="text" name="title"
         id="title" size="100">
       </td>
      
       </tr>
      
    
     </table>
      <script id="content" name="content" type="text/plain"style="width:900px;height:240px;">

                </script>
                
                <script type="text/javascript">
               var editor = UE.getEditor('content');
           </script>
           
         
    <a  class="easyui-linkbutton"  onclick="saveArticle();">保存</a>
          
     </form>
   
 
   
   <script type="text/javascript">
   //保存内容 
    function saveArticle(){
	   //获取百度编辑器的内容 
    	var art = editor.getContent();
    	
	   $("#artForm").form("submit",{
		   
		   url:"${pageContext.request.contextPath}/article/addArticle.htm",
		   onSubmit:function(param){
			   param.type=$("#type").val();
			   param.url=$("#url").val();
			   param.author=$("#author").val();
			   param.tag=$("#tag").combobox("getValue");
			   param.content=art;
			   param.title=$("#title").val();
			   
			   return $("#artForm").form("validate");
			   
		   },
		   success:function(info){
			  
   				var  data = eval('('+info+')');
   				if (data.result){
   					$.messager.alert("info",data.msg);
   					window.location.href="${pageContext.request.contextPath}/article/articleList.htm";
   				}else{
   					$.messager.alert("info",data.msg);
   				}
		   }
	   });
   }
    	/* $.post("${pageContext.request.contextPath}/article/addArticle.htm",
    			{
    		    content:art,
    		    title:$("#title").val(),
    		    url:$("#url").val(),
    		    org :$("#org").val(),
    		    author:$("#author").val(),
    		    tag:$("#tag").val()
    			},
    			function(data){
    				
    				if (data.result){
    					$.messager.alert("info",data.msg);
    					window.location.href="${pageContext.request.contextPath}/article/articleList.htm";
    				}else{
    					$.messager.alert("info",data.msg);
    				}
    				
    			},
    			"json");
    } */
   
   </script>
 
 </body>

</html>