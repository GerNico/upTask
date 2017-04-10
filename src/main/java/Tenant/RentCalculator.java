package Tenant;
import java.util.Observable;

public class RentCalculator extends Observable{
    private static volatile RentCalculator instance;

    private double utilitiesCharge;
    private int numberOfMonths;
    private double rentAmount;
    private java.util.Date loanDate;

    /**
     Construct a RentCalculator with specified monthly utilities charge, number of months, and rent amount
     */

    private RentCalculator(double utilitiesCharge, int numberOfMonths, double rentAmount) {
        this.utilitiesCharge = utilitiesCharge;
        this.numberOfMonths = numberOfMonths;
        this.rentAmount = rentAmount;
        loanDate = new java.util.Date();
    }

    /** Return annualInterestRate */
    public double getutilitiesChargee() {
        return utilitiesCharge;
    }

    /** Set a new monthly untility charge */
    public void setutilitiesCharge(double utilitiesCharge) {
        this.utilitiesCharge = utilitiesCharge;
        super.setChanged();
    }

    /** Return numberOfMonths */
    public int getNumberOfMonths() {return numberOfMonths;}

    /** Set a new numberOfMonths */
    public void setNumberOfMonths(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
        super.setChanged();}

    /** Return loanAmount */  public double getRentAmount() {return rentAmount;}

    /** Set a newRentAmount */
    public void setRentAmount(double rentAmount) throws Exception { if (rentAmount < 0)
    throw new Exception("Money cannot be negative");
    this.rentAmount = rentAmount;
        super.setChanged();
    }

    /** Find total payment */
    public double getTotalRentPayment() {
        double totalPayment = (rentAmount + utilitiesCharge) * numberOfMonths;
        return totalPayment;
    }

    /** Return loan date */
    public java.util.Date getLoanDate() { return loanDate;}

    public static RentCalculator getCalculatorInstance(){
        if (instance==null)
            synchronized (RentCalculator.class){
            if (instance==null)
                instance=new RentCalculator(0,0,0);
            }
        return instance;
    }
}