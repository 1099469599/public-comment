package com.cheng.constant;

/**
 * 常量枚举类
 * Created by dell-pc on 2017/7/27.
 */
public enum PageCodeEnum {

    ADD_SUCCESS(1000, "新增成功"),
    ADD_FAIL(1001, "新增失败"),
    MODIFY_SUCCESS(1100, "修改成功"),
    MODIFY_FAIL(1101, "修改失败"),
    REMOVE_SUCCESS(1200, "删除成功"),
    REMOVE_FAIL(1201, "删除失败"),;
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
}
