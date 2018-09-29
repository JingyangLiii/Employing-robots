import java.io.*;
public class MeatDishes implements Serializable{
	private String d;
	private int price;
	private int num;
	MeatDishes one,two,three;
	public MeatDishes(String d,int price,int num){
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
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/MeatDishes.ser"));
		MeatDishes rone=(MeatDishes) is.readObject();
		MeatDishes rtwo=(MeatDishes) is.readObject();
		MeatDishes rthree=(MeatDishes) is.readObject();
		num1=rone.getNum();
		num2=rtwo.getNum();
		num3=rthree.getNum();
		if(i==1){
		one=new MeatDishes("gong bao ji ding",1000,num1-1);
		two=new MeatDishes("bo luo gu lao rou",900,num2);
		three=new MeatDishes("suan tai rou si",800,num3);}
		else if (i==2){
		one=new MeatDishes("gong bao ji ding",1000,num1);
		two=new MeatDishes("bo luo gu lao rou",900,num2-1);
		three=new MeatDishes("suan tai rou si",800,num3);}
		else {
		one=new MeatDishes("gong bao ji ding",1000,num1);
		two=new MeatDishes("bo luo gu lao rou",900,num2);
		three=new MeatDishes("suan tai rou si",800,num3-1);}
		
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/MeatDishes.ser"));
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
		MeatDishes one=new MeatDishes("gong bao ji ding",1000,3);
		MeatDishes two=new MeatDishes("bo luo gu lao rou",900,3);
		MeatDishes three=new MeatDishes("suan tai rou si",800,3);
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/MeatDishes.ser"));
		os.writeObject(one);
		os.writeObject(two);
		os.writeObject(three);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}
 }
}