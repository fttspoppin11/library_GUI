package RR;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Menu1 extends JFrame implements Serializable{
	//�л� ���� �Է�
	JPanel p2;
	Image menu1 = Toolkit.getDefaultToolkit().getImage("img/�л�����.jpg"); 
	public static Map<Integer, Student> studentMap; //�л� ������ �Է� ���� �� �ٽ� �����ؾ���
	
	Font f = new Font("SanSerif",Font.BOLD,15);//��ư ��Ʈ
	Font f1 = new Font("SanSerif",Font.BOLD,28);//��ư ��Ʈ
	
	public static String name=null;
	public static int sn = 0; //�й�
	
	public Menu1(){
		
		RR RR = new RR();
		RR.setVisible(false);
		
		studentMap = new HashMap<Integer,Student>();
		studentMap .putAll(studentMap);
		
		setSize(1050,820);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�ҿ����б� ������ ������ �¼� �˸� �ý���");
		
		p2=new JPanel(){
			@Override
	         protected void paintComponent(Graphics g) 
	          { 
	             g.drawImage(menu1, 0, 0, 1050, 820, this);

	          } 
		};
		
		p2.setLayout(null);
		setResizable(false); 
		
		JButton b1 = new JButton("Ȯ��");
		JButton b2 = new JButton("���");
		JButton b3 = new JButton("����ȭ��");
		
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		
		b1.setBounds(720, 240, 100, 50);//��ư ��ǥ ����
		b2.setBounds(720, 450, 100, 50);
		b3.setBounds(720, 600, 100, 50);
		
		b1.setFont(f);  
		b2.setFont(f);  
		b3.setFont(f);  
		
		t1.setFont(f1);  
		t2.setFont(f1); 
		
		t1.setBounds(330, 240, 300, 50);
		t2.setBounds(330, 450, 300, 50);
	
		//JLabel l1 = new JLabel();//�л� ���� �Է� ���� ��(�ؽ�Ʈ ���Ͽ� �����ų��� )
		
		
		b1.addActionListener(new ActionListener (){
			
			public void actionPerformed(ActionEvent e){
				//setVisible(false);//���� ����tâ �Ⱥ��̰� �ϱ�
				int sn = 0; //�й�
				
					try{
						if((t1.getText()).equals("")){
							JOptionPane.showMessageDialog(null,"       �й��� �Է����ּ���!","�˸�â", JOptionPane.ERROR_MESSAGE);
						}
						
						if(!(t1.getText()).equals("")){

							sn=Integer.parseInt(t1.getText());//�й��� ���� ����(�й��� 3�ڸ���)
							
							if(sn>=1000||sn<=99){
								JOptionPane.showMessageDialog(null,"     �й��� ��Ȯ���� �ʽ��ϴ�!","�˸�â", JOptionPane.ERROR_MESSAGE);
								}
							
							if(99<sn&&sn<=999){
									if(RR.studentMap.containsKey(sn)==true){
										
										JOptionPane.showMessageDialog(null,"     �̹� ��ϵ� �й��Դϴ�!","�˸�â", JOptionPane.ERROR_MESSAGE);
									}
									else
										JOptionPane.showMessageDialog(null,"             ��� ������ �й��Դϴ�!","�˸�â", JOptionPane.PLAIN_MESSAGE);
								}
							
						}
					}catch(NumberFormatException a){
						a.printStackTrace();
						JOptionPane.showMessageDialog(null,"     ��Ȯ�ϰ� �Է����ּ���!","�˸�â", JOptionPane.ERROR_MESSAGE);
					}finally{}
			}
		});
		
		b2.addActionListener(new ActionListener (){
			
			public void actionPerformed(ActionEvent e){
				//setVisible(false);//���� ����â �Ⱥ��̰� �ϱ�
	
			
				try{
					
					if((t1.getText()).equals("")||(t2.getText()).equals("")){
						JOptionPane.showMessageDialog(null,"       ������ ��� �Է����ּ���!","�˸�â", JOptionPane.ERROR_MESSAGE);
					}
				
					
					if((!(t2.getText()).equals(""))&&(!(t1.getText()).equals(""))){
						name=t2.getText();
						sn=Integer.parseInt(t1.getText());
						if(sn>=1000||sn<=99){
							JOptionPane.showMessageDialog(null,"     �й��� ��Ȯ���� �ʽ��ϴ�!","�˸�â", JOptionPane.ERROR_MESSAGE);
							}
						if(99<sn&&sn<=999){
								if(RR.studentMap.containsKey(sn)==true){
									JOptionPane.showMessageDialog(null,"     �̹� ��ϵ� �й��Դϴ�!","�˸�â", JOptionPane.ERROR_MESSAGE);
								}
								else{
									RR.studentMap.put(sn,new Student(name,sn,0,false));
									saveFile(name,sn);
									JOptionPane.showMessageDialog(null,"             �л� ������ ��ϵǾ����ϴ�!","�˸�â", JOptionPane.PLAIN_MESSAGE);
								}
						}
				
					}
				
				}catch(NumberFormatException a){
					a.printStackTrace();
					JOptionPane.showMessageDialog(null,"     ��Ȯ�ϰ� �Է����ּ���!","�˸�â", JOptionPane.ERROR_MESSAGE);
				}finally{}
	
			}
		});
		
		b3.addActionListener(new ActionListener (){
			
			public void actionPerformed(ActionEvent e){
				setVisible(false);//���� ����â �Ⱥ��̰� �ϱ�
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
			
			File file = new File("�л�����.txt");
			FileOutputStream fos = new FileOutputStream(file,true);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
		
			osw.write(n+" ");// ��ū�� \n�� �ȴ�
			osw.write(s+" ");// ��ū�� \n�� �ȴ�
			osw.write("\n");
			 System.out.println("���� ���� �Ϸ�");
		     System.out.println("�л�����.txt ������ Ȯ���ϼ���.");
		     
			
			//fos.close();
			osw.close();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
    

	}
	

	
}