package dataaccess;

import org.junit.*;
import org.junit.rules.ExpectedException;
import pricing.PriceSchedule;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DataAccessTest {
    public static DataAccess db;

    @BeforeClass
    public static void setUpClass(){
        db = new DataAccess();
        db.connection();
    }

    @AfterClass
    public static void tearDownClass(){
        db = null;
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDoesCustNumberExist() throws Exception {
        boolean expected = true;
        boolean actual = db.doesCustNumberExist(104);
        assertEquals(expected,actual);

    }

    @Test
    public void testGetCarTypePriceSchedule(){
        PriceSchedule expected = new PriceSchedule("economy", BigDecimal.valueOf(35.00).setScale(2),BigDecimal.valueOf(30.00).setScale(2),BigDecimal.valueOf(25.00).setScale(2));
        PriceSchedule actual = null;
        try {
            actual = db.getCarTypePriceSchedule("economy");
        } catch (CarTypeNotFoundException e) {
            e.printStackTrace();
        }
        assertTrue("getCarTypePriceSchedule: Fail", expected.toString().equals(actual.toString()));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testGetCarTypePriceScheduleWithWrongCarType() throws CarTypeNotFoundException{
        System.out.println("getCarTypePriceSchedule with Wrong Car Type");
        thrown.expect(CarTypeNotFoundException.class);
        PriceSchedule testPriceSchedule = db.getCarTypePriceSchedule("omy");
    }
}