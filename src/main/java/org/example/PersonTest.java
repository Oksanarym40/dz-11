package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PersonTest extends Person{

    public PersonTest(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Test (priority=1, description =" Verify if man is retired")
    public void testIsRetiredForMan() {
        Man man = new Man("Igor", "Rymaruk", 40);
        assertFalse(man.isRetired());
    }

    @Test (priority=2, description = "Verify if woman is retired")
    public void testIsRetiredForWoman() {
        Woman woman = new Woman("Oksana", "Shpynta", 55);
        assertTrue(woman.isRetired());
    }

    @Test (priority = 3, description = "Verify if registered partners")
    public void testSetPartner() {
        Man man1 = new Man("Igor", "Rymaruk", 40);
        Woman woman1 = new Woman("Oksana", "Shpynta", 35);

        man1.setPartner(woman1);

        assertEquals(man1, woman1.getPartner());
        assertEquals(woman1, man1.getPartner());
    }

    @Test (priority = 4, description = "Verify if woman's  last name change after registerPartnership")
    public void testRegisterPartnership() {
        Man man1 = new Man("Igor", "Rymaruk", 40);
        Woman woman1 = new Woman("Oksana", "Rymaruk", 35);

        man1.registerPartnership(woman1);

        assertEquals(man1, woman1.getPartner());
        assertEquals(woman1, man1.getPartner());
        assertEquals(woman1.getLastName(), man1.getLastName());
    }

    @Test (priority = 5, description = "Verify if womans return to previous last name after deregisterPartnership")
    public void testDeregisterPartnership() {
        Man man1 = new Man("Igor", "Rymaruk", 40);
        Woman woman1 = new Woman("Oksana", "Shpynta", 35);

        man1.setPartner(woman1);
       // man1.deregisterPartnership(true);

        assertNull(man1.getPartner());
        assertNull(woman1.getPartner());
        assertEquals(woman1.getLastName(), "Shpynta");
    }
}