/**
 * Created by lei on 16-1-10.
 */

$(document).ready(function(){
    $('button:contains("免费注册")').click(function(event) {
        var form = $('form[action="/user/register.json"]');
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

    $('button:contains("立即登陆")').click(function(event) {
        var form = $('form[action="/user/signin.json"]');
        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: form.serialize(),
            success: function(data) {
                if (1 == data.userdata){
                    alert("邮箱未注册");
                }else if(2 == data.userdata){
                    alert("用户名或密码不对");
                }else {
                    userLogined();
                }
            }
        });
    });
});

//用户登陆成功
function userLogined(){
    $.ajax({
        type: "get",
        url: "/user/profile.json",
        success: function(data) {
            $('#user-interface').html('<li><a href="/user/account.html">'+data.userdata.name+'</a></li>'+
                    '<li><a href="/user/logout.html">退出</a></li>');
            $('button:contains("×")').trigger('click');
        }
    });
}