package crud.model;
import java.util.List;
import crud.model.Teacher;
import crud.model.TeacherService;

public class TeacherController {

	TeacherService teacherservice;
	public TeacherController() {
		
		teacherservice=new TeacherService();
	}


	public int insertRecord(Teacher teacher) {
		int result= teacherservice.insertRecord(teacher);
		return result;
	}


	public int updateRecord(Teacher teacher) {
		
		int result=teacherservice.updateRecord(teacher);
		return result;
	}

	
	public int deleteRecord(int tid) {
		
		int result=teacherservice.deleteRecord(tid);
		return result;
	}

	
	public List<Teacher> getAllRecords() {
		
		List<Teacher> list=teacherservice.getAllRecords();
		return list;
	}

	
	public Teacher getTeacherByid(int tid) {
		
		Teacher teacher=teacherservice.getTeacherBytid(tid);
		return teacher;
	}


}
