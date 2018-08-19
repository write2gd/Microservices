package com.gd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RefreshScope
@RestController
public class FeignEmployeeInfoController {

    @Autowired
    EmployeeServiceProxy proxyService;
    @RequestMapping("/dashboard/feign/{myself}")
    public EmployeeInfo findme(@PathVariable Long myself) {
        return proxyService.findById(myself);
    }
    @RequestMapping("/dashboard/feign/peers")
    public Collection< EmployeeInfo > findPeers() {
        return proxyService.findAll();
    }
}
