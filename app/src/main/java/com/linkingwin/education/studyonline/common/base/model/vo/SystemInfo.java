package com.linkingwin.education.studyonline.common.base.model.vo;

import java.util.Date;

public class SystemInfo {
    /**
     * 系统ID
     */
    private String id;

    /**
     * 系统名称
     */
    private String sName;

    /**
     * 父系统id
     */
    private String pid;

    /**
     * 系统地址
     */
    private String sUrl;

    /**
     * 服务类型
     */
    private String sType;
    /**
     *  单价
     */
    private String sPrice;

    /**
     *  内容介绍
     */
    private String sComments;

    /**
     * logo
     */
    private String sLogo;

    /**
     * 是否有效（1,有效,0,无效）
     */
    private String isenable;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date lastUpdateDate;

    /**
     * 修改人
     */
    private String lastUpdateor;

    /**
     * 系统ID
     * @return id 系统ID
     */
    public String getId() {
        return id;
    }

    /**
     * 系统ID
     * @param id 系统ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 系统名称
     * @return s_name 系统名称
     */
    public String getsName() {
        return sName;
    }

    /**
     * 系统名称
     * @param sName 系统名称
     */
    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    /**
     * 父系统id
     * @return pid 父系统id
     */
    public String getPid() {
        return pid;
    }

    /**
     * 父系统
     * id当sType为 {@link Constants.SystemType.SYSTEM_TYPE_VALUE_ADD_SERVICE)} 时
	 * pid为systemId,否则pid 为空
     * @param pid 父系统id
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * 系统地址
     * @return s_url 系统地址
     */
    public String getsUrl() {
        return sUrl;
    }

    /**
     * 系统地址
     * @param sUrl 系统地址
     */
    public void setsUrl(String sUrl) {
        this.sUrl = sUrl == null ? null : sUrl.trim();
    }

    /**
     * 
     * @return s_type 
     */
    public String getsType() {
        return sType;
    }

    /**
     * 
     * @param sType 
     */
    public void setsType(String sType) {
        this.sType = sType == null ? null : sType.trim();
    }

    /**
     * 
     * @return s_comments 
     */
    public String getsComments() {
        return sComments;
    }

    /**
     * 
     * @param sComments 
     */
    public void setsComments(String sComments) {
        this.sComments = sComments == null ? null : sComments.trim();
    }

    /**
     * 
     * @return s_logo 
     */
    public String getsLogo() {
        return sLogo;
    }

    /**
     * 
     * @param sLogo 
     */
    public void setsLogo(String sLogo) {
        this.sLogo = sLogo == null ? null : sLogo.trim();
    }

    /**
     * 是否有效（1,有效,0,无效）
     * @return isenable 是否有效（1,有效,0,无效）
     */
    public String getIsenable() {
        return isenable;
    }

    /**
     * 是否有效（1,有效,0,无效）
     * @param isenable 是否有效（1,有效,0,无效）
     */
    public void setIsenable(String isenable) {
        this.isenable = isenable == null ? null : isenable.trim();
    }

    /**
     * 创建人
     * @return creator 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 修改时间
     * @return last_update_date 修改时间
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * 修改时间
     * @param lastUpdateDate 修改时间
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * 修改人
     * @return last_updateor 修改人
     */
    public String getLastUpdateor() {
        return lastUpdateor;
    }

    /**
     * 修改人
     * @param lastUpdateor 修改人
     */
    public void setLastUpdateor(String lastUpdateor) {
        this.lastUpdateor = lastUpdateor == null ? null : lastUpdateor.trim();
    }

	public String getsPrice() {
		return sPrice;
	}

	public void setsPrice(String sPrice) {
		this.sPrice = sPrice;
	}
    
    
}