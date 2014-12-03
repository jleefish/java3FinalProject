/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pricing;

import java.beans.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
/**
 *
 * @author jhlee
 */
public class RentalBean implements Serializable{
    private int pickupYear;
    private int pickupMon;
    private int pickupDay;
    private int pickupHour;
    private int pickupMin;
    private int dropoffYear;
    private int dropoffMon;
    private int dropoffDay;
    private int dropoffHour;
    private int dropoffMin;
    private String rentalType;
    private String cardType;
    private String cardNumber;
    private int customerNumber;
    private BigDecimal taxRate;
    private BigDecimal price;
    private PriceSchedule priceSchedule;
      
    public RentalBean() {
       
    }
    
    /**
     * method for price estimation based on business rules
     * @return 
     */

    public PriceSchedule getPriceSchedule() {
        return priceSchedule;
    }
    
    /**
     * @return the pickupYear
     */
    public int getPickupYear() {
        return pickupYear;
    }

    /**
     * @param pickupYear the pickupYear to set
     */
    public void setPickupYear(int pickupYear) {
        this.pickupYear = pickupYear;
    }

    /**
     * @return the pickupMon
     */
    public int getPickupMon() {
        return pickupMon;
    }

    /**
     * @param pickupMon the pickupMon to set
     */
    public void setPickupMon(int pickupMon) {
        this.pickupMon = pickupMon;
    }

    /**
     * @return the pickupDay
     */
    public int getPickupDay() {
        return pickupDay;
    }

    /**
     * @param pickupDay the pickupDay to set
     */
    public void setPickupDay(int pickupDay) {
            this.pickupDay = pickupDay;
    }

    /**
     * @return the pickupHour
     */
    public int getPickupHour() {
        return pickupHour;
    }

    /**
     * @param pickupHour the pickupHour to set
     */
    public void setPickupHour(int pickupHour) {
        this.pickupHour = pickupHour;
    }

    /**
     * @return the pickupMin
     */
    public int getPickupMin() {
        return pickupMin;
    }

    /**
     * @param pickupMin the pickupMin to set
     */
    public void setPickupMin(int pickupMin) {
        this.pickupMin = pickupMin;
    }

    /**
     * @return the dropoffYear
     */
    public int getDropoffYear() {
        return dropoffYear;
    }

    /**
     * @param dropoffYear the dropoffYear to set
     */
    public void setDropoffYear(int dropoffYear) {
        this.dropoffYear = dropoffYear;
    }

    /**
     * @return the dropoffMon
     */
    public int getDropoffMon() {
        return dropoffMon;
    }

    /**
     * @param dropoffMon the dropoffMon to set
     */
    public void setDropoffMon(int dropoffMon) {
        this.dropoffMon = dropoffMon;
    }

    /**
     * @return the dropoffDay
     */
    public int getDropoffDay() {
        return dropoffDay;
    }

    /**
     * @param dropoffDay the dropoffDay to set
     */
    public void setDropoffDay(int dropoffDay) {
        this.dropoffDay = dropoffDay;
    }

    /**
     * @return the dropoffHour
     */
    public int getDropoffHour() {
        return dropoffHour;
    }

    /**
     * @param dropoffHour the dropoffHour to set
     */
    public void setDropoffHour(int dropoffHour) {
        this.dropoffHour = dropoffHour;
    }

    /**
     * @return the dropoffMin
     */
    public int getDropoffMin() {
        return dropoffMin;
    }

    /**
     * @param dropoffMin the dropoffMin to set
     */
    public void setDropoffMin(int dropoffMin) {
        this.dropoffMin = dropoffMin;
    }

    /**
     * @return the rentalType
     */
    public String getRentalType() {
        return rentalType;
    }

    /**
     * @param rentalType the rentalType to set
     */
    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    /**
     * @return the cardType
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * @param cardType the cardType to set
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @param cardNumber the cardNumber to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * @return the taxRate
     */
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate the taxRate to set
     */
    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @param priceSchedule the priceSchedule to set
     */
    public void setPriceSchedule(PriceSchedule priceSchedule) {
        this.priceSchedule = priceSchedule;
    }   

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }
}
