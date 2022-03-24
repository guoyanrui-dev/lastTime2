package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import com.example.demo.test.RequestUtil;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author guoyanrui on 2021/8/17
 */
@Controller
@RequestMapping("/my")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public List<User> getStaging() {
        return userService.getAllUser();
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public void test() throws IOException {
        new RequestUtil().sendGet("http://baidu.com");
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addUser(@RequestParam(value = "id") int id,
                          @RequestParam(value = "name") String name,
                          @RequestParam(value = "password") String password) {

        int res = userService.insert(id, name, password);
        if (res > 0) {
            return "增加成功";
        } else {
            return "插入失败";
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String del(@RequestParam(value = "id") int id) {
        int res = userService.deleteUser(id);
        if (res > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public User getUserId(@RequestParam(value = "id") int id) {
        return userService.selectOne(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(@RequestParam(value = "id") int id,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "password") String password) {

        int res = userService.update(id, name, password);
        if (res > 0) {
            return "更新成功";
        } else {
            return "更新失败";
        }
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getmain() {
        return "index";
    }

    @ExceptionHandler(Exception.class)
    public String exception() {
        return "error";
    }
}
