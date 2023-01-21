package SCD.SCD;

import SCD.SCD.Collection.MailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScdApplication {
	/*@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}*/
	private MailService senderService;

	public ScdApplication(MailService senderService) {
		this.senderService = senderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ScdApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
		senderService.sendEmail("iuliantimofte2@gmail.com","NFT","this is body");
	}

}
