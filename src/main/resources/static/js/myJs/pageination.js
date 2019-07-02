//
function pagination(page, size) {
	modifyData("?page=" + page + "&size=" + size);
}
function modifyData(suffix) {
	jQuery.ajax({
		type : "GET",
		url : "/category/listCategories" + suffix,
		success : function(data) {
			jQuery(".navbar-primary").html(data);
		}
	});
}
//
function paginationAsset(page, size) {
	modifyDataAsset("?page=" + page + "&size=" + size);
}
function modifyDataAsset(suffix) {
	jQuery.ajax({
		type : "GET",
		url : "/asset/listAsset" + suffix,
		success : function(data) {
			jQuery(".navbar-primary").html(data);
		}
	});
}
//
function paginationSup(page, size) {
	modifyDataSup("?page=" + page + "&size=" + size);
}
function modifyDataSup(suffix) {
	jQuery.ajax({
		type : "GET",
		url : "/supplier/listSuppliers" + suffix,
		success : function(data) {
			jQuery(".navbar-primary").html(data);
		}
	});
}
//
function paginationGroup(page, size) {
	modifyDataGroup("?page=" + page + "&size=" + size);
}
function modifyDataGroup(suffix) {
	jQuery.ajax({
		type : "GET",
		url : "/group/listGroups" + suffix,
		success : function(data) {
			jQuery(".navbar-primary").html(data);
		}
	});
}
//
function paginationAcc(page, size) {
	modifyDataAcc("?page=" + page + "&size=" + size);
}
function modifyDataAcc(suffix) {
	jQuery.ajax({
		type : "GET",
		url : "/user/listAccounts" + suffix,
		success : function(data) {
			jQuery(".navbar-primary").html(data);
		}
	});
}