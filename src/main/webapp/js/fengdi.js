//初始化参数  提示  jQuery2.0以上版本
var initcommon = {
	fullPath:window.document.location.href,
	path:window.document.location.pathname
}

window.projectName = "有码";
var commonjson = {
	//url路径
	strFullPath:initcommon.fullPath,
	strPath:initcommon.path,
	prePath:initcommon.fullPath.substring(0,initcommon.fullPath.indexOf(initcommon.path)),
	postPath:initcommon.path.substring(0,initcommon.path.substr(1).indexOf('/')+1),
	rootPath:initcommon.fullPath.substring(0,initcommon.fullPath.indexOf(initcommon.path))+initcommon.path.substring(0,initcommon.path.substr(1).indexOf('/')+1),   
	pathMath:initcommon.path.substring(initcommon.path.lastIndexOf('/')+1,initcommon.path.length)
};
var tankuanghtml = '<div id="tankuang"><div class="tankuangDialog" style="z-index: 1003;">'+
'<div class="dialogHead"><span class="head_title">FgË0</span></div>'+
'<div class="dialogContent"></div><div class="dialogFoot">'+
'<div class="close_btn" onclick="closeTankuangDialog();">FgË1</div>'+
'</div></div><div class="dialogCover"></div></div>';
var tankuangalerthtml = '<div id="tankuang"><div class="tankuangDialog" style="z-index: 1003;width:50%;max-width:200px;height:auto;">'+
'<div class="dialogHead" style="background:#3AA33A;color:white;"><span class="head_title" style="color:white;margin-left:5px;font-size:12px;">FgË0</span></div>'+
'<div class="dialogContent" style="width:auto;height:auto;min-height:30px;padding:10px;text-align:center;">FgË1</div><div class="dialogFoot">'+
'<div class="close_btn" style="float: inherit;margin:5px auto;background:#3AA33A;color:white;">FgË2</div>'+
'</div></div><div class="dialogCover"></div></div>';
var tankuangconfirmhtml = '<div id="tankuang"><div class="tankuangDialog" style="z-index: 1003;">'+
'<div class="dialogHead"><span class="head_title">FgË0</span></div>'+
'<div class="dialogContent"></div><div class="dialogFoot">'+
'<div class="close_btn" onclick="closeTankuangDialog();">FgË1</div>'+
'</div></div><div class="dialogCover"></div></div>';
var jiantankuanghtml = '<div class="jiantankuang" style="position:fixed;z-index:9999;"><span class="jiantankuangred radius2">FgË0</span></div>';
var jianzaihtml = '<div id="tankuangjiazai" style="position:fixed;top:0px;left:0px;z-index:1006;width:100%;height:100%;"><img class="loadimg" src="'+commonjson.rootPath+'/images/load.gif" /><div class="dialogCover"></div></div>';
var caozuotishihtml = '<div id="caozuotishi" style="float: left;width: 100px;position: absolute;left: 50%;margin-left: -50px;top: 10px;color: white;font-size: 16px;">FgË0</div>';

var tankuangyoumahtml = '<div id="tankuang"><div class="tankuangDialog" style="z-index: 1003;width:50%;max-width:200px;height:auto;">'+
'<div class="dialogHead" style="background:#06e40e;color:white;width: 390px;"><span class="head_title" style="color:white;margin-left:5px;font-size:12px;">FgË0</span></div>'+
'<div class="dialogContent" style="width:390px;height:80px;padding-left: 166px;width: 185%;min-height:30px;padding:10px;text-align:center;">FgË1</div><div class="dialogFoot" style="padding-left: 184px;width: 103%;">'+
'<div class="close_btn" style="float: inherit;margin:5px auto;background:#3AA33A;color:white;">FgË2</div>'+
'</div></div><div class="dialogCover"></div></div>';
//弹框插件 begin 后期完善各种弹框功能
jQuery.fn.tankuang = function(canshu){
	var tankuanghtmlstr = htmlConnect(tankuanghtml,canshu.arr);
	$("body").append(tankuanghtmlstr);
	$("#tankuang").find(".dialogContent").append(canshu.neirong);
}

