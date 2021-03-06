package rs.ac.uns.ftn.storage.storageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
public class StorageServiceApplication {

    @RequestMapping("/health")
    public String home() {
        return "Hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(StorageServiceApplication.class, args);
    }

}
