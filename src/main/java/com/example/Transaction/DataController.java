package com.example.Transaction;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

	@Controller
	public class DataController {

		@GetMapping("/data")
		public String Trans(Model model) {
			return "transaction";
		}
	}

