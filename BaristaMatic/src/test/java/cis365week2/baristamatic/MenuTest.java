
package cis365week2.baristamatic;

import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *
 * @author Matt Guzowski
 */
public class MenuTest {

    public MenuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addRecipe method, of class Menu.
     */
    @Test
    public void testAddRecipe() {
        System.out.println("Testing addRecipe in Menu.");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        assertTrue(menu.recipes.containsKey("Coffee"));
    }

    /**
     * Test of display method, of class Menu.
     */
    @Test
    public void testDisplay() {
        System.out.println("Testing display in Menu.");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        menu.display();
        verify(out).println(startsWith("Menu:"));
    }

    /**
     * Test of makeDrink method, of class Menu.
     */
    @Test
    public void testMakeDrink() {
        System.out.println("Testing makeDrink in Menu.");
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        menu.makeDrink(4);
        int result = inventory.quantities.get("Coffee");
        int expResult = 7; //Coffee has 3 units of Coffee in the recipe
        assertEquals(expResult, result);
    }

}
