import java.util.Scanner;

public class Player {
    
    private String name;
    private char symbol;
    private boolean isHuman;
    private int[][] stats; 


    public Player(String name, char symbol, boolean isHuman) {
        this.name = name;
        this.symbol = symbol;
        this.isHuman = isHuman;
        stats = new int[3][3]; // Amount of implemented gamemodes, 3 stats = {wins, draws, losses}

    }

    //-------New players-------

    public Player addPlayer(char symbol, boolean isHuman) {
        Scanner scanner = new Scanner(System.in);
        String name = ("Player " + (1 + Game.length(playerList)));
        

        System.out.println("Would you like to select a name for " + name + "?");
        System.out.println("1: Yes.");
        System.out.println("2: No.");
        int choice;

        while ((choice != 1) || (choice != 2)) {
            choice = scanner.nextInt();
        }

        if (choice == 1) {
            name = chooseName();
        }
        else {
            continue;
        }
        scanner.close();
        return new Player(name, symbol, isHuman);
    }

    public String chooseName() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        scanner.close();
        return name;
    }

    //-------Name, Symbol and isHuman-------

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public boolean isHuman() {
        return this.isHuman;
    }



    //-------Stats-------


    public int getWins(int gameMode) {
        return stats[gameMode][0];
    }
    public int getDraws(int gameMode) {
        return stats[gameMode][1];
    }
    public int getLosses(int gameMode) {
        return stats [gameMode][2];
    }
    public int getTotalStat(int stat) {
        int total = 0;
        for (int gameMode = 0; gameMode < this.stats.length; gameMode++) 
            total =+ this.stats[gameMode][stat];
        return total;
    }

    public void hasWon(int gameMode) {
        this.stats[gameMode][0] =+ 1;
    }
    public void isDraw(int gameMode) {
        this.stats[gameMode][1] =+ 1;
    }
    public void hasLost(int gameMode) {
        this.stats[gameMode][2] =+ 1;
    }

}
