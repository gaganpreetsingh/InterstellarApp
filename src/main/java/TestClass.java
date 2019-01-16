import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gagan.util.HibernateUtil;


public class TestClass { 

	public static void main(String[] args)
	{

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();		

		session.close();
		System.out.println("One to Many Annotatios Done...!!!!!!");
		factory.close();
	}

}