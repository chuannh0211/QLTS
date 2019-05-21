jQuery(document).ready(function() {
	// Open modal danh sach danh muc
	if (jQuery('#myModal').length > 0) {
		// show modal
		jQuery('#myBtn').click(function() {
			jQuery('#myModal').show();
		});

		// close modal
		jQuery('span.closee').click(function() {
			jQuery('#myModal').hide();
		});

		window.onclick = function(event) {
			if (event.target == document.getElementById('myModal')) {
				jQuery('#myModal').hide();
			}
		}

		// show modal for class
		jQuery('.open-modal').click(function() {
			jQuery('#myModal').show();
		});

		}
	
		// Popup sửa chi tiết tài sản
		jQuery(".open-modal").click(function() {
			var id_dcts = jQuery(this).attr("id-dcts");
			// console.log(id_dcts);
			jQuery.ajax({
				url : 'sua-dctsX/' + id_dcts,// 1
				success : function(data) {
					jQuery("#content_modal").html(data);
				}
			});
		});
		
		//Popup sửa biến động tài sản
});
