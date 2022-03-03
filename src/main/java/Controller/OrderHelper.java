package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Order;


public class OrderHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniProject");
	public void insertNewOrder(Order s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	public List<Order> getOrders(){
		EntityManager em = emfactory.createEntityManager();
		List<Order> allOrders = em.createQuery("SELECT o FROM Order o").getResultList();
		return allOrders;
	}
	public Order searchForOrderById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Order found = em.find(Order.class, tempId);
		return found;
	}
	public void deleteOrder(Order toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Order> typedQuery = em.createQuery("select order from Order order where order.orderId = :selectedId", Order.class);
		typedQuery.setParameter("selectedId", toDelete.getOrderId());
		typedQuery.setMaxResults(1);
		Order result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	public void updateList(Order toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
