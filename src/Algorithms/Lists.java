package Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lists {
    private final List<String> tasks;
    private final Scanner scanner;
    private boolean isRunning = true;

    public Lists() {
        this.scanner = new Scanner(System.in);
        this.tasks = new ArrayList<>();

    }


    public void addTask() {
        System.out.print("Type the task: ");
        String task = scanner.nextLine();
        if (task == null || task.trim().isEmpty()) {
            System.out.println("Empty task");
            return;
        }
        tasks.add(task);
    }

    public void removeTask() {
        System.out.print("Type the task: ");
        String task = scanner.nextLine();
        if (!tasks.remove(task)) {
            System.out.println("\nNo task");
        }
    }

    public void removeTaskAt() {
        System.out.print("Type the index: ");
        try {
            int i = Integer.parseInt(scanner.nextLine());
            if (i < 1 || i > tasks.size()) {
                System.out.println("No task");
                return;
            }
            tasks.remove(i - 1);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
        }
    }

    public void run() {
        while (isRunning) {
            printMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> addTask();
                case "2" -> removeTask();
                case "3" -> removeTaskAt();
                case "4" -> printTasks();
                case "5" -> isRunning = false;
                default -> System.out.println("No command");

            }

        }

    }

    private void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available");
            return;
        }
        System.out.println("\nCurrent tasks:");
        int i = 1;
        for (String task : tasks) {
            System.out.println(i++ + ": " + task);
        }
    }

    private void printMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("Type the number: ");
        System.out.println("1. Add the task");
        System.out.println("2. Remove the task");
        System.out.println("3. Remove the task at index");
        System.out.println("4. Print the tasks");
        System.out.println("5. Exit");
        System.out.print("> ");
    }


    public static void main(String[] args) {
        Lists lst = new Lists();
        lst.run();
    }

}
