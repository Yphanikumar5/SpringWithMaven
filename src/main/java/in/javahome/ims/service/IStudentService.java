package in.javahome.ims.service;

import java.util.List;

import in.javahome.ims.vo.StudentVO;

public interface IStudentService {

	public void addStudentDetails(StudentVO studentVO);

	public List<StudentVO> findAll();
}
