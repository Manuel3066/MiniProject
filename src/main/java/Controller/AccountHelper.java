package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Account;

public class AccountHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniProject");
	public void insertAccount(Account li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	public List<Account>showAllAccounts(){
		EntityManager em = emfactory.createEntityManager();
		List<Account>allItems = em.createQuery("SELECT i FROM Account i").getResultList();
		return allItems;
	}
	public void deleteAccount(Account toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Account>typedQuery = em.createQuery("select li from Account li where li.email =:selectedEmail and li.address =:selectedAddress and li.firstName =:selectedFirstName and li.lastName =:selectedLastName and li.password =:selectedPassword and li.phoneNumber =:selectedPhoneNumber",Account.class);
		typedQuery.setParameter("selectedEmail", toDelete.getEmail());
		typedQuery.setParameter("selectedLastName", toDelete.getAddress());
		typedQuery.setParameter("selectedFirstName", toDelete.getFirstName());
		typedQuery.setParameter("selectedLastName", toDelete.getLastName());
		typedQuery.setParameter("selectedPassword", toDelete.getPassword());
		typedQuery.setParameter("selectedPhoneNumber", toDelete.getPhoneNumber());
		typedQuery.setMaxResults(1);
		Account result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	public Account searchForAccountById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Account found = em.find(Account.class, idToEdit);
		em.close();
		return found;
	}
	public void updateAccount(Account toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	public List<Account> searchForAccountByEmail(String email) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Account>typedQuery = em.createQuery("select li from Account li where li.email =:selectedEmail",Account.class);
		typedQuery.setParameter("selectedEmail", email);
		List<Account>foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	public void cleanUp() {
		emfactory.close();
	}
}
