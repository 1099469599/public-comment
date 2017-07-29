/**
 * 添加广告相关
 * Created by cheng on 2017/7/26.
 */

$(function () {
    common.showMessage($("#message").val());
});

/**
 *添加广告
 */
function add() {
    if (check()) {
        $("#mainForm").submit();
    }
}

/**
 * 返回列表
 */
function goback() {
    location.href = $("#basePath").val() + "/ad";
}

/**
 * 表单内容验证
 * @returns {boolean}
 */
function check() {
    //TODO 需要添加表单验证
    return true;
}