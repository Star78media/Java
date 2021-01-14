public class Main {

    public static void main(String[] args) {
        // 1 2 3
        int n0Step = 1000;
        int winDoor;
        int PlayerGuess;
        int n0wins = 0;
        int n0Losses = 0;
        for (int i = 0; i < n0Step; i++) {
            winDoor = (int) (Math.random() * 3) + 1;
            PlayerGuess = (int) (Math.random() * 3) + 1;
            if (PlayerGuess == winDoor) {
                n0Losses += 1;

            } else {
                n0wins += 1;

            }
            System.out.println("Wins:" + n0wins + "Losses" + n0Losses);

        }
    }
}