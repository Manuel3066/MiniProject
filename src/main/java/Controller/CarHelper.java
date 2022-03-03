package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Car;

public class CarHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniProject");
	public void insertCar(Car li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	public List<Car>showAllCars(){
		EntityManager em = emfactory.createEntityManager();
		List<Car>allCars = em.createQuery("SELECT i FROM Car i").getResultList();
		return allCars;
	}
	public void deleteAccount(Car toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car>typedQuery = em.createQuery("select li from Car li where li.color =:selectedColor and li.drivetrain =:selectedDrivetrain and li.engine =:selectedEngine and li.fuelType =:selectedFuelType and li.make =:selectedMake and li.model =:selectedModel and li.mpg =:selectedMpg and li.ordered =:selectedOrdered and li.price =:selectedPrice and li.safetyRating =:selectedSafetyRating and li.transmission =:selectedTransmission and li.type =:selectedType and li.year =:selectedYear",Car.class);
		typedQuery.setParameter("selectedColor", toDelete.getColor());
		typedQuery.setParameter("selectedDrivetrain", toDelete.getDrivetrain());
		typedQuery.setParameter("selectedEngine", toDelete.getEngine());
		typedQuery.setParameter("selectedFuelType", toDelete.getFuelType());
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedMpg", toDelete.getMpg());
		typedQuery.setParameter("selectedOrdered", toDelete.getOrdered());
		typedQuery.setParameter("selectedPrice", toDelete.getPrice());
		typedQuery.setParameter("selectedSafetyRating", toDelete.getSafetyRating());
		typedQuery.setParameter("selectedTransmission", toDelete.getTransmission());
		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		typedQuery.setMaxResults(1);
		Car result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	public Car searchForCarById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Car found = em.find(Car.class, idToEdit);
		em.close();
		return found;
	}
	public void updateCar(Car toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	public void cleanUp() {
		emfactory.close();
	}
}
