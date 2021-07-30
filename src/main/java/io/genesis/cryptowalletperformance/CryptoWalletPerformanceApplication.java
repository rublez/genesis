package io.genesis.cryptowalletperformance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import io.genesis.cryptowalletperformance.service.CalculatePerformances;

@SpringBootApplication
@EnableFeignClients
public class CryptoWalletPerformanceApplication {

	@Autowired
	CalculatePerformances calculatePerformances;

	public static void main(final String[] args) {
		SpringApplication.run(CryptoWalletPerformanceApplication.class, args);
		
	}

	@Bean
	CommandLineRunner startProgram() {
		return args -> {
			calculatePerformances.doTheMagic();

		};

	}

}
