package tomcat.dome;

//дһ����������Ϊservlet�ĸ���
public abstract class MyServlet {
	//��Ҫ����ʵ�ֵĳ��󷽷�
	protected abstract void doGet(MyRequest request,MyResponse response);
	protected abstract void doPost(MyRequest request,MyResponse response);
	
	//�����Լ��ķ���
	//�����service�����Դ����request�Լ�response
	//�ķ������ͽ����жϣ��ɴ˵���doGet��doPost����
	public void service(MyRequest request,MyResponse response) throws NoSuchMethodException {
		if(request.getMethod().equalsIgnoreCase("POST")) {
			doPost(request, response);
		}else if(request.getMethod().equalsIgnoreCase("GET")) {
			doGet(request, response);
		}else {
			throw new NoSuchMethodException("not support");
		}
	}
}
