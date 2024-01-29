package lifePackage;

import java.util.Stack;

public class q {
	Stack<Integer> mainstack;
	Stack<Integer> helper;
	public q() {
		 this.mainstack = new Stack<>();
    	this.helper = new Stack<>();
		
    	
	}
public void push(int x) {
        this.mainstack.push(x);
    }
    
    public int pop() {
        int x;
        while (! this.mainstack.isEmpty()) {
        	
        	this.helper.push(this.mainstack.pop());
        	
        }
        x=this.helper.pop();
        while (! this.helper.isEmpty()) {
        	
        	this.mainstack.push(this.helper.pop());
        	
        }
        return x;
        
        
    }
    
    public int peek() {
        int x;
        while (! this.mainstack.isEmpty()) {
        	
        	this.helper.push(this.mainstack.pop());
        	
        }
        x=this.helper.peek();
        while (! this.helper.isEmpty()) {
        	
        	this.mainstack.push(this.helper.pop());
        	
        }
        return x;
            
    }
    
    public boolean empty() {
    	return this.mainstack.isEmpty();
        
    }

}
