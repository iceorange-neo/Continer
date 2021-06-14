package study.set;

import java.util.Comparator;

/**
 * @author neo
 * @date 2021/6/13 22:11
 */
public class User implements Comparable {

    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object obj){
        int compare = 0;
        if(obj instanceof User){
            User other = (User) obj;
            compare = this.getName().compareTo(other.getName());
            if(0 == compare){
                return Integer.compare(this.getAge(), other.getAge());
            }
        }
        return compare;
    }
}
