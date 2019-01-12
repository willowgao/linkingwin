package com.linkingwin.education.studyonline.common.base.model.vo;

/**
 * @Desc
 * @Author Willowgao
 * @Version V1.0
 * @Date 2018/6/25
 */

public class SpinnerVO {
    public SpinnerVO(String id, String text) {
        this.id = id;
        this.text = text;
    }

    String id;
    String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        return text;
    }
}
