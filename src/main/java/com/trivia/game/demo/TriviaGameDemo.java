package com.trivia.game.demo;


import com.trivia.game.engine.TriviaAdmin;
import com.trivia.game.engine.TriviaGame;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class TriviaGameDemo {
    public static void main(String[] args) {
        log.info("Game is loading up...");
        Scanner scanner = new Scanner(System.in);
        boolean gameMenuRunning = true;
        do {
            System.out.println("Enter [START] to start the game or [EXIT] to quit...");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("START")) {
                new TriviaGame().startGame();
            } else if (response.equalsIgnoreCase("ADMIN")) {
                new TriviaAdmin().start();
            } else if (response.equalsIgnoreCase("EXIT")) {
                System.out.println("Bye, bye!");
                gameMenuRunning = false;
            } else {
                System.out.println("Enter [START] to start the game or [EXIT] to quit...");
            }

        } while (gameMenuRunning);
        log.info("Game shutdown...");

    }
}
