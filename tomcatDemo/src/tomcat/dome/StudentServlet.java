package tomcat.dome;

import java.io.IOException;

//ʵ���Լ�ҵ����ص�Servlet
public class StudentServlet extends MyServlet{

	@Override
	protected void doGet(MyRequest request, MyResponse response) {
		//����response�е������ д������
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
		//����response�е������ д������
		try {
			response.write("I am a student.");
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}

}
