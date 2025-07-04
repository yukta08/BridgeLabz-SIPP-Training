public class DLL {
    public static void main(String[] args) {
        
    }
}

class DoubleLinkedList{
       Node head;
       Node tail;
       class Node{
        Object data;
        Node next;
        Node previous;
        Node(Object data){
            this.data=data;

        }
    }
    public void add(Object data){
        Node n=new Node(data);
        if(head==null){
            head=tail=n;
        }
        
        }
    }

