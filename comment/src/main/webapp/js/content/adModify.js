$(function () {
    common.showMessage($("#message").val());
    $("#mainForm").validate({
        rule:{
            "title":"required",
            "link":"required",
            "weight":{
                required:true,
                digits:true,
                maxlength:5
            }
        },
        message:{
            "title":"请输入标题！"
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
