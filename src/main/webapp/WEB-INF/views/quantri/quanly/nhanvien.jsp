<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Header -->
   <%@include file="/WEB-INF/views/quantri/include/header.jsp" %>
<!-- Header end -->

<!-- Sidebar -->
   <%@include file="/WEB-INF/views/quantri/include/sidebar-ql.jsp" %>
<!-- Sidebar end -->

        <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            <div class="col-sm-12">
              <ol class="breadcrumb ">
                <li class="breadcrumb-item"><a href="#">Quản lý</a></li>
                <li class="breadcrumb-item active">Nhân viên</li>
              </ol>
            </div>
            <div class="col-sm-6">

            </div>

          </div>
        </div><!-- /.container-fluid -->
      </section>

      <!-- Main content -->
      <section class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-12">

              <div class="card">
                <div class="card-header d-flex flex-column">
                  <div>
                    <h3 class="card-title">Danh sách nhân viên</h3>
                  </div>
                  <div>
                    <button type="submit" class="btn bg-primary  mt-2" data-toggle="modal"
                      data-target="#modal-add-new"><i class="fas fa-plus mr-2"></i>Thêm mới</button>
                  </div>


                </div>
                <!-- /.card-header -->
                <div class="card-body">
                  <table id="example3" class="table table-bordered table-striped">
                    <thead class="bg-primary">
                      <tr>
                        <th>Ma NV</th>
                        <th>Anh dai dien</th>
                        <th>Ten nhan vien</th>
                        <th>SDT</th>
                        <th>Phai</th>
                        <th>Trang thai</th>
                        <th>Thao tac</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>Trident
                          <!-- TridentTridentTridentTridentTridentTridentTridentTridentTridentTridentTridentTridentTridentTridentTridentTridentTridentTridentTridentTridentTrident -->
                        </td>
                        <td class="text-center"> <a href="dist/img/avatar.png" data-toggle="lightbox"
                            data-title="Đẹp trai vô cùng"><img src="dist/img/avatar.png" alt="Product Image"
                              class="img-size-50" /></a>
                        </td>
                        <td>Internet
                          Explorer 4.0
                        </td>
                        <td>Internet
                          Explorer 4.0
                        </td>
                        <td>Win 95+</td>
                        <td><span class="badge badge-info">Processing</span></td>
                        <td>
                          <div class="d-flex justify-content-between px-4">
                            <a class="" href="#" data-toggle="modal" data-target="#modal-info-detail"><i
                                class="fas fa-info-circle"></i> </a>
                            <a class="" href="#" data-toggle="modal" data-target="#modal-edit"><i
                                class="fas fa-edit"></i>
                            </a>
                            <a class="" href="#" data-toggle="modal" data-target="#exampleModalConfirm"><i
                                class="fas fa-lock-open"></i> </a>
                            <!-- <a class="" href="#" data-toggle="modal" data-target="#exampleModalDisable"><i class="fas fa-lock"></i> </a> -->
                          </div>

                        </td>
                      </tr>

                      <tr>
                        <td>Misc</td>
                        <td class="text-center"><a href="https://unsplash.it/1200/768.jpg?image=50"
                            data-toggle="lightbox" data-title="A random title" data-footer="A custom footer text">
                            <img src="https://unsplash.it/600.jpg?image=50" class="img-fluid img-size-50">
                          </a></td>
                        <td>Internet
                          Explorer 4.0
                        </td>
                        <td>Internet
                          Explorer 4.0
                        </td>
                        <td>Text only</td>
                        <td><span class="badge badge-success">Active</span></td>
                        <td>
                          <div class="d-flex justify-content-between px-4">
                            <a class="" href="#" data-toggle="modal" data-target="#modal-info-detail"><i
                                class="fas fa-info-circle"></i> </a>
                            <a class="" href="#" data-toggle="modal" data-target="#modal-edit"><i
                                class="fas fa-edit"></i>
                            </a>
                            <a class="" href="#" data-toggle="modal" data-target="#exampleModalConfirm"><i
                                class="fas fa-lock-open"></i> </a>
                            <!-- <a class="" href="#" data-toggle="modal" data-target="#exampleModalDisable"><i class="fas fa-lock"></i> </a> -->
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>Misc</td>
                        <td class="text-center"><a href="https://unsplash.it/1200/768.jpg?image=50"
                            data-toggle="lightbox" data-title="A random title" data-footer="A custom footer text">
                            <img src="https://unsplash.it/600.jpg?image=50" class="img-fluid img-size-50">
                          </a></td>
                        <td>Internet
                          Explorer 4.0
                        </td>
                        <td>Internet
                          Explorer 4.0
                        </td>
                        <td>Windows Mobile 6</td>
                        <td><span class="badge badge-danger">Processing</span></td>
                        <td>
                          <div class="d-flex justify-content-between px-4">

                            <a class="" href="#" data-toggle="modal" data-target="#modal-info-detail"><i
                                class="fas fa-info-circle"></i> </a>
                            <a class="" href="#" data-toggle="modal" data-target="#modal-edit"><i
                                class="fas fa-edit"></i>
                            </a>
                            <a class="" href="#" data-toggle="modal" data-target="#exampleModalConfirm"><i
                                class="fas fa-lock-open"></i> </a>
                            <!-- <a class="" href="#" data-toggle="modal" data-target="#exampleModalDisable"><i class="fas fa-lock"></i> </a> -->
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>Misc</td>
                        <td class="text-center"><a href="https://unsplash.it/1200/768.jpg?image=50"
                            data-toggle="lightbox" data-title="A random title" data-footer="A custom footer text">
                            <img src="https://unsplash.it/600.jpg?image=50" class="img-fluid img-size-50">
                          </a></td>
                        <td>Internet
                          Explorer 4.0
                        </td>
                        <td>Internet
                          Explorer 4.0
                        </td>
                        <td>PSP</td>
                        <td><span class="badge badge-info">Processing</span></td>

                        <td>
                          <div class="d-flex justify-content-between px-4">
                            <a class="" href="#" data-toggle="modal" data-target="#modal-info-detail"><i
                                class="fas fa-info-circle"></i> </a>
                            <a class="" href="#" data-toggle="modal" data-target="#modal-edit"><i
                                class="fas fa-edit"></i>
                            </a>
                            <!-- <a class="" href="#" data-toggle="modal" data-target="#exampleModalConfirm"><i
                              class="fas fa-lock-open"></i> </a> -->
                            <a class="" href="#" data-toggle="modal" data-target="#exampleModalDisable"><i
                                class="fas fa-lock"></i> </a>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>Other browsers</td>
                        <td class="text-center"><a href="https://unsplash.it/1200/768.jpg?image=50"
                            data-toggle="lightbox" data-title="A random title" data-footer="A custom footer text">
                            <img src="https://unsplash.it/600.jpg?image=50" class="img-fluid img-size-50">
                          </a></td>
                        <td>-</td>
                        <td>Internet
                          Explorer 4.0
                        </td>
                        <td>Internet
                          Explorer 4.0
                        </td>
                        <td><span class="badge badge-info">Processing</span></td>

                        <td>
                          <div class="d-flex justify-content-between px-4">
                            <a class="" href="#" data-toggle="modal" data-target="#modal-info-detail"><i
                                class="fas fa-info-circle"></i> </a>
                            <a class="" href="#" data-toggle="modal" data-target="#modal-edit"><i
                                class="fas fa-edit"></i>
                            </a>
                            <a class="" href="#" data-toggle="modal" data-target="#exampleModalConfirm"><i
                                class="fas fa-lock-open"></i> </a>
                            <!-- <a class="" href="#" data-toggle="modal" data-target="#exampleModalDisable"><i class="fas fa-lock"></i> </a> -->
                          </div>
                        </td>
                      </tr>

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

<!-- Footer -->
   <%@include file="/WEB-INF/views/quantri/include/footer.jsp" %>
<!-- Footer end -->

 
