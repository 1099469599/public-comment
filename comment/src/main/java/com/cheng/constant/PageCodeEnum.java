package com.cheng.constant;

/**
 * 常量枚举类
 * Created by dell-pc on 2017/7/27.
 */
public enum PageCodeEnum {

    ADD_SUCCESS(1000, "新增成功!"),
    ADD_FAIL(1001, "新增失败!"),
    MODIFY_SUCCESS(1100, "修改成功!"),
    MODIFY_FAIL(1101, "修改失败!"),
    REMOVE_SUCCESS(1200, "删除成功!"),
    REMOVE_FAIL(1201, "删除失败!"),
    LOGIN_FAIL(1301,"登录失败!用户名或密码错误!"),
    SESSION_TIMEOUT(1302,"session超时，请重新登录!"),
    NO_AUTH(1303,"没有权限访问请求资源，请切换账户后重试!"),
    USERNAME_EXISTS(1401,"用户名已存在!"),
    GROUPNAME_EXISTS(1402,"用户组名已存在!"),
    SUB_MENU_EXISTS(1403,"菜单下还存在子菜单!"),
    ASSIGN_SUCCESS(1500,"分配成功!"),
    ASSIGN_FAIL(1501,"分配失败!"),
    ORDER_SUCCESS(1600,"排序成功!"),
    ORDER_FAIL(1601,"排序失败!"),

    ;
    /**
     * 返回码
     * 前两位表示返回码的类型
     * 后两位表示状态
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回码传递给页面的key
     */
    public static final String KEY = "pageCode";

    PageCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
