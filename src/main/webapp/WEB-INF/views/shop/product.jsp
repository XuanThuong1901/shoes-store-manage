<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Header -->
<%@include file="/WEB-INF/views/shop/include/header.jsp"%>
<!-- Header End -->
<main>
	<!-- Breadcrumb Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-12">
				<nav class="breadcrumb bg-light mb-30">
					<a class="breadcrumb-item text-dark" href="#">Trang chủ</a> <span
						class="breadcrumb-item active">Mua sắm</span>
				</nav>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Shop Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<!-- Shop Sidebar Start -->
			<div class="col-lg-3 col-md-4">
				<!-- Status Start -->
				<h5 class="section-title position-relative text-uppercase mb-3"
					data-toggle="collapse" href="#collapseStatus" role="button"
					aria-expanded="true" aria-controls="collapseStatus">
					<span class="bg-secondary pr-3">Status <i
						class="fas fa-chevron-down"></i></span>
				</h5>
				<div class="collapse show" id="collapseStatus">
					<div class="bg-light p-4 mb-30">
						<form>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input"
									id="status-all" checked> <label
									class="custom-control-label" for="status-all">All</label> <span
									class="badge border font-weight-normal">145</span>
							</div>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between">
								<input type="checkbox" class="custom-control-input"
									id="status-sale-off"> <label
									class="custom-control-label" for="status-sale-off">Sale
									off</label> <span class="badge border font-weight-normal">168</span>
							</div>
						</form>
					</div>
				</div>
				<!-- Status End -->
				<!-- Categories Start -->
				<h5 class="section-title position-relative text-uppercase mb-3"
					data-toggle="collapse" href="#collapseCategories" role="button"
					aria-expanded="true" aria-controls="collapseCategories">
					<span class="bg-secondary pr-3">Categories <i
						class="fas fa-chevron-down"></i></span>
				</h5>
				<div class="collapse show" id="collapseCategories">
					<div class="bg-light p-4 mb-30">
						<form>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input"
									id="category-all" checked> <label
									class="custom-control-label" for="category-all">All</label> <span
									class="badge border font-weight-normal">145</span>
							</div>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input"
									id="category-nike"> <label class="custom-control-label"
									for="category-nike">Nike</label> <span
									class="badge border font-weight-normal">168</span>
							</div>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input"
									id="category-adidas"> <label
									class="custom-control-label" for="category-adidas">Adidas</label>
								<span class="badge border font-weight-normal">145</span>
							</div>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input"
									id="category-vans"> <label class="custom-control-label"
									for="category-vans">Vans</label> <span
									class="badge border font-weight-normal">145</span>
							</div>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input"
									id="category-converse"> <label
									class="custom-control-label" for="category-converse">Converse</label>
								<span class="badge border font-weight-normal">145</span>
							</div>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input"
									id="category-ananas"> <label
									class="custom-control-label" for="category-ananas">Ananas</label>
								<span class="badge border font-weight-normal">145</span>
							</div>
						</form>
					</div>
				</div>
				<!-- Categories End -->
				<!-- Price Start -->
				<h5 class="section-title position-relative text-uppercase mb-3"
					data-toggle="collapse" href="#collapsePrice" role="button"
					aria-expanded="true" aria-controls="collapsePrice">
					<span class="bg-secondary pr-3">Price <i
						class="fas fa-chevron-down"></i></span>
				</h5>
				<div class="collapse show" id="collapsePrice">
					<div class="bg-light p-4 mb-30">
						<form>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input" checked
									id="price-all"> <label class="custom-control-label"
									for="price-all">All Price</label> <span
									class="badge border font-weight-normal">1000</span>
							</div>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input" id="price-1">
								<label class="custom-control-label" for="price-1">$0 -
									$100</label> <span class="badge border font-weight-normal">150</span>
							</div>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input" id="price-2">
								<label class="custom-control-label" for="price-2">$100 -
									$200</label> <span class="badge border font-weight-normal">295</span>
							</div>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input" id="price-3">
								<label class="custom-control-label" for="price-3">$200 -
									$300</label> <span class="badge border font-weight-normal">246</span>
							</div>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
								<input type="checkbox" class="custom-control-input" id="price-4">
								<label class="custom-control-label" for="price-4">$300 -
									$400</label> <span class="badge border font-weight-normal">145</span>
							</div>
							<div
								class="custom-control custom-checkbox d-flex align-items-center justify-content-between">
								<input type="checkbox" class="custom-control-input" id="price-5">
								<label class="custom-control-label" for="price-5">$400 -
									$500</label> <span class="badge border font-weight-normal">168</span>
							</div>
						</form>
					</div>
				</div>
				<!-- Price End -->
				<!-- Color Start -->
				<!-- <h5 class="section-title position-relative text-uppercase mb-3" data-toggle="collapse"
                    href="#collapseColor1" role="button" aria-expanded="true" aria-controls="collapseColor1"><span
                        class="bg-secondary pr-3">color <i class="fas fa-chevron-down"></i></span></h5>
                <div class="collapse show" id="collapseColor1">
                    <div class="bg-light p-4 mb-30">
                        <form>
                            <div
                                class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="checkbox" class="custom-control-input" checked id="color-all">
                                <label class="custom-control-label" for="price-all">All Color</label>
                                <span class="badge border font-weight-normal">1000</span>
                            </div>
                            <div
                                class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="checkbox" class="custom-control-input" id="color-1">
                                <label class="custom-control-label" for="color-1">Black</label>
                                <span class="badge border font-weight-normal">150</span>
                            </div>
                            <div
                                class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="checkbox" class="custom-control-input" id="color-2">
                                <label class="custom-control-label" for="color-2">White</label>
                                <span class="badge border font-weight-normal">295</span>
                            </div>
                            <div
                                class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="checkbox" class="custom-control-input" id="color-3">
                                <label class="custom-control-label" for="color-3">Red</label>
                                <span class="badge border font-weight-normal">246</span>
                            </div>
                            <div
                                class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                <input type="checkbox" class="custom-control-input" id="color-4">
                                <label class="custom-control-label" for="color-4">Blue</label>
                                <span class="badge border font-weight-normal">145</span>
                            </div>
                            <div
                                class="custom-control custom-checkbox d-flex align-items-center justify-content-between">
                                <input type="checkbox" class="custom-control-input" id="color-5">
                                <label class="custom-control-label" for="color-5">Green</label>
                                <span class="badge border font-weight-normal">168</span>
                            </div>
                        </form>
                    </div>
                </div> -->
				<!-- Color End -->
				<!-- Color custom start-->
				<h5 class="section-title position-relative text-uppercase mb-3"
					data-toggle="collapse" href="#collapseColor" role="button"
					aria-expanded="true" aria-controls="collapseColor">
					<span class="bg-secondary pr-3">color custom <i
						class="fas fa-chevron-down"></i></span>
				</h5>
				<div class="collapse show" id="collapseColor">
					<div class="bg-light p-4 mb-30">
						<div class="d-flex flex-wrap g-2">
							<label class=" btn-filter-color" id="btn-color--#dc3545">
								<span class=" btn-filter-color-item"
								style="background-color: #dc3545"></span> <input type="checkbox"
								name="" hidden />
							</label> <label class=" btn-filter-color" id="btn-color--#007bff">
								<span class=" btn-filter-color-item"
								style="background-color: #007bff"></span> <input type="checkbox"
								name="" hidden />
							</label> <label class=" btn-filter-color" id="btn-color--#6f42c1">
								<span class=" btn-filter-color-item"
								style="background-color: #6f42c1"></span> <input type="checkbox"
								name="" hidden />
							</label> <label class=" btn-filter-color" id="btn-color--#ffc107">
								<span class=" btn-filter-color-item"
								style="background-color: #ffc107"></span> <input type="checkbox"
								name="" hidden />
							</label> <label class=" btn-filter-color" id="btn-color--#fff"> <span
								class=" btn-filter-color-item" style="background-color: #fff"></span>
								<input type="checkbox" name="" hidden />
							</label> <label class=" btn-filter-color" id="btn-color--#28a745">
								<span class=" btn-filter-color-item"
								style="background-color: #28a745"></span> <input type="checkbox"
								name="" hidden />
							</label> <label class=" btn-filter-color" id="btn-color--#343a40">
								<span class=" btn-filter-color-item"
								style="background-color: #343a40"></span> <input type="checkbox"
								name="" hidden />
							</label> <label class=" btn-filter-color" id="btn-color--#e83e8c">
								<span class=" btn-filter-color-item"
								style="background-color: #e83e8c"></span> <input type="checkbox"
								name="" hidden />
							</label> <label class=" btn-filter-color" id="btn-color--#fd7e14">
								<span class=" btn-filter-color-item"
								style="background-color: #fd7e14"></span> <input type="checkbox"
								name="" hidden />
							</label>

						</div>
					</div>
				</div>
				<!-- Color custom end -->

				<!-- Size Start -->
				<h5 class="section-title position-relative text-uppercase mb-3"
					data-toggle="collapse" href="#collapseSize" role="button"
					aria-expanded="true" aria-controls="collapseSize">
					<span class="bg-secondary pr-3">size <i
						class="fas fa-chevron-down"></i></span>
				</h5>
				<div class="collapse show" id="collapseSize">
					<div class="bg-light p-4 mb-30">
						<div class="d-flex flex-wrap g-2">
							<button class="btn border m-1 btn-filter-size" id="btn-size--35">35</button>
							<button class="btn border m-1 btn-filter-size" id="btn-size--36">36</button>
							<button class="btn border m-1 btn-filter-size" id="btn-size--37">37</button>
							<button class="btn border m-1 btn-filter-size" id="btn-size--38">38</button>
							<button class="btn border m-1 btn-filter-size" id="btn-size--39">39</button>
							<button class="btn border m-1 btn-filter-size" id="btn-size--40">40</button>
							<button class="btn border m-1 btn-filter-size" id="btn-size--41">41</button>
							<button class="btn border m-1 btn-filter-size" id="btn-size--42">42</button>
							<button class="btn border m-1 btn-filter-size" id="btn-size--43">43</button>
							<button class="btn border m-1 btn-filter-size" id="btn-size--44">44</button>
						</div>

						<div
							class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-2">
							<input type="checkbox" class="custom-control-input" id="size-5">
							<label class="custom-control-label ml-1" for="size-5">Tất
								cả</label>

						</div>
					</div>
				</div>

				<!-- Size End -->

			</div>
			<!-- Shop Sidebar End -->


			<!-- Shop Product Start -->
			<div class="col-lg-9 col-md-8">
				<div class="row pb-3">
					<div class="col-12">
						<div
							class="d-flex align-items-center justify-content-between mb-4">
							<div>
								<button class="btn btn-sm btn-light">
									<i class="fa fa-th-large"></i>
								</button>
								<button class="btn btn-sm btn-light ml-2">
									<i class="fa fa-bars"></i>
								</button>
							</div>
							<div class="ml-2">
								<div class="btn-group">
									<button type="button"
										class="btn btn-sm btn-light dropdown-toggle"
										data-toggle="dropdown">Sắp xếp</button>
									<div class="dropdown-menu dropdown-menu-right">
										<a class="dropdown-item" href="#">Mới nhất</a> <a
											class="dropdown-item" href="#">Phổ biến</a> <a
											class="dropdown-item" href="#">Đánh giá tốt</a>
									</div>
								</div>
								<div class="btn-group ml-2">
									<button type="button"
										class="btn btn-sm btn-light dropdown-toggle"
										data-toggle="dropdown">Hiển thị</button>
									<div class="dropdown-menu dropdown-menu-right">
										<a class="dropdown-item" href="#">10</a> <a
											class="dropdown-item" href="#">20</a> <a
											class="dropdown-item" href="#">30</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-6 pb-1">
						<div class="product-item bg-light mb-4">
							<div class="product-img position-relative overflow-hidden">
								<span class="badge bg-warning">NEW</span> <img
									class="img-fluid w-100" src="resources/user/img/product-1.jpg"
									alt="">
								<div class="product-action d-flex">
									<div class="d-flex flex-row">
										<a class="btn btn-outline-dark btn-square" href=""><i
											class="fa fa-shopping-cart"></i></a> <a
											class="btn btn-outline-dark btn-square" href=""><i
											class="fa fa-sync-alt"></i></a> <a
											class="btn btn-outline-dark btn-square" href=""><i
											class="fa fa-search"></i></a>
									</div>

									<button href="#" class="btn text-uppercase btn-product-buynow">mua
										ngay</button>
								</div>



							</div>
							<div class="text-center py-4">
								<a class="h6 text-decoration-none text-truncate" href="">Product
									Name Goes Here</a>
								<div
									class="d-flex align-items-center justify-content-center mt-2">
									<h5>$123.00</h5>
									<h6 class="text-muted ml-2">
										<del>$123.00</del>
									</h6>
								</div>
								<div
									class="d-flex align-items-center justify-content-center mb-1">
									<small class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small>(99)</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-6 pb-1">
						<div class="product-item bg-light mb-4">
							<div class="product-img position-relative overflow-hidden">
								<span class="badge bg-warning">NEW</span> <img
									class="img-fluid w-100" src="resources/user/img/product-2.jpg"
									alt="">
								<div class="product-action">
									<a class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-shopping-cart"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-sync-alt"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-search"></i></a>

								</div>

							</div>
							<div class="text-center py-4">
								<a class="h6 text-decoration-none text-truncate" href="">Product
									Name Goes Here</a>
								<div
									class="d-flex align-items-center justify-content-center mt-2">
									<h5>$123.00</h5>
									<h6 class="text-muted ml-2">
										<del>$123.00</del>
									</h6>
								</div>
								<div
									class="d-flex align-items-center justify-content-center mb-1">
									<small class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star-half-alt text-primary mr-1"></small> <small>(99)</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-6 pb-1">
						<div class="product-item bg-light mb-4">
							<div class="product-img position-relative overflow-hidden">
								<span class="badge bg-warning">NEW</span> <img
									class="img-fluid w-100" src="resources/user/img/product-3.jpg"
									alt="">
								<div class="product-action">
									<a class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-shopping-cart"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-sync-alt"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-search"></i></a>
								</div>
							</div>
							<div class="text-center py-4">
								<a class="h6 text-decoration-none text-truncate" href="">Product
									Name Goes Here</a>
								<div
									class="d-flex align-items-center justify-content-center mt-2">
									<h5>$123.00</h5>
									<h6 class="text-muted ml-2">
										<del>$123.00</del>
									</h6>
								</div>
								<div
									class="d-flex align-items-center justify-content-center mb-1">
									<small class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star-half-alt text-primary mr-1"></small> <small
										class="far fa-star text-primary mr-1"></small> <small>(99)</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-6 pb-1">
						<div class="product-item bg-light mb-4">
							<div class="product-img position-relative overflow-hidden">
								<span class="badge bg-warning">NEW</span> <img
									class="img-fluid w-100" src="resources/user/img/product-4.jpg"
									alt="">
								<div class="product-action">
									<a class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-shopping-cart"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-sync-alt"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-search"></i></a>
								</div>
							</div>
							<div class="text-center py-4">

								<a class="h6 text-decoration-none text-truncate" href="">Product
									Name Goes Here</a>
								<div
									class="d-flex align-items-center justify-content-center mt-2">
									<h5>$123.00</h5>
									<h6 class="text-muted ml-2">
										<del>$123.00</del>
									</h6>
								</div>
								<div
									class="d-flex align-items-center justify-content-center mb-1">
									<small class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="far fa-star text-primary mr-1"></small> <small
										class="far fa-star text-primary mr-1"></small> <small>(99)</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-6 pb-1">
						<div class="product-item bg-light mb-4">
							<div class="product-img position-relative overflow-hidden">
								<span class="badge bg-warning">NEW</span> <img
									class="img-fluid w-100" src="resources/user/img/product-5.jpg"
									alt="">
								<div class="product-action">
									<a class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-shopping-cart"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-sync-alt"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-search"></i></a>
								</div>
							</div>
							<div class="text-center py-4">
								<a class="h6 text-decoration-none text-truncate" href="">Product
									Name Goes Here</a>
								<div
									class="d-flex align-items-center justify-content-center mt-2">
									<h5>$123.00</h5>
									<h6 class="text-muted ml-2">
										<del>$123.00</del>
									</h6>
								</div>
								<div
									class="d-flex align-items-center justify-content-center mb-1">
									<small class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small>(99)</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-6 pb-1">
						<div class="product-item bg-light mb-4">
							<div class="product-img position-relative overflow-hidden">
								<span class="badge bg-warning">NEW</span> <img
									class="img-fluid w-100" src="resources/user/img/product-6.jpg"
									alt="">
								<div class="product-action">
									<a class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-shopping-cart"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-sync-alt"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-search"></i></a>
								</div>
							</div>
							<div class="text-center py-4">
								<a class="h6 text-decoration-none text-truncate" href="">Product
									Name Goes Here</a>
								<div
									class="d-flex align-items-center justify-content-center mt-2">
									<h5>$123.00</h5>
									<h6 class="text-muted ml-2">
										<del>$123.00</del>
									</h6>
								</div>
								<div
									class="d-flex align-items-center justify-content-center mb-1">
									<small class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star-half-alt text-primary mr-1"></small> <small>(99)</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-6 pb-1">
						<div class="product-item bg-light mb-4">
							<div class="product-img position-relative overflow-hidden">
								<span class="badge bg-warning">NEW</span> <img
									class="img-fluid w-100" src="resources/user/img/product-7.jpg"
									alt="">
								<div class="product-action">
									<a class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-shopping-cart"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-sync-alt"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-search"></i></a>
								</div>
							</div>
							<div class="text-center py-4">
								<a class="h6 text-decoration-none text-truncate" href="">Product
									Name Goes Here</a>
								<div
									class="d-flex align-items-center justify-content-center mt-2">
									<h5>$123.00</h5>
									<h6 class="text-muted ml-2">
										<del>$123.00</del>
									</h6>
								</div>
								<div
									class="d-flex align-items-center justify-content-center mb-1">
									<small class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star-half-alt text-primary mr-1"></small> <small
										class="far fa-star text-primary mr-1"></small> <small>(99)</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-6 pb-1">
						<div class="product-item bg-light mb-4">
							<div class="product-img position-relative overflow-hidden">
								<span class="badge bg-warning">NEW</span> <img
									class="img-fluid w-100" src="resources/user/img/product-8.jpg"
									alt="">
								<div class="product-action">
									<a class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-shopping-cart"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-sync-alt"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-search"></i></a>
								</div>
							</div>
							<div class="text-center py-4">
								<a class="h6 text-decoration-none text-truncate" href="">Product
									Name Goes Here</a>
								<div
									class="d-flex align-items-center justify-content-center mt-2">
									<h5>$123.00</h5>
									<h6 class="text-muted ml-2">
										<del>$123.00</del>
									</h6>
								</div>
								<div
									class="d-flex align-items-center justify-content-center mb-1">
									<small class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="far fa-star text-primary mr-1"></small> <small
										class="far fa-star text-primary mr-1"></small> <small>(99)</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 col-sm-6 pb-1">
						<div class="product-item bg-light mb-4">
							<div class="product-img position-relative overflow-hidden">
								<span class="badge bg-warning">NEW</span> <img
									class="img-fluid w-100" src="resources/user/img/product-9.jpg"
									alt="">
								<div class="product-action">
									<a class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-shopping-cart"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-sync-alt"></i></a> <a
										class="btn btn-outline-dark btn-square" href=""><i
										class="fa fa-search"></i></a>
								</div>
							</div>
							<div class="text-center py-4">
								<a class="h6 text-decoration-none text-truncate" href="">Product
									Name Goes Here</a>
								<div
									class="d-flex align-items-center justify-content-center mt-2">
									<h5>$123.00</h5>
									<h6 class="text-muted ml-2">
										<del>$123.00</del>
									</h6>
								</div>
								<div
									class="d-flex align-items-center justify-content-center mb-1">
									<small class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="fa fa-star text-primary mr-1"></small> <small
										class="far fa-star text-primary mr-1"></small> <small
										class="far fa-star text-primary mr-1"></small> <small>(99)</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col-12">
						<nav>
							<ul class="pagination justify-content-center">
								<li class="page-item disabled"><a class="page-link"
									href="#">Previous</span></a></li>
								<li class="page-item active"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">Next</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
			<!-- Shop Product End -->
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
