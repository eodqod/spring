package kr.human.di.app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import kr.human.di.vo.EmployeeVO;

public class EmployeeVOMain {
	public static void main(String[] args) {
		
        Resource resource = new ClassPathResource(
            "EmployeeVO.xml");
 
        // Creating an object of BeanFactory class
        @SuppressWarnings("deprecation")
		BeanFactory factory = new XmlBeanFactory(resource);
 
        // Creating an object of Employee class
        EmployeeVO e = (EmployeeVO)factory.getBean("emp");
 
        // Calling print() method inside main() method
        e.display();
		
	}
}
