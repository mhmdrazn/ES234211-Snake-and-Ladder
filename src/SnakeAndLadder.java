import java.util.ArrayList;
import java.util.Scanner;

public class SnakeAndLadder {
    private ArrayList<Player> players;
    private ArrayList<Snake> snakes;
    private ArrayList<Ladder> ladders;
    private ArrayList<Todboxes> todBoxes;
    private int boardSize;
    //0 = the game isn't started yet
    //1 = the game is started
    //2 = the game is over
    private int status;
    private int playerInTurn;

    // SnakeAndLadder constructor
    public SnakeAndLadder(){
        this.players = new ArrayList<Player>();
        this.snakes = new ArrayList<Snake>();
        this.ladders = new ArrayList<Ladder>();
        this.todBoxes = new ArrayList<Todboxes>();
        this.status = 0; // set status ke 0, karena game belum dimulai
        this.playerInTurn = 0; // set playerInTurn ke 0, karena belum terdapat player yang akan memulai game
    }

    // set board size, snake, dan ladder sesuai dengan difficulty
    public void initiateGame(){
        System.out.println();
        System.out.println("Choose the level of the game below: \n1. Easy \n2. Medium \n3. Hard");
        Scanner sc = new Scanner(System.in);
        int difficulty = sc.nextInt();
        sc.nextLine();

        // atur  tingkat kesulitan game, terdapat 3 level, yakni easy, medium, dan hard.
        // masing masing level memiliki perbedaan di board size, jumlah snake, dan jumlah ladder
        switch(difficulty){
            case 1: // level easy
                this.boardSize = 100;
                int[][] easyLadders = {
                        {2,23},{8,34},{20,77},{32,68},
                        {41,79},{74,88},{82,100},{85,95}
                };
                addLadders(easyLadders);

                int[][] easySnakes = {
                        {29,9},{38,15},{47,5},{53,33},
                        {62,37},{86,54},{92,70},{97,25}
                };
                addSnakes(easySnakes);
                break;

            case 2: // level medium
                this.boardSize = 144;
                int[][] mediumLadders = {
                        {2, 23}, {8, 34}, {20, 77}, {32, 68},{41, 79},{74, 88},
                        {82, 100},{85, 95},{101, 123},{112, 130},{120, 135},{128, 140}
                };
                addLadders(mediumLadders);
                int[][] mediumSnakes = {
                        {29, 9},{38, 15},{47, 5},{53, 33},{62, 37},{86, 54},
                        {92, 70},{97, 25},{110, 90},{115, 95},{120, 99},{125, 105}
                };
                addSnakes(mediumSnakes);
                break;

            case 3: // level hard
                this.boardSize = 196;
                int[][] hardLadders = {
                        {2, 23},{8, 34},{20, 77},{32, 68},{41, 79},{74, 88},{82, 100},{85, 95},{101, 123},
                        {112, 130},{120, 135},{128, 140},{145, 157},{150, 165},{160, 175},{170, 190}
                };
                addLadders(hardLadders);
                int[][] hardSnakes = {
                        {29, 9},{38, 15},{47, 5},{53, 33},{62, 37},{86, 54},{92, 70},{97, 25},{110, 90},
                        {115, 95},{120, 99},{125, 105},{130, 110},{135, 115},{140, 120},{145, 125}
                };
                addSnakes(hardSnakes);
                break;
            default:
                System.out.println("Invalid difficulty level");
                break;
        }

        // generate ToD Boxes sesuai dengan ukuran dari boardSize
        for (int i = 0; i < boardSize/10; i++){
            Todboxes todBox = Todboxes.generateRandomToDBox(boardSize);
            todBoxes.add(todBox);
        };
    }

    // setter
    public void setBoardSize(int boardSize){
        this.boardSize = boardSize;
    }
    public void setSnakes(int status){
        this.status = status;
    }
    public void setPlayerInTurn(int playerInTurn){
        this.playerInTurn = playerInTurn;
    }
    public void setStatus(int n){
        this.status = n;
    }

