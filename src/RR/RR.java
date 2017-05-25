package RR;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

//화면 메인 구성

public class RR extends JFrame implements Serializable{
	Image main =Toolkit.getDefaultToolkit().getImage("img/도서관 열람실 메인화면.jpg");
	JPanel p1;
	Font f = new Font("SanSerif",Font.BOLD,15);//버튼 폰트
	Font f1 = new Font("SanSerif",Font.BOLD,28);//버튼 폰트
	
	public static Map<Integer, Student> studentMap ; //학생 정보를 입력 받을 곳
	
	public static int RoomA = 9;
	public static int RoomB = 9;
	
	public RR(){
		
		studentMap = new HashMap<Integer,Student>();
		studentMap .putAll(studentMap);
		
		readFile();
		readFile2();
		readFile3();
		
		p1 = new JPanel() { 
	          
			@Override
	         protected void paintComponent(Graphics g) 
	          { 
	        	 // picturePanel=new PictureJPanel() ; 이라고 하는것과 같습니다.
	        	  //위 처럼 클래스를 만드는 과정을 JPanel(){.........} 로 표현함으로써, 클래스를 하나 추가하지 않고도 같은 효과를 낼수 있습니다.
	        	  //new 클래스명() 다음에 ; <-를 하는건 당연한 거겠죠?
	             g.drawImage(main, 0, 0, 1050, 820, this);

	          } 

	       }; 
		
	
		setSize(1050,820);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("소영대학교 도서관 열람실 좌석 알림 시스템");
		
		p1.setLayout(null);
		setResizable(false); 
		
		//p1.setLayout(new FlowLayout()); //내맘대로 설정하려면 null 난 FlowLayout (왼-오)
		
	
		JButton b1 = new JButton("학생정보등록");
		JButton b2 = new JButton("좌석 사용하기");
		JButton b3 = new JButton("좌석 반납하기");
		JButton b4 = new JButton("종료");
	
		//b3.setPreferredSize(new Dimension(150,80)); 레이아웃 지정햇을때 쓰는것 버튼 크기 변경
	
		
		b1.setBounds(160, 650, 170, 80);//버튼 좌표 결정
		b2.setBounds(350, 650, 170, 80);
		b3.setBounds(540, 650, 170, 80);
		b4.setBounds(730, 650, 170, 80);
		
		b1.setFont(f);  
		b2.setFont(f);  
		b3.setFont(f);  
		b4.setFont(f);  
		
		
		b1.addActionListener(new ActionListener (){
			
			public void actionPerformed(ActionEvent e){
				setVisible(false);//기존 메인창 안보이게 하기
				Menu1 m1 = new Menu1();
				m1.setVisible(true);
				
			}
		});
		
		b2.addActionListener(new ActionListener (){
			
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				id id = new id();
				id.setVisible(true);
				//System.out.println(RoomA);//?? 변수 이상함 ㅠ
				
			}
		});
		
