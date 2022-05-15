<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Header -->
<%@include file="/WEB-INF/views/quantri/include/header.jsp"%>
<!-- Header end -->

<!-- Sidebar -->
<%@include file="/WEB-INF/views/quantri/include/sidebar-ql.jsp"%>
<!-- Sidebar end -->


<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper " style="height: 100%; overflow: scroll">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-12">
					<ol class="breadcrumb ">
						<li class="breadcrumb-item"><a href="quanly/tongquan">Quản
								lý</a></li>
						<li class="breadcrumb-item active">Nhập hàng</li>
					</ol>
				</div>
				<div class="col-sm-6"></div>

			</div>
		</div>
		<!-- /.container-fluid -->
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">

					<div class="card">
						<div class="card-header ">
							<div class="d-flex justify-content-between">
								<h3 class=" mt-2">Danh sách phiếu nhập hàng</h3>

								<button type="submit" class="btn bg-primary  mt-2"
									data-toggle="modal" data-target="#modal-add-new">
									<i class="fas fa-plus mr-2"></i>Thêm phiếu nhập mới
								</button>
							</div>
							<div>
								<c:choose>
									<c:when test="${isSuccess }">
										<div
											class="mt-2 alert alert-success alert-dismissible fade show"
											role="alert">
											${alertMessage }
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
									</c:when>
									<c:when test="${isSuccess == false }">
										<div
											class="mt-2 alert alert-danger alert-dismissible fade show"
											role="alert">
											${alertMessage }
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
									</c:when>
								</c:choose>

							</div>

						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<table id="bangnhaphang"
								class="table table-bordered table-striped text-center">
								<thead class="bg-primary">
									<tr>
										<th>Mã phiếu nhập</th>
										<th>Tên NCC</th>
										<th>Ngày nhập</th>
										<th>Mã nhân viên</th>
										<th>Tổng tiền</th>
										<th>Thao tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="pn" items="${danhSachPhieuNhap }">
										<tr>
											<td>${pn.getMaPN() }</td>
											<td>${pn.getNhaCungCap().getTenNCC() }</td>
											<td>${pn.getThoiGian() }</td>
											<td>${pn.getNhanVien().getMaNV() }</td>
											<td><fmt:setLocale value="vi_VN" /> <fmt:formatNumber
													value="${pn.getTongTien()}" type="currency"
													currencySymbol="vnđ" /></td>

											<td>
												<div class="d-flex justify-content-between px-4">
													<a class=""
														href="quanly/phieunhap/${pn.getMaPN() }?thongtin"><i
														class="fas fa-info-circle"></i> </a> <a class=""
														href="quanly/phieunhap/${pn.getMaPN() }?suaphieunhap"><i
														class="fas fa-edit"></i> </a> <a class="" href="#"
														data-toggle="modal" data-target="#modal-add-newctpn">
														<i class="fas fa-folder-plus"></i>
													</a> <a class="" href="#" data-toggle="modal"
														data-target="#exampleModal"> <i
														class="fas fa-pen-square"></i>
													</a>
											</td>

										</tr>

									</c:forEach>



								</tbody>
								<!-- <tfoot class="bg-primary">
                      <tr>
                        <th>Rendering engine</th>
                        <th>Browser</th>
                        <th>Platform(s)</th>
                        <th>Engine version</th>
                        <th>CSS grade</th>
                      </tr>
                    </tfoot> -->
							</table>
						</div>
						<!-- /.card-body -->
					</div>
					<!-- /.card -->
				</div>
			</div>
			<!-- /.row -->

		</div>

	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<div class="modal fade" id="modal-info-detail"
	isShow="${isOpenModalInfo }">
	<div class="modal-dialog modal-dialog-scrollable modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title">Thông tin phiếu nhập</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div class="jumbotron" style="overflow: scroll">
				<div>
					<p class="float-right">Mã nhân viên:
						${thongTinPN.getNhanVien().getMaNV() }</p>
					<p>Nhân viên nhập: ${thongTinPN.getNhanVien().getHo() }
						${thongTinPN.getNhanVien().getTen() }</p>
					<p>Ngày nhập: ${thongTinPN.getThoiGian() }</p>

				</div>
				<hr>
				<h3>
					<strong>Nhà cung cấp:
						${thongTinPN.getNhaCungCap().getTenNCC() }</strong>
				</h3>
				<p class="float-right">Địa chỉ:
					${thongTinPN.getNhaCungCap().getDiaChi() }</p>
				<p>Mã nhà cung cấp: ${thongTinPN.getNhaCungCap().getMaNCC() }</p>

				<h4>${thongTinPN.getChiTietPN().size() }&nbsp;sảnphẩm</h4>
				<table class="table  table-striped text-center"
					id="chitietphieunhap">
					<thead>
						<tr>

							<th class="bg-primary">Sản phẩm</th>
							<th class="bg-primary">Số lượng</th>
							<th class="bg-primary">Size</th>
							<th class="bg-primary">Màu</th>
							<th class="bg-primary">Giá</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ctpn" items="${thongTinPN.getChiTietPN() }">
							<tr>

								<td class="d-flex justify-content-center"><img
									src="https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/7348553c641f4da7b881adf80119295a_9366/Giay_NMD_V3_DJen_GX3373_01_standard.jpg"
									width="40px" height="40px"> <span class="p-2">${ctpn.getChiTietSP().getSanPham().getTenSP() }</span>
								</td>
								<td>${ctpn.getChiTietSP().getSoLuong()}</td>
								<td>${ctpn.getChiTietSP().getSizeSanPham().getTenSize()}</td>
								<td>${ctpn.getChiTietSP().getMauSanPham().getTenMau()}</td>
								<td><fmt:setLocale value="vi_VN" /> <fmt:formatNumber
										value="${ctpn.getChiTietSP().getSanPham().getGia() * ctpn.getChiTietSP().getSoLuong()}"
										type="currency" currencySymbol="vnđ" /></td>

							</tr>
						</c:forEach>


					</tbody>
				</table>
				<div class="d-flex justify-content-end">
					<h5 class="">
						<strong>TỔNG: <fmt:setLocale value="vi_VN" /> <fmt:formatNumber
								value="${thongTinPN.getTongTien()}" type="currency"
								currencySymbol="vnđ" /></strong>
					</h5>

				</div>

			</div>

		</div>

	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<div class="modal fade" id="modal-add-new"
	isShow="${isOpenModalAddNew }">
	<div class="modal-lg modal-dialog modal-dialog-scrollable"
		role="document">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h5 class="modal-title" id="exampleModalScrollableTitle">Thêm
					phiếu nhập mới</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true" style="color: white;">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form:form class="form-horizontal" method="post"
					action="quanly/phieunhap?themPN" modelAttribute="phieuNhapMoi">
					<div class="form-group">
						<label for="">Nhà cung cấp</label>
						<form:select path="nhaCungCap.maNCC"
							items="${danhSachNhaCungCap }" class="form-control form-select"
							itemValue="maNCC" itemLabel="tenNCC"></form:select>
						<form:errors path="nhaCungCap.maNCC" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<form:hidden path="nhanVien.maNV" class="form-control"
							value="${sessionScope['user'].getNhanVien().getMaNV() }" />
					</div>
					<div class="form-group">
						<label for="">Ngày nhập</label>
						<form:input path="thoiGian" type="date" class="form-control" />
						<form:errors path="thoiGian" cssClass="text-danger" />
					</div>
					<div class="form-group d-flex justify-content-end">

						<button type="submit" name="themPN" class="btn btn-primary">Lưu</button>
						<a href="quanly/phieunhap" id="cancel-save-modal-phieunhap"
							class="mx-2 btn btn-secondary">Hủy</a>
					</div>

				</form:form>
			</div>

		</div>
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- Modal sửa và xóa chi tiết sản phẩm -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-lg modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header bg-secondary">
				<h5 class="modal-title" id="exampleModalLabel">Sửa chi tiết
					phiếu nhập</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<table class="table table-hover table-striped text-center">
					<thead>
						<tr>
							<th class="bg-primary">STT</th>
							<th class="bg-primary">Sản phẩm</th>
							<th class="bg-primary">Số lượng</th>
							<th class="bg-primary">Size</th>
							<th class="bg-primary">Màu</th>
							<th class="bg-primary">Giá</th>
							<th class="bg-primary">Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td class="d-flex justify-content-center"><img
								src="https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/7348553c641f4da7b881adf80119295a_9366/Giay_NMD_V3_DJen_GX3373_01_standard.jpg"
								width="40px" height="40px"> <span class="p-2">GIÀY
									SUPERSTAR PARLEY</span></td>
							<td>1</td>
							<td>40</td>
							<td>Black</td>
							<td>3 300 000 ₫</td>
							<td>
								<button type="button" class="btn btn-primary"
									data-toggle="modal" data-target="#modal-edit1">
									<i class="far fa-edit"></i>
								</button>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td class="d-flex justify-content-center"><img
								src="https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/7348553c641f4da7b881adf80119295a_9366/Giay_NMD_V3_DJen_GX3373_01_standard.jpg"
								width="40px" height="40px"> <span class="p-2">GIÀY
									NMD_V3</span></td>
							<td>1</td>
							<td>38.5</td>
							<td>Black</td>
							<td>4 000 000 ₫</td>
							<td>
								<button type="button" class="btn btn-primary"
									data-toggle="modal" data-target="#modal-edit1">
									<i class="far fa-edit"></i>
								</button>
							</td>
						</tr>
						<tr>
							<td>3</td>
							<td class="d-flex justify-content-center"><img
								src="https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/7348553c641f4da7b881adf80119295a_9366/Giay_NMD_V3_DJen_GX3373_01_standard.jpg"
								width="40px" height="40px"> <span class="p-2">GIÀY
									NMD_V3</span></td>
							<td>1</td>
							<td>40</td>
							<td>Yellow</td>
							<td>4 000 000 ₫</td>
							<td>
								<button type="button" class="btn btn-primary"
									data-toggle="modal" data-target="#modal-edit1">
									<i class="far fa-edit"></i>
								</button>

							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="modal-footer d-flex justify-content-between">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Lưu thay đổi</button>
			</div>
		</div>
	</div>
