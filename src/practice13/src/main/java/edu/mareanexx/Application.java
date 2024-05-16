package edu.mareanexx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Value("${student.name}")
    private String studentName;

    @Value("${student.last_name}")
    private String studentLastName;

    @Value("${student.group}")
    private String studentGroup;

    private final Environment environment;

    public Application(Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Использую @Value аннотацию:");
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Last Name: " + studentLastName);
        System.out.println("Student Group: " + studentGroup);

        System.out.println("\nИспользуя интерфейс Environment:");
        System.out.println("Student Name: " + environment.getProperty("student.name"));
        System.out.println("Student Last Name: " + environment.getProperty("student.last_name"));
        System.out.println("Student Group: " + environment.getProperty("student.group"));
    }
}
