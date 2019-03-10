package tomcat.dome;

import java.util.ArrayList;
import java.util.List;

//创建一个存储有请求路径与servlet的对应关系的 映射关系配置类
public class ServletMappingConfig {
	//使用一个list类型 里面存储的是映射关系类Mapping
	public static List<ServletMapping>servletMappings=new ArrayList<>(16);
	
	//向其中添加映射关系
	static {
		servletMappings.add(new ServletMapping("student","/student", "tomcat.dome.StudentServlet"));
		servletMappings.add(new ServletMapping("teacher","/teacher", "tomcat.dome.TeacherServlet"));
	}
}
