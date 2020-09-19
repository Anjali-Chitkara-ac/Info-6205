package Sep16;

public class InsertInSortedCircular {
    public Node insert(Node head, int insertVal) {
        Node n = new Node(insertVal);
        if(head==null){
            head = n;
            n.next = head;
            return head;
        }
        Node temp = head;
        Node smallest = new Node(Integer.MAX_VALUE);
        Node largest = new Node(Integer.MIN_VALUE);

        do{
            //Node next = temp.next;
            if(temp.val < smallest.val){
                smallest = temp;
            }
            if(temp.val >= largest.val){
                largest = temp;
            }
            temp = temp.next;
        } while (temp!=head);
        //System.out.println(smallest.val);
        //System.out.println(largest.val);

        if(insertVal>=largest.val || insertVal<=smallest.val){
            Node temp1 = largest.next;
            largest.next = n;
            n.next = temp1;
            return largest;
        }
        Node b = smallest;
        while (b!=largest){
            if(n.val>=b.val && n.val<=b.next.val){
                Node c = b.next;
                b.next = n;
                n.next = c;
                return head;

            }
            b = b.next;
        }
        return head;
    }

    public static void demo(){
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = head;
//        head.next.next.next.next = new Node(6);
//        head.next.next.next.next.next = new Node(7);
//        head.next.next.next.next.next.next = head.next;

        InsertInSortedCircular obj = new InsertInSortedCircular();
        Node a = obj.insert(head,4);
        do{
            System.out.print(a.val + "->");
            a=a.next;
        } while (a!=head);
       // System.out.println(a.val);
    }

}
