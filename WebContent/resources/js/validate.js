$(document).ready(function(){
	$("#passwordForm").submit(function(){
		return validatePassword();
	});
	
	$("#emailForm").submit(function(){
		return validateEmail();
	});
	
	$("deactivate-card-form").ajaxForm(function(e){
		deactivateCard(e);
	});
});

function deactivateCard(e){
	var url = "deactivateCard";
	$.ajax({
		type: "POST",
		url: url,
		data: $("#deactivate-card-form").serialize(),
		success: function(data){
			alert(data);
		}
	});
	e.preventDefault();
}

function validatePassword(){
	var password = $("#password").val();
	var passwordRe = $("#passwordRe").val();
	if(password == passwordRe){
		$("#passError").text("");
		return true;
	}
	$("#passError").text("Passwords does not match!");
	$("#password").val("");
	$("#passwordRe").val("");
	return false;
}

function validateEmail(){
	var email = new RegExp('^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,6}$');
	if(email.test($("#email").val())){		
		return true;
	}
	return false;
}