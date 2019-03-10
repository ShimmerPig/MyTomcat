package tomcat.dome;

import java.io.IOException;

//实现自己业务相关的Servlet
public class StudentServlet extends MyServlet{

	@Override
	protected void doGet(MyRequest request, MyResponse response) {
		//利用response中的输出流 写出内容
		try {
			//System.out.println("!!!!!!!!!!!!!!!!!!");
			response.write("I am a student.");
			//System.out.println("9999999999999999");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(MyRequest request, MyResponse response) {
		//利用response中的输出流 写出内容
		try {
			response.write("I am a student.");
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}

}
