package com.xuyueqi.controller;

import com.xuyueqi.model.User;
import com.xuyueqi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * create by xuyueqi on 2018/5/5
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("add")
    public int addUser(User user){
        return userService.addUser(user);
    }

    @ResponseBody
    @PostMapping("/all")
    public Object findAllUser(@RequestParam(name="pageNum",required = false,defaultValue = "1") int pageNum,
                              @RequestParam(name="pageSize",required = false,defaultValue = "10") int pageSize){
        log.info("test info");
        log.debug("test debug");
        return userService.findAllUser(pageNum,pageSize);
    }


    @PostMapping("test")
    @ResponseBody
    public Object testGet() throws IOException {
        String url = "http://chy.qrwei.com/index.php?g=Portal&m=Nbch&a=getAuthcode&mobile=15858432400";
//        String url = "http://localhost:8080/user/all";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request  = new Request.Builder().url(url).addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.78 Safari/537.36").build();
        Response response = okHttpClient.newCall(request).execute();
        okhttp3.ResponseBody responseBody = response.body();
        byte[] bytein  = responseBody.bytes();
        String s1 = new String(bytein,"GB2312");
        log.info(s1);
        return s1;
    }
}
