<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Header -->
<%@include file="/WEB-INF/views/shop/include/header.jsp"%>
<!-- Header End -->

<%@include file="/WEB-INF/views/taglib/tag.jsp"%>

<main>
	<!-- Breadcrumb Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-12">
				<nav class="breadcrumb bg-light mb-30">
					<a class="breadcrumb-item text-dark" href="#">Trang chủ</a> <span
						class="breadcrumb-item active">Đăng nhập</span>
				</nav>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->


	<!-- Shop Start -->
	<div class="container">

		<div class="row px-xl-5 d-flex justify-content-center">
			<div class="col-lg-12 form-sign-in ">
				<ul class="nav nav-pills mb-3 justify-content-center mb-5"
					id="pills-tab" role="tablist">
					<li class="nav-item"><a class="nav-link active h4"
						id="pills-home-tab" data-toggle="pill" href="#login-form"
						role="tab" aria-controls="pills-home" aria-selected="true">ĐĂNG
							NHẬP</a></li>
					<li class="nav-item"><a class="nav-link h4"
						id="pills-profile-tab" data-toggle="pill" href="#register-form"
						role="tab" aria-controls="pills-profile" aria-selected="false">ĐĂNG
							KÝ</a></li>

				</ul>

				<div class="tab-content" id="pills-tabContent">
					<div class="tab-pane fade show active" id="login-form"
						role="tabpanel" aria-labelledby="pills-home-tab">


						<form:form action="dang-nhap" method="post" id="form-login"
							modelAttribute="taikhoan">
							<div class="form-floating mb-3">
								<form:input path="email" id="email-login" placeholder="EMAIL"
									class="form-control border-top-0 border-left-0 border-right-0 border-size-2" />
								
								<form:errors path="email" cssClass="text-danger" />
								<p class="text-danger" id="error-email-login"></p>
							</div>
							<div class="form-floating mb-3">
								<form:password path="matKhau"
									class="  form-control border-top-0 border-left-0 border-right-0 border-size-2"
									id="password-login" placeholder="MẬT KHẨU" />
								<form:errors path="matKhau" cssClass="text-danger" />
								<p class="text-danger" id="error-password-login"></p>

							</div>
							<p class="text-danger">${message }</p>
							<button id="btn-login" class="w-100 btn btn-primary h5 mt-4"
								type="submit">ĐĂNG NHẬP</button>
						</form:form>

						<%-- <form action="auth/dang-nhap" method="post">

							<div class="form-floating mb-3">

								<input type="email"
									class="  form-control border-top-0 border-left-0 border-right-0 border-size-2"
									id="email-login" placeholder="EMAIL">
								<p class="text-danger" id="error-email-login"></p>
									
							</div>
							<div class="form-floating mb-3">
								<input type="password"
									class="  form-control border-top-0 border-left-0 border-right-0 border-size-2"
									id="password-login" placeholder="MẬT KHẨU">
									<p class="text-danger" id="error-password-login"></p>
							</div>

							<div
								class="checkbox d-flex mt-4 justify-content-between align-self-center remember">
								<label> <input type="checkbox" value="remember-me"><small>Nhớ
										mật khẩu</small>
								</label> <a class="forgetpass" href="#"><small>Quên mật
										khẩu?</small></a>
							</div>
							<button id="btn-login" class="w-100 btn btn-primary h5 mt-4" type="submit">ĐĂNG
								NHẬP</button>
						</form> --%>
					</div>
					<div class="tab-pane fade" id="register-form" role="tabpanel"
						aria-labelledby="pills-profile-tab">
						<form>

							<div class="form-floating">

								<input type="text"
									class=" mb-3 form-control border-top-0 border-left-0 border-right-0 border-size-2"
									id="lastName-register" placeholder="HỌ">
							</div>
							<div class="form-floating">
								<input type="text"
									class=" mb-3 form-control border-top-0 border-left-0 border-right-0 border-size-2"
									id="fistName-register" placeholder="TÊN">
							</div>
							<div class="form-floating">
								<input type="email"
									class=" mb-3 form-control border-top-0 border-left-0 border-right-0 border-size-2"
									id="email-register" placeholder="EMAIL">
							</div>
							<div class="form-floating">
								<input type="password"
									class=" mb-3 form-control border-top-0 border-left-0 border-right-0 border-size-2"
									id="password-register" placeholder="MẬT KHẨU">
							</div>
							<div class="form-floating">
								<input type="password"
									class=" mb-3 form-control border-top-0 border-left-0 border-right-0 border-size-2"
									id="confirmPassword-register" placeholder="NHẬP LẠI MẬT KHẨU">
							</div>
							<div class="form-floating">
								<input type="text"
									class=" mb-3 form-control border-top-0 border-left-0 border-right-0 border-size-2"
									id="phone-register" placeholder="SỐ ĐIỆN THOẠI">
							</div>
							<div class="form-floating">
								<input type="text"
									class=" mb-3 form-control border-top-0 border-left-0 border-right-0 border-size-2"
									id="address-register" placeholder="ĐỊA CHỈ">
							</div>
							<button class="btn btn-primary h5 mt-4 w-100" type="submit">ĐĂNG
								KÝ</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- Shop End -->

</main>


<!-- Footer -->
<%@include file="/WEB-INF/views/shop/include/footer.jsp"%>
<!-- Footer End -->



<!-- JS Lib -->
<%@include file="/WEB-INF/views/shop/include/jsLib.jsp"%>
<!-- JS Lib End -->

<script src="resources/user/js/auth.js"></script>
</body>

</html>

