package service;
import entity.Sirket;
import util.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SirketService {
    DB db = new DB();
    Sirket sirket = null;
    List<Sirket> sirketList = new ArrayList<>();


    public static void main(String[] args) {
        SirketService sirketService = new SirketService();
        Sirket sirket1 = new Sirket(2,"Aselsan","Hans","x"," y",1994);
            sirketService.create(sirket1);
        //     sirketService.deleteById(2);
        //     sirketService.update(sirket1);
       // sirketService.read();
    }
    public void create(Sirket sirket){
        String sql = "insert into sirket(sirketismi,sirketsahibi,unvan,faaliyetalani,kurulusyili) values(?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1,sirket.getSirketIsmi());
            preparedStatement.setString(2, sirket.getSirketSahibi());
            preparedStatement.setString(3, sirket.getUnvan());
            preparedStatement.setString(4,sirket.getFaaliyetAlani());
            preparedStatement.setInt(5,sirket.getKurulusYili());
            preparedStatement.executeUpdate();
            System.out.println(sirket.getSirketIsmi() + " eklendi.");
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void read() {
        String sql = "select * from sirket";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String sirketismi = rs.getString("sirketismi");
                String sirketsahibi = rs.getString("sirketsahibi");
                String unvan = rs.getString("unvan");
                String faaliyetalani = rs.getString("faaliyetalani");
                Integer kurulusyili = rs.getInt("kurulusyili");
                sirket = new Sirket(id, sirketismi, sirketsahibi, unvan, faaliyetalani, kurulusyili);
                sirketList.add(sirket);
            }
            if (sirketList.isEmpty()) {
                System.out.println("Şirket");
            } else {
                sirketList.forEach(item -> System.out.println(item));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }}
