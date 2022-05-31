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
						class="breadcrumb-item active">Giỏ hàng</span>
				</nav>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->


	<!-- Cart Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-lg-8 table-responsive mb-5">
				<table
					class="table table-light table-borderless table-hover text-center mb-0">
					<thead class="thead-dark">
						<tr>
							<th>Sản phẩm</th>
							<th>Size</th>
							<th>Giá</th>
							<th>Số lượng</th>
							<th>Tổng tiền</th>
							<th>Thao tác</th>
						</tr>
					</thead>
					<tbody class="align-middle">
						<c:if test="${giohang.size()  == 0}">
							<div class="alert alert-primary" role="alert">Giỏ hàng của
								bạn đang trống</div>
							<div class="my-4">
								<a href="sanpham" class="btn btn-info">Mua sắm</a>
							</div>
						</c:if>
						<c:forEach var="i" items="${giohang }">
							<tr class="row-sp">
								<td class="align-middle"><img
									src="resources/file/${i.chiTietSP.sanPham.hinhAnh }" alt=""
									style="width: 50px;"> 
									<a href="sanpham/${ i.chiTietSP.sanPham.maSP}"><span class="text-truncate">
										${i.chiTietSP.sanPham.tenSP }</span></a>
									</td>
								<td class="align-middle">${i.chiTietSP.sizeSanPham.tenSize }</td>
								<td class="align-middle"><fmt:setLocale value="vi_VN" /> <fmt:formatNumber
										maxFractionDigits="0"
										value="${i.chiTietSP.sanPham.gia - i.chiTietSP.sanPham.gia* (i.chiTietSP.sanPham.giamGia/100)}"
										type="currency" currencySymbol="đ" /></td>
								<td class="align-middle">
									<div class="input-group quantity mx-auto" style="width: 100px;">
										<div class="input-group-btn">
											<button type="button"
												class="btn btn-sm btn-primary btn-minus" type="button"
												id="btn-minus" data-ctsp="${i.chiTietSP.maChiTietSP }">
												<i class="fa fa-minus"></i>
											</button>
										</div>
										<input type="text" name="soluong"
											data-ctsp="${i.chiTietSP.maChiTietSP }"
											class="form-control form-control-sm bg-secondary border-0 text-center"
											value="${i.soLuong }">
										<div class="input-group-btn">
											<button type="button" class="btn btn-sm btn-primary btn-plus"
												id="btn-plus" data-ctsp="${i.chiTietSP.maChiTietSP }">
												<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
								</td>
								<td class="align-middle price" data-ctsp="${ i.chiTietSP.maChiTietSP}"
								data-priceone="${(i.chiTietSP.sanPham.gia - i.chiTietSP.sanPham.gia* (i.chiTietSP.sanPham.giamGia/100)) }"
									data-price="${(i.chiTietSP.sanPham.gia - i.chiTietSP.sanPham.gia* (i.chiTietSP.sanPham.giamGia/100)) * i.soLuong}"><fmt:setLocale
										value="vi_VN" /> <fmt:formatNumber maxFractionDigits="0"
										value="${(i.chiTietSP.sanPham.gia - i.chiTietSP.sanPham.gia* (i.chiTietSP.sanPham.giamGia/100)) * i.soLuong}"
										type="currency" currencySymbol="đ" /></td>
								<td class="align-middle">
									<form action="giohang" method="post">
										<input type="text" name="mactsp"
											value="${i.chiTietSP.maChiTietSP }" hidden />
										<button type="submit" name="xoasp"
											class="btn btn-sm btn-danger">
											<i class="fa fa-times"></i>
										</button>
									</form>

								</td>
							</tr>
						</c:forEach>

						<!-- 
						<tr>
							<td class="align-middle"><img src="img/product-5.jpg" alt=""
								style="width: 50px;"> Product Name</td>
							<td class="align-middle">$150</td>
							<td class="align-middle">
								<div class="input-group quantity mx-auto" style="width: 100px;">
									<div class="input-group-btn">
										<button class="btn btn-sm btn-primary btn-minus">
											<i class="fa fa-minus"></i>
										</button>
									</div>
									<input type="text"
										class="form-control form-control-sm bg-secondary border-0 text-center"
										value="1">
									<div class="input-group-btn">
										<button class="btn btn-sm btn-primary btn-plus">
											<i class="fa fa-plus"></i>
										</button>
									</div>
								</div>
							</td>
							<td class="align-middle">$150</td>
							<td class="align-middle"><button
									class="btn btn-sm btn-danger">
									<i class="fa fa-times"></i>
								</button></td>
						</tr> -->
					</tbody>
				</table>
			</div>
			<c:choose>
				<c:when test="${giohang.size() > 0 }">
					<div class="col-lg-4">
						<!-- <form class="mb-30" action="">
							<div class="input-group">
								<input type="text" class="form-control border-0 p-4"
									placeholder="Mã giảm giá">
								<div class="input-group-append">
									<button class="btn btn-primary">Áp dụng</button>
								</div>
							</div>
						</form> -->
						<h5 class="section-title position-relative text-uppercase mb-3">
							<span class="bg-secondary pr-3">Tổng giỏ hàng</span>
						</h5>
						<div class="bg-light p-30 mb-5">
							<div class="border-bottom pb-2">
								<div class="d-flex justify-content-between mb-3">
									<h6>Tạm tính</h6>
									<h6 id="temp-price">$150</h6>
								</div>
								<div class="d-flex justify-content-between">
									<h6 class="font-weight-medium">Phí giao hàng</h6>
									<h6 class="font-weight-medium" id="ship-price">30.000&nbsp;đ</h6>
								</div>
							</div>
							<div class="pt-2">
								<div class="d-flex justify-content-between mt-2">
									<h5>Tổng tiền</h5>
									<h5 id="total-price">0</h5>
								</div>
								<form action="thanhtoan" method="post">
									<input type="text" name="tongtien" value="" hidden />
									<div class="row d-flex justify-content-between">
										<a href="sanpham"
											class="col-md-5 btn btn-block btn-primary font-weight-bold my-3 py-3">
											Quay lại </a>

										<button type="submit" name="thanhtoangiohang"
											class="col-md-5 btn btn-block btn-primary font-weight-bold my-3 py-3">Thanh
											toán</button>


									</div>
								</form>
							</div>

						</div>
					</div>

				</c:when>
			</c:choose>

		</div>
	</div>
	<!-- Cart End -->
	<p id="alertMessage" data-success=${isSuccess }></p>
