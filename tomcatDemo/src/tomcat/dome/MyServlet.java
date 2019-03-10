package tomcat.dome;

//写一个抽象类作为servlet的父类
public abstract class MyServlet {
	//需要子类实现的抽象方法
	protected abstract void doGet(MyRequest request,MyResponse response);
	protected abstract void doPost(MyRequest request,MyResponse response);
	
	//父类自己的方法
	//父类的service方法对传入的request以及response
	//的方法类型进行判断，由此调用doGet或doPost方法
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
