/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.gii.ligaajedrez.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import es.uv.gii.ligaajedrez.modelo.Club;
import es.uv.gii.ligaajedrez.modelo.EntrenadorModel;
import es.uv.gii.ligaajedrez.modelo.FederacionModel;
import es.uv.gii.ligaajedrez.modelo.GerenteModel;
import es.uv.gii.ligaajedrez.modelo.JugadorModel;
import es.uv.gii.ligaajedrez.modelo.Partida;
import es.uv.gii.ligaajedrez.modelo.Reserva;
import es.uv.gii.ligaajedrez.modelo.Sede;
import es.uv.gii.ligaajedrez.modelo.Torneo;
import es.uv.gii.ligaajedrez.modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;

/**
 *
 * @author jbeltran
 */
public class DB {

    private static DB DB;
    private Configuration cfg;
    private SessionFactory factory;
    private Session session;

    private DB() {
        // JPA/Hibernate init
        cfg = new Configuration();
	cfg.configure("ligaajedrez/db/hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();
        session = factory.openSession();
    }
    
    public static DB getDB() {
        if (DB == null) {
            DB = new DB();
        }
        return DB;
    }
    
    public Session getSession() {
        return session;
    }
    
    public void createInitialData() {
        Transaction t = session.beginTransaction();
        
        // Create initial Federacion
        FederacionModel fm = new FederacionModel("Valencia");
        FederacionModel fm1 = new FederacionModel("Madrid");
        session.save(fm);
        session.save(fm1);
        
        // Create initial Sede
        Sede s = new Sede();
        Sede s1 = new Sede();
        session.save(s);
        session.save(s1);
        
        // Create initial Club
        Club c = new Club("Jaque al rey", fm, s);
        Club c1 = new Club("Burjassot", fm, s);
        Club c3 = new Club("Viva el alfil", fm1, s1);
        Club c2 = new Club("Morata", fm1, s1);
        session.save(c);
        session.save(c1);
        session.save(c2);
        session.save(c3);
        
        // Create initial JugadorModel
        JugadorModel jm = new JugadorModel("Usuario 1", 0, 20, c);
        JugadorModel jm1 = new JugadorModel("Administrador 1", 0, 20, c);
        session.save(jm);
        session.save(jm1);
        
        // Create initial Usuario
        Usuario u = new Usuario("usuario", "usuario", jm);
        Usuario u1 = new Usuario("admin", "admin", jm1, true);
        session.save(u);
        session.save(u1);
        
        // Create initial Torneo
        ArrayList<Club> lc = new ArrayList<>();
        lc.add(c);
        lc.add(c1);
        ArrayList<Club> lc1 = new ArrayList<>();
        lc.add(c2);
        lc.add(c3);
        Torneo to = new Torneo(fm, new Date(), lc);
        Torneo to1 = new Torneo(fm1, new Date(), lc1);
        session.save(to);
        session.save(to1);
        
        // Create initial Partidas
        Partida p = new Partida(jm, jm1, s, new Date(), new Date(), to);
        session.save(p);
        
        // Create initial Reserva
        Reserva r = new Reserva(u1, new Date(), 10, s);
        session.save(r);
        
        // Create initial EntrenadorModel
        EntrenadorModel em = new EntrenadorModel("Entrenador1", "entrenador", "36/3/2001", "61942301845");
        session.save(em);
        
        // Create initial GerenteModel
        GerenteModel gm = new GerenteModel("Entrenador1", "entrenador", "36/3/2001", "61942301845", "1200", "19");
        session.save(gm);
        
        // Save objects
        t.commit();
    }
    
    public <T> T getById(Class<T> type, int id) {
        return (T) session.get(type, id);
    }
    
    public <T> List<T> getAll(Class<T> type) {
        return (List<T>) session.createCriteria(type).list();
    }
    
    public <T> List<T> getFiltered(Class<T> type, List<Criterion> criterions) {
        Criteria criteria = session.createCriteria(type);
        
        for (Criterion criterion : criterions)
            criteria.add(criterion);
        
        return (List<T>) criteria.list();
    }
}
