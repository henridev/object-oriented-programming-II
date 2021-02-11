package ui;

//tag::codeExample[]
public class EqualsTest { 
    public static void main(String[] args) 
    { 
        String s1 = new String("HELLO"); 
        String s2 = new String("HELLO"); 
        System.out.println(s1 == s2); // <1>
        System.out.println(s1.equals(s2)); // <2>
    } 
} 
//end::codeExample[]
