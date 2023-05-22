package com.saper.primeiro;

import com.saper.primeiro.dtos.CostResponseDTO;
import com.saper.primeiro.dtos.PriceResponseDTO;
import com.saper.primeiro.services.PayService;
import com.saper.primeiro.services.TimeService;
import com.saper.primeiro.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@SpringBootApplication
@RestController
public class PrimeiroApplication implements CommandLineRunner {
	@Autowired
	TimeService timeService;
	@Autowired
	TypeService typeService;
	@Autowired
	PayService payService;

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "first", defaultValue = "Thalyson") String first,
						@RequestParam(value = "second", defaultValue = "Gomes") String second) {
		return String.format("Hello %s %s!", first, second);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(payService.calcCost(78, "carro"));
	}

	@GetMapping("/calc-cost")
	public CostResponseDTO calcCost(@RequestParam(value = "minutes", defaultValue = "0") int minutes,
									@RequestParam(value = "type", defaultValue = "carro") String type) {

		return new CostResponseDTO(payService.calcCost(minutes, type));
	}

	@GetMapping("/price")
	public PriceResponseDTO price(){
		return new PriceResponseDTO(typeService.calcType("carro"),
									typeService.calcType("moto"));
	}
}
