function pages(pn){
	$("#zhuye").empty();
	$("#gzpn").val(pn);
	$.ajax({
		url:"/ssm/person/guanzhu.action",
		data:"username="+$("#username").val()+"&pn="+pn,
		dataType:"json",
		success:function(param){
			var a;
			for(var i in param.list){
				a = i*10
				var json = param.list[i];
				var guanzhu = $("#guanzhu").clone();
				guanzhu.find('a[name="name"]').html("<span class='glyphicon glyphicon-user'></span>"+json.name);
				if(i%2==0){
					guanzhu.css({
						"position":"relative",
						"top":a+"px",
						"display":"block",
					});
				}else{
					guanzhu.css({
						"position":"relative",
						"top":a-10+"px",
					    "left":"30px",
						"display":"block",
					});
				}
				
				$("#zhuye").append(guanzhu);
			}
			var pagenation = $("#pagenation").clone();
			var b = param.total;
			if(b>0){
				if(b%6==0){
					var w = b/6;
					$("#pnsize").val(w);
					pagenation.find("ul").append("<li><a href='#' onclick='shangy()'>&laquo;</a></li>")
					for(var i=1;i<=w;i++){
						if(i==pn){
							pagenation.find("ul").append("<li class='active'><a href='#' onclick='pages("+i+")'>"+i+"</a></li>")
						}else{
							pagenation.find("ul").append("<li><a href='#' onclick='pages("+i+")'>"+i+"</a></li>")
						}
					}
					pagenation.find("ul").append("<li><a href='#' onclick='xiay()'>&raquo;</a></li>")
				}else{
					var w = b/6+1;
					$("#pnsize").val(w);
					pagenation.find("ul").append("<li><a href='#' onclick='shangy()'>&laquo;</a></li>")
					for(var i=1;i<=w;i++){
						if(i==pn){
							pagenation.find("ul").append("<li class='active'><a href='#' onclick='pages("+i+")'>"+i+"</a></li>")
						}else{
							pagenation.find("ul").append("<li><a href='#' onclick='pages("+i+")'>"+i+"</a></li>")
						}
					}
					pagenation.find("ul").append("<li><a href='#' onclick='xiay()'>&raquo;</a></li>")
				}
			}else{
				$("#pnsize").val(0);
				pagenation.html("<h3>你还没有关注人</h3>")
			}
			
			pagenation.css({
				"position":"relative",
			    "top":a+"px",
				"display":"block"
			});
			$("#zhuye").append(pagenation);
		}
	});
}

function shangy(){
	if($("#gzpn").val()==1){
		alert("已经是第一页了");
		return;
	}
	var pn = $("#gzpn").val();
	pages(pn-1);
}

function xiay(){
	if($("#gzpn").val()>=$("#pnsize").val()){
		alert("已经是最后一页了");
		return;
	}
	var pn = $("#gzpn").val();
	pages(pn+1);
}

function rmmicro(){
	$("#rmmicro").empty();
	$.ajax({
		url:"/ssm/person/rmmicro.action",
		data:"username="+$("#username").val(),
		dataType:"json",
		success:function(param){
			for(var item in param.list){
				var json = param.list[item];
				var a = item*20+20;
				var micro = $("#moban_").clone();
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
					"display":"block",
					"border":"1px solid blue",
				});
				$("#rmmicro").append(micro);
			}
		}
	});
}

function mymicro(){
	$("#mymain").css({
		"display":"none",
	});
	$("#myziliao").css({
		"display":"none",
	});
	$("#mymicro").css({
		"display":"block",
	});
	$("#2222").attr("class","active");
	$("#1111").removeClass();
	$("#3333").removeClass();
	$("#zhuye").empty();
	$.ajax({
		url:"/ssm/person/mymicro.action",
		data:"username="+$("#username").val(),
		dataType:"json",
		success:function(param){
			for(var item in param){
				var json = param[item];
				var a = item*20+20;
				var micro = $("#moban_").clone();
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
					"display":"block",
					"border":"1px solid red",
				});
				$("#zhuye").append(micro);
			}
		}
	});
	
}

function myziliao(){
	$("#mymain").css({
		"display":"none",
	});
	$("#myziliao").css({
		"display":"block",
	});
	$("#mymicro").css({
		"display":"none",
	});
	$("#3333").attr("class","active");
	$("#1111").removeClass();
	$("#2222").removeClass();
	$("#zhuye").empty();
}

function mymain(param){
	$("#mymain").css({
		"display":"block",
	});
	$("#myziliao").css({
		"display":"none",
	});
	$("#mymicro").css({
		"display":"none",
	});
	$("#1111").attr("class","active");
	$("#2222").removeClass();
	$("#3333").removeClass();
	if(param=="guanzhu"){
		myguanzhu();
	}else if(param=="fensi"){
		myfensi();
	}else {
		myshoucang();
	}
	
}

function myguanzhu(){
	$("#myguanzhu").attr("class","active");
	$("#myfensi").removeClass();
	$("#myshoucang").removeClass();
	pages(1);
}

function myfensi(){
	$("#myfensi").attr("class","active");
	$("#myguanzhu").removeClass();
	$("#myshoucang").removeClass();
	$("#zhuye").empty();
}

function myshoucang(){
	$("#myshoucang").attr("class","active");
	$("#myfensi").removeClass();
	$("#myguanzhu").removeClass();
	$("#zhuye").empty();
	$.ajax({
		url:"/ssm/person/myshoucang.action",
		data:"username="+$("#username").val(),
		dataType:"json",
		success:function(param){
			for(var item in param){
				var json = param[item];
				var a = item*20+20;
				var micro = $("#moban_").clone();
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
					"display":"block",
					"border":"1px solid yellow",
				});
				$("#zhuye").append(micro);
			}
		}
	});
}

function returnindex(){
	window.location.href="/ssm/user/login.action?username="+$("#username").val()+"&password="+$("#password").val()+"&fenlei=index";
}
