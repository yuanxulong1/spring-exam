package p.yxl;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("mvc")
public class HelloController {

    @RequestMapping("/hello")
    private String hello() {
        return "hello";
    }
}
