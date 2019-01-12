package com.linkingwin.education.studyonline.common.base.model.po;

import org.xutils.DbManager;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;
import org.xutils.ex.DbException;

import java.io.Serializable;
import java.util.List;

/**
 * @描述 字典类型实体
 * @作者 gsh
 * @时间 2017/5/16 15:15
 */
@Table(name="t_dictype")
public class DicTypePO implements Serializable {
    /**
     * 主键
     */
    @Column(name="ID",isId = true,autoGen = false,property = "NOT NULL")
    private Long id;
    /**
     * 字典类型编号
     */
    @Column(name="CODE")
    private String code;
    /**
     * 字典类型名称
     */
    @Column(name="NAME")
    private String name;

    public List<DicItemPO> getDicitems(DbManager db) throws DbException {
        return db.selector(DicItemPO.class).where("TYPEID", "=", this.id).findAll();//一对多的查询
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