//操作提示弹框
function caozuotishitankuang(canshu){
	var caozuotishihtmlstr = htmlConnect(caozuotishihtml,[canshu.content]);
	if(canshu.obj != undefined){
		canshu.obj.find(".tankuangDialog").append(caozuotishihtmlstr);
	}else{
		$(".tankuangDialog").append(caozuotishihtmlstr);
	}
	$("#caozuotishi").slideDown().fadeOut(3000,function(){$("#caozuotishi").remove()});
}

function tankuangalert(canshu){
	var arr = [window.projectName,canshu.content,"确定"];
	var tankuangalerthtmlstr = htmlConnect(tankuangalerthtml,arr);
	$("body").append(tankuangalerthtmlstr);
	//绑定事件
	$("body").on("click","#tankuang .close_btn",function(){
		
		if(canshu.fun != undefined){
			canshu.fun();
		}
		
		$("body").off("click","#tankuang .close_btn");
		$("#tankuang").remove();
	});
}
function tankuangyouma(canshu){
	var arr = ['请确定以上信息录入无误？',canshu.content,"确定"];
	var tankuangyoumahtmlstr = htmlConnect(tankuangyoumahtml,arr);
	$("body").append(tankuangyoumahtmlstr);
	//绑定事件
	$("body").on("click","#tankuang .close_btn",function(){
		
		if(canshu.fun != undefined){
			canshu.fun();
		}
		
		$("body").off("click","#tankuang .close_btn");
		$("#tankuang").remove();
	});
}


function closeTankuangDialog(){
	$("#tankuang").remove();
}

function jiantankuang(canshu){
	var arr = [canshu];
	var jiantankuanghtmlstr = htmlConnect(jiantankuanghtml,arr);
	$("body").append(jiantankuanghtmlstr);
	$(".jiantankuang").show().fadeOut(2000,function(){$(".jiantankuang").remove()});
}

//关闭弹框
function closeDialog(obj){
	obj.hide();
}
//弹框插件 end

//operamasks-ui插件显示时间
window.showTimeOptions = {  
    dateFormat : "yy-mm-dd H:i",  
    showTime : true  
};
//operamasks-ui插件显示时间
window.showDateOptions = {  
    dateFormat : "yy-mm-dd",  
    showTime : true  
};

//表格对象
function Table(fgobj,dataSource,formData,fgData,start,limit){
    this.fgobj = fgobj;
    this.dataSource = dataSource;
    this.formData = formData;
    this.fgData = fgData;
    this.start = start;
    this.limit = limit;
}
window.table = [];

