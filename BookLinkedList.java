import java.util.Scanner;

class BookLinkedList {
  BookNode start;

  BookNode searchBook(String isbn) throws Exception {
    BookNode temp = start;

    while (temp != null) {
      if (temp.isbn.equals(isbn)) return temp;

      temp = temp.next;
    }

    throw new Exception("Book Not Found");
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    BookLinkedList list = new BookLinkedList();
    BookNode helper = new BookNode();

    int ch;

    do {
      System.out.println("\n1. Add Book at Beginning");
      System.out.println("2. Add Book at End");
      System.out.println("3. Search Book");
      System.out.println("4. Exit");
      System.out.print("Enter Choice: ");
      ch = sc.nextInt();
      sc.nextLine();

      switch (ch) {
        case 1:
          BookNode b1 = new BookNode();
          b1.accept();
          list.start = helper.addBook(list.start, b1);
          System.out.println("Book Added");
          break;

        case 2:
          BookNode b2 = new BookNode();
          b2.accept();
          list.start = helper.addBookAtEnd(list.start, b2);
          System.out.println("Book Added");
          break;

        case 3:
          System.out.print("Enter ISBN to Search: ");
          String isbn = sc.nextLine();

          try {
            BookNode result = list.searchBook(isbn);
            System.out.println("\nBook Found");
            result.display();
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;

        case 4:
          System.out.println("Program Terminated");
          break;

        default:
          System.out.println("Invalid Choice");
      }

    } while (ch != 4);

    sc.close();
  }
}
