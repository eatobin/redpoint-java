package RedPointMaven;

import org.junit.Assert;
import org.junit.Test;

public class HatTest {
    Roster roster;
    Hat hat;

//    @Before
//    public void setUp() {
//        blackhawks2010 = new Roster();
//        blackhawks2010.roster_list.clear();
//        blackhawks2010.roster_list.put("EriTob", blackhawks2010.new Player("Eric Tobin", "SarArt")); //TODO Use constructor values
//        blackhawks2010.roster_list.put("SarArt", blackhawks2010.new Player("Sarah Artzi", "JerCoh")); //TODO Use constructor values
//        blackhawks2010.roster_list.put("JerCoh", blackhawks2010.new Player("Jerri Cohen", "EriTob")); //TODO Use constructor values
//        hat = new Hat(blackhawks2010);
//
//    }

    @Test
    public void testDrawPuck() {
        Assert.assertEquals(3, hat.pucks.size());
        System.out.println(hat.pucks.toString());
        Assert.assertEquals("JerCoh", hat.pucks.get(1));
        Assert.assertTrue(!hat.drawPuck().equals("none"));

        hat.pucks.clear();
        Assert.assertEquals("none", hat.drawPuck());
    }

    @Test
    public void testRemovePuck() {
        Assert.assertTrue(hat.removePuck("SarArt"));
        Assert.assertEquals(2, hat.pucks.size());
        Assert.assertFalse(hat.removePuck("SarArt"));
        Assert.assertTrue(hat.removePuck("EriTob"));
        Assert.assertTrue(hat.removePuck("JerCoh"));
        Assert.assertTrue(hat.drawPuck().equals("none"));
    }

    @Test
    public void testDiscardPuck() {
        Assert.assertTrue(hat.discardPuck("JerCoh"));
        Assert.assertEquals(1, hat.discardsSize());
        Assert.assertEquals(2, hat.pucks.size());
        Assert.assertTrue(hat.discards.contains("JerCoh"));
    }

    @Test
    public void testReturnDiscards() {
        Assert.assertTrue(hat.discardPuck("EriTob"));
        Assert.assertEquals(2, hat.pucks.size());
        Assert.assertEquals(1, hat.discardsSize());
        Assert.assertFalse(hat.pucks.contains("EriTob"));
        Assert.assertTrue(hat.discards.contains("EriTob"));

        hat.returnDiscards();
        Assert.assertEquals(3, hat.pucks.size());
        Assert.assertEquals(0, hat.discardsSize());
        Assert.assertTrue(hat.pucks.contains("EriTob"));
    }
}
