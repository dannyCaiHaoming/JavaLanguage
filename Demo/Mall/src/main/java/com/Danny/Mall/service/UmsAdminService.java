package com.Danny.Mall.service;


import com.Danny.Mall.mbg.model.UmsAdmin;
import com.Danny.Mall.mbg.model.UmsPermission;

import java.util.List;

public interface UmsAdminService {


    UmsAdmin getAdminByUsername(String username);


    UmsAdmin register(UmsAdmin umsAdminParam);

    String login(String username, String password);


    List<UmsPermission> getPermissionList(Long userId);


}