// 分页插件 begin
jQuery.fn.fgQueryTable = function(canshu){
	 var obj = $(this);
	 var fenyeObj = obj.parent(".queryTableDiv").siblings(".fg_fenye");
	 var t;
	 var c=0;
	 for(var i=0;i<table.length;i++){
		 if(table[i].fgobj.selector == this.selector){
			 t = table[i];
			 c = i;
		 }
	 }
	 if(t == undefined){
		 t = new Table(this,canshu.dataSource,canshu.formData,canshu.fgData);
		 table[table.length] = t;
		 c = table.length-1;
	 }
	 var dataSource;
	 var formData;
	 var fgData;
	 if(canshu.dataSource == undefined){
		 dataSource = t.dataSource;
	 }else{
		 dataSource = canshu.dataSource;
		 table[c].dataSource = canshu.dataSource;
	 }
	 if(canshu.formData == undefined){
		 formData = t.formData;
	 }else{
		 formData = canshu.formData;
		 table[c].formData = canshu.formData;
	 }
	 if(canshu.fgData == undefined){
		 fgData = t.fgData;
	 }else{
		 fgData = canshu.fgData;
		 table[c].fgData = canshu.fgData;
	 }
	 if(formData.find("input.limit").length == 0){
		 formData.append("<input type='hidden' class='limit' name='limit' value='"+canshu.limit+"' />");
		 formData.append("<input type='hidden' class='start' name='start' value='0' />");
	 }
	 if(canshu.start != undefined){
		 formData.find(".start").val(canshu.start);
	 }
	 $.ajax({
		 type:'post',
		 url:dataSource,
		 data:formData.serializeObject(),
		 success:function(da){
			var d = eval("("+da+")");
			var res = fgData;
	    	var data = d.rows;
	    	var html = '<tr>';
	    	html += "<th><div style='text-align:center;width:50px;'>序号</div></th>";//序号
	    	//头部拼装
	    	for(var i=0; i<res.length; i++){
	    		var css = res[i].css==null?'':res[i].css;
	    		html +=	"<th align=''><div style='text-align:"+res[i].align+";width:"+res[i].width+"px;"+css+"'>"+res[i].header+"</div></th>";
	    	}
	    	html +=	"</tr>";
	    	// 循环拼装表体本身
	    	if(data.length<d.limit){
	    		for(var i=0; i<data.length; i++){
	    			if(i%2==0){
	    				html +=	"<tr class='fg_data_table_2'>";
	    			}else{
	    				html +=	"<tr class='fg_data_table_1'>";
	    			}
	    			html += "<td><div style='text-align:center;width:50px;'>"+(d.start+i+1)+"</div></td>";//序号
		    		for(var j=0; j<res.length; j++){
		    			var css = res[j].css==null?'':res[j].css;
		    			html += "<td ><div style='padding:5px;word-wrap: break-word;text-align:"+res[j].align+";width:"+res[j].width+"px;"+css+"'>";
		    			if(res[j].fgMethod == null){
		    				html +=	data[i][res[j].name];
		    			}else{
		    				html +=	res[j].fgMethod(data[i][res[j].name],data[i],i);
		    			}
		    			html +=	"</div></td>";
		    		}
		    		html +=	"</tr>";
		    	};
	    	}else{
	    		for(var i=0; i<d.limit; i++){
	    			if(i%2==0){
	    				html +=	"<tr class='fg_data_table_2'>";
	    			}else{
	    				html +=	"<tr class='fg_data_table_1'>";
	    			}
	    			html += "<td><div style='text-align:center;width:50px;'>"+(d.start+i+1)+"</div></td>";//序号
	    			if(i>=data.length){
	    				for(var j=0; j<res.length; j++){
			    			var css = res[j].css==null?'':res[j].css;
			    			html += "<td ><div style='padding:5px;word-wrap: break-word;text-align:"+res[j].align+";width:"+res[j].width+"px;"+css+"'>";
			    			html +=	"</div></td>";
			    		}
	    			}else{
	    				for(var j=0; j<res.length; j++){
			    			var css = res[j].css==null?'':res[j].css;
			    			html += "<td ><div style='padding:5px;word-wrap: break-word;text-align:"+res[j].align+";width:"+res[j].width+"px;"+css+"'>";
			    			if(res[j].fgMethod == null){
			    				html +=	data[i][res[j].name];
			    			}else{
			    				html +=	res[j].fgMethod(data[i][res[j].name],data[i],i);
			    			}
			    			html +=	"</div></td>";
			    		}
	    			}
		    		html +=	"</tr>";
		    	};
	    	}
	    	
	    	if(d.total==0){
	    		html +=	"<tr class='empty_data'><td colspan='"+(res.length+1)+"'><div style='height:50px;line-height:50px;background:white;text-align:center;'>暂无数据</div></td></tr>";
	    	}
	    	// 将表格插入到页面指定位置
	    	obj.html(html);
	    	if(canshu.otherData != undefined){
	    		canshu.otherData(d);
	    	}
	    	//分页处理
	    	fenyeObj.show();
	    	//上一页
	    	var prePage = (d.start-d.limit)<0?0:(d.start-d.limit);
	    	//下一页
	    	var nextPage = (d.start+d.limit)>=d.total?d.start:(d.start+d.limit);
	    	
	    	var fenyehtml = '<div style="text-align:left;width:120px;">共计'+d.total+'条  </div><div onclick="$(\'#'+obj.attr("id")+'\').fgQueryTable({start:0})">首页</div>'+
	    		'<div onclick="$(\'#'+obj.attr("id")+'\').fgQueryTable({start:'+prePage+'})">上一页</div>'+
				'<div style="width:80px;">第<input type="text" onkeypress="if(event.keyCode == \'13\'){if(this.value<'+Math.ceil(d.total/d.limit)+' && this.value >0){$(\'#'+obj.attr("id")+'\').fgQueryTable({start:(this.value-1)*'+d.limit+'})}}" value="'+(d.start/d.limit+1)+'" class="now_page"/>页</div>'+
				'<div>共'+Math.ceil(d.total/d.limit)+'页</div>'+
				'<div onclick="$(\'#'+obj.attr("id")+'\').fgQueryTable({start:'+nextPage+'})">下一页</div>'+
				'<div onclick="$(\'#'+obj.attr("id")+'\').fgQueryTable({start:'+(Math.ceil(d.total/d.limit)-1)*d.limit+'})">末页</div>';
	    	fenyeObj.html(fenyehtml);
		 }
	 });
}


