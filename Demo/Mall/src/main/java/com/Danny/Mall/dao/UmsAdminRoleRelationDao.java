package com.Danny.Mall.dao;


import com.Danny.Mall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsAdminRoleRelationDao {

    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);

}
