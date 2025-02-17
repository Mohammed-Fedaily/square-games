package fr.le.campus.numerique.square_games.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SquareGamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquareGamesApplication.class, args);
	}

}
