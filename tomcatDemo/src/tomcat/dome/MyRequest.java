package tomcat.dome;

import java.io.IOException;
import java.io.InputStream;

//ʵ���Լ���������
public class MyRequest {
	//�����url
	private String url;
	//����ķ�������
	private String method;
	
	//���캯�� ����һ��������
	public MyRequest(InputStream inputStream) throws IOException {
		//���ڴ��http�������ݵ�����
		StringBuilder httpRequest=new StringBuilder();
		//���ڴ��������ж�ȡ���ݵ��ֽ�����
		byte[]httpRequestByte=new byte[1024];
		int length=0;
		//���������е����ݶ����ֽ������У����ҶԳ��Ƚ����ж�
		if((length=inputStream.read(httpRequestByte))>0) {
			//֤���������������ݣ����ֽ�������ӵ�������
			httpRequest.append(new String(httpRequestByte,0,length));
		}
		//�������е����ݴ�ӡ����
		System.out.println("httpRequest = [ "+httpRequest+" ]");
		
		
		//��httpRequest�л�ȡurl��method�洢��myRequest��
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
