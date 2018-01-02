function check() {

    if (msg.password.value != msg.password2.value) {
        alert("请保证输入的两次密码相同!");
        msg.password2.focus();
        return false;
    }

    //发送数据去后台
    register(msg.password.value);
    return true;
}

function register(rpassword) {

    $.post("user_updatepwd.action",
        {
            'id': id,
            'password': rpassword
        },
        function (data, status) {
            //局部刷新页面
            //$('.tpl-login').html(data);
            //alert(JSON.stringify(data));
            alert(data.tip);
            //alert(data.check);
            if (data.check) {
                window.location.href = "user_toMain.action";
            }
            //window.location.href = "user_toMain.action";
            //alert("数据: " + JSON.stringify(data) + "\n状态: " + status);
            //alert(data.status);
        });

}
