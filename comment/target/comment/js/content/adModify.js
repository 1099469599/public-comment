$(function () {
    common.showMessage($("#message").val());
    $("#mainForm").validate({
        rules: {
            "title": "required",
            "link": "required",
            "weight": {
                required: true,
                digits: true
            }
        },
        messages: {
            "title": "请输入标题!",
            "link": "请输入链接地址!",
            "weight": {
                required: "请输入权重!",
                digits: "请输入数字!"
            }
        }
    });
});

/**
 * 提交修改
 */
function modify() {
    $("#mainForm").submit();
}


/**
 * 返回列表
 */
function goback() {
    location.href = $("#basePath").val() + "/ad";
}
