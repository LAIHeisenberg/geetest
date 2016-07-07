package actions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by LaiDaShen on 2016/7/7.
 */
@Controller
public class TestAction {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        System.out.println("success..");
        return "result";
    }
}
