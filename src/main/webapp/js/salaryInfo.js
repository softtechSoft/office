$(function(){
	$('.aa').bind('input propertychange', function(){
	var $this = $(this);
	console.log($this);
	var text_length = $this.val().length;
	var current_width = parseInt(text_length) *16;
	console.log(current_width+"px");

	});
})

document.querySelector("input").addEventListener("input",function(){
	this.style.width="0px";
	this.style.width=this.scrollWidth +"px";
});
