package com.linkingwin.education.studyonline.common.base.model.po;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.io.Serializable;

/**
 * @描述 字典项实体
 * @作者 gsh
 * @时间 2017/5/16 15:15
 */
@Table(name="t_dicitem")
public class DicItemPO implements Serializable {
    /**
     * 主键
     */
    @Column(name="ID",isId = true,autoGen = false,property = "NOT NULL")
    private Long id;
    /**
     * 字典类型ID
     */
    @Column(name="TYPEID",property = "NOT NULL")
    private Long typeid;
    /**
     * 字典项显示值
     */
    @Column(name="DISPLAYNAME")
    private String displayname;
    /**
     * 字典项实际值
     */
    @Column(name="DVALUE")
    private String dvalue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getDvalue() {
        return dvalue;
    }

    public void setDvalue(String dvalue) {
        this.dvalue = dvalue;
    }
}
