import java.util.*;

class FiniteState{
	public Hashtable<Character,FiniteState> nextMap;
	public boolean finished;

	public FiniteState(){
		this.nextMap = new Hashtable<Character,FiniteState>();	
		this.finished=false;	
	}
	
	public void addTransition(char input, FiniteState nextState){
		this.nextMap.put(input, nextState);
	}
	
	public void setFinished(){
		this.finished=true;
	}
}

public class exactMatchString{
	public static void findPrefixMappings(char[] input, int curIndex, FiniteState currentState, FiniteState[] states){
		int k=curIndex;
		while(k>0)
		{
			if(currentState.nextMap.hasKey(input[k])){
				continue;
			}	
			int leftStartingPoint = 0;
			int rightStartingPoint = curIndex-k+1;
			boolean prefixPossible=true;
			for(int i=0;i<k;i++){
				if(input[leftStartingPoint+i] != input[rightStartingPoint+i]){
					prefixPossible=false;
				}
			}
			if(prefixPossible){
				/*Insert the kth element and map it to the kth node*/
				currentState.addTransition(input[k],states[k]);
			}
			k--;
		}	
	}
	
	public static void main(String args[]){
		System.out.println("Enter the main string and search string");
		Scanner scanner = new Scanner(System.in);
		char[] mainString = scanner.next().toCharArray();
		char[] searchString = scanner.next().toCharArray();
		
		/*Build a automata table for search string*/
		FiniteState previousState=new FiniteState();
		FiniteState firstState = previousState; 
		FiniteState currentState=null;
		FiniteState[] states = new FiniteState[searchString.length];
		int p=0;
		states[0]=firstState;
		for(int i=1;i<searchString.length;i++){
			curState = new FiniteState();
			states[p++] = curState;
			exactMatchString.findPrefixMappings(searchString, i, curState, );
			previousState.set(searchString[i],curState);
		}
		currentState.setFinished();	
	}
}
