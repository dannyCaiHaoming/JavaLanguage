package com.Danny.Mall.controller;


import com.Danny.Mall.common.api.CommonResult;
import com.Danny.Mall.dto.UmsAdminLoginParam;
import com.Danny.Mall.mbg.model.UmsAdmin;
import com.Danny.Mall.mbg.model.UmsPermission;
import com.Danny.Mall.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService adminService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @GetMapping(value = "/hello")
    @ResponseBody
    public CommonResult Hello(){
        return CommonResult.success("Hello");
    }

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult result){
        UmsAdmin umsadmin = adminService.register(umsAdminParam);
        if (umsadmin == null) {
            CommonResult.failed("注册用户失败");
        }
        return CommonResult.success(umsadmin);
    }


    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam,
                              BindingResult bindingResult) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return CommonResult.success(tokenMap);
    }


    @ApiOperation(value = "获取用户所有权限")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsPermission>> getPermissinoList(@PathVariable Long adminId) {
        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }






















}
