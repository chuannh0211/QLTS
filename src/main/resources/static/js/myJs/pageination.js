function pagination(page, size) {
	modifyData("/danhmuc?page=" + page + "&size=" + size);
}
function modifyData(suffix) {
	jQuery.ajax({
		type : "GET",
		url : suffix,
		success : function(data) {
			jQuery(".navbar-primary").html(data);
		}
	});
}
