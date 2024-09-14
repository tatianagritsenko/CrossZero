import java.util.Scanner;

public class Game {
    private Map map = new Map();
    private Player player = Player.CROSS;
    private boolean isEndGame = false;

    public void play() {
        System.out.println("Игра крестики-нолики");

        while (!isEndGame) {
            makeMove();

            char winner = findWinner();

            switch (winner) {
                case 'X' -> System.out.println("Выиграли крестики");
                case 'O' -> System.out.println("Выиграли нолики");
                case 'T' -> System.out.println("Ничья");
            }

            if (winner != 'N')
                isEndGame = true;
            else
                changePlayer();
        }

        showMap();
        System.out.println("Игра закончена");
    }

    private char findWinner() {
        return map.findWinner();
    }

    private void showMap() {
        map.showMap();
    }

    private void makeMove() {
        showMap(); // показываем игровое поле

        showPlayer(); // показываем, чей ход

        // выбираем позицию
        int x, y;
        while (true) {
            x = chooseIndex('X');
            y = chooseIndex('Y');

            if (!map.checkPosition(x, y))
                System.out.println("Позиция занята");
            else
                break;
        }

        map.setElem(x, y, player);
    }

    private void showPlayer() {
        switch (player) {
            case Player.CROSS -> System.out.println("Ход крестиков");
            case Player.ZERO -> System.out.println("Ход ноликов");
        }
    }

    private int chooseIndex(char coordinate) {
        int index = -1;
        while (true)
        {
            System.out.printf("Выберите позицию по %c: ", coordinate);
            Scanner in = new Scanner(System.in);
            index = in.nextInt();
            if (map.checkIndex(index))
                break;
            else
                System.out.printf("Индекс %c выходит за границы массива", coordinate);
        }
        return index;
    }

    private void changePlayer() {
        if (player == Player.ZERO)
            player = Player.CROSS;
        else
            player = Player.ZERO;
    }

}
