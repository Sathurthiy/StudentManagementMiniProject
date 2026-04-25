import java.util.*;
class StudentManagement
{
	int id;
	String name;
	int marks;

StudentManagement(int id,String name,int marks)
{
	this.id=id;
	this.name=name;
	this.marks=marks;
}
public void displayDetails()
{
	System.out.println("Student id:"+id);
	System.out.println("Student Name:"+name);
	System.out.println("Student's Marks:"+marks);
}

}
class Student{
	 static StudentManagement [] student=new StudentManagement[5];
	 static int count=0;
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	while(true) {
	System.out.println("\n______________________________________________________________________________");
	System.out.println("\n");
	System.out.println("                       STUDENT MANAGEMENT SYSTEM");
	System.out.println("\n______________________________________________________________________________");
	System.out.println(" \n   MENU");
	System.out.println("\n  1. Add Student \n  2. View Student \n  3. Search Student \n  4. Delete Student \n  5. Update Student \n  6. Topper Student  \n  7. Exit");
   System.out.println("\nEnter choice:");
   int choice=sc.nextInt();
   
   switch(choice) {
   case 1:
	   System.out.println("ADDING STUDENT");
	   addStudent(sc);
	   break;
   case 2:
	   System.out.println(" VIEW STUDENT ");
	   viewStudent();
	   break;
   case 3:
	   System.out.println("SEARCHING STUDENT");
	   searchStudentByID(sc);
	   break;
   case 4:
	   System.out.println("DELETE STUDENT");
	   deleteStudentById(sc);
	   break;
   case 5:
	   System.out.println("UPDATE STUDENT");
	   updateStudent(sc);
	   break;
   case 6:
	   System.out.println("\n TOPPER ");
	   findTopper();
	   break;
   case 7:
	   System.exit(0);
   default:
	   System.out.println("Invalid option.Please enter choice from 1 to 4");
	   break;
   }
   }
}  

public static void addStudent(Scanner sc) {
	if(count==student.length) {
		System.out.println("Storage full");
		return;
	}
	int id;
	while(true) {
		System.out.print("Enter ID:");
		id=sc.nextInt();
	
	if(idFound(id)) {
		break;
	}
	else {
		System.out.println("ID Already found");
		}
	}
	System.out.print("Enter name:");
	sc.nextLine();
	String name=sc.nextLine();
	int marks;
	while(true) {
		System.out.print("Enter Marks:");
        marks=sc.nextInt();
	if(validateMarks(marks)) {
		break;
	}
	else {
		System.out.println("invalid mark");
	}
	}
	System.out.println("\nStudent details added successfully");
	StudentManagement ob=new StudentManagement(id,name,marks);
	student[count]=ob;
	count++;
    ob.displayDetails();  
}
public static void findTopper() {
	if(count==0)
	{
		System.out.println("No students available");
		}
	else {
		int topperindex=0;
		int max=student[0].marks;
	for (int i=0;i<count;i++) {
		if(student[i].marks>max) {
			max=student[i].marks;
			topperindex=i;
		}
	}
		System.out.println("\nTopper student marks:"+max);
		System.out.println("\nTopper Student Details");
		student[topperindex].displayDetails();
	}
	
}
public static boolean idFound(int id)
{
	for(int i=0 ;i<count;i++) {
	if(student[i].id==id) {
		return false;
	}
	}
		return true;
	}
	
public static boolean validateMarks(int marks) {
	if(marks>=0 && marks<=100) {
		return true;
	}
	else {
		return false;
	}
	}

public static void viewStudent()
{
	if(count==0)
	{
		System.out.println("No students available");
	}
	else
	{
	for(int i=0;i<count;i++) {
		
		student[i].displayDetails();
	}
	}
}
public static void searchStudentByID(Scanner sc) {
	System.out.println("Enter an ID of the student:");
	int searchid=sc.nextInt();
	boolean found=false;
	for(int i=0;i<count;i++) {
		if(student[i].id==searchid) {
			student[i].displayDetails();
			found=true;
			break;
		}
	}
	if(!found) {
		System.out.println("No student found in this ID.Please enter the correct ID");
	}
}
public static void deleteStudentById(Scanner sc) {
	System.out.println("Enter an ID of the student:");
	int searchid=sc.nextInt();
	boolean found=false;
	for(int i=0;i<count;i++) {
		if(student[i].id==searchid) {
			for(int j=i;j<count-1;j++) { //shift elements to left after deleting  a student
				student[j]=student[j+1];
			}
			count--;
			found=true;
			student[count]=null;
			System.out.println("Deleted Successfully");
			break;
		}
	}
	if(!found) {
		System.out.println("No student is found in this ID");
	}
	
}
public static void updateStudent(Scanner sc) {
System.out.println("Enter an ID of the student:");
int searchid=sc.nextInt();
boolean found=false;
for(int i=0;i<count;i++) {
	if(student[i].id==searchid) {
		System.out.println("Enter the details to be updated");
		System.out.println("1.Name \n 2.Marks \n 3.Both\n");
		System.out.println("Enter the number of content to be updated:");
		int update=sc.nextInt();
	
		if(update==1) {
			System.out.println("Enter your updated name:");
			sc.nextLine();
			String upname=sc.nextLine();
			student[i].name=upname;	
		}
		else if(update==2) {
			System.out.println("Enter your updated marks:");
			int upmarks=sc.nextInt();
			student[i].marks=upmarks;	
		}
		else {
			System.out.println("Enter your updated name:");
			sc.nextLine();
			String upname=sc.nextLine();
			student[i].name=upname;	
			System.out.println("Enter your updated marks:");
			int upmarks=sc.nextInt();
			student[i].marks=upmarks;	
		}
		
		found=true;
		break;
	}
	
	}

if(!found) {
	System.out.println("No student found in this ID.Please enter the correct ID");
}
}
}
