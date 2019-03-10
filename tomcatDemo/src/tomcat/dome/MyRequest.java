package tomcat.dome;

import java.io.IOException;
import java.io.InputStream;

//实现自己的请求类
public class MyRequest {
	//请求的url
	private String url;
	//请求的方法类型
	private String method;
	
	//构造函数 传入一个输入流
	public MyRequest(InputStream inputStream) throws IOException {
		//用于存放http请求内容的容器
		StringBuilder httpRequest=new StringBuilder();
		//用于从输入流中读取数据的字节数组
		byte[]httpRequestByte=new byte[1024];
		int length=0;
		//将输入流中的内容读到字节数组中，并且对长度进行判断
		if((length=inputStream.read(httpRequestByte))>0) {
			//证明输入流中有内容，则将字节数组添加到容器中
			httpRequest.append(new String(httpRequestByte,0,length));
		}
		//将容器中的内容打印出来
		System.out.println("httpRequest = [ "+httpRequest+" ]");
		
		
		//从httpRequest中获取url，method存储到myRequest中
		String httpHead=httpRequest.toString().split("\n")[0];
		url=httpHead.split("\\s")[1];
		method=httpHead.split("\\s")[0];
		System.out.println("MyRequests = [ "+this+" ]");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
}
