import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameZork {
    public static ArrayList<Room> roomArray = null;  // all the room information

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String userMsg;
        Player player = new Player();

        System.out.println("Would you like to play a game of Zork (y/n)?");
        userMsg = keyboard.nextLine();
        if (userMsg.equalsIgnoreCase("y")) {
            // play a game
            roomArray = new ArrayList<Room>();

            initGame();
            playerStatus(player);
        }
        else {
            // stop the game
        }




        for (Room aroom : roomArray)
            aroom.printInfo();
    }


    public static void initGame() {
        Room aroom;


        aroom = new Room("outside");
        roomArray.add(aroom);

        aroom = new Room ("foyer", "dead scorpion");
        roomArray.add(aroom);

        aroom = new Room ("library", "spiders");
        roomArray.add(aroom);

        aroom = new Room ("kitchen", "bats");
        roomArray.add(aroom);

        aroom = new Room ("front room", "piano");
        roomArray.add(aroom);

        aroom = new Room ("dining room", "dust, empty box");
        roomArray.add(aroom);

        aroom = new Room ("vault", "3 walking skeletons");
        roomArray.add(aroom);

        aroom = new Room ("parlor", "treasure chest");
        roomArray.add(aroom);

        aroom = new Room ("secret room", "piles of gold");
        roomArray.add(aroom);

        // initialize money (upto $1000) to each room other than "outside"
        int max = roomArray.size();
        Random random = new Random();
        double amt;

        for (int i = 1; i < max; i++) {
            amt = random.nextDouble() * 1000;
            aroom = roomArray.get(i);
            aroom.setMoney(amt);
        }

        // randomly assign a thief to a room other than "outside"
        int item = random.nextInt(max-1) + 1;
        aroom = roomArray.get(item);
        aroom.setThief(true);
    }

    public static void playerStatus(Player valP){
        String items = "";

        System.out.println("You are in room " + valP.getRoomId() +
                           ", " + valP.getRoomname());

        items = valP.getItems();
        if (items.length() == 0)
            items = "no items";

        System.out.println("You have " + valP.printMoney() + " and " + items);
    }

    public static String printMoney(double amt) {
        return NumberFormat.getCurrencyInstance().format(amt);
    }
}
