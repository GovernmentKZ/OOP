import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    private ArrayList<Client> clients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Visit> appointment;



    public Hospital() {
        clients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointment = new ArrayList<>();

    }

    public void addDoctor(Doctor d) {
        if (this.doctors.contains(d)) {
            System.out.println("This product exist. Add new product");
        }
        this.doctors.add(d);
        System.out.println(d.getName() + " added successfully");
    }


    public void addClient(Client c) {
        if (this.clients.contains(c)) {
            System.out.println("This product exist. Add new product");
        }
        this.clients.add(c);
        System.out.println(c.getLogin() + " added successfully");
    }

    public void listDoctors() {
        for (Doctor d : doctors) {
            System.out.println("Name: " + d.getName() + " Surname: " + d.getSurname() + " Specialization: " + d.getSpecialization());
        }
    }

    public void editDoctor(String name) {
        for (Doctor d : doctors) {
            if (name.equals(d.getName())) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter new name:");
                String name1 = scanner.nextLine();
                d.setName(name1);
                System.out.println("Enter new surname:");
                String surname1 = scanner.nextLine();
                d.setSurname(surname1);
                System.out.println("Enter new specialization:");
                String specialization1 = scanner.nextLine();
                d.setSpecialization(specialization1);
                System.out.println("Edit Успешно!");
                break;
            }
        }
    }


    public void listClients() {
        for (Client c : clients) {
            System.out.println("Login: " + c.getLogin() + "Password: " + c.getPassword());
        }
    }

    public void editClient(String login) {
        for (Client c : clients) {
            if (c.getLogin().equals(login)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter new login:");
                String login1 = scanner.nextLine();
                c.setLogin(login1);
                System.out.println("Enter new password:");
                String password1 = scanner.nextLine();
                c.setPassword(password1);
                System.out.println("Edit Успешно!");
                break;
            }
        }
    }

    public void removeDoctor(String name) {
        for (Doctor d : doctors) {
            if (d.getName().equals(name)) {
                doctors.remove(d);
                break;
            } else {
                System.out.println("Wrong name");
                break;
            }
        }
    }

    public void removeClient(String login) {
        for (Client c : clients) {
            if (c.getLogin().equals(login)) {
                clients.remove(c);
                break;
            } else {
                System.out.println("Wrong Login");
                break;
            }
        }
    }

    public void showVisits(){
        if (appointment.size() == 0){
            System.out.println("Пока нет никаких записей!");
        }
        else {
            for (Visit visit : appointment) {
                System.out.println("Клиент " + visit.getLogin() + " записался доктору " + visit.getName() + ". " + "Время: " + visit.getDay() + "." + visit.getMonth() + "." + "2023" + ", " + visit.getHours() + ":" + visit.getMinute());
            }
        }
    }

    public void checkClient(Client client) {
        Scanner scanner = new Scanner(System.in);
        for (Client c : clients) {
            if (client.getLogin().equals(c.getLogin()) && client.getPassword().equals(c.getPassword())) {
                System.out.println("Вход выполнен успешно!");
                int chislo = -1;

                System.out.println("Выберите действие");
                System.out.println("1.Записатся на прием");
                System.out.println("0.Exit");
                chislo = scanner.nextInt();
                switch (chislo) {
                    case 1: {
                        System.out.println("Enter Day:");
                        int day = scanner.nextInt();
                        System.out.println("Enter Month:");
                        int month = scanner.nextInt();
                        System.out.println("Enter Hours:");
                        int hours = scanner.nextInt();
                        System.out.println("Enter minute:");
                        int minute = scanner.nextInt();
                        System.out.println("Врачи:");
                        listDoctors();
                        System.out.println("напишите имя нужного врача по нужной облости:");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        Visit visit = new Visit(day, month, hours, minute, name, c.getLogin());
                        visit.toString();
                        for (Doctor d : doctors)
                        {
                            if (visit.getName().equals(d.getName())){
                                System.out.println("Врачь найден успешно");
                                if (appointment.size() == 0){
                                    this.appointment.add(visit);
                                    System.out.println("Успешно!");
                                    System.out.println("Вы записались доктору " + d.getName());
                                    System.out.println("На дату: " + visit.getDay() + "." + visit.getMonth() + "." + "2023" + ", " + visit.getHours() + ":" + visit.getMinute());
                                }
                                else {
                                for (Visit v: appointment){
                                    if (v.getHours() == visit.getHours() && v.getMinute() != visit.getMinute() && visit.getMinute() == 30)
                                    {
                                        this.appointment.add(visit);
                                        System.out.println("Успешно!");
                                        System.out.println("Вы записались доктору " + d.getName());
                                        System.out.println("На дату: " + visit.getDay() + "." + visit.getMonth() + "." + "2023" + ", " + visit.getHours() + ":" + visit.getMinute());
                                    }
                                    else if (v.getHours() == visit.getHours() && v.getMinute() != visit.getMinute() && visit.getMinute() == 00)
                                    {
                                        this.appointment.add(visit);
                                        System.out.println("Успешно!");
                                        System.out.println("Вы записались доктору " + d.getName());
                                        System.out.println("На дату: " + visit.getDay() + "." + visit.getMonth() + "." + "2023" + ", " + visit.getHours() + ":" + visit.getMinute());
                                    }
                                    else if (v.getHours() != visit.getHours() && v.getMinute() == visit.getMinute() && visit.getMinute() == 30)
                                    {
                                        this.appointment.add(visit);
                                        System.out.println("Успешно!");
                                        System.out.println("Вы записались доктору " + d.getName());
                                        System.out.println("На дату: " + visit.getDay() + "." + visit.getMonth() + "." + "2023" + ", " + visit.getHours() + ":" + visit.getMinute());
                                    }
                                    else if (v.getHours() != visit.getHours() && v.getMinute() == visit.getMinute() && visit.getMinute() == 00)
                                    {
                                        this.appointment.add(visit);
                                        System.out.println("Успешно!");
                                        System.out.println("Вы записались доктору " + d.getName());
                                        System.out.println("На дату: " + visit.getDay() + "." + visit.getMonth() + "." + "2023" + ", " + visit.getHours() + ":" + visit.getMinute());
                                    }
                                    else {
                                        System.out.println("Время введено не правильно. Либо 30 либо 00");
                                    }
                                }
                                }
                            }
                            else {
                                System.out.println("Имя врача не верное");
                            }
                        }
                    }
                    case 0:
                        break;
                    default: {
                        System.out.println("Enter num between 0-1:");
                        break;
                    }
                }
            } else {
                System.out.println("Login или Password не правильный!");
            }
        }
    }
}
