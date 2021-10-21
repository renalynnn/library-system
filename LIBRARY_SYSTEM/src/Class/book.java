/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Class.BookData;
/**
 *
 * @author Acer
 */
public class book {
    
    public List<BookData> getList() {
        List<BookData> bookList = new ArrayList<>();
        Connection conn = db.getConnection();
        String query = "SELECT * FROM books";
        System.out.println(query);

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                BookData book = new BookData();

                book.id = rs.getInt("id");
                book.name = rs.getString("name");
                book.author = rs.getString("author");
                book.status = rs.getString("status");

                bookList.add(book);

//                System.out.println("Book name: " + book.name);
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute books database!" + e);
        }

        return bookList;
    }

    public boolean addBook(BookData book) {
        boolean isSuccess = false;
        Connection conn = db.getConnection();
        String query = "INSERT INTO books (name, author)" + "VALUES ('" + book.name + "', '" + book.author + "')";
        System.out.println(query);

        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);

            System.out.println(book.name + " book has been succesfully added.");
            isSuccess = true;

        } catch (SQLException e) {
            System.out.println("Failed to execute books database!" + e);
        }

        return isSuccess;
    }

}

