package maiji.neo4jEnglish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan
@SpringBootApplication
public class Neo4jEnglishApplication {

    public static void main(String[] args) {
        SpringApplication.run(Neo4jEnglishApplication.class, args);
    }

}
