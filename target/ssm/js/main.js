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
					micro.find("h6").html(json.fbdate+"转发微博");
					micro.find('p[name="microdata"]').html(json.authorname+":"+json.microdata);
				}else{
					micro.find("h6").html(json.fbdate+"来自 安安微博");
					micro.find('p[name="microdata"]').html(json.microdata);
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
					}else{
						micro.find('a[name="dianzan"]').html("<span class='glyphicon glyphicon-thumbs-up'></span>&nbsp;&nbsp;"+json.zanshu);
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
					}else{
						micro.find('a[name="shoucang"]').html("<span class='glyphicon glyphicon-star-empty'></span>&nbsp;&nbsp;"+json.cangshu);
					}
				}
				if(json.plshu==0){
					
				}else{
					micro.find('a[name="pinglun"]').html("<span class='glyphicon glyphicon-sound-stereo'></span>&nbsp;&nbsp;"+json.plshu);
				}
				micro.find('input[name="microid"]').val(json.microid);
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
					micro.find("h6").html(json.fbdate+"转发微博");
					micro.find('p[name="microdata"]').html(json.authorname+":"+json.microdata);
				}else{
					micro.find("h6").html(json.fbdate+"来自 安安微博");
					micro.find('p[name="microdata"]').html(json.microdata);
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
					}else{
						micro.find('a[name="dianzan"]').html("<span class='glyphicon glyphicon-thumbs-up'></span>&nbsp;&nbsp;"+json.zanshu);
					}
				}
                if(json.plshu==0){
					
				}else{
					micro.find('a[name="pinglun"]').html("<span class='glyphicon glyphicon-sound-stereo'></span>&nbsp;&nbsp;"+json.plshu);
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
					}else{
						micro.find('a[name="shoucang"]').html("<span class='glyphicon glyphicon-star-empty'></span>&nbsp;&nbsp;"+json.cangshu);
					}
				}
				micro.find('input[name="microid"]').val(json.microid);
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
					micro.find("h6").html(json.fbdate+"转发微博");
					micro.find('p[name="microdata"]').html(json.authorname+":"+json.microdata);
				}else{
					micro.find("h6").html(json.fbdate+"来自 安安微博");
					micro.find('p[name="microdata"]').html(json.microdata);
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
					}else{
						micro.find('a[name="dianzan"]').html("<span class='glyphicon glyphicon-thumbs-up'></span>&nbsp;&nbsp;"+json.zanshu);
					}
				}
                if(json.plshu==0){	
				}else{
					micro.find('a[name="pinglun"]').html("<span class='glyphicon glyphicon-sound-stereo'></span>&nbsp;&nbsp;"+json.plshu);
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
					}else{
						micro.find('a[name="shoucang"]').html("<span class='glyphicon glyphicon-star-empty'></span>&nbsp;&nbsp;"+json.cangshu);
					}
				}
				micro.find('input[name="microid"]').val(json.microid);
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

function pingLun(infoss){
	var micro = $(infoss).parent();
	micro.find('div[name="pldiv"]').css({
		"display":"block",
	});
	var microid = micro.find('input[name=microid]').val();
	micro.find('div[name="pls"]').empty();
	$.ajax({
		url:"/ssm/main/pingLun.action",
		data:"microid="+microid,
		dataType:"json",
		success:function(param){
			for(var i in param){
				var json = param[i];
				var pl = $("#plmoban").clone();
				if(json.flag){
					pl.find('a[name="user_"]').html(json.name+"：");
				}else {
					pl.find('a[name="user_"]').html(json.name);
					pl.find('p[name="hfppp"]').css({
						"display":"block",
					});
					pl.find('a[name="user_2"]').html("@"+json.name_+":");
					pl.find('a[name="user_2"]').css({
						"display":"block",
					});
				}
				pl.find('input[name="plid"]').val(json.plid);
				pl.find('p[name="plinfo"]').html(json.pldata);
				pl.find('input[name="microid"]').val(microid);
				pl.css({
					"display":"block",
				});
				micro.find('div[name="pls"]').append(pl);
			}
		}
	});
}

function huifu(infoss){
	var pinglun = $(infoss).parent();
	pinglun.find('div[name="pldiv_"]').css({
		"display":"block",
	});
}


function fbpl_(infoss){
	var ttt = $(infoss).parents();
	var pldiv_ = $(ttt[0]);
	var pl_ = $(ttt[2]);
	var micro = $(ttt[5]);
	if(pldiv_.find('input[name="pldata_"]').val()==""){
		alert("评论内容为空");
		return;
	}
	var microid = micro.find('input[name="microid"]').val();
	var plid_ = pl_.find('input[name="plid"]').val();
	$.ajax({
		url:"/ssm/main/fbpl.action",
		data:"userid="+$("#userid").val()+"&microid="+microid+"&pldata="
		+pldiv_.find('input[name="pldata_"]').val()+"&plid_="+plid_,
		dataType:"json",
		success:function(param){
			if(param.flag){
				alert("评论成功");
				window.location.href="/ssm/user/login.action?username="+$("#username").val()+"&password="+$("#password").val()+"&fenlei="+$("#fenlei").val();
			}else{
				alert("评论失败");
			}
		}
	});
}

function fbpl(infoss){
	var pldiv = $(infoss).parent();
	var micro = $(pldiv).parent();
	if(pldiv.find('input[name="pldata"]').val()==""){
		alert("评论内容为空");
		return;
	}
	$.ajax({
		url:"/ssm/main/fbpl.action",
		data:"userid="+$("#userid").val()+"&microid="+micro.find('input[name="microid"]').val()+"&pldata="+pldiv.find('input[name="pldata"]').val(),
		dataType:"json",
		success:function(param){
			if(param.flag){
				alert("评论成功");
				window.location.href="/ssm/user/login.action?username="+$("#username").val()+"&password="+$("#password").val()+"&fenlei="+$("#fenlei").val();
			}else{
				alert("评论失败");
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

