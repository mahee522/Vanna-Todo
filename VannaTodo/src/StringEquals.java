public class StringEquals {
 public static void main(String[] args){
 jack();
 jill();
 }
 public static void jack() {
 String s1 = "hill5";
 String s2 = "hill" + "5";
 System.out.println(s1==s2);
 }
 public static void jill() {
 String s1 = "hill5";
 String s2 = "hill" + s1.length();
 System.out.println(s1==s2);
 }
 }