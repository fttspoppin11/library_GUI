package RR;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Menu1 extends JFrame implements Serializable{
	//학생 정보 입력
	JPanel p2;
	Image menu1 = Toolkit.getDefaultToolkit().getImage("img/학생정보.jpg"); 
	public static Map<Integer, Student> studentMap; //학생 정보를 입력 받을 곳 다시 선언해야함
	
	Font f = new Font("SanSerif",Font.BOLD,15);//버튼 폰트
	Font f1 = new Font("SanSerif",Font.BOLD,28);//버튼 폰트
	
	public static String name=null;
	public static int sn = 0; //학번
	
	public Menu1(){
		
		RR RR = new RR();
		RR.setVisible(false);
		
		studentMap = new HashMap<Integer,Student>();
		studentMap .putAll(studentMap);
		
		setSize(1050,820);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("소영대학교 도서관 열람실 좌석 알림 시스템");
		
		p2=new JPanel(){
			@Override
	         protected void paintComponent(Graphics g) 
	          { 
	             g.drawImage(menu1, 0, 0, 1050, 820, this);

	          } 
		};
		
		p2.setLayout(null);
		setResizable(false); 
		
		JButton b1 = new JButton("확인");
		JButton b2 = new JButton("등록");
		JButton b3 = new JButton("메인화면");
		
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		
		b1.setBounds(720, 240, 100, 50);//버튼 좌표 결정
		b2.setBounds(720, 450, 100, 50);
		b3.setBounds(720, 600, 100, 50);
		
		b1.setFont(f);  
		b2.setFont(f);  
		b3.setFont(f);  
		
		t1.setFont(f1);  
		t2.setFont(f1); 
		
		t1.setBounds(330, 240, 300, 50);
		t2.setBounds(330, 450, 300, 50);
	
		//JLabel l1 = new JLabel();//학생 정보 입력 받을 라벨(텍스트 파일에 저장시킬라고 )
		
		
		b1.addActionListener(new ActionListener (){
			
			public void actionPerformed(ActionEvent e){
				//setVisible(false);//기존 메인t창 안보이게 하기
				int sn = 0; //학번
				
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
										
										JOptionPane.showMessageDialog(null,"     이미 등록된 학번입니다!","알림창", JOptionPane.ERROR_MESSAGE);
									}
									else
										JOptionPane.showMessageDialog(null,"             등록 가능한 학번입니다!","알림창", JOptionPane.PLAIN_MESSAGE);
								}
							
						}
					}catch(NumberFormatException a){
						a.printStackTrace();
						JOptionPane.showMessageDialog(null,"     정확하게 입력해주세요!","알림창", JOptionPane.ERROR_MESSAGE);
					}finally{}
			}
		});
		
		b2.addActionListener(new ActionListener (){
			
			public void actionPerformed(ActionEvent e){
				//setVisible(false);//기존 메인창 안보이게 하기
	
			
				try{
					
					if((t1.getText()).equals("")||(t2.getText()).equals("")){
						JOptionPane.showMessageDialog(null,"       정보를 모두 입력해주세요!","알림창", JOptionPane.ERROR_MESSAGE);
					}
				
					
					if((!(t2.getText()).equals(""))&&(!(t1.getText()).equals(""))){
						name=t2.getText();
						sn=Integer.parseInt(t1.getText());
						if(sn>=1000||sn<=99){
							JOptionPane.showMessageDialog(null,"     학번이 정확하지 않습니다!","알림창", JOptionPane.ERROR_MESSAGE);
							}
						if(99<sn&&sn<=999){
								if(RR.studentMap.containsKey(sn)==true){
									JOptionPane.showMessageDialog(null,"     이미 등록된 학번입니다!","알림창", JOptionPane.ERROR_MESSAGE);
								}
								else{
									RR.studentMap.put(sn,new Student(name,sn,0,false));
									saveFile(name,sn);
									JOptionPane.showMessageDialog(null,"             학생 정보가 등록되었습니다!","알림창", JOptionPane.PLAIN_MESSAGE);
								}
						}
				
					}
				
				}catch(NumberFormatException a){
					a.printStackTrace();
					JOptionPane.showMessageDialog(null,"     정확하게 입력해주세요!","알림창", JOptionPane.ERROR_MESSAGE);
				}finally{}
	
			}
		});
		
		b3.addActionListener(new ActionListener (){
			
			public void actionPerformed(ActionEvent e){
				setVisible(false);//기존 메인창 안보이게 하기
				RR R = new RR();
				R.setVisible(true);
				
			}
		});
		
		p2.add(t1);
		p2.add(t2);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		
		add(p2);
	
		setBounds(0, 0, 1050, 820); 
		setVisible(true);
	}
	
	public void saveFile(String n, int s){
		 
	
		try{
			
			File file = new File("학생정보.txt");
			FileOutputStream fos = new FileOutputStream(file,true);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
		
			osw.write(n+" ");// 토큰은 \n이 된다
			osw.write(s+" ");// 토큰은 \n이 된다
			osw.write("\n");
			 System.out.println("파일 저장 완료");
		     System.out.println("학생정보.txt 파일을 확인하세요.");
		     
			
			//fos.close();
			osw.close();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
    

	}
	

	
}