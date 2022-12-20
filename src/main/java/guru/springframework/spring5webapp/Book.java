package guru.springframework.spring5webapp;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String isbn;
    private String puplisher;
    @ManyToMany
    @JoinTable(name = "author_book",joinColumns =@JoinColumn (name="book_id"),
   inverseJoinColumns = @JoinColumn(name="author_id"))
   private Set<Author> authors=new HashSet<>();
    public Book(){

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", puplisher='" + puplisher + '\'' +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Book(String title, String isbn, String puplisher){
        this.title=title;
        this.isbn=isbn;
        this.puplisher=puplisher;
    }
    public Book(String title, String isbn, String puplisher, Set<Author> authors){
        this.title=title;
        this.isbn=isbn;
        this.puplisher=puplisher;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPuplisher() {
        return puplisher;
    }

    public void setPuplisher(String puplisher) {
        this.puplisher = puplisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
