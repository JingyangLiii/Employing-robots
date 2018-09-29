import java.io.*;
public class Dishes implements Serializable{
	private String d;
	private int price;
	private int num;
	public Dishes(String d,int price,int num){
	this.d=d;
	this.price=price;
	this.num=num;}

	public int getPrice(){
		return price;}
	public int getNum(){
		return num;}
	public String getDish(){
		return d;}


	public static void main(String[] agrs){
		Dishes a =new Dishes(",",1,1);
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/RDishes.ser"));
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}
 }
}