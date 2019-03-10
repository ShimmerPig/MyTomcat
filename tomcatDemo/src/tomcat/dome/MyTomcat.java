package tomcat.dome;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


//Tomcat服务器类 编写对请求做分发处理的相关逻辑
public class MyTomcat {
	//端口号
	private int port=8080;
	//用于存放请求路径与对应的servlet类的请求映射关系的map
	//相应的信息从配置类中获取
	private Map<String, String>urlServletMap=new HashMap<>(16);
	//构造方法
	public MyTomcat(int port) {
		this.port=port;
	}
	
	//tomcat服务器的启动方法
	public void start() {
		//初始化请求映射关系
		initServletMapping();
		//服务端的套接字
		ServerSocket serverSocket=null;
		try {
			//创建绑定到某个端口的服务端套接字
			serverSocket=new ServerSocket(port);
			System.out.println("MyTomcat begin start...");
			//循环 用于接收客户端
			while(true) {
				//接收到的客户端的套接字
				Socket socket=serverSocket.accept();
				//获取客户端的输入输出流
				InputStream inputStream=socket.getInputStream();
				OutputStream outputStream=socket.getOutputStream();
				//通过输入输出流创建请求与响应对象
				MyRequest request=new MyRequest(inputStream);
				MyResponse response=new MyResponse(outputStream);
				
				//根据请求对象的method分发请求 调用相应的方法
				dispatch(request, response);
				//关闭客户端套接字
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//初始化请求映射关系，相关信息从配置类中获取
	private void initServletMapping() {
		for(ServletMapping servletMapping:ServletMappingConfig.servletMappings) {
			urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
		}
	}
	
	//通过当前的request以及response对象分发请求
	private void dispatch(MyRequest request,MyResponse response) {
		//根据请求的url获取对应的servlet类的string
		String clazz=urlServletMap.get(request.getUrl());
		//System.out.println("====="+clazz);
		try {
			//通过类的string将其转化为对象
			Class servletClass=Class.forName("tomcat.dome.StudentServlet");
			//实例化一个对象
			MyServlet myServlet=(MyServlet)servletClass.newInstance();
			
			//调用父类方法，根据request的method对调用方法进行判断
			//完成对myServlet中doGet与doPost方法的调用
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
	
	//main方法  直接启动tomcat服务器
	public static void main(String[] args) {
		new MyTomcat(8080).start();
	}
	
}
