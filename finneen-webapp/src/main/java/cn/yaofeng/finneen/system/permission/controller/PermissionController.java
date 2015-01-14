package cn.yaofeng.finneen.system.permission.controller;

import cn.yaofeng.finneen.system.permission.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Finneen on 2015/1/12.
 */
@RestController
@RequestMapping(value = "/perm")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/list")
    public Object list() {
        return permissionService.findAll();
    }
}
