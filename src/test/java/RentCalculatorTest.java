
import Tenant.RentCalculator;
import Tenant.Tenant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class RentCalculatorTest {

    @Test
    void setutilitiesCharge() throws Exception {
        RentCalculator rentCalc =RentCalculator.getCalculatorInstance();
        rentCalc.setutilitiesCharge(200);
        rentCalc.setNumberOfMonths(6);
        rentCalc.setRentAmount(300);
        assertEquals(200,rentCalc.getutilitiesChargee());
        rentCalc.setutilitiesCharge(300);
        assertEquals(300,rentCalc.getutilitiesChargee());
    }

    @Test
    void setNumberOfMonths() throws Exception {
        RentCalculator rentCalc =RentCalculator.getCalculatorInstance();
        rentCalc.setutilitiesCharge(200);
        rentCalc.setNumberOfMonths(6);
        rentCalc.setRentAmount(300);
        rentCalc.setNumberOfMonths(6);
        assertEquals(6,rentCalc.getNumberOfMonths());
    }


    @Test
    void setRentAmount() throws Exception {
        RentCalculator rentCalc =RentCalculator.getCalculatorInstance();
        rentCalc.setutilitiesCharge(200);
        rentCalc.setNumberOfMonths(6);
        rentCalc.setRentAmount(300);
        assertEquals(200,rentCalc.getutilitiesChargee());
        try {
            rentCalc.setRentAmount(-1);
        } catch (Exception e){assertEquals("Money cannot be negative",e.getMessage());}
        try {
            rentCalc.setRentAmount(-100);
        } catch (Exception e){assertEquals("Money cannot be negative",e.getMessage());}
    }

    @Test
    void getTotalRentPayment() throws Exception {
        RentCalculator rentCalc =RentCalculator.getCalculatorInstance();
        rentCalc.setutilitiesCharge(200);
        rentCalc.setNumberOfMonths(3);
        rentCalc.setRentAmount(300);
        assertEquals(1500,rentCalc.getTotalRentPayment());
        rentCalc.setNumberOfMonths(7);
        assertEquals(3500,rentCalc.getTotalRentPayment());

    }

    @Test
    void getLoanDate() {
    }

    @Test
    void observerPatern() throws Exception {
        RentCalculator rentCalc=RentCalculator.getCalculatorInstance();
        rentCalc.setNumberOfMonths(2);
        rentCalc.setRentAmount(1700);
        rentCalc.setutilitiesCharge(300);
        Tenant jeremy=new Tenant("Jeremy","Clarkson",123456,rentCalc.getRentAmount()+rentCalc.getutilitiesChargee());
        Tenant richard=new Tenant("Richard","Hammond",234567,rentCalc.getRentAmount()+rentCalc.getutilitiesChargee());
        Tenant james=new Tenant("James","May",345678,rentCalc.getRentAmount()+rentCalc.getutilitiesChargee());

        rentCalc.addObserver(jeremy);
        rentCalc.addObserver(james);
        rentCalc.addObserver(richard);

        rentCalc.setRentAmount(Math.round(Math.random()*3000));
        rentCalc.notifyObservers();

        rentCalc.deleteObserver(jeremy);
        rentCalc.setRentAmount(Math.round(Math.random()*2000));
        rentCalc.notifyObservers();

        rentCalc.deleteObserver(richard);
        rentCalc.addObserver(jeremy);
        rentCalc.setRentAmount(Math.round(Math.random()*1500));
        rentCalc.notifyObservers();

    }

}