package com.huijin.controller;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * 球形摄像头云台辅助控制接口
 */
@Controller
public class MonitorController {


    @GetMapping("/isapi/continuous")
    @ResponseBody
        public String sendPutRequest(String ip, String port, String channel, String username, String password, String pan, String tilt) {
        String url = "http://" + ip + ":" + port + "/ISAPI/PTZCtrl/channels/" + channel + "/continuous";
        try {
            return sendPutRequest(url, username, password, pan, tilt);
        } catch (IOException e) {
            e.printStackTrace();
            return "调用云台辅助控制异常，请检查参数或联系管理员。";
        }
    }


    private static String sendPutRequest(String url, String username, String password, String pan, String tilt) throws IOException {
        HttpClient client = new HttpClient();
        // 设置用户名和密码
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username, password);
        client.getState().setCredentials(AuthScope.ANY, creds);
        PutMethod method = new PutMethod(url);

        String xmlStr = "<?xml version: \"1.0\" encoding=\"UTF-8\"?><PTZData><pan>" + pan + "</pan><tilt>" + tilt + "</tilt></PTZData>";

        RequestEntity requestEntity = new StringRequestEntity(xmlStr, "application/xml", "utf-8");
        method.setRequestEntity(requestEntity);
        client.executeMethod(method);
        byte[] responseData = method.getResponseBodyAsString().getBytes(method.getResponseCharSet());
        String strResponseData = new String(responseData, "utf-8");
        method.releaseConnection();
        sendStopPutRequest(url);
        return strResponseData;
    }

    private static void sendStopPutRequest(String url) throws IOException {
        HttpClient client = new HttpClient();
        // 设置用户名和密码
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials("admin", "st852645");
        client.getState().setCredentials(AuthScope.ANY, creds);
        PutMethod method = new PutMethod(url);

        String xmlStr = "<?xml version: \"1.0\" encoding=\"UTF-8\"?><PTZData><pan>0</pan><tilt>0</tilt></PTZData>";

        RequestEntity requestEntity = new StringRequestEntity(xmlStr, "application/xml", "utf-8");
        method.setRequestEntity(requestEntity);
        client.executeMethod(method);
        method.getResponseBodyAsString().getBytes(method.getResponseCharSet());
        method.releaseConnection();
    }

}