    // getter
    public ArrayList<Player> getPlayers(){
        return players;
    }
    public ArrayList<Ladder> getLadders(){
        return ladders;
    }
    public ArrayList<Snake> getSnakes(){
        return snakes;
    }
    public ArrayList<Todboxes> getTodboxes(){
        return todBoxes;
    }
    public int getBoardSize(){
        return boardSize;
    }
    public int getPlayerInTurn(){
        return playerInTurn;
    }
    public int getStatus(){
        return status;
    }

    // method untuk menambahkan player ke dalam arraylist
    public void addPlayers(String[] playerNames) {
        for (String playerName : playerNames) {
            Player p = new Player(playerName);
            this.players.add(p);
        }
    }

    // method untuk menambahkan snake ke dalam arraylist
    public void addSnakes(int[][] snake){
        for (int i = 0; i < snake.length; i++){
            Snake s = new Snake(snake[i][0], snake[i][1]);
            this.snakes.add(s);
        }
    }

    // method untuk menambahkan ladder ke dalam arraylist
    public void addLadders(int[][] ladder){
        for (int i = 0; i < ladder.length; i++){
            Ladder l = new Ladder(ladder[i][0], ladder[i][1]);
            this.ladders.add(l);
        }
    }

    // method untuk menentukan player turn
    public int getTurn(){
        if (this.status == 0){
            return (int) (Math.random() * this.players.size());
        } else {
            return (this.playerInTurn + 1) % this.players.size();
        }
    }

    // method untuk memindahkan player sesuai dengan dice number yang diperoleh 
    public void movePlayer(Player player, int move){
        player.moveAround(move, this.boardSize);

        // cek laddder
        for (int i = 0; i < this.ladders.size(); i++){
            Ladder ladder = this.ladders.get(i);
            if (player.getPosition() == ladder.getFromPosition()){
                player.setPosition(ladder.getToPosition());
                System.out.println(player.getUserName() + " got ladder from " + ladder.getFromPosition() + " climb to " + ladder.getToPosition());
                SoundEffect.playSound("sound/ladderSoundEffect.wav");
            }
        } 
        
        // cek snake
        for (int i = 0; i < this.snakes.size(); i++){
            Snake snake = this.snakes.get(i);
            if (player.getPosition() == snake.getFromPosition()){
                player.setPosition(snake.getToPosition());
                System.out.println(player.getUserName() + " got snake from " + snake.getFromPosition() + " slide down to " + snake.getToPosition());
                SoundEffect.playSound("sound/snakeSoundEffect.wav");
            }
        }

        // cek ToD Box
        for (Todboxes todBox: this.todBoxes){
            if(player.getPosition() == todBox.getPosition()){
                System.out.println("\n---------------------------------\n");
                System.out.println(player.getUserName() + " landed on a Truth or Dare Box!");
                System.out.println("Your challenge is, " + todBox.getChallenge());
            }
        }

        System.out.println(player.getUserName() + " new position is " + player.getPosition());
        if(player.getPosition() == getBoardSize()){
            this.status = 2;
            System.out.println("\nThe winner is: " + player.getUserName() + "\n");
            SoundEffect.playSound("sound/winnerSound.wav");
        }
    }

    // method untuk mengecek snake terdekat jika kalah dalam duel pada posisi yang sama
    public Snake findTheNearestSnake(int position){
        Snake nearestSnake = null;
        int minDistance = Integer.MAX_VALUE;

        for (Snake snake : this.snakes){
            int distance = position - snake.getFromPosition();
            if (distance > 0 && distance < minDistance){
                minDistance = distance;
                nearestSnake = snake;
            }
        }
        return nearestSnake;
    }

