$('#pw, #pwConfirm').on('keyup', function () {
  if ($('#pw').val() == $('#pwConfirm').val()) {
    $('#message').html('Khớp mật khẩu').css('color', 'green');
  } else 
    $('#message').html('Không khớp mật khẩu!!!').css('color', 'red');
 
});