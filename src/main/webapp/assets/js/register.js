function check() {
    if (msg.username.value.length > 6 || msg.username.value.length < 4) {
        alert("请输入4~6位字符的名称!");
        msg.username.focus();
        return false;
    }

    if (msg.password.value != msg.password2.value) {
        alert("请保证输入的两次密码相同!");
        msg.password2.focus();
        return false;
    }

    //发送数据去后台
    register(msg.username.value, msg.password.value);
    return true;
}

function register(rname, rpassword) {

    $.post("user_confirmation.action",
        {
            'userid': rname,
            'password': rpassword,

        },
        function (data, status) {
            //局部刷新页面
            $('.tpl-login').html(data);

            //alert("数据: " + JSON.stringify(data) + "\n状态: " + status);
            //alert(data.status);
        });

}
