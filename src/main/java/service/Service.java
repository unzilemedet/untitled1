package service;

import com.bilgeadam.entity.Musteri;
import com.bilgeadam.entity.Siparis;
import com.bilgeadam.entity.SiparisKalemi;
import com.bilgeadam.entity.Urun;

import java.math.BigDecimal;
import java.util.List;

import static Utility.FileUtils.sessionFactory;

public class Service {
    Repository repository = new Repository();
    public <List> List<Musteri> getAllMusteri() {
        return repository.getAllMusteri();
    }
    Repository repository = new Repository();
    public void printOrders() {
        List<Siparis> orders = repository.getAllSiparis();
        for (Siparis order : orders) {
            System.out.println("Sipariş ID: " + order.getId() + " Müşteri: " + order.getMusteri().getAd() + " " + order.getMusteri().getSoyad() + " Musteri ID: " + order.getMusteri().getId());
            double totalPrice = 0;
            for (SiparisKalemi orderItem : order.getSiparisKalemleri()) {
                Urun product = orderItem.getUrun();
                System.out.println("Ürün: " + product.getAd() + " Fiyat: " + product.getFiyat() + " Adet sayısı: " + orderItem.getAdet());
                totalPrice += product.getFiyat() * orderItem.getAdet();
            }
            System.out.println("Sipariş Toplam : " + totalPrice + " TL.");
        }
    }

    public void printCustomerOrders() {
        List<Musteri> customers = repository.getAllMusteri();
        for (Musteri customer : customers) {
            System.out.println("Müşteri: " + customer.getAd() + " " + customer.getSoyad() + " Musteri ID: " + customer.getId());
            double totalExpense = 0;
            for (Siparis order : customer.getSiparisler()) {
                System.out.println("Sipariş ID: " + order.getId());
                for (SiparisKalemi orderItem : order.getSiparisKalemleri()) {
                    Urun product = orderItem.getUrun();
                    System.out.println("Ürün: " + product.getAd() + " Fiyat: " + product.getFiyat() + " Adet sayısı: " + orderItem.getAdet());
                    totalExpense += product.getFiyat() * orderItem.getAdet();
                }
            }
            System.out.println("Toplam Harcama : " + totalExpense + " TL.");
        }
    }
    Session session = sessionFactory.openSession();
    String sql = "SELECT m.id, SUM(sk.adet) as adet FROM musteri m JOIN siparis s ON m.id = s.musteri_id JOIN siparis_kalemi sk ON s.id = sk.siparis_id GROUP BY m.id";
    SQLQuery query = session.createSQLQuery(sql);
    List<Object[]> results = query.list();
       for (Object[] result : results) {
        Integer customerId = (Integer) result[0];
        BigDecimal totalQuantity = (BigDecimal) result[1];
        System.out.println("Müşteri ID: " + customerId + " Adet: " + totalQuantity);
    }
session.close();


    public void printCustomerNameAndOrder() {
        Session session = sessionFactory.openSession();
        String sql = "SELECT m.ad, m.soyad, s.id FROM musteri m JOIN siparis s ON m.id = s.musteri_id";
        SQLQuery query = session.createSQLQuery(sql);
        List<Object[]> results = query.list();
        for (Object[] result : results) {
            String customerName = (String) result[0];
            String customerSurname = (String) result[1];
            Integer orderNumber = (Integer) result[2];
            System.out.println("Müşteri: " + customerName + " " + customerSurname + " Sipariş Numarası: " + orderNumber);
        }
        session.close();
    }
}