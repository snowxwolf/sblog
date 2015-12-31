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