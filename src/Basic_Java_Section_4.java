import java.util.ArrayList;

public class Basic_Java_Section_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Variables
		int d = 5;
		//String c= "Atanu";
		//char letter='r';
		System.out.println(d+" "+"This is your age");
		
		//Arrays
		int[] arr =new int[5];
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
		arr[3]=4;
		arr[4]=5;
		
		//Another way
		int[] arr2= {6,7,8,9,10};
		
		System.out.println(arr2[0]);			
	
	
	//Array with for loop
  for(int i=0;i<arr2.length;i++)
  {
	  	System.out.println(arr2[i]);
  }
  
  String[] name= {"Rahul","Atanu","sanjoy"};
		  for(int i=0;i<name.length;i++)
		  {
	  System.out.println(name[i]);
		  }
		  
	//Enhanced for loop
		  
		  for(String s:name)
		  {
			  System.out.println(s);
		  }
		  
		  //If Else 
		  for(int i=0;i<arr2.length;i++)
			  if(arr2[i]%2==0)
			  {
				 System.out.println("This Is Chronology devidede by 2"+"="+ i); 
			  }
		  
			  else {
				  System.out.println("This is not devided by 2"+"="+i);
			  }

		  //Array List
		  
		  ArrayList<String> name2 = new ArrayList<String>();
		  name2.add("Atanu");
		  name2.add("Raj");
		  {
		  System.out.println(name2.get(1));
		  }
		  
		  for(int i=0;i<name2.size();i++) {
			  System.out.println(name2.get(0));
		  }
		  
		  
		  //string litteral
		  String s ="Rahul shetty Academy";
		  
		  //string with new keyword
		  //String s1 =new String("Raja academy");
		//Splited string
		  String[] newlist = s.split(" ");
		  
		  {
			  System.out.println(newlist[0].trim());
			  System.out.println(newlist[1]);
			  System.out.println(newlist[2]);
		  }
		  
		  //Print String
		  for(int i=0;i<s.length();i++) {
			  System.out.println(s.charAt(i));
		  }
		  
		  //Print String Reverse Order
		  
		  for(int i=s.length()-1;i>=0;i--) {
			  System.out.println(s.charAt(i));
		  }
		  
		  
		  
		  Basic_Java_Section_4 data = new Basic_Java_Section_4();
		  data.getData();
		  Basic_code data2 = new Basic_code();
		  data2.dataset2();
		  
		  
}
	//Method	
public void getData() {
	  System.out.println("This is the test method");
}}

