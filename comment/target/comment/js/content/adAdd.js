/**
 * 添加广告相关
 * Created by cheng on 2017/7/26.
 */

$(function () {
    common.showMessage($("#message").val());
    $("#mainForm").validate({
        rules: {
            "title": "required",
            "link": "required",
            "imgFile":"required",
            "weight": {
                required: true,
                digits: true
            }
        },
        messages: {
            "title": "请输入标题!",
            "link": "请输入链接地址!",
            "imgFile":"请选择要上传的文件!",
            "weight": {
                required: "请输入权重!",
                digits: "请输入数字!"
            }
        }
    });
});

/**
 *添加广告
 */
function add() {
        $("#mainForm").submit();
}

/**
 * 返回列表
 */
function goback() {
    location.href = $("#basePath").val() + "/ad";
}

