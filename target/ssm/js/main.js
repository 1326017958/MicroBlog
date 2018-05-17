function faBu(){
	$.ajax({
		url:"/ssm/main/faBu.action",
		type:"post",
		data:"username="+$("#username").val()+"&microdata="+$("#microdata").val(),
		dataType:"json",
		success:function(param){
			if(param.flag){
				alert("发布成功，点击刷新页面");
				window.location.href="/ssm/user/login.action?username="+param.username+"&password="+param.password;
			}else{
				alert("发布失败，请稍后重新发表微博！！");
			}
		}
	});
}

function importFile(){
	if($("#filepath").val()==""){
		alert("文件为空");
		return;
	}
	$("#importFile").css({"disable":"true"});
	$("form").ajaxSubmit(function(data){
		    if(data.flag){
			    alert("上传文件成功");
		    }else{
			    alert("上传文件失败");
		    }
		});
}

function out(){
	window.location.href="/ssm/user/index.action";
}

function register(){
	window.location.href="/ssm/user/register.action";
}


function index(){
	var index = $("#index");
	$("#index").attr("class","active");
	$("#self").removeClass();
	$("#image").removeClass();
	$("#microinfo").empty();
	$("#fenlei").val("index")
	$.ajax({
		url:"/ssm/main/index.action",
		data:"username="+$("#username").val(),
		dataType:"json",
		type:"post",
		success:function(param){
			var a;
			for(var item in param){
				var json = param[item];
				a = item*20+20;
				var micro = $("#moban").clone();
				micro.find('a[name="name_"]').html("<span class='glyphicon glyphicon-user'></span>"+json.name);
				if(json.authorname!=undefined){
					micro.find("h6").html("转发微博");
					micro.find("p").html(json.authorname+":"+json.microdata);
				}else{
					micro.find("p").html(json.microdata);
				}
				if(json.zanshu==undefined||json.zanshu==0){
				}else{
					var flag = false;
					if(json.dianzanid!=undefined){
						for(var i in json.dianzanid){
							if(json.dianzanid[i]==json.microid){
								flag = true;
							}
						}
						if(flag){
							micro.find('a[name="dianzan"]').html("<span class='glyphicon glyphicon-thumbs-up' style='color:yellow;'></span>&nbsp;&nbsp;"+json.zanshu);
						}else{
							micro.find('a[name="dianzan"]').html("<span class='glyphicon glyphicon-thumbs-up'></span>&nbsp;&nbsp;"+json.zanshu);
						}
					}
				}
				
				if(json.cangshu==undefined||json.cangshu==0){
				}else{
					var ttt = false;
					if(json.shoucangid!=undefined){
						for(var i in json.shoucangid){
							if(json.shoucangid[i]==json.microid){
								ttt = true;
							}
						}
						if(ttt){
							micro.find('a[name="shoucang"]').html("<span class='glyphicon glyphicon-star' style='color:yellow;'></span>&nbsp;&nbsp;"+json.cangshu);
						}else{
							micro.find('a[name="shoucang"]').html("<span class='glyphicon glyphicon-star-empty'></span>&nbsp;&nbsp;"+json.cangshu);
						}
					}
				}
				micro.find("input").val(json.microid);
				micro.find("img").attr("src",json.filepath);
				micro.css({
					"position":"relative",
				    "top":a+"px",
					"display":"block"
				});
				$("#microinfo").append(micro);
			}
			
			var pagenation = $("#pagenation").clone();
			pagenation.css({
				"position":"relative",
			    "top":a+"px",
				"display":"block"
			});
			$("#microinfo").append(pagenation);
		}
	});
	
}

function self(){
	var self = $("#self");
	$("#self").attr("class","active");
	$("#index").removeClass();
	$("#image").removeClass();
	$("#microinfo").empty();
	$("#fenlei").val("self")
	$.ajax({
		url:"/ssm/main/self.action",
		data:"username="+$("#username").val(),
		dataType:"json",
		type:"post",
		success:function(param){
			
			for(var item in param){
				var json = param[item];
				var a = item*20+20;
				var micro = $("#moban").clone();
				micro.find('a[name="name_"]').html("<span class='glyphicon glyphicon-user'></span>"+json.name);
				if(json.authorname!=undefined){
					micro.find("h6").html("转发微博");
					micro.find("p").html(json.authorname+":"+json.microdata);
				}else{
					micro.find("p").html(json.microdata);
				}
				if(json.zanshu==undefined||json.zanshu==0){
				}else{
					var ttt = false;
					if(json.dianzanid!=undefined){
						for(var i in json.dianzanid){
							if(json.dianzanid[i]==json.microid){
								ttt = true;
							}
						}
						if(flag){
							micro.find('a[name="dianzan"]').html("<span class='glyphicon glyphicon-thumbs-up' style='color:yellow;'></span>&nbsp;&nbsp;"+json.zanshu);
						}else{
							micro.find('a[name="dianzan"]').html("<span class='glyphicon glyphicon-thumbs-up'></span>&nbsp;&nbsp;"+json.zanshu);
						}
					}
				}
				
				if(json.cangshu==undefined||json.cangshu==0){
				}else{
					var ttt = false;
					if(json.shoucangid!=undefined){
						for(var i in json.shoucangid){
							if(json.shoucangid[i]==json.microid){
								ttt = true;
							}
						}
						if(ttt){
							micro.find('a[name="shoucang"]').html("<span class='glyphicon glyphicon-star' style='color:yellow;'></span>&nbsp;&nbsp;"+json.cangshu);
						}else{
							micro.find('a[name="shoucang"]').html("<span class='glyphicon glyphicon-star-empty'></span>&nbsp;&nbsp;"+json.cangshu);
						}
					}
				}
				micro.find("input").val(json.microid);
				micro.find("img").attr("src",json.filepath);
				micro.css({
					"position":"relative",
				    "top":a+"px",
					"display":"block"
				});
				$("#microinfo").append(micro);
			}
		}
	});
	
}

