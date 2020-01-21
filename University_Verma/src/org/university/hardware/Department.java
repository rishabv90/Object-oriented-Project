package org.university.hardware;
import org.university.software.Course;
import org.university.people.Student;
import org.university.people.Professor;



//import java.io.*; 
import java.util.*; 

public class Department {

	
	private String name; 
	private ArrayList<Student> studentList;
	private ArrayList<Course> courseList;
	private ArrayList<Professor> professorList;
	
	
	
	public Department() {
		name = "x";
		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();
		professorList = new ArrayList<Professor>();
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
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	public ArrayList<Course> getCourseList(){
		return courseList;
	}
	
	
	
	public ArrayList<Professor> getProfessorList() {
		return professorList;
	}

	public void setProfessorList(ArrayList<Professor> professorList) {
		this.professorList = professorList;
	}
	
	public void printStudentList() {//need to fix this
		for (int i = 0; i <= studentList.size()-1; i++) {
			  System.out.println(studentList.get(i));
			}
	}
	
	public void printProfessorList() {//need to fix this
		for (int i = 0; i <= professorList.size()-1; i++) {
			  System.out.println(professorList.get(i));
			}
	}

	public void printCourseList() {//need to fix this
		for (int i = 0; i <= courseList.size()-1; i++) {
			  System.out.println(courseList.get(i));
			}
	}
	
	
	public void addProfessor(Professor aProfessor){//check!!!
		professorList.add(aProfessor);
	}
	
}
