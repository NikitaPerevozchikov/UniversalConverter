package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Paths;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        String path = args[0];

        ListGeneration.createListLineConvert(Paths.get(path));
        SpringApplication app = new SpringApplication(Main.class);
        app.run(args);
    }
}
