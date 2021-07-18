package fizzsoftware.moneytracker;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Dayz implements Serializable {
    private String dateTitle;
    private ArrayList<Purchase> purchaseList = new ArrayList<>();

    public Dayz() {
        String tmpDate = new SimpleDateFormat("E hh:mm:ss a '['z']' '<'MM-dd-yyyy'>'").format(new Date());
        if (isDateValid(tmpDate)) {
            this.dateTitle = tmpDate;
        } else {
            this.dateTitle = "Date Not Found";
        }
    }

    public boolean isDateValid(String str) {
        if (str == null) {
            return false;
        }
        return true;
    }

    public void setDateTitle(String dat) {
        this.dateTitle = dat;
    }

    public String getDateTitle() {
        return this.dateTitle;
    }

    public int getPurchaseListSize() {
        return this.purchaseList.size();
    }

    public ArrayList<Purchase> getPurchaseList() {
        return this.purchaseList;
    }

    public String getPurchaseNodeName(int z) {
        return this.purchaseList.get(z).getTitle();
    }

    public String getPurchaseNodePrice(int y) {
        DecimalFormat e = new DecimalFormat("##00.00");
        e.setMinimumFractionDigits(2);
        return e.format(this.purchaseList.get(y).getPrice());
    }

    public void setPurchaseNodeName(String s, int z) {
        Purchase pu = this.purchaseList.get(z);
        if (s.isEmpty()) {
            s = "Blank Purchase";
        }
        pu.setTitle(s);
        this.purchaseList.set(z, pu);
    }

    public void setPurchaseNodePrice(String d, int y) {
        Purchase pu = this.purchaseList.get(y);
        if (d.isEmpty()) {
            d = "0.00";
        }
        pu.setPrice(Double.parseDouble(d));
        this.purchaseList.set(y, pu);
    }

    public void addPurchase(String name, String price) {
        Purchase p = new Purchase();
        if (name.isEmpty()) {
            name = "Blank Purchase";
        }
        if (price.isEmpty()) {
            price = "0.00";
        }
        p.setTitle(name);
        p.setPrice(Double.parseDouble(price));
        this.purchaseList.add(p);
    }

    public void removeLastPurchase() {
        if (this.purchaseList.size() > 0) {
            this.purchaseList.remove(this.purchaseList.size() - 1);
        }
    }

    public void clearPurchaseList() {
        if (this.purchaseList.size() > 0) {
            this.purchaseList.clear();
        }
    }

    public double getPurchaseTotal() {
        double sum = 0.0d;
        Iterator i$ = this.purchaseList.iterator();
        while (i$.hasNext()) {
            sum += i$.next().getPrice();
        }
        return sum;
    }

    public String toString() {
        DecimalFormat f = new DecimalFormat();
        f.setMinimumFractionDigits(2);
        return this.dateTitle + "  =  $ " + f.format(getPurchaseTotal());
    }
}
