package com.batu;

import com.batu.dao.AccountDAO;
import com.batu.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BatuApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatuApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		return runner -> {

			demoTheBeforeAdvice(accountDAO,membershipDAO);

		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {


		Account account = new Account();
		accountDAO.addAccount(account,true);

		membershipDAO.addMemberAccount();

	}

}
