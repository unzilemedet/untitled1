package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    private final String mysqlDriver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost/maraton?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey&useSSL=false";
    private final String userName = "root";
    private final String userPass = "U.m123456";

    public Connection connection = null;

    public DB(){
        try{
            Class.forName(mysqlDriver);
            connection = DriverManager.getConnection(url,userName,userPass);
            if(!connection.isClosed()){
                System.out.println("Connection Success");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
