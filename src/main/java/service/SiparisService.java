package service;

import com.bilgeadam.entity.Siparis;
import com.bilgeadam.entity.SiparisKalemi;
import org.hibernate.Session;

import javax.transaction.Transaction;
import java.util.List;

public class SiparisService<SiparisKalemi> {

    static SiparisDao siparisDao=new SiparisDao();
    public static void save(Siparis siparis){
        siparisDao.save(siparis);
    }
    public static void getAll(){
        List<Siparis> siparisList=siparisDao.getAll();
        for(Siparis item:siparisList){
            System.out.println("Siparis Id:"+item.getId()
        };
    }
    public List<Siparis> getAll() {
        Transaction transaction = null;
        List<Siparis> list = null;


        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            list = session.createQuery("select siparis from Siparis siparis").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return list;
    }
    List<Siparis> siparisList = siparisDao.getAll();
        for (Siparis item : siparisList) {
        System.out.println("Sipariş ID: " + item.getId());
        Integer siparisToplam = 0;
        for (SiparisKalemi item2 : item.getSiparisKalemleri()) {
            item2.getUrun().getFiyat();
        }
}
