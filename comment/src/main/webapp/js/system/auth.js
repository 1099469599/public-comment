$(function () {
    //初始化用户树
    initUserTree();
    //初始化用户组树
    initGroupTree();
    //初始化菜单树
    initMenuTree();

    $("#userForm").validate({
        rules: {
            "userName": "required",
            "chName": "required"
        }
    });
    $("#groupForm").validate({
        rules: {
            "groupName": "required"
        }
    });
    $("#menuForm").validate({
        rules: {
            "menuName": "required"
        }
    });
    $("#actionForm").validate({
        rules: {
            "actionName": "required",
            "actionUrl": "required",
        }
    });
});


/**
 * 鼠标在菜单间移动时样式的切换
 */
function move(element) {
    $(".rMenuLiMove").addClass("rMenuLi");
    $(".rMenuLiMove").remove("rMenuLiMove");

    $(element).addClass("rMenuLiMove");
    $(element).removeClass("rMenuLi");
}

/**
 *鼠标在弹出层上方时，解除鼠标按下的事件
 */
function divOver() {
    $("body").unbind("mousedown", mousedown);
}

/**
 * 单击鼠标事件：
 * 在页面任意地方单击鼠标，关闭右键弹出的菜单
 */
function mousedown() {
    $("#rMenu").css({
        "visibility": "hidden"
    });
    $("#groupMenu").css({
        "visibility": "hidden"
    });
    $("#menuMenu").css({
        "visibility": "hidden"
    });
}

/**
 * 鼠标划出右键菜单层时，去除"鼠标经过菜单"的样式
 */
function divOut() {
    $("body").bind("mousedown", mousedown);

    $(".rMenuLiMove").addClass("rMenuLi");
    $(".rMenuLiMove").remove("rMenuLiMove");
}

/**
 * 右击时定位右键菜单展示的位置并显示
 * @param event js event对象
 * @param rMenuId 菜单
 */
function rightClick(event, rMenuId) {
    $("#" + rMenuId).css({
        "top": event.clientY + "px",
        "left": event.clientX + "px",
        "visibility": "visible"
    });
}

/**
 * 清空用户维护界面里的内容
 */
function clearUser() {
    $("#userId").val("");
    $("#userName").val("");
    $("#chName").val("");
}

/**
 * 清空用户组维护界面里的内容
 */
function clearGroup() {
    $("#groupId").val("");
    $("#groupName").val("");
}

/**
 * 清空菜单维护界面里的内容
 */
function clearMenu() {
    $("#menuId").val("");
    $("#menuName").val("");
    $("#url").val("");
}

/**
 * 清空动作维护界面里的内容
 */
function clearAction() {
    $("#actionId").val("");
    $("#actionName").val("");
    $("#actionUrl").val("");
    $("#httpMethod").val("");
}

/**
 * 初始化用户树
 */
function initUserTree() {
    common.ajax({
        url: $("#basePath").val() + "/users",//默认用get请求
        success: function (data) {
            var setting = {
                view: {
                    dblClickExpand: true,//定义双击打开
                    showLine: true,//显示节点之间的连线
                    selectedMulti: false//是否允许同时选中多个节点 否
                },
                data: {
                    simpleData: { //简单数据模式
                        enable: true //使用
                    },
                    key: {//zTree 节点数据
                        name: "chName"//保存节点名称的属性名称
                    }
                },
                callback: {//回调函数
                    //TODO 直接写 onClick ：selectUser
                    onClick: function (event, treeId, treeNode) {//用于捕获节点被左键点击的事件回调函数
                        selectUser();
                    },
                    onRightClick: userRightClick//用于捕获节点被右键点击的事件回调函数
                }
            };
            data.push({id: 0, chName: "用户", open: true});//id：根节点的唯一标识,chName：节点名称，open：节点是否默认打开
            $.fn.zTree.init($("#user"), setting, data);
        }
    });
}

/**
 * 在用户树上右击显示右键菜单同时选中节点
 * @param event 标准的 js event 对象
 * @param treeId 对应 zTree 的 treeId，便于用户操控
 * @param treeNode 被点击的节点 JSON 数据对象
 */
function userRightClick(event, treeId, treeNode) {
    if (!treeNode) {
        return;
    }
    $.fn.zTree.getZTreeObj(treeId).selectNode(treeNode);
    rightClick(event, "rMenu");
}

/**
 * 选中用户后显示用户对应的用户组
 */
