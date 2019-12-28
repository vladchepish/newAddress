package helpers;

import objects.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DbHelper {

    private final SessionFactory sessionFactory;

    public DbHelper() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    public List<Group> getGroupsList() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Group> result = session.createQuery("from Group").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Set<Group> getGroupSet() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Set<Group> groups = new HashSet<>();
        List<Group> result = session.createQuery("from Group").list();
        for (Group g : result) {
            groups.add(g);
        }
        session.getTransaction().commit();
        session.close();
        return groups;
    }

}
