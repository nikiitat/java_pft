package stqa.pft.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import stqa.pft.mantis.model.UserData;

import java.util.List;

/**
 * Created by nikitatertytskyi on 02.03.2018.
 */
public class DbMantisHelper {
    private final ApplicationManager app;
    private final SessionFactory sessionFactory;

    public DbMantisHelper(ApplicationManager applicationManager) {
        this.app = applicationManager;
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public List<UserData> users() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<UserData> result = session.createQuery("from UserData").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
