<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>xheditor整合案例</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/xheditor/xheditor-1.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/xheditor/xheditor_lang/zh-cn.js"></script>

<style type="text/css">
   /* 增加插入代码工具图标 */
  .btnCode {
    background: transparent url(images/code.gif) no-repeat 0px 0px;
    background-position: 3px -2px;
  }
</style>
<script type="text/javascript">
  
   $(function(){
	   /*
	   加入扩展的插入代码的 功能 
	   */
	   var plugins={
			    Code:{c:'btnCode',t:'插入代码',h:1,e:function(){
			      var _this=this;
			      var htmlCode="<div>编程语言<select id='xheCodeType'>";
			        htmlCode+="<option value='html'>HTML/XML</option>";
			        htmlCode+="<option value='js'>Javascript</option>";
			        htmlCode+="<option value='css'>CSS</option>";
			        htmlCode+="<option value='php'>PHP</option>";
			        htmlCode+="<option value='java'>Java</option>";
			        htmlCode+="<option value='py'>Python</option>";
			        htmlCode+="<option value='pl'>Perl</option>";
			        htmlCode+="<option value='rb'>Ruby</option>";
			        htmlCode+="<option value='cs'>C#</option>";
			        htmlCode+="<option value='c'>C++/C</option>";
			        htmlCode+="<option value='vb'>VB/ASP</option>";
			        htmlCode+="<option value=''>其它</option>";
			        htmlCode+="</select></div><div>";
			        htmlCode+="<textarea id='xheCodeValue' wrap='soft' spellcheck='false' style='width:300px;height:100px;' />";
			        htmlCode+="</div><div style='text-align:right;'><input type='button' id='xheSave' value='确定' /></div>";			
			      var jCode=$(htmlCode),jType=$('#xheCodeType',jCode),jValue=$('#xheCodeValue',jCode),jSave=$('#xheSave',jCode);
			      jSave.click(function(){
			        _this.loadBookmark();
			        _this.pasteHTML('<pre class="brush: '+jType.val()+'">'+_this.domEncode(jValue.val())+'</pre> ');
			        _this.hidePanel();
			        return false;	
			      });
			      _this.saveBookmark();
			      _this.showDialog(jCode);
			    }},
			      
			      };
			      $('#content').xheditor({
			      plugins:plugins,//使用我们定义的插件  
			      tools : 'full',
				   width:980,
				   height:450,
			        skin : 'default',
			        upImgUrl : "${pageContext.request.contextPath}/upload.htm",
			        upImgExt : "jpg,jpeg,png,gif",
			        html5Upload : false,
			        //上传图片的配置 
			        onUpload : upload,
			      loadCSS:'<style>pre{margin-left:2em;border-left:3px solid #CCC;padding:0 1em;}</style>',
			      });
	   
	  
	   //回调函数 
	   function upload(data){
		   
	   }
	   
   });
    
   
   function save(){
	   
	   $.post("${pageContext.request.contextPath}/saveContent.htm",
			   {"org":$("#org").val,
		         "content":$("#content").val,
		         "title":$("#title").val},
			   function(data){
				   alert(data);
			   },
			   "json");
	   
   }


</script>

</head>
<body>


 
<form action="${pageContext.request.contextPath}/saveContent.htm" method="post">
  
  <table>
    
    <tr>
     <td>来源:</td>
     <td><input id="org" name="org" ></td>
    </tr>
    
    <tr>
     
     <td>标题:</td>
     
     <td><input id="title" name="title"></td>
    
    </tr>
  
  </table>
   
    <textarea id="content" name="content"></textarea>
    
     <input type="submit" value="发布" > 
    
      </form>
</body>
</html>