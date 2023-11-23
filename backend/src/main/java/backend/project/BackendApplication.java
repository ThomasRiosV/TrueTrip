package backend.project;

import backend.project.entities.Authority;
import backend.project.entities.AuthorityName;
import backend.project.entities.Personal;
import backend.project.entities.User;
import backend.project.repositories.AuthorityRepository;
import backend.project.repositories.PersonalRepository;
import backend.project.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.List;


@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

  @Bean
  public CommandLineRunner mappingDemo(
    AuthorityRepository authorityRepository,
    UserRepository userRepository,
    PersonalRepository personalRepository
  ) {
    return args -> {
      authorityRepository.saveAll(
        List.of(
          new Authority(AuthorityName.ADMIN),
          new Authority(AuthorityName.CLIENT)
        )
      );

      User user = new User("msanchez", new BCryptPasswordEncoder().encode("password"), true, new Date(),
        List.of(authorityRepository.findByName(AuthorityName.ADMIN)));
      userRepository.save(user);

      Personal personal = new Personal(Long.valueOf(0), "Marlon", "Sanchez", "marlon@gmail.com", new Date(), "Lima", "Lima", "Lima", "Lima", "999999999", user);
      personalRepository.save(personal);

      User user2 = new User("jrios", new BCryptPasswordEncoder().encode("password"), true, new Date(), List.of(authorityRepository.findByName(AuthorityName.ADMIN)));
      userRepository.save(user2);

      Personal personal2 = new Personal(Long.valueOf(0), "Jhon", "Rios", "thomasrv543@gmail.com", new Date(), "Lima", "Lima", "Lima", "Lima", "999999999", user2);
      personalRepository.save(personal2);

    };
  }


}


/*userRepository.save(
					new User("msanchez", new BCryptPasswordEncoder().encode("password"),true,new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ADMIN)
							)

					)
			);*/
