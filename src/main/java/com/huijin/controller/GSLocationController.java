package com.huijin.controller;

import com.alibaba.fastjson.JSON;
import com.huijin.model.LocationRequestVO;
import com.huijin.model.LocationResponseVO;
import com.huijin.model.PersonLocationInfo;
import com.huijin.service.GSLocationService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 甘肃项目 -- 人员定位系统接口controller
 */
@Controller
public class GSLocationController {

    @Autowired
    private GSLocationService locationService;


    @PostMapping("/api/uploadLocationDataList")
    @ResponseBody
    public String uploadLocationDataList(@RequestBody String json) {
        // 1.接收参数 转换实体
        LocationRequestVO requestVO = JSON.parseObject(json, LocationRequestVO.class);
        // 2.实体持久化
        // System.out.println(requestVO);
        locationService.saveData(requestVO.getData());

        LocationResponseVO responseVO = new LocationResponseVO();
        responseVO.setData("accept ok!");
        responseVO.setCode(200);
        responseVO.setInfo("success");
        return JSON.toJSONString(responseVO);
    }

    @GetMapping("/getLocationDataList")
    @ResponseBody
    public String getLocationDataList() {
        LocationRequestVO vo = new LocationRequestVO();
        List<PersonLocationInfo> infos = locationService.getLocationDataInfos();
        if (CollectionUtils.isNotEmpty(infos)) {
            vo.setCount(infos.size());
            vo.setData(infos);
        } else {
            vo.setCount(0);
        }
        return JSON.toJSONString(vo);
    }
}
