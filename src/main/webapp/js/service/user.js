/**
 * Created by lei on 16-1-10.
 */

$(document).ready(function(){
    $('button:contains("Create Account")').click(function(event) {
        var form = $('form[action="/user/register.html"]');
        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: form.serialize()
        }).done(function(data) {
            alert(data);
        }).fail(function(data) {
            alert(data);
        });
    });
});