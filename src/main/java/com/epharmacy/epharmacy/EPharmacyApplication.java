package com.epharmacy.epharmacy;

import com.epharmacy.epharmacy.Repository.ArticleRepository;
import com.epharmacy.epharmacy.Repository.CategoryRepository;
import com.epharmacy.epharmacy.model.AppRole;
import com.epharmacy.epharmacy.model.AppUser;
import com.epharmacy.epharmacy.model.Article;
import com.epharmacy.epharmacy.model.Category;
import com.epharmacy.epharmacy.service.AccountService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class EPharmacyApplication implements CommandLineRunner {

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	@Autowired
	private  AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(EPharmacyApplication.class, args);
	}


	@Bean
	BCryptPasswordEncoder getBCPE(){
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {

		accountService.save(new AppRole(null, "USER"));
		accountService.save(new AppRole(null, "ADMIN"));
		Stream.of("user1", "user2", "user3", "admin").forEach(un -> {
			accountService.saveUser(un, "1234", "1234", "USER");
		});
		accountService.addRoleToUser("admin", "ADMIN");

		repositoryRestConfiguration.exposeIdsFor(Article.class, Category.class);


		categoryRepository.save(new Category(null,"Antiviraux", null));
		categoryRepository.save(new Category(null,"Antibiotiques", null));
		categoryRepository.save(new Category(null,"Anti-inflammatoires", null));
		Random rnd = new Random();
		categoryRepository.findAll().forEach(c -> {
			for (int i = 0; i < 10; i++) {
				Article p = new Article();
				p.setArticleNom(RandomString.make(18));
				p.setArticlePrice(100 + rnd.nextInt(10000));
				p.setAvailable(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setSelected(rnd.nextBoolean());
				p.setCategory(c);
				p.setArticleImage("unknown.png");
				articleRepository.save(p);
			}
		});
	}
}
