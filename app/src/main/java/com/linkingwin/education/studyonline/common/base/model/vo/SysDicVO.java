package com.linkingwin.education.studyonline.common.base.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @描述 系统字典实体
 * @作者 gsh
 * @时间 2017/4/10 15:35
 */

public class SysDicVO implements Serializable {
    private String code;
    private String name;
    private List<Dicitems> dicitems;
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

    public List<Dicitems> getDicitems() {
        return dicitems;
    }

    public void setDicitems(List<Dicitems> dicitems) {
        this.dicitems = dicitems;
    }

  public static class Dicitems implements Serializable {
        private String dvalue;
        private String displayname;

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
}
