/**
 * 商户新增
 * Created by dell-pc on 2017/8/2.
 */

$(function () {
    common.showMessage($("#message").val());
    $("#mainForm").validate({
        rules: {
            "title": "required",
            "subtitle": "required",
            "city": "required",
            "category": "required",
            "price": "required",
            "distance": "required",
            "desc": "required"
        },
        messages: {
            "title": "请输入标题!",
            "subtitle": "请输入副标题!",
            "city": "请选择城市!",
            "category": "请选择类别!",
            "price": "请输入价格!",
            "distance": "请输入距离!",
            "desc": "请输入描述!"
        }
    });
});

/**
 * 添加商户
 */
function add() {
    $("#mainForm").submit();
}
/**
 * 返回列表
 */
function goback() {
    location.href = $("#basePath").val() + "/businesses";
}
