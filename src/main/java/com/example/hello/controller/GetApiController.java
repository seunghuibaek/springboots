package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    @GetMapping(path="/hello")      // http://localhost:9090/api/get/hello
    public String hello() {
        return "get Hello";
    }

    // 예전 방식
    @RequestMapping(path="hi", method = RequestMethod.GET)       // get http://localhost:9090/api/get/hi
    public String hi() {
        return "hi";
    }

    // http://localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{id}")        // {name} 과 아래 변수는 같아야 함
    public String pathVariable(@PathVariable(name = "id") String pathName) {
        System.out.println("PathVariable : "+ pathName);
        return pathName;
    }

    // http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });
        return sb.toString();
    }

    // 명시적으로 값을 받음
    @GetMapping("query-param02")
    public String queryParam02(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;
    }
}
