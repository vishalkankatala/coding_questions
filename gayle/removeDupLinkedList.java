import java.util.*;

public class removeDupLinkedList{
	public static void main(String args[]){
		
		/*Read the inputs into a linked list*/
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		for(int i=0;i<size;i++){
			linkedList.add(new Integer(scanner.nextInt()));
		}
		
		/*Now scan and remove duplicates*/
		int k=0;
		while(k<size){
		        ListIterator<Integer> listIterator = linkedList.listIterator(k++);
			if(!listIterator.hasNext()){
				break;
			}
			int pivot = listIterator.next();
			while(listIterator.hasNext()){
				if(listIterator.next() == pivot){
					listIterator.remove();
				}
			}
		}
		
		/*Now scan and remove duplicates*/
                ListIterator<Integer> resultIterator = linkedList.listIterator();
		while(resultIterator.hasNext()){
			System.out.println(resultIterator.next());
		}
		
	}
}
