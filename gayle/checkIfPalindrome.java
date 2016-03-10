import java.util.*;

public class checkIfPalindrome{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string");
		char[] inputChars = scanner.next().toCharArray();
		LinkedList<Character> input = new LinkedList<Character>();
		Stack<Character> inputStack = new Stack<Character>();
		
		/*Build the linked list */
		for(int i=0;i<inputChars.length;i++){
			input.add(inputChars[i]);
		}
		
		ListIterator<Character> slowPointer = input.listIterator();
	        ListIterator<Character> fastPointer = input.listIterator();
		
		/*Find the mid-point*/
		boolean oddCount=false;
		while(fastPointer.hasNext()){
			System.out.println("Fast Pointer: "+fastPointer.next());
			if(fastPointer.hasNext()){
				fastPointer.next();
			}else{
				oddCount=true;
				
			}
			char slowPointerChar = slowPointer.next();
			System.out.println("Slow point char: "+slowPointerChar);
			inputStack.push(slowPointerChar);
		}
		if(oddCount){
			System.out.println("Odd number of chars");
			inputStack.pop();
		}
		
		boolean palindrome=true;
		while(slowPointer.hasNext()){
			char linkedListValue=slowPointer.next().charValue();
			char stackCharValue = inputStack.pop().charValue();
			System.out.println("linkedListValue: "+linkedListValue);
			System.out.println("stackCharValue: "+stackCharValue);
			if(linkedListValue != stackCharValue){
				palindrome=false;
				break;
			}
		}
		if(palindrome){
			System.out.println("Input is a palindrome");
		}else{
			System.out.println("Input is not a palindrome");
		}
	}
}
