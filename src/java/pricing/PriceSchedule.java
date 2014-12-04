/*
 *CarRates is used to represent the name of a class of rental car,
 *such as "Compact" and all associated prices (e.g. weekly rate, weekday rate)
 */
package pricing;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author junghun lee and julio tain sueiras
 */
public class PriceSchedule implements Serializable {
     private String typeName;
     private BigDecimal weekdayRate;
     private BigDecimal weekendRate;
     private BigDecimal weeklyRate;

    public PriceSchedule(String typeName, BigDecimal weekdayRate, BigDecimal weekendRate, BigDecimal weeklyRate) {
        this.typeName = typeName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.weeklyRate = weeklyRate;
    }

    public PriceSchedule() {
    }

    /**
     * @return the typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName the typeName to set
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * @return the weekdayRate
     */
    public BigDecimal getWeekdayRate() {
        return weekdayRate;
    }

    /**
     * @param weekdayRate the weekdayRate to set
     */
    public void setWeekdayRate(BigDecimal weekdayRate) {
        this.weekdayRate = weekdayRate;
    }

    /**
     * @return the weekendRate
     */
    public BigDecimal getWeekendRate() {
        return weekendRate;
    }

    /**
     * @param weekendRate the weekendRate to set
     */
    public void setWeekendRate(BigDecimal weekendRate) {
        this.weekendRate = weekendRate;
    }

    /**
     * @return the weeklyRate
     */
    public BigDecimal getWeeklyRate() {
        return weeklyRate;
    }

    /**
     * @param weeklyRate the weeklyRate to set
     */
    public void setWeeklyRate(BigDecimal weeklyRate) {
        this.weeklyRate = weeklyRate;
    }

    @Override
    public String toString() {
        return "CarRates{" + "typeName=" + typeName +
                ", weekdayRate=" + weekdayRate +
                ", weekendRate=" + weekendRate +
                ", weeklyRate=" + weeklyRate + '}';
    }    
}
