function check(){
    //alert("6666666");
    alert(msg.addimage.value);
    if(msg.addimage.value == null){
        alert("请选择图片!");
        return false;
    }
    $("#msg").submit();
}

