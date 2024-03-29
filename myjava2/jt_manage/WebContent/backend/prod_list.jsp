<%@page pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>商品管理</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{ font-family: "微软雅黑"; background-color: #EDEDED; }
	h2{ text-align: center; }
	table{ margin: 0 auto; text-align: center; border-collapse:collapse; font-size:16px }
	td, th{ padding: 7px;}
	th{ background-color: #DCDCDC; width:120px; }
	th.desc{ width: 500px; }
	hr{ margin-bottom:20px; border:1px solid #aaa; }
</style>

<!--引入jquery的js库-->
<script src="../js/jquery-1.4.2.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<h2>商品管理</h2>
	<hr/>
	<table border="1">
		<tr>
			<th>商品ID</th>
			<th>商品名称</th>
			<th>商品种类</th>
			<th>商品单价</th>
			<th>库存数量</th>
			<th class="desc">描述信息</th>
			<th>操 作</th>
		</tr>

		<!-- 模版数据 -->
		<tr>
			<td>1</td>
			<td>三坑手机</td>
			<td>电子数码</td>
			<td>3000.0</td>
			<td>
				188
			</td>
			<td>三坑手机, 专业坑人三十年, 从未被超越...!!!</td>
			<td>
				<a id="delProd" href="#">删除</a> |
				<a id="updProd" href="prod_update.html">修改</a>
			</td>
		</tr>
		<tr>
			<td>2</td>
			<td>三坑手机</td>
			<td>电子数码</td>
			<td>3000.0</td>
			<td>
				188
			</td>
			<td>三坑手机, 专业坑人三十年, 从未被超越...!!!</td>
			<td>
				<a id="delProd" href="#">删除</a> |
				<a id="updProd" href="#">修改</a>
			</td>
		</tr>
		<tr>
			<td>3</td>
			<td>三坑手机</td>
			<td>电子数码</td>
			<td>3000.0</td>
			<td>
				188
			</td>
			<td>三坑手机, 专业坑人三十年, 从未被超越...!!!</td>
			<td>
				<a id="delProd" href="#">删除</a> |
				<a id="updProd" href="#">修改</a>
			</td>
		</tr>
		<tr>
			<td>4</td>
			<td>三坑手机</td>
			<td>电子数码</td>
			<td>3000.0</td>
			<td>
				188
			</td>
			<td>三坑手机, 专业坑人三十年, 从未被超越...!!!</td>
			<td>
				<a id="delProd" href="#">删除</a> |
				<a id="updProd" href="#">修改</a>
			</td>
		</tr>
		<tr>
			<td>5</td>
			<td>三坑手机</td>
			<td>电子数码</td>
			<td>3000.0</td>
			<td>
				188
			</td>
			<td>三坑手机, 专业坑人三十年, 从未被超越...!!!</td>
			<td>
				<a id="delProd" href="#">删除</a> |
				<a id="updProd" href="#">修改</a>
			</td>
		</tr>
		<tr>
			<td>6</td>
			<td>三坑手机</td>
			<td>电子数码</td>
			<td>3000.0</td>
			<td>
				188
			</td>
			<td>三坑手机, 专业坑人三十年, 从未被超越...!!!</td>
			<td>
				<a id="delProd" href="#">删除</a> |
				<a id="updProd" href="#">修改</a>
			</td>
		</tr>
		<tr>
			<td>7</td>
			<td>三坑手机</td>
			<td>电子数码</td>
			<td>3000.0</td>
			<td>
				188
			</td>
			<td>三坑手机, 专业坑人三十年, 从未被超越...!!!</td>
			<td>
				<a id="delProd" href="#">删除</a> |
				<a id="updProd" href="#">修改</a>
			</td>
		</tr>
		<tr>
			<td>8</td>
			<td>三坑手机</td>
			<td>电子数码</td>
			<td>3000.0</td>
			<td>
				188
			</td>
			<td>三坑手机, 专业坑人三十年, 从未被超越...!!!</td>
			<td>
				<a id="delProd" href="#">删除</a> |
				<a id="updProd" href="#">修改</a>
			</td>
		</tr>
		<tr>
			<td>9</td>
			<td>三坑手机</td>
			<td>电子数码</td>
			<td>3000.0</td>
			<td>
				188
			</td>
			<td>三坑手机, 专业坑人三十年, 从未被超越...!!!</td>
			<td>
				<a id="delProd" href="#">删除</a> |
				<a id="updProd" href="#">修改</a>
			</td>
		</tr>
		<tr>
			<td>10</td>
			<td>三坑手机</td>
			<td>电子数码</td>
			<td>3000.0</td>
			<td>
				188
			</td>
			<td>三坑手机, 专业坑人三十年, 从未被超越...!!!</td>
			<td>
				<a id="delProd" href="#">删除</a> |
				<a id="updProd" href="#">修改</a>
			</td>
		</tr>
	</table>
</body>
</html>



