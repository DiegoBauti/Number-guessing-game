import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int numDifficulty;
        System.out.printf("Welcome to the Number Guessing Game!\nI'm thinking of a number between 1 and 100.\n" +
                "Please select the difficulty level:\n1. Easy (10 chances)\n2. Medium (5 chances)\n3. Hard (3 chances)\n" +
                "\nEnter your choice: ");

        if (scan.hasNextInt()){
            numDifficulty=scan.nextInt();
            GameRepository repository=new GameRepository();
            GameService gameService;
            switch (numDifficulty){
                case 1->{
                    gameService=new GameService(new Game(Difficulty.EASY),repository);
                    gameService.gameExecution(scan);
                }
                case 2->{
                    gameService=new GameService(new Game(Difficulty.MEDIUM),repository);
                    gameService.gameExecution(scan);
                }
                case 3->{
                    gameService=new GameService(new Game(Difficulty.HARD),repository);
                    gameService.gameExecution(scan);
                }
                default-> System.out.println("\nNo difficulty level was selected");
            }
        }else {
            System.out.println("No number has been entered");
        }
    }
}