package Tenant;

import java.util.Observable;
import java.util.Observer;

public class Tenant implements Observer {
    String firstName;
    String secondName;
    long id;
    double expectedRent;

    public Tenant(String fN, String sN, long ident,double rent){
        this.firstName=fN;
        this.secondName=sN;
        this.id=ident;
        this.expectedRent=rent;

    }
    @Override
    public void update(Observable o, Object arg) {
        double newRent=((RentCalculator)o).getRentAmount()+((RentCalculator)o).getutilitiesChargee();
        if (newRent>this.expectedRent) System.out.println(this.firstName+": Greedy bastards! "+(newRent-this.expectedRent)+"$ more to pay");
        else System.out.println(this.firstName+": Hah! Good news! "+(this.expectedRent-newRent)+"$ less to pay");
        this.expectedRent=newRent;
    }
}

