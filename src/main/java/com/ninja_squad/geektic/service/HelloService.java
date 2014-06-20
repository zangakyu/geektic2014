package com.ninja_squad.geektic.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Fake service just to test that everything works fine
 * @author JB Nizet
 */
@RestController
@Transactional
@RequestMapping("/api/hello")
public class HelloService {

    @RequestMapping(method = GET)
    public HelloMessage sayHello() {
        return new HelloMessage();
    }
}
