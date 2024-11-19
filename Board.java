

public class Board {

// -------- Class variables ----------

    private String name = "Gameboard";
    private boolean isFull = false;
    private char[][] table; 
    private int spacesTaken = 0;
    private int spacesTotal = 9;


//  -------- Public Methods ---------

//Skapa bräde
    public void create(){
        this.create("Gameboard", 3, 3);
    }

    public void create(String Name){
        this.create(Name, 3, 3);
    }
    
    public void create(String name, int rows, int columns){
        this.table = new char[rows][columns];
        this.setName(name);
        this.setSpacesTotal(rows*columns);
        
    //TODO ----------Felhantering -- kan inte vara 0, hantera här eller där det skickas?
 
        for(int i = 0; i < this.table.length; i++){
            for(int j = 0; j < this.table[0].length; j++){
                table[i][j] = ' ';
            }
        }
    }

 
//Skriv ut bräde i terminal
    public void print(){   //TODO snygga till utskrift! siffror hamnar snett om det är tvåsiffrigt
    System.out.println("Here is your board!");
        
    
        this.printColumnNumbers();
        this.printLine();
        for(int x = 0; x < this.table.length; x++){
            this.printRow(x);
            this.printLine();
        }
        System.out.println("");

    }
    
//Kolla om space is valid - här kontrolleras att platsen finns med på brädet
    public boolean checkSpaceValid (int row, int column){
        if(row >= 0 && row < this.table.length && column >= 0 && column < this.table[0].length){
            return true;
        }else{
            return false;
        }
    }

//Kolla om plats är ledig
    public boolean checkSpaceAvailable (int row, int column){
        if (checkSpaceValid(row, column) && this.table[row][column] == ' '){
            return true; 
        }else{
            return false;
        }
    }

//Placera symbol
    public void placeSymbol(int row, int column, char symbol){
    //TODO ----------Felhantering och skicka true eller ha bara void?----
        if (this.checkSpaceAvailable(row, column)){
            this.table[row][column] = symbol;
            this.spacesTaken++;
            if (this.spacesTaken >= this.spacesTotal){
                this.setIsFull(true);
            }
        }
   }
 

//Kolla om vinst
    public boolean checkIfWin(int row, int column, int numbersInRowToWin){
        int Horizontal = 1;
        int Vertical = 1;
        int DiagonalDown = 1;
        int DiagonalUp = 1;

        Vertical = Vertical + this.checkUp(row, column);
        Vertical = Vertical + this.checkDown(row, column);

        Horizontal = Horizontal + this.checkLeft(row, column);
        Horizontal = Horizontal + this.checkRight(row, column);

        DiagonalDown = DiagonalDown + this.checkUpLeft(row, column);
        DiagonalDown = DiagonalDown + this.checkDownRight(row, column);
        
        DiagonalUp = DiagonalUp + this.checkUpRight(row, column);
        DiagonalUp = DiagonalUp + this.checkDownLeft(row, column);
        
        System.out.println("Vertikalt : " + Vertical);    
        System.out.println("Horisontellt : " + Horizontal);  
        System.out.println("Diagonalt nedåt: " + DiagonalDown);
        System.out.println("Diagonalt uppåt: " + DiagonalUp);
        
        if( Vertical >= numbersInRowToWin || 
            Horizontal >= numbersInRowToWin ||
            DiagonalDown >= numbersInRowToWin ||
            DiagonalUp >= numbersInRowToWin)
        {
            return true;
        }else{
            return false;
        }
    }

// ---------- Private methods -------

    private int checkUp(int row, int column){
        int localNumbersInRow = 0;
        int i = row - 1;
        while(checkSpaceValid(i, column)){
            if(this.table[i][column] == this.table[row][column]){
                localNumbersInRow++;
                i--;
            }else{ 
                break;
            }
        }
        return localNumbersInRow;
    }
    private int checkDown(int row, int column){
        int localNumbersinrow = 0;
        int i = row + 1;
        while(checkSpaceValid(i, column)){
            if(this.table[i][column] == this.table[row][column]){
                localNumbersinrow++;
                i++;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private int checkLeft(int row, int column){
        int localNumbersinrow = 0;
        int j = column - 1;
        while(checkSpaceValid(row, j)){
            if(this.table[row][j] == this.table[row][column]){
                localNumbersinrow++;
                j--;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private int checkRight(int row, int column){
        int localNumbersinrow = 0;
        int j = column + 1;
        while(checkSpaceValid(row, j)){
            if(this.table[row][j] == this.table[row][column]){
                localNumbersinrow++;
                j++;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private int checkUpLeft(int row, int column){
        int localNumbersinrow = 0;
        int i = row - 1;
        int j = column - 1;
        while(checkSpaceValid(i, j)){
            if(this.table[i][j] == this.table[row][column]){
                localNumbersinrow++;
                i--;
                j--;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private int checkDownRight(int row, int column){
        int localNumbersinrow = 0;
        int i = row + 1;
        int j = column + 1;
        while(checkSpaceValid(i, j)){
            if(this.table[i][j] == this.table[row][column]){
                localNumbersinrow++;
                i++;
                j++;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }


    private int checkUpRight(int row, int column){
        int localNumbersinrow = 0;
        int i = row - 1;
        int j = column + 1;
        while(checkSpaceValid(i, j)){
            if(this.table[i][j] == this.table[row][column]){
                localNumbersinrow++;
                i--;
                j++;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private int checkDownLeft(int row, int column){
        int localNumbersinrow = 0;
        int i = row + 1;
        int j = column - 1;
        while(checkSpaceValid(i, j)){
            if(this.table[i][j] == this.table[row][column]){
                localNumbersinrow++;
                i++;
                j--;
            }else{ 
                break;
            }
        }
        return localNumbersinrow;
    }

    private void printRow(int x){
        System.out.print((x+1) + " | ");
        for(char a : table[x]){
            System.out.print(a + " | ");
        }
        System.out.println("");
    }

    private void printColumnNumbers(){
        System.out.print("  | ");
        for(int m = 1; m <= this.table[0].length; m++){
            System.out.print(m + " | ");
        } 
        System.out.println("");
    }

    private void printLine(){
        for(int m = 0; m <= this.table[0].length; m++){
            System.out.print("----");
        }
        System.out.println("");
    }


// ------- Getters and setters --------


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public char[][] getTable() {
        return this.table;
    }
    
    public void setTable(char[][] table) {
        this.table = table;
    }
    
    public int getSpacesTaken() {
        return this.spacesTaken;
    }
    
    public void setSpacesTaken(int spacesTaken) {
        this.spacesTaken = spacesTaken;
    }
    
    public int getSpacesTotal() {
        return this.spacesTotal;
    }
    
    public void setSpacesTotal(int spacesTotal) {
        this.spacesTotal = spacesTotal;
    }


    public boolean getIsFull() {
        return this.isFull;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }

}