package interfaces;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<Integer>> cardPayments = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Добавить новую карту");
            System.out.println("2. Добавить платёж по карте");
            System.out.println("3. Показать все платежи");
            System.out.println("4. Выход" + "\n" + "-------" + "\n");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            boolean shouldExit = switch (choice) {
                case 1 -> {
                    System.out.print("Введите номер карты: ");
                    String newCard = scanner.nextLine();

                    if (cardPayments.containsKey(newCard)) {
                        System.out.println("Эта карта уже есть в системе!");
                    } else {
                        cardPayments.put(newCard, new ArrayList<>());
                        System.out.println("Карта добавлена!");
                    }
                    yield false;
                }

                case 2 -> {
                    System.out.print("Введите номер карты: ");
                    String card = scanner.nextLine();

                    if (!cardPayments.containsKey(card)) {
                        System.out.println("Такой карты нет! Сначала добавьте её.");
                        yield false;
                    }

                    System.out.print("Введите сумму платежа: ");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    CreditCard creditCard = new CreditCard(card);
                    if (Payable.isValid(amount)) {
                        cardPayments.get(card).add(amount);
                        creditCard.pay(creditCard.getMethod(), amount);
                        System.out.println("Платёж добавлен!");
                    } else {
                        System.out.println("Ошибка: неверная сумма платежа!");
                    }
                    yield false;
                }

                case 3 -> {
                    System.out.println("\nВсе платежи:");
                    cardPayments.forEach((cardNum, payments) ->
                            System.out.printf("Карта %s: %s%n", cardNum, payments)
                    );
                    yield false;
                }

                case 4 -> {
                    System.out.println("Выход из системы...");
                    scanner.close();
                    yield true;
                }

                default -> {
                    System.out.println("Неверный выбор!");
                    yield false;
                }
            };

            if (shouldExit) break;
        }
    }
}