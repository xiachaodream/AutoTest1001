import com.alibaba.fastjson.JSONPath;
import com.api.services.LoginService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginTest {
    @Test(description = "登录正常用例")
    public void login(){
        HashMap<String, String> heads = new HashMap<>();
        heads.put("X-Requested-With","XMLHttpRequest");
        String result = LoginService.login("xiachao", "123456", heads);
        String code = JSONPath.extract(result, "$.code").toString();
        Assert.assertEquals(code,"0");
    }
}
