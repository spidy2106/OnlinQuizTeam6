package crud.model;
import java.util.List;
import java.util.Scanner;
import crud.model.TeacherController;
import crud.model.Teacher;

public class TeacherView {
	public static void main(String[] args) throws Exception {
		TeacherController teacherctrl = new TeacherController();
		int result;
		Teacher teacher = null;
		int tid;
		String name;
		String email;
		int phoneno;
		int choice;
		
		while(true){
		System.out.println("1. Add Record");
		System.out.println("2. Update Record");
		System.out.println("3. Delete Record");
		System.out.println("4. View Records");
		System.out.println("5. View a Record");
		System.out.println("0. Exit ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice");
		 choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Enter tid, name, email, phoneno");
			tid = sc.nextInt();
			sc.nextLine();
			name = sc.nextLine();
		    email=sc.nextLine();
		    phoneno=sc.nextInt();

			teacher = new Teacher(tid, name, email, phoneno);
			result = teacherctrl.insertRecord(teacher);
			if (result > 0)
				System.out.println("Record Inserted");
			else
				System.out.println("Record not inserted");
			break;
		case 2:
			System.out.println("Enter tid, name, email, phoneno");
			tid = sc.nextInt();
			sc.nextLine();
			name = sc.nextLine();
			email=sc.nextLine();
			phoneno=sc.nextInt();
			
			teacher = new Teacher(tid, name, email, phoneno);
			result = teacherctrl.insertRecord(teacher);
			result = teacherctrl.updateRecord(teacher);
			if (result > 0)
				System.out.println("Record updated");
			else
				System.out.println("Record not found");
			break;

		case 3:
			System.out.println("Enter tid");
			tid = sc.nextInt();
			result = teacherctrl.deleteRecord(tid);
			if (result > 0)
				System.out.println("Record deleted");
			else
				System.out.println("Record not found");
			break;
		case 4:
			List<Teacher> list=teacherctrl.getAllRecords();
			for(Teacher teac : list){
				System.out.println(teac.getTid()+"\t"+teac.getName()+" "+teac.getEmail()+" "+teac.getPhone_no());
			}
		break;
		
		case 5:
			System.out.println("Enter tid");
			tid=sc.nextInt();
			teacher=teacherctrl.getTeacherByid(tid);
			System.out.println("Tid="+teacher.getTid());
			System.out.println("name="+teacher.getName());
			System.out.println("email="+teacher.getEmail());
			System.out.println("Phoneno="+teacher.getPhone_no());
			break;
		case 0: System.exit(0);

		}
	}
	}
}

