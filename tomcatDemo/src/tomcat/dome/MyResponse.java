package tomcat.dome;

import java.io.IOException;
import java.io.OutputStream;

//实现自己的响应类
public class MyResponse {
	//定义输出流
	private OutputStream outputStream;
	
	//构造函数 传入输出流
	public MyResponse(OutputStream outputStream) {
		this.outputStream=outputStream;
	}
	
	//创建写出方法
	public void write(String content)throws IOException{
		//用来存放要写出数据的容器
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("HTTP/1.1 200 OK\r\n")
		.append("Content-type:text/html\r\n")
		.append("\r\n")
        .append("<html><head><title>Hello World</title></head><body>")
        .append(content)
        .append("</body><html>");
		
		//转换成字节数组 并进行写出
		outputStream.write(stringBuffer.toString().getBytes());
		//System.out.println("sss");
		outputStream.close();
	}
	
}
