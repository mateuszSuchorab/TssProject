package dao;

import java.sql.ResultSet;
import to.Data;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataService {

    ArrayList<Data> data = new ArrayList<Data>();

    public DataService() {
    }

    String error;
    String select = "SELECT * FROM people";
    int lastId;

    public ArrayList<Data> getData() {
        ResultSet rs = null;
                    data.clear();
        try {
            rs = getConnectionFromContext()
                    .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery(select);
            int id = 1;
            String name;
            String lastName;
            while (rs.next()) {
                id = rs.getInt("ID");
                name = (rs.getString("NAME"));
                lastName = (rs.getString("LASTNAME"));
                data.add(new Data(id, name, lastName));
                lastId = id++;
            }
        } catch (SQLException ex) {
            error = ex.toString();
        }
        return data;
        
    }

    public void addData(String name, String lastName) {
        try {
            getConnectionFromContext().createStatement()
                    .executeUpdate("INSERT INTO people (\"ID\",\"NAME\",\"LASTNAME\") values(" + ++lastId + ", '" + name + "','" + lastName + "')");
        } catch (SQLException ex) {
            error = ex.toString();
        }
    }

    public void deleteData(String id) {
        try {
            getConnectionFromContext().createStatement()
                    .executeUpdate("DELETE FROM people WHERE id=" + id + "");
        } catch (SQLException ex) {
            error = ex.toString();
        }
    }

    public void editData(String id, String name, String lastName) {
        try {
            getConnectionFromContext().createStatement()
                    .executeUpdate("UPDATE people SET \"NAME\"='" + name + "',\"LASTNAME\"='" + lastName + "' WHERE id=" + id + "");

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
            javax.sql.DataSource ds_mysql = (javax.sql.DataSource) envContext.lookup("jdbc/tutorialsdb");
            java.sql.Connection connection;
            connection = ds_mysql.getConnection();
            return connection;
        } catch (Exception ex) {
            throw new SQLException("Nie pobrano połączenia z kontekstu");
        }
    }
}
