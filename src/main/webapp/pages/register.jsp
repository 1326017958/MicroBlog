<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/ssm/js/user.js"></script>
<title>工程微博</title>
</head>
<body style="background-image:url(/ssm/image/4.jpg)">
<div class="container">
	<div class="row clearfix">
		<div class="col-md-4 column">
		</div>
		<div class="col-md-4 column">
			<table class="table">
				<thead>
					<tr class="success">
						<th>用户属性</th>
						<th>用户值</th>
					</tr>
				</thead>
				<tbody>
					<tr class="info">
						<td>用户名</td>
						<td><input id="username" name="username"></td>
					</tr>
					<tr class="success">
						<td>用户密码</td>
						<td><input id="password" name="password"></td>
					</tr>
					<tr class="info">
						<td>联系方式</td>
						<td><input id="phone" name="phone"></td>
					</tr>
					<tr class="warning">
						<td>用户性别</td>
						<td>
							<select id="sex" name="sex" style="width:174px;height:27px;">
							    <option value="0">男</option>
							    <option value="1">女</option>
							</select>
						</td>
					</tr>
					<tr class="info">
						<td>用户昵称</td>
						<td><input id="name" name="name"></td>
					</tr>
					<tr class="warning">
						<td>用户地址</td>
						<td><input id="address" name="address"></td>
					</tr>
				</tbody>
				<tfoot>
				    <tr class="success">
						<td><a href="#" class="btn btn-default" onclick="insertUser()">保存</a></td>
						<td><a href="#" class="btn btn-default" onclick="clUser()">清空</a></td>
					</tr>
				</tfoot>
			</table>
		</div>
		<div class="col-md-4 column">
		</div>
	</div>
</div>
</body>
</html>