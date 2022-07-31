package com.leran.satokengateway.component;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import com.learn.satokencommon.domain.UserDTO;

import java.util.List;

/**
 * @Author:liwy
 * @date: 22.7.30
 * @Version:1.0
 */
public class StpInterfaceImpl implements StpInterface {
    @Override
    public List<String> getPermissionList(Object o, String s) {
        UserDTO userInfo = (UserDTO)StpUtil.getSession().get("userInfo");
        return userInfo.getPermissionList();
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        // 角色码
        return null;
    }
}
