package web.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Имя пользователя не может быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно состоять от 2 до 30 символов")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "Фамилия пользователя не может быть пустой")
    @Size(min = 2, max = 60, message = "Фамилия должна состоять от 2 до 60 символов")
    private String lastName;

    @Column(name = "age")
    @Min(value = 0, message = "Возраст не может быть меньше 0")
    private int age;

    @Column(name = "email")
    @NotEmpty(message = "Email пользователя не может быть пустой")
    @Email
    private String email;

    public User() {
    }

    public User(String mame, String lastName, int age, String email) {
        this.name = mame;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