function selectUser() {
    var nodes = $.fn.zTree.getZTreeObj("user").getSelectedNodes();
    var groupTree = $.fn.zTree.getZTreeObj("group");
    //先清空原本选中的选项
    var checkedNodes = groupTree.getCheckedNodes(true);
    if (checkedNodes.length > 0) {
        groupTree.checkNode(checkedNodes[0], false);
    }

    common.ajax({
        url: $("#basePath").val() + "/users/" + nodes[0].id,
        success: function (data) {
            //如果当前选中的用户有组，则选中这个组
            if (data.groupId) {
                groupTree.checkNode(groupTree.getNodeByParam("id", data.groupId), true);
            }
        }
    });
}

/**
 * 初始化新增用户界面
 */
function initAddUser() {
    mousedown();
    clearUser();
    $("#userTitle").html("&nbsp;&nbsp;新增用户");
    $("#cover").show();
    $("#userMaintain").show();
}

/**
 * 初始化修改用户界面
 */
function initModifyUser() {
    mousedown();
    var nodes = $.fn.zTree.getZTreeObj("user").getSelectedNodes();
    common.ajax({
        url: $("#basepath").val() + "/users/" + nodes[0].id,
        success: function (data) {
            clearUser();
            $("#userId").val(data.id);
            $("#userName").val(data.name);
            $("#chName").val(data.chName);
            $("#userTitle").html("&nbsp;&nbsp;修改用户");
            $("#cover").show();
            $("#userMaintain").show();
        }
    });
}

/**
 * 保存用户，如果主键存在则修改，不存在则新增
 */
function saveUser() {
    if ($("#userForm").valid()) {
        if ($("#userId").val()) {
            common.ajax({
                url: $("#basePath").val() + "/users/" + $("#userId").val(),
                type: "POST",
                success: function (data) {
                    if (data.code === common.pageCode.MODIFY_SUCCESS) {
                        initUserTree();
                        closeUser();
                    }
                    common.showMessage(data.msg);
                },
                data: {
                    "name": $("#userName").val(),
                    "chName": $("#chName").val(),
                    "_method": "PUT"
                }
            });
        } else {
            common.ajax({
                url: $("#basePath").val() + "/users/",
                type: "POST",
                success: function (data) {
                    if (data.code === common.pageCode.MODIFY_SUCCESS) {
                        initUserTree();
                        closeUser();
                    }
                    common.showMessage(data.msg);
                },
                data: {
                    "name": $("#userName").val(),
                    "chName": $("#chName").val(),
                    "password": $("#password").val(),
                    "_method": "PUT"
                }
            });
        }
    }
}

/**
 * 删除用户
 */
function removeUser() {
    mousedown();
    var nodes = $.fn.zTree.getZTreeObj("user").getSelectedNodes();
    if (confirm("确定要删除用户[" + nodes[0].chName + "]吗?")) {
        common.ajax({
            url: $("#basePath").val() + "/users/" + nodes[0].id,
            type: "POST",
            success: function (data) {
                if (data.code === common.pageCode.REMOVE_SUCCESS) {
                    initUserTree();
                }
                common.showMessage(data.msg);
            },
            data: {
                "_method": "DELETE"
            }
        });
    }
}

/**
 * 重置密码
 */
function restPassword() {
    mousedown();
    var nodes = $.fn.zTree.getZTreeObj("user").getSelectedNodes();
    common.ajax({
        url: $("#basePath").val() + "/users/" + nodes[0].id,
        type: "POST",
        success: function (data) {
            if (data.code === common.pageCode.MODIFY_SUCCESS) {
                //TODO 改为状态码
                common.showMessage("重置密码成功!");
            } else {
                common.showMessage(data.msg);
            }
        },
        data: {
            "_method": "PUT",
            "password": nodes[0].name
        }
    });
}

/**
 * 为用户分配用户组
 */
function assignGroup() {
    var userNodes = $.fn.zTree.getZTreeObj("user").getSelectedNodes();
    var groupNodes = $.fn.zTree.getZTreeObj("group").getSelectedNodes();
    if (userNodes.length <= 0) {
        common.showMessage("未选中用户!");
        return;
    }
    if (userNodes.length == 0) {
        common.showMessage("不能为根节点分配用户组!");
        return;
    }
    if (userNodes.length >= 0) {
        common.showMessage("未选中用户组!");
        return;
    }
    common.ajax({
        url: $("#basePath").val() + "/users/" + userNodes[0].id,
        type: "POST",
        success: function (data) {
            if (data.code === common.pageCode.MODIFY_SUCCESS) {
                common.showMessage("分配用户组成功!");
            } else {
                common.showMessage(data.msg);
            }
        },
        data: {
            "groupId": groupNodes[0].id,
            "_method": "PUT"
        }
    });
}

