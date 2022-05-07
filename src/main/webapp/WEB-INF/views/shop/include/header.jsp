<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/taglib/tag.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="utf-8">
<title>Shoeniverse - Shop</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Free HTML Templates" name="keywords">
<meta content="Free HTML Templates" name="description">

<!-- Favicon -->
<link href="<c:url value='resources/user/img/favicon.ico' /> "
	rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="<c:url value='resources/user/lib/animate/animate.min.css'/>"
	rel="stylesheet">
<link
	href="<c:url value='resources/user/lib/owlcarousel/assets/owl.carousel.min.css'/>"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="<c:url value='resources/user/css/style.css'/>"
	rel="stylesheet">

<link href="<c:url value='resources/user/css/custom-d.css' />"
	rel="stylesheet">
<link href="<c:url value='resources/user/css/custom-t.css'/>"
	rel="stylesheet">
<link href="<c:url value='resources/user/css/custom-n.css'/>"
	rel="stylesheet">

</head>

<body>
	<!-- Topbar Start -->
	<div class="container-fluid">
		<div class="row bg-secondary py-1 px-xl-5">
			<div class="col-lg-6 d-none d-lg-block leader">
				<div class="d-inline-flex align-items-center h-100 topbar-font">
					<a class="text-body mr-3" href="">About</a> <a
						class="text-body mr-3" href="">Liên hệ</a> <a
						class="text-body mr-3" href="">Trợ giúp</a> <a
						class="text-body mr-3" href="">Câu hỏi thường gặp<span
						class="fa fa-question-circle ml-1"></span></a>
				</div>
			</div>
			<div class="col-lg-6 text-center text-lg-right">
				<div class="d-inline-flex align-items-center">
					<!-- <div class="btn-group">
						<button type="button" class="btn btn-sm btn-light dropdown-toggle"
							data-toggle="dropdown">Tài khoản</button>
						<div class="dropdown-menu dropdown-menu-right">
							<button class="dropdown-item" type="button">Đăng nhập</button>
							<button class="dropdown-item" type="button">Đăng ký</button>
						</div>
					</div> -->
					<a class="btn btn-primary" href="dangnhap" role="button">Đăng
						nhập</a>
					<!-- <a class="btn  bg-danger ml-2 text-white" href="dangky" role="button">Đăng ký</a> -->
				</div>
				<div class="d-inline-flex align-items-center d-block d-lg-none">
					<a href="" class="btn px-0 ml-2"> <i class="fa fa-search"></i>
					</a> <a href="user.html" class="btn px-0 ml-2"> <i
						class="fas fa-user text-dark"></i>
					</a> <a href="" class="btn px-0 ml-2"> <i
						class="fas fa-shopping-cart text-dark"></i> <span
						class="badge text-dark border border-dark rounded-circle"
						style="padding-bottom: 2px;">0</span>
					</a>
				</div>
			</div>
		</div>
		<div
			class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
			<div class="col-lg-3">
				<a href="" class="text-decoration-none"> <!-- <span class="h1 text-uppercase text-primary bg-dark px-2">Multi</span> -->
					<!-- <span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">Shop</span> -->
					<span class="h2 text-uppercase text-dark px-2 ml-n1"
					style="font-weight: 800;">shoeniverse</span>
				</a>
			</div>
			<div class="col-lg-5 col-6">
				<form action="">
					<div class="input-group justify-content-center">
						<input type="text" class="form-control"
							placeholder="Nhập sản phẩm cần tìm">
						<div class="input-group-append">
							<span class="input-group-text bg-transparent text-primary">
								<i class="fa fa-search"></i>
							</span>
						</div>
					</div>
				</form>
			</div>
			<div
				class="col-lg-3 offset-lg-1 col-6 d-flex text-right text-white bg-danger py-2 rounded-service">
				<div>
					<span class="fa fa-phone bg-primary rounded-phone"></span>
				</div>
				<div class="pl-4 ml-5">
					<p class="m-0">Chăm sóc khách hàng</p>
					<h5 class="m-0 text-white">Tel:+012 345 6789</h5>
				</div>

			</div>
		</div>
	</div>
	<!-- Topbar End -->


	<!-- Navbar Start -->
	<div class="container-fluid bg-dark mb-30">
		<div class="row">
			<div class="col-lg-2 d-none d-lg-block">
				<a
					class="btn d-flex align-items-center justify-content-between bg-primary w-100"
					data-toggle="collapse" href="#navbar-vertical"
					style="height: 65px; padding: 0 30px;">
					<h6 class="text-dark m-0">
						<i class="fa fa-bars mr-2"></i>DANH MỤC
					</h6> <i class="fa fa-angle-down text-dark"></i>
				</a>
				<nav
					class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 bg-light"
					id="navbar-vertical"
					style="width: calc(100% - 30px); z-index: 999;">
					<div class="navbar-nav w-100">
						<a href="" class="nav-item nav-link">Giày</a> <a href=""
							class="nav-item nav-link">Sandal</a> <a href=""
							class="nav-item nav-link">Dép</a>
					</div>
				</nav>
			</div>
			<div class="col-lg-9">
				<nav
					class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0">
					<a href="" class="text-decoration-none d-block d-lg-none"> <span
						class="h1 text-uppercase text-light px-2 ml-n1">shoeniverse</span>
					</a>
					<button type="button" class="navbar-toggler" data-toggle="collapse"
						data-target="#navbarCollapse">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse justify-content-between"
						id="navbarCollapse">
						<div class="navbar-nav mr-auto py-0">
							<a href="./" class="nav-item nav-link">TRANG CHỦ</a>
							<div class="nav-item dropdown">
								<a href="#" class="nav-link dropdown-toggle"
									data-toggle="dropdown">MUA SẮM<i
									class="fa fa-angle-down ml-1 mt-1"></i></a>
								<div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
									<a href="cart.html" class="dropdown-item">NAM</a> <a
										href="checkout.html" class="dropdown-item">NỮ</a>
								</div>
							</div>
							<a href="chitietsanpham" class="nav-item nav-link">CHI TIẾT
								SẢN PHẨM</a> <a href="lienhe" class="nav-item nav-link">LIÊN HỆ</a>
						</div>
						<div class="navbar-nav ml-auto py-0 d-none d-lg-block">
							<a href="user.html" class="btn px-0"> <i
								class="fas fa-user text-primary"></i>
							</a> <a href="" class="btn px-0 ml-3"> <i
								class="fas fa-shopping-cart text-primary"></i> <span
								class="badge text-secondary border border-secondary rounded-circle"
								style="padding-bottom: 2px;">0</span>
							</a>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</div>
	<!-- Navbar End -->