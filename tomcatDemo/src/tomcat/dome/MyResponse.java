package tomcat.dome;

import java.io.IOException;
import java.io.OutputStream;

//ʵ���Լ�����Ӧ��
public class MyResponse {
	//���������
	private OutputStream outputStream;
	
	//���캯�� ���������
	public MyResponse(OutputStream outputStream) {
		this.outputStream=outputStream;
	}
	
	//����д������
	public void write(String content)throws IOException{
		//�������Ҫд�����ݵ�����
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("HTTP/1.1 200 OK\r\n")
		.append("Content-type:text/html\r\n")
		.append("\r\n")
        .append("<html><head><title>Hello World</title></head><body>")
        .append(content)
        .append("</body><html>");
		
		//ת�����ֽ����� ������д��
		outputStream.write(stringBuffer.toString().getBytes());
		//System.out.println("sss");
		outputStream.close();
	}
	
}
