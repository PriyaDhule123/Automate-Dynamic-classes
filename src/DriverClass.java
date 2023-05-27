import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import commonFunctionPackage.Utility_Common_Function;
//import commonFunctionPackage1.Utility_common_Function;

public class DriverClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		//post_tc_11.execute();
				ArrayList<String> testcaserun=Utility_Common_Function.readDataExcel("postrunner","testcasetoexecute");
						
					
				int count =testcaserun.size();
				System.out.println(count);
				for (int i=1;i<count;i++)
				{
				String testcasename=testcaserun.get(i);
				System.out.println(testcasename);
				// call the testcaseclass on runtime by using java.lang.reflect package
				Class<?> testclassname=Class.forName("testClassPackage."+testcasename);
				// call the execute method belonging to test class captured in variable testclassname by using java.lang.reflect.method class
				Method executemethod=testclassname.getDeclaredMethod("execute");
				// set the accessibility of method true 
				executemethod.setAccessible(true);
				// create the instance of testclass captured in variable name testclassname
				Object instanceoftestclass=testclassname.getDeclaredConstructor().newInstance();
				// execute the testclass captured in variable name testclass name
				executemethod.invoke(instanceoftestclass);
				
				}
	}

}