function image(){
	var image = $("#image");
	$("#image").attr("class","active");
	$("#index").removeClass();
	$("#self").removeClass();
	$("#microinfo").empty();
	$("#fenlei").val("image")
	$.ajax({
		url:"/ssm/main/image.action",
		data:"username="+$("#username").val(),
		dataType:"json",
		type:"post",
		success:function(param){
			
			for(var item in param){
				var json = param[item];
				var a = item*20+20;
				var micro = $("#moban").clone();
				micro.find('a[name="name_"]').html("<span class='glyphicon glyphicon-user'></span>"+json.name);
				if(json.authorname!=undefined){
					micro.find("h6").html("转发微博");
					micro.find("p").html(json.authorname+":"+json.microdata);
				}else{
					micro.find("p").html(json.microdata);
				}
				if(json.zanshu==undefined||json.zanshu==0){
				}else{
					var flag = false;
					if(json.dianzanid!=undefined){
						for(var i in json.dianzanid){
							if(json.dianzanid[i]==json.microid){
								flag = true;
							}
						}
						if(flag){
							micro.find('a[name="dianzan"]').html("<span class='glyphicon glyphicon-thumbs-up' style='color:yellow;'></span>&nbsp;&nbsp;"+json.zanshu);
						}else{
							micro.find('a[name="dianzan"]').html("<span class='glyphicon glyphicon-thumbs-up'></span>&nbsp;&nbsp;"+json.zanshu);
						}
					}
				}
				
				if(json.cangshu==undefined||json.cangshu==0){
				}else{
					var ttt = false;
					if(json.shoucangid!=undefined){
						for(var i in json.shoucangid){
							if(json.shoucangid[i]==json.microid){
								ttt = true;
							}
						}
						if(ttt){
							micro.find('a[name="shoucang"]').html("<span class='glyphicon glyphicon-star' style='color:yellow;'></span>&nbsp;&nbsp;"+json.cangshu);
						}else{
							micro.find('a[name="shoucang"]').html("<span class='glyphicon glyphicon-star-empty'></span>&nbsp;&nbsp;"+json.cangshu);
						}
					}
				}
				micro.find("input").val(json.microid);
				micro.find("img").attr("src",json.filepath);
				micro.css({
					"position":"relative",
				    "top":a+"px",
					"display":"block"
				});
				$("#microinfo").append(micro);
			}
		}
	});
	
}

function zhuanFaMicro(infoss){
	var micro = $(infoss).parent();
	var microid=micro.find("input").val();
	var username=$("#username").val();
	$.ajax({
		url:"/ssm/main/zhuanFaMicro.action",
		type:"post",
		data:"username="+$("#username").val()+"&microid="+microid,
		dataType:"json",
		success:function(param){
			if(param.flag){
				alert("转发成功，点击刷新页面");
				window.location.href="/ssm/user/login.action?username="+param.username+"&password="+param.password+"&fenlei="+$("#fenlei").val();
			}else{
				alert("转发失败，请稍后重新发表微博！！");
			}
		}
	});
}

function dianZan(infoss){
	var micro = $(infoss).parent();
	var microid=micro.find("input").val();
	var username=$("#username").val();
	$.ajax({
		url:"/ssm/main/dianZan.action",
		type:"post",
		data:"username="+$("#username").val()+"&microid="+microid,
		dataType:"json",
		success:function(param){
			if(param.flag){
				alert(param.msg);
				window.location.href="/ssm/user/login.action?username="+param.username+"&password="+param.password+"&fenlei="+$("#fenlei").val();
			}else{
				alert(param.msg);
				window.location.href="/ssm/user/login.action?username="+param.username+"&password="+param.password+"&fenlei="+$("#fenlei").val();
			}
		}
	});
}

function deleteZan(infoss){
	var micro = $(infoss).parent();
	var microid=micro.find("input").val();
	var username=$("#username").val();
	$.ajax({
		url:"/ssm/main/deleteZan.action",
		type:"post",
		data:"username="+$("#username").val()+"&microid="+microid,
		dataType:"json",
		success:function(param){
			if(param.flag){
				alert("取消点赞成功");
			}else{
				alert("取消点赞失败，请稍后尝试");
			}
		}
	});
}

function shouCang(infoss){
	var micro = $(infoss).parent();
	var microid=micro.find("input").val();
	var username=$("#username").val();
	$.ajax({
		url:"/ssm/main/shouCang.action",
		type:"post",
		data:"username="+$("#username").val()+"&microid="+microid,
		dataType:"json",
		success:function(param){
			if(param.flag){
				alert(param.msg);
				window.location.href="/ssm/user/login.action?username="+param.username+"&password="+param.password+"&fenlei="+$("#fenlei").val();
			}else{
				alert(param.msg);
				window.location.href="/ssm/user/login.action?username="+param.username+"&password="+param.password+"&fenlei="+$("#fenlei").val();
			}
		}
	});
}

