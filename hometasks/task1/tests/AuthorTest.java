package hometasks.task1.tests;

import hometasks.task1.solutions.Author;
import org.junit.Assert;
import org.junit.Test;

public class AuthorTest extends Assert{



    @Test
    public void testToString(){
        Author objTest = new Author("Petr", "petr@mail.ru", 'm');
        assertEquals("Author[name = Petr, email = petr@mail.ru, gender = m]", objTest.toString());
    }

}