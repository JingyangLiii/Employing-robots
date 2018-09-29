import java.io.*;
public class Jokes implements Serializable{
	private String joke;
	public Jokes(String joke){
		this.joke=joke;}
	public String getJokes(){
		return joke; }

	public static void main(String[] agrs){
		Jokes one=new Jokes("<html>Little Robert asked his mother for two cents.<br> What did you do with the money I gave you yesterday? <br>I gave it to a poor old woman.<br> You're a good boy, said the mother proudly. Here are two cents more. <br>But why are you so interested in the old woman? <br>She is the one who sells the candy.</html>");
		Jokes two=new Jokes("<html>I've Just Bitten My Tongue. Are we poisonous?<br> The young snake asked his mother. <br>Yes, dear, she replied, Why do you ask?<br> Cause I've just bitten my tongue! </html>");
		Jokes three=new Jokes("<html>It was rush hour and I was dashing to a train in New York City's Grand Central Terminal.<br> As I neared the gate, a plump, middle-aged woman sprinted up from behind, <br>lost her footing on the smooth marble floor and slid onto her back.<br> Her momentum carried her close to my shoes. Before I could help her,<br> however, she had scrambled up. Gaining her composure, <br>she winked at me and said, Do you always have beautiful women failing at your feet? </html>");
		Jokes four=new Jokes("<html>Q: What's the difference between a monkey and a flea?<br> A: A monkey can have fleas, but a flea can't have monkeys. </html>");
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/Jokes.ser"));
		os.writeObject(one);
		os.writeObject(two);
		os.writeObject(three);
		os.writeObject(four);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}
 }
}