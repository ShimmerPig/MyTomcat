package tomcat.dome;

import java.util.ArrayList;
import java.util.List;

//����һ���洢������·����servlet�Ķ�Ӧ��ϵ�� ӳ���ϵ������
public class ServletMappingConfig {
	//ʹ��һ��list���� ����洢����ӳ���ϵ��Mapping
	public static List<ServletMapping>servletMappings=new ArrayList<>(16);
	
	//���������ӳ���ϵ
	static {
		servletMappings.add(new ServletMapping("student","/student", "tomcat.dome.StudentServlet"));
		servletMappings.add(new ServletMapping("teacher","/teacher", "tomcat.dome.TeacherServlet"));
	}
}
