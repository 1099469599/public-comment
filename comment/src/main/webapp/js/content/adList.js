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
 * 删除
 */
function remove() {
    alert(123);

}

/**
 * 初始化修改页
 */
function modifyInit() {
    alert(123);
}