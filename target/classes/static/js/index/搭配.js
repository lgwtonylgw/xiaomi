$(function(){
		/* 页面加载后第一个选项-‘热门’默认被选中 */
		$("#dapei>#title>div>ul>li:first").addClass("ontitle");
		$("#dapei>#content>.content_right").hide();
		$($("#dapei>#content>.content_right")[0]).show();
		/* 鼠标放到哪个选项上，对应的处理 */
		$("#dapei>#title>div>ul>li").mouseover(function(){
			$("#dapei>#title>div>ul>li").removeClass("ontitle");
			$(this).addClass("ontitle");
			for(var i=0;i<4;i++){
				if(this==$("#dapei>#title>div>ul>li")[i]){
					$("#dapei>#content>.content_right").hide();
					$($("#dapei>#content>.content_right")[i]).show();
				}
			}
		})
	})