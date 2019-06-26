import java.util.ArrayList;
import java.util.Random;

public class GameZork {
    public static ArrayList<Room> roomArray;  // all the room information

    public static void main(String[] args) {
        roomArray = new ArrayList<Room>();

        initGame();

        for (Room aroom : roomArray)
            aroom.printInfo();
    }


    public static void initGame() {
        Room aroom;

        aroom = new Room("outside", "", 0.0, false);
        roomArray.add(aroom);

        aroom = new Room ("foyer", "dead scorpion", 0.0, false);
        roomArray.add(aroom);

        aroom = new Room ("library", "spiders", 0.0, false);
        roomArray.add(aroom);

        aroom = new Room ("kitchen", "bats", 0.0, false);
        roomArray.add(aroom);

        aroom = new Room ("front room", "piano", 0.0, false);
        roomArray.add(aroom);

        aroom = new Room ("dining room", "dust, empty box", 0.0, false);
        roomArray.add(aroom);

        aroom = new Room ("vault", "3 walking skeletons", 0.0, false);
        roomArray.add(aroom);

        aroom = new Room ("parlor", "treasure chest", 0.0, false);
        roomArray.add(aroom);

        aroom = new Room ("secret room", "piles of gold", 0.0, false);
        roomArray.add(aroom);

        // initialize money to each room other than room 1 - outside
        int max = roomArray.size();
        Random random = new Random();
        double amt;

        for (int i = 1; i < max; i++) {
            amt = random.nextDouble() * 1000;
            aroom = roomArray.get(i);
            aroom.setMoney(amt);
        }

        // randomly assign a thief to a room other than room 0 - outside
        int item = random.nextInt(max-1) + 1;
        aroom = roomArray.get(item);
        aroom.setThief(true);
    }
}
