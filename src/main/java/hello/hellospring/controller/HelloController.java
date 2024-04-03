package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return new String("hello");
    }
    

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
    
    @GetMapping("hello-string")
    @ResponseBody  // http 바디부분으로 반환하겠다. 
    public String helloString(@RequestParam(required = false) String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody  // http 바디부분으로 반환하겠다. 
    public Hello helloApi(@RequestParam(required = false) String name) {
        Hello hello = new Hello();
        hello.setNeme(name);
        return hello;

    }

    static class Hello {
        private String neme;
        public String getNeme() {
            return neme;
        }
        public void setNeme(String neme) {
            this.neme = neme;
        }
        
    }


}