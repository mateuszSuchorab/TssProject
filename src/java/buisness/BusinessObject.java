/*

 */

package buisness;

import to.Data;
import dao.DataService;
import java.util.ArrayList;

/**
 *
 * @author Mateusz Suchorab <suchorab.mateusz@gmail.com>
 */
public class BusinessObject {

    DataService dao;

    public BusinessObject() {
        dao = new DataService();
    }

    public void add(String name, String surname) {
        dao.addData(name, surname);
    }

    public void edit(String id, String name, String surname) {
        dao.editData(id, name, surname);
    }

    public void del(String id) {
        dao.deleteData(id);
    }
    public ArrayList<Data> getAll(){
        return dao.getData();
    }
}
