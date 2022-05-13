 function activeSidebarItem(){
	 $(".nav-item").each(function() {
		 if($(location).attr("pathname").includes($(this).attr("id"))){
			 $(this).find(".nav-link").addClass("active");
		 }
	 })
 }

function isShowModal(){
	
	let modalShow = $(".modal.fade[isShow=true]");
	
	if(modalShow){
		modalShow.modal('show')
	}
	
}

function updateUserInfo(){
	 //alertify.notify("Kiểu file ảnh không hợp lệ. Vui lòng chọn ảnh .PNG hoặc .JPG", "success", 7);
	
	 let inpChangeAvatar = $("#input-change-avatar")
	
	 inpChangeAvatar.on("change", function(e){
		 console.log(inpChangeAvatar)
		 let imgAvatar = $("#user-modal-avatar")
		 imgAvatar.attr("src", URL.createObjectURL(inpChangeAvatar[0].files[0]))
		 imgAvatar.on("load", function(){
			 URL.revokeObjectURL(imgAvatar.attr("src"))
		 })
	 })
}

function showModalConfirm(){
	$("#cancel-save-modal").on("click", function(e){
		e.preventDefault();
		alertify.confirm('Bạn có chắc chắn hủy?', '', function(){
			$("#cancel-save-modal").unbind("click")
			$("#cancel-save-modal")[0].click()
		}
        , function(){} ).set('labels', {ok:'Hủy', cancel:'Thoát'});

	})
}

$(document).ready(function(){
	activeSidebarItem();
	
	isShowModal();
	
	updateUserInfo();
	
	showModalConfirm();
 });