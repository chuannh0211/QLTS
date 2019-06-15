$(document).ready(function() {
	console.log("1");
	jQuery('#pageId').click(function() {
		console.log("check");
		function dsdmPageable(type, page, size) {
			console.log("2");
			modifyData("dsdmPageable?page=" + page + "&size=" + size);
			console.log("page: " + page);
			console.log("size: " + size);
		}
		function modifyData(suffix) {
			console.log("3");
			jQuery.ajax({
				url : "/" + suffix,
				succes : function(data) {
					jQuery('#pageId').html(data);
				}
			});
		}
	});

});