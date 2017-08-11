/**
 * 商户列表
 * Created by dell-pc on 2017/8/2.
 */

$(function () {
    common.showMessage($("#message").val());
});

/**
 * 分页查找
 */
function search(pageNum) {
    $("#pageNum").val(pageNum);
    $("#mainForm").submit();
}

/**
 * 删除商户
 */
function removeBusiness(id) {
    if (confirm("确定要删除这条广告吗? ")) {
        $("#_method").val("delete");
        $("#mainForm").attr("action", $("#basePath").val() + "/businesses/" + id);
        $("#mainForm").submit();
    }
}

/**
 * 初始化修改页
 */
function modifyInit(id) {
    window.location.href = $("#basePath").val() + "/businesses/" + id;
}