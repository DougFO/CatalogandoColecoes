package br.edu.iff.ccc.bsi.webdev.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(path = "/home")
public class MainControllerView {

		@GetMapping
		public String page() {
			return "index";
		}
		
		
//		@RequestMapping("/register")
//		public class RegisterFormController {
//			
//		  @RequestMapping(method = POST)
//		  public String processForm(
//		      User user, Model model) {
//				
//		    model.addAttribute("firstname", user.getFirstName());
//		    model.addAttribute("lastname", user.getLastName());
//				
//		    return "profile";
//				
//		  }
//			
//		}
		
		
		
}

//@Controller
//@RequestMapping("/register")
//public class RegisterFormController {
//	
//  @RequestMapping(method = POST)
//  public String processForm(
//      User user, Model model) {
//		
//	  model.addAttribute("firstname", user.getFirstName());
//    model.addAttribute("lastname", user.getLastName());
//		
//    return "profile";
//		
//  }
//	
//}


