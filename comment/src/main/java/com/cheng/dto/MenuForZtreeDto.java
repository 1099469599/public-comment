package com.cheng.dto;

/**
 * 菜单列表dto
 * Created by cheng on 2017/7/22.
 */
public class MenuForZtreeDto {

    /**
     * 这个节点在数据库中的主键值
     */
    private Long id;
    /**
     * 这个节点在数据库里的父节点主键值
     */
    private Long parentId;
    /**
     * 树上显示的名称
     */
    private String name;
    /**
     * zTree上是否默认展开
     */
    private boolean open;
    /**
     * 用来表示zTree上父子节点关系的节点id：
     * 因将来会在一棵树上展示两种节点：菜单、动作
     * 这两个来自两张表，表的主键会重复，这样造成zTree展示时混乱，为了区分zTree上两种节点，将在这两种节点的原主键上加前缀：
     * 来自菜单表的节点：菜单前缀+菜单表id
     * 来自动作表的节点：动作前缀+动作表id
     */
    private String comboId;
    /**
     * 用来表示zTree上父节点关系的父节点id：
     * 与comboId原因相同。
     */
    private String comboParentId;
    /**
     * 菜单表节点前缀
     */
    public static final String PREFIX_MENU = "MENU_";
    /**
     * 动作表节点前缀
     */
    public static final String PREFIX_ACTION = "ACTION_";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getComboId() {
        return comboId;
    }

    public void setComboId(String comboId) {
        this.comboId = comboId;
    }

    public String getComboParentId() {
        return comboParentId;
    }

    public void setComboParentId(String comboParentId) {
        this.comboParentId = comboParentId;
    }
}