// 分页插件end

jQuery.dateAdd = Date.prototype.dateAdd = function(strInterval, number) {  
    var dtTmp = this;  
	if(typeof this == 'function'){
		dtTmp = new Date();
	}
    switch (strInterval) { 
		case 'ms' : return new Date(Date.parse(dtTmp) + number);
        case 'ss' :return new Date(Date.parse(dtTmp) + (1000 * number));  
        case 'mm' :return new Date(Date.parse(dtTmp) + (60000 * number));   
        case 'hh' :return new Date(Date.parse(dtTmp) + (3600000 * number));  
        case 'dd' :return new Date(Date.parse(dtTmp) + (86400000 * number));   
        case 'we' :return new Date(Date.parse(dtTmp) + ((86400000 * 7) * number)); 
        case 'se' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + number*3, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());  
        case 'MM' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + number, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());   
        case 'yy' :return new Date((dtTmp.getFullYear() + number), dtTmp.getMonth(), dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());   
    }   
} 

//写cookies函数
jQuery.setCookie = function(name,value,strInterval,number)//四个参数，一个是cookie的名子，一个是值,一个时间类型，一个时间数值
{
	var exp  = new Date(); 
	if(strInterval != undefined && number != undefined){
		exp = jQuery.dateAdd(strInterval, number);
	}else{
		exp.setTime(exp.getTime() + 30*86400000); //默认保存30天
	}
	document.cookie = name + "="+ escape (value) + "; expires=" + exp.toGMTString() + "; path=/";
}
//取cookies函数      
jQuery.getCookie = function(name)  
{
	var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
	 if(arr != null) return unescape(arr[2]); return null;

}
//删除cookie
jQuery.delCookie = function(name)
{
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval = jQuery.getCookie(name);
	if(cval!=null) document.cookie= name + "="+cval+"; expires="+exp.toGMTString();
}
//cookie方法 end

//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

// 下拉table 拼装 begin
function createXialaTable(obj,data,res,inObj,fun){
	var html = '';
	html += '<table class="table table-bordered table-hover table-striped" style="margin:0px;">';//序号
	// 循环拼装表体本身
	if(data.length>0){
		//头部拼装
		html += '<thead style="background-color:white;">';
		for(var i=0; i<res.length; i++){
			var css = res[i].css==null?'':res[i].css;
			html +=	"<td style='"+css+"' width='"+res[i].width+"' align='"+res[i].align+"'>"+res[i].header+"</td>";
		}
		html +=	"</tr></thead><tbody>";
		for(var i=0; i<data.length; i++){
			var da = "";
			for(var j=0; j<res.length; j++){
				da += " "+res[j].name+"='"+data[i][res[j].name]+"'";
			}
			html +=	"<tr"+da+" onclick='"+fun+"(this)' style='cursor:pointer;'>";
			for(var j=0; j<res.length; j++){
				var css = res[j].css==null?'':res[j].css;
				html += "<td style='"+css+"' width='"+res[j].width+"' align='"+res[j].align+"'>";
				if(res[j].fgMethod == null){
					html +=	data[i][res[j].name];
				}else{
					html +=	res[j].fgMethod(data[i][res[j].name],data[i],i);
				}
				html +=	"</td>";
			}
			html +=	"</tr>";
		}
	}else if(data.length==0){
		html +=	"<tbody><tr class='empty_data'><td colspan='"+(res.length+1)+"'><div style='height:20px;line-height:20px;width:100%;background:white;text-align:center;'>暂无数据</div></td></tr>";
		//$(obj).val("");
		//alert($(obj).val());
	}
	html += '</tbody></table>';
	return html;
}
// 下拉table 拼装 end

//数字联动效果
function liandong(obj,num){
	$(obj).siblings(".liandong").val($(obj).val()*num);
	console.error($(obj).siblings(".liandong").val());
}

