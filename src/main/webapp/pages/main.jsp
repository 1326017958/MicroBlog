<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<link rel="stylesheet" href="/ssm/easyui/themes/default/easyui.css">
<link rel="stylesheet" href="/ssm/easyui/themes/default/linkbutton.css">
<link rel="stylesheet" href="/ssm/easyui/themes/icon.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery.form/4.2.2/jquery.form.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/ssm/js/user.js"></script>
<script type="text/javascript" src="/ssm/js/main.js"></script>
<script type="text/javascript" src="/ssm/easyui/jquery.easyui.min.js"></script>
<title>安安微博</title>
<script type="text/javascript">
$(function(){
	if($("#fenlei").val()=="image"){
		image();
	}else if($("#fenlei").val()=="self"){
		self();
	}else{
		index();
	}
	
});
</script>
</head>
<body style="overflow-x: hidden; overflow-x: hidden">
    <input type="hidden" id="userid" name="userid" value="${map.userid}">
    <input type="hidden" id="password" name="password" value="${map.password}">
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h1 style="color: blue;">欢迎进入安安微博</h1>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-11 col-md-offset-1 column">
				<ul class="nav nav-tabs">
					<br>
					<li class="active" id="index"><a href="#" onclick="index()">首页</a></li>
					<li id="self"><a href="#" onclick="self()">原创</a></li>
					<li id="image"><a href="#" onclick="image()">图片</a></li>
					<li class="dropdown pull-right"><a href="#"
						data-toggle="dropdown" class="dropdown-toggle"><span
							class="glyphicon glyphicon-user"></span>${map.name}<strong
							class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a href="#" onclick="out()">退出登录</a></li>
							<li><a href="#" onclick="register()">注册</a></li>
						</ul></li>
				</ul>
			</div>
		</div>

		<div class="row clearfix">
			<div class="col-md-1 column">
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#">热门</a></li>
					<li><a href="#">头条</a></li>
					<li><a href="#">搞笑</a></li>
					<li><a href="#">社会</a></li>
					<li><a href="#">时尚</a></li>
					<li><a href="#">军事</a></li>
					<li><a href="#">美女</a></li>
					<li><a href="#">体育</a></li>
				</ul>
			</div>
			<div class="col-md-7 column">
				<div class="row clearfix">
				    <br>
					<div class="col-md-11 col-md-offset-1 column" style="border:1px solid blue;">
					    
					    <div>
					       <input type="hidden" id="fenlei" name="fenlei" value="${user.fenlei}">
					       <input type="hidden" id="username" name="username" value="${user.username}">
						   <h4 style="color: red;">有什么新鲜事想告诉大家？111</h4>
						   <input type="text" id="microdata" name="microdata" style="width: 500px; height: 100px;"><br>
						   <form action="/ssm/main/importFile.action" method="post" enctype="multipart/form-data" id="form"> 
						        <input type="file" style="float: left;" id="filepath" name="filepath">
						        <a href="#" id="importFile" class="btn btn-default" style="float: left;position: relative; left: 10px; background-color: #00ff00;" onclick="importFile()">上传文件</a>
						   </form>
						   <a href="#" class="btn btn-default" style="position: absolute; left: 460px; background-color: red;" onclick="faBu()">发布</a>
						   <br>
						   <br>
					    </div>
					</div>
					<div id="moban" class="col-md-11 col-md-offset-1 column" style="border:1px solid blue;position:relative;top:20px;display:none;">
					    
					    <input type="hidden" name="microid">
					    
					    <div class="row clearfix">
					         <div class="col-md-12 column">
					             <a href="#" style="font-size: 30px; color: #ff0055;" name="name_"><span class="glyphicon glyphicon-user"></span>赵宗峰</a>
					             <h6 style="color: red;">来自    安安微博</h6>
					             <p name="microdata">我的微博</p>
					             <img alt="" src="" height="150px" width="300px">
					         </div>
					       
					    </div>
					    <a href="#" name="dianzan" onclick="dianZan(this)"><span class="glyphicon glyphicon-thumbs-up"></span>点赞</a>
					    <a href="#" name="shoucang" style="position:relative;left:15px;" onclick="shouCang(this)"><span class="glyphicon glyphicon-star-empty"></span>收藏</a>
					    <a href="#" name="pinglun" style="position:relative;left:30px;" onclick="pingLun(this)"><span class="glyphicon glyphicon-sound-stereo"></span>评论</a>
					    <a href="#" name="zhuanfa" style="position:relative;left:45px;" onclick="zhuanFaMicro(this)"><span class="glyphicon glyphicon-share"></span>转发</a>
					    <div style="background:#cccccc;">
					    <div class="form-group" style="display:none" name="pldiv">
					         <input type="text" style="width:300px;float:left;" class="form-control" name="pldata"/>
					         <a href="#" class="btn btn-default btn-sm" onclick="fbpl(this)" style="height:35px;width:60px;position:relative;left:20px;color:yellow;font-size:20px;"><span class="glyphicon glyphicon-ok"></span></a>
				        </div>
				        
				        <div id="plmoban" name="plmoban" style="display:none;">
				           <input type="hidden" name="plid">
				           <input type="hidden" name="microid">
				           <a href="#" name="user_" style="font-size: 15px;float:left; color: #ff0055;"><span class="glyphicon glyphicon-user"></span>赵宗峰：</a>
				           <p name="hfppp" style="font-size: 15px;float:left;display:none">回复</p>
				           <a href="#" name="user_2" style="display:none;float:left;"></a>
				           <p style="font-size: 15px;" name="plinfo"></p>
				           <a href="#" onclick="huifu(this)" style="position:relative;left:550px;">回复</a>
				           <div class="form-group col-md-11 col-md-offset-1 column" style="display:none;position:relative;" name="pldiv_">
					          <input type="text" style="width:450px;float:left;" class="form-control" name="pldata_"/>
					          <a href="#" class="btn btn-default btn-sm" onclick="fbpl_(this)" style="height:35px;width:60px;position:relative;left:20px;color:yellow;font-size:20px;"><span class="glyphicon glyphicon-ok"></span></a>
				           </div>
				        </div>
				        <div id="pls" name="pls">
				             
				        </div>
				        </div>
					</div>
					<div id="microinfo">
					
					</div>
					<div class="col-md-11 col-md-offset-1 column" id="pagenation" style="display:none;">
						<ul class="pagination">
							<li><a href="#">&laquo;</a></li>
							<li class="active"><a href="#">1</a></li>
							<li class="disabled"><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-md-offset-1 column">
			    <br><br>
				<div class="col-md-12 column">
					<div class="carousel slide" id="carousel-725928">
						<ol class="carousel-indicators">
							<li class="active" data-slide-to="0"
								data-target="#carousel-725928"></li>
							<li data-slide-to="1" data-target="#carousel-725928"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img alt="" src="/ssm/image/0.jpg" />
								<div class="carousel-caption">
									<h4>${map.name}</h4>
									<p>Welcome to An-An-microblag</p>
								</div>
							</div>
							<div class="item">
								<img alt="" src="/ssm/image/3.jpg" />
								<div class="carousel-caption">
									<h4>${map.name}</h4>
									<p>Welcome to An-An-microblag</p>
								</div>
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-725928"
							data-slide="prev"><span
							class="glyphicon glyphicon-chevron-left"></span></a> <a
							class="right carousel-control" href="#carousel-725928"
							data-slide="next"><span
							class="glyphicon glyphicon-chevron-right"></span></a>
					</div>
				</div>
				<ul class="nav nav-tabs">
				    <li>
					    <a href="/ssm/main/usergz.action?username=${user.username}&name=${map.name}&password=${user.password}" >关注</a>
				    </li>
				    <li>
					    <a href="/ssm/main/userfs.action?username=${user.username}&name=${map.name}&password=${user.password}">粉丝</a>
				    </li>
				    <li>
					    <a href="/ssm/main/userm.action?username=${user.username}&name=${map.name}&password=${user.password}">微博</a>
				    </li>
				    <li>
					    <a href="/ssm/main/usersc.action?username=${user.username}&name=${map.name}&password=${user.password}">收藏</a>
				    </li>
			    </ul>
			</div>
		</div>

	</div>

</body>
</html>