/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pricing;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author jhlee
 */
public class RentalFormValidator {

    private HttpServletRequest formRequest;
    private ArrayList<Integer> errorCodes;
    private RentalBean bean = new RentalBean();

    public RentalFormValidator(HttpServletRequest formRequest) {
        this.formRequest = formRequest;
        this.errorCodes = new ArrayList<Integer>();
    }

    public boolean isValid() {
        boolean valid = true;

        if (isCustomerNull()) {
            valid = false;
        }
        if (!isCustomerNumeric()) {
            valid = false;
        } else {
            bean.setCustomerNumber(Integer.parseInt(formRequest.getParameter("customerNo")));
        }
        if (isPickupDayNull()) {
            valid = false;
        }
        if (!isPickupDayInRange()) {
            valid = false;
        } else {
            bean.setPickupDay(Integer.parseInt(formRequest.getParameter("pickupDay")));
        }
        if (isPickupMonthNull()) {
            valid = false;
        }
        if (!isPickupMonthInRange()) {
            valid = false;
        } else {
            bean.setPickupMon(Integer.parseInt(formRequest.getParameter("pickupMonth")));

        }
        if (isPickupYearNull()) {
            valid = false;
        }
        if (!isPickupYearInRange()) {
            valid = false;
        } else {
            bean.setPickupYear(Integer.parseInt(formRequest.getParameter("pickupYear")));

        }
        if (isPickupHourNull()) {
            valid = false;
        }
        if (!isPickupHourInRange()) {
            valid = false;
        } else {
            bean.setPickupHour(Integer.parseInt(formRequest.getParameter("pickupHour")));

        }
        if (isDropoffDayNull()) {
            valid = false;
        }
        if (!isDropoffDayInRange()) {
            valid = false;
        } else {
            bean.setDropoffDay(Integer.parseInt(formRequest.getParameter("dropoffDay")));

        }
        if (isDropoffMonthNull()) {
            valid = false;
        }
        if (!isDropoffMonthInRange()) {
            valid = false;
        } else {
            bean.setDropoffMon(Integer.parseInt(formRequest.getParameter("dropoffMonth")));

        }
        if (isDropoffYearNull()) {
            valid = false;
        }
        if (!isDropoffYearInRange()) {
            valid = false;
        } else {
            bean.setDropoffYear(Integer.parseInt(formRequest.getParameter("dropoffYear")));

        }
        if (isDropoffHourNull()) {
            valid = false;
        }
        if (!isDropoffHourInRange()) {
            valid = false;
        } else {
            bean.setDropoffHour(Integer.parseInt(formRequest.getParameter("dropoffHour")));

        }
        if (isCarTypeNull()) {
            valid = false;
        }
        if (!isCarTypeInRange()) {
            valid = false;
        } else {
            bean.setRentalType(formRequest.getParameter("cartype"));

        }
        if (isCreditCardTypeNull()) {
            valid = false;
        }
        if (!isCreditCardTypeInRange()) {
            valid = false;
        } else {
            bean.setCardType(formRequest.getParameter("creditCardType"));
        }
        if (isCreditCardNoNull()) {
            valid = false;
        }
        if (!isCreditCardNoInRange()) {
            valid = false;
        } else {
            bean.setCardNumber(formRequest.getParameter("creditCardNo"));
        }
        return valid;
    }

    public void setErrorCodes(ArrayList<Integer> errorCodes) {
        this.errorCodes = errorCodes;
    }

    public ArrayList<Integer> getErrorCodes() {
        return errorCodes;
    }

