package in.javahome.ims.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.javahome.ims.service.ICourseService;
import in.javahome.ims.service.IStudentService;
import in.javahome.ims.vo.CourseVO;
import in.javahome.ims.vo.StudentVO;

// My Local changes
@RestController
public class StudentController {
// Added by Hari
	@Autowired
	private IStudentService studentService;
	@Autowired
	private ICourseService courseService;
	// Changes done in master
	@RequestMapping(value = "/courses", method = RequestMethod.GET, produces = "application/json")
	public List<CourseVO> getCources() {
		System.out.println("Madhu here....");
		return courseService.findAll();
	}
	
	@RequestMapping(value = "/student/courses/{studentId}", method = RequestMethod.GET, produces = "application/json")
	public List<CourseVO> getStudentCources(@PathVariable Integer studentId) {
		System.out.println("added By madhu");
		// Coment added by master branch
		System.out.println("added By Hari");
		return courseService.findAllStudentCourses(studentId);
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST, produces = "application/json")
	public String register(@RequestBody StudentVO studentVO) {
		studentService.addStudentDetails(studentVO);
		return "addStudent";
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
	public Set<StudentVO> studentsList() {
		return studentService.findAll();
	}
	
	@RequestMapping(value = "/student/fee/{studentId}", method = RequestMethod.GET, produces = "application/json")
	public List<StudentVO> studentFeeDetails(@PathVariable Integer studentId) {
		return studentService.findStudentFeeDetails(studentId);
	}
	
}
