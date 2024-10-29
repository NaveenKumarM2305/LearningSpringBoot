package com.naveen.aopdemo;

import com.naveen.aopdemo.dao.AccountDAO;
import com.naveen.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner->{
			demoBeforeAdviceForAddAccount(accountDAO,membershipDAO);
		};
	}

	private void demoBeforeAdviceForAddAccount(AccountDAO accountDAO,MembershipDAO membershipDAO) {
	accountDAO.addAccount();
	membershipDAO.addAccount();

	}
}
