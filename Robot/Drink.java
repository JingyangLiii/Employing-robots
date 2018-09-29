import java.io.*;
public class Drink implements Serializable{
	private String d;
	private int price;
	private int num;
	Drink one,two,three;
	public Drink(String d,int price,int num){
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
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/Drink.ser"));
		Drink rone=(Drink) is.readObject();
		Drink rtwo=(Drink) is.readObject();
		Drink rthree=(Drink) is.readObject();
		num1=rone.getNum();
		num2=rtwo.getNum();
		num3=rthree.getNum();
		if(i==1){
		one=new Drink("lvcha",1000,num1-1);
		two=new Drink("hongcha",900,num2);
		three=new Drink("molihua cha",800,num3);}
		else if (i==2){
		one=new Drink("lvcha",1000,num1);
		two=new Drink("hongcha",900,num2-1);
		three=new Drink("molihua cha",800,num3);}
		else {
		one=new Drink("lvcha",1000,num1);
		two=new Drink("hongcha",900,num2);
		three=new Drink("molihua cha",800,num3-1);}
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/Drink.ser"));
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
		Drink one=new Drink("lvcha",1000,3);
		Drink two=new Drink("hongcha",900,3);
		Drink three=new Drink("molihua cha",800,3);
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/Drink.ser"));
		os.writeObject(one);
		os.writeObject(two);
		os.writeObject(three);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}
 }
}