</div>
<!-- Modal sửa và xóa chi tiết sản phẩm -->

<!-- Modal edit1 -->

<div class="modal fade" id="modal-edit1" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-lg modal-dialog modal-dialog-scrollable"
		role="document">
		<div class="modal-content">
			<div class="modal-header bg-secondary">
				<h5 class="modal-title" id="exampleModalScrollableTitle">Sửa
					chi tiết</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true" style="color: white;">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label for="inputEmail4">Mã sản phẩm</label> <input type="email"
							class="form-control" id="inputEmail4" placeholder="M38789792">
					</div>
					<div class="form-group">
						<label for="inputEmail4">Thêm hình ảnh </label>
						<button type="submit" class="btn bg-dark">
							<i class="fas fa-upload"></i>
						</button>
					</div>
					<div class="form-group">
						<label for="inputPassword4">Tên sản phẩm</label> <input
							type="password" class="form-control" id="inputPassword4"
							placeholder="ABCDEF">
					</div>
					<div class="form-group">
						<label for="inputPassword4">Màu sản phẩm</label> <input
							type="password" class="form-control" id="inputPassword4"
							placeholder="ABCDEF">
					</div>
					<div class="form-group">
						<label for="inputPassword4">Kích thước sản phẩm</label> <input
							type="password" class="form-control" id="inputPassword4"
							placeholder="ABCDEF">
					</div>
					<div class="form-group">
						<label for="inputAddress">Mã nhà cung cấp</label> <input
							type="text" class="form-control" id="inputAddress"
							placeholder="NCC1">
					</div>
					<div class="form-group">
						<label for="inputAddress">Số lượng</label> <input type="text"
							class="form-control" id="inputAddress" placeholder="300">
					</div>
					<div class="form-group">
						<label for="inputAddress2">Giá</label> <input type="text"
							class="form-control" id="inputAddress2" placeholder="3 000 000 đ">
					</div>

				</form>
			</div>
			<div class="modal-footer d-flex justify-content-between">
				<button type="button" class="btn btn-danger" data-toggle="modal"
					data-target="#modal-delete">Xóa chi tiết</button>

				<!-- Modal -->
				<div class="modal fade" id="modal-delete" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header bg-danger">
								<h5 class="modal-title" id="exampleModalLabel">
									<i class="fas fa-times"></i> Bạn muốn xóa chi tiết này?
								</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<!-- <div class="modal-body">
                      
                    </div> -->
							<div class="modal-footer d-flex justify-content-between">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-danger">Xóa</button>
							</div>
						</div>
					</div>
				</div>
				<button type="button" class="btn btn-primary">Lưu thay đổi</button>
			</div>
		</div>
	</div>