    // method untuk menentukan jumlah player
    public void initiatePlayer() {
        Scanner sc = new Scanner(System.in);
        int numPlayers;
    
        do {
            System.out.println("Enter the number of players between 2 until 4:");
            numPlayers = sc.nextInt();
            sc.nextLine();
    
            // validasi jumlah player yang diinput
            if (numPlayers < 2 || numPlayers > 4) {
                System.out.println("Invalid number of players. Please enter a number between 2 and 4.");
            }
        } while (numPlayers < 2 || numPlayers > 4); // loop sampai jumplah player yang diinput valid
    
        // buat array untuk menampung nama player
        String[] playerNames = new String[numPlayers];
    
        // input nama untuk setiap player
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter player " + (i + 1) + " name:");
            playerNames[i] = sc.nextLine();
        }
    
        // buat object player dan input ke dalam ArrayList
        for (String playerName : playerNames) {
            Player player = new Player(playerName);
            // memasukkan playerNames ke dalam ArrayList players
            this.players.add(player);
        }
    }

    // method untuk memulai game 
    public void play(){
        System.out.println("\n------------ Snake And Ladder is Started! ------------\n");

        // inisiasi player
        initiatePlayer();

        // inisiasi gamenya
        initiateGame();

        do {
            // mulai game dengan set nilai status ke 1
            setStatus(1);

            // tentukan player yang mendapatkan giliran
            int t1 = getTurn();
            setPlayerInTurn(t1);

            // display playerInTurn
            Player playerInTurn = getPlayers().get(t1);
            System.out.println("\n---------------------------------\n");
            System.out.println("Player in turn is " + playerInTurn.getUserName());

            // playerInTurn melakukan roll dice
            Scanner sc = new Scanner(System.in);
            int x = 0;

            do{
                System.out.println(playerInTurn.getUserName() + " it's your turn, please press enter to roll the dice");
                String input = sc.nextLine();

                if (input.isEmpty()){
                    x = playerInTurn.rollDice();
                }
                System.out.println("Dice number: " + x);

                // pindahkan player sesuai dengan dice
                movePlayer(playerInTurn, x);
            } while (x == 6); // jika mendapatkan dadu 6, player akan roll dice kembali
            
            // cek apakah ada player lain di posisi yang sama
            for (Player player : this.players){
                // jika terdapat player lain di posisi yang sama 
                if (player != playerInTurn && player.getPosition() == playerInTurn.getPosition()){
                    System.out.println("\n---------------------------------\n");
                    System.out.println("Both Players " + playerInTurn.getUserName() + " and " + player.getUserName() + " are in the same position!");

                    // mini game, melakukan besar-besaran angka dadu
                    System.out.println(playerInTurn.getUserName() + " and " + player.getUserName() + " will now roll the dice to determine the loser.");

                    int dice1, dice2;
                    do{
                        dice1 = playerInTurn.rollDice();
                        dice2 = player.rollDice();

                        System.out.println(playerInTurn.getUserName() + " rolled:" + dice1);
                        System.out.println(player.getUserName() + " rolled:" + dice2);

                        if (dice1 == dice2){
                            System.out.println("It's a draw! Rolling the dice again...");
                        } 
                    } while (dice1 == dice2);

                    Player loser = dice1 < dice2? playerInTurn: player;
                    System.out.println("The loser is: " + loser.getUserName());

                    // cari dan pindahkan posisi loser ke snake terdekat
                    Snake nearestSnake = findTheNearestSnake(loser.getPosition());
                    if (nearestSnake != null){
                        loser.setPosition(nearestSnake.getToPosition());
                        System.out.println("Oh no! " + loser.getUserName() + " slides down to " + nearestSnake.getFromPosition());
                    } else {
                        System.out.println("No snake found for " + loser.getUserName() + " to slide down");
                    }
                }
            }

        } while (getStatus() != 2);

        // Tampilkan statistik setelah game selesai
        GameStatisticsFrame.showStatistics(this.players);
    }
}
