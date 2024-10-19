package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.client.WelcomeApiFeignClient;

@RestController
public class GreetRestController {
	@Autowired
	private WelcomeApiFeignClient welcomeClient;

	@GetMapping("/greet")
	public String greetMsg() {
		String welcomeResponse = welcomeClient.invokeWelcomeApi();
		String greetResponse = " Good Morning ..!!";
		return   greetResponse + welcomeResponse ;
	}
}
