package com.huijin.model;

public class LocationResponseVO {
    private String data;
    private Integer code;
    private String info;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "LocationResponseVO{" +
                "data='" + data + '\'' +
                ", code=" + code +
                ", info='" + info + '\'' +
                '}';
    }
}
