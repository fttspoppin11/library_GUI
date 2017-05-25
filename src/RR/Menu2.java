package RR;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

import RR.Menu1;
import java.applet.*;

public class Menu2 extends JDialog implements ItemListener {
	JPanel p3;
	Image menu2 = Toolkit.getDefaultToolkit().getImage("img/좌석사용.jpg");
	public static Map<Integer, Student> studentMap; //학생 정보를 입력 받을 곳 다시 선언해야함
	
	Font f = new Font("SanSerif",Font.BOLD,15);//버튼 폰트
	Font f1 = new Font("SanSerif",Font.BOLD,28);//버튼 폰트
	
	Checkbox []c = new Checkbox[18]; // 좌석 18개의 체크박스 생성
	CheckboxGroup cg = new CheckboxGroup();
	
	public Menu2(){
		
		studentMap = new HashMap<Integer,Student>();
		studentMap .putAll(studentMap);
		
		p3=new JPanel(){
			@Override
	         protected void paintComponent(Graphics g) 
	          { 
	             g.drawImage(menu2, 0, 0, 1050, 820, this);

	          } 
		};
		
		setSize(1050,820);
		setTitle("소영대학교 도서관 열람실 좌석 알림 시스템");
		
		p3.setLayout(null);
		setResizable(false); 
		
		JButton b2 = new JButton("메인화면");
		
		JLabel l1 = new JLabel(Integer.toString(RR.RoomA));//잔여좌석 표기할 곳
		JLabel l2 = new JLabel(Integer.toString(RR.RoomB));//잔여좌석 표기할 곳
		 
		for(int i=0;i<c.length;i++){
			c[i]=new Checkbox(String.valueOf(i+1),cg,false);
			c[i].setBackground(Color.LIGHT_GRAY);
			c[i].setSize(20, 20);
			//c[i].addItemListener(this);
		}//초기화
		
		b2.setBounds(400, 620, 200, 100);
		
		//l1.setBounds(320, 550, 30, 30);
		//l2.setBounds(750, 550, 30, 30);
		
		int x=200;
		int y =340;
		
		for(int i=0;i<9;i++){
			
			if(i<=2){
				c[i].setBounds(x,y,17,20);
				x+=85;
			}
			
			if((i%3==0)&&(i>2)){
				x=200;
				y+=87;
				c[i].setBounds(x,y,17,20);	
			}
			
			
			if((i%3!=0)&&(i>2)){
		 		x+=85;
				c[i].setBounds(x,y,17,20);
			}
			
				}
		x=630;
		y=340;
		
		for(int i=9;i<c.length;i++){
			
			if(i<=11){
				c[i].setBounds(x,y,17,20);
				x+=85;
			}
			
			if((i%3==0)&&(i>11)){
				x=630;
				y+=87;
				c[i].setBounds(x,y,17,20);	
			}
			
			
			if((i%3!=0)&&(i>11)){
				x+=85;
				c[i].setBounds(x,y,17,20);
			}
			
				}
		
		
		b2.setFont(f); 
		
		l1.setFont(f1);
		l1.setForeground(Color.red);
		
		l2.setFont(f1);
		l2.setForeground(Color.red);
		
		
		b2.addActionListener(new ActionListener (){
			
			public void actionPerformed(ActionEvent e){
				setVisible(false);//기존 메인창 안보이게 하기
	
			}
		});
		
		p3.add(b2);
		
		p3.add(l1);
		p3.add(l2);
		
		for(int i=0;i<c.length;i++){
			c[i].addItemListener(this);
			p3.add(c[i]);
			}
		
		
		add(p3);
		
		
		setBounds(0, 0, 1050, 820); 
		setModal(true);
		
	}
	int b = id.sn;
	
	public void itemStateChanged(ItemEvent e){
		
		try{
			
			for(int i=0;i<c.length;i++){
				
				if(e.getSource()==c[i]){
					if(c[i].getState()){
						
						int x = JOptionPane.showOptionDialog(null,e.getItem()+ "번 좌석을 사용하시겠습니까?", "알림창", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
						int y = Integer.parseInt((String) e.getItem());
						
						a : switch(x){
								case JOptionPane.YES_OPTION:{
									for(Map.Entry<Integer, Student> s : RR.studentMap.entrySet() ){
										int key = s.getValue().getusenumber();
										
										if(key==y){
											JOptionPane.showMessageDialog(null,"     사용중인 좌석 입니다!","경고창", JOptionPane.ERROR_MESSAGE);
											break a;
											}
										
									}
									if(!RR.studentMap.get(b).getUsing()){
										setVisible(false);
										JOptionPane.showMessageDialog(null,"                "+y+"번 좌석 사용 처리 완료!","알림창", JOptionPane.PLAIN_MESSAGE);
										RR.studentMap.get(b).setusenumber(y);
										RR.studentMap.get(b).setUsing(true);
										saveSeat(b,y);
										break;
									}
								
								}
								
								case JOptionPane.NO_OPTION:
									break;
								
							}
						
						}
					}
			}
		}catch(NullPointerException a){
			a.printStackTrace();
			JOptionPane.showMessageDialog(null,"     예외발생!","알림창", JOptionPane.ERROR_MESSAGE);
		}
	
	}
	
	public void saveSeat(int n, int s){
		 
		
		try{
			
			File file = new File("좌석이용정보.txt");
			FileOutputStream fos = new FileOutputStream(file,true);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
		
			osw.write(n+" ");// 토큰은 \n이 된다
			osw.write(s+" ");// 토큰은 \n이 된다
			//osw.write("\n");
			 System.out.println("파일 저장 완료");
		     System.out.println("좌석이용정보.txt 파일을 확인하세요.");
		     
			
			//fos.close();
			osw.close();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
    

	}
}
