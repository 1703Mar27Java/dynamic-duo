/**
 * 
 */
$(document).ready(function(){
	$("h1").on({
		mouseenter:function(){
			$(this).css("color", "#ffffff");
		},
		mouseleave:function(){
			$(this).css("color","#003366");
		}	
		
	});
	
	
});


$(document).ready(function(){
	$("body").css("background-color","#99ccff");
	
});


$(document).ready(function(){
	$("a").css("color", "#000000");
});


$(document).ready(function(){
	$("input").focus(function(){
		$(this).css("background-color","ffffcc");
		
	});
});


