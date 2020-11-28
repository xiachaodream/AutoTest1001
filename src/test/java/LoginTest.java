import com.alibaba.fastjson.JSONPath;
import com.api.services.LoginService;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginTest {
    private Logger logger = Logger.getLogger(LoginTest.class);
    @Test(description = "登录正常用例")
    public void login(){
        HashMap<String, String> heads = new HashMap<>();
        heads.put("X-Requested-With","XMLHttpRequest");
        String result = LoginService.login("xiachao", "123456", heads);
        String code = JSONPath.extract(result, "$.code").toString();
        logger.info(code);
        Assert.assertEquals(code,"0");
    }
}
