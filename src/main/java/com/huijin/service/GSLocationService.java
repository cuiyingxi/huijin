package com.huijin.service;

import com.huijin.model.PersonLocationInfo;

import java.util.List;

public interface GSLocationService {

    void saveData(List<PersonLocationInfo> personLocationInfoList);

    List<PersonLocationInfo> getLocationDataInfos();
}
