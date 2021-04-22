package com.hyun.book.springboot.web;

import com.hyun.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// JSON 변환 컨트롤러로 만들어 줌. 원래는 각 메소드마다 @ResponseBody를 선언해야 했지만 한 번에 사용하도록
@RestController
public class HelloController {
    @GetMapping("/hello")   // 원래 @RequestMapping(method=RequestMethod.GET)으로 사용했었음
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        // RequestParam: 외부에서 API로 넘긴 인자를 가져오는 annotation
        // 즉 name과 amount는 API를 호출하는 곳에서 넘겨준 값들임
        // 외부에서 name (@RequestParam("name") 이란 이름으로 넘긴 인자를 helloDto의 인자 name(String name)에 저장하게 됨
        return new HelloResponseDto(name, amount);
    }
}
