window.onload = function() {
	var word_input_width;
	if(/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)){
		word_input_width = "60%"
	} else {
		$("#word").focus();
		word_input_width = "20%";
	}
	$("#word").css("width", word_input_width);
	
	$("#search").click(function() {
		var word = $("#word").val();
		var f_type =  $("#f_type").val();
		var f_type2 =  $("#f_type2").val();
		var type = '';
		if ("1" == f_type2) {
			type = "startwith/";
		} else if ("2" == f_type2) {
			type = "endwith/";
		} else {
			type = "";
		}
		var result = '';
		$.ajax({  // ajax请求
				url:"../idiom/" + type + word +"/20" ,
				type:"get",
				data:{},
				dataType : 'json',
				async:false,
				success:function(res){
					$("#idiom_tbody").empty();
					if (res.length == 0) {
						word = $("#word").val();
						$("#idiom_tbody").append("<h2>没有搜索到与\""+word+"\"有关的成语(T_T)，换个词试试吧~<h2>");
						return;
					}
					for (var i = 0; i < res.length; i++) {
						var derivation = res[i].derivation;
						var example = res[i].example;
						var explanation = res[i].explanation;
						var pinyin = res[i].pinyin;
						var word = res[i].word;
						var abbreviation = res[i].abbreviation;
						derivation = derivation.substring(0, derivation.lastIndexOf("。")+1);
//						alert(word);<td>"+derivation+"</td>\n<td>"+example+"</td>\n
						var content = "<tr class=\"footable-even\" style=\"\">\n"
									+"<td>\n"
									+"<ul style=\"list-style-type:none;padding-left: 8px;\">\n"
									+"<h2><strong>"+word+"</strong></h2>\n"
									+"<li><strong>读音:&nbsp;&nbsp;</strong>"+pinyin+"</li>\n"
									+"<li><strong>解释:&nbsp;&nbsp;</strong>"+explanation+"</li>\n"
									+"<li><strong>出处:&nbsp;&nbsp;</strong>"+derivation+"</li>\n"
									+"<li><strong>用例:&nbsp;&nbsp;</strong>"+example+"</li>\n"
									+"</ul>\n"
									+"</td>\n"
									+"</tr>\n";
//						$("#idiom_tbody").append("<tr class='footable-even' style>\n<td>\n<span class='footable-toggle'></span>\n"+word+"</td>\n<td>"+pinyin+"</td>\n<td>"+explanation+"</td>\n</tr>");
						$("#idiom_tbody").append(content);
						var tagobj = $("#idiom_tbody");
					}
					$.parser.parse(tagobj);
				}
			});
//		window.location = "http://www.ghostxu.cn/sd_cms/idiom/" + word;
	});
}


$("input").keydown(function(event) {
	e = event ? event : (window.event ? window.event : null);
	if (e.keyCode == 13) {
//		alert("检测到回车");
		$("#search").click();
		return false;
	}
});
