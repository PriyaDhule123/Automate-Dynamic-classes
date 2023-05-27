package requestRepositoryPackage;

import java.io.IOException;
import java.util.ArrayList;

import commonFunctionPackage.Utility_Common_Function;
//import commonFunctionPackage.Utility_Coomon_Fuction;

public class Post_Req_Repository {
	public static String base_URI() {
		String baseURI="https://reqres.in/";
		return baseURI;
	}
	public static String request_Body11() throws IOException {
		 ArrayList<String> data=Utility_Common_Function.readDataExcel("Post_Test_Data","Post_TC_11");
			
		  String req_name= data.get(1);                  
		  String req_job=data.get(2);
		String requestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return requestBody;	
	}
	public static String request_Body12() throws IOException {
		 ArrayList<String> data=Utility_Common_Function.readDataExcel("Post_Test_Data","Post_TC_12");
			
		  String req_name= data.get(1);                  
		  String req_job=data.get(2);
		String requestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return requestBody;	
	}
	public static String request_Body13() throws IOException {
		 ArrayList<String> data=Utility_Common_Function.readDataExcel("Post_Test_Data","Post_TC_13");
			
		  String req_name= data.get(1);                  
		  String req_job=data.get(2);
		String requestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return requestBody;	
	}
	public static String resource() {
		String resource="api/users";
		return resource;
	}

}
