package RR;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

import RR.Menu1;
import java.applet.*;
//�ݳ�
public class id2 extends JDialog{
	JPanel pid;
	
	public static Map<Integer, Student> studentMap; //�л� ������ �Է� ���� �� �ٽ� �����ؾ���
	
	Font f = new Font("SanSerif",Font.BOLD,15);//��ư ��Ʈ
	Font f1 = new Font("SanSerif",Font.BOLD,28);//��ư ��Ʈ
	
	public static int sn = 0; //�й�
	
	public id2(){
		
		RR RR = new RR();
		//RR.setVisible(false);
		
		studentMap = new HashMap<Integer,Student>();
		studentMap .putAll(studentMap);//���� �߿���
		
		JButton b1 = new JButton("�α���");
		b1.setFont(f);
		
		JTextField t1 = new JTextField(10);
		t1.setFont(f);  
		
		JLabel l1 = new JLabel("����� �й��� �Է��ϼ���  ");
		setLayout(new FlowLayout());
		
		
		setSize(300,120);
		setLocation(400,350);
		setTitle("�ý��� �α���");
		
		
	
		
		b1.addActionListener(new ActionListener (){
		
			public void actionPerformed(ActionEvent e){
				
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
									if(!RR.studentMap.get(sn).getUsing()){
										JOptionPane.showMessageDialog(null,"     ������� �¼��� �����ϴ�!","���â", JOptionPane.ERROR_MESSAGE);}
									
									else{
										setVisible(false);//���� ����â �Ⱥ��̰� �ϱ�
										int a = RR.studentMap.get(sn).getusenumber();
										
										int x = JOptionPane.showOptionDialog(null,a+ "�� �¼��� �ݳ��Ͻðڽ��ϱ�?", "�˸�â", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
											
											a : switch(x){
											case JOptionPane.YES_OPTION:{
												JOptionPane.showMessageDialog(null,"                "+a+"�� �¼� �ݳ� ó�� �Ϸ�!","�˸�â", JOptionPane.PLAIN_MESSAGE);
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
						JOptionPane.showMessageDialog(null,"     �й��� ��Ȯ���� �ʽ��ϴ�!","�˸�â", JOptionPane.ERROR_MESSAGE);
					}catch(NullPointerException a){
						a.printStackTrace();
						JOptionPane.showMessageDialog(null,"     �й��� ��Ȯ���� �ʽ��ϴ�!","�˸�â", JOptionPane.ERROR_MESSAGE);
						
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
			
			File file = new File("�¼��ݳ�����.txt");
			FileOutputStream fos = new FileOutputStream(file,true);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
		
			osw.write(n+" ");// ��ū�� \n�� �ȴ�
			osw.write(s+" ");// ��ū�� \n�� �ȴ�
			//osw.write("\n");
			 System.out.println("���� ���� �Ϸ�");
		     System.out.println("�¼��ݳ�����.txt ������ Ȯ���ϼ���.");
		     
			
			//fos.close();
			osw.close();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
    

	}
}