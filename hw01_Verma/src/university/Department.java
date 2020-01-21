package university;
import java.io.*; 
import java.util.*; 

public class Department {

	
	private String name; 
	private ArrayList<Student> studentList;
	private ArrayList<Course> courseList;
	
	
	public Department() {
		name = "x";
		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();
	}
	
	public void setDepartmentName(String aName ) {
		name = aName;
	}
	
	public String getDepartmentName() {
		return name;	
	}
	
	public void addCourse(Course course) {
		courseList.add(course);
		course.setDepartment(this);
	}
	
	public void addStudent(Student student) {
		studentList.add(student);
		student.setDepartment(this);
	}
	
	public ArrayList<Student> getStudents() {
		return studentList;
	}
	
	public ArrayList<Course> getCourseList(){
		return courseList;
	}
	
	
}