//获取鼠标坐标
jQuery.mouseXY = function(e){ 
	var x,y; 
	var e = e||window.event; 
	return { 
		x:e.clientX+document.body.scrollLeft+document.documentElement.scrollLeft, 
		y:e.clientY+document.body.scrollTop+document.documentElement.scrollTop 
	}; 
}

//空校验
function emptyValid(obj){
	for(var i=0; i<obj.length; i++){
		if(obj[i].obj.val() == null || $.trim(obj[i].obj.val()) == '' ){
			alert(obj[i].value);
			obj[i].obj.focus();
			return 0;
		}
	}
}
//数字校验
function numValid(obj){
	for(var i=0; i<obj.length; i++){
		if(obj[i].obj.val() != null && $.trim(obj[i].obj.val()) != '' ){
			if(!/^(([1-9]\d{0,9})|0)(\.\d{1,2})?$/.test(obj[i].obj.val())){
				alert(obj[i].value);
				obj[i].obj.focus();
				return 0;
			}
		}
	}
}

//金额校验
function priceValid(price){
	var res = /^[0-9]+.?[0-9]{0,2}$/; 
	if (!res.test(price)){
		return true;
	}else{
		return false;
	}
}

//正数校验包括0
function zhengValid(num){
	if(/^([1-9]\d{0,9})|0$/.test(num)){
		return false;
	}else{
		return true;
	}
}


//插件 块拖动 begin    后期完善参考腾讯新闻分析弹出框  对移动的位置做限制 设置显示层
jQuery.fn.drug = function(o){
	var obj = this;
	if(o == undefined){
		o = this;
	}
	if(o.css("position") == "static"){
		o.css({"position":"relative","left":"0px","top":"0px"});
	}
	obj.mousedown(function(e){
		var a = jQuery.mouseXY(e);
		var left = o.css("left").replace("px","")|0;
		var top = o.css("top").replace("px","")|0;
		document.onmousemove = function (e) {
			var b = jQuery.mouseXY(e);
			o.css({"left":left+b.x-a.x+"px","top":top+b.y-a.y+"px"});
		}
	}).mouseup(function(e){
		document.onmousemove = null;
	}).mouseleave(function(e){
		document.onmousemove = null;
	});
}


//html拼接begin
function htmlConnect(str,arr){
	for(var i=0; i<arr.length; i++){
		var reg = new RegExp("FgË"+i,"g");
		str = str.replace(reg,arr[i]);
	}
	return str;
}
//html拼接end

//插件 静态页面切换 begin  后期完善滑动滚动等功能操作
jQuery.fn.tab = function(canshu){
	if(canshu == undefined){
		canshu = {};
	}
	var o = this;
	o.children().each(function(){
		this.onclick = function(){
			$(this).siblings().css(canshu.cssclickcommon);
			$(this).css(canshu.cssclickon);
			canshu.tabpage.hide();
			canshu.tabpage.eq($(this).getIndex()).show();
			if(canshu.wenzi == undefined){
				
			}else if(canshu.wenzi == "1"){
				canshu.wenobj.text(canshu.wenarr[$(this).getIndex()]);
			}else if(canshu.wenzi == "2"){
				canshu.wenobj.text($(this).text());
			}
			canshu.fun;
		}
	});
}
//插件 静态页面切换 end

//获取当前元素是父类的第几个元素
jQuery.fn.getIndex = function(){
	ele = this[0];
	//IE is simplest and fastest 
	if(ele.sourceIndex){ 
		return ele.sourceIndex - ele.parentNode.sourceIndex - 1; 
	} 
	//other browsers 
	var i=0; 
	while(ele.previousElementSibling){ 
		i++;
		ele = ele.previousElementSibling;
	} 
	return i; 
}

//格式化金额
var fmoney = function(s,obj,row){
   s = s/100;
   n = 2;  
   s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";  
   var l = s.split(".")[0].split("").reverse(),  
   r = s.split(".")[1];  
   t = "";  
   for(var i = 0; i < l.length; i ++ )  
   {  
      t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");  
   }  
   return "￥"+t.split("").reverse().join("") + "." + r;  
}  

