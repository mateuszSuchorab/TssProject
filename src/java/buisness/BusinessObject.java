/*

 */

package buisness;

import to.User;
import dao.UserService;
import java.util.ArrayList;

/**
 *
 * @author Mateusz Suchorab <suchorab.mateusz@gmail.com>
 */
public class BusinessObject {

    UserService dao;

    public BusinessObject() {
        dao = new UserService();
    }

    public void add(String name, String surname) {
        dao.addData(name, surname);
    }

    public void edit(String id, String name, String surname) {
        dao.editData(id, name, surname);
    }

    public void del(String id) {
        dao.delData(id);
    }
    public ArrayList<User> getAll(){
        return dao.getData();
    }
}
