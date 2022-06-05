let accountInfo = {}

function checkInputLogin(){
	$("#email-login").change(function() {
		let email = $(this).val();
		let regexEmail = new RegExp(/^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/);
		if(!regexEmail.test(email)){
			$("#error-email-login").text("Vui lòng không bỏ trống và nhập Email hợp lệ")
			return false;
		}else {
			$("#error-email-login").text("")
		}
		
		
		accountInfo.email = email;
	})
	
	$("#password-login").bind("change",function() {
		let password = $(this).val();
		if(password.length <1){
			$("#error-password-login").text("Xin vui lòng nhập mật khẩu !")
			return false;
		}else {
			$("#error-password-login").text("")
		}
		
		accountInfo.password = password;
	})
}



$(document).ready(function () {
	
	//alert('okko')
	console.log('auth')
	checkInputLogin();
	
	$("#btn-login").click(function (e) {
		e.preventDefault();
		if(!jQuery.isEmptyObject(accountInfo)){
			$("#form-login").submit();

	      }else {
	    	  $("#error-email-login").text("Vui lòng nhập Email")
	    	  $("#error-password-login").text("Xin vui lòng nhập mật khẩu !")
	      }
	});
	
	
})	
	