package RR;
import java.util.*;
import java.io.*;

public class Student implements Serializable{
	private String name; //�̸�
 	private int studentNumber; //�й�
 	private boolean using; //�л��� �¼��� ������̸� true, �ƴϸ� false
 	private int usenumber;//�л��� ������� �¼� ��ȣ
 	
 	
 	public Student(String n, int m, int a, boolean x){
		this.name=n;
		this.studentNumber=m;
		this.usenumber=a;
		this.using=x;
	}//������
 	
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
