package com.rondollete.springreacttemplate.controllers;

import com.rondollete.springreacttemplate.services.SanityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/sanity", produces = "application/json")
public class SanityCheckController {

    @GetMapping("/service/{pathVariable}")
    public HashMap<String, String> service(@PathVariable String pathVariable) {
        return SanityService.process(pathVariable);
    }

    @GetMapping("/ip")
    public HashMap<String, String> ip() throws UnknownHostException {
        HashMap<String, String> map = new HashMap<>();
        map.put("ip", InetAddress.getLocalHost().getHostAddress());
        map.put("hostname", InetAddress.getLocalHost().getHostName());
        return map;
    }
}
