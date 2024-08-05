package org.scoula.dynamicweb.controller;

import lombok.extern.log4j.Log4j;
import org.scoula.dynamicweb.dto.SampleDTO;
import org.scoula.dynamicweb.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController {
    @RequestMapping
    public void basic() {
        log.info("basic..............");
    }

    @RequestMapping(value="/basic", method={RequestMethod.GET, RequestMethod.POST})
    public void basicGet() {
        log.info("basic get.........");
    }

    @GetMapping("/basicOnlyGet") // url: /sample/basicOnlyGet
    public void basicGet2()  {
        log.info("basic get2...........");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {
        log.info("" + dto);
        return  "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(
            @RequestParam("name") String name,
            @RequestParam("age") int age) {
        log.info("name: " + name);
        log.info("age: " + age);

        return "ex02";
    }

    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids ){
        log.info("ids: " + ids);
        return "ex02List";
    }
//    @GetMapping("/ex02List")
//    public String ex02List(@RequestParam("ids") String[] ids){
//        log.info("array ids: " + Arrays.toString(ids));
//        return "ex02List";
//    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
        log.info("todo: " + todo);
        return "ex03";
    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
        log.info("dto: " + dto);
        log.info("page: " + page);

        return "sample/ex04";
    }
}
