/* Book.java
Entity for the Book
Author: Ongezwa Gwaza (211272183)
Date: 27 March 2022
*/
package za.ac.cput.entity;

public class Book {
//    Attributes for the Book entity
    private  String  bookCode;
    private  String name;
    private  String publisher;
    private  String available;
    private  Supplier supplierId;

    //default Constructor
    public Book(){}

    /* Constructor for the book class
    which uses BookBuilder to instantiate fields
     */
    private Book(BookBuilder bookBuilder) {
        this.bookCode = bookBuilder.bookCode;
        this.name = bookBuilder.name;
        this.publisher = bookBuilder.publisher;
        this.available = bookBuilder.available;
        this.supplierId = bookBuilder.supplierId;
    }

    public Book copy(Book book){
        setBookCode(book.getBookCode());
        setName(book.getName());
        setPublisher(book.getPublisher());
        setAvailable(book.getAvailable());
        setSupplierId(book.getSupplierId());
        return this;
    }

//    Getters and Setters for the Book attributes
    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    //    toString method used to convert object attributes to  string data type
    @Override
    public String toString() {
        return "Book{" +
                "bookCode='" + bookCode + '\'' +
                ", name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", available='" + available + '\'' +
                ", supplierId='" + supplierId.getName() + '\'' +
                '}';
    }

//    Builder class used to implement the Builder pattern
    public static class BookBuilder{
        private  String  bookCode;
        private  String name;
        private  String publisher;
        private  String available;
        private  Supplier supplierId;

    /* Constructor for the Book Builder Class
      bookCode should be available on each object instantiation
   */
        public BookBuilder(String bookCode) {
            this.bookCode = bookCode;
        }
    public BookBuilder supplierOfBook(Supplier supplier){
        this.supplierId = supplier;
        return this;
    }

        public BookBuilder nameOfBook(String name){
            this.name = name;
            return this;
        }

        public BookBuilder publishedBy(String publisher){
            this.publisher = publisher;
            return this;
        }

        public BookBuilder isBookAvailable(String available){
            this.available = available;
            return this;
        }

//        method for creating/building the instance of the book class
        public Book build(){
            Book book = new Book(this);
            return  book;
        }
    }
}
