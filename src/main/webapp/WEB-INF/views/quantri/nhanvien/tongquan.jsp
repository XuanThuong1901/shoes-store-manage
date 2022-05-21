<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Header -->
   <%@include file="/WEB-INF/views/quantri/include/header.jsp" %>
<!-- Header end -->

<!-- Sidebar -->
   <%@include file="/WEB-INF/views/quantri/include/sidebar-nv.jsp" %>
<!-- Sidebar end -->

        <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            
            <div class="col-sm-12">
              <ol class="breadcrumb mt-1">
                <li class="breadcrumb-item"><a href="nhanvien/tongquan">Nhân viên</a></li>
                <li class="breadcrumb-item active">Tổng quan</li>
              </ol>
            </div>
          </div>
        </div><!-- /.container-fluid -->
      </section>

      <!-- Main content -->
      <section class="content">

        <div class="row">
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box border border-info">
              <div class="inner">
                <h3>${danhSachKhachHang.size() }</h3>

                <p>Khách hàng</p>
              </div>
              <div class="icon">
                <i class=" fas fa-users text-info"></i>
              </div>
              <a href="nhanvien/khachhang" class="small-box-footer bg-info">Chi tiết <i
                  class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box border border-info">
              <div class="inner">
                <h3>${danhSachDanhMucSanPham.size() }</h3>

                <p>Danh mục sản phẩm</p>
              </div>
              <div class="icon">
               <i class="nav-icon "></i>
                <i class="fab fa-elementor text-info"></i>
              </div>
              <a href="nhanvien/danhmucsp" class="small-box-footer bg-info">Chi tiết <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box border border-info">
              <div class="inner">
                <h3>${danhSachSanPham.size() }</h3>

                <p>San pham</p>
              </div>
              <div class="icon">
                <i class="ion ion-pie-graph text-info"></i>
              </div>
              <a href="nhanvien/sanpham" class="small-box-footer bg-info">Chi tiết <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box border border-info">
              <div class="inner">
                <h3>${danhSachDonHang.size()}</h3>

                <p>Đơn hàng</p>
              </div>
              <div class="icon">
                <i class="ion ion-bag text-info"></i>
              </div>
              <a href="nhanvien/donhang" class="small-box-footer bg-info">Chi tiết <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box border border-info">
              <div class="inner">
                <h3>${danhSachPhieuNhap.size() }</h3>

                <p>Đơn hàng nhập</p>
              </div>
              <div class="icon">
                <i class="nav-icon fas fa-clipboard-list text-info"></i>
              </div>
              <a href="nhanvien/phieunhap" class="small-box-footer bg-info">Chi tiết <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box border border-info">
              <div class="inner">
                <h3>${danhSachNhaCungCap.size() }</h3>

                <p>Nhà cung cấp</p>
              </div>
              <div class="icon">
                <i class="fas fa-dolly-flatbed text-info"></i>
              </div>
              <a href="nhanvien/nhacungcap" class="small-box-footer bg-info">Chi tiết <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box border border-info">
              <div class="inner">
                <h3>65</h3>

                <p>Thong ke</p>
              </div>
              <div class="icon">
                <i class="ion ion-pie-graph text-info"></i>
              </div>
              <a href="#" class="small-box-footer bg-info">Chi tiết <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
        </div>
        <!-- /.row -->

      </section>
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

<!-- Footer -->
   <%@include file="/WEB-INF/views/quantri/include/footer.jsp" %>
<!-- Footer end -->

 
