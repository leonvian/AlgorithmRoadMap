import linkedlist.ReverseLinkedList206;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedList206Tests {

    @Test
    public void testCase1() {
        ReverseLinkedList206.Node node1 = new ReverseLinkedList206.Node(1);
        ReverseLinkedList206.Node node2 = new ReverseLinkedList206.Node(2);
        ReverseLinkedList206.Node node3 = new ReverseLinkedList206.Node(3);
        ReverseLinkedList206.Node node4 = new ReverseLinkedList206.Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        ReverseLinkedList206.Node head = node1;
        // 1 -> 2 ->  3 ->  4
        Assert.assertEquals(1, head.value);
        Assert.assertEquals(2, head.next.value);
        Assert.assertEquals(3, head.next.next.value);
        Assert.assertEquals(4, head.next.next.next.value);
        Assert.assertNull(head.next.next.next.next);

        head = ReverseLinkedList206.reverse(node1);

        // 1 <- 2 <-  3 <-  4
        Assert.assertEquals(4, head.value);
        Assert.assertEquals(3, head.next.value);
        Assert.assertEquals(2, head.next.next.value);
        Assert.assertEquals(1, head.next.next.next.value);
        Assert.assertNull(head.next.next.next.next);
    }

}
