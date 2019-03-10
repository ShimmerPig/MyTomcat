package tomcat.dome;

import java.io.IOException;

//实现自己业务相关的Servlet
public class TeacherServlet extends MyServlet{

	@Override
	protected void doGet(MyRequest request, MyResponse response) {
		//利用response中的输出流 写出内容
		try {
			response.write("I am a teacher.");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(MyRequest request, MyResponse response) {
		//利用response中的输出流 写出内容
		try {
			response.write("I am a teacher.");
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}

}