//导航展开折叠begin
// *** fuji:  父级  
// *** ziji:  子级 
// *** show_time:  显示秒数  
// *** hide_time:  隐藏秒数 
// *** hide_other: 隐藏其他  
jQuery.fn.fgNavAction = function(canshu){
	if(canshu.show_time == undefined ){//显示秒数
		canshu.show_time = 0;
	}
	if(canshu.hide_time == undefined ){//隐藏秒数
		canshu.hide_time = 0;
	}
	canshu.fuji.each(function(){
		$(this).click(function(){
			if(canshu.hide_other == undefined ){//隐藏秒数
				$(canshu.ziji).hide(canshu.hide_time);
			}
			$(this).next(canshu.ziji).show(canshu.show_time);
		});
	});
}

//导航展开折叠end

//树的展开折叠
jQuery.fn.fgtree = function(canshu){
	if(canshu == undefined){
		canshu = {};
		console.error("树fgtree方法没有传递参数");
		return;
	}
	var o = $(this);
	if(canshu.show_time == undefined ){//显示秒数
		canshu.show_time = 0;
	}
	if(canshu.hide_time == undefined ){//隐藏秒数
		canshu.hide_time = 0;
	}
	o.css({"position":"relative"});
	o.click(function(){
			if(canshu.jibie == 1 ){
				if($(this).nextUntil(canshu.nextClass).is(":hidden")){
					$(this).nextUntil(canshu.nextClass).show(canshu.show_time);
					$(this).removeClass("jia").addClass("jian");
				}else{
					$(this).nextUntil(canshu.nextClass).hide(canshu.hide_time);
					$(this).removeClass("jian").addClass("jia");
				}
			}else{
				var obj = $(this);
				var mo = false;
				$(this).nextUntil(canshu.nextClass).each(function(){
					if($(this).is(canshu.preClass)){
						if(obj.nextUntil(canshu.preClass).is(":hidden")){
							obj.nextUntil(canshu.preClass).show(canshu.show_time);
						}else{
							obj.nextUntil(canshu.preClass).hide(canshu.hide_time);
						}
						mo = true;
						return;
					}
				});
				if(!mo){
					if($(this).nextUntil(canshu.nextClass).is(":hidden")){
						$(this).nextUntil(canshu.nextClass).show(canshu.show_time);
					}else{
						$(this).nextUntil(canshu.nextClass).hide(canshu.hide_time);
					}
				}
			}
		});
}


//验证手机号是否正确
function checkMobile(mobile){
	var re = /^(0|86|17951)?(13[0-9]|15[0-9]|17[0-9]|18[0-9]|14[0-9])[0-9]{8}$/;
    if(re.test(mobile)){
        return true;
    }else{
        return false;
    }
}

function checkIsMoney(amt){
	var reg = /^(([1-9]\d{0,9})|0)(\.\d{1,2})?$/;
	if(reg.test(amt)){
		return true;
	}else{
		return false;
	}
}

function checkIsNumber(num){
	var reg = /^(([1-9]\d{0,9})|0)$/;
	if(reg.test(num)){
		return true;
	}else{
		return false;
	}
}

//上传图片框
var uploadImagehtml = '<div id="upload"><div class="addImageDialog" style="z-index: 1003;"><div class="dialogHead"><span class="head_title">上传图片</span></div>'+
						'<div class="dialogContent"><div class="imageShow"><img class="img" src="" alt="" width="150" height="150" /></div>'+
						'<div class="uploadImageBlock"><input class="uploadImage" id="uploadToImportFile" name="uploadToImportFile" type="file" value="" /></div>'+
						'<div class="uploadClick" onclick="contactAjaxFileUpload(this);">上传</div></div><div class="dialogFoot"><div class="close_btn" onclick="closeUploadDialog();">'+
						'关闭</div></div></div><div class="dialogCover"></div></div>';
//关闭上传图片框
function closeUploadDialog(){
	$("#upload").hide();
}


