public class Map {
    private final int mapSize = 3;

    private char[][] map = {
            {'.', '.', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'}
    };

    public void showMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf("%c ", map[i][j]);
            }
            System.out.println();
        }
    }

    public void setElem(int x, int y, Player player) {
        switch (player) {
            case ZERO -> map[x][y] = 'O';
            case CROSS -> map[x][y] = 'X';
        }
    }

    public boolean checkPosition(int x, int y) {
        return map[x][y] == '.';
    }

    public boolean checkIndex(int index) {
        return index < mapSize && index > -1;
    }

    public char findWinner() {
        if (checkWin('X')) return 'X';
        if (checkWin('O')) return 'O';
        if (isMapFull()) return 'T';
        return 'N';
    }

    private boolean checkWin(char symbol) {

        for (int i = 0; i < mapSize; i++) {
            if (map[i][0] == symbol && map[i][0] == map[i][1] && map[i][0] == map[i][2]) return true; // проверка по строкам
            if (map[0][i] == symbol && map[0][i] == map[1][i] && map[0][i] == map[2][i]) return true; // проверка по столбцам
        }

        // проверка по диагоналям
        if (map[0][0] == symbol && map[0][0] == map[1][1] && map[0][0] == map[2][2]) return true;
        if (map[0][2] == symbol && map[0][2] == map[1][1] && map[0][2] == map[2][0]) return true;

        return false;
    }

    private boolean isMapFull() {

        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++)
                if (map[i][j] == '.')
                    return false;

        return true;
    }
}
