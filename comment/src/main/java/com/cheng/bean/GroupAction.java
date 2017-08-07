package com.cheng.bean;

/**
 * 用户组表与http动作表关系的实体
 * Created by cheng on 2017/7/22.
 */
public class GroupAction {

    /**
     * 用户组表id
     */
    private Long groupId;
    /**
     * http动作表id
     */
    private Long actionId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }
}
