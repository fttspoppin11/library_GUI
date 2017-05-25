package RR;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

import RR.Menu1;
import java.applet.*;
//반납
public class id2 extends JDialog{
	JPanel pid;
	
	public static Map<Integer, Student> studentMap; //학생 정보를 입력 받을 곳 다시 선언해야함
	
	Font f = new Font("SanSerif",Font.BOLD,15);//버튼 폰트
	Font f1 = new Font("SanSerif",Font.BOLD,28);//버튼 폰트
	
	public static int sn = 0; //학번
	
	public id2(){
		
		RR RR = new RR();
		//RR.setVisible(false);
		
		studentMap = new HashMap<Integer,Student>();
		studentMap .putAll(studentMap);//제일 중요함
		
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
									if(!RR.studentMap.get(sn).getUsing()){
										JOptionPane.showMessageDialog(null,"     사용중인 좌석이 없습니다!","경고창", JOptionPane.ERROR_MESSAGE);}
									
									else{
										setVisible(false);//기존 메인창 안보이게 하기
										int a = RR.studentMap.get(sn).getusenumber();
										
										int x = JOptionPane.showOptionDialog(null,a+ "번 좌석을 반납하시겠습니까?", "알림창", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
											
											a : switch(x){
											case JOptionPane.YES_OPTION:{
												JOptionPane.showMessageDialog(null,"                "+a+"번 좌석 반납 처리 완료!","알림창", JOptionPane.PLAIN_MESSAGE);
												RR.studentMap.get(sn).setusenumber(0);
												RR.studentMap.get(sn).setUsing(false);
												returnSeat(sn,a);
												//if(RR.studentMap.get(sn).getusenumber()<=9){RR.RoomA++;}
												//else{RR.RoomB++;}
											}
											case JOptionPane.NO_OPTION:{break;}
												}
									
										}
									
								}
									
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
	
	public void returnSeat(int n, int s){
		 
		
		try{
			
			File file = new File("좌석반납정보.txt");
			FileOutputStream fos = new FileOutputStream(file,true);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
		
			osw.write(n+" ");// 토큰은 \n이 된다
			osw.write(s+" ");// 토큰은 \n이 된다
			//osw.write("\n");
			 System.out.println("파일 저장 완료");
		     System.out.println("좌석반납정보.txt 파일을 확인하세요.");
		     
			
			//fos.close();
			osw.close();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
    

	}
}