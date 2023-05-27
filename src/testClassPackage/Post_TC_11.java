package testClassPackage;
import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import commonFunctionPackage.API_Common_Function;
import commonFunctionPackage.Utility_Common_Function;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.Post_Req_Repository;
//import testclassPackage1.post_tc_11;

public class Post_TC_11 {
	public static void execute() throws IOException 
	{ 
		 for(int i=0;i<5;i++)
		 {
			 String baseURI=Post_Req_Repository.base_URI();
			 String requestBody=Post_Req_Repository.request_Body11();
			 String resource=Post_Req_Repository.resource();
			 
			 int statusCode=API_Common_Function.res_statusCode(baseURI, requestBody, resource);
			 if(statusCode==201)
			 {
				 String responseBody=API_Common_Function.res_responseBody(baseURI, requestBody, resource);
				 Post_TC_11.validator(statusCode, requestBody, responseBody);
				 Utility_Common_Function .evidencefilecreater("Post_TC_11", requestBody, responseBody);
				 break;
			 }
			 else
			 {
				 System.out.println("correct status code is not find hence retrying the API");	
			 }
		 }
		 }
		 public static void validator(int statusCode,String requestBody,String responseBody)
		 {
			 JsonPath jspres=new JsonPath(responseBody);
		     String res_name=jspres.getString("name");
		     String res_job=jspres.getString("job");
		     int res_id=jspres.getInt("id");
		     String res_createdAt=jspres.getString("createdAt");
		     res_createdAt=res_createdAt.substring(0,11);
		     
		     JsonPath jspreq=new JsonPath(requestBody);
		     String req_name=jspreq.getString("name");
		     String req_job=jspreq.getString("job");
		     LocalDateTime Date=LocalDateTime.now();
		     String exp_Date=Date.toString().substring(0,11);
		   
		     Assert.assertEquals(statusCode,201);
		     Assert.assertEquals(res_name,req_name);
		     Assert.assertEquals(res_job,req_job);
		     Assert.assertEquals(res_createdAt,exp_Date);
		     Assert.assertNotNull(res_id);
		     
		 
	}
 
	
}
