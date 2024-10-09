package com.sangeng.expression;

import com.sangeng.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @create: Rock Wang  2024-10-09 11:01
 **/

@Component("ex")
public class SGExpressionRoot {

    public boolean hasAuthority(String authority){
        // 获取当前用户的权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();
        List<String> permissions = loginUser.getPermissions();
        // 判断用户权限集合中是否存在authority 少了SimpleGrantedAuthority的转换
        return permissions.contains(authority);
    }
}
