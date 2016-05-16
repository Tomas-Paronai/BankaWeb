$(document).ready(function(){
	$(".tablink").click(function(){
		changeTabContent(this);
	});
});

function changeTabContent(el){
	$(".tab-content").css("display","none");
	$("#"+$(el).attr("data")).css("display","block");
}