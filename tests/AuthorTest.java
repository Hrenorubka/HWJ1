package tests;

import hometasks.Author;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest extends Assert{



    @Test
    public void testToString(){
        Author objTest = new Author("Petr", "petr@mail.ru", 'm');
        assertEquals("Author[name = Petr, email = petr@mail.ru, gender = m]", objTest.toString());
    }

}