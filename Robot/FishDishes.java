import java.io.*;
public class FishDishes implements Serializable{
	private String d;
	private int price;
	private int num;
	FishDishes one,two,three;
	public FishDishes(String d,int price,int num){
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
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/FishDishes.ser"));
		FishDishes rone=(FishDishes) is.readObject();
		FishDishes rtwo=(FishDishes) is.readObject();
		FishDishes rthree=(FishDishes) is.readObject();
		num1=rone.getNum();
		num2=rtwo.getNum();
		num3=rthree.getNum();
		if(i==1){
		one=new FishDishes("qingzheng luyu",1000,num1-1);
		two=new FishDishes("xiamen shui zhu huoyu",900,num2);
		three=new FishDishes("sichuan huangmen man",800,num3);}
		else if (i==2){
		one=new FishDishes("qingzheng luyu",1000,num1);
		two=new FishDishes("xiamen shui zhu huoyu",900,num2-1);
		three=new FishDishes("sichuan huangmen man",800,num3);}
		else {
		one=new FishDishes("qingzheng luyu",1000,num1);
		two=new FishDishes("xiamen shui zhu huoyu",900,num2);
		three=new FishDishes("sichuan huangmen man",800,num3-1);}
		
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/FishDishes.ser"));
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
		FishDishes one=new FishDishes("qingzheng luyu",1000,3);
		FishDishes two=new FishDishes("xiamen shui zhu huoyu",900,3);
		FishDishes three=new FishDishes("sichuan huangmen man",800,3);
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/FishDishes.ser"));
		os.writeObject(one);
		os.writeObject(two);
		os.writeObject(three);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}
 }
}