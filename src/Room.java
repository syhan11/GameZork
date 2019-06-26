
import java.text.NumberFormat;

public class Room {
    protected static int max = 0;
    private int number;
    private String name;
    private String items;
    private double money;
    private boolean thief;


    public Room() {
        number = max;
        name = "";
        items = "";
        money = 0.0;
        thief = false;
        max++;
    }

    public Room(String name, String items, double money, boolean thief) {
        number = max;
        this.name = name;
        this.items = items;
        this.money = money;
        this.thief = thief;
        max++;
    }

    public int getNumber() {
        return number;
    }
    /*
     * once an item of a room is taken, it is no longer there for others to take
     */
    public  String getItem() {
        String tmp = this.items;
        this.items = null;
        return tmp;
    }

    public  void setItem(String varI) {
        this.items = varI;
    }

    /*
     * once money is taken, it is no longer there for others to take
     */
    public  double getMoney() {
        double tmp = this.money;
        this.money = 0.0;
        return tmp;
    }

    public  void setMoney(double money) {
        // convert double money into 2 decimal points
        //NumberFormat.getCurrencyInstance().format(valD);
        this.money = money;
    }

    public  boolean isThief() {
        return this.thief;
    }

    public  void setThief(boolean thief) {
        this.thief = thief;
    }

    public  void printInfo() {

        System.out.println("Room " + number + ": " +
                           "\tName: " + name +
                           "\tItems: " + items +
                           "\tMoney: " + formatMoney() +
                           "\tThief: " + thief );
    }

    public String formatMoney(){
        return NumberFormat.getCurrencyInstance().format(money);
    }
}
