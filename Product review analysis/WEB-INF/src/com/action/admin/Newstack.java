package com.action.admin;

public class Newstack {

	  int top;
	  char stack[];
	  int maxLen;

	  public Newstack(int max) {
	    top = -1; 
	    maxLen = max; 
	    stack = new char[maxLen];
	  }

	  public void push(char item) {
	    top++;
	    stack[top] = item;
	  }

	  public int pop() {
	    //x = stack[top];
	    //top = top - 1;
	    top--;
	    return stack[top];
	  }

	  public boolean isStackEmpty() {
	    if(top == -1) {
	      System.out.println("Stack is empty" + top);
	      return true;
	    } else 
	      return false;
	  }

	  public void reset() { 
	    top = -1;
	  }

	  public void showStack() {
	    System.out.println(" ");
	    System.out.println("Stack Contents...");
	    for(int j = top; j > -1; j--){
	      System.out.println(stack[j]);
	    }
	    System.out.println(" ");
	  }

	  public void showStack0toTop() {
	    System.out.println(" ");
	    System.out.println("Stack Contents...");
	    for(int j=0; j>=top; j++){
	      System.out.println(stack[j]); 
	    }
	    System.out.println(" ");
	  }
	//}

	  public boolean test(String p ){
	    boolean balanced = false;
	    balanced = false;
	    //while (  ) 
	    for(char i = '('; i < p.length(); i++ ){
	      push('(');
	    }
	    for (char j = ')'; j < p.length(); j++){
	      pop();
	    }
	    if (isStackEmpty()) {
	      balanced = true;
	      //return balanced;
	    }
	    return balanced;
	  } 

	  public static void main(String[] args) {
	    Newstack stacks = new Newstack(100);
	    String y = new String("(((1+44)*3)");

	    stacks.test(y);
	    //System.out.println(stacks.test(y));
	  }    
	}