    public boolean isCustomerNull() {
        try {
            if (formRequest.getParameter("customerNo").isEmpty()) { // || formRequest.getParameter("customer") == null
                errorCodes.add(1011);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean isCustomerNumeric() {
        try {
            Integer.valueOf(formRequest.getParameter("customerNo"));
        } catch (NumberFormatException e) {
            errorCodes.add(1012);
            return false;
        }
//        bean.setCustomerNumber(Integer.parseInt(formRequest.getParameter("customerNo")));
        return true;
    }

    public boolean isPickupDayNull() {
        if (formRequest.getParameter("pickupDay").isEmpty() || formRequest.getParameter("pickupDay") == null) {
            errorCodes.add(1021);
            return true;
        }
        return false;
    }

    public boolean isPickupDayInRange() {
        try {
            if (Integer.parseInt(formRequest.getParameter("pickupDay")) < 1 || Integer.parseInt(formRequest.getParameter("pickupDay")) > 31) {
                errorCodes.add(1022);
                return false;
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    //need to fix...test fail.
    public boolean isPickupMonthNull() {
        if (formRequest.getParameter("pickupMonth").isEmpty() || formRequest.getParameter("pickupMonth") == null) {
            errorCodes.add(1031);
            return true;
        }
        return false;
    }

    public boolean isPickupMonthInRange() {
        try {
            if (Integer.parseInt(formRequest.getParameter("pickupMonth")) < 1 || Integer.parseInt(formRequest.getParameter("pickupMonth")) > 12) {
                errorCodes.add(1032);
                return false;
            }
//            bean.setPickupMon(Integer.parseInt(formRequest.getParameter("pickupMonth")));
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPickupYearNull() {
        if (formRequest.getParameter("pickupYear").isEmpty() || formRequest.getParameter("pickupYear") == null) {
            errorCodes.add(1041);
            return true;
        }
        return false;
    }

    public boolean isPickupYearInRange() {
        try {
            if (formRequest.getParameter("pickupYear").equalsIgnoreCase("2014") || formRequest.getParameter("pickupYear").equalsIgnoreCase("2015")) {
                return true;
            } else {
                errorCodes.add(1042);
                return false;
            }
//            int pickupYear = Integer.parseInt(formRequest.getParameter("pickupYear"));
//            bean.setPickupYear(pickupYear);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPickupHourNull() {
        if (formRequest.getParameter("pickupHour").isEmpty() || formRequest.getParameter("pickupHour") == null) {
            errorCodes.add(1051);
            return true;
        }
        return false;
    }

    public boolean isPickupHourInRange() {
        try {
            if (Integer.parseInt(formRequest.getParameter("pickupHour")) < 0 || Integer.parseInt(formRequest.getParameter("pickupHour")) > 23) {
                errorCodes.add(1052);
                return false;
            }
//            bean.setPickupHour(Integer.parseInt(formRequest.getParameter("pickupHour")));
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDropoffDayNull() {
        if (formRequest.getParameter("dropoffDay").isEmpty() || formRequest.getParameter("dropoffDay") == null) {
            errorCodes.add(1061);
            return true;
        }
        return false;
    }

    public boolean isDropoffDayInRange() {
        try {
            if (Integer.parseInt(formRequest.getParameter("dropoffDay")) < 1 || Integer.parseInt(formRequest.getParameter("dropoffDay")) > 31) {
                errorCodes.add(1062);
                return false;
            }
//            bean.setDropoffDay(Integer.parseInt(formRequest.getParameter("dropoffDay")));
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDropoffMonthNull() {
        if (formRequest.getParameter("dropoffMonth").isEmpty() || formRequest.getParameter("dropoffMonth") == null) {
            errorCodes.add(1071);
            return true;
        }
        return false;
    }

    public boolean isDropoffMonthInRange() {
        try {
            if (Integer.parseInt(formRequest.getParameter("dropoffMonth")) < 1 || Integer.parseInt(formRequest.getParameter("dropoffMonth")) > 12) {
                errorCodes.add(1072);
                return false;
            }
//            bean.setDropoffMon(Integer.parseInt(formRequest.getParameter("dropoffMonth")));
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDropoffYearNull() {
        if (formRequest.getParameter("dropoffYear").isEmpty() || formRequest.getParameter("dropoffYear") == null) {
            errorCodes.add(1081);
            return true;
        }
        return false;
    }

    public boolean isDropoffYearInRange() {
        try {
            if (formRequest.getParameter("dropoffYear").equalsIgnoreCase("2014") || formRequest.getParameter("dropoffYear").equalsIgnoreCase("2015")) {
                return true;
            } else {
                errorCodes.add(1082);
                return false;
            }
//            bean.setDropoffYear(Integer.parseInt(formRequest.getParameter("dropoffYear")));

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDropoffHourNull() {
        if (formRequest.getParameter("dropoffHour").isEmpty() || formRequest.getParameter("dropoffHour") == null) {
            errorCodes.add(1091);
            return true;
        }
        return false;
    }

    public boolean isDropoffHourInRange() {
        try {
            if (Integer.parseInt(formRequest.getParameter("dropoffHour")) < 0 || Integer.parseInt(formRequest.getParameter("dropoffHour")) > 23) {
                errorCodes.add(1092);
                return false;
            }
//            bean.setDropoffHour(Integer.parseInt(formRequest.getParameter("dropoffHour")));
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCarTypeNull() {
        if (formRequest.getParameter("cartype").isEmpty() || formRequest.getParameter("cartype") == null) {
            errorCodes.add(1101);
            return true;
        }
        return false;
    }

    public boolean isCarTypeInRange() {
        if (formRequest.getParameter("cartype").equalsIgnoreCase("economy")
                || formRequest.getParameter("cartype").equalsIgnoreCase("standard")
                || formRequest.getParameter("cartype").equalsIgnoreCase("luxury")
                || formRequest.getParameter("cartype").equalsIgnoreCase("minivan")) {
            return true;
        }
        errorCodes.add(1102);
        return false;
//        bean.setDropoffHour(Integer.parseInt(formRequest.getParameter("dropoffHour")));
    }

    public boolean isCreditCardTypeNull() {
        if (formRequest.getParameter("creditCardType").isEmpty() || formRequest.getParameter("creditCardType") == null) {
            errorCodes.add(1111);
            return true;
        }
        return false;
    }

    public boolean isCreditCardTypeInRange() {
        try {
            if (formRequest.getParameter("creditCardType").equalsIgnoreCase("visa")
                    || formRequest.getParameter("creditCardType").equalsIgnoreCase("mastercard")) {
                return true;
            } else {
                errorCodes.add(1112);
                return false;
            }
//            bean.setCardType(formRequest.getParameter("cerditCardType"));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCreditCardNoNull() {
        if (formRequest.getParameter("creditCardNo").isEmpty() || formRequest.getParameter("creditCardNo") == null) {
            errorCodes.add(1121);
            return true;
        }
        return false;
    }

    public boolean isCreditCardNoInRange() {
        String cardType = formRequest.getParameter("creditCardType");
        String cardNo = formRequest.getParameter("creditCardNo").trim();

        if (cardType.equalsIgnoreCase("visa")) {
            if (cardNo.charAt(0) == '4') {
                if (cardNo.length() == 13 || cardNo.length() == 16) {
                    return true;
                }
            } else {
                errorCodes.add(1122);
                return false;
            }
        } else if (cardType.equalsIgnoreCase("mastercard")) {
            if (!cardNo.startsWith("51") || !cardNo.startsWith("52") || !cardNo.startsWith("53") || !cardNo.startsWith("54") || !cardNo.startsWith("55")) {
                if (cardNo.length() != 16) {
                    errorCodes.add(1122);
                    return false;
                }
            } else {
                return true;
            }
        }
        return true;
//        bean.setCardNumber(formRequest.getParameter(cardNo));
    }

    public RentalBean getBean() {
        return bean;
    }

    public void setBean(RentalBean bean) {
        this.bean = bean;
    }
}
