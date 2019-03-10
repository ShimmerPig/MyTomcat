package tomcat.dome;

//请求url与项目中的servlet的映射关系
public class ServletMapping {
	//servlet的名字
	private String servletName;
	//请求的url
	private String url;
	//servlet类
	private String clazz;
	public String getServletName() {
		return servletName;
	}
	public void setServletName(String servletName) {
		this.servletName = servletName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public ServletMapping(String servletName, String url, String clazz) {
		super();
		this.servletName = servletName;
		this.url = url;
		this.clazz = clazz;
	}
}
