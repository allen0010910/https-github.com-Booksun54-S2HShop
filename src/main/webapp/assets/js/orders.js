window.onload = function () {
    var list;
    var count;
    var now = 1;

    $.get("orders_queryOrders.action", {
        page: 1, rows: 5
    }, function (data, status) {
        list = data;
        //alert("数据: " + JSON.stringify(list) + "\n状态: " + status);
        //alert(list.rows[1].address);
        count = Math.floor((list.total + 4) / 5);
        //alert(count);
        //alert(Math.floor(9/5));
        //alert(page);
        var last = now - 1;
        //alert(now);
        if (now > 1) {

            //alert(last);
            $("#pagination").append("<li class=\"am-pagination-prev\">\n" +
                "        <a href=\"#\" class=\"\" onclick='getOrders(" + last + ")'>上一页</a>\n" +
                "      </li>");
        } else {
            $("#pagination").append("<li class=\"am-pagination-prev  am-disabled\">\n" +
                "        <a href=\"#\" class=\"\" onclick='getOrders(" + last + ")'>上一页</a>\n" +
                "      </li>");
        }

        $("#pagination").append(" <li class=\"am-pagination-select\" >\n" +
            "          <select id='select'>");

        for (var i = 1; i <= count; i++) {
            if (i == now) {
                b = "  <option value=\"#\" class=\"\" selected=\"selected\" onclick='getOrders(" + i + ")'>" + i + "\n" +
                    "\n" +
                    "</option>"
            } else {
                b = "  <option value=\"#\" class=\"\" onclick='getOrders(" + i + ")'>" + i + "\n" +
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
                "        <a href=\"#\" class=\"\" onclick='getOrders(" + next + ")'>下一页</a>\n" +
                "      </li>");
        }


        for (var i = 0; i < list.rows.length; i++) {
            //alert(list.rows);
            //alert(obj.id);
            //alert(list.rows[i].whlist.warehouse.name);
            var a = 1;

            s = "<tr><td><input type=\"checkbox\" name='check' value='" + list.rows[i].id + "' /></td><td>" + i + "</td><td>" + list.rows[i].id +
                "</td>+<td>" + list.rows[i].goods.name + "</td><td>" +
                list.rows[i].num + "</td>" +
                "<td>" +
                list.rows[i].price + "</td>"
                + "<td>" +
                list.rows[i].provider.pname + "</td>" + "<td>" + list.rows[i].sum + "</td>" +
                "<td>" + list.rows[i].whlist.warehouse.name + "</td>" + "<td>" + list.rows[i].date + "</td>"
                + "<td>" +
                "<div class=\"tpl-table-black-operation\">\n" +
                "<a href=\"javascript:;\" onclick= editOrders('" +
                list.rows[i].id + "','" + list.rows[i].name + "','" +
                list.rows[i].address + "')>" +
                "<i class=\"am-icon-pencil\"></i> 编辑\n" +
                "</a>\n" +

                "<a href=\"javascript:;\" class=\"tpl-table-black-operation-del\" onclick=delOrders('" + list.rows[i].id + "')>\n" +
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

        $('#addname').val("");
        $('#addaddress').val("");

        $('#my-prompt').modal({
            relatedTarget: this,
            onConfirm: function (e) {
                //alert(e.data[2])

                $.post("orders_saveOrders.action",
                    {
                        'name': e.data[0],
                        'address': e.data[1],
                    },
                    function (data, status) {
                        //alert("数据: \n" + data + "\n状态: " + status);
                        if (status == 'success') {
                            alert("插入成功!");
                            getOrders(1);
                        }

                    });

                //alert('你输入的是：' + e.data[0] || '')
            },
            onCancel: function (e) {
                alert('取消添加仓库信息!');
            }
        });
    });

    $("#search").click(function () {
        var text = $("#searchtext").val();
        var list;
        //alert(text);
        //getOrders();

        $.get("orders_searchbyname.action", {
            page: 1, rows: 5, 'wno': wno, "goods.name": text
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
                    "        <a href=\"#\" class=\"\" onclick='getOrders(" + last + ")'>上一页</a>\n" +
                    "      </li>");
            } else {
                $("#pagination").append("<li class=\"am-pagination-prev am-disabled \">\n" +
                    "        <a href=\"#\" class=\"\" onclick='getOrders(" + last + ")'>上一页</a>\n" +
                    "      </li>");
            }

            $("#pagination").append(" <li class=\"am-pagination-select\" >\n" +
                "          <select id='select'>");

            for (var i = 1; i <= count; i++) {

                b = "  <option value=\"#\" class=\"\" onclick='getOrders(" + i + ")'>" + i + "\n" +
                    "\n" +
                    "</option>"

                $("#select").append(b);
            }

            $("#pagination").append(" </select>\n" +
                "        </li>");

            if (count != 1 && now != count) {
                //alert(next);
                $("#pagination").append(" <li class=\"am-pagination-next \">\n" +
                    "        <a href=\"#\" class=\"\" onclick='getOrders(" + next + ")'>下一页</a>\n" +
                    "      </li>");
            }

            for (var i = 0; i < list.rows.length; i++) {


                s = "<tr><td><input type=\"checkbox\" name='check' value='" + list.rows[i].id + "' /></td><td>" + i + "</td><td>" + list.rows[i].id +
                    "</td>+<td>" + list.rows[i].goods.name + "</td><td>" +
                    list.rows[i].num + "</td>" +
                    "<td>" +
                    list.rows[i].price + "</td>"
                    + "<td>" +
                    list.rows[i].provider.pname + "</td>" + "<td>" + list.rows[i].sum + "</td>" +
                    "<td>" + list.rows[i].whlist.warehouse.name + "</td>" + "<td>" + list.rows[i].date + "</td>"
                    + "<td>" +
                    "<div class=\"tpl-table-black-operation\">\n" +
                    "<a href=\"javascript:;\" onclick= editOrders('" +
                    list.rows[i].id + "','" + list.rows[i].name + "','" +
                    list.rows[i].address + "')>" +
                    "<i class=\"am-icon-pencil\"></i> 编辑\n" +
                    "</a>\n" +

                    "<a href=\"javascript:;\" class=\"tpl-table-black-operation-del\" onclick=delOrders('" + list.rows[i].id + "')>\n" +
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
                $.post("orders_deleteOrders.action",
                    {
                        id: checkData[x]
                    },
                    function (data, status) {
                        //alert("数据: " + JSON.stringify(data) + "\n状态: " + status);
                        alert(data.status);
                        getOrders(1);
                    });

                alert(checkData[x]);
            }
        }
    });


});

