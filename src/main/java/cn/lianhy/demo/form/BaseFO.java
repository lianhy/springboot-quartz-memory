package cn.lianhy.demo.form;

import java.io.Serializable;

public class BaseFO implements Serializable{

    private Integer pageIndex;

    private Integer limitBegin;

    private Integer pageSize;

    private String createDate;

    private String updateDate;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getLimitBegin() {
        return limitBegin;
    }

    public void setLimitBegin(Integer limitBegin) {
        this.limitBegin = limitBegin;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
