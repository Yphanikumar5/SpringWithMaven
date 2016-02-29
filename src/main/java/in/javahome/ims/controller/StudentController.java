package in.javahome.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.javahome.ims.entities.Student;
import in.javahome.ims.service.IStudentService;

@Controller
public class StudentController {

	@Autowired
	private IStudentService registerService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registerForm(@ModelAttribute("student") Student student) {
		return "addStudent";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String register(@ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Student Name" + student.getFirstName());
			return "addStudent";
		} else {
			registerService.addStudentDetails(student);
			return "addStudent";
		}

	}
}
