package Utility;

import com.bilgeadam.entity.Musteri;
import com.bilgeadam.entity.Siparis;
import com.bilgeadam.entity.SiparisKalemi;
import com.bilgeadam.entity.Urun;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FileUtils {
    private static SessionFactory sessionFactory;

    public static <SessionFactory> FileUtils.SessionFactory getSessionFactory() {

        if (sessionFactory == null){
            try{
                Configuration configuration = new Configuration();
                configuration.getClass(Musteri.class);
                configuration.getClass(Siparis.class);
                configuration.getClass(SiparisKalemi.class);
                configuration.getClass();
                sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private static class SessionFactory {
    }
}
