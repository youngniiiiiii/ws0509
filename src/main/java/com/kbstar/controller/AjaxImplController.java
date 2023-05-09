package com.kbstar.controller;

import com.kbstar.dto.Sales;
import com.kbstar.service.SalesService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class AjaxImplController {
    @Autowired
    SalesService salesService;

    @RequestMapping("/chartarea")
    public Object chartarea() {

        List<Sales> list = null;
        list = salesService.sumsales();

        JSONArray MALE = new JSONArray();
        JSONArray FEMALE = new JSONArray();
        for (Sales obj : list) {
            if (obj.getGender().equals("M")) {
                MALE.add(obj.getPrice());
            } else {
                FEMALE.add(obj.getPrice());
            }
        }

        JSONObject jo = new JSONObject();
        jo.put("male", MALE);
        jo.put("female", FEMALE);
        log.info(jo.toJSONString());
        return jo;
    }

    ;
};