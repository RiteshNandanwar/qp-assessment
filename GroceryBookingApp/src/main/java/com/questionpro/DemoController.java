package com.questionpro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/message")
	public String getMessage() {
		return "calling controller";
	}
}
