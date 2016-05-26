$(document).ready(function(){
	scaleBodyTable();
	
	loadWithPath();
	
	$(".tablink").click(function(){
		changePath(this);
	});
});

function changePath(el){
	var link = document.location.href;
	link += "/" + $(el).attr("data");
	document.location.href = link;
}

function loadWithPath(){
	var link = document.location.href;
	var n = link.lastIndexOf('/');
	var result = link.substring(n+1);
	alert(result);
}

function scaleBodyTable(){
	var height = $(window).height();
	//TODO
}

