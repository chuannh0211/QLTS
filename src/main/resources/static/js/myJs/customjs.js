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
					jQuery('#myModal-InfoUser').hide();
					jQuery('#myModal-editTs').hide();
					jQuery('#myModal-editBdts').hide();
					jQuery('#myModal-editUser').hide();
					jQuery('#modal-suppDetails').hide();
					jQuery("#modal-editSupplier").hide();
					jQuery("#myModal-groupInfo").hide();
					jQuery("#myModal-editGroup").hide();
					jQuery("#modal-viewCategory").hide();
					jQuery("#modal-editCategory").hide();
					jQuery("#myModal-addBdts").hide();
				});
				// click ra window -> tắt modal
				window.onclick = function(event) {
					if (event.target == document
							.getElementById('myModal-InfoUser')) {
						jQuery('#myModal-InfoUser').hide();
					} else if (event.target == document
							.getElementById('modal-suppDetails')) {
						jQuery('#modal-suppDetails').hide();
					} else if (event.target == document
							.getElementById('myModal-groupInfo')) {
						jQuery('#myModal-groupInfo').hide();
					} else if (event.target == document
							.getElementById('modal-viewCategory')) {
						jQuery('#modal-viewCategory').hide();
					}

				}
				// show modal for class
				jQuery('.open-modal').click(function() {
					jQuery('#myModal').show();

				});
				// Popup sửa danh mục
				jQuery('.open-modal-editCategory').click(function() {
					jQuery('#modal-editCategory').show();
					var id_category = jQuery(this).attr("id_categpry");
					jQuery.ajax({
						url : 'edit-dsdm/' + id_category,
						success : function(data) {
							jQuery("#content-editCategory").html(data);
						}
					});
				});

				// Popup xem thông tin danh mục
				jQuery('.open-modal-categoryDetails').click(function() {
					jQuery('#modal-viewCategory').show();
					var id_category = jQuery(this).attr("id_categpry");
					jQuery.ajax({
						url : 'view-category-details/' + id_category,
						success : function(data) {
							jQuery("#content-categoryDetails").html(data);
						}
					});
				});
				// Popup xem thông tin người dùng
				jQuery('.open-modal-user-detail').click(function() {
					jQuery('#myModal-InfoUser').show();
					var id_user = jQuery(this).attr("id-user");
					// console.log(id_user);
					jQuery.ajax({
						url : 'info-user-popup/' + id_user,
						success : function(data) {
							jQuery("#content_infoUser").html(data);
						}
					});
				});

				// Popup sửa thông tin tài sản
				jQuery(".open-modal-editAsset").click(function() {
					jQuery('#myModal-editTs').show();
					var id_tss = jQuery(this).attr("id-tss");
					// console.log(id_tss);
					jQuery.ajax({
						url : '/edit-ts/' + id_tss,
						success : function(data) {
							jQuery("#content_editAsset").html(data);
						}
					});
				});

				// Popup sửa biến động tài sản
				jQuery(".open-modal-editBdts").click(function() {
					jQuery('#myModal-editBdts').show();
					var id_bdts = jQuery(this).attr("id-bdts");
					jQuery.ajax({
						url : 'form-sua-bdts/' + id_bdts,
						success : function(data) {
							jQuery("#content_modal_bdts").html(data);
						}
					});
				});

				// Popup sửa dcts
				jQuery(".open-modal").click(function() {
					var id_dcts = jQuery(this).attr("id-dcts");
					// console.log(id_dcts);
					jQuery.ajax({
						url : 'sua-dctsX/' + id_dcts,// 1
						success : function(data) {
							jQuery("#content_modal_dcts").html(data);
						}
					});
				});

				// Popup sửa thông tin user
				jQuery(".open-modal-editUser").click(function() {
					jQuery('#myModal-editUser').show();
					var id = jQuery(this).attr("id-user");
					jQuery.ajax({
						url : 'edit-dstk/' + id,
						success : function(data) {
							jQuery("#content_editUser").html(data);
						}
					});
				})

				// Popup xem thông tin nhà cung cấp
				jQuery(".open-modal-suppDetails").click(function() {
					jQuery('#modal-suppDetails').show();
					var id_ncc = jQuery(this).attr("id-ncc");
					jQuery.ajax({
						url : 'nccDetails/' + id_ncc,
						success : function(data) {
							jQuery("#content-suppliers").html(data);
						}
					});
				});

				// Popup sửa thông tin nhà cung cấp
				jQuery(".open-modal-editSupp").click(function() {
					jQuery("#modal-editSupplier").show();
					var id_sup = jQuery(this).attr("id-ncc");
					jQuery.ajax({
						url : 'edit-ncc/' + id_sup,
						success : function(data) {
							jQuery("#content-editSupplier").html(data);
						}
					});
				});

				// Popup xem thông tin nhóm
				jQuery(".opan-modal-viewDetails").click(function() {
					jQuery('#myModal-groupInfo').show();

					var id_nhom = jQuery(this).attr("id-nhom");
					jQuery.ajax({
						url : 'group-details/' + id_nhom,
						success : function(data) {
							jQuery("#content-groupDetails").html(data);
						}
					});
				});

				// Popup sửa thông tin nhóm
				jQuery(".opan-modal-editGroup").click(function() {
					jQuery('#myModal-editGroup').show();
					var id_nhom = jQuery(this).attr("id-nhom");
					jQuery.ajax({
						url : 'edit-dsn/' + id_nhom,
						success : function(data) {
							jQuery("#content-editGroup").html(data);
						}
					});
				});

			/*	// Popup biến động tài sản
				jQuery(".open-modal-dcts").click(function() {
					jQuery('#myModal-addBdts').show();
					var id_bdtss = jQuery(this).attr("id-bdtss");
					console.log(id_bdtss);
				});*/

			}
		});
