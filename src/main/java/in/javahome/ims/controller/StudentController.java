package in.javahome.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.javahome.ims.service.ICourseService;
import in.javahome.ims.service.IStudentService;
import in.javahome.ims.vo.CourseVO;
import in.javahome.ims.vo.StudentVO;

@RestController
public class StudentController {

	@Autowired
	private IStudentService studentService;
	@Autowired
	private ICourseService courseService;
	
	@RequestMapping(value = "/courses", method = RequestMethod.GET, produces = "application/json")
	public List<CourseVO> getCources() {
		return courseService.findAll();
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST, produces = "application/json")
	public String register(@RequestBody StudentVO studentVO) {
		studentService.addStudentDetails(studentVO);
		return "addStudent";
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
	public List<StudentVO> register() {
		return studentService.findAll();
	}
	
}
