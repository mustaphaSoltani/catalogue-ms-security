package org.soltani;

import org.soltani.entities.AppRole;
import org.soltani.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.stream.Stream;

@SpringBootApplication
@CrossOrigin("*")
public class SecServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecServiceApplication.class, args);
    }
@Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.saveRoles(new AppRole(null,"USER"));
            accountService.saveRoles(new AppRole(null,"ADMIN"));
            Stream.of("user1","user2","user3","admin").forEach(un ->{
                accountService.saveUser(un,"1234","1234");
            } );
            accountService.addRoleToUser("admin","ADMIN");
        };
}
@Bean
BCryptPasswordEncoder getBCE(){
        return new BCryptPasswordEncoder();
}
}
