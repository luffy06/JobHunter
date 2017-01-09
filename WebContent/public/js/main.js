function changeRegisterAction(role) {
	alert(role)
	document.getElementId("registerform").action="register?role="+role;
}