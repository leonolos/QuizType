package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Quiz {

    //Properties
    private Integer quizId;
    private String title;

    //Constructors
    public Quiz() {
    }

    public Quiz(String title) {
        this.title = title;
    }

    //Getters
    public Integer getQuizId() {
        return quizId;
    }

    public String getTitle() {
        return title;
    }

    //Setters
    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Quiz{" + "quizId=" + quizId + ", title=" + title + '}';
    }

    //Other Methods
    public static void createTable() {
        
        try {
            String query = "CREATE TABLE \"quiz\" (\n"
                    + "	\"id\"	INTEGER,\n"
                    + "	\"titre\"	TEXT,\n"
                    + "	PRIMARY KEY(\"id\" AUTOINCREMENT)\n"
                    + ");";

            String connectionUrl = "jdbc:sqlite:src/models/dbQuizType.db";
            Class.forName("org.sqlite.JDBC");
            Connection connection;
            connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement ps = connection.prepareStatement(query);
            boolean b = ps.execute();
            System.out.println("models.quiz.createTable()");
            System.out.println(b);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
