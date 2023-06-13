
public class Tester {
	public static void main(String[] args){
		MyLinkedList list = new MyLinkedList();
		
		list.addFirst(40);
		System.out.println("Just inserted first; size now is " + list.size());
		System.out.println(list);

		list.addFirst(20);
		System.out.println("Just inserted first; size now is " + list.size());
		System.out.println(list);

		list.addLast(60);
		System.out.println("Just inserted last; size now is " + list.size());
		System.out.println(list);
		
		int removed = -1;
		
		removed = list.removeFirst();
		System.out.println("Just removed: " + removed + "; size now is " + list.size());
		System.out.println(list);
		
		removed = list.removeFirst();
		System.out.println("Just removed: " + removed + "; size now is " + list.size());
		System.out.println(list);
		
		removed = list.removeFirst();
		System.out.println("Just removed: " + removed + "; size now is " + list.size());
		System.out.println(list);
		
		// Uncomment when your add(position, element) is working
		/*
		list.add(0, 80);
		System.out.println("Just inserted (pos 0); size now is " + list.size());
		System.out.println(list);

		list.add(1, 90);
		System.out.println("Just inserted (pos 1); size now is " + list.size());
		System.out.println(list);
		
		list.add(2, 100);
		System.out.println("Just inserted (pos 2); size now is " + list.size());
		System.out.println(list);
		
		list.add(0, 200);
		System.out.println("Just inserted (pos 0); size now is " + list.size());
		System.out.println(list);
		
		list.add(0, 300);
		System.out.println("Just inserted (pos 0); size now is " + list.size());
		System.out.println(list);
		
		list.add(1, 250);
		System.out.println("Just inserted (pos 1); size now is " + list.size());
		System.out.println(list);
		
		list.add(3, 150);
		System.out.println("Just inserted (pos 3); size now is " + list.size());
		System.out.println(list);
		
		System.out.println("Element at pos 0: " + list.get(0));
		System.out.println("Element at pos 1: " + list.get(1));
		System.out.println("Element at pos 6: " + list.get(6));
		// System.out.println("Element 7: " + list.get(7)); Throws exception
		*/

		// Uncomment when your remove(position, element) is working
		/*
		list.remove(3);
		System.out.println("Just removed (pos 3); size now is " + list.size());
		System.out.println(list);
		
		list.remove(1);
		System.out.println("Just removed (pos 1); size now is " + list.size());
		System.out.println(list);
		
		list.remove(0);
		System.out.println("Just removed (pos 0); size now is " + list.size());
		System.out.println(list);
		
		list.remove(3);
		System.out.println("Just removed (pos 3); size now is " + list.size());
		System.out.println(list);
		
		list.remove(1);
		System.out.println("Just removed (pos 1); size now is " + list.size());
		System.out.println(list);
		
		list.remove(0);
		System.out.println("Just removed (pos 0); size now is " + list.size());
		System.out.println(list);
		
		list.remove(0);
		System.out.println("Just removed (pos 0); size now is " + list.size());
		System.out.println(list);
		*/
	}
}
