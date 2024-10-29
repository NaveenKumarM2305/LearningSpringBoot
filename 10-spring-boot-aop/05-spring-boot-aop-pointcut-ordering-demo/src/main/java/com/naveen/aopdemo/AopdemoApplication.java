package com.naveen.aopdemo;

import com.naveen.aopdemo.dao.Account;
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
		// caling addAccount method
		Account myAccount = new Account();
		accountDAO.addAccount(myAccount,true);

		// calling addFunnyMemeber method of membershipDAO
		membershipDAO.addFunnyMember();

		accountDAO.setName("abc");
		accountDAO.setAge(23);

		String name=accountDAO.getName();
		 int age = accountDAO.getAge();

	}
}
