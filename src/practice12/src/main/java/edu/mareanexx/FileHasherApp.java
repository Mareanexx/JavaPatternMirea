package edu.mareanexx;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class FileHasherApp implements CommandLineRunner {

    private String inputFile;
    private String outputFile;

    public static void main(String[] args) {
        SpringApplication.run(FileHasherApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        inputFile = "C:/moya/practsJava/myfiles/1.txt";
        outputFile = "C:/moya/practsJava/myfiles/hash.txt";

        try {
            if (!Files.exists(Paths.get(inputFile))) {
                Files.write(Paths.get(outputFile), "null".getBytes());
                System.out.println("Input file does not exist. Created output file with 'null' content.");
            } else {
                hashFile(inputFile, outputFile);
                System.out.println("File hashed successfully.");
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void initialize() {
        System.out.println("Application started.");
    }

    @PreDestroy
    public void cleanup() {
        try {
            Files.deleteIfExists(Paths.get(inputFile));
            System.out.println("Input file deleted.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void hashFile(String inputFile, String outputFile) throws IOException, NoSuchAlgorithmException {
        try (InputStream inputStream = new FileInputStream(inputFile);
             OutputStream outputStream = new FileOutputStream(outputFile)) {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                digest.update(buffer, 0, bytesRead);
            }
            byte[] hashedBytes = digest.digest();
            String hashedString = bytesToHex(hashedBytes);
            outputStream.write(hashedString.getBytes(StandardCharsets.UTF_8));
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
