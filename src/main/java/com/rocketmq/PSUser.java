package com.rocketmq;


/**
 * 修改手机号传过来的数据
 */
public class PSUser {
    private String USERKEY;
    private String PHONE;


    public String getUSERKEY() {
        return USERKEY;
    }

    public void setUSERKEY(String USERKEY) {
        this.USERKEY = USERKEY;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }
}
