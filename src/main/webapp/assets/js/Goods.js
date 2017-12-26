window.onload = function () {
    var list;//数据集
    var count;//总的页数
    var now = 1;//当前页

    $.get("goods_queryGoods.action", {
        page: 1, rows: 5, 'name': ' '
    }, function (data, status) {
        list = data;
        //alert("数据: " + JSON.stringify(list) + "\n状态: " + status);
        //alert(list.rows[1].address);
        count = Math.floor((list.total + 4) / 5);
        //alert(count);
        //alert(Math.floor(9/5));
        //alert(page);
        var last = now - 1;
        //alert(list.total);
        //alert(now);
        if (now > 1) {

            //alert(last);
            $("#pagination").append("<li class=\"am-pagination-prev\">\n" +
                "        <a href=\"#\" class=\"\" onclick='getgoods(" + last + ")'>上一页</a>\n" +
                "      </li>");
        } else {
            $("#pagination").append("<li class=\"am-pagination-prev  am-disabled\">\n" +
                "        <a href=\"#\" class=\"\" onclick='getgoods(" + last + ")'>上一页</a>\n" +
                "      </li>");
        }

        $("#pagination").append(" <li class=\"am-pagination-select\" >\n" +
            "          <select id='select'>");

        for (var i = 1; i <= count; i++) {
            if (i == now) {
                b = "  <option value=\"#\" class=\"\" selected=\"selected\" onclick='getgoods(" + i + ")'>" + i + "\n" +
                    "\n" +
                    "</option>"
            } else {
                b = "  <option value=\"#\" class=\"\" onclick='getgoods(" + i + ")'>" + i + "\n" +
                    "\n" +
                    "</option>"
            }
            $("#select").append(b);
        }

        $("#pagination").append(" </select>\n" +
            "        </li>");

        if (count != 1 && now != count) {

            //alert(now);
            var next = now + 1;
            //alert(next+"1lalal");
            $("#pagination").append(" <li class=\"am-pagination-next \">\n" +
                "        <a href=\"#\" class=\"\" onclick='getgoods(" + next + ")'>下一页</a>\n" +
                "      </li>");
        }


        for (var i = 0; i < list.rows.length; i++) {
            //alert(list.rows);
            //alert(obj.id);

            s = "<tr><td><input type=\"checkbox\" name='check' value='" + list.rows[i].id + "' /></td><td>" + i + "</td><td>" + list.rows[i].id +
                "</td>" +
                "<td><img src='" + list.rows[i].pic + "' class=\"tpl-table-line-img\"></td>" +
                "<td>" + list.rows[i].name + "</td>" +
                "<td>" + list.rows[i].samary + "</td>" +
                "<td>" + list.rows[i].type + "</td>" +
                "<td>" + list.rows[i].price + "</td>" +
                "<td>" +
                "<div class=\"tpl-table-black-operation\">\n" +
                "<a href=\"javascript:;\" onclick= editgoods('" +
                list.rows[i].id + "','" + list.rows[i].name + "','" + list.rows[i].samary + "','" +
                list.rows[i].type + "','" +
                list.rows[i].price + "')>" +
                "<i class=\"am-icon-pencil\"></i> 编辑\n" +
                "</a>\n" +

                "<a href=\"javascript:;\" class=\"tpl-table-black-operation-del\" onclick=delgoods('" + list.rows[i].id + "')>\n" +
                "<i class=\"am-icon-trash\"></i> 删除\n" +
                "</a>\n" +

                "</div>\n" +
                "</td></tr>";
            // alert(s);
            $("#test").append(s);

        }


    });

    var Menu;
    $.get("getmenu.action", function (data, status) {
        Menu = data;
        //alert("数据: " +JSON.stringify(Menu) + "\n状态: " + status);
        menuTree(Menu, document.getElementById('tree'), 'tree');
    });

}

