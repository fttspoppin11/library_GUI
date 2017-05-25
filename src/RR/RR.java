package RR;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

//ȭ�� ���� ����

public class RR extends JFrame implements Serializable{
	Image main =Toolkit.getDefaultToolkit().getImage("img/������ ������ ����ȭ��.jpg");
	JPanel p1;
	Font f = new Font("SanSerif",Font.BOLD,15);//��ư ��Ʈ
	Font f1 = new Font("SanSerif",Font.BOLD,28);//��ư ��Ʈ
	
	public static Map<Integer, Student> studentMap ; //�л� ������ �Է� ���� ��
	
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
	        	 // picturePanel=new PictureJPanel() ; �̶�� �ϴ°Ͱ� �����ϴ�.
	        	  //�� ó�� Ŭ������ ����� ������ JPanel(){.........} �� ǥ�������ν�, Ŭ������ �ϳ� �߰����� �ʰ� ���� ȿ���� ���� �ֽ��ϴ�.
	        	  //new Ŭ������() ������ ; <-�� �ϴ°� �翬�� �Ű���?
	             g.drawImage(main, 0, 0, 1050, 820, this);

	          } 

	       }; 
		
	
		setSize(1050,820);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�ҿ����б� ������ ������ �¼� �˸� �ý���");
		
		p1.setLayout(null);
		setResizable(false); 
		
		//p1.setLayout(new FlowLayout()); //������� �����Ϸ��� null �� FlowLayout (��-��)
		
	
		JButton b1 = new JButton("�л��������");
		JButton b2 = new JButton("�¼� ����ϱ�");
		JButton b3 = new JButton("�¼� �ݳ��ϱ�");
		JButton b4 = new JButton("����");
	
		//b3.setPreferredSize(new Dimension(150,80)); ���̾ƿ� ���������� ���°� ��ư ũ�� ����
	
		
		b1.setBounds(160, 650, 170, 80);//��ư ��ǥ ����
		b2.setBounds(350, 650, 170, 80);
		b3.setBounds(540, 650, 170, 80);
		b4.setBounds(730, 650, 170, 80);
		
		b1.setFont(f);  
		b2.setFont(f);  
		b3.setFont(f);  
		b4.setFont(f);  
		
		
		b1.addActionListener(new ActionListener (){
			
			public void actionPerformed(ActionEvent e){
				setVisible(false);//���� ����â �Ⱥ��̰� �ϱ�
				Menu1 m1 = new Menu1();
				m1.setVisible(true);
				
			}
		});
		
		b2.addActionListener(new ActionListener (){
			
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				id id = new id();
				id.setVisible(true);
				//System.out.println(RoomA);//?? ���� �̻��� ��
				
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
				System.exit(0);//���α׷�����
			}
		});
		
		
		p1.add(b1);//p1�� ��ư �ø���.
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
			File file = new File("�л�����.txt");
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
			System.out.print("�ѹ�����\n");
			e.printStackTrace();
		}catch(Exception e){
			System.out.print("����\n");
			e.printStackTrace();
		}
	
	
		}
	
	public void readFile2(){
		//�¼� �̿� ������ �׶� �׶� �ҷ��ͼ� �ٲ��ش�.
		try{
			File file = new File("�¼��̿�����.txt");
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
			 
			 int []student =new int[(int)file.length()];//�й�
			 int []num = new int[(int)file.length()];//��������¼�
			 
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
			System.out.print("�ѹ�����\n");
			e.printStackTrace();
		}catch(Exception e){
			System.out.print("����\n");
			e.printStackTrace();
		}
	
	
		}
	
	
	public void readFile3(){
		//�¼� �̿� ������ �׶� �׶� �ҷ��ͼ� �ٲ��ش�.
		try{
			File file = new File("�¼��ݳ�����.txt");
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
			 
			 int []student =new int[(int)file.length()];//�й�
			 int []num = new int[(int)file.length()];//��������¼�
			 
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
			System.out.print("�ѹ�����\n");
			e.printStackTrace();
		}catch(Exception e){
			System.out.print("����\n");
			e.printStackTrace();
		}
	
	
		}
	
	
	
}
