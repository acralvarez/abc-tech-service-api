package br.com.fiap.abctechservice.Controller;

import com.fasterxml.jackson.core.io.IOContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RestController
@RequestMapping("/")
public class HealthCheckController {

    @GetMapping()
    public ResponseEntity <String> status(){
        return ResponseEntity.ok("Sucesso!");

    }

    @GetMapping("version")
    public ResponseEntity<String> version(){
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.yml");
        try{
            properties.load(inputStream);
                } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(properties.getProperty("build.name") +"_" + properties.getProperty("build.version"));
    }
}
