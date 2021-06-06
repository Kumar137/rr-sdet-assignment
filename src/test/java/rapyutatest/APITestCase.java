package rapyutatest;

import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.APIUtils;
import utils.CustomListeners;

import java.util.HashMap;

public class APITestCase {

    APIUtils apiUtils;
    @BeforeClass
    public void init()
    {
        apiUtils=new APIUtils();
    }

    @Test
    public void verifyID()
    {

        HashMap<String,String> hmap=new HashMap<String, String>();
        hmap.put("t","Happy Potter");
        hmap.put("token","");
        Response response=apiUtils.getApiRequest(hmap);
        if(response.getStatusCode()!=200)
        {
            CustomListeners.test.log(LogStatus.INFO,response.prettyPrint());
        }
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
