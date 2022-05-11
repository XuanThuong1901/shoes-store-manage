<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="modal fade" id="modal-info-detail">
      <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">Thong tin nhân viên</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="row">
              <!-- /.col -->
              <div class="col-md-12">
                <form class="form-horizontal">
                  <div class="row">
                    <div class="col-md-4">
                      <!-- Profile Image -->
                      <div class="card card-primary card-outline">
                        <div class="card-body box-profile">
                          <div class="text-center">
                            <img class="profile-user-img img-fluid img-circle" src="resources/employee/dist/img/user4-128x128.jpg"
                              alt="User profile picture" style="width: 120px;">
                          </div>

                          <h3 class="profile-username text-center text-primary">Nina Mcintire</h3>

                          <p class="text-muted text-center">Nhân viênnnn</p>

                        </div>
                        <!-- /.card-body -->
                      </div>
                      <!-- /.card -->
                    </div>

                    <div class="col-md-8">
                      <div class="card">
                        <div class="card-body text-primary">

                          <div class="form-group row">
                            <label for="inputName" class="col-sm-2 col-form-label">Mã NV</label>
                            <div class="col-sm-10">
                              <input type="email" class="form-control" id="inputName" placeholder="NV1">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputEmail" class="col-sm-2 col-form-label">Tên NV</label>
                            <div class="col-sm-10">
                              <input type="email" class="form-control" id="inputEmail" placeholder="Võ Thị Thanh Ngân">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputName2" class="col-sm-2 col-form-label">Giới tính</label>
                            <div class="col-sm-10">
                              <input type="text" class="form-control" id="inputName2" placeholder="Nữ">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputExperience" class="col-sm-2 col-form-label ">Ngày sinh</label>
                            <div class="col-sm-10">
                              <input class="form-control" id="inputExperience" placeholder="13/11/2001"></input>
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputSkills" class="col-sm-2 col-form-label text-primary">CCCD</label>
                            <div class="col-sm-10">
                              <input type="text" class="form-control" id="inputSkills" placeholder="01234567890">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputSkills" class="col-sm-2 col-form-label ">SĐT</label>
                            <div class="col-sm-10">
                              <input type="text" class="form-control" id="inputSkills" placeholder="0123456789">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputSkills" class="col-sm-2 col-form-label">Dia chi</label>
                            <div class="col-sm-10">
                              <input type="text" class="form-control" id="inputSkills"
                                placeholder="97 Man Thien, Q9 TP. HCM">
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>

                </form>
              </div>
              <!-- /.col -->
            </div>
          </div>
          <!-- <div class="modal-footer justify-content-between">
            <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
            <button type="button" class="btn bg-dark">Lưu</button>
          </div> -->
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->

    <div class="modal fade" id="modal-add-new">
      <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">Thêm nhân viên</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="row">
              <!-- /.col -->
              <div class="col-md-12">
                <form class="form-horizontal">
                  <div class="row">
                    <div class="col-md-4">
                      <!-- Profile Image -->
                      <div class="card card-primary card-outline">
                        <div class="card-body box-profile">
                          <div class="text-center">
                            <img class="profile-user-img img-fluid img-circle" src="resources/employee/dist/img/user4-128x128.jpg"
                              alt="User profile picture" style="width: 120px;">
                          </div>

                          <h3 class="profile-username text-center">Nina Mcintire</h3>

                          <p class="text-muted text-center">Nhân viênnnn</p>

                        </div>
                        <!-- /.card-body -->
                      </div>
                      <!-- /.card -->
                    </div>

                    <div class="col-md-8">

                      <div class="form-group row">
                        <label for="inputName" class="col-sm-2 col-form-label">Mã NV</label>
                        <div class="col-sm-10">
                          <input type="email" class="form-control" id="inputName" placeholder="NV1">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="inputEmail" class="col-sm-2 col-form-label">Tên NV</label>
                        <div class="col-sm-10">
                          <input type="email" class="form-control" id="inputEmail" placeholder="Võ Thị Thanh Ngân">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="inputName2" class="col-sm-2 col-form-label">Giới tính</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="inputName2" placeholder="Nữ">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="inputExperience" class="col-sm-2 col-form-label">Ngày sinh</label>
                        <div class="col-sm-10">
                          <input class="form-control" id="inputExperience" placeholder="13/11/2001"></input>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="inputSkills" class="col-sm-2 col-form-label">CCCD</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="inputSkills" placeholder="01234567890">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="inputSkills" class="col-sm-2 col-form-label">SĐT</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="inputSkills" placeholder="0123456789">
                        </div>
                      </div>

                    </div>
                  </div>

                </form>
              </div>
              <!-- /.col -->
            </div>
          </div>
          <div class="modal-footer justify-content-between">
            <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
            <button type="button" class="btn bg-dark">Lưu</button>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->



    <div class="modal fade" id="modal-edit">
      <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">Sửa nhân viên</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="row">
              <!-- /.col -->
              <div class="col-md-12">
                <div class="card">
                  <div class="card-header p-2">
                    <ul class="nav nav-pills">
                      <li class="nav-item"><a class="nav-link active" href="#activity" data-toggle="tab">Thông tin</a>
                      </li>
                      <li class="nav-item"><a class="nav-link" href="#settings" data-toggle="tab">Cài đặt</a></li>
                    </ul>
                  </div><!-- /.card-header -->
                  <div class="card-body">
                    <div class="tab-content">
                      <div class="active tab-pane" id="activity">
                        <!-- Info profile -->

                        <form class="form-horizontal">
                          <div class="row">
                            <div class="col-md-3">
                              <!-- Profile Image -->
                              <div class="card card-primary card-outline">
                                <div class="card-body box-profile">
                                  <div class="text-center">
                                    <img class="profile-user-img img-fluid img-circle"
                                      src="resources/employee/dist/img/user4-128x128.jpg" alt="User profile picture">
                                  </div>

                                  <h3 class="profile-username text-center">Nina Mcintire</h3>

                                  <p class="text-muted text-center">Nhân viên</p>



                                  <a href="#" class="btn bg-dark btn-block"><i class="fas fa-upload"></i></a>
                                </div>
                                <!-- /.card-body -->
                              </div>
                              <!-- /.card -->
                            </div>

                            <div class="col-md-9">

                              <div class="form-group row">
                                <label for="inputName" class="col-sm-2 col-form-label">Mã NV</label>
                                <div class="col-sm-10">
                                  <input type="email" class="form-control" id="inputName" placeholder="NV1">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="inputEmail" class="col-sm-2 col-form-label">Tên NV</label>
                                <div class="col-sm-10">
                                  <input type="email" class="form-control" id="inputEmail"
                                    placeholder="Võ Thị Thanh Ngân">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="inputName2" class="col-sm-2 col-form-label">Giới tính</label>
                                <div class="col-sm-10">
                                  <input type="text" class="form-control" id="inputName2" placeholder="Nữ">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="inputExperience" class="col-sm-2 col-form-label">Ngày sinh</label>
                                <div class="col-sm-10">
                                  <input class="form-control" id="inputExperience" placeholder="13/11/2001"></input>
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="inputSkills" class="col-sm-2 col-form-label">CCCD</label>
                                <div class="col-sm-10">
                                  <input type="text" class="form-control" id="inputSkills" placeholder="01234567890">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="inputSkills" class="col-sm-2 col-form-label">SĐT</label>
                                <div class="col-sm-10">
                                  <input type="text" class="form-control" id="inputSkills" placeholder="0123456789">
                                </div>
                              </div>

                            </div>
                          </div>

                        </form>
                        <!-- /.Info profile -->
                      </div>
                      <!-- /.tab-pane -->


                      <div class="tab-pane" id="settings">
                        <form class="form-horizontal">
                          <div class="form-group row">
                            <label for="inputName" class="col-sm-2 col-form-label">Mật khẩu</label>
                            <div class="col-sm-10">
                              <input type="password" class="form-control" id="inputName" placeholder="Mật khẩu">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputEmail" class="col-sm-2 col-form-label">Mật khẩu mới</label>
                            <div class="col-sm-10">
                              <input type="password" class="form-control" id="inputEmail"
                                placeholder="Nhập mật khẩu mới">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputName2" class="col-sm-2 col-form-label">Nhập lại</label>
                            <div class="col-sm-10">
                              <input type="password" class="form-control" id="inputName2"
                                placeholder="Nhập lại mật khẩu mới">
                            </div>
                          </div>

                          <div class="form-group row">
                            <div class="offset-sm-2 col-sm-10">
                              <button type="submit" class="btn bg-dark">Xác nhận</button>
                            </div>
                          </div>
                        </form>
                      </div>
                      <!-- /.tab-pane -->
                    </div>
                    <!-- /.tab-content -->
                  </div><!-- /.card-body -->
                </div>
                <!-- /.card -->
              </div>
              <!-- /.col -->
            </div>
          </div>
          <div class="modal-footer justify-content-between">
            <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
            <button type="button" class="btn bg-dark">Lưu thay đổi</button>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>

    <!-- Modal mở -->
    <div class="modal fade " id="exampleModalConfirm" tabindex="-1" aria-labelledby="exampleModalConfirm"
      aria-hidden="true">
      <div class="modal-dialog ">
        <div class="modal-content">
          <div class="modal-header bg-primary">
            <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-lock-open"></i>&nbsp; Bạn muốn mở hoạt động
              tài khoản này?
            </h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <!-- <div class="modal-body">
            <p class="text-center">Bạn muốn mở hoạt động tài khoản này?</p>
          </div> -->
          <div class="modal-footer d-flex justify-content-end">
            <button type="button" class="btn btn-primary" data-dismiss="modal">Tiếp tục</button>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
    <!-- /.modal  confirm mở-->
    <!--Modal tắt hđ-->
    <div class="modal fade " id="exampleModalDisable" tabindex="-1" aria-labelledby="exampleModalConfirm"
      aria-hidden="true">
      <div class="modal-dialog ">
        <div class="modal-content">
          <div class="modal-header bg-secondary">
            <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-lock"></i>&nbsp; Bạn muốn tắt hoạt động tài
              khoản
              này?
            </h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <!-- <div class="modal-body">
            <p class="text-center">Bạn muốn tắt hoạt động tài khoản này?</p>
          </div> -->
          <div class="modal-footer d-flex justify-content-end">
            <button type="button" class="btn btn-primary" data-dismiss="modal">Tiếp tục</button>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
    <!--Modal tắt hđ-->

    <footer class="main-footer">
      <div class="float-right d-none d-sm-block">
        <b>Version</b> 1.0.0
      </div>
      <strong>Copyright &copy; 2014-2022 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
      <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
  </div>
  <!-- resources/employee/wrapper -->

  <!-- jQuery -->
  <script src="<c:url value='resources/employee/plugins/jquery/jquery.min.js' />"></script>
  <!-- Bootstrap 4 -->
  <script src="<c:url value='resources/employee/plugins/bootstrap/js/bootstrap.bundle.min.js' />"></script>
  <!-- DataTables  & Plugins -->
  <script src="<c:url value='resources/employee/plugins/datatables/jquery.dataTables.min.js' />"></script>
  <script src="<c:url value='resources/employee/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js' />"></script>
  <script src="<c:url value='resources/employee/plugins/datatables-responsive/js/dataTables.responsive.min.js' />"></script>
  <script src="<c:url value='resources/employee/plugins/datatables-responsive/js/responsive.bootstrap4.min.js' />"></script>
  <script src="<c:url value='resources/employee/plugins/datatables-buttons/js/dataTables.buttons.min.js' />"></script>
  <script src="<c:url value='resources/employee/plugins/datatables-buttons/js/buttons.bootstrap4.min.js' />"></script>
  <script src="<c:url value='resources/employee/plugins/jszip/jszip.min.js' />"></script>
  <script src="<c:url value='resources/employee/plugins/pdfmake/pdfmake.min.js' />"></script>
  <script src="<c:url value='resources/employee/plugins/pdfmake/vfs_fonts.js' />"></script>
  <script src="<c:url value='resources/employee/plugins/datatables-buttons/js/buttons.html5.min.js' />"></script>
  <script src="<c:url value='resources/employee/plugins/datatables-buttons/js/buttons.print.min.js' />"></script>
  <script src="<c:url value='resources/employee/plugins/datatables-buttons/js/buttons.colVis.min.js' />"></script>
  <!--  ekko-lightbox show img--->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.min.js"
    integrity="sha512-Y2IiVZeaBwXG1wSV7f13plqlmFOx8MdjuHyYFVoYzhyRr3nH/NMDjTBSswijzADdNzMyWNetbLMfOpIPl6Cv9g=="
    crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <!-- AdminLTE App -->
  <script src="<c:url value='resources/employee/dist/js/adminlte.min.js' />"></script>
  <!-- AdminLTE for demo purposes -->
  <script src="<c:url value='resources/employee/dist/js/demo.js' />"></script>
  <!-- Page specific script -->
  <!-- Custom js -->
  <script src="<c:url value='resources/employee/dist/js/main.js' />"></script>
  
  <script>
    // Click Open Img
    $(document).on('click', '[data-toggle="lightbox"]', function (event) {
      event.preventDefault();
      $(this).ekkoLightbox();
    });

    // Datatable
    $(function () {
      $("#example3").DataTable({
        "responsive": true,
        "ordering": true,
        "autoWidth": false,
        "language": {
          "lengthMenu": "Hien _MENU_ dong moi trang",
          "zeroRecords": "Nothing found - sorry",
          "info": "Trang _PAGE_ / _PAGES_",
          "infoEmpty": "No records available",
          "infoFiltered": "(filtered from _MAX_ total records)",
          "loadingRecords": "Loading...",
          "search": "tim kiem:",
          paginate: {
            previous: '‹',
            next: '›'
          },
        },
        columnDefs: [{
          orderable: false,
          targets: 1
        }, {
          orderable: false,
          targets: 6
        }]

      })
      $("#example1").DataTable({
        "responsive": true,
        "lengthChange": false,
        "autoWidth": false,
        "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
      }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
      $('#example2').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": false,
        "ordering": true,
        "info": true,
        "autoWidth": false,
        "responsive": true,
      });
    });

  </script>
</body>

</html>
