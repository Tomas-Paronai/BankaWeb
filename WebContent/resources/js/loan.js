var checkedRadio;

$(document).ready(function(){
	checkedRadio = $("input[type=radio]");
	
	$("input[type=radio]").change(function(){
		countResults(this);
		checkedRadio = this;
	});
	
	$('#loanAmount').on('keyup',function(){
		setTimeout(function(){
			countResults(checkedRadio);
		},2000);
	});
});

function countResults(radioInterest){
	var interest = $(radioInterest).val();
	var amount = parseFloat($("#loanAmount").val());
	var repay = amount * 0.3 + amount
	var months = repay / (amount * interest);;
		
	$("#repay").text(repay + " $");
	$("#months").text(months);	
}