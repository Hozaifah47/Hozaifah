import java.util.Scanner;

class BookNode {
  String isbn;
  String title;
  String author;
  String publisher;
  BookNode next;

  public BookNode() {
    isbn = null;
    title = null;
    author = null;
    publisher = null;
    next = null;
  }

  public BookNode(String isbn, String title, String author, String publisher) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    next = null;
  }

  void display() {
    System.out.println("ISBN = " + isbn);
    System.out.println("Title = " + title);
    System.out.println("Author = " + author);
    System.out.println("Publisher = " + publisher);
  }

  void accept() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the ISBN");
    isbn = sc.nextLine();
    System.out.println("Enter the Title");
    title = sc.nextLine();
    System.out.println("Enter the name of the Author");
    author = sc.nextLine();
    System.out.println("Enter the name of the Publisher");
    publisher = sc.nextLine();
  }

  BookNode addBookAtEnd(BookNode start, BookNode node) {
    if (start == null) return node;

    BookNode temp = start;

    while (temp.next != null) temp = temp.next;

    temp.next = node;

    return start;
  }

  BookNode addBook(BookNode start, BookNode node) {
    node.next = start;
    start = node;
    return start;
  }
}
