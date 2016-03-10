class LinkedListNode{
	int number;
	LinkedListNode next;
	
	public  LinkedListNode(int number){
		this.number=number;
	}
	
	public void setNumber(int number){
		this.number = number;
	}

	public void setNext(LinkedListNode next){
		this.next=next;
	}
	
	public LinkedListNode getNext(){
		return this.next;
	}
	
	public int getNumber(){
		return number;
	}
}

public class findStartingPoint{
	
	public static void main(String args[]){
		/*Build a linked list*/
		
		LinkedListNode startOfLoop=null;
		LinkedListNode firstNode = new LinkedListNode(0);
		LinkedListNode previous = firstNode;
		LinkedListNode current=null;
				
		for(int i=1;i<40;i++){
			current = new LinkedListNode(i);
			if(i==37){
                                startOfLoop=current;
                        }
			previous.setNext(current);
			previous=current;
		}
		current.setNext(startOfLoop);
		
		/*Print out the number of the cell for the starting point*/
		
		LinkedListNode p1=firstNode.getNext();
		LinkedListNode p2=firstNode.getNext().getNext();
		/*move until they collide*/
		while(true){
			System.out.println("p1: "+p1.getNumber());
			System.out.println("p2: "+p2.getNumber());
			if(p1.getNumber() == p2.getNumber()){
				break;
			}else{
				p1=p1.getNext();
				p2=p2.getNext().getNext();
			}

		}
		
		p1=firstNode;
		int x=0;
		while(x<100){
			x++;
			System.out.println("p1: "+p1.getNumber());
                        System.out.println("p2: "+p2.getNumber());
			p1=p1.getNext();
			p2=p2.getNext();
			if(p1.getNumber() == p2.getNumber()){
				System.out.println("Found the start of the loop: "+p1.getNumber());
				break;
			}			

		}
	}
}
