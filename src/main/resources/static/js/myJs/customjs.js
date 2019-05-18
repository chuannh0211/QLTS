jQuery(document).ready(function() {
	
	
	//Open modal danh sach danh muc
	if (jQuery('#myModal').length > 0){
//		var modal = document.getElementById('myModal');
//		var btn = document.getElementById("myId");
//		var span = document.getElementsByClassName("close")[0];
//		btn.onclick = function() {
//			modal.style.display = "block";
//		}
//		span.onclick = function() {
//			modal.style.display = "none";
//		}
//		window.onclick = function(event) {
//			if (event.target == modal) {
//				modal.style.display = "none";
//			}
//		}
		//show modal
		jQuery('#myBtn').click(function(){
			jQuery('#myModal').show();
		});

		//close modal
		jQuery('span.closee').click(function(){
			jQuery('#myModal').hide();
		});
		
		window.onclick = function(event) {
			if (event.target == document.getElementById('myModal')) {
				jQuery('#myModal').hide();
			}
		}
		
		//show modal for class
		jQuery('.open-modal').click(function(){
			jQuery('#myModal').show();
		});

	}
});