function getOrders(noww) {
    var list;
    $.get("orders_queryOrders.action", {
        page: noww, rows: 5, 'wno': wno
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
                "        <a href=\"#\" class=\"\" onclick='getOrders(" + last + ")'>上一页</a>\n" +
                "      </li>");
        } else {
            $("#pagination").append("<li class=\"am-pagination-prev am-disabled \">\n" +
                "        <a href=\"#\" class=\"\" onclick='getOrders(" + last + ")'>上一页</a>\n" +
                "      </li>");
        }

        $("#pagination").append(" <li class=\"am-pagination-select\" >\n" +
            "          <select id='select'>");

        for (var i = 1; i <= count; i++) {
            if (i == noww) {
                b = "  <option value=\"#\" class=\"\" selected=\"selected\" onclick='getOrders(" + i + ")'>" + i + "\n" +
                    "\n" +
                    "</option>"
            } else {
                b = "  <option value=\"#\" class=\"\" onclick='getOrders(" + i + ")'>" + i + "\n" +
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
                "        <a href=\"#\" class=\"\" onclick='getOrders(" + next + ")'>下一页</a>\n" +
                "      </li>");
        }
        for (var i = 0; i < list.rows.length; i++) {
            //alert(list.rows);

            s = "<tr><td><input type=\"checkbox\" name='check' value='" + list.rows[i].id + "' /></td><td>" + i + "</td><td>" + list.rows[i].id +
                "</td>+<td>" + list.rows[i].goods.name + "</td><td>" +
                list.rows[i].num + "</td>" +
                "<td>" +
                list.rows[i].price + "</td>"
                + "<td>" +
                list.rows[i].provider.pname + "</td>" + "<td>" + list.rows[i].sum + "</td>" +
                "<td>" + list.rows[i].whlist.warehouse.name + "</td>" + "<td>" + list.rows[i].date + "</td>"
                + "<td>" +
                "<div class=\"tpl-table-black-operation\">\n" +
                "<a href=\"javascript:;\" onclick= editOrders('" +
                list.rows[i].id + "','" + list.rows[i].name + "','" +
                list.rows[i].address + "')>" +
                "<i class=\"am-icon-pencil\"></i> 编辑\n" +
                "</a>\n" +

                "<a href=\"javascript:;\" class=\"tpl-table-black-operation-del\" onclick=delOrders('" + list.rows[i].id + "')>\n" +
                "<i class=\"am-icon-trash\"></i> 删除\n" +
                "</a>\n" +
                "</div>\n" +
                "</td></tr>";
            // alert(s);
            $("#test").append(s);

        }

    });
}

function delOrders(id) {
    alert($('#id_delete').val());
    $('#id_delete').val(id);
    alert($('#id_delete').val());
    $('#my-confirm').modal({
        relatedTarget: this,
        onConfirm: function (options) {
            alert($('#id_delete').val());
            $.post("orders_deleteOrders.action",
                {
                    "id": $('#id_delete').val()
                },
                function (data, status) {
                    //alert("数据: " + JSON.stringify(data) + "\n状态: " + status);
                    alert(data.status);
                    getOrders(1);
                });
        },
        // closeOnConfirm: false,
        onCancel: function () {
            alert('算逑，不弄了');
        }
    });
}

function editOrders(id, name, address) {
    // alert(id);
    // alert(pname);
    // alert(infor);
    // alert(address);
    // alert(phone);
    $('#id_edit').val(id);
    $('#name_edit').val(name);
    $('#address_edit').val(address);
    $('#my-prompt2').modal({
        relatedTarget: this,
        onConfirm: function (e) {
            $.post("orders_editOrders.action",
                {
                    "id": $('#id_edit').val(),
                    'name': $('#name_edit').val(),
                    'address': $('#address_edit').val()
                },
                function (data, status) {
                    //alert("数据: " + JSON.stringify(data) + "\n状态: " + status);
                    alert(data.status);
                    getOrders(1);
                });
        },
        // closeOnConfirm: false,
        onCancel: function () {
            alert('算逑，不弄了');
        }
    });

}
