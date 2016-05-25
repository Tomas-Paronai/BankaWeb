$(document).ready(function(){
	$("input[type=radio]").change(function(){
		var interest = this.value;
		alert(interest);
		var amount = $("#amount").val();
		alert(amount);
		var repay = amount * 0.3 + amount
		alert(repay);
		var months = repay / (amount * interest);
		alert(months);
		
		$("#repay").text(repay + " $");
		$("#months").text(months);
	});
});