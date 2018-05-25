package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import to.Vehicle;

/**
 *
 * @author Mateusz Suchorab <suchorab.mateusz@gmail.com>
 */
public class VehicleService {

    String error;
    String select = "SELECT * FROM vehicles";
    int lastId;
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public VehicleService() {
    }

    public ArrayList<Vehicle> getVehicles() {
        ResultSet rs;
        vehicles.clear();
        try {
            rs = getConnectionFromContext()
                    .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery(select);
            int id;
            String make;
            String model;
            while (rs.next()) {
                id = rs.getInt("ID");
                make = (rs.getString("MAKE"));
                model = (rs.getString("MODEL"));
                vehicles.add(new Vehicle(id, make, model));
                lastId = id++;
            }
        } catch (SQLException ex) {
            error = ex.toString();
        }
        return vehicles;

    }

    public void addVehicle(String make, String model) {
        try {
            getConnectionFromContext().createStatement()
                    .executeUpdate("INSERT INTO vehicles (\"ID\",\"MAKE\",\"MODEL\") values(" + ++lastId + ", '" + make + "','" + model + "')");
        } catch (SQLException ex) {
            error = ex.toString();
        }
    }

    public void delVehicle(String id) {
        try {
            getConnectionFromContext().createStatement()
                    .executeUpdate("DELETE FROM vehicles WHERE id=" + id + "");
        } catch (SQLException ex) {
            error = ex.toString();
        }
    }

    public void editVehicle(String id, String make, String model) {
        try {
            getConnectionFromContext().createStatement()
                    .executeUpdate("UPDATE vehicles SET \"MAKE\"='" + make + "',\"MODEL\"='" + model + "' WHERE id=" + id + "");

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
