import java.text.NumberFormat;
import java.util.ArrayList;

public class Player {
    protected static int id = 0;        // player id
    private int roomid;                   // room number player is in
    private String roomname;            // room name player is in
    private String items;               // items player obtained
    private double money;               // money player obtained
    private ArrayList<String> history;  // history of where player had been

    public Player() {
        id++;
        roomid = 0;
        roomname = "";
        items = "";
        money = 0;
        history = null;
    }

    public int getRoomId() {
        return roomid;
    }

    public void setRoomId(int room) {
        this.roomid = room;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getItems() {
        return items;
    }

    public void addItems(String items) {
        this.items = this.items + ", " + items;
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(double money) {
        this.money += money;
    }

    public String printMoney() {
        return NumberFormat.getCurrencyInstance().format(money);
    }

    public ArrayList<String> getAllHistory() {
        return history;
    }

    public void addHistory(String history) {
        this.history.add(history);
    }
}
