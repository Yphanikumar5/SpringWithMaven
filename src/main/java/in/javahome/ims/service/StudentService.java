package in.javahome.ims.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.javahome.ims.dao.IStudentDao;
import in.javahome.ims.entities.Student;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private IStudentDao dao;

	 @Transactional
	public void addStudentDetails(Student student) {
		dao.addStudent(student);
	}
}
