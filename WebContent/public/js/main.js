function changeRegisterAction(role) {
	alert(role)
	document.getElementById("registerform").action="register?role="+role;
}

$(function() {
	$('.form_datetime').datetimepicker({
		format: 'yyyy-mm-dd'
	});
})