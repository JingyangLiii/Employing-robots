import java.io.*;
public class NoodleDishes implements Serializable{
	private String d;
	private int price;
	private int num;
	NoodleDishes one,two,three;
	public NoodleDishes (String d,int price,int num){
	this.d=d;
	this.price=price;
	this.num=num;}

	public int getPrice(){
		return price;}
	public int getNum(){
		return num;}
	public String getDish(){
		return d;}

	public void decrease(int i){
		int num1=0,num2=0,num3=0;
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/NoodleDishes.ser"));
		NoodleDishes rone=(NoodleDishes) is.readObject();
		NoodleDishes rtwo=(NoodleDishes) is.readObject();
		NoodleDishes rthree=(NoodleDishes) is.readObject();
		num1=rone.getNum();
		num2=rtwo.getNum();
		num3=rthree.getNum();
		if(i==1){
		one=new NoodleDishes("miantiao",1000,num1-1);
		two=new NoodleDishes("chaomian",900,num2);
		three=new NoodleDishes("tangmian",800,num3);}
		else if (i==2){
		one=new NoodleDishes("miantiao",1000,num1);
		two=new NoodleDishes("chaomian",900,num2-1);
		three=new NoodleDishes("tangmian",800,num3);}
		else {
		one=new NoodleDishes("miantiao",1000,num1);
		two=new NoodleDishes("chaomian",900,num2);
		three=new NoodleDishes("tangmian",800,num3-1);}
		
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/NoodleDishes.ser"));
		os.writeObject(one);
		os.writeObject(two);
		os.writeObject(three);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}}
		catch(Exception ex){
			ex.printStackTrace();}
}
		
	public void renew(){
		NoodleDishes one=new NoodleDishes("miantiao",1000,3);
		NoodleDishes two=new NoodleDishes("chaomian",900,3);
		NoodleDishes three=new NoodleDishes("tangmian",800,3);
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/NoodleDishes.ser"));
		os.writeObject(one);
		os.writeObject(two);
		os.writeObject(three);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}
 }	
}
