package pl.devkamil.app.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

    @Test
    public void twoUsersWithTheSameFieldsShouldBeEqual(){
        assertEquals(new User(1, "login","name","type","avatar","created"),
                new User(1, "login","name","type","avatar","created"));
    }

    @Test
    public void twoUsersWithDifferentNameArentEqual(){
        assertNotEquals(new User(1, "login","name1","type","avatar","created"),
                new User(1, "login","name2","type","avatar","created"));
    }

    @Test
    public void twoUsersWithDifferentFieldsArentEqual(){
        assertNotEquals(new User(1, "login1","name1","type1","avatar1","created1"),
                new User(2, "login2","name2","type2","avatar2","created2"));
    }

    @Test
    public void twoUsersWithTheSameFieldsShouldHaveTheSameHashCode(){
        assertEquals(new User(1, "login","name","type","avatar","created").hashCode(),
                new User(1, "login","name","type","avatar","created").hashCode());
    }

    @Test
    public void twoUsersWithDifferentNameShouldHaveDifferentHashCode(){
        assertNotEquals(new User(1, "login","name1","type","avatar","created").hashCode(),
                new User(1, "login","name2","type","avatar","created").hashCode());
    }

    @Test
    public void twoUsersWithDifferentFieldsShouldHaveDifferentHashCode(){
        assertNotEquals(new User(1, "login1","name1","type1","avatar1","created1").hashCode(),
                new User(2, "login2","name2","type2","avatar2","created2").hashCode());
    }

}

