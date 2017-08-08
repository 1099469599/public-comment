/**
 *广告列表
 * Created by dell-pc on 2017/7/27.
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
 * 删除广告
 */
function removeAd(id) {
    if (confirm("确定要删除这条广告吗? ")) {
        $("#id").val(id);
        $("#mainForm").attr("action", $("#basePath").val() + "/ad/remove");
        $("#mainForm").submit();
    }
}

/**
 * 初始化修改页
 */
function modifyInit(id) {
    $("#id").val(id);
    $("#mainForm").attr("action", $("#basePath").val() + "/ad/modifyInit");
    $("#mainForm").submit();
}