</div>
<!-- Modal edit1 -->


<div class="modal fade" id="modal-edit" isShow="${isOpenModalEdit }">
	<div class="modal-lg modal-dialog modal-dialog-scrollable"
		role="document">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h5 class="modal-title" id="exampleModalScrollableTitle">Sửa
					thông tin phiếu nhập</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true" style="color: white;">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form:form class="form-horizontal" method="post"
					action="quanly/phieunhap/${thongTinPN.getMaPN()}?suaPN"
					modelAttribute="thongTinPN">
					<div class="form-group">
						<label for="">Nhà cung cấp</label>
						<form:select path="nhaCungCap.maNCC"
							items="${danhSachNhaCungCap }" class="form-control form-select"
							itemValue="maNCC" itemLabel="tenNCC"></form:select>
						<form:errors path="nhaCungCap.maNCC" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<form:hidden path="nhanVien.maNV" class="form-control"
							value="${sessionScope['user'].getNhanVien().getMaNV() }" />
					</div>
					<div class="form-group">
						<label for="">Ngày nhập</label>
						<form:input path="thoiGian" type="date" class="form-control" />
						<form:errors path="thoiGian" cssClass="text-danger" />
					</div>
					<div class="form-group d-flex justify-content-end">

						<button type="submit" name="suaPN" class="btn btn-primary">Lưu</button>
						<a href="quanly/phieunhap" id="cancel-update-modal-phieunhap"
							class="mx-2 btn btn-secondary">Hủy</a>
					</div>

				</form:form>
			</div>

		</div>
	</div>
	<!-- /.modal-dialog -->
