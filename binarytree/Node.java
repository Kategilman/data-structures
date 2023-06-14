public class Node{
   public int value;
   public Node greater;
   public Node less;

   public Node(int value, Node greater, Node less){
    this.value = value;
    this.greater =greater;
    this.less = less;
   }
}