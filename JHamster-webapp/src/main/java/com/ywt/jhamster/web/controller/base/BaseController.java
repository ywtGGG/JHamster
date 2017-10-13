package com.ywt.jhamster.web.controller.base;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 基础Controller
 * @author yuwentao
 *
 */
@Controller
@RequestMapping(value="/index")
public class BaseController {
	
	@RequestMapping("/hello")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

}