$(document).ready(function () {


    $('#doc-prompt-toggle').on('click', function () {
        //alert("123");
        $('#addimage').val("");
        $('#addname').val("");
        $('#addsamary').val("");
        $('#addtype').val("");
        $('#addprice').val("");
        $('#my-prompt').modal({
            relatedTarget: this,
            onConfirm: function (e) {
                //alert(e.data)
                //alert(getPath())

                $("#myform").submit();

                //alert('你输入的是：' + e.data[0] || '')
            },
            onCancel: function (e) {
                alert('取消添加商品信息!');
            }
        });
    });

    $("#search").click(function () {
        var text = $("#searchtext").val();
        var list;
        //alert(text);
        //getgoods();

        $.get("goods_queryGoods.action", {
            page: 1, rows: 5, 'name': text
        }, function (data, status) {

            list = data;
            var now = 1;

            //alert("数据: " + JSON.stringify(list) + "\n状态: " + status);
            //alert(list.rows[1].address);
            $("#test").empty();
            $("#pagination").empty();
            var count = Math.floor(list.total + 4) / 5;
            //alert(Math.floor(9/5));
            //alert(page);
            var last = now - 1;
            var next = now + 1;
            if (now > 1) {

                $("#pagination").append("<li class=\"am-pagination-prev \">\n" +
                    "        <a href=\"#\" class=\"\" onclick='getgoods(" + last + ")'>上一页</a>\n" +
                    "      </li>");
            } else {
                $("#pagination").append("<li class=\"am-pagination-prev am-disabled \">\n" +
                    "        <a href=\"#\" class=\"\" onclick='getgoods(" + last + ")'>上一页</a>\n" +
                    "      </li>");
            }

            $("#pagination").append(" <li class=\"am-pagination-select\" >\n" +
                "          <select id='select'>");

            for (var i = 1; i <= count; i++) {

                b = "  <option value=\"#\" class=\"\" onclick='getgoods(" + i + ")'>" + i + "\n" +
                    "\n" +
                    "</option>"

                $("#select").append(b);
            }

            $("#pagination").append(" </select>\n" +
                "        </li>");

            if (count != 1 && now != count) {
                //alert(next);
                $("#pagination").append(" <li class=\"am-pagination-next \">\n" +
                    "        <a href=\"#\" class=\"\" onclick='getgoods(" + next + ")'>下一页</a>\n" +
                    "      </li>");
            }

            for (var i = 0; i < list.rows.length; i++) {

                s = "<tr><td><input type=\"checkbox\" name='check' value='" + list.rows[i].id + "' /></td><td>" + i + "</td><td>" + list.rows[i].id +
                    "</td>" +
                    "<td><img src='" + list.rows[i].pic + "' class=\"tpl-table-line-img\"></td>" +
                    "<td>" + list.rows[i].name + "</td>" +
                    "<td>" + list.rows[i].samary + "</td>" +
                    "<td>" + list.rows[i].type + "</td>" +
                    "<td>" + list.rows[i].price + "</td>" +
                    "<td>" +
                    "<div class=\"tpl-table-black-operation\">\n" +
                    "<a href=\"javascript:;\" onclick= editgoods('" +
                    list.rows[i].id + "','" + list.rows[i].name + "','" + list.rows[i].samary + "','" +
                    list.rows[i].type + "','" +
                    list.rows[i].price + "')>" +
                    "<i class=\"am-icon-pencil\"></i> 编辑\n" +
                    "</a>\n" +

                    "<a href=\"javascript:;\" class=\"tpl-table-black-operation-del\" onclick=delgoods('" + list.rows[i].id + "')>\n" +
                    "<i class=\"am-icon-trash\"></i> 删除\n" +
                    "</a>\n" +

                    "</div>\n" +
                    "</td></tr>";
                // alert(s);
                $("#test").append(s);

            }

        });


    });


//全选/全不选
    $("#checkAll").bind("click", function () {
        $("input[name='check']").prop("checked", this.checked);
        //显示删除按钮
        /*if(this.checked == true){
           $("input[name='Delete'").css("display",'block');
        }else{
           $("input[name='Delete'").css("display",'none');
        }*/
    });

//批量删除
    $("#deleteall").click(function () {
        if (confirm('确定要删除所选吗?')) {
            var checks = $("input[name='check']:checked");
            if (checks.length == 0) {
                alert('未选中任何项！');
                return false;
            }
            //将获取的值存入数组
            var checkData = new Array();
            checks.each(function () {
                checkData.push($(this).val());
            });
            //alert(checkData);
            for (x in checkData) {
                $.post("goods_deletegoods.action",
                    {
                        id: checkData[x]
                    },
                    function (data, status) {
                        //alert("数据: " + JSON.stringify(data) + "\n状态: " + status);
                        alert(data.status);
                        getgoods(1);
                    });

                alert(checkData[x]);
            }
        }
    });


});

