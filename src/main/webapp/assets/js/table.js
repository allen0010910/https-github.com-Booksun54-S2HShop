window.onload = function () {
    var Menu;
    $.get("getmenu.action", function (data, status) {
        Menu = data;
        //alert("数据: " +JSON.stringify(Menu) + "\n状态: " + status);
        menuTree(Menu, document.getElementById('tree'), 'tree');
    });
    //构建菜单
    //alert(JSON.stringify(Menu))
    //menuTree(Menu, document.getElementById('tree'), 'tree');
}

/*
 * @构建树形菜单
 * @arrJson:json数据
 * @container:菜单容器
 */
function menuTree(jsonArr, container, treeId) {
    var oText, oUrl, oicon;
    var oUl = document.createElement('ul');
    for (var i = 0; i < jsonArr.length; i++) {
        var oLi = document.createElement('li');
        oUl.className = 'sidebar-nav-link'
        oUrl = jsonArr[i].url || "javascript:void(0)";
        oicon = jsonArr[i].icon || " ";
        oText = jsonArr[i].tit;
        if (jsonArr[i].submenu) {
            oLi.className = 'sidebar-nav-link'
            oLi.className = 'sidebar-nav-link';
            oLi.innerHTML = '<a style="font-size:15px;" href="' + oUrl + '">' + '<span class= ' + oicon + '></span>' + oText + '</a>';
            menuTree(jsonArr[i].submenu, oLi);//递归构建子菜单
        } else {
            oUl.className = 'sidebar-nav-link sidebar-nav-sub'
            oLi.className = 'sidebar-nav-link';
            oLi.innerHTML = '<a style="font-size:5px;" href="' + oUrl + '">' + '<span class= ' + oicon + '></span>' + oText + '</a>';
        }
        //自定义函数
        if (typeof jsonArr[i].func == "function") {
            oLi.getElementsByTagName('a')[0].func = jsonArr[i].func;
            oLi.getElementsByTagName('a')[0].onclick = function () {
                this.func();
            }
        }
        oUl.appendChild(oLi);
    }
    //最外层容器事件委托
    if (treeId) {
        document.getElementById(treeId).onclick = function (e) {
            var event = e || window.event;
            var target = event.target || event.srcElement;
            var next = target.nextSibling;
            if (target.nodeName.toLowerCase() == "a") {
                if (next) {
                    if (next.style.display == "" || next.style.display == "block") {
                        next.style.display = "none";
                    } else {
                        next.style.display = "block";
                    }
                }
            }
        }
    }
    container.appendChild(oUl);
}