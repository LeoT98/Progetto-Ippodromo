package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = " %s";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public List<Greeting> greeting(@RequestParam(value = "name", defaultValue = "Hello World!") String name) {
		Greeting a=new Greeting(counter.incrementAndGet(), name);
		Greeting b=new Greeting(counter.incrementAndGet(), name);
		List<Greeting> v=new ArrayList<Greeting>();
		v.add(new Greeting(counter.incrementAndGet(), name));
		v.add(new Greeting(counter.incrementAndGet(), name));
		return v;
	}
}
