package tomcat.dome;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


//Tomcat�������� ��д���������ַ����������߼�
public class MyTomcat {
	//�˿ں�
	private int port=8080;
	//���ڴ������·�����Ӧ��servlet�������ӳ���ϵ��map
	//��Ӧ����Ϣ���������л�ȡ
	private Map<String, String>urlServletMap=new HashMap<>(16);
	//���췽��
	public MyTomcat(int port) {
		this.port=port;
	}
	
	//tomcat����������������
	public void start() {
		//��ʼ������ӳ���ϵ
		initServletMapping();
		//����˵��׽���
		ServerSocket serverSocket=null;
		try {
			//�����󶨵�ĳ���˿ڵķ�����׽���
			serverSocket=new ServerSocket(port);
			System.out.println("MyTomcat begin start...");
			//ѭ�� ���ڽ��տͻ���
			while(true) {
				//���յ��Ŀͻ��˵��׽���
				Socket socket=serverSocket.accept();
				//��ȡ�ͻ��˵����������
				InputStream inputStream=socket.getInputStream();
				OutputStream outputStream=socket.getOutputStream();
				//ͨ�����������������������Ӧ����
				MyRequest request=new MyRequest(inputStream);
				MyResponse response=new MyResponse(outputStream);
				
				//������������method�ַ����� ������Ӧ�ķ���
				dispatch(request, response);
				//�رտͻ����׽���
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//��ʼ������ӳ���ϵ�������Ϣ���������л�ȡ
	private void initServletMapping() {
		for(ServletMapping servletMapping:ServletMappingConfig.servletMappings) {
			urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
		}
	}
	
	//ͨ����ǰ��request�Լ�response����ַ�����
	private void dispatch(MyRequest request,MyResponse response) {
		//���������url��ȡ��Ӧ��servlet���string
		String clazz=urlServletMap.get(request.getUrl());
		//System.out.println("====="+clazz);
		try {
			//ͨ�����string����ת��Ϊ����
			Class servletClass=Class.forName("tomcat.dome.StudentServlet");
			//ʵ����һ������
			MyServlet myServlet=(MyServlet)servletClass.newInstance();
			
			//���ø��෽��������request��method�Ե��÷��������ж�
			//��ɶ�myServlet��doGet��doPost�����ĵ���
			myServlet.service(request, response);
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
	}
	
	//main����  ֱ������tomcat������
	public static void main(String[] args) {
		new MyTomcat(8080).start();
	}
	
}
