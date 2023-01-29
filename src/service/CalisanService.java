package service;



import entity.Calisan;
import entity.Sirket;
import util.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CalisanService {
    private DB db = new DB();
    Calisan calisan = null;
    List<Calisan> calisanList = new ArrayList<>();


    public static void main(String[] args) {
        CalisanService calisanService = new CalisanService();
        Sirket sirket1 = new Sirket(1);
        Sirket sirket2=new Sirket(2);
        Calisan calisan4= new Calisan(1,"fatma",38,20000.0,"eleman4",sirket1);
       // Calisan calisan2 = new Calisan(4,"mehmet",40,25000.0,"eleman3 ",sirket2);
       calisanService.create(calisan4);
        //calisanService.read();
        //calisanService.update(calisan3);
       // calisanService.deleteById(2);
    }
    public void create(Calisan calisan){
        String sql = "insert into calisan(isim,yas,maas,departman,sirket) values(?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1,calisan.getIsim());
            preparedStatement.setInt(2,calisan.getYas());
            preparedStatement.setDouble(3,calisan.getMaas());
            preparedStatement.setString(4,calisan.getDepartman());
            preparedStatement.setInt(5,calisan.getSirket().getId());
            preparedStatement.executeUpdate();
            System.out.println(calisan.getIsim() + " çalışanı eklendi");
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void read(){
        String sql = "select * from calisan as c\n" +
                "inner join sirket as s\n" +
                "on c.sirket = s.id";
        try{
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt("id");
                String isim = rs.getString("isim");
                Integer yas = rs.getInt("yas");
                Double maas = rs.getDouble("maas");
                String departman = rs.getString("departman");
                String sirketismi = rs.getString("sirketismi");
                String sirketsahibi = rs.getString("sirketsahibi");
                String unvan = rs.getString("unvan");
                String faaliyetalani = rs.getString("faaliyetalani");
                Integer kurulusyili = rs.getInt("kurulusyili");
                calisan = new Calisan(id,isim,yas,maas,departman,new Sirket(sirketismi,sirketsahibi,unvan,faaliyetalani,kurulusyili));
                calisanList.add(calisan);
            }
            if(calisanList.isEmpty()){
                System.out.println("Calisan");
            }else{
                calisanList.forEach(item -> System.out.println(item));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Calisan calisan){
        String sql = "update calisan set isim = ?, yas = ? , maas = ?, departman = ?, sirket = ? where id = ?";
        try{
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1,calisan.getIsim());
            preparedStatement.setInt(2,calisan.getYas());
            preparedStatement.setDouble(3,calisan.getMaas());
            preparedStatement.setString(4,calisan.getDepartman());
            preparedStatement.setInt(5,calisan.getSirket().getId());
            preparedStatement.setInt(6,calisan.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            read();
            System.out.println("Güncellendi");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteById(int calisanId){
        String sql = "delete from calisan where id = ?";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1,calisanId);
            preparedStatement.executeUpdate();
            System.out.println("Silindi");
            read();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
