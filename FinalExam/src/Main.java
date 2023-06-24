import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (true) {
            while (choice != 0) {
                System.out.println("1.Воити");
                System.out.println("0.Exit");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1: {
                        System.out.print("Enter login:");
                        scanner.nextLine();
                        String login = scanner.nextLine();
                        System.out.print("Enter password:");

                        String password = scanner.nextLine();
                        int num = 0;
                        if (login.equals("Admin") && password.equals("Admin")) {
                            do {

                                Admin admin = new Admin(login, password);
                                int number = -1;
                                System.out.println("Выберите действие");
                                System.out.println("1.Добавить врача");
                                System.out.println("2.Добавить клиента");
                                System.out.println("3.Исправить врача");
                                System.out.println("4.Исправить клиентов");
                                System.out.println("5.Удалить врача");
                                System.out.println("6.Удалить клиента");
                                System.out.println("7.Список всех записи");
                                System.out.println("0.Exit");
                                number = scanner.nextInt();
                                switch (number) {
                                    case 1: {
                                        scanner.nextLine();
                                        System.out.println("Enter name:");
                                        String name = scanner.nextLine();


                                        System.out.println("Enter surname");
                                        String surname = scanner.nextLine();


                                        System.out.println("enter specialization");
                                        String specialization = scanner.nextLine();
                                        Doctor doctor = new Doctor(name, surname, specialization);
                                        hospital.addDoctor(doctor);
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Enter login:");
                                        scanner.nextLine();
                                        String login1 = scanner.nextLine();
                                        System.out.println("Enter password");
                                        String password1 = scanner.nextLine();
                                        Client client = new Client(login1, password1);
                                        hospital.addClient(client);
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Врачи:");
                                        scanner.nextLine();
                                        hospital.listDoctors();
                                        System.out.println("Введите имя нужного доктора:");
                                        String name = scanner.nextLine();
                                        hospital.editDoctor(name);
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("Клиенты:");
                                        hospital.listClients();
                                        System.out.println("Введите Login нужного Клиента:");
                                        String name = scanner.nextLine();
                                        hospital.editClient(name);
                                        break;
                                    }
                                    case 5: {
                                        System.out.println("Клиенты:");
                                        hospital.listClients();
                                        System.out.println("Введите Login нужного Клиенты которогу нужно удалить:");
                                        String lohinRemove = scanner.nextLine();
                                        hospital.removeClient(lohinRemove);
                                        break;
                                    }
                                    case 6: {
                                        System.out.println("Докторы:");
                                        hospital.listClients();
                                        System.out.println("Введите имя нужного Врача которогу нужно удалить:");
                                        String nameRemove = scanner.nextLine();
                                        hospital.removeDoctor(nameRemove);
                                        break;
                                    }
                                    case 7: {
                                        hospital.showVisits();
                                        break;
                                    }
                                    case 0:
                                        num = 1;
                                        break;

                                    default: {
                                        System.out.println("Enter between 0-4");
                                        break;
                                    }
                                }
                            } while (num == 0);
                            System.out.println("Вы вышли из системы администрирования! ");


                        } else {
                            Client client = new Client(login, password);
                            hospital.checkClient(client);

                        }
                    }
                }
            }
        }
    }
}