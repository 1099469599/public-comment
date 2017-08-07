/**
 * 管理模块
 * Created by dell-pc on 2017/8/6.
 */

$(function () {

    common.showMessage($("#message").val());
    //验证信息
    $("#mainForm").validate({
        rules: {
            "name": {
                required: true
            },
            "password": {
                required: true
            }
        }, messages: {
            "name": {
                required: "用户名不能为空!"
            },
            "password": {
                required: "密码不能为空!"
            }
        }
    });

    /**
     * 单击登录
     */
    $("#submit_login").click(login);
    /**
     *
     */
    $(document).keydown(function (event) {
        if (event.keyCode == 13) {
            login();
        }
    });

});

function login() {
    if ($("#password").val()) {
        $("#password_md5").val($.md5($("#password").val()));
    }
    $("#mainForm").submit();
}