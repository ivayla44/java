package game;
import options_interfaces.*;
import dialogue.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void playGame(DialogueTree tree, Player player) throws Exception {
        DialogueStep current_step = tree.getStep();
        while(current_step != null) {
            System.out.println(current_step.getStepID());

            System.out.println(current_step.getNpcCue());

            if(current_step.getPlayerAnswers().isEmpty()) {
                if(current_step.getNextStep() != null) current_step = current_step.getNextStep();
                else {
                    System.out.println("Game ended.");
                    return;
                }
            }
            else {
                for(DialogueOption answer : current_step.getPlayerAnswers()) {
                    System.out.println(current_step.getPlayerAnswers().indexOf(answer));
                    System.out.println(answer.getPlayerCue());
                    if(answer.getModifiers() != null) {
                        for(Object modifier : answer.getModifiers()) {
                            if(modifier instanceof IOptional) {
                                ((IOptional) modifier).test(player);
                            } else if (modifier instanceof IRequirement) {
                                ((IRequirement) modifier).take(player);
                            }
                            else {
                                ((IReward) modifier).reward(player);
                            }
                        }
                    }
                    while(true) {
                        for(DialogueOption option : current_step.getPlayerAnswers()) {
                            System.out.println(option.getPlayerCue());
                        }
                        System.out.println("Enter what number option you would like to choose:");
                        Scanner in = new Scanner(System.in);
                        int choice = in.nextInt();
                        if (choice < 0 || choice > current_step.getPlayerAnswers().size()) {
                            System.out.println("Invalid option. Try again.");
                        }
                        else {
                            for (DialogueOption option : current_step.getPlayerAnswers()) {
                                if (choice == current_step.getPlayerAnswers().indexOf(option)) {
                                    if(option.getNextStep() != null) current_step = option.getNextStep();
                                    else {
                                        System.out.println("Game ended.");
                                        return;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<String> p1inv = new ArrayList<>();
        p1inv.add("Slingshot");
        p1inv.add("Amo");
        p1inv.add("Cheese");
        p1inv.add("Small bag of gold");
        Player player1 = new Player(300, 200, 11, 150, p1inv);

        DialogueOption step1_option1 = new DialogueOption("I want to buy armor.", null, null);
        DialogueOption step1_option2 = new DialogueOption("I have slain the dragon.", null, new ArrayList<>());
        DialogueOption step1_option3 = new DialogueOption("I want to speak with the king.", null, new ArrayList<>());
        List<DialogueOption> step1_answers = new ArrayList<>();

        DialogueOption step2_option1 = new DialogueOption("Give me Light armor.", null, new ArrayList<>());
        DialogueOption step2_option2 = new DialogueOption("Give me Light armor and don't cheat.", null, new ArrayList<>());
        List<DialogueOption> step2_answers = new ArrayList<>();

        IReward rew1 = a -> {
            System.out.println("Big bag of gold awarded.");
            a.addToInventory("Big bag of gold");
            a.setGOLD(a.getGOLD() + 100);
        };
        IRequirement req1 = a -> {
            System.out.println("Dragon head required.");
            if(a.getInventory().contains("Dragon head")) {
                rew1.reward(a);
            }
            else {
                System.out.println("Come back when you have the dragon head.");
            }
        };
        step1_option2.modify(req1);

        IOptional opt1 = a -> a.getCHA() > 10;
        step1_option3.modify(opt1);

        IOptional opt2 = a -> a.getCHA() < 5;
        IReward rew2 = a -> {
            System.out.println("Light armor acquired.");
            a.addToInventory("Light armor");
            a.setSTR(a.getSTR() + 35);
        };
        IRequirement req2 = a -> {
            if (opt2.test(a)) {
                System.out.println("Medium bag of gold required.");
                if (a.getInventory().contains("Medium bag of gold.")) {
                    rew2.reward(a);
                } else {
                    System.out.println("Come back when you have a medium bag of gold.");
                }
            }
        };
        step2_option1.modify(req2);

        IOptional opt3 = a -> a.getCHA() >= 5;
        IRequirement req3 = a -> {
            if(opt3.test(a)) {
                System.out.println("Small bag of gold required.");
                if (a.getInventory().contains("Small bag of gold.")) {
                    rew2.reward(a);
                } else {
                    System.out.println("Come back when you have a small bag of gold.");
                }
            }
        };
        step2_option2.modify(req3);

        step2_answers.add(step2_option1);
        step2_answers.add(step2_option2);

        DialogueStep step2 = new DialogueStep("2", "I have some armors.", step2_answers, null);

        DialogueStep option1_step = new DialogueStep("1.1", "I want to buy armor.", null, step2);

        step1_option1.setNextStep(option1_step);
        step1_answers.add(step1_option1);
        step1_answers.add(step1_option2);
        step1_answers.add(step1_option3);

        DialogueStep step1 = new DialogueStep("1", "Welcome to Fantasytown! How can I help you?", step1_answers, null);

        DialogueTree tree = new DialogueTree(step1);

        playGame(tree, player1);
    }
}