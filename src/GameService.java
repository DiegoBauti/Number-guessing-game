import java.util.Scanner;
import java.util.Map;

public class GameService {
    private Game game;
    private final GameRepository repository;
    private Map<Difficulty,Integer> record;

    public GameService(Game game,GameRepository repository){
        this.game=game;
        this.repository=repository;
        this.record=repository.loadRecord();
    }

    public void gameExecution(Scanner scanner){
        Difficulty difficulty=game.getDifficulty();
        long timeStart=System.currentTimeMillis();
        String decisition="y";
        int attempts=1;

        System.out.printf("\nGreat! You have selected the %s difficulty level.\nLet's start the game!\n",difficulty.name().toLowerCase());

        while (attempts<=difficulty.getTries() && decisition.equalsIgnoreCase("y")){

            int numIntent=readGuess(scanner);

            if(numIntent==game.getNumRandom()){
                int time= (int) ((System.currentTimeMillis()-timeStart)/1000);
                System.out.printf("\nCongratulations! You guessed the correct number in %d attempts.",attempts);
                System.out.printf("\nYou took %d seg.",time);

                int puntajeMax=record.get(difficulty);
                if(attempts <puntajeMax){
                    System.out.printf("\nNew record! Previous best: %d attempts", record.get(difficulty));
                    record.put(difficulty,attempts);
                    repository.writeRecord(record);
                }
                return;
            }

            approachAdvice(numIntent);
            System.out.printf("\nRemaining attempts: %d",difficulty.getTries()-attempts);


            if (attempts<difficulty.getTries()){
                do{
                    System.out.print("\nDo you want to continue playing? (y/n) :");
                    decisition=scanner.next();
                }while (!decisition.equalsIgnoreCase("y") && !decisition.equalsIgnoreCase("n"));
            }else {
                System.out.println("\n\nHe ran out of attempts!.");
            }

            attempts ++;
        }
        scanner.close();
    }

    private int readGuess(Scanner scanner){
        while (true) {
            System.out.print("\nEnter your guess: ");
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("Please enter a valid number.");
            scanner.next();
        }
    }

    private void approachAdvice(int num){
        if (num>game.getNumRandom()) System.out.printf("Incorrect! The number is less than %d.",num);
        else System.out.printf("Incorrect! The number is greater than %d.",num);
    }
}
