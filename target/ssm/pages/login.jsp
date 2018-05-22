<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/ssm/js/user.js"></script>

<title>安安微博</title>
</head>
<body style="background-image:url(/ssm/image/10.jpg)">
<div class="container" >
    <div class="col-md-12 column">
			<div class="carousel slide" id="carousel-725928">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-725928">
					</li>
					<li data-slide-to="1" data-target="#carousel-725928">
					</li>
					<li data-slide-to="2" data-target="#carousel-725928">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="/ssm/image/19.jpg" />
						<div class="carousel-caption">
							<h4>
								First Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="/ssm/image/21.jpg" />
						<div class="carousel-caption">
							<h4>
								Second Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="/ssm/image/20.jpg" />
						<div class="carousel-caption">
							<h4>
								Third Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-725928" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-725928" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div>
	<div class="row clearfix">
		<div class="col-md-4 column">
		</div>
		<div class="col-md-4 column">
			<form action="/ssm/user/login.action" method="GET" id="form01">
			    <input type="hidden" id="fenlei" name="fenlei" value="index">
				<div class="form-group">
					 <label for="exampleInputUsername1">Username</label><input type="text" class="form-control" id="username" name="username"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">Password</label><input type="password" class="form-control" id="password" name="password"/>
				</div>
				<a href="#" class="btn btn-default" onclick="submit()">登录</a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    <a href="/ssm/user/register.action" class="btn btn-default">注册</a>
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    <a href="#" class="btn btn-default" onclick="cl()">清空</a>
			</form>
		</div>
		<div class="col-md-4 column">
		</div>
	</div>
</div>
</body>
</html>