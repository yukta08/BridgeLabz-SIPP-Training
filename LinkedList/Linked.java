class Linked{
public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.addLast(1);
    ll.addLast(2);
    ll.addLast(3);
    ll.addbetween(2.5,2);
    ll.addFirst(0);
    ll.addLast(4);
    //ll.delete();
    //ll.deleteFirst();
    ll.deleteBetween(2);
    ll.display();
}}

class LinkedList{
    Node head;
    Node tail;
    class Node{
        Object data;
        Node next;
        Node (Object data){
            this.data = data;
        }
    
}

public void addFirst(Object data){
    Node n=new Node(data);
    if(head ==null){
        head = tail =n;
    }
    else{
    n.next=head;
    head=n;
    }
}
public void addbetween(Object data,Object after){
    Node n = new Node(data);
    if(head ==null){
        head = tail =n;
    }
    else{
        Node temp=head;
        while(temp.data!=after){
            temp=temp.next;
        }
        n.next=temp.next;
        temp.next=n;
    }
}
public void addLast(Object data){
    Node n=new Node(data);//create new object
    if(head ==null){
        head = tail =n;
    }
    else{
    tail.next=n;
    tail=n;
    }
}
public void delete(){
    Node temp =head;//pointer
    while(temp.next!=tail){
        temp =temp.next;
    }
    if(head.next==null)
        head=tail=null;
    else{
        tail=temp;
        temp.next=null;
    }
}
public void deleteFirst(){
    Node temp = head;
    if(head.next==null)
        head=tail=null;
    else{
        temp.next=head.next;
        head=temp.next;
    }
}
public void deleteBetween(Object value){
    Node temp = head;
    while(temp.next.data!=value){
        temp = temp.next;
    }
    if (head.next==null) {
        head=tail=null;
    } else {
        temp.next=temp.next.next;
    }
}
public void display(){
    Node temp =head;
    while(temp!=null){
        System.out.print(temp.data + "->");
        temp = temp.next;
    }
}
}