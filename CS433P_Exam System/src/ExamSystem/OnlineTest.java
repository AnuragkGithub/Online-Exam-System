package ExamSystem;

import java.awt.event.*;
import javax.swing.*;

public class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
        String User, Pass;
	OnlineTest(String U, String P)
	{
                User = U;
                Pass = P;
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,200,20);
		jb[1].setBounds(50,110,200,20);
		jb[2].setBounds(50,140,200,20);
		jb[3].setBounds(50,170,200,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
			count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
//			JOptionPane.showMessageDialog(this,"Total Marks = "+count);
//			System.exit(0);
			new Result(count, User, Pass);
			this.dispose();

		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Q1: What is java");
			jb[0].setText("array of objects");jb[1].setText("collection of objects");jb[2].setText("low level language");jb[3].setText("none of these");	
		}
		if(current==1)
		{
			l.setText("Q2: What are the features of java");
			jb[0].setText("Encapsulation");jb[1].setText("Inheritance");jb[2].setText("High performance");jb[3].setText("none of these");
		}
		if(current==2)
		{
			l.setText("Q3: How java enable high performance");
			jb[0].setText("in time compiler");jb[1].setText("not exact time compile");jb[2].setText("enabling run file");jb[3].setText("none of these");
		}
		if(current==3)
		{
			l.setText("Q4: What are classes");
			jb[0].setText("methods and collection");jb[1].setText("instance of object");jb[2].setText("variables");jb[3].setText("Both variables and methods");
		}
		if(current==4)
		{
			l.setText("Q5: What is an object");
			jb[0].setText("Dynamic location");jb[1].setText("method specifiers");jb[2].setText("instance of class");jb[3].setText("none of these");
		}
		if(current==5)
		{
			l.setText("Que6: What is Encapsulation");
			jb[0].setText("code specifying");jb[1].setText(" code maintainability");jb[2].setText("data tranfer");jb[3].setText("none of these");
		}
		if(current==6)
		{
			l.setText("Que7: Which one among these is not a class ");
			jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");jb[3].setText("Button");
		}
		if(current==7)
		{
			l.setText("Que8: which one among these is not a function of Object class");
			jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");jb[3].setText("getDocumentBase");		
		}
		if(current==8)
		{
			l.setText("Que9: which function is not present in Applet class");
			jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");
		}
		if(current==9)
		{
			l.setText("Que10: Which one among these is not a valid component");
			jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");jb[3].setText("JTextArea");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[1].isSelected());
		if(current==1)
			return(jb[2].isSelected());
		if(current==2)
			return(jb[0].isSelected());
		if(current==3)
			return(jb[3].isSelected());
		if(current==4)
			return(jb[2].isSelected());
		if(current==5)
			return(jb[1].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
	}
	public static void main(String []args)
	{
		
	}


}
