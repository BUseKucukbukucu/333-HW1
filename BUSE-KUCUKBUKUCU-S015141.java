import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main{



    public static int searchLevel=0;
    public static int whooseTurn=0;
    public static int win=0;
    public static String[][] game = new String[6][7];
    public static final int searchLimit=10;
    public static int remainMoves=42;
    // int b;
    // shift+0

    public static void main (String [] args){
        searchLevel=takeSearchLevel();
        System.out.println("Welcome to Connect4 Game, here is print of game. You are going to do first move !");
        String[][] connectFourGame=createGame(game);

        int moveColumn= takeMove(1);
        if(check(moveColumn,1)==0){
            connectFourGame=updateGame(1,connectFourGame);
            printGame(connectFourGame);
            remainMoves--;
            win=0;
            }

        else{
            win=-1;
            check(moveColumn,1);

        }

        playGame(connectFourGame,win,-1);


        //String[][] startofGame=createGame(game);

        //playGame(startofGame,win,whooseTurn);
    }


    public static String[][] createGame(String[][] game) {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                game[i][j] = "#";
                System.out.print(game[i][j]);
            }
            System.out.println();
        }
        return game;

    }

    public static int check(int input, int winTurn) {
        int winCheck=0;
        if (input == -2 && winTurn == -1) {
            System.out.println("Computer losT the game by illegal move. The winner is user, congratulations!");
            winCheck=1;
        } else if (input == -2 && winTurn == 1) {
            System.out.println("User losT the game by illegal move. The winner is computer, congratulations!");
            winCheck=-1;
        }
        return winCheck;
    }






    public static void printGame(String[][] printGame){
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                System.out.print(game[i][j]);
            }
            System.out.println();
        }

    }



    public static int takeMove(int whoseTurn) {

        System.out.println("Its your turn. Pick a move between 1 and 7:");
        Scanner scnr = new Scanner(System.in);
        int inp = scnr.nextInt();

        //moves user=1, computer=-1,illegal=-2, beforeStart=0;

        if (inp > 7 || inp < 1) {
            System.out.println("Input is out of bound, game is losted !");
            whooseTurn = -2;

            //for illegal moves


        }
        return inp;
    }


    public static void playGame(String[][] ourGame, int win, int turn){


              while(win==0 && remainMoves!=0) {
                  ourGame = updateGame(turn, ourGame);
                  printGame(ourGame);
                  remainMoves--;
                  if(remainMoves%2==0){
                      turn=1;}
                     else
                      turn=-1;
                  }
              }



    public static String[][] updateGame(int whooseMove1, String[][] game1){
        int b=evaluation();

        int a=dfs(b);

        if (whooseMove1==-1){
            System.out.println("Its computer move-->"+ a);
            game1= computerMove(a);
        }

        else if (whooseMove1==1){
            game1= userMove();
        }
        return game1;
    }

    public static String[][] computerMove(int chosenMove){
        for (int i = 6; i <= 0; i--) {
            if (game[i][chosenMove-1] == "#") {
                game[i][chosenMove-1] = "X";}

            }
    return game;}


    public static int dfs(int a){
        int computerMove=1;
        return computerMove;
    }

    public static String[][] userMove() {
        int chosedMove=takeMove(1);
        if(chosedMove>0&&chosedMove<8){
            int j = chosedMove-1;
        for (int i = 6; i < 0; i--) {
            if (game[i][j] == "#") {
                game[i][j] = "O";
                break;
            }
        }}
        else{
            check(1,-2);

        }
        return game;
    }

    public static int takeSearchLevel() {

        System.out.println("Enter a search level between 1 and " + searchLimit+":");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(searchLimit + 1);

        if (a > searchLimit || a<1 ){
            do {
                System.out.println("Invalid input! Enter a search level between 01 and " + searchLimit);
                a = scanner.nextInt(searchLimit + 1);
            }
            while (a < searchLimit);


        }
        return a;
    }


    public static int evaluation(){
        ArrayList arrayList=new ArrayList<>();
        arrayList.add(diagonalCheck());
        arrayList.add(horizontalCheck());
        arrayList.add(verticalCheck());


        Integer maxScore= (Integer) Collections.max(arrayList);
        return maxScore;

    }

    public static int diagonalCheck(){
        int score1=0;
        return score1;
    }

    public static int horizontalCheck(){
        int score2=0;
        return score2;

    }
    public static int verticalCheck(){
         int score3=0;
         return score3;
    }
}
