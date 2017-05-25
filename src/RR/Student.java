package RR;
import java.util.*;
import java.io.*;

public class Student implements Serializable{
	private String name; //이름
 	private int studentNumber; //학번
 	private boolean using; //학생이 좌석을 사용중이면 true, 아니면 false
 	private int usenumber;//학생이 사용중인 좌석 번호
 	
 	
 	public Student(String n, int m, int a, boolean x){
		this.name=n;
		this.studentNumber=m;
		this.usenumber=a;
		this.using=x;
	}//생성자
 	
 	public String getName(){
		return name;
	}
	public boolean getUsing(){
		return using;
	}
	public int getStudentNumber(){
		return studentNumber;
	}
	public int getusenumber(){
		return usenumber;
	}
	public void setusenumber(int x){
		this.usenumber=x;
	}
	public void setName(String n){
		this.name=n;
	}
	public void setUsing(boolean x){
		this.using=x;
	}
	public void setStudentNumber(int m){
		this.studentNumber=m;
	}
	
}
