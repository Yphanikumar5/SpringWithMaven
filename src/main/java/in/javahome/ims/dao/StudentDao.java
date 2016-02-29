package in.javahome.ims.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.javahome.ims.entities.Student;

@Repository
public class StudentDao implements IStudentDao {
	
	@Autowired
	private HibernateTemplate template;
	
	public void addStudent(Student student) {
		template.save(student);
	}

}
