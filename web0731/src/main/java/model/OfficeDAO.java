package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OfficeDAO {
	EntityManager createManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("web0731");
		return factory.createEntityManager();
	}
	public List<Office> getAll(){
		EntityManager em = createManager();
		em.getTransaction().begin();
		List<Office> data=em.createQuery("select o from Office o").getResultList();
		em.getTransaction().commit();
		em.close();
		return data;
	}

	public boolean saveOffice() {
		EntityManager em = createManager();
		try {
			em.getTransaction().begin();
			
			Office of = new Office();
			of.setOfficeCode("8");
			of.setCity("Taipei");
			of.setPhone("+886 976382291");
			of.setAddressLine1("101 shlin market");
			of.setAddressLine2("floor 4");
			of.setState(null);
			of.setCountry("Taiwan");
			of.setPostalCode("11156");
			of.setTerritory("Taiwan");
			
			Employee e1=new Employee();
			e1.setEmployeeNumber(1851);
			e1.setLastName("Chang");
			e1.setFirstName("Mike");
			e1.setExtension("0x1851");
			e1.setEmail("mike@gmail.com");
			//e1.setOffice(of);
			e1.setReportsTo(1056);
			e1.setJobTitle("Sales Rep");
			Employee e2=new Employee();
			e2.setEmployeeNumber(1852);
			e2.setLastName("Chen");
			e2.setFirstName("Kitty");
			e2.setExtension("0x1852");
			e2.setEmail("kitty@gmail.com");
			//e2.setOffice(of);
			e2.setReportsTo(1056);
			e2.setJobTitle("Sales Rep");
			ArrayList<Employee> list=new ArrayList<>();
			list.add(e1);
			list.add(e2);
			of.setEmployees(list);
			em.persist(of);
			
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception ex) {
			System.out.println("1->*error:" + ex.getMessage());
			return false;
		}

	}
}
