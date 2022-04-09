package com.action.admin;

import java.util.*; 
class StackSample
{ 
static void showpush(Stack st, String a) { 
st.push(a); 
System.out.println("push(" + a + ")"); 
System.out.println("stack: " + st); 
} 
static void showpop(Stack st) { 
System.out.print("pop -> "); 
String bb=st.toString();
StringBuffer sb=new StringBuffer();
sb.append(bb);
sb.append("~");
String aaa=sb.toString();
System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+aaa); 
String a =  st.pop().toString(); 

System.out.println("stack: " + st); 
} 
public static void main(String args[]) { 
Stack st = new Stack(); 
Stack st1 = new Stack(); 
Stack st2 = new Stack(); 
System.out.println("stack: " + st); 
showpush(st, "manu"); 
showpush(st1, "mmm"); 
showpush(st2, "kkk"); 
String ss=st2.toString();

System.out.println("))))))))))))))))))))))))))))))))))))))))))))))))))"+ss);
if(ss.equals("[,]"))
{
showpop(st); 
showpop(st1); 
showpop(st2); 
}
try { 
//showpop(st); 
} catch (EmptyStackException e) { 
System.out.println("empty stack"); 
} 
} 
}