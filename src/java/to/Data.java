/*

 */

package to;

/**
 *
 * @author Mateusz Suchorab <suchorab.mateusz@gmail.com>
 */
public class Data {
    Long id;
    String name;
    String surname;

    public Data() {
    }

    public Data(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
