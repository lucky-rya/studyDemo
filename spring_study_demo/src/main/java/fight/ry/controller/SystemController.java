package fight.ry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
@Controller
@CrossOrigin
public class SystemController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(String username,String password){
        Map<String,Object> map = new HashMap<String, Object>();
        if(null !=username && null!= password ){
            if("ry".equalsIgnoreCase(username)){
                if("123".equalsIgnoreCase((password))){
                    map.put("data","登录成功");
                }else{
                    map.put("data","用户名或者密码错误");

                }

            }else{
                map.put("data","用户名或者密码错误");
            }
        }else{
            map.put("data","用户名或者密码不能为空");
        }
        return  map;
    }
}
