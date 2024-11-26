package com.huijin.model;

import java.math.BigDecimal;

/**
 * 人员定位信息
 */
public class PersonLocationInfo {
    // 报警状态
    private Integer alarm;

    // 标签类型
    private Integer cardType;

    // 标签卡号
    private String cardno;

    // 所属企业ID
    private String companyId;

    // 所属企业名称
    private String companyName;

    // 部门名称
    private String department;

    // 部门ID
    private String deptId;

    // 设备名称
    private String deviceName;

    // 设备SN
    private String deviceSn;

    // 高程
    private String elevation;

    // 性别，男或女
    private String gender;

    // 心率数据，正常范围：0-100，255：非心率设备
    private Integer heartRate;

    // 身份证号码
    private String idNumber;

    // 距离洞口米数
    private BigDecimal inlX;

    // 最后入场时间
    private String lastInTime;

    // 纬度
    private String latitude;

    // 经度
    private String longitude;

    // 距离基站米数
    private BigDecimal masterX;

    // nX坐标
    private BigDecimal nX;

    // nY坐标
    private BigDecimal nY;

    // 血氧
    private Integer oximeter;

    // pX像素坐标
    private BigDecimal pX;

    // pY像素坐标
    private BigDecimal pY;

    // 工号，唯一
    private String personId;

    // 姓名
    private String personName;

    // 电话号码
    private String phone;

    // 桩号
    private String pileNo;

    // 车辆号码
    private String plateNumber;

    // 项目编号
    private String projectId;

    // 区域码
    private String regionCode;

    // 区域ID
    private String regionId;

    // 区域名称
    private String regionName;

    // 环数
    private String ringNum;

    // 停留时长
    private Integer stayTime;

    // 班组ID
    private String teamId;

    // 班组名称
    private String teamName;

    // 更新时间
    private String updateTime;

    // 车辆类型
    private String vehicleType;

    // 标签电量
    private Integer volume;

    // 工种/职务
    private String workTypeName;

    public Integer getAlarm() {
        return alarm;
    }

    public void setAlarm(Integer alarm) {
        this.alarm = alarm;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public BigDecimal getInlX() {
        return inlX;
    }

    public void setInlX(BigDecimal inlX) {
        this.inlX = inlX;
    }

    public String getLastInTime() {
        return lastInTime;
    }

    public void setLastInTime(String lastInTime) {
        this.lastInTime = lastInTime;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getMasterX() {
        return masterX;
    }

    public void setMasterX(BigDecimal masterX) {
        this.masterX = masterX;
    }

    public BigDecimal getnX() {
        return nX;
    }

    public void setnX(BigDecimal nX) {
        this.nX = nX;
    }

    public BigDecimal getnY() {
        return nY;
    }

    public void setnY(BigDecimal nY) {
        this.nY = nY;
    }

    public Integer getOximeter() {
        return oximeter;
    }

    public void setOximeter(Integer oximeter) {
        this.oximeter = oximeter;
    }

    public BigDecimal getpX() {
        return pX;
    }

    public void setpX(BigDecimal pX) {
        this.pX = pX;
    }

    public BigDecimal getpY() {
        return pY;
    }

    public void setpY(BigDecimal pY) {
        this.pY = pY;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPileNo() {
        return pileNo;
    }

    public void setPileNo(String pileNo) {
        this.pileNo = pileNo;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRingNum() {
        return ringNum;
    }

    public void setRingNum(String ringNum) {
        this.ringNum = ringNum;
    }

    public Integer getStayTime() {
        return stayTime;
    }

    public void setStayTime(Integer stayTime) {
        this.stayTime = stayTime;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getWorkTypeName() {
        return workTypeName;
    }

    public void setWorkTypeName(String workTypeName) {
        this.workTypeName = workTypeName;
    }

    @Override
    public String toString() {
        return "PersonLocationInfo{" +
                "alarm=" + alarm +
                ", cardType=" + cardType +
                ", cardno='" + cardno + '\'' +
                ", companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", department='" + department + '\'' +
                ", deptId='" + deptId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceSn='" + deviceSn + '\'' +
                ", elevation='" + elevation + '\'' +
                ", gender='" + gender + '\'' +
                ", heartRate=" + heartRate +
                ", idNumber='" + idNumber + '\'' +
                ", inlX=" + inlX +
                ", lastInTime='" + lastInTime + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", masterX=" + masterX +
                ", nX=" + nX +
                ", nY=" + nY +
                ", oximeter=" + oximeter +
                ", pX=" + pX +
                ", pY=" + pY +
                ", personId='" + personId + '\'' +
                ", personName='" + personName + '\'' +
                ", phone='" + phone + '\'' +
                ", pileNo='" + pileNo + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", projectId='" + projectId + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", regionId='" + regionId + '\'' +
                ", regionName='" + regionName + '\'' +
                ", ringNum='" + ringNum + '\'' +
                ", stayTime=" + stayTime +
                ", teamId='" + teamId + '\'' +
                ", teamName='" + teamName + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", volume=" + volume +
                ", workTypeName='" + workTypeName + '\'' +
                '}';
    }
}
