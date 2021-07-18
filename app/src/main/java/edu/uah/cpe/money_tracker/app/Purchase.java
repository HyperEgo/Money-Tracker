package fizzsoftware.moneytracker;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Purchase implements Serializable {
    private double price;
    private String title;

    public void setTitle(String tit) {
        this.title = tit;
    }

    public void setPrice(double pr) {
        this.price = pr;
    }

    public String getTitle() {
        return this.title;
    }

    public double getPrice() {
        return this.price;
    }

    public String toString() {
        DecimalFormat f = new DecimalFormat("##0.00");
        f.setMinimumFractionDigits(2);
        return this.title + "  =  $ " + f.format(this.price);
    }
}
