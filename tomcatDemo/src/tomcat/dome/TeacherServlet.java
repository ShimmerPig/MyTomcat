package tomcat.dome;

import java.io.IOException;

//ʵ���Լ�ҵ����ص�Servlet
public class TeacherServlet extends MyServlet{

	@Override
	protected void doGet(MyRequest request, MyResponse response) {
		//����response�е������ д������
		try {
			response.write("I am a teacher.");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(MyRequest request, MyResponse response) {
		//����response�е������ д������
		try {
			response.write("I am a teacher.");
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}

}
