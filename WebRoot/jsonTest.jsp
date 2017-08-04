<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSON交互测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	function requestJson(){
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/requestJson.action',
			contentType:'application/json;charset=utf-8',
			//数据格式是商品信息
			data:'{"name":"手机","price":"999"}',
			success:function(data){//返回json结果
				alert(data);
			}
		});
	}
	function responseJson(){
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/responseJson.action',
			//不用指定contentType因为有默认的
			//contentType:'application/json;charset=utf-8',
			//数据格式是商品信息
			data:'name=手机&price=999',
			success:function(data){//返回json结果
				alert(data);
			}
		});
	}
</script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求是json串，输出是json串"/>
<input type="button" onclick="responseJson()" value="请求是key/value，输出是json串"/>
</body>
</html>