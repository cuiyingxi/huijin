package com.huijin.model;

import java.util.List;

/**
 * 全量人员定位实时数据 请求参数
 */
public class LocationRequestVO {

    private int count;

    private List<PersonLocationInfo> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<PersonLocationInfo> getData() {
        return data;
    }

    public void setData(List<PersonLocationInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LocationRequestVO{" +
                "count=" + count +
                ", data=" + data +
                '}';
    }
}
