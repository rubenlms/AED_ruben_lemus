package es.iespuertodelacruz.rl.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import es.iespuertodelacruz.rl.entities.Staff;

public class StaffRepository implements CRUD<Staff,Integer>{
	
	private EntityManagerFactory emf;

	public StaffRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Staff> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Staff findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Staff staff = em.find(Staff.class, id);
		em.getTransaction().commit();
		em.close();
		return staff;
	}
	
	public Staff findbyName(String name) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Staff staff = em.createNamedQuery("Staff.findByName", Staff.class)
			.setParameter("name", name)
			.getSingleResult();//recoge un solo dato de la base de datos

		em.getTransaction().commit();
		em.close();
		return staff;
	}

	@Override
	public Staff save(Staff obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Staff update(Staff obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
