package com.oasis.rx.product.tool.base.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Title:tree结构
 * Description:树形结构信息存储(不是存储在数据库中，用的是一个工具类，纯碎的polo对象)
 *
 * @author Created by Julie
 * @version 1.0
 * @date on 8:41 2017/7/16
 */
@Data
public class TreeEntity implements Serializable {

    private String id;
    /**
     * 父节点Id
     */
    private String pId;
    /**
     * 名称
     */
    private String name;
    /**
     * url
     */
    private String url;
    /**
     * 节点是否打开
     */
    private Boolean open;
    /**
     * 多选框是否选中
     */
    private Boolean checked;

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    /**
     * 是否为叶子节点，true表示是叶子节点，false表示不是叶子节点
     */
    public Boolean leaf = true;

}
