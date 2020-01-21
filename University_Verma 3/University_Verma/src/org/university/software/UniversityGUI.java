//Rishab Verma December 3rd 2019

package org.university.software;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.swing.*;

import org.university.hardware.Department;
import org.university.people.Student;

@SuppressWarnings({ "serial", "unused" })
public class UniversityGUI extends JFrame {

	private University aUniversity;
	private JMenuBar menuBar; // the horizontal container

//file menu
	private JMenu fileMenu;
	private JMenuItem fileLoad;
	private JMenuItem fileSave;
	private JMenuItem fileExit;

//admin
	private JMenu adminMenu;
	private JMenuItem printAllInfo;

//student
	private JMenu studentMenu;
	private JMenuItem addCourse;
	private JMenuItem dropCourse;
	private JMenuItem printSchedule;

	public UniversityGUI(String windowTitle, University univ) {
		super(windowTitle);

		aUniversity = new University(univ);
		setSize(300, 200);
		setLocation(400, 400);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JLabel("<HTML><center>Welcome to University System"
				+ "<BR>Choose an action from the above menus.</center></HTML>"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();
		setVisible(true);
	}

	public void buildGUI() {
		menuBar = new JMenuBar();
//file Stuff
		fileMenu = new JMenu("File");
		fileSave = new JMenuItem("Save");
		fileLoad = new JMenuItem("Load");
		fileExit = new JMenuItem("Exit");
		
		fileSave.addActionListener(new MenuListener()); 
		fileLoad.addActionListener(new MenuListener()); 
		fileExit.addActionListener(new MenuListener());
		
		fileMenu.add(fileSave);
		fileMenu.add(fileLoad);
		fileMenu.add(fileExit);

//admin
		adminMenu = new JMenu("Administrator");
		printAllInfo = new JMenuItem("Print All Info");
		printAllInfo.addActionListener(new MenuListener());
		adminMenu.add(printAllInfo);

//student
		studentMenu = new JMenu("Students");
		addCourse = new JMenuItem("Add Course");
		dropCourse = new JMenuItem("Drop Course");
		printSchedule = new JMenuItem("Print Schedule");
		addCourse.addActionListener(new MenuListener());
		dropCourse.addActionListener(new MenuListener());
		printSchedule.addActionListener(new MenuListener());
		studentMenu.add(addCourse);
		studentMenu.add(dropCourse);
		studentMenu.add(printSchedule);


		menuBar.add(fileMenu);
		menuBar.add(studentMenu);
		menuBar.add(adminMenu);
		setJMenuBar(menuBar);
	}

	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) // this is the method MenuListener must implement, as it comes from
													// the ActionListener interface.
		{
			JMenuItem source = (JMenuItem) (e.getSource());

			if (source.equals(fileExit)) {
				System.exit(0);

			} else if (source.equals(fileSave)) {
				System.out.println("actionLister for Save");
				University.saveData(aUniversity);

			} else if (source.equals(fileLoad)) {
				System.out.println("actionLister for Load");
				aUniversity = University.loadData();

			} else if (source.equals(printAllInfo)) {

				handleAdministratorPrint();

			} else if (source.equals(addCourse)) {
				
				handleAddCourse();

			} else if (source.equals(dropCourse)) {

				handleDropCourse();

			} else if (source.equals(printSchedule)) {

				handleStudentPrintSchedule();

			}

		}

	}

	public void handleAdministratorPrint() {

		createPopUP();

	}

	public void handleAddCourse() {
		System.out.println("Add Course");
		int info;
		Student newStudent = new Student();
		Boolean S = false;
		Boolean D = false;
		Boolean C = false;
		JTextField student = new JTextField();
		JTextField department = new JTextField();
		JTextField course = new JTextField();
		int courseNum;
		String name = "X";
		String departmentName = "Y";

		Object[] windowContent = { "Student Name:", student, "Department:", department, "Course #:", course };

		info = JOptionPane.showConfirmDialog(null, windowContent, "Add Course", JOptionPane.OK_CANCEL_OPTION);

		if (info == JOptionPane.OK_OPTION) {



			courseNum = Integer.parseInt(course.getText());
			name = student.getText();
			departmentName = department.getText();

			S = checkStudent(name, courseNum);
			D = checkDepartment(departmentName, courseNum);
			C = checkCourse(departmentName, courseNum);

			if (S == false) {
				System.out.println("Student NOT found after check student function");
				JOptionPane.showMessageDialog(null, "Student \"" + name + "\" does not exist", "Student Does not exist Error", JOptionPane.PLAIN_MESSAGE);
			} else if (S == true) {
				System.out.println("Student Found after check student function");
			}
			if (D == false) {
				System.out.println("Department NOT found after check department function");
				//JOptionPane.showMessageDialog(null, "Department " + departmentName + " does not exist", "Department Does not exist Error", JOptionPane.PLAIN_MESSAGE);
			}else if (D == true) {
				System.out.println("Department Found after check department function");
			}
			if (C == false) {
				System.out.println("Course NOT Found after check course function");
				//JOptionPane.showMessageDialog(null, "Course " + departmentName + courseNum + " does not exist", "Error adding student to course", JOptionPane.PLAIN_MESSAGE);
			}else if (C == true) {
				System.out.println("Course Found after check course function");
			}
			
			if(S&C&D) {
				System.out.println(name +" " + departmentName + " "+ courseNum);
				addCourseFunction(name, departmentName, courseNum); //main part 
			}
		}

	}

	public void handleDropCourse() {
		System.out.println("Drop Course");
		int info;
		Student newStudent = new Student();
		Boolean S = false;
		Boolean D = false;
		Boolean C = false;
		JTextField student = new JTextField();
		JTextField department = new JTextField();
		JTextField course = new JTextField();
		int courseNum;
		String name = "X";
		String departmentName = "Y";

		Object[] windowContent = { "Student Name:", student, "Department:", department, "Course #:", course };

		info = JOptionPane.showConfirmDialog(null, windowContent, "Drop Course", JOptionPane.OK_CANCEL_OPTION);
		if (info == JOptionPane.OK_OPTION) {
			
			courseNum = Integer.parseInt(course.getText());
			name = student.getText();
			departmentName = department.getText();

			S = checkStudent(name, courseNum);
			D = checkDepartment(departmentName, courseNum);
			C = checkCourse(departmentName, courseNum);

			if (S == false) {
				System.out.println("Student NOT found after check student function");
				JOptionPane.showMessageDialog(null, "Student " + name + " does not exist", "Student Does not exist Error", JOptionPane.PLAIN_MESSAGE);
			} else if (S == true) {
				System.out.println("Student Found after check student function");
			}
			if (D == false) {
				System.out.println("Department NOT found after check department function");
				//JOptionPane.showMessageDialog(null, "Department " + departmentName + " does not exist", "Department Does not exist Error", JOptionPane.PLAIN_MESSAGE);
			}else if (D == true) {
				System.out.println("Department Found after check department function");
			}
			if (C == false) {
				System.out.println("Course NOT Found after check course function");
				//JOptionPane.showMessageDialog(null, "Course " + departmentName + courseNum + " does not exist", "Error adding student to course", JOptionPane.PLAIN_MESSAGE);
			}else if (C == true) {
				System.out.println("Course Found after check course function");
			}
			
			if(S&C&D) {
				System.out.println(name +" " + departmentName + " "+ courseNum);
				removeCourseFunction(name, departmentName, courseNum); //main part 
			}
		}

	}

	public void handleStudentPrintSchedule() {
		String message = "";
		String name = "X";
		Boolean S = false;
		JTextField student = new JTextField();
		Object[] windowContent = { "Student Name:", student };
		int info;	
		info = JOptionPane.showConfirmDialog(null, windowContent, "Print Student Schedule", JOptionPane.OK_CANCEL_OPTION);
		
		if(info == JOptionPane.OK_OPTION) {
			System.out.println("Print Student Schedule");
			name = student.getText();
			S = checkStudent(name, 0);
			if (S == false) {
				message = "Student NOT found after check student function";
				System.out.println("Student NOT found after check student function");
				JOptionPane.showMessageDialog(null, "Student " + name + " does not exist", "Student Does not exist Error", JOptionPane.PLAIN_MESSAGE);
			} else if (S == true) {
				System.out.println("Student Found after check student function");
			}
			
			createPopUp2(name);
			
		}
	}
	
	public void createPopUp2(String name) {
		Student thisStudent = new Student();
		JFrame adminPopWindow = new JFrame();
		JPanel scroll = new JPanel();
		//adminPopWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminPopWindow.setTitle("Scroll bars");
		adminPopWindow.setSize(500, 500);
		adminPopWindow.setLocation(400, 400);
		adminPopWindow.setVisible(false);
		ByteArrayOutputStream printPopUp = new ByteArrayOutputStream();
		PrintStream now = new PrintStream(printPopUp);
		PrintStream old = System.out;
		System.setOut(now);
		
		for(Department d : aUniversity.departmentList) {
			for(Student s : d.getStudentList())
				if (s.getName().equals(name)) {
					thisStudent = s;
					System.out.println("Found Student For print schedule");
					break;
				}	
		}
		thisStudent.printSchedule();
		JTextArea printContent = new JTextArea(printPopUp.toString());
		System.out.flush();
		System.setOut(old);
		scroll.setBackground(Color.RED);
		scroll.setPreferredSize(new Dimension(500, 600));
		scroll.add(printContent);
		adminPopWindow.add(new JScrollPane(scroll));
		adminPopWindow.setVisible(true);
		
	}

	public void createPopUP() {
//have a pop up window here
		JFrame adminPopWindow = new JFrame();
		JPanel scroll = new JPanel();

//window
		//adminPopWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminPopWindow.setTitle("Scroll bars");
		adminPopWindow.setSize(600, 600);
		adminPopWindow.setLocation(400, 400);
		adminPopWindow.setVisible(false);

//print
		ByteArrayOutputStream printPopUp = new ByteArrayOutputStream();
		PrintStream now = new PrintStream(printPopUp);
		PrintStream old = System.out;
		System.setOut(now);
		aUniversity.printAllForAdmin();
		JTextArea printContent = new JTextArea(printPopUp.toString());
		System.out.flush();
		System.setOut(old);

//scroll
		scroll.setBackground(Color.RED);
		scroll.setPreferredSize(new Dimension(500, 2800));
		scroll.add(printContent);

		adminPopWindow.add(new JScrollPane(scroll));
		adminPopWindow.setVisible(true);

	}

	public Boolean checkStudent(String name, int Number) {
		for (Department d : aUniversity.departmentList) {
			for (Student s : d.getStudentList()) {
				if (s.getName().equals(name)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean checkDepartment(String departmentName, int courseNum) {
		Department dep = new Department();
		//System.out.println("department Name");
		for (Department d : aUniversity.departmentList) {

			//System.out.println("department Name");
			//System.out.println(d.getDepartmentName() + "***");

			if (d.getDepartmentName().equals(departmentName)) {
				return true;
			}
		}
		return false;
	}

	public Boolean checkCourse(String departmentName, int courseNum) {
		Department dep = new Department();

		for (Department d : aUniversity.departmentList) {
			if (d.getDepartmentName().equals(departmentName)) {
				dep = d;
			}
		}
		for (CampusCourse cc : dep.getCampusCourseList()) {
			if (cc.getCourseNumber().equals(courseNum)) {
				System.out.println("Campus Course");
				return true;
			}
		}
		for (OnlineCourse oc : dep.getOnlineCourseList()) {
			if (oc.getCourseNumber().equals(courseNum)) {
				System.out.println("Online Course");
				return true;
			}
		}

		return false;
	}
	
	public void removeCourseFunction(String name, String departmentName, int courseNum) {
		Department dep = new Department();
		Student thisStudent = new Student();
		String conflictMessage = "nothing";
		
		for(Department d : aUniversity.departmentList ) {
			
				
				for(Student s : d.getStudentList()) {
					if (s.getName().equals(name)) {
						dep = d;
						thisStudent = s;
						System.out.println("Found Student For Remove");
						break;
					}	
				}
				
				for(CampusCourse cc : d.getCampusCourseList()) {
					Boolean detectFlag = true;
					Boolean availableFlag = true;
					Boolean containsFlag=true;
					if(cc.getCourseNumber().equals(courseNum)) {
							thisStudent.dropCourse(cc);
							System.out.println("**Campus course Drop");
							conflictMessage = thisStudent.conflictMessageDrop;
							System.out.println(name+departmentName+courseNum);
							JOptionPane.showMessageDialog(null, conflictMessage, "Dropped Course", JOptionPane.PLAIN_MESSAGE);
						}
					}
					
				
				
				for(OnlineCourse oc : d.getOnlineCourseList()) {
					Boolean detectFlag = true;
					Boolean availableFlag = true;
					Boolean containsFlag=true;
					if(oc.getCourseNumber().equals(courseNum)) {		
	
					
						if(detectFlag & availableFlag & containsFlag) {
							thisStudent.dropCourse(oc);
							System.out.println("**Campus course Drop");
							conflictMessage = "You have successfully dropped the course " + oc.getDepartment().getDepartmentName() + oc.getCourseNumber() + " "+ oc.getName();
							JOptionPane.showMessageDialog(null, conflictMessage, "Dropped Course", JOptionPane.PLAIN_MESSAGE);
						}
					}
					
				}
			}
		
	}
	
	
	
	public void addCourseFunction(String name, String departmentName, int courseNum) {
		Department dep = new Department();
		Student thisStudent = new Student();
		String conflictMessage = "nothing";
		
		for(Department d : aUniversity.departmentList ) {
			if (d.getDepartmentName().equals(departmentName)) {
				
				for(Student s : d.getStudentList()) {
					if (s.getName().equals(name)) {
						dep = d;
						thisStudent = s;
						
						break;
					}	
				}
				for(OnlineCourse oc : d.getOnlineCourseList()) {
					Boolean detectFlag = true;
					Boolean availableFlag = true;
					Boolean containsFlag=true;
					if(oc.getCourseNumber().equals(courseNum)) {
						if(oc.availableTo(thisStudent) == false) {
						    //conflictMessage = name + " can't add Online Course " + departmentName+ courseNum + " " + oc.getName()+ ". Because the Student does not have enough campus credit."  ;
							thisStudent.addCourse(oc);
							//conflictMessage = cc.conflictMessage;
							conflictMessage = thisStudent.conflictMessageOnline;
							System.out.println("**" + conflictMessage);
							JOptionPane.showMessageDialog(null, conflictMessage, "Error Capacity conflict", JOptionPane.ERROR_MESSAGE);	
						
						availableFlag = false;
						}
					
						if(detectFlag & availableFlag & containsFlag) {
							thisStudent.addCourse(oc);
							conflictMessage = "You have successfully added the course " + oc.getDepartment().getDepartmentName() + oc.getCourseNumber() + " "+ oc.getName();
							JOptionPane.showMessageDialog(null, conflictMessage, "Added Course", JOptionPane.PLAIN_MESSAGE);
						}
					}
					
				}
				
				
				
				for (CampusCourse cc : d.getCampusCourseList()) {
					Boolean detectFlag = true;
					Boolean availableFlag = true;
					Boolean containsFlag=true;
					
					if(cc.getCourseNumber().equals(courseNum)) {
						
						if(thisStudent.detectConflict(cc)) {
							conflictMessage = thisStudent.conflictMessage;
						
							JOptionPane.showMessageDialog(null, conflictMessage, "Error Scheduling conflict", JOptionPane.ERROR_MESSAGE);
							detectFlag = false;
						}
						if(cc.availableTo(thisStudent) == false) {
							    conflictMessage = name + " can't add Campus Course " + departmentName+ courseNum + " " + cc.getName()+ ". Because this course has enough students."  ;
					
								//conflictMessage = cc.conflictMessage;
								System.out.println("**" + conflictMessage);
								JOptionPane.showMessageDialog(null, conflictMessage, "Error Capacity conflict", JOptionPane.ERROR_MESSAGE);	
							
							availableFlag = false;
						}
						else if(thisStudent.getCampusCourseList().contains(cc)) {
							conflictMessage = name + " is already enrolled in the class";
							JOptionPane.showMessageDialog(null, conflictMessage, "Error Course Exists in Student courseList", JOptionPane.ERROR_MESSAGE);
							containsFlag=false;
						}
						
						
						if(detectFlag & availableFlag & containsFlag) {
							thisStudent.addCourse(cc);
							conflictMessage = "You have successfully added the course " + cc.getDepartment().getDepartmentName() + cc.getCourseNumber() + " "+ cc.getName();
							JOptionPane.showMessageDialog(null, conflictMessage, "Added Course", JOptionPane.PLAIN_MESSAGE);
						}
					}
				}
			}
		}
		
		
		
		
	}

}