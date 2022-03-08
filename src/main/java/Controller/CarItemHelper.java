/**
 * @author theaw - mcorralledezma@dmacc.edu
 * CIS175 - Spring 2022
 * Feb 3, 2022
 **/
package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Car;
import java.util.List;

/**
 * @author theaw
 *
 */

public class CarItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleShoppingList");
	
	public void insertItem(Car li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Car>showAllitems(){
		EntityManager em = emfactory.createEntityManager();
		List<Car>allItems = em.createQuery("SELECT i FROM CarItem i").getResultList();
		return allItems;
	}
	
	public void deleteItem(Car toDelete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Car>typedQuery = em.createQuery("select li from Car li where li.model = :selectedModel and li.color = :selectedColor",Car.class);
			
			typedQuery.setParameter("selectedModel", toDelete.getModel());
			typedQuery.setParameter("selectedColor", toDelete.getColor());
			
			
			typedQuery.setMaxResults(1);
			
			Car result = typedQuery.getSingleResult();
			
			em.remove(result);
			em.getTransaction().commit();
			em.close();
	}

	/**
	 * @param toEdit
	 */
	public void updateItem(Car toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public Car searchForCarById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Car found = em.find(CarItem.class, idToEdit);
		em.close();
		
		return found;
	}

	/**
	 * @param modelName
	 * @return
	 */
	public List<Car> searchforCarByModel(String modelName) {
		// TODO Auto-generated method stub
		EntityManager em=emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car>typedQuery= em.createQuery("select li from CarItem li where li.model = :selectedModel", CarItem.class);
		typedQuery.setParameter("selectedModel", modelName);
		List<Car> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	/**
	 * @param itemName
	 * @return
	 */
	public List<CarItem> searchForCarByColor(String colorName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car>typedQuery=em.createQuery("select li from CarItem li where li.color = :selectedColor", CarItem.class);
		typedQuery.setParameter("selectedColor", colorName);
		List<Car>foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;

	}	
	
	public void cleanUp() {
		emfactory.close();
	}
}
