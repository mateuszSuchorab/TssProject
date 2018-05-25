/*

 */

package dao;

import to.Data;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mateusz Suchorab <suchorab.mateusz@gmail.com>
 */
public class DataService {
ArrayList<Data> data;

    public DataService() {
    }

    
    public ArrayList<Data> getData() {
        java.sql.ResultSet wynikZapytania = null;
        data = new ArrayList<Data>();
        try {

            wynikZapytania = getConnectionFromContext()
                    .createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("select * from people");

            Long id;
            String name;
            String surname;

            while (wynikZapytania.next()) {

                id = wynikZapytania.getLong("ID");
                name = (wynikZapytania.getString("NAME"));
                surname = (wynikZapytania.getString("SURNAME"));

                data.add(new Data(id, name, surname));

            }

        } catch (SQLException ex) {
            String sBlad = ex.toString();
        }
        return data;
    }

        public void addData(String name,String surname) {
        try {

            getConnectionFromContext()
                    .createStatement()
                    .executeUpdate("insert into people (\"NAME\",\"SURNAME\") values('"+name+"','"+surname+"')");

        } catch (SQLException ex) {
            String sBlad = ex.toString();
        }
        
    }
   public void delData(String id) {
        try {

            getConnectionFromContext()
                    .createStatement()
                    .executeUpdate("delete from people where id="+id);

        } catch (SQLException ex) {
            String sBlad = ex.toString();
        }
        
    }
      public void editData(String id, String name, String surname) {
        try {

            getConnectionFromContext()
                    .createStatement()
                    .executeUpdate("update people set \"NAME\"='"+name+"',\"SURNAME\"='"+surname+"' where id="+id);

        } catch (SQLException ex) {
            String sBlad = ex.toString();
        }
        
    }
    
    public java.sql.Connection getConnectionFromContext() throws SQLException {
        //przyklad pobierania polaczenia z bazą z puli polaczen zdefiniowanych
        //w pliku konfiguracyjnym context.xml na serwerze Tomcat
        try {
            //ustalanie kontekstu Java Namin Directory Interface
            javax.naming.Context initContext = new javax.naming.InitialContext();
            javax.naming.Context envContext = (javax.naming.Context) initContext.lookup("java:comp/env");
            javax.sql.DataSource ds_mysql = (javax.sql.DataSource) envContext.lookup("jdbc/baza");
            java.sql.Connection connection;
            connection = ds_mysql.getConnection();
            return connection;
        } catch (Exception ex) {
            throw new SQLException("Nie pobrano połączenia z kontekstu");
        }
    }
}