/**
 * 初始化用户组树
 */
function initGroupTree() {
    common.ajax({
        url: $("#basePath").val() + "/groups",
        success: function (data) {
            var setting = {
                check: {
                    enable: true,//设置节点上是否显示checkbox/radio
                    chkStyle: "radio"//显示 radio 选择框
                },
                view: {
                    dblClickExpand: true,
                    showLine: true,
                    selectedMulti: false
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                callback: {
                    onClick: function (event, treeId, treeNode) {
                        selectGroup();
                    },
                    onRightClick: groupRightClick
                }
            };
            data.push({id: 0, name: "用户组", open: true, nocheck: true});
            $.fn.zTree.init($("#group"), setting, data);
        }
    });
}

/**
 * 初始化菜单树
 */
function initMenuTree() {
    common.ajax({
        url: $("#basePath").val() + "/menus",
        success: function (data) {
            var setting = {
                edit: {
                    enable: true,//设置zTree处于编辑状态
                    showRemoveBtn: false,//设置是否显示删除按钮
                    showRenameBtn: false,//设置是否显示编辑名称按钮
                    drag: {//拖拽时
                        isCopy: false//设置是否允许复制节点
                    }
                },
                check: {
                    enable: true//默认是checkbox
                },
                view: {
                    dblClickExpand: true,// 定义双击展开
                    showLine: true,
                    selectedMulti: false
                },
                data: {
                    simpleData: {
                        enable: true,
                        pIdKey: "comboParentId",//设置父节点
                        idKey: "comboId"//当前节点
                    }
                },
                callback: {
                    beforeDrop: beforeDrop,
                    beforeDrag: beforeDrag,
                    onRightClick: menuRightClick
                }
            };
            data.push({
                comboId: common.menuPrefix.PREFIX_MENU + "0", name: "菜单+动作"
                , open: true, nocheck: true
            });//nocheck 设置节点是否隐藏 checkbox / radio
            $.fn.zTree.init($("#menu"), setting, data);
        }
    });
}


/**
 * 在用户树
 */
function groupRightClick(event, treeId, treeNode) {

}

/**
 * 右击时定位右键菜单展示的位置并显示
 * @param event js event对象
 * @param rMenuId 菜单
 */
function rightClick(event, rMenuId) {
    $("#" + rMenuId).css({
        "top": event.clientY + "px",
        "left": event.clientX + "px",
        "visibility": "visible"
    });
}

/**
 * 在菜单树上右击显示右键菜单同时显示选中菜单
 */
function menuRightClick(event, treeId, treeNode) {
    if (!treeNode) {
        return;
    }
    rightClick(event, "menuMenu");
    $.fn.zTree.getZTreeObj(treeId).selectNode(treeNode);
    $(".rmenuli").show();
    //如果是动作节点，不显示[新增菜单]、[新增操作]
    if (treeNode.comboId.indexOf(common.menuPrefix.PREFIX_ACTION) == 0) {
        $(".menuclass").hide();
    }
    //如果是根节点，不显示[修改]、[删除]
    if (treeNode.comboId.indexOf(common.menuPrefix.PREFIX_ACTION + 0)) {
        $(".menuclass").hide();
    }
}

/**
 *关闭用户维护界面
 */
function closeUser() {
    $("#cover").hide();
    $("#userMaintain").hide();
}

/**
 *关闭用户组维护界面
 */
function closeGroup() {
    $("#cover").hide();
    $("#groupMaintain").hide();
}

/**
 *关闭菜单维护界面
 */
function closeMenu() {
    $("#cover").hide();
    $("#menuMaintain").hide();
}

/**
 *关闭动作维护界面
 */
function closeAction() {
    $("#cover").hide();
    $("#actionMaintain").hide();
}

/**
 *节点被拖拽之前的事件回调函数
 * 返回false可以阻止拖拽
 */
function beforeDrag(treeId, treeNodes) {
    //动作节点不参与排序
    if (treeNodes[0].comboId.indexOf(common.menuPrefix.PREFIX_ACTION) == 0) {
        return false;
    }
}

/**
 * 节点拖拽操作结束之前事件：
 * 将拖拽后的顺序提交，修改数据库中的顺序
 */
function beforeDrop(treeId, treeNodes, targetNode, moveType, isCopy) {

}

