package com.nuesoft.po;

public class Admin {
    private int adminid;
    private String adminame;
    private String adminpwd;
    private String status;
    private String remark;
    private String admindate;

    public Admin() {
    }

    public Admin(int adminid, String adminame, String adminpwd,String status, String remark, String admindate) {
        this.adminid=adminid;
        this.adminame =adminame;
        this.adminpwd =adminpwd;
        this.status=status;
        this. remark= remark;
        this.admindate=admindate;
    }

    public int getAdminid() {
        return adminid;
    }

    public String getAdminame() {
        return adminame;
    }

    public String getAdminpwd() {
        return adminpwd;
    }

    public String getStatus() {
        return status;
    }

    public String getRemark() {
        return remark;
    }

    public String getAdmindate() {
        return admindate;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public void setAdminame(String adminame) {
        this.adminame = adminame;
    }

    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setAdmindate(String admindate) {
        this.admindate = admindate;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminid=" + adminid +
                ", adminame='" + adminame + '\'' +
                ", adminpwd='" + adminpwd + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", admindate='" + admindate + '\'' +
                '}';
    }
}