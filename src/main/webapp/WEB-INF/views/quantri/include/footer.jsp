<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>






<div class="modal fade" id="modal-edit">
	<div class="modal-dialog modal-lg modal-dialog-scrollable">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Sửa nhân viên</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
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
									<li class="nav-item"><a class="nav-link active"
										href="#activity" data-toggle="tab">Thông tin</a></li>
									<li class="nav-item"><a class="nav-link" href="#settings"
										data-toggle="tab">Cài đặt</a></li>
								</ul>
							</div>
							<!-- /.card-header -->
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
																	src="resources/employee/dist/img/user4-128x128.jpg"
																	alt="User profile picture">
															</div>

															<h3 class="profile-username text-center">Nina
																Mcintire</h3>

															<p class="text-muted text-center">Nhân viên</p>



															<a href="#" class="btn bg-dark btn-block"><i
																class="fas fa-upload"></i></a>
														</div>
														<!-- /.card-body -->
													</div>
													<!-- /.card -->
												</div>

												<div class="col-md-9">

													<div class="form-group row">
														<label for="inputName" class="col-sm-2 col-form-label">Mã
															NV</label>
														<div class="col-sm-10">
															<input type="email" class="form-control" id="inputName"
																placeholder="NV1">
														</div>
													</div>
													<div class="form-group row">
														<label for="inputEmail" class="col-sm-2 col-form-label">Tên
															NV</label>
														<div class="col-sm-10">
															<input type="email" class="form-control" id="inputEmail"
																placeholder="Võ Thị Thanh Ngân">
														</div>
													</div>
													<div class="form-group row">
														<label for="inputName2" class="col-sm-2 col-form-label">Giới
															tính</label>
														<div class="col-sm-10">
															<input type="text" class="form-control" id="inputName2"
																placeholder="Nữ">
														</div>
													</div>
													<div class="form-group row">
														<label for="inputExperience"
															class="col-sm-2 col-form-label">Ngày sinh</label>
														<div class="col-sm-10">
															<input class="form-control" id="inputExperience"
																placeholder="13/11/2001"></input>
														</div>
													</div>
													<div class="form-group row">
														<label for="inputSkills" class="col-sm-2 col-form-label">CCCD</label>
														<div class="col-sm-10">
															<input type="text" class="form-control" id="inputSkills"
																placeholder="01234567890">
														</div>
													</div>
													<div class="form-group row">
														<label for="inputSkills" class="col-sm-2 col-form-label">SĐT</label>
														<div class="col-sm-10">
															<input type="text" class="form-control" id="inputSkills"
																placeholder="0123456789">
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
												<label for="inputName" class="col-sm-2 col-form-label">Mật
													khẩu</label>
												<div class="col-sm-10">
													<input type="password" class="form-control" id="inputName"
														placeholder="Mật khẩu">
												</div>
											</div>
											<div class="form-group row">
												<label for="inputEmail" class="col-sm-2 col-form-label">Mật
													khẩu mới</label>
												<div class="col-sm-10">
													<input type="password" class="form-control" id="inputEmail"
														placeholder="Nhập mật khẩu mới">
												</div>
											</div>
											<div class="form-group row">
												<label for="inputName2" class="col-sm-2 col-form-label">Nhập
													lại</label>
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
							</div>
							<!-- /.card-body -->
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



<footer class="main-footer">
	<div class="float-right d-none d-sm-block">
		<b>Version</b> 1.0.0
	</div>
	<strong>Copyright &copy; 2014-2022 <a
		href="https://adminlte.io">AdminLTE.io</a>.
	</strong> All rights reserved.
</footer>

<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
	<!-- Control sidebar content goes here -->
</aside>
<!-- /.control-sidebar -->
</div>
<!-- resources/employee/wrapper -->

<!-- jQuery -->
<script
	src="<c:url value='resources/employee/plugins/jquery/jquery.min.js' />"></script>
<!-- Bootstrap 4 -->
<script
	src="<c:url value='resources/employee/plugins/bootstrap/js/bootstrap.bundle.min.js' />"></script>
<!-- Select2 -->
<script
	src="<c:url value='resources/employee/plugins/select2/js/select2.full.min.js' />"></script>
<!-- Bootstrap4 Duallistbox -->
<script
	src="<c:url value='resources/employee/plugins/bootstrap4-duallistbox/jquery.bootstrap-duallistbox.min.js' />"></script>
<!-- InputMask -->
<script
	src="<c:url value='resources/employee/plugins/moment/moment.min.js' />"></script>
<script
	src="<c:url value='resources/employee/plugins/inputmask/jquery.inputmask.min.js' />"></script>
<!-- date-range-picker -->
<script
	src="<c:url value='resources/employee/plugins/daterangepicker/daterangepicker.js' />"></script>
<!-- bootstrap color picker -->
<script
	src="<c:url value='resources/employee/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js' />"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="<c:url value='resources/employee/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js' />"></script>
