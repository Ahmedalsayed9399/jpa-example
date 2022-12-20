package guru.springframework.spring5webapp;

import jakarta.persistence.*;
import jakarta.transaction.UserTransaction;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String FirstName;
    private String lastName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books=new HashSet<>();
    public Author(){

    }
    public Author(String firstName,String lastName){
        this.FirstName=firstName;
        this.lastName=lastName;

    }
    public Author(String firstName,String lastName,Set<Book> books){
        this.FirstName=firstName;
        this.lastName=lastName;
        this.books=books;

    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