</div>

<!-- Modal mở -->
<div class="modal fade " id="modal-add-newctpn" aria-hidden="true">
	<div class="modal-lg modal-dialog modal-dialog-scrollable"
		role="document">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h5 class="modal-title" id="exampleModalScrollableTitle">Thêm
					chi tiết phiếu nhập</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true" style="color: white;">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form:form
					action="quanly/phieunhap/${thongTinPN.getMaPN()}?themctpn"
					method="post" modelAttribute="CTSP" enctype="multipart/form-data">
					<div class="form-group">
						<label for="">Sản phẩm</label>
						<form:select path="sanPham.maSP" items="${danhSachSanPham }"
							class="form-control form-select" itemValue="maSP"
							itemLabel="tenSP"></form:select>
						<form:errors path="sanPham.maSP" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="">Thêm hình ảnh </label> <img class="img-thumbnail" style="width: 200px; height: 200px;"
							src="https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png" /> 
						<button type="submit" class="btn bg-dark">
							<i class="fas fa-upload"></i>
						</button>
					</div>
					<div class="form-group">
						<label for="inputPassword4">Tên sản phẩm</label> <input
							type="password" class="form-control" id="inputPassword4"
							placeholder="ABCDEF">
					</div>
					<div class="form-group">
						<label for="">Màu sản phẩm</label>
						<form:select path="mauSanPham.maMau" items="${danhSachMau }"
							class="form-control form-select" itemValue="maMau"
							itemLabel="tenMau"></form:select>
					</div>
					<div class="form-group">
						<label for="">Size sản phẩm</label>
						<form:select path="sizeSanPham.maSize" items="${danhSachSize }"
							class="form-control form-select" itemValue="maSize"
							itemLabel="tenSize"></form:select>
					</div>
					<div class="form-group">
						<label for="">Nhà cung cấp</label>
						
					</div>
					<div class="form-group">
						<label for="inputAddress">Số lượng</label> <input type="text"
							class="form-control" id="inputAddress" placeholder="300">
					</div>


				</form:form>
			</div>
			<!-- <div class="modal-footer d-flex justify-content-between">
				<button type="button" class="btn"
					style="background-color: none; border-color: rgb(0, 109, 199);"
					data-dismiss="modal">Đóng</button>
				<button type="button" class="btn btn-primary">Lưu</button>
			</div> -->
		</div>
	</div>
	<!-- /.modal  confirm mở-->
</div>
<!--Modal tắt hđ-->
<div class="modal fade " id="exampleModalDisable" tabindex="-1"
	aria-labelledby="" aria-hidden="true">
	<div class="modal-dialog ">
		<div class="modal-content">
			<div class="modal-header bg-secondary">
				<h5 class="modal-title" id="exampleModalLabel">
					<i class="fas fa-lock"></i>&nbsp; Bạn muốn tắt hoạt động tài khoản
					này?
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<!-- <div class="modal-body">
            <p class="text-center">Bạn muốn tắt hoạt động tài khoản này?</p>
          </div> -->
			<div class="modal-footer d-flex justify-content-end">
				<button type="button" class="btn btn-primary" data-dismiss="modal">Tiếp
					tục</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!--Modal tắt hđ-->

<!-- Footer -->
<%@include file="/WEB-INF/views/quantri/include/footer.jsp"%>
<!-- Footer end -->