

function validatePassword(){
	var password = $("#password").text();
	var passwordRe = $("#passwordRe").text();
	if(password == passwordRe){
		$("#passError").text("");
		return true;
	}
	$("#passError").text("Passwords does not match!");
	return false;
}