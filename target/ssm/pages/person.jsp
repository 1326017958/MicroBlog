<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/jquery.form/4.2.2/jquery.form.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/ssm/js/user.js"></script>
<script type="text/javascript" src="/ssm/js/main.js"></script>
<script type="text/javascript" src="/ssm/js/person.js"></script>
<script type="text/javascript">
$(function(){
	if($("#fenlei1").val()=="mymain"){
		mymain($("#fenlei2").val());
	}else if($("#fenlei1").val()=="mymicro"){
		mymicro();
	}else {
		myziliao();
	}
	rmmicro();
});
</script>
<title>安安微博</title>
</head>
<body>
	<div class="container">
	    <input type="hidden" id="fenlei1" name="fenlei1" value="${fenlei1}">
	    <input type="hidden" id="fenlei2" name="fenlei2" value="${fenlei2}">
	    <input type="hidden" id="username" name="username" value="${map.username}">
	    <input type="hidden" id="name_" name="name_" value="${map.name}">
	    <input type="hidden" id="userid" name="userid" value="${map.userid}">
	    <input type="hidden" id="password" name="password" value="${map.password}">
	    <input type="hidden" id="gzpn" name="gzpn">
	    <input type="hidden" id="pnsize" name="pnsize">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="carousel slide" id="carousel-751227">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0"
							data-target="#carousel-751227"></li>
						<li data-slide-to="1" data-target="#carousel-751227"></li>
						<li data-slide-to="2" data-target="#carousel-751227"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img alt="" src="/ssm/image/19.jpg" />
							<div class="carousel-caption">
								<h3>个人页面</h3>
								<h4>First Thumbnail label</h4>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
							</div>
						</div>
						<div class="item">
							<img alt="" src="/ssm/image/20.jpg" />
							<div class="carousel-caption">
								<h3>个人页面</h3>
								<h4>Second Thumbnail label</h4>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
							</div>
						</div>
						<div class="item">
							<img alt="" src="/ssm/image/21.jpg" />
							<div class="carousel-caption">
								<h3>个人页面</h3>
								<h4>Third Thumbnail label</h4>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
							</div>
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-751227"
						data-slide="prev"><span
						class="glyphicon glyphicon-chevron-left"></span></a> <a
						class="right carousel-control" href="#carousel-751227"
						data-slide="next"><span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
				<nav class="navbar navbar-default" role="navigation">
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active" id="1111"><a href="#" onclick="mymain()">我的主页</a></li>
						<li  id="2222"><a href="#" onclick="mymicro()">我的微博</a></li>
						<li  id="3333"><a href="#" onclick="myziliao()">我的资料</a></li>

					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" id="searchby"/>
						</div>
						<a href="#" class="btn btn-default" onclick="SearchUser()">
							<span class="glyphicon glyphicon-search"
								style="color: rgb(255, 140, 60);"> 搜索</span>
						</a>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown pull-right"><a href="#"
						data-toggle="dropdown" class="dropdown-toggle"><span
							class="glyphicon glyphicon-user"></span>${map.name}<strong
							class="caret"></strong></a>
						<ul class="dropdown-menu">
						    <li><a href="#" onclick="register()">注册</a></li>
							<li><a href="#" onclick="out()">退出登录</a></li>
							<li><a href="#" onclick="returnindex()">返回主页</a></li>
							
						</ul></li>
					</ul>
				</div>

				</nav>
			</div>
		</div>
		<div id="personinfo">
		<div class="row clearfix">
		    
			<div class="col-md-6 column">

				<div class="row clearfix" id="mymain" style="display:none;">
					<div class="col-md-12 column">
						<ul class="nav nav-tabs">
							
							<li class="active" id="myguanzhu"><a href="#" onclick="myguanzhu()">关注</a></li>
							<li id="myfensi"><a href="#" onclick="myfensi()">粉丝</a></li>
							<li id="myshoucang"><a href="#" onclick="myshoucang()">收藏</a></li>
						</ul>
					</div>
				</div>
				<div class="row clearfix" id="mymicro" style="display:none;">
					<div class="col-md-12 column">
						<ul class="nav nav-tabs">
							
							<li class="active" ><a href="#" onclick="">我的微博</a></li>
						</ul>
					</div>
				</div>
				<div class="row clearfix">
					<div class="col-md-12 column" id="myziliao" style="display:none;">
						<ul class="nav nav-tabs">
							
							<li class="active"><a href="#" onclick="">我的资料</a></li>
						</ul>
					</div>
				</div>
				<div class="row clearfix" id="mysearch" style="display:none;">
					<div class="col-md-12 column">
						<ul class="nav nav-tabs">
							
							<li class="active" ><a href="#" onclick="">搜索用户</a></li>
						</ul>
					</div>
				</div>

                <div class="row clearfix">
                <br>
					<div style="border: 1px solid yellow; width: 250px; display: none; float: left;" id="guanzhu">
					    <input type="hidden" name="_userid">
						<a href="#" style="font-size: 30px; color: #ff0055;" name="name"><span class="glyphicon glyphicon-user"></span>赵宗峰</a>
						<p><span class="glyphicon glyphicon-ok"></span>已关注</p>
						<h6 style="color: red;">通过安安关注</h6>
						<a href="#" onclick="deleteGZ(this)"><span class="glyphicon glyphicon-minus-sign" style="color: yellow;" name="deleteGZ"></span>取消关注</a>
					</div>
					<div class="col-md-11 col-md-offset-1 column" id="pagenation"
						style="display: none;">
						<ul class="pagination">
						</ul>
					</div>
					<div style="border: 1px solid yellow; width: 250px; display: none; float: left;" id="UserP">
					    <input type="hidden" name="_userid">
						<a href="#" style="font-size: 30px; color: #ff0055;" name="name"><span class="glyphicon glyphicon-user"></span>赵宗峰</a>
						<p><span class="glyphicon glyphicon-ok"></span>已关注</p>
						<a href="#" name="dGZ" onclick="deleteGZ(this)" style="display: none;"><span class="glyphicon glyphicon-minus-sign" style="color: yellow;" name="deleteGZ"></span>取消关注</a>
						<a href="#" name="nGZ" onclick="newGZ(this)" style="display: none;"><span class="glyphicon glyphicon-plus-sign" style="color: yellow;" name="deleteGZ"></span>添加关注</a>
					</div>
					<div style="border: 1px solid yellow; width: 250px; display: none; float: left;" id="fensi">
					    <input type="hidden" name="_userid">
						<a href="#" style="font-size: 30px; color: #ff0055;" name="name"><span class="glyphicon glyphicon-user"></span>赵宗峰</a>
						<p><span class="glyphicon glyphicon-ok"></span>已关注</p>
						<h6 style="color: red;">通过安安关注</h6>
						<a href="#" name="dGZ" onclick="deleteGZ(this)" style="display: none;"><span class="glyphicon glyphicon-minus-sign" style="color: yellow;" name="deleteGZ"></span>取消关注</a>
						<a href="#" name="nGZ" onclick="newGZ(this)" style="display: none;"><span class="glyphicon glyphicon-plus-sign" style="color: yellow;" name="deleteGZ"></span>添加关注</a>
					</div>
					<div id="UserInfo" style="display: none;">
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
										<td><input type="text" id="username_1" name="username_1" value="${map.username}" readonly style="background-color:#CCCCCC"></td>
									</tr>
									<tr class="success">
										<td>用户密码</td>
										<td><input id="password_1" name="password_1" value="${map.password}"></td>
									</tr>
									<tr class="info">
										<td>联系方式</td>
										<td><input id="phone_1" name="phone_1" value="${map.phone}"></td>
									</tr>
									<tr class="warning">
									    
										<td>用户性别<input type="hidden" id="sex_" name="sex_" value="${map.sex}"></td>
										<td><select id="sex_1" name="sex_1"
											style="width: 174px; height: 27px;">
												<option value="0">男</option>
												<option value="1">女</option>
										</select></td>
									</tr>
									<tr class="info">
										<td>用户昵称</td>
										<td><input id="name_1" name="name_1" value="${map.name}"></td>
									</tr>
									<tr class="warning">
										<td>用户地址</td>
										<td><input id="address_1" name="address_1" value="${map.address}"></td>
									</tr>
								</tbody>
								<tfoot>
									<tr class="success">
										<td><a href="#" class="btn btn-default"
											onclick="updateUser()">保存修改</a></td>
										<td></td>
									</tr>
								</tfoot>
							</table>
				    </div>
					<div class="col-md-12 column" id="zhuye">
					</div>
				</div>
			</div>
			<div class="col-md-5 col-md-offset-1 column">
		        <div class="row clearfix">
					<div class="col-md-12 column">
						<ul class="nav nav-tabs">
							<li class="active" id="remen"><a href="#" onclick="">热门微博</a></li>
						</ul>
					</div>
					<div class="col-md-12 column" id="moban_" style="border:1px solid blue;position:relative;top:20px;display:none;">
					    <input type="hidden" name="microid">
					    <div class="row clearfix">
					         <div class="col-md-12 column">
					             <a href="#" style="font-size: 30px; color: blue;" name="name_"><span class="glyphicon glyphicon-user"></span>赵宗峰</a>
					             <h6 style="color: red;">来自    安安微博</h6>
					             <p>我的微博</p>
					             <img alt="" src="" height="150px" width="300px">
					         </div>
					       
					    </div>
					    <a href="#" name="dianzan" onclick="dianZan(this)"><span class="glyphicon glyphicon-thumbs-up"></span>点赞</a>
					    <a href="#" name="shoucang" style="position:relative;left:15px;" onclick="shouCang(this)"><span class="glyphicon glyphicon-star-empty"></span>收藏</a>
					    <a href="#" name="pinglun" style="position:relative;left:30px;" onclick="pingLun(this)"><span class="glyphicon glyphicon-sound-stereo"></span>评论</a>
					    <a href="#" name="zhuanfa" style="position:relative;left:45px;" onclick="zhuanFaMicro(this)"><span class="glyphicon glyphicon-share"></span>转发</a>
					</div>
					
					<div id="rmmicro"></div>
				</div>
		    </div>
		</div>
		</div>
	</div>

</body>
</html>