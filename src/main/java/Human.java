import ru.gb.lesson7.AfterSuite;
import ru.gb.lesson7.BeforeSuite;
import ru.gb.lesson7.Test;

/*
После билда файл Human.class был перемещен из папки Target в папку "C:/forTest"
Далее работа с файлом велась из вышеуказанной директории
 */

public class Human {
    private String name;
    private String surname;
    private int age;
    private int height;

    public Human(String name, String surname, int age, int height) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.height = height;
    }

    @BeforeSuite
    public void fullInfo() {
        System.out.println("BeforeSuite");
        System.out.println("Name: " + name + ", surname: " + surname + ", age is: " + age + ", height: " + height);
    }

    @AfterSuite
    public void conclusion() {
        System.out.println("AfterSuite");
        if (height >= 175) {
            System.out.println(name + " достаточно высок, особенно если он азиат");
        } else if (height < 174 || height > 54) {
            System.out.println(name + " не высок");
        } else {
            System.out.println("Несите книгу рекордов Гиннеса!");
        }
    }

    @Test(priority = 1)
    public void nameInfo() {
        System.out.println("Priority = 1");
        System.out.println("Name: " + name);
    }

    @Test(priority = 3)
    public void surnameInfo() {
        System.out.println("Priority = 3");
        System.out.println("Surname: " + surname);
    }

    @Test(priority = 5)
    public void ageInfo() {
        System.out.println("Priority = 5");
        System.out.println("Age is: " + age);
    }

    @Test(priority = 7)
    public void heightInfo() {
        System.out.println("Priority = 7");
        System.out.println("Height: " + height);
    }
}
