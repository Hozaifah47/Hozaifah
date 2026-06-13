public class Reverse {
  NumLinkedList reverse = new NumLinkedList();

  NumLinkedList reverse(NumLinkedList list) throws Exception {
    if (list.start == null) {
      throw new Exception("the list is empty");
    }
    NumNode temp = list.start;
    while (temp != null) {
      NumNode node = new NumNode();
      node.num = temp.num;
      node.next = reverse.start;
      reverse.start = node;
      temp = temp.next;
    }

    return reverse;
  }
}
