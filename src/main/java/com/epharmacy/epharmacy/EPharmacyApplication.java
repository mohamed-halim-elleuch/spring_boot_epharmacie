package com.epharmacy.epharmacy;

import com.epharmacy.epharmacy.Repository.*;
import com.epharmacy.epharmacy.model.*;
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
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

@SpringBootApplication
public class EPharmacyApplication implements CommandLineRunner {

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private SourceRepository sourceRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	@Autowired
	private  AccountService accountService;
	@Autowired
	private PharmacieRepository pharmacieRepository;
	@Autowired
	private FournisseurRepository fournisseurRepository;

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
		repositoryRestConfiguration.exposeIdsFor(Article.class, Source.class);

		sourceRepository.save(new Source("local"));
		sourceRepository.save(new Source("étranger"));


		for (int i = 1; i < 11; i++) {
			pharmacieRepository.save(new Pharmacie(i, RandomString.make(10), "cité elghzela","55331247", "70188299", RandomString.make(4) + "." + RandomString.make(4) + "@gmail.com", "Pharmacie de nuit"));
		}

		for (int i = 1; i < 11; i++) {
			fournisseurRepository.save(new Fournisseur(i, RandomString.make(10), "à l'étranger", "55331247", "70188299", RandomString.make(4) + "." + RandomString.make(4) + "@yahoo.fr", "bon fournisseur"));
		}


		categoryRepository.save(new Category(null,"Antiviraux"));
		categoryRepository.save(new Category(null,"Antibiotiques"));
		categoryRepository.save(new Category(null,"Anti-inflammatoires"));
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
				p.setFournisseur(fournisseurRepository.getById(i+1));
				p.setPharmacie(pharmacieRepository.getById(i+1));
				p.setSource(new Source("étranger"));
				p.setArticleImage("unknown.png");
				articleRepository.save(p);
			}
		});
	}
}
