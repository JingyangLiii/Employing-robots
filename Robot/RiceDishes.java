import java.io.*;
public class RiceDishes implements Serializable{
	private String d;
	private int price;
	private int num;
	RiceDishes one,two,three;
	public RiceDishes(String d,int price,int num){
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
		try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/RiceDishes.ser"));
		RiceDishes rone=(RiceDishes) is.readObject();
		RiceDishes rtwo=(RiceDishes) is.readObject();
		RiceDishes rthree=(RiceDishes) is.readObject();
		num1=rone.getNum();
		num2=rtwo.getNum();
		num3=rthree.getNum();
		if(i==1){
		one=new RiceDishes("hong chang chaofan",1000,num1-1);
		two=new RiceDishes("huangjin da pai fan",900,num2);
		three=new RiceDishes("huotui chaofan",800,num3);}
		else if (i==2){
		one=new RiceDishes("hong chang chaofan",1000,num1);
		two=new RiceDishes("huangjin da pai fan",900,num2-1);
		three=new RiceDishes("huotui chaofan",800,num3);}
		else {
		one=new RiceDishes("hong chang chaofan",1000,num1);
		two=new RiceDishes("huangjin da pai fan",900,num2);
		three=new RiceDishes("huotui chaofan",800,num3-1);}
		
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/RiceDishes.ser"));
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
		RiceDishes one=new RiceDishes("hong chang chaofan",1000,3);
		RiceDishes two=new RiceDishes("huangjin da pai fan",900,3);
		RiceDishes three=new RiceDishes("huotui chaofan",800,3);
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/RiceDishes.ser"));
		os.writeObject(one);
		os.writeObject(two);
		os.writeObject(three);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}
 }
}