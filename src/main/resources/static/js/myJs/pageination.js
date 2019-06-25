//
function pagination(page, size) {
	modifyData("?page=" + page + "&size=" + size);
}
function modifyData(suffix) {
	jQuery.ajax({
		type : "GET",
		url : "/listCategoris" + suffix,
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
		url : "/listAsset" + suffix,
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
		url : "/listSuppliers" + suffix,
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
		url : "/listGroups" + suffix,
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
		url : "/listAccounts" + suffix,
		success : function(data) {
			jQuery(".navbar-primary").html(data);
		}
	});
}