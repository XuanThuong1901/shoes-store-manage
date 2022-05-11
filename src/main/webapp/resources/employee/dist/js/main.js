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

$(document).ready(function(){
	activeSidebarItem();
	
	isShowModal()
 });