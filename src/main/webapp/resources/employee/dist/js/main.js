 function activeSidebarItem(){
	 $(".nav-item").on("click", function(){
		 
		 $(".nav-item").find(".nav-link.active").removeClass("active");
		 $(this).find(".nav-link").addClass("active");
	 })
 }


$(document).ready(function(){
	activeSidebarItem();
	console.log($(location).attr("pathname"))
 });