		b3.addActionListener(new ActionListener (){
			
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				id2 id2 = new id2();
				id2.setVisible(true);
				
			}
		});
		
		b4.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0){
				System.exit(0);//프로그램종료
			}
		});
		
		
		p1.add(b1);//p1에 버튼 올린다.
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		
		add(p1);
		
		setBounds(0, 0, 1050, 820); 
		setVisible(true);
		
	}

	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		g.drawImage(main, 0, 0, 1050, 820, this); 
	}
	
	public void readFile(){
		
		try{
			File file = new File("학생정보.txt");
			FileInputStream fis = new FileInputStream(file);
			//InputStreamReader isw = new InputStreamReader(fis);
			 byte []b = new byte[(int)file.length()]; 
			 
			 String st ="";
			
			 int x = fis.read(b);
			 
			 for(int i=0;i<x;i++){
				 
				 st+=(char)b[i];
			 }
			 int l = 1;
			 
			 String []na =new String[(int)file.length()];
			 int []num = new int[(int)file.length()];
			 
			 StringTokenizer stn = new StringTokenizer(st, " ");    
			
			 while(stn.hasMoreTokens()){
				 if(l%2!=0){
					 na[l-1]=stn.nextToken();
					 }
				 if(l%2==0){
					 num[l-1]=Integer.parseInt(stn.nextToken());
					 }
				 l++;
			 }  
			 
			 for(int i=0;i<num.length;i++){
				 studentMap.put(num[i],new Student(na[i],num[i],0,false));
			 }

			 fis.close();

		}catch(NumberFormatException e){
			System.out.print("넘버예외\n");
			e.printStackTrace();
		}catch(Exception e){
			System.out.print("예외\n");
			e.printStackTrace();
		}
	
	
		}
	
	public void readFile2(){
		//좌석 이용 정보를 그때 그때 불러와서 바꿔준다.
		try{
			File file = new File("좌석이용정보.txt");
			FileInputStream fis = new FileInputStream(file);
			//InputStreamReader isw = new InputStreamReader(fis);
			 byte []b = new byte[(int)file.length()]; 
			 
			 String st ="";
			
			 int x = fis.read(b);
			 
			 for(int i=0;i<x;i++){
				 
				 st+=(char)b[i];
			 }
			 
			 int l = 1;
			 int j = 1;
			 
			 int a = 1 ;
			 
			 int []student =new int[(int)file.length()];//학번
			 int []num = new int[(int)file.length()];//사용중인좌석
			 
			 StringTokenizer stn = new StringTokenizer(st, " ");    
			
			 while(stn.hasMoreTokens()){
				 if(a%2!=0){
					 student[l-1]=Integer.parseInt(stn.nextToken());
					 l++;
					 }
				 if(a%2==0){
					 num[j-1]=Integer.parseInt(stn.nextToken());
					 j++;
					 }
				a++;
			 }  
			 
			
			 for(int i=0;i<x;i++){
				 for(Map.Entry<Integer, Student> s : studentMap.entrySet() ){
					 
					 int key = s.getKey();
				
					 if(key==student[i]){
						 studentMap.get(student[i]).setusenumber(num[i]);
						 studentMap.get(student[i]).setUsing(true);
						 
						
					 }
				 
				
				 }
			 }
			 
			

			 fis.close();

		}catch(NumberFormatException e){
			System.out.print("넘버예외\n");
			e.printStackTrace();
		}catch(Exception e){
			System.out.print("예외\n");
			e.printStackTrace();
		}
	
	
		}
	
	
	public void readFile3(){
		//좌석 이용 정보를 그때 그때 불러와서 바꿔준다.
		try{
			File file = new File("좌석반납정보.txt");
			FileInputStream fis = new FileInputStream(file);
			//InputStreamReader isw = new InputStreamReader(fis);
			 byte []b = new byte[(int)file.length()]; 
			 
			 String st ="";
			
			 int x = fis.read(b);
			 
			 for(int i=0;i<x;i++){
				 
				 st+=(char)b[i];
			 }
			 
			 int l = 1;
			 int j = 1;
			 
			 int a = 1 ;
			 
			 int []student =new int[(int)file.length()];//학번
			 int []num = new int[(int)file.length()];//사용중인좌석
			 
			 StringTokenizer stn = new StringTokenizer(st, " ");    
			
			 while(stn.hasMoreTokens()){
				 if(a%2!=0){
					 student[l-1]=Integer.parseInt(stn.nextToken());
					 l++;
					 }
				 if(a%2==0){
					 num[j-1]=Integer.parseInt(stn.nextToken());
					 j++;
					 }
				a++;
			 }  
			 
			
			 for(int i=0;i<x;i++){
				 for(Map.Entry<Integer, Student> s : studentMap.entrySet() ){
					 
					 int key = s.getKey();
				
					 if(key==student[i]){
						 studentMap.get(student[i]).setusenumber(0);
						 studentMap.get(student[i]).setUsing(false);
						 
						
					 }
				 
				
				 }
			 }
			 
			 
			 

			 fis.close();

		}catch(NumberFormatException e){
			System.out.print("넘버예외\n");
			e.printStackTrace();
		}catch(Exception e){
			System.out.print("예외\n");
			e.printStackTrace();
		}
	
	
		}
	
	
	
}
