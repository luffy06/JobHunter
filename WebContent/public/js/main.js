function changeRegisterAction(role) {
	alert(role)
	document.getElementById("registerform").action="register?role="+role;
}