import java.io.Serializable;
import java.util.List;

public class User implements Serializable, Comparable {
    private String name;
    private Integer age;
    private List<String> favouriteNumber;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getFavouriteNumber() {
        return favouriteNumber;
    }

    public void setFavouriteNumber(List<String> favouriteNumber) {
        this.favouriteNumber = favouriteNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", favouriteNumber=" + favouriteNumber +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        User o1=(User)this;
        User o2=(User)o;
        return o1.getName().compareTo(o2.getName());
    }
}