function ajaxUploadImage(canshu){
	$(document).ajaxStart(function() {
		// 开始上传文件时显示一个图片
		$("body").append(jianzaihtml);
	}).ajaxComplete(function() {
		// 文件上传完成将图片隐藏起来
		$("#tankuangjiazai").remove();
	});
	//判断文件类型
	var filename = canshu.filename;
	if(filename == null || filename == ''){
		tankuangalert({content:"请选择文件！",fun:function(){}});
		return false;
	}
	if(canshu.filetype == undefined){
		
	}else if(canshu.filetype == "img"){
		if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(filename)){
			//tankuangalert({content:"请选择图片！",fun:function(){}});
			//return false;
		}
	}else if(canshu.filetype == "excel"){
		if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(filename)){
			tankuangalert({content:"请选择表格！",fun:function(){}});
			return false;
		}
	}else if(canshu.filetype == "video"){
		if(!/\.(mp4|MP4)$/.test(filename)){
			tankuangalert({content:"请选择视频！",fun:function(){}});
			return false;
		}
	}
	var key = new Date().getTime();
	jQuery.ajaxFileUpload({
		url : canshu.linkpath+canshu.link1, 
		secureuri : false,// 一般设置为false
		fileElementId : 'uploadToImportFile', // 文件上传控件的id属性 <input
		dataType : 'json',
		data : {id:key},
		success : function(data) { // 服务器成功响应处理函数
			tankuangalert({content:"上传成功！",fun:function(){
				if(canshu.successFun!=undefined){
					canshu.successFun();
				}
				$.ajax({
					   async:false,
					   url: canshu.linkpath+canshu.link2, 
					   type: "GET",
					   dataType: "jsonp", 
				        jsonp: "callbackparam", //服务端用于接收callback调用的function名的参数  
				        jsonpCallback: "success", //callback的function名称,服务端会把名称和data一起传递回来  
				        data:{key:key},
				        success: function(json){
				        	var path = eval(json[0]);
				        	canshu.pathFun(path);
				        },
				        error: function(json){alert("error");}
				});
			}});
		},
		error : function(data, e) { // 服务器响应失败处理函数
			tankuangalert({content:"上传失败！",fun:function(){
				$("#tankuang").remove();
				return;
			}});
		}
	}); 
}
//
function ajaxUploadImageNoDialog(canshu){
	$(document).ajaxStart(function() {
		// 开始上传文件时显示一个图片
		$("body").append(jianzaihtml);
	}).ajaxComplete(function() {
		// 文件上传完成将图片隐藏起来
		$("#tankuangjiazai").remove();
	});
	//判断文件类型
	var filename = canshu.filename;
	if(filename == null || filename == ''){
		tankuangalert({content:"请选择文件！",fun:function(){}});
		return false;
	}
	if(canshu.filetype == undefined){
		
	}else if(canshu.filetype == "img"){
		if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(filename)){
			//tankuangalert({content:"请选择图片！",fun:function(){}});
			//return false;
		}
	}else if(canshu.filetype == "excel"){
		if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(filename)){
			tankuangalert({content:"请选择表格！",fun:function(){}});
			return false;
		}
	}else if(canshu.filetype == "video"){
		if(!/\.(mp4|MP4)$/.test(filename)){
			tankuangalert({content:"请选择视频！",fun:function(){}});
			return false;
		}
	}
	var key = new Date().getTime();
	jQuery.ajaxFileUpload({
		url : canshu.linkpath+canshu.link1,
		secureuri : false,// 一般设置为false
		fileElementId : 'uploadToImportFile', // 文件上传控件的id属性 <input
		dataType : 'json',
		data : {id:key},
		success : function(data) { // 服务器成功响应处理函数
			if(canshu.successFun!=undefined){
				canshu.successFun();
			}
			$.ajax({
				   async:false,
				   url: canshu.linkpath+canshu.link2,
				   type: "GET",
				   dataType: "jsonp",
			        jsonp: "callbackparam", //服务端用于接收callback调用的function名的参数
			        jsonpCallback: "success", //callback的function名称,服务端会把名称和data一起传递回来
			        data:{key:key},
			        success: function(json){
			        	var path = eval(json[0]);
			        	canshu.pathFun(path);
			        },
			        error: function(json){alert("error");}
			});
		},
		error : function(data, e) { // 服务器响应失败处理函数
			tankuangalert({content:"上传失败！",fun:function(){
				$("#tankuang").remove();
				return;
			}});
		}
	});
}
//
window.uploadImage = {"link1":"","link2":'',"name":'',"picture":'',"linkpath":''};
//打开上传图片框
function openUploadDialog(obj,link1,link2,linkpath,name,picture){
	if($("#upload").length > 0){
		$("#upload").find(".imageShow").hide();
		$("#upload").find(".imageShow .img").attr("src","");
		$("#upload").find(".uploadImageBlock").show();
		$("#upload").find("#uploadToImportFile").val("");
		$("#upload").find(".uploadClick").show();
		$("#upload").show();
	}else{
		$(obj).parents("body").append(uploadImagehtml);
		$("#upload").show();
	}
	uploadImage.link1 = link1;
	uploadImage.link2 = link2;
	uploadImage.linkpath = linkpath;
	uploadImage.name = name;
	uploadImage.picture = picture;
}
//校验上传文件类型
function isLegalFiletype(filename) {
//	var pattern = /(.jpg|.zip|.html|.htm)$/;
//	if (!pattern.exec(filename)) {
//		alert("文件格式不正确!");
//		return false;
//	}
	if(filename == ""){
		alert("请选择图片！")
		return false;
	}
	return true;
}

