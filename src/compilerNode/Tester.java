package compilerNode;
import java.util.ArrayList;
import java.util.List;
import compilerNode.*;
class A{};
class B extends A{};
class C extends B{};
public class Tester {
	
	public static void main(String[] args) {
		Exprnode a=new Assignnode();
		B b=new B();
		C c=new C();
		A ac=new C();
		B bc=new C();
		System.out.println(a.getClass().equals(Exprnode.class));
	}
}
