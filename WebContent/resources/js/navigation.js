$(document).ready(function(){
	$(".tablink").click(function(){
		changeTabContent(this);
	});
	
	$(".trans-nav").click(function(){
		changeTransContent(this);
	});
	
	$(".trans-nav").hover(function(){
		showcase(this);
	});
});

function changeTabContent(el){
	$(".tablink").attr('class','tablink');
	$(".trans-nav").attr('class','trans-nav');
	$(".trans-content").css("display","none");
	$(el).toggleClass("chosen");
	$(".tab-content").css("display","none");
	$("#"+$(el).attr("data")).css("display","block");
}

function changeTransContent(el){
	$(".trans-nav").attr('class','trans-nav');
	$(el).toggleClass("chosen");
	$(".trans-content").css("display","none");
	$("#"+$(el).attr("data")).css("display","block");
}

function showcase(el){	
	var connVal = $(el).attr("data");
	$('.showcase[conn="'+connVal+'"]').toggleClass("active");
}