function contactAjaxFileUpload(obj) {
//	$("#showTable").empty();
	/*$("#loadingimg").ajaxStart(function() {
		// 开始上传文件时显示一个图片
		$(this).show();
	}).ajaxComplete(function() {
		// 文件上传完成将图片隐藏起来
		$(this).hide();
	});*/
	//
	var key = new Date().getTime()+Math.round(Math.random()*100000);
	if (isLegalFiletype($("#uploadToImportFile").val())) {
		$.ajaxFileUpload({
			url : uploadImage.linkpath+uploadImage.link1, 
			secureuri : false,// 一般设置为false
			fileElementId : 'uploadToImportFile', // 文件上传控件的id属性 <input
			dataType : 'json',
			data : {id:key},
			success : function(data) { // 服务器成功响应处理函数
				$("#upload").find(".imageShow").show();
				$("#upload").find(".uploadImageBlock").hide();
				$("#upload").find(".uploadClick").hide();
				$.ajax({
					   async:false,
					   url: uploadImage.linkpath+uploadImage.link2, 
					   type: "GET",
					   dataType: "jsonp", 
				        jsonp: "callbackparam", //服务端用于接收callback调用的function名的参数  
				        jsonpCallback: "success", //callback的function名称,服务端会把名称和data一起传递回来  
				        data:{key:key},
				        success: function(json){
				        	var data = eval(json[0]);
				        	var path = data.retData;
							if(data.retCode == 'success'){
					        	uploadImage.name.val(path);
					        	$("#upload").find(".imageShow .img").attr("src",uploadImage.linkpath+path);
					        	uploadImage.picture.attr("src",uploadImage.linkpath+path).show();
					        }else{
								alert("上传异常"+data.retData);
							}
				        },
				        error: function(json){alert("error");}
				});
			},
			error : function(data, e) { // 服务器响应失败处理函数
				alert("上传失败");
				$("#upload").find("uploadClick").show();
				return;
			}
		}); 
	}
}
//上传文件
function ajaxFileUpload(obj,link1,link2,linkpath,name,uploadInputId) {
	console.error($("#"+uploadInputId).val()!='');
	if ($("#"+uploadInputId).val()!='') {
		$.ajaxFileUpload({
			url : linkpath+link1, 
			secureuri : false,// 一般设置为false
			fileElementId : uploadInputId, // 文件上传控件的id属性 <input
			dataType : 'json',
			data : {id:$("#hiddenid").val()},
			success : function(data) { // 服务器成功响应处理函数
				alert("上传成功");
				$.ajax({
					   async:false,
					   url: linkpath+link2, 
					   type: "GET",
					   dataType: "jsonp", 
				        jsonp: "callbackparam", //服务端用于接收callback调用的function名的参数  
				        jsonpCallback: "success", //callback的function名称,服务端会把名称和data一起传递回来  
				        success: function(json){
				        	var path = eval(json[0]).path;
				        	name.val(path);
				        	$("#"+uploadInputId).hide();
				        	$(obj).hide();
				        	$(obj).siblings(".huixian").show().html(path);
				        	$(obj).siblings(".xiugai").show();
				        },
				        error: function(json){alert("error");}
				});
			},
			error : function(data, e) { // 服务器响应失败处理函数
				alert("上传失败");
				$("#upload").find("uploadClick").show();
				return;
			}
		}); 
	}else{
		alert("请选择文件!");
	}
    
}