/**
 * 主页
 * Created by cheng on 2017/7/25.
 */

/**
 * 方法描述：单机一级菜单（页面上部的菜单），初始化子菜单（即页面左部菜单）
 */
function clickFirstMenu(element) {
    //判断当前单击的节点是否是[选中模式]，如果是[选中模式],不再触发单机事件
    if ($(element).attr("class") != "on") {
        //将同级节点的[选中模式]清空
        $("#mainMenuUl").children().attr("class", "");
        //将当前节点置为[选中模式]
        $(element).attr("class", "on");
        //加载二级菜单内容
        $("#menuDiv").html("<h3 onclick='clickSecondMenu(this，)'><a>广告管理</a></h3>");
    }
}

/**
 * 方法描述：单机二级菜单（页面左部菜单），初始化主页面
 */
function clickSecondMenu(element, path) {
    //将其他有[选中模式]的节点清空
    $("#menuDiv").children().children().attr("class", "");
    //将当前单机的节点置为[选中模式]
    $(element).children().attr("class", "on");
    //将当前页面跳转到指定的地址
    $("#mainPage").attr("src", path);
}



// /**
//  * 当前登录用户可以访问的菜单Map
//  */
// var menuMap = {};
//
// $(function () {
//     //TODO
//     common.ajax()
// });
//
// /**
//  * 初始化菜单
//  */
// function initMenu() {
//     var menuList = menuMap[0];
//     $("#menuDiv").html("");
//     $.each(menuList,function(i,value) {
//         $("#menuDiv").append("<li onclick='clickMenu(this," + value.id + ")'><a><span>"
//             + value.name + "</span></a></li>");
//     });
// }
//
// /**
//  * 根据父单ID初始化子菜单
//  */
// function initSubMenu(parentId) {
//     var menuList = menuMap[parentId];
//     $("#subMenuDiv").html("");
//     $.each(menuList, function (i, value) {
//         $("#subMenuDiv").append("<h3 onclick=\"clickSubMenu(this,'" + value.url + "')\"><a>" + value.name + "</a></h3>")
//     });
// }
//
//
// /**
//  * 方法描述：单击菜单（页面上部的菜单），初始化子菜单（即页面左部菜单）
//  */
// function clickMenu(element, id) {
//     //将同级节点的[选中样式]清空
//     $("#menuDiv").children().attr("class", "");
//     //将当前单击的节点重置为[选中样式]
//     $(element).attr("class", "on");
//     //加载子菜单内容
//     initSubMenu(id);
// }
//
// /**
//  * 方法描述：单击子菜单（页面左部菜单），初始化主页面
//  */
// function clickSubMenu(element, path) {
//     //将其他有[选中模式]的节点的样式清空
//     $("#subMenuDiv").find(".on").attr("class", "");
//     //将当前单机的节点置为[选中模式]
//     $(element).children.attr("class", "on");
//     //将当前页面跳转到指定的地址(iframe)
//     $("#mainPage").attr("src", $("#basePath").val() + path);
// }