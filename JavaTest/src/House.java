class Building
{
	 public Building() 
	 {
		System.out.println("inside no-arg constr of Building");
	 }
	 public Building(String s)
	 {
		 this();
		 System.out.println("inside arg constr of Building");
	 }
}
public class House extends Building
{
	 public House()
	 {
		
		 System.out.println("inside na-arg const of House");
	 }
	 public House(String h)
	 {
		 this();
		 System.out.println("inside arg const of House");
	 }
	 
	 public static void main(String [] args) 
	 {
		System.out.println(new House("qwerty"));
		String s = "qwerty";
		System.out.println(s.toString());
		StringBuilder sb = new StringBuilder("wddwd");
	 }

}