function getgoods(noww) {
    var list;
    $.get("goods_queryGoods.action", {
        page: noww, rows: 5, 'name': " "
    }, function (data, status) {

        //alert("数据: " + JSON.stringify(list) + "\n状态: " + status);
        //alert(list.rows[1].address);
        $("#test").empty();
        $("#pagination").empty();

        list = data;
        //alert("数据: " + JSON.stringify(list) + "\n状态: " + status);
        //alert(list.rows[1].address);
        var count = Math.floor((list.total + 4) / 5);
        //alert(Math.floor(9/5));
        //alert(page);
        var last = noww - 1;
        var next = noww + 1;
        if (noww > 1) {

            $("#pagination").append("<li class=\"am-pagination-prev\">\n" +
                "        <a href=\"#\" class=\"\" onclick='getgoods(" + last + ")'>上一页</a>\n" +
                "      </li>");
        } else {
            $("#pagination").append("<li class=\"am-pagination-prev am-disabled \">\n" +
                "        <a href=\"#\" class=\"\" onclick='getgoods(" + last + ")'>上一页</a>\n" +
                "      </li>");
        }

        $("#pagination").append(" <li class=\"am-pagination-select\" >\n" +
            "          <select id='select'>");

        for (var i = 1; i <= count; i++) {
            if (i == noww) {
                b = "  <option value=\"#\" class=\"\" selected=\"selected\" onclick='getgoods(" + i + ")'>" + i + "\n" +
                    "\n" +
                    "</option>"
            } else {
                b = "  <option value=\"#\" class=\"\" onclick='getgoods(" + i + ")'>" + i + "\n" +
                    "\n" +
                    "</option>"
            }
            $("#select").append(b);
        }

        $("#pagination").append(" </select>\n" +
            "        </li>");

        if (count != 1 && noww != count) {
            //alert(now);

            $("#pagination").append(" <li class=\"am-pagination-next \">\n" +
                "        <a href=\"#\" class=\"\" onclick='getgoods(" + next + ")'>下一页</a>\n" +
                "      </li>");
        }
        for (var i = 0; i < list.rows.length; i++) {
            //alert(list.rows[i]);

            s = "<tr><td><input type=\"checkbox\" name='check' value='" + list.rows[i].id + "' /></td><td>" + i + "</td><td>" + list.rows[i].id +
                "</td>" +
                "<td><img src='" + list.rows[i].pic + "' class=\"tpl-table-line-img\"></td>" +
                "<td>" + list.rows[i].name + "</td>" +
                "<td>" + list.rows[i].samary + "</td>" +
                "<td>" + list.rows[i].type + "</td>" +
                "<td>" + list.rows[i].price + "</td>" +
                "<td>" +
                "<div class=\"tpl-table-black-operation\">\n" +
                "<a href=\"javascript:;\" onclick= editgoods('" +
                list.rows[i].id + "','" + list.rows[i].name + "','" + list.rows[i].samary + "','" +
                list.rows[i].type + "','" +
                list.rows[i].price + "')>" +
                "<i class=\"am-icon-pencil\"></i> 编辑\n" +
                "</a>\n" +

                "<a href=\"javascript:;\" class=\"tpl-table-black-operation-del\" onclick=delgoods('" + list.rows[i].id + "')>\n" +
                "<i class=\"am-icon-trash\"></i> 删除\n" +
                "</a>\n" +

                "</div>\n" +
                "</td></tr>";
            // alert(s);
            $("#test").append(s);

        }

    });
}

function delgoods(id) {

    alert(id);
    $('#gid').val(id);
    $('#my-confirm').modal({
        relatedTarget: this,
        onConfirm: function (e) {
            alert($('#gid').val());

            $.post("goods_deletegoods.action",
                {
                    "id": $('#gid').val()
                },
                function (data, status) {
                    //alert("数据: " + JSON.stringify(data) + "\n状态: " + status);
                    //alert();

                    getgoods(1);
                });

        },
        // closeOnConfirm: false,
        onCancel: function () {
            alert('算逑，不弄了');
        }
    });
}

function editgoods(id, name, samary, type, price) {
    // alert(id);
    // alert(pname);
    // alert(infor);
    // alert(address);
    // alert(phone);
    //alert(samary);
    $('#editid').val(id);
    $('#editname').val(name);
    $('#editsamary').val(samary);
    $('#edittype').val(type);
    $('#editprice').val(price);


    //alert( $('#editsamery').val());

    $('#my-prompt2').modal({
        relatedTarget: this,
        onConfirm: function (e) {
            //alert($('#editsamery').val());
            $('#form2').submit();
            $('#editid').val("");
            $('#editname').val("");
            $('#editsamary').val("");
            $('#edittype').val("");
            $('#editprice').val("");
            $('#editimage').val("");
        },
        // closeOnConfirm: false,
        onCancel: function () {
            alert('算逑，不弄了');
        }
    });

}
