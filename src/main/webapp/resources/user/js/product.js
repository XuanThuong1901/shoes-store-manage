function filterSizeProduct(){
	 $(".btn-filter-size").click(function () {
		 
		 if($(this).hasClass("btn-size-active")){
			 
		 }else {
			 
		 }
		 
		    $(this).toggleClass("btn-size-active");
		    let size= $(this).data("masize")
		   
		    let currentUrl = window.location.href
		    
		    
		    if(window.location.href.includes("?")){
		    	
		    	window.location.href = `${currentUrl}&s=${size}`
		    }else {
		    	window.location.href = `${currentUrl}?s=${size}`
		    	
		    }
		    	
		    
		  });
}

function filterColorProduct(){
	 $(".btn-filter-color-item").click(function () {
		    $(this).parent().toggleClass("border border-dark");
		    console.log(window.location)
		  });
}

function getDetailProduct(){
	$(".btn-product-buynow").click(function (){
		
		window.location.href= "sanpham/" + $(this).data("id")
	})
}

$(document).ready(function () {
 
	filterSizeProduct();
	
	filterColorProduct();
	
	getDetailProduct();
});
