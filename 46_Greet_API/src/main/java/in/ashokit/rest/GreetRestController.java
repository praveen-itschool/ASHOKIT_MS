package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.client.WelcomeApiFeignClient;

@RestController
public class GreetRestController {
	@Autowired
	private WelcomeApiFeignClient welcomeClient;
	@Autowired
	private Environment env;

	@GetMapping("/greet")
	public String greetMsg() {
		String welcomeResponse = welcomeClient.invokeWelcomeApi();
		String port = env.getProperty("server.port");
		String greetResponse = " Good Morning ..!! (" + port + ")";
		return greetResponse + welcomeResponse;
	}
}
