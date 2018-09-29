import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.color.*;
public class RobotInterface implements Serializable{
	JFrame frame;
	JTextField text=new JTextField(5);
	JTextField text1=new JTextField(5);
	TextM M=new TextM();
	Text1M M1=new Text1M();
	private int test,test1;
	JButton button,button1,button2;
	Sleeping slp;
	
	public void enterSleep(){										//enter sleep model.
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65,105,225));
		JLabel label = new JLabel("Sleeping",JLabel.CENTER);
		label.setFont(new Font("Dialog",1,30));
		frame.getContentPane().add(BorderLayout.CENTER,label);
		frame.setSize(700,400);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button=new JButton("exit Sleeping");
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		button.addActionListener(new exitListener());	
	}
	
	public void greet(){                                            //output greeting to customer.
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65,105,225)); 
		String s="hahah";
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/WelcomeMessages.ser"));    //read welcome messages
		WelcomeMessages rone=(WelcomeMessages) is.readObject();
		WelcomeMessages rtwo=(WelcomeMessages) is.readObject();
		WelcomeMessages rthree=(WelcomeMessages) is.readObject();
		WelcomeMessages rfour=(WelcomeMessages) is.readObject();
		WelcomeMessages rfive=(WelcomeMessages) is.readObject();
		int i =(int)(Math.random()*4);                              //randomly output greeting
		if(i==0)
		s=rone.getMessages();
		else if(i==1)
		s=rtwo.getMessages();
		else if (i==2)
		s=rthree.getMessages();
		else if (i==3)
		s=rfour.getMessages();
		else
		s=rfive.getMessages();}			
		catch(Exception ex){
			ex.printStackTrace();}
		JLabel label = new JLabel(s,JLabel.CENTER);
		label.setFont(new Font("Dialog",1,30));
		JButton button=new JButton("Order dishes");
		frame.getContentPane().add(BorderLayout.CENTER,label);
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		frame.setSize(700,400);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new goListener());	
		slp=new Sleeping();
		slp.start();
		frame.addMouseMotionListener(new MouseAdapter(){
		public void mouseMoved(MouseEvent e){
			slp.setT();}});
	}
	
	public void go(){												//output kinds of dishes.
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65,105,225));
		JLabel label = new JLabel("Please select an option:");
		label.setFont(new Font("Dialog",1,30));
		Font font=new Font("Calibri",Font.BOLD,25);
		JTextField field = new JTextField("Option selected:",9);
		field.setFont(font);
		field.setOpaque(false);
		field.setEditable(false);
		text.setOpaque(false);
		field.setBorder (BorderFactory.createLineBorder(new Color(65,105,225)));
		JLabel label1 =new JLabel("<html> 1 <br>fish</html>",JLabel.CENTER);
		JLabel label2 =new JLabel("<html> 2 <br>meat</html>",JLabel.CENTER);
		JLabel label3 =new JLabel("<html> 3 <br>rice</html>",JLabel.CENTER);
		JLabel label4 =new JLabel("<html> 4 <br>noodle</html>",JLabel.CENTER);
		JLabel label5 =new JLabel("<html> 5 <br>drink</html>",JLabel.CENTER);
		JLabel label6 =new JLabel("                           ");
		label1.setFont(new Font("Dialog",1,17));
		label2.setFont(new Font("Dialog",1,17));
		label3.setFont(new Font("Dialog",1,17));
		label4.setFont(new Font("Dialog",1,17));
		label5.setFont(new Font("Dialog",1,17));
		JPanel panel1=new JPanel(new FlowLayout(2,10,10));
		JPanel panel=new JPanel(new GridLayout(2,3,2,2));
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		panel2.setBackground(new Color(65,105,225));
		panel3.setBackground(new Color(65,105,225));
		panel1.setBackground(new Color(65,105,225));
		panel.setBackground(new Color(65,105,225));
		frame.getContentPane().add(BorderLayout.NORTH,label);		
		frame.getContentPane().add(BorderLayout.SOUTH,panel1);
	    frame.getContentPane().add(BorderLayout.WEST,panel2);
		frame.getContentPane().add(BorderLayout.EAST,panel3);
		panel.add(label1); label1.setBackground(new Color(176,196,222)); 
		panel.add(label2); label2.setBackground(new Color(244,164,96));
		panel.add(label3); label3.setBackground(new Color(127,255,212));
		panel.add(label4); label4.setBackground(new Color(250,250,210));
		panel.add(label5); label5.setBackground(new Color(238,130,238));
		panel.add(label6); label6.setBackground(new Color(78,238,148));
		panel1.add(field);
		panel1.add(text);
		text.setBorder (BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,50)));
		text.setHorizontalAlignment(SwingConstants.CENTER); 
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.setSize(700,400);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1.setOpaque(true);
		label2.setOpaque(true);
		label3.setOpaque(true);
		label4.setOpaque(true);
		label5.setOpaque(true);
		label6.setOpaque(true);	
		text.addActionListener(new DishListener());
		slp=new Sleeping();
		slp.start();
		frame.addMouseMotionListener(new MouseAdapter(){
		public void mouseMoved(MouseEvent e){
			slp.setT();}});
	}

	public void rego(){												//the input option was wrong, so output kinds of dishes again.
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.RED);
		JLabel label = new JLabel("Wrong! Please select a right option:");
		label.setFont(new Font("Dialog",1,30));
		Font font=new Font("Calibri",Font.BOLD,25);
		JTextField field = new JTextField("Option selected:",9);
		field.setFont(font);
		field.setOpaque(false);
		field.setEditable(false);
		text.setOpaque(false);
		field.setBorder (BorderFactory.createLineBorder(new Color(65,105,225)));
		JLabel label1 =new JLabel("<html> 1 <br>fish</html>",JLabel.CENTER);
		JLabel label2 =new JLabel("<html> 2 <br>meat</html>",JLabel.CENTER);
		JLabel label3 =new JLabel("<html> 3 <br>rice</html>",JLabel.CENTER);
		JLabel label4 =new JLabel("<html> 4 <br>noodle</html>",JLabel.CENTER);
		JLabel label5 =new JLabel("<html> 5 <br>drink</html>",JLabel.CENTER);
		JLabel label6 =new JLabel("                           ");
		label1.setFont(new Font("Dialog",1,17));
		label2.setFont(new Font("Dialog",1,17));
		label3.setFont(new Font("Dialog",1,17));
		label4.setFont(new Font("Dialog",1,17));
		label5.setFont(new Font("Dialog",1,17));
		JPanel panel1=new JPanel(new FlowLayout(2,10,10));
		JPanel panel=new JPanel(new GridLayout(2,3,5,5));
		panel.setBackground(new Color(65,105,225));
		panel1.setBackground(new Color(65,105,225));
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		panel2.setBackground(new Color(65,105,225));
		panel3.setBackground(new Color(65,105,225));
		frame.getContentPane().add(BorderLayout.NORTH,label);		
		frame.getContentPane().add(BorderLayout.SOUTH,panel1);
		frame.getContentPane().add(BorderLayout.WEST,panel2);
		frame.getContentPane().add(BorderLayout.EAST,panel3);
		panel.add(label1); label1.setBackground(new Color(176,196,222)); 
		panel.add(label2); label2.setBackground(new Color(244,164,96));
		panel.add(label3); label3.setBackground(new Color(127,255,212));
		panel.add(label4); label4.setBackground(new Color(250,250,210));
		panel.add(label5); label5.setBackground(new Color(238,130,238));
		panel.add(label6); label6.setBackground(new Color(78,238,148));
		panel1.add(field);
		panel1.add(text);
		text.setBorder (BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,50)));
		text.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.setSize(700,400);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1.setOpaque(true);
		label2.setOpaque(true);
		label3.setOpaque(true);
		label4.setOpaque(true);
		label5.setOpaque(true);
		label6.setOpaque(true);	
		text.addActionListener(new DishListener());
		slp=new Sleeping();
		slp.start();
		frame.addMouseMotionListener(new MouseAdapter(){
		public void mouseMoved(MouseEvent e){
			slp.setT();}});
		}
	
	public void goDish(String a,String b,String c){					//output names of choosed kind of dishes.
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65,105,225));
		button=new JButton("Back");
		JLabel label = new JLabel("Please select an option:");
		label.setBackground(new Color(65,105,225));
		label.setOpaque(true);
		label.setFont(new Font("Dialog",1,30));
		Font font=new Font("Calibri",Font.BOLD,25);
		JTextField field = new JTextField("Option selected:",9);
		field.setFont(font);
		field.setOpaque(false);
		field.setEditable(false);
		text.setOpaque(false);
		field.setBorder (BorderFactory.createLineBorder(new Color(65,105,225)));
		JLabel label1=new JLabel("1:"+a,JLabel.CENTER);
		JLabel label2=new JLabel("2:"+b,JLabel.CENTER);
		JLabel label3=new JLabel("3:"+c,JLabel.CENTER);
		JLabel label4 =new JLabel("  ");
		JLabel label5 =new JLabel("  ");
		JLabel label6 =new JLabel("  ");
		
		label1.setFont(new Font("Dialog",1,17));
		label2.setFont(new Font("Dialog",1,17));
		label3.setFont(new Font("Dialog",1,17));
		JPanel panel1=new JPanel(new FlowLayout(2,10,10));
		JPanel panel4=new JPanel();
		JPanel panel3=new JPanel();
		panel4.setBackground(new Color(65,105,225));
		panel3.setBackground(new Color(65,105,225));
		panel1.setBackground(new Color(65,105,225));
		JPanel panel=new JPanel(new GridLayout(2,3,2,2)); 
		frame.getContentPane().add(BorderLayout.WEST,panel4);
		frame.getContentPane().add(BorderLayout.EAST,panel3);
		panel.setBackground(new Color(65,105,225));
		JPanel panel2=new JPanel(new GridLayout(1,2));
		frame.getContentPane().add(BorderLayout.NORTH,panel2);		
		frame.getContentPane().add(BorderLayout.SOUTH,panel1);
		panel.add(label1); label1.setBackground(new Color(176,196,222)); 
		panel.add(label2); label2.setBackground(new Color(244,164,96));
		panel.add(label3); label3.setBackground(new Color(127,255,212));
		panel.add(label4); label4.setBackground(new Color(250,250,210));
		panel.add(label5); label5.setBackground(new Color(238,130,238));
		panel.add(label6); label6.setBackground(new Color(78,238,148));
		panel1.add(field);
		panel1.add(text);
		text.setBorder (BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,50)));
		text.setHorizontalAlignment(SwingConstants.CENTER); 
		panel2.add(label);
		panel1.add(button);
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.setSize(700,400);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1.setOpaque(true);
		label2.setOpaque(true);
		label3.setOpaque(true);	
		label4.setOpaque(true);
		label5.setOpaque(true);
		label6.setOpaque(true);	
		text.addActionListener(new DeepDishListener());
		button.addActionListener(new BackListener());
		slp=new Sleeping();
		slp.start();
		frame.addMouseMotionListener(new MouseAdapter(){
		public void mouseMoved(MouseEvent e){
			slp.setT();}});
	}
	
	public void regoDish(String a,String b,String c){				//the input option was wrong, output names of choosed kind of dishes again.
		frame = new JFrame();
		button=new JButton("Back");
		frame.getContentPane().setBackground(Color.RED);
		JLabel label = new JLabel("Wrong! Please select a right option:");
		label.setFont(new Font("Dialog",1,20));
		label.setForeground(Color.RED);
		label.setBackground(new Color(65,105,225));
		label.setOpaque(true);
		Font font=new Font("Calibri",Font.BOLD,25);
		JTextField field = new JTextField("Option selected:",9);
		field.setFont(font);
		field.setOpaque(false);
		field.setEditable(false);
		text.setOpaque(false);
		field.setBorder (BorderFactory.createLineBorder(new Color(65,105,225)));
		JLabel label1=new JLabel("1:"+a,JLabel.CENTER);
		JLabel label2=new JLabel("2:"+b,JLabel.CENTER);
		JLabel label3=new JLabel("3:"+c,JLabel.CENTER);
		JLabel label4 =new JLabel("  ");
		JLabel label5 =new JLabel("  ");
		JLabel label6 =new JLabel("  ");
		label1.setFont(new Font("Dialog",1,17));
		label2.setFont(new Font("Dialog",1,17));
		label3.setFont(new Font("Dialog",1,17));
		JPanel panel1=new JPanel(new FlowLayout(2,10,10));
		JPanel panel4=new JPanel();
		JPanel panel3=new JPanel();
		panel4.setBackground(new Color(65,105,225));
		panel3.setBackground(new Color(65,105,225));
		panel1.setBackground(new Color(65,105,225));
		frame.getContentPane().add(BorderLayout.WEST,panel4);
		frame.getContentPane().add(BorderLayout.EAST,panel3);
		JPanel panel=new JPanel(new GridLayout(2,3,2,2));
		panel.setBackground(new Color(65,105,225));
		JPanel panel2=new JPanel(new GridLayout(1,2));
		frame.getContentPane().add(BorderLayout.NORTH,panel2);		
		frame.getContentPane().add(BorderLayout.SOUTH,panel1);
		panel.add(label1); label1.setBackground(new Color(176,196,222)); 
		panel.add(label2); label2.setBackground(new Color(244,164,96));
		panel.add(label3); label3.setBackground(new Color(127,255,212));
		panel.add(label4); label4.setBackground(new Color(250,250,210));
		panel.add(label5); label5.setBackground(new Color(238,130,238));
		panel.add(label6); label6.setBackground(new Color(78,238,148));
		panel1.add(field);
		panel1.add(text);
		text.setBorder (BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,50)));
		text.setHorizontalAlignment(SwingConstants.CENTER); 
		panel2.add(label);
		panel1.add(button);
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.setSize(700,400);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1.setOpaque(true);
		label2.setOpaque(true);
		label3.setOpaque(true);	
		label4.setOpaque(true);
		label5.setOpaque(true);
		label6.setOpaque(true);	
		button.addActionListener(new BackListener());
		text.addActionListener(new DeepDishListener());
		slp=new Sleeping();
		slp.start();
		frame.addMouseMotionListener(new MouseAdapter(){
		public void mouseMoved(MouseEvent e){
			slp.setT();}});
		}

	public void DeepgoDish(String a,int b,int c){					//output the detial information about choosed dish.
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65,105,225));
		button=new JButton("Back");
		JLabel label = new JLabel("Information about this dish:");
		label.setFont(new Font("Dialog",1,20));
		JButton button1=new JButton("Order this dish!");
		JLabel label1=new JLabel(a,JLabel.CENTER);
		JLabel label2=new JLabel("Rrice:"+b+"RMB",JLabel.CENTER);
		JLabel label3=new JLabel("Available number:"+c,JLabel.CENTER);
		label1.setFont(new Font("Dialog",1,17));
		label2.setFont(new Font("Dialog",1,17));
		label3.setFont(new Font("Dialog",1,17));
		JPanel panel1=new JPanel(new GridLayout(1,2));
		JPanel panel=new JPanel(new GridLayout(3,1));
		frame.getContentPane().add(BorderLayout.NORTH,panel1);		
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		panel.add(label1); 
		panel.add(label2); 
		panel.add(label3); 
		panel1.add(label);
		panel1.add(button1);
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.setSize(700,400);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new BackListener());
		button1.addActionListener(new Order1Listener());
		slp=new Sleeping();
		slp.start();
		frame.addMouseMotionListener(new MouseAdapter(){
		public void mouseMoved(MouseEvent e){
			slp.setT();}});
		}

	public void OrderFail(String a,String b,String c){				//the dish isn't available, so recommmend other option.
		frame = new JFrame();
		button=new JButton("Back");
		JLabel label = new JLabel("<html>This one isn't available. <br>Please select other option:</html>");
		label.setFont(new Font("Dialog",1,20));
		label.setBackground(new Color(65,105,225));
		label.setOpaque(true);
		Font font=new Font("Calibri",Font.BOLD,25);
		JTextField field = new JTextField("Option selected:",9);
		field.setFont(font);
		field.setOpaque(false);
		field.setEditable(false);
		text.setOpaque(false);
		field.setBorder (BorderFactory.createLineBorder(new Color(65,105,225)));
		JLabel label7 = new JLabel("Option selectd:");
		label7.setFont(new Font("Dialog",1,30));
		JLabel label1=new JLabel("1:"+a,JLabel.CENTER);
		JLabel label2=new JLabel("2:"+b,JLabel.CENTER);
		JLabel label3=new JLabel("3:"+c,JLabel.CENTER);
		JLabel label4 =new JLabel("  ");
		JLabel label5 =new JLabel("  ");
		JLabel label6 =new JLabel("  ");
		label1.setFont(new Font("Dialog",1,17));
		label2.setFont(new Font("Dialog",1,17));
		label3.setFont(new Font("Dialog",1,17));
		JPanel panel1=new JPanel(new FlowLayout(2,10,10));
		JPanel panel4=new JPanel();
		JPanel panel3=new JPanel();
		panel4.setBackground(new Color(65,105,225));
		panel3.setBackground(new Color(65,105,225));
		panel1.setBackground(new Color(65,105,225));
		JPanel panel=new JPanel(new GridLayout(2,3,2,2)); 
		frame.getContentPane().add(BorderLayout.WEST,panel4);
		frame.getContentPane().add(BorderLayout.EAST,panel3);
		JPanel panel2=new JPanel(new GridLayout(1,2));
		frame.getContentPane().add(BorderLayout.NORTH,panel2);		
		frame.getContentPane().add(BorderLayout.SOUTH,panel1);
		panel.add(label1); label1.setBackground(new Color(176,196,222)); 
		panel.add(label2); label2.setBackground(new Color(244,164,96));
		panel.add(label3); label3.setBackground(new Color(127,255,212));
		panel.add(label4); label4.setBackground(new Color(250,250,210));
		panel.add(label5); label5.setBackground(new Color(238,130,238));
		panel.add(label6); label6.setBackground(new Color(78,238,148));
		panel1.add(field);
		panel1.add(text);
		text.setBorder (BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,50)));
		text.setHorizontalAlignment(SwingConstants.CENTER); 
		panel2.add(label);
		panel1.add(button);
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		panel.setBackground(new Color(65,105,225));
		frame.setSize(700,400);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1.setOpaque(true);
		label2.setOpaque(true);
		label3.setOpaque(true);	
		label4.setOpaque(true);
		label5.setOpaque(true);
		label6.setOpaque(true);	
		button.addActionListener(new BackListener());
		text.addActionListener(new DeepDishListener());
		slp=new Sleeping();
		slp.start();
		frame.addMouseMotionListener(new MouseAdapter(){
		public void mouseMoved(MouseEvent e){
			slp.setT();}});
	}
	
	public void OrderSucceed(){										//order successfully and custmoer can continue to order or finish ordering dishes.
		Dishes[] dish=new Dishes[8];
		int i=0,j=0;
		try{	ObjectInputStream ris =new ObjectInputStream(new FileInputStream("../../Files/RDishes.ser"));
		while(ris.readObject()!=null){
			i++;}}
		catch(Exception ex){
			ex.printStackTrace();}
		try{	ObjectInputStream ris =new ObjectInputStream(new FileInputStream("../../Files/RDishes.ser"));
		while(i>j){
			dish[j]=(Dishes) ris.readObject();
			j++;}
			}
		catch(Exception ex){
			ex.printStackTrace();}
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/Dishes.ser"));
			dish[j]=(Dishes) is.readObject();}
		catch(Exception ex){
			ex.printStackTrace();}
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/RDishes.ser"));
		while(j>=0){
		os.writeObject(dish[j]);
		System.out.println(dish[j].getDish()+" "+dish[j].getPrice()+" 1");
		j--;
		}
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}
		frame = new JFrame();
		button2=new JButton("Continue to order");
		button2.addActionListener(new BackListener());
		button1=new JButton("Finish order");
		button1.addActionListener(new JokeListener());
		frame.getContentPane().setBackground(Color.RED);
		JLabel label1 = new JLabel("Order successfully",JLabel.CENTER);
		label1.setFont(new Font("Dialog",1,30));
		JPanel panel1=new JPanel(new GridLayout(1,2));
		JPanel panel=new JPanel(new GridLayout(i+2,3));
		JLabel[] label=new JLabel[24];
		JLabel label21 =new JLabel("Name",JLabel.CENTER);
		JLabel label22 =new JLabel("Price",JLabel.CENTER);
		JLabel label23 =new JLabel("Number",JLabel.CENTER);
		label21.setFont(new Font("Dialog",1,20));
		label22.setFont(new Font("Dialog",1,20));
		label23.setFont(new Font("Dialog",1,20));
		frame.getContentPane().add(BorderLayout.NORTH,label1);
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.getContentPane().add(BorderLayout.SOUTH,panel1);
		panel.add(label21); 
		panel.add(label22); 
		panel.add(label23);
		frame.setSize(700,400);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1.add(button2); panel1.add(button1);
		slp=new Sleeping();
		slp.start();
		frame.addMouseMotionListener(new MouseAdapter(){
		public void mouseMoved(MouseEvent e){
		slp.setT();}});
		while(j<=i){
		label[(j+1)*3+1]=new JLabel(dish[j+1].getDish()+" ",JLabel.CENTER);
		label[(j+1)*3+2]=new JLabel(dish[j+1].getPrice()+" ",JLabel.CENTER);
		label[(j+1)*3+3]=new JLabel("1",JLabel.CENTER);
		panel.add(label[(j+1)*3+1]);
		panel.add(label[(j+1)*3+2]);
		panel.add(label[(j+1)*3+3]);
		label[(j+1)*3+1].setFont(new Font("Dialog",1,20));
		label[(j+1)*3+2].setFont(new Font("Dialog",1,20));
		label[(j+1)*3+3].setFont(new Font("Dialog",1,20));
		j++;}	
	}
	
	class BackListener implements ActionListener{					//back to the interface where can show the kinds of dishes.
	public void actionPerformed(ActionEvent event){
		slp.out();
		RobotInterface c =new RobotInterface();
		c.go();	
		frame.dispose();}}	
		
	class goListener implements ActionListener{						//greeting is over and start next interface.
	public void actionPerformed(ActionEvent event){
	slp.out();
	RobotInterface h =new RobotInterface();
		frame.dispose();
		h.go();	
	}}
	
	class DishListener implements ActionListener{					//judge input and call for rego method or goDish method.
	public void actionPerformed(ActionEvent event){
		slp.out();
		test=Integer.parseInt(text.getText());
		M.output(test);												//save the first input.
		if((test!=1)&&(test!=2)&&(test!=3)&&(test!=4)&&(test!=5))	//judge input and input is wrong.
			{RobotInterface b=new RobotInterface();
			 frame.dispose();
			 b.rego();}
		else{														//input is right.
		RobotInterface a=new RobotInterface();	
		switch(test){												//switch by the number of the first input and second input. Call for goDish method.
		case 1:
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/FishDishes.ser"));
		FishDishes rone=(FishDishes) is.readObject();
		FishDishes rtwo=(FishDishes) is.readObject();
		FishDishes rthree=(FishDishes) is.readObject();
		a.goDish(rone.getDish(),rtwo.getDish(),rthree.getDish());}			
		catch(Exception ex){
			ex.printStackTrace();}
		break;
		case 2:
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/MeatDishes.ser"));
		MeatDishes rone=(MeatDishes) is.readObject();
		MeatDishes rtwo=(MeatDishes) is.readObject();
		MeatDishes rthree=(MeatDishes) is.readObject();
		a.goDish(rone.getDish(),rtwo.getDish(),rthree.getDish());}			
		catch(Exception ex){
			ex.printStackTrace();}
		break;
		case 3:
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/RiceDishes.ser"));
		RiceDishes rone=(RiceDishes) is.readObject();
		RiceDishes rtwo=(RiceDishes) is.readObject();
		RiceDishes rthree=(RiceDishes) is.readObject();
		a.goDish(rone.getDish(),rtwo.getDish(),rthree.getDish());}			
		catch(Exception ex){
			ex.printStackTrace();}
		break;
		case 4:
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/NoodleDishes.ser"));
		NoodleDishes rone=(NoodleDishes) is.readObject();
		NoodleDishes rtwo=(NoodleDishes) is.readObject();
		NoodleDishes rthree=(NoodleDishes) is.readObject();
		a.goDish(rone.getDish(),rtwo.getDish(),rthree.getDish());}			
		catch(Exception ex){
			ex.printStackTrace();}
		break;
		case 5:
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/Drink.ser"));
		Drink rone=(Drink) is.readObject();
		Drink rtwo=(Drink) is.readObject();
		Drink rthree=(Drink) is.readObject();
		a.goDish(rone.getDish(),rtwo.getDish(),rthree.getDish());}			
		catch(Exception ex){
			ex.printStackTrace();}
		break;}	
		}
		frame.dispose();
	}	
	}

	class DeepDishListener implements ActionListener{				//judge input and call for regoDish method or DeepgoDish method.
	public void actionPerformed(ActionEvent event){
		slp.out();
		frame.dispose();
		test1=Integer.parseInt(text.getText());
		M1.output(test1);
		if((test1!=1)&&(test1!=2)&&(test1!=3))						//judge input and the input is wrong.
		{
		RobotInterface d=new RobotInterface();
		d.test=M.getText();
		switch(d.test){												//read corresponding information of dish. 
		case 1:
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/FishDishes.ser"));
		FishDishes rone=(FishDishes) is.readObject();
		FishDishes rtwo=(FishDishes) is.readObject();
		FishDishes rthree=(FishDishes) is.readObject();
		d.regoDish(rone.getDish(),rtwo.getDish(),rthree.getDish());}		//Call for regoDish method.
		catch(Exception ex){
			ex.printStackTrace();}
		break;
		case 2:
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/MeatDishes.ser"));
		MeatDishes rone=(MeatDishes) is.readObject();
		MeatDishes rtwo=(MeatDishes) is.readObject();
		MeatDishes rthree=(MeatDishes) is.readObject();
		d.regoDish(rone.getDish(),rtwo.getDish(),rthree.getDish());}			
		catch(Exception ex){
			ex.printStackTrace();}
		break;
		case 3:
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/RiceDishes.ser"));
		RiceDishes rone=(RiceDishes) is.readObject();
		RiceDishes rtwo=(RiceDishes) is.readObject();
		RiceDishes rthree=(RiceDishes) is.readObject();
		d.regoDish(rone.getDish(),rtwo.getDish(),rthree.getDish());}			
		catch(Exception ex){
			ex.printStackTrace();}
		break;
		case 4:
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/NoodleDishes.ser"));
		NoodleDishes rone=(NoodleDishes) is.readObject();
		NoodleDishes rtwo=(NoodleDishes) is.readObject();
		NoodleDishes rthree=(NoodleDishes) is.readObject();
		d.regoDish(rone.getDish(),rtwo.getDish(),rthree.getDish());}			
		catch(Exception ex){
			ex.printStackTrace();}
		break;
		case 5:
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/Drink.ser"));
		Drink rone=(Drink) is.readObject();
		Drink rtwo=(Drink) is.readObject();
		Drink rthree=(Drink) is.readObject();
		d.regoDish(rone.getDish(),rtwo.getDish(),rthree.getDish());}			
		catch(Exception ex){
			ex.printStackTrace();}
		break;}	
		}
		else{														//judge second input and the second input is right.
		RobotInterface e=new RobotInterface();						
		e.test=M.getText();											//read first input from Text.ser.
		if(e.test==1){												//judge the number of the first input and second input. Call for DeepgoDish method.
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/FishDishes.ser"));
		FishDishes rone=(FishDishes) is.readObject();
		FishDishes rtwo=(FishDishes) is.readObject();
		FishDishes rthree=(FishDishes) is.readObject();
		if(test1==1){
		e.DeepgoDish(rone.getDish(),rone.getPrice(),rone.getNum());}
		else if(test1==2){
		e.DeepgoDish(rtwo.getDish(),rtwo.getPrice(),rtwo.getNum());}
		else{														 
		e.DeepgoDish(rthree.getDish(),rthree.getPrice(),rthree.getNum());}}			
		catch(Exception ex){
			ex.printStackTrace();}
		}
		else if(e.test==2){
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/MeatDishes.ser"));
		MeatDishes rone=(MeatDishes) is.readObject();
		MeatDishes rtwo=(MeatDishes) is.readObject();
		MeatDishes rthree=(MeatDishes) is.readObject();
		if(test1==1){
		e.DeepgoDish(rone.getDish(),rone.getPrice(),rone.getNum());}
		else if(test1==2){
		e.DeepgoDish(rtwo.getDish(),rtwo.getPrice(),rtwo.getNum());}
		else{
		e.DeepgoDish(rthree.getDish(),rthree.getPrice(),rthree.getNum());}}			
		catch(Exception ex){
			ex.printStackTrace();}
		}
		else if(e.test==3){
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/RiceDishes.ser"));
		RiceDishes rone=(RiceDishes) is.readObject();
		RiceDishes rtwo=(RiceDishes) is.readObject();
		RiceDishes rthree=(RiceDishes) is.readObject();
		if(test1==1){
		e.DeepgoDish(rone.getDish(),rone.getPrice(),rone.getNum());}
		else if(test1==2){
		e.DeepgoDish(rtwo.getDish(),rtwo.getPrice(),rtwo.getNum());}
		else{
		e.DeepgoDish(rthree.getDish(),rthree.getPrice(),rthree.getNum());}}			
		catch(Exception ex){
			ex.printStackTrace();}
		}	
		else if(e.test==4){
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/NoodleDishes.ser"));
		NoodleDishes rone=(NoodleDishes) is.readObject();
		NoodleDishes rtwo=(NoodleDishes) is.readObject();
		NoodleDishes rthree=(NoodleDishes) is.readObject();
		if(test1==1){
		e.DeepgoDish(rone.getDish(),rone.getPrice(),rone.getNum());}
		else if(test1==2){
		e.DeepgoDish(rtwo.getDish(),rtwo.getPrice(),rtwo.getNum());}
		else{
		e.DeepgoDish(rthree.getDish(),rthree.getPrice(),rthree.getNum());}}			
		catch(Exception ex){
			ex.printStackTrace();}
		}	
		else if(e.test==5){
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/Drink.ser"));
		Drink rone=(Drink) is.readObject();
		Drink rtwo=(Drink) is.readObject();
		Drink rthree=(Drink) is.readObject();
		if(test1==1){
		e.DeepgoDish(rone.getDish(),rone.getPrice(),rone.getNum());}
		else if(test1==2){
		e.DeepgoDish(rtwo.getDish(),rtwo.getPrice(),rtwo.getNum());}
		else{
		e.DeepgoDish(rthree.getDish(),rthree.getPrice(),rthree.getNum());}}			
		catch(Exception ex){
			ex.printStackTrace();}
		}}

}}	
	
	class Order1Listener implements ActionListener{					//judge input text and available number of choosed dishes.
	public void actionPerformed(ActionEvent event){
		slp.out();
		frame.dispose();
		int i=M.getText();											//read choices.
		int j=M1.getText1();
		int num1=0,num2=0,num3=0;
		RobotInterface g=new RobotInterface();
		Dishes f=new Dishes("1",1,1);
		if (i==1){
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/FishDishes.ser"));		//read the information of dishes.
		FishDishes rone=(FishDishes) is.readObject();
		FishDishes rtwo=(FishDishes) is.readObject();
		FishDishes rthree=(FishDishes) is.readObject();
		num1=rone.getNum();
		num2=rtwo.getNum();
		num3=rthree.getNum();
			if((j==1)&&(num1==0))																				//judge input text and available number of choosed dishes.
				g.OrderFail(rone.getDish(),rtwo.getDish(),rthree.getDish());									//if the dish isn't available, turn to method OrderFail().
			else if((j==2)&&(num2==0))
				g.OrderFail(rone.getDish(),rtwo.getDish(),rthree.getDish());
			else if((j==3)&&(num3==0))
				g.OrderFail(rone.getDish(),rtwo.getDish(),rthree.getDish());
			else{
		rone.decrease(j);																						//if the dish is available, the available of dish decrease 1.
		if(j==1)
		f=new Dishes(rone.getDish(),rone.getPrice(),rone.getNum());
		else if(j==2)
		f=new Dishes(rtwo.getDish(),rtwo.getPrice(),rtwo.getNum());												//save choosed dish into Dishes;
		else if(j==3)
		f=new Dishes(rthree.getDish(),rthree.getPrice(),rthree.getNum());	
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/Dishes.ser"));		//save Dishes to Dishes.ser;
		os.writeObject(f);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}	
		g.OrderSucceed();}
		}
		catch(Exception ex){
			ex.printStackTrace();}
		}
		else if (i==2){
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/MeatDishes.ser"));
		MeatDishes rone=(MeatDishes) is.readObject();
		MeatDishes rtwo=(MeatDishes) is.readObject();
		MeatDishes rthree=(MeatDishes) is.readObject();
		num1=rone.getNum();
		num2=rtwo.getNum();
		num3=rthree.getNum();
			if((j==1)&&(num1==0))
				g.OrderFail(rone.getDish(),rtwo.getDish(),rthree.getDish());
			else if((j==2)&&(num2==0))
				g.OrderFail(rone.getDish(),rtwo.getDish(),rthree.getDish());
			else if((j==3)&&(num3==0))
				g.OrderFail(rone.getDish(),rtwo.getDish(),rthree.getDish());
			else{
		rone.decrease(j);
		if(j==1)
		f=new Dishes(rone.getDish(),rone.getPrice(),rone.getNum());
		else if(j==2)
		f=new Dishes(rtwo.getDish(),rtwo.getPrice(),rtwo.getNum());
		else if(j==3)
		f=new Dishes(rthree.getDish(),rthree.getPrice(),rthree.getNum());	
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/Dishes.ser"));
		os.writeObject(f);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}	
		g.OrderSucceed();}}
		catch(Exception ex){
			ex.printStackTrace();}}
			
		else if (i==3){
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/RiceDishes.ser"));
		RiceDishes rone=(RiceDishes) is.readObject();
		RiceDishes rtwo=(RiceDishes) is.readObject();
		RiceDishes rthree=(RiceDishes) is.readObject();
		num1=rone.getNum();
		num2=rtwo.getNum();
		num3=rthree.getNum();
			if((j==1)&&(num1==0))
				g.OrderFail(rone.getDish(),rtwo.getDish(),rthree.getDish());
			else if((j==2)&&(num2==0))
				g.OrderFail(rone.getDish(),rtwo.getDish(),rthree.getDish());
			else if((j==3)&&(num3==0))
				g.OrderFail(rone.getDish(),rtwo.getDish(),rthree.getDish());
			else{
		rone.decrease(j);
		if(j==1)
		f=new Dishes(rone.getDish(),rone.getPrice(),rone.getNum());
		else if(j==2)
		f=new Dishes(rtwo.getDish(),rtwo.getPrice(),rtwo.getNum());
		else if(j==3)
		f=new Dishes(rthree.getDish(),rthree.getPrice(),rthree.getNum());	
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/Dishes.ser"));
		os.writeObject(f);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}	
		g.OrderSucceed();}}
		catch(Exception ex){
			ex.printStackTrace();}}
		else if (i==4){
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/NoodleDishes.ser"));
		NoodleDishes rone=(NoodleDishes) is.readObject();
		NoodleDishes rtwo=(NoodleDishes) is.readObject();
		NoodleDishes rthree=(NoodleDishes) is.readObject();
		num1=rone.getNum();
		num2=rtwo.getNum();
		num3=rthree.getNum();
			if((j==1)&&(num1==0))
				g.OrderFail(rone.getDish(),rtwo.getDish(),rthree.getDish());
			else if((j==2)&&(num2==0))
				g.OrderFail(rone.getDish(),rtwo.getDish(),rthree.getDish());
			else if((j==3)&&(num3==0))
				g.OrderFail(rone.getDish(),rtwo.getDish(),rthree.getDish());
			else{
		rone.decrease(j);
		if(j==1)
		f=new Dishes(rone.getDish(),rone.getPrice(),rone.getNum());
		else if(j==2)
		f=new Dishes(rtwo.getDish(),rtwo.getPrice(),rtwo.getNum());
		else if(j==3)
		f=new Dishes(rthree.getDish(),rthree.getPrice(),rthree.getNum());	
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/Dishes.ser"));
		os.writeObject(f);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}	
		g.OrderSucceed();}}
		catch(Exception ex){
			ex.printStackTrace();}}
			
		else if (i==5){
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/Drink.ser"));
		Drink rone=(Drink) is.readObject();
		Drink rtwo=(Drink) is.readObject();
		Drink rthree=(Drink) is.readObject();
		num1=rone.getNum();
		num2=rtwo.getNum();
		num3=rthree.getNum();
			if((j==1)&&(num1==0))
				g.OrderFail(rone.getDish(),rtwo.getDish(),rthree.getDish());
			else if((j==2)&&(num2==0))
				g.OrderFail(rone.getDish(),rtwo.getDish(),rthree.getDish());
			else if((j==3)&&(num3==0))
				g.OrderFail(rone.getDish(),rtwo.getDish(),rthree.getDish());
			else{
		rone.decrease(j);
		if(j==1)
		f=new Dishes(rone.getDish(),rone.getPrice(),rone.getNum());
		else if(j==2)
		f=new Dishes(rtwo.getDish(),rtwo.getPrice(),rtwo.getNum());
		else if(j==3)
		f=new Dishes(rthree.getDish(),rthree.getPrice(),rthree.getNum());	
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/Dishes.ser"));
		os.writeObject(f);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}	
		g.OrderSucceed();}}
		catch(Exception ex){
			ex.printStackTrace();}
	}
	}}
	
	class JokeListener implements ActionListener{					//output jokes.
	public void actionPerformed(ActionEvent event){
		frame.dispose();
		slp.out();
		frame = new JFrame();
		button1=new JButton("Stop jokes!");
		button1.addActionListener(new StopListener());
		button2=new JButton("Continue to order");
		button2.addActionListener(new BackListener());
		button=new JButton("Pay bills");
		button.addActionListener(new PayListener());		
		JPanel panel=new JPanel(new GridLayout(1,3));
		String s="1";
		int i =(int)(Math.random()*4);
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/Jokes.ser"));       //read jokes from Jokes.ser.
		Jokes rone=(Jokes) is.readObject();
		Jokes rtwo=(Jokes) is.readObject();
		Jokes rthree=(Jokes) is.readObject();
		Jokes rfour=(Jokes) is.readObject();
		if(i==0)
		s=rone.getJokes();
		else if(i==1)
		s=rtwo.getJokes();
		else if (i==2)
		s=rthree.getJokes();
		else if (i==3)
		s=rfour.getJokes();}			
		catch(Exception ex){
			ex.printStackTrace();}
		JLabel label1 = new JLabel(s,JLabel.CENTER);                                          
		label1.setFont(new Font("Dialog",1,15));
		frame.getContentPane().add(BorderLayout.SOUTH,panel);
		frame.getContentPane().add(BorderLayout.CENTER,label1);
		panel.add(button2); panel.add(button1); panel.add(button);
		frame.setSize(700,400);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		slp=new Sleeping();
		slp.start();
		frame.addMouseMotionListener(new MouseAdapter(){
		public void mouseMoved(MouseEvent e){
			slp.setT();}});
	}}
	
	class StopListener extends JPanel implements ActionListener{	//stop jokes.
	public void actionPerformed(ActionEvent event){
		slp.out();
		frame.dispose();
		frame = new JFrame();
		JPanel picture=new JPanel(){
		public void paintComponent(Graphics g) {
		ImageIcon image =new ImageIcon("chatu.jpg");
		g.drawImage(image.getImage(),245,0,209,this.getHeight(),this);		//remove jokes to a picture. 
		}};
		button2=new JButton("Continue to order");
		button2.addActionListener(new BackListener());
		button=new JButton("Pay bills");
		button.addActionListener(new PayListener());		
		JPanel panel=new JPanel(new GridLayout(1,2));
		frame.getContentPane().add(BorderLayout.SOUTH,panel);
		frame.getContentPane().add(BorderLayout.CENTER,picture);
		panel.add(button2);panel.add(button);
		frame.setSize(700,400);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		slp=new Sleeping();
		slp.start();
		frame.addMouseMotionListener(new MouseAdapter(){
		public void mouseMoved(MouseEvent e){
			slp.setT();}});
	}}	

	class PayListener implements ActionListener{					//show all the dishes had been ordered.
	public void actionPerformed(ActionEvent event){
		slp.out();
		frame.dispose();
		Dishes[] dish1=new Dishes[8];
		int i=0,j=0,price=0;
		try{	ObjectInputStream ris =new ObjectInputStream(new FileInputStream("../../Files/RDishes.ser"));		//record the number of dishes.
		while(ris.readObject()!=null){
			i++;}}
		catch(Exception ex){
			ex.printStackTrace();}
		try{	ObjectInputStream ris =new ObjectInputStream(new FileInputStream("../../Files/RDishes.ser"));		//save dishes into Dishes.
		while(i>j){
			dish1[j]=(Dishes) ris.readObject();
			j++;}
			}
		catch(Exception ex){
			ex.printStackTrace();}
		frame = new JFrame();
		button2=new JButton("Continue to order");
		button2.addActionListener(new BackListener());
		button1=new JButton("Finish meal");
		button1.addActionListener(new MealListener());
		frame.getContentPane().setBackground(Color.RED);
		JLabel label1 = new JLabel("All dishes",JLabel.CENTER);
		label1.setFont(new Font("Dialog",1,30));
		JPanel panel=new JPanel(new GridLayout(i+1,3));
		JLabel[] label=new JLabel[24];	
		JPanel panel1=new JPanel(new GridLayout(1,3));
		JPanel panel2=new JPanel(new GridLayout(1,2));
		frame.getContentPane().add(BorderLayout.NORTH,panel1);
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.getContentPane().add(BorderLayout.SOUTH,panel2);
		JLabel label2 = new JLabel("Total price: ",JLabel.CENTER);
		label2.setFont(new Font("Dialog",1,30));
		panel2.add(label2); panel1.add(label1); panel1.add(button2); panel1.add(button1);
		JLabel label21 =new JLabel("Name",JLabel.CENTER);
		JLabel label22 =new JLabel("Price",JLabel.CENTER);
		JLabel label23 =new JLabel("Number",JLabel.CENTER);
		label21.setFont(new Font("Dialog",1,20));
		label22.setFont(new Font("Dialog",1,20));
		label23.setFont(new Font("Dialog",1,20));
		panel.add(label21); 
		panel.add(label22); 
		panel.add(label23);
		frame.setSize(700,400);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j=0;
		while(j<i){
		label[(j)*3+1]=new JLabel(dish1[j].getDish()+" ",JLabel.CENTER);
		label[(j)*3+2]=new JLabel(dish1[j].getPrice()+" ",JLabel.CENTER);
		label[(j)*3+3]=new JLabel("1",JLabel.CENTER);
		panel.add(label[(j)*3+1]);
		panel.add(label[(j)*3+2]);
		panel.add(label[(j)*3+3]);
		label[(j)*3+1].setFont(new Font("Dialog",1,20));
		label[(j)*3+2].setFont(new Font("Dialog",1,20));
		label[(j)*3+3].setFont(new Font("Dialog",1,20));
		price=price+dish1[j].getPrice();
		j++;}	
		JLabel label3 = new JLabel("RMB "+price,JLabel.CENTER);
		label3.setFont(new Font("Dialog",1,30));
		panel2.add(label3);
		slp=new Sleeping();
		slp.start();
		frame.addMouseMotionListener(new MouseAdapter(){
		public void mouseMoved(MouseEvent e){
			slp.setT();}});
	}}	
	
	class MealListener implements ActionListener{					//when customer finish meal, give farewell message.
	public void actionPerformed(ActionEvent event){
		slp.out();
		frame.dispose();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65,105,225));
		int i =(int)(Math.random()*3);
		String s="hahah";
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/Farewell.ser"));
		Farewell rone=(Farewell) is.readObject();
		Farewell rtwo=(Farewell) is.readObject();
		Farewell rthree=(Farewell) is.readObject();
		Farewell rfour=(Farewell) is.readObject();
		if(i==0)
		s=rone.getFarewell();
		else if(i==1)
		s=rtwo.getFarewell();
		else if (i==2)
		s=rthree.getFarewell();
		else if (i==3)
		s=rfour.getFarewell();	}	
		catch(Exception ex){
			ex.printStackTrace();}
		JLabel label = new JLabel(s,JLabel.CENTER);
		label.setFont(new Font("Dialog",1,30));
		button=new JButton("New customer");
		frame.getContentPane().add(BorderLayout.CENTER,label);
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		frame.setSize(700,400);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new RestartListener());
		slp=new Sleeping();
		slp.start();
		frame.addMouseMotionListener(new MouseAdapter(){
		public void mouseMoved(MouseEvent e){
			slp.setT();}});
	}}
	
	class RestartListener implements ActionListener,Serializable{	//to welcome new customers.
	public void actionPerformed(ActionEvent event){
		slp.out();
		frame.dispose();
		RobotInterface i =new RobotInterface();
		i.greet();
		Dishes z =new Dishes(",",1,1);
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/RDishes.ser"));
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}
	}}
	
	class exitListener implements ActionListener{					//exit sleeping.
	public void actionPerformed(ActionEvent event){	
	frame.dispose();}}
	
	}