<!-- Bootstrap Switch -->
<script src="<c:url value='resources/employee/plugins/bootstrap-switch/js/bootstrap-switch.min.js' />"></script>
<!-- BS-Stepper -->
<script src="<c:url value='resources/employee/plugins/bs-stepper/js/bs-stepper.min.js' />"></script>
<!-- dropzonejs -->
<script src="<c:url value='resources/employee/plugins/dropzone/min/dropzone.min.js' />"></script>
<!-- DataTables  & Plugins -->
<script
	src="<c:url value='resources/employee/plugins/datatables/jquery.dataTables.min.js' />"></script>
<script
	src="<c:url value='resources/employee/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js' />"></script>
<script
	src="<c:url value='resources/employee/plugins/datatables-responsive/js/dataTables.responsive.min.js' />"></script>
<script
	src="<c:url value='resources/employee/plugins/datatables-responsive/js/responsive.bootstrap4.min.js' />"></script>
<script
	src="<c:url value='resources/employee/plugins/datatables-buttons/js/dataTables.buttons.min.js' />"></script>
<script
	src="<c:url value='resources/employee/plugins/datatables-buttons/js/buttons.bootstrap4.min.js' />"></script>
<script
	src="<c:url value='resources/employee/plugins/jszip/jszip.min.js' />"></script>
<script
	src="<c:url value='resources/employee/plugins/pdfmake/pdfmake.min.js' />"></script>
<script
	src="<c:url value='resources/employee/plugins/pdfmake/vfs_fonts.js' />"></script>
<script
	src="<c:url value='resources/employee/plugins/datatables-buttons/js/buttons.html5.min.js' />"></script>
<script
	src="<c:url value='resources/employee/plugins/datatables-buttons/js/buttons.print.min.js' />"></script>
<script
	src="<c:url value='resources/employee/plugins/datatables-buttons/js/buttons.colVis.min.js' />"></script>
<!--  ekko-lightbox show img--->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.min.js"
	integrity="sha512-Y2IiVZeaBwXG1wSV7f13plqlmFOx8MdjuHyYFVoYzhyRr3nH/NMDjTBSswijzADdNzMyWNetbLMfOpIPl6Cv9g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!-- Alertify -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/AlertifyJS/1.13.1/alertify.min.js" integrity="sha512-JnjG+Wt53GspUQXQhc+c4j8SBERsgJAoHeehagKHlxQN+MtCCmFDghX9/AcbkkNRZptyZU4zC8utK59M5L45Iw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!-- AdminLTE App -->
<script
	src="<c:url value='resources/employee/dist/js/adminlte.min.js' />"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value='resources/employee/dist/js/demo.js' />"></script>
<!-- Page specific script -->
<!-- Custom js -->
<script src="<c:url value='resources/employee/dist/js/main.js' />"></script>

<script>
   $(function () {
    //Initialize Select2 Elements
    $('.select2').select2()

    //Initialize Select2 Elements
    $('.select2bs4').select2({
      theme: 'bootstrap4'
    })

    //Datemask dd/mm/yyyy
    $('#datemask').inputmask('dd/mm/yyyy', { 'placeholder': 'dd/mm/yyyy' })
    //Datemask2 mm/dd/yyyy
    $('#datemask2').inputmask('mm/dd/yyyy', { 'placeholder': 'mm/dd/yyyy' })
    //Money Euro
    $('[data-mask]').inputmask()

    //Date picker
    $('#reservationdate').datetimepicker({
        format: 'L',
       defaultDate: new Date()
    });

    //Date and time picker
    $('#reservationdatetime').datetimepicker({ icons: { time: 'far fa-clock' } });

    //Date range picker
    $('#reservation').daterangepicker()
    //Date range picker with time picker
    $('#reservationtime').daterangepicker({
      timePicker: true,
      timePickerIncrement: 30,
      locale: {
        format: 'MM/DD/YYYY hh:mm A'
      }
    })
    //Date range as a button
    $('#daterange-btn').daterangepicker(
      {
        ranges   : {
          'Today'       : [moment(), moment()],
          'Yesterday'   : [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
          'Last 7 Days' : [moment().subtract(6, 'days'), moment()],
          'Last 30 Days': [moment().subtract(29, 'days'), moment()],
          'This Month'  : [moment().startOf('month'), moment().endOf('month')],
          'Last Month'  : [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        },
        startDate: moment().subtract(29, 'days'),
        endDate  : moment()
      },
      function (start, end) {
        $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))
      }
    )

    //Timepicker
    $('#timepicker').datetimepicker({
      format: 'LT'
    })

    //Bootstrap Duallistbox
    $('.duallistbox').bootstrapDualListbox()

    //Colorpicker
    $('.my-colorpicker1').colorpicker()
    //color picker with addon
    $('.my-colorpicker2').colorpicker()

    $('.my-colorpicker2').on('colorpickerChange', function(event) {
      $('.my-colorpicker2 .fa-square').css('color', event.color.toString());
    })

    $("input[data-bootstrap-switch]").each(function(){
      $(this).bootstrapSwitch('state', $(this).prop('checked'));
    })

  })
  
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
          "lengthMenu": "Hiện _MENU_ dòng mỗi trang",
          "zeroRecords": "Nothing found - sorry",
          "info": "Trang _PAGE_ / _PAGES_",
          "infoEmpty": "No records available",
          "infoFiltered": "(filtered from _MAX_ total records)",
          "loadingRecords": "Loading...",
          "search": "Tìm kiếm:",
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
