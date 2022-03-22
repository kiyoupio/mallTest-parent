package com.yangpai.gateway.controller;

import com.yangpai.gateway.component.GateWayApiDocs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger.web.*;

import java.util.List;

/**
 * swagger聚合操作器
 * @author kuangyoupeng1
 * @date 2022.3.15
 */
@RestController
@RequestMapping("/swagger-resources")
public class SwaggerResourceController {
    /**
     * swagger聚合类
     */
    @Autowired
    private GateWayApiDocs gateWayApiDocs;

    @GetMapping
    public ResponseEntity<List<SwaggerResource>> swaggerResources() {
        return new ResponseEntity<>(gateWayApiDocs.get(), HttpStatus.OK);
    }
}
