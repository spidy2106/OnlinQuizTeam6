package crud.model;
import java.util.List;
import crud.model.Teacher;
public interface TeacherCrud {
	
	int insertRecord(Teacher teacher);
	int updateRecord(Teacher teacher);
	int deleteRecord(int tid);
	List<Teacher> getAllRecords();
	Teacher getTeacherBytid(int tid);

}