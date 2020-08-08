package spaces;

import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		Stack<Character> s1 = new Stack<Character>();

		for (Character c : s.toCharArray()) {
			if (c == '{' || c == '[' || c == '(') {
				s1.push(c);

			}

			else if (c == '}' && !s1.isEmpty() && s1.peek() == '{') {

				s1.pop();

			}

			else if (c == ']' && !s1.isEmpty() && s1.peek() == '[') {

				s1.pop();

			} else if (c == ')' && !s1.isEmpty() && s1.peek() == '(') {

				s1.pop();

			}

		}
		System.out.println(s1.isEmpty());

	}

}

