import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.api.utils.HttpClientUtil;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class HttpClientUtilsTest {
    public String sign=null;
    @Test
    public void httpGet(){
        String result = HttpClientUtil.get("http://api.nnzhp.cn/api/user/stu_info?stu_name=test001",new HashMap<String, String>());
        System.out.println(result);
    }


    @Test
    public void login(){
        Map<String, Object> params=new HashMap<>();
        params.put("username","niuhanyang");
        params.put("passwd","aA123456");
        String result = HttpClientUtil.postForm("http://api.nnzhp.cn/api/user/login", params, new HashMap<>());
        System.out.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        sign = (String) JSONPath.eval(jsonObject, "$.login_info.sign");

    }

    @Test(dependsOnMethods = {"login"})
    public void httpPostForm2(){
        Map<String, Object> params = new HashMap<>();
        params.put("stu_id","4058");
        params.put("gold","100");
        Map<String, Object> heads = new HashMap<>();
        heads.put("cookie:niuhanyang=",sign);
        String result = HttpClientUtil.postForm("http://api.nnzhp.cn/api/user/login",params,new HashMap<>());
        System.out.println(result);
    }
    @Test
    public void httpPostJson(){
        String json="{\"name\":\"micr067\",\n" +
                "    \"grade\":\"白羊座\",\n" +
                "    \"phone\":13888888880,\n" +
                "    \"sex\":\"男\",\n" +
                "    \"age\":26,\n" +
                "    \"addr\":\"北京市朝阳区\"}";
        String result = HttpClientUtil.postJson("http://api.nnzhp.cn/api/user/login",json);
        System.out.println(result);
    }
}