</main>
<!-- Back to Top -->
<a href="#" class="btn btn-primary back-to-top"><i
	class="fa fa-angle-double-up"></i></a>

<!-- Footer -->
<%@include file="/WEB-INF/views/shop/include/footer.jsp"%>
<!-- Footer End -->


<!-- JS Lib -->
<%@include file="/WEB-INF/views/shop/include/jsLib.jsp"%>
<!-- JS Lib End -->

<script>
function tinhTongTien(){
	let tongTien = 0;
	$(".row-sp").each(function(){
		
		 tongTien += (parseFloat($(this).find("td.price").data("price")))
		
	})
	
	let formatter = new Intl.NumberFormat('vi-VN', {
		style: 'currency',
  		currency: 'VND',})
  	
  	
	  	$("#temp-price").text(formatter.format(tongTien))
		$("#total-price").text(formatter.format(tongTien + 30000))
		$("input[name=tongtien]").attr("value", tongTien)
  	
	
}

		$(document).ready(function(){
			let isSuccess = $("#alertMessage").data("success")
			if(isSuccess){
				
				toastr.success('Xóa khỏi giỏ hàng thành công!')
			}
			
			tinhTongTien();
			
			
			let data = {}
			$(".btn-plus").each(function () {
				let btnPlus = $(this)
				
					btnPlus.on("click", function() {
						let mactsp = btnPlus.data("ctsp")
						console.log($("input[data-ctsp="+mactsp+"]"))
						 data.soluong = parseInt($("input[data-ctsp="+mactsp+"]").attr("value"))
						 data.mactsp = $("input[data-ctsp="+mactsp+"]").data("ctsp")
						console.log('soluong', data);
						
							$.ajax({
								url: "giohang?capnhatsl",
								type: "post",
								data: data,
								success: function(result){
									console.log('result', result);
									if(result === 'true') {
										let price =  parseFloat($("td.price[data-ctsp="+mactsp+"]").data("priceone"))
										console.log('price', price)
										
										let formatter = new Intl.NumberFormat('vi-VN', {
											style: 'currency',
									  		currency: 'VND',})
										$("td.price[data-ctsp="+mactsp+"]").text(formatter.format(price * data.soluong))
										$("td.price[data-ctsp="+mactsp+"]").data("price", price * data.soluong)
										tinhTongTien();
										
									}
									
								},
								error: function(error){
									console.log(error);
								}
							})
					})
			})
			
			
			
			$(".btn-minus").each(function () {
				let btnMinus = $(this)
				
					btnMinus.on("click", function() {
						let mactsp = btnMinus.data("ctsp")
						console.log($("input[data-ctsp="+mactsp+"]"))
						 data.soluong = parseInt($("input[data-ctsp="+mactsp+"]").attr("value"))
						 data.mactsp = $("input[data-ctsp="+mactsp+"]").data("ctsp")
						console.log('soluong', data);
						
							$.ajax({
								url: "giohang?capnhatsl",
								type: "post",
								data: data,
								success: function(result){
									console.log('result', result);
									if(result === 'true') {
										let price =  parseFloat($("td.price[data-ctsp="+mactsp+"]").data("priceone"))
										console.log('price', price)
										
										let formatter = new Intl.NumberFormat('vi-VN', {
											style: 'currency',
									  		currency: 'VND',})
										$("td.price[data-ctsp="+mactsp+"]").text(formatter.format(price * data.soluong))
										$("td.price[data-ctsp="+mactsp+"]").data("price", price * data.soluong)
										tinhTongTien();
										
									}
									
								},
								error: function(error){
									console.log(error);
								}
							})
					})
			})
			
		})

</script>