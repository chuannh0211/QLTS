jQuery(document).ready(function() {
	console.log("helo");
	if (jQuery('#datetimepicker1').length > 0) {
		jQuery('#mm').click(function() {
			jQuery('#datetimepicker1').datetimepicker();
		});

	}
});