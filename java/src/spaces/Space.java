package spaces;

import java.util.Scanner;

public class Space {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		String s1="{}[]()";
		int c1=0,c2=0,c3=0,c4=0,c5=0,c6=0;
		char[]ch=s1.toCharArray();
		int n=s.length();
		for(int i=0;i<n;i++)
		{ 
			if(s.charAt(i)==ch[0])
				c1++;
			else if(s.charAt(i)==ch[1])
			c2++;
			else if(s.charAt(i)==ch[2])
				c3++;
				else if(s.charAt(i)==ch[3])
					c4++;
					else if(s.charAt(i)==ch[4])
						c5++;
					else if(s.charAt(i)==ch[5])
						c6++;
			
		}
		if(c1==c2&&c3==c4&&c5==c6)
		System.out.println("is valid");
		else
			System.out.println("not valid");

	}

}
