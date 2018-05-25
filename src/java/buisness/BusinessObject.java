package buisness;

import dao.VehicleService;
import java.util.ArrayList;
import to.Vehicle;

/**
 *
 * @author Mateusz Suchorab <suchorab.mateusz@gmail.com>
 */
public class BusinessObject {

    VehicleService dao;

    public BusinessObject() {
        dao = new VehicleService();
    }

    public void add(String make, String model) {
        dao.addVehicle(make, model);
    }

    public void edit(String id, String name, String model) {
        dao.editVehicle(id, name, model);
    }

    public void del(String id) {
        dao.delVehicle(id);
    }
    public ArrayList<Vehicle> getAll(){
        return dao.getVehicles();
    }
}
