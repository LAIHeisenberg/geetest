package actions;

import com.geetest.sdk.java.GeetestConfig;
import com.geetest.sdk.java.GeetestLib;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by LaiDaShen on 2016/7/7.
 */
@Controller
public class StartCaptchaAction {

    @RequestMapping(value = "/startCaptcha",method = RequestMethod.GET)
    public void startCaptcha(HttpServletRequest request, HttpServletResponse response){
        GeetestLib gtSdk = new GeetestLib(GeetestConfig.getCaptcha_id(), GeetestConfig.getPrivate_key());

        String resStr = "{}";

        //自定义userid
        String userid = "test";

        //进行验证预处理
        int gtServerStatus = gtSdk.preProcess(userid);

        //将服务器状态设置到session中
        request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
        //将userid设置到session中
        request.getSession().setAttribute("userid", userid);

        resStr = gtSdk.getResponseStr();

        PrintWriter out = null;
        try{
            out = response.getWriter();
        }catch (IOException e){
            e.printStackTrace();
        }
        out.println(resStr);
    }
}
