<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
		${} el表达式可以从四大域中获取指定名称的属性
		${ name } 会以此按照从小到大的顺序到四大域中查找名称为name
		的域属性,如果找到就直接返回,如果找不到就什么也不输出!
	--%>
	<p>姓名:  ${ name }</p>
	<p>年龄:  ${ age }</p>
	<p>昵称:  ${ nickname }</p>
	 
</body>
</html>