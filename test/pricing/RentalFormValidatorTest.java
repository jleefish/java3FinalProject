/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pricing;

import pricing.RentalFormValidator;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jhlee
 */
public class RentalFormValidatorTest {

    private MockRequest currRequest;

    public RentalFormValidatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        currRequest = new MockRequest();
        currRequest.setParameter("customerNo", "1111");
        currRequest.setParameter("pickupDay", "1");
        currRequest.setParameter("pickupMonth", "1");
        currRequest.setParameter("pickupYear", "2014");
        currRequest.setParameter("pickupHour", "10");
        currRequest.setParameter("dropoffDay", "1");
        currRequest.setParameter("dropoffMonth", "1");
        currRequest.setParameter("dropoffYear", "2014");
        currRequest.setParameter("dropoffHour", "10");
        currRequest.setParameter("cartype", "standard");
        currRequest.setParameter("creditCardType", "visa");
        currRequest.setParameter("creditCardNo", "4111111111111111");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isValid method, of class RentalFormValidator.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        currRequest.setParameter("customerNo", "a");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }

    /**
     * Test of getErrors method, of class RentalFormValidator.
     */
    @Test
    public void testGetErrorCodes() {
        System.out.println("getErrors");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        ArrayList<Integer> expResult = new ArrayList<>();
        expResult.add(1011);
        instance.setErrorCodes(expResult);
        ArrayList<Integer> result = instance.getErrorCodes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setErrorCodes method, of class RentalFormValidator.
     */
    @Test
    public void testSetErrorCodes() {
        System.out.println("setErrorCodes");
        ArrayList<Integer> expResult = new ArrayList<Integer>();
        RentalFormValidator instance = new RentalFormValidator(null);
        expResult.add(1111);
        instance.setErrorCodes(expResult);
        ArrayList<Integer> result = instance.getErrorCodes();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCustomerNull method, of class RentalFormValidator.
     */
    @Test
    public void testIsCustomerNull() {
        System.out.println("isCustomerNull");
        currRequest.setParameter("customerNo", "");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = true;
        boolean result = instance.isCustomerNull();
        assertEquals(expResult, result);
    }

    /**
     * Test reverse of isCustomerNull method, of class RentalFormValidator.
     */
    @Test
    public void testIsCustomerNotNull() {
        System.out.println("isCustomerNull");
        currRequest.setParameter("customerNo", "2");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = false;
        boolean result = instance.isCustomerNull();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCustomerNumeric method, of class RentalFormValidator.
     */
    @Test
    public void testIsCustomerNumeric() {
        System.out.println("isCustomerNumeric");
        currRequest.setParameter("customerNo", "a");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = false;
        boolean result = instance.isCustomerNumeric();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPickupDayNull method, of class RentalFormValidator.
     */
    @Test
    public void testIsPickupDayNull() {
        System.out.println("isPickupDayNull");
        currRequest.setParameter("pickupDay", "");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = true;
        boolean result = instance.isPickupDayNull();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPickupDayInRange method, of class RentalFormValidator.
     */
    @Test
    public void testIsPickupDayInRange() {
        System.out.println("isPickupDayInRange");
        currRequest.setParameter("pickupDay", "32");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = false;
        boolean result = instance.isPickupDayInRange();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPickupMonthNull method, of class RentalFormValidator.
     */
    @Test
    public void testIsPickupMonthNull() {
        System.out.println("isPickupMonthNull");
        currRequest.setParameter("pickupMonth", "");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = true;
        boolean result = instance.isPickupMonthNull();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPickupMonthInRange method, of class RentalFormValidator.
     */
    @Test
    public void testIsPickupMonthInRange() {
        System.out.println("isPickupMonthInRange");
        currRequest.setParameter("pickupMonth", "13");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = false;
        boolean result = instance.isPickupMonthInRange();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPickupYearNull method, of class RentalFormValidator.
     */
    @Test
    public void testIsPickupYearNull() {
        System.out.println("isPickupYearNull");
        currRequest.setParameter("pickupYear", "");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = true;
        boolean result = instance.isPickupYearNull();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPickupYearInRange method, of class RentalFormValidator.
     */
    @Test
    public void testIsPickupYearInRange() {
        System.out.println("isPickupYearInRange");
        currRequest.setParameter("pickupYear", "1");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = false;
        boolean result = instance.isPickupYearInRange();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPickupHourNull method, of class RentalFormValidator.
     */
    @Test
    public void testIsPickupHourNull() {
        System.out.println("isPickupHourNull");
        currRequest.setParameter("pickupHour", "");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = true;
        boolean result = instance.isPickupHourNull();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPickupHourInRange method, of class RentalFormValidator.
     */
    @Test
    public void testIsPickupHourInRange() {
        System.out.println("isPickupHourInRange");
        currRequest.setParameter("pickupHour", "24");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = false;
        boolean result = instance.isPickupHourInRange();
        assertEquals(expResult, result);
    }

    /**
     * Test of isDropoffDayNull method, of class RentalFormValidator.
     */
    @Test
    public void testIsDropoffDayNull() {
        System.out.println("isDropoffDayNull");
        currRequest.setParameter("dropoffDay", "");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = true;
        boolean result = instance.isDropoffDayNull();
        assertEquals(expResult, result);
    }

    /**
     * Test of isDropoffDayInRange method, of class RentalFormValidator.
     */
    @Test
    public void testIsDropoffDayInRange() {
        System.out.println("isDropoffDayInRange");
        currRequest.setParameter("dropoffDay", "0");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = false;
        boolean result = instance.isDropoffDayInRange();
        assertEquals(expResult, result);
    }

    /**
     * Test of isDropoffMonthNull method, of class RentalFormValidator.
     */
    @Test
    public void testIsDropoffMonthNull() {
        System.out.println("isDropoffMonthNull");
        currRequest.setParameter("dropoffMonth", "");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = true;
        boolean result = instance.isDropoffMonthNull();
        assertEquals(expResult, result);
    }

    /**
     * Test of isDropoffMonthInRange method, of class RentalFormValidator.
     */
    @Test
    public void testIsDropoffMonthInRange() {
        System.out.println("isDropoffMonthInRange");
        currRequest.setParameter("dropoffMonth", "13");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = false;
        boolean result = instance.isDropoffMonthInRange();
        assertEquals(expResult, result);
    }

    /**
     * Test of isDropoffYearNull method, of class RentalFormValidator.
     */
    @Test
    public void testIsDropoffYearNull() {
        System.out.println("isDropoffYearNull");
        currRequest.setParameter("dropoffYear", "");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = true;
        boolean result = instance.isDropoffYearNull();
        assertEquals(expResult, result);
    }

    /**
     * Test of isDropoffYearInRange method, of class RentalFormValidator.
     */
    @Test
    public void testIsDropoffYearInRange() {
        System.out.println("isDropoffYearInRange");
        currRequest.setParameter("dropoffYear", "1");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = false;
        boolean result = instance.isDropoffYearInRange();
        assertEquals(expResult, result);
    }

    /**
     * Test of isDropoffHourNull method, of class RentalFormValidator.
     */
    @Test
    public void testIsDropoffHourNull() {
        System.out.println("isDropoffHourNull");
        currRequest.setParameter("dropoffHour", "");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = true;
        boolean result = instance.isDropoffHourNull();
        assertEquals(expResult, result);
    }

    /**
     * Test of isDropoffHourInRange method, of class RentalFormValidator.
     */
    @Test
    public void testIsDropoffHourInRange() {
        System.out.println("isDropoffHourInRange");
        currRequest.setParameter("dropoffHour", "24");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = false;
        boolean result = instance.isDropoffHourInRange();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCarTypeNull method, of class RentalFormValidator.
     */
    @Test
    public void testIsCarTypeNull() {
        System.out.println("isCarTypeNull");
        currRequest.setParameter("cartype", "");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = true;
        boolean result = instance.isCarTypeNull();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCarTypeInRange method, of class RentalFormValidator.
     */
    @Test
    public void testIsCarTypeInRange() {
        System.out.println("isCarTypeInRange");
        currRequest.setParameter("cartype", "bus");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = false;
        boolean result = instance.isCarTypeInRange();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCreditCardTypeNull method, of class RentalFormValidator.
     */
    @Test
    public void testIsCreditCardTypeNull() {
        System.out.println("isCreditCardTypeNull");
        currRequest.setParameter("creditCardType", "");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = true;
        boolean result = instance.isCreditCardTypeNull();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCreditCardTypeInRange method, of class RentalFormValidator.
     */
    @Test
    public void testIsCreditCardTypeInRange() {
        System.out.println("isCreditCardTypeInRange");
        currRequest.setParameter("creditCardType", "visa");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = true;
        boolean result = instance.isCreditCardTypeInRange();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCreditCardNoNull method, of class RentalFormValidator.
     */
    @Test
    public void testIsCreditCardNoNull() {
        System.out.println("isCreditCardNoNull");
        currRequest.setParameter("creditCardNo", "");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = true;
        boolean result = instance.isCreditCardNoNull();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCreditCardNoInRange method, of class RentalFormValidator.
     */
    @Test
    public void testIsCreditCardNoInRange() {
        System.out.println("isCreditCardNoInRange");
        currRequest.setParameter("creditCardNo", "0");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        boolean expResult = false;
        boolean result = instance.isCreditCardNoInRange();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBean method, of class RentalFormValidator.
     */
    @Test
    public void testGetBean() {
        System.out.println("getBean");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        instance.isValid();
        RentalBean expResult = new RentalBean();
        expResult.setCardNumber("1");
        instance.setBean(expResult);
        RentalBean result = instance.getBean();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBean method, of class RentalFormValidator.
     */
    @Test
    public void testSetBean() {
        System.out.println("setBean");
        RentalFormValidator instance = new RentalFormValidator(currRequest);
        RentalBean bean = new RentalBean();
        bean.setCardNumber("1111");
        instance.setBean(bean);
        RentalBean expResult = instance.getBean();
        assertEquals(expResult, bean);
    }

}
