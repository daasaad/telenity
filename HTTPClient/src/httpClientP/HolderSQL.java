package httpClientP;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HolderSQL implements Holdable {
	private static final String PERSISTENCE_UNIT_NAME = "SmsServletJPA";
	private EntityManagerFactory emf;
	private EntityManager em;

	public void get(SmsServlet_Request data) {
		this.initEntityManager();
		this.createAndRead(data);
	}

	private void createAndRead(SmsServlet_Request data) {
		EntityTransaction entr = em.getTransaction();
		entr.begin();
		em.persist(data);
		entr.commit();
		em.close();
	}

	private void initEntityManager() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}

}
