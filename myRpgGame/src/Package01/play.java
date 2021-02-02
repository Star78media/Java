package Package01;

public class play {
    static Game_Logic gl = new Game_Logic();

    public static void main(String[] args) {
        Game_objects.initalizeNPCArray();
        while (true) {
            game_loop();
        }
    }

        public static void game_loop ()
        {
            gl.waiterCommand();

        }
    }
