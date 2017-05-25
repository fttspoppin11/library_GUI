package RR;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

import RR.Menu1;
import java.applet.*;
//사용
public class id extends JDialog{
	JPanel pid;
	public static Map<Integer, Student> studentMap; //학생 정보를 입력 받을 곳 다시 선언해야함
	
	public static int sn = 0; //학번
	
	Font f = new Font("SanSerif",Font.BOLD,15);//버튼 폰트
	Font f1 = new Font("SanSerif",Font.BOLD,28);//버튼 폰트
	
	public id(){
		
		RR RR = new RR();
		//RR.setVisible(false);
		
		studentMap = new HashMap<Integer,Student>();
		studentMap .putAll(studentMap);
		
		JButton b1 = new JButton("로그인");
		b1.setFont(f);
		
		JTextField t1 = new JTextField(10);
		t1.setFont(f);  
		
		JLabel l1 = new JLabel("등록한 학번을 입력하세요  ");
		setLayout(new FlowLayout());
		
		
		setSize(300,120);
		setLocation(400,350);
		setTitle("시스템 로그인");
		
		
	
		
		b1.addActionListener(new ActionListener (){
		
			public void actionPerformed(ActionEvent e){
					try{
						if((t1.getText()).equals("")){
							JOptionPane.showMessageDialog(null,"       학번을 입력해주세요!","알림창", JOptionPane.ERROR_MESSAGE);
						}
						
						if(!(t1.getText()).equals("")){

							sn=Integer.parseInt(t1.getText());//학번을 집어 넣음(학번은 3자리수)
							
							if(sn>=1000||sn<=99){
								JOptionPane.showMessageDialog(null,"     학번이 정확하지 않습니다!","알림창", JOptionPane.ERROR_MESSAGE);
								}
							
							if(99<sn&&sn<=999){
									if(RR.studentMap.containsKey(sn)==true){
										if(RR.studentMap.get(sn).getUsing()){
											JOptionPane.showMessageDialog(null,"     이미 좌석을 사용중이십니다!","경고창", JOptionPane.ERROR_MESSAGE);}
										
										else{
											setVisible(false);//기존 메인창 안보이게 하기
											Menu2 m2 = new Menu2();
											m2.setVisible(true);
											}
										
									}
									else
										JOptionPane.showMessageDialog(null,"     학번이 정확하지 않습니다!","알림창", JOptionPane.ERROR_MESSAGE);
									
								}	
						}
					}catch(NumberFormatException a){
						a.printStackTrace();
						JOptionPane.showMessageDialog(null,"     학번이 정확하지 않습니다!","알림창", JOptionPane.ERROR_MESSAGE);
					}catch(NullPointerException a){
						a.printStackTrace();
						JOptionPane.showMessageDialog(null,"     학번이 정확하지 않습니다!","알림창", JOptionPane.ERROR_MESSAGE);
						
					}finally{}
			
				}
		});
		
		
		
		add(l1);
		add(t1);
		add(b1);
		
		setModal(true);
		
	}
}
