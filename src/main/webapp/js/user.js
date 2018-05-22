function submit(){
	var username=$("#username").val();
	var password=$("#password").val();
	if(username==""){
		alert("用户名为空，请输入用户名！！");
		return;
	}
	if(password==""){
		alert("密码为空，请输入密码！！");
		return;
	}
	$.ajax({
		url:"/ssm/user/loginCheck.action",
		data:"username="+username+"&password="+password,
		dataType:"json",
		success:function(param){
			if(param.flag==true){
				$("#form01").submit();
			}else{
				alert("用户名不存在或密码错误！！！");
			}
		}
	});
}

function cl(){
	$("#username").val("");
	$("#password").val("");
}

function insertUser(){
	if($("#username").val()==""){
		alert("用户名不能为空！！");
		return;
	}
	if($("#password").val()==""){
		alert("密码不能为空！！");
		return;
	}
	$.ajax({
		url:"/ssm/user/insertUser.action",
		data:"username="+$("#username").val()+"&password="+$("#password").val()+"&phone="+$("#phone").val()+"&sex="+$("#sex").val()+
		     "&name="+$("#name").val()+"&address="+$("#address").val(),
		dataType:"json",
		success:function(param){
			if(param.flag){
				alert("注册成功，点击确定返回登录页面！！");
				window.location.href="/ssm/user/index.action";
			}else{
				alert("注册失败，请重新注册！！");
			}
		}
	});
}

function clUser(){
	$("#username").val("");
	$("#password").val("");
	$("#phone").val("");
	$("#sex").val("");
	$("#name").val("");
	$("#address").val("");
}

function updateUser(){
	var data_ = "username="+$("#username_1").val();
	data_ += "&password="+$("#password_1").val();
	data_ += "&phone="+$("#phone_1").val();
	data_ += "&sex="+$("#sex_1").val();
	data_ += "&name="+$("#name_1").val();
	data_ += "&address="+$("#address_1").val();
	$.ajax({
		url:"/ssm/user/updateUser.action",
		data:data_,
		dataType:"json",
		success:function(param){
			if(param.flag){
				alert("修改成功");
			}else{
				alert("修改失败");
			}
		}
	})
}

