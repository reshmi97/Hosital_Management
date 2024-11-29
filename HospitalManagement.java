package HospitalManagementProject;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Scanner;

class Patient{
    int idCounter=1;
    int id;
    String name;
    int age;
    char gender;
    public Patient(String name,int age,char gender){
        this.id=idCounter++;
        this.age=age;
        this.name=name;
        this.gender=gender;
    }
    public String toString(){
        return "Id "+id+" Name "+name+" Gender "+gender;
    }
    public int getId(){
        return id;
    }
}
class Doctor{
    int idCounter=1;
    int id;
    String name;
    String speciality;
    public Doctor(String name,String speciality){
        this.id=idCounter++;
        this.name=name;
        this.speciality=speciality;
    }
    public int getId(){
        return id;
    }
    public String getSpeciality(){
        return speciality;
    }
    public String toString(){
        return "Name "+name+" Id "+id+" Speciality "+speciality;
    }
}
class Appointment{
    Patient patient ;
    Doctor doctor;
    String date;
    public Appointment(Patient patient,Doctor doctor,String date){
        this.patient=patient;
        this.doctor=doctor;
        this.date=date;
    }
    public String toString(){
        return "Appointme: [Patient "+patient+" Doctor "+doctor+"Date"+date+"]";
    }
}

public class HospitalManagement {
    private static ArrayList<Patient> patients =new ArrayList<>();
    private static ArrayList<Doctor> doctors =new ArrayList<>();
    private static ArrayList<Appointment> appointments =new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        do {
        System.out.println("Hospital Management System");
        System.out.println("1. Add Patient");
        System.out.println("2. Add Doctor");
        System.out.println("3. Schedule Appointment");
        System.out.println("4. View Patients");
        System.out.println("5. View Doctors");
        System.out.println("6. View Appointments");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
        choice=sc.nextInt();

            switch (choice) {
                case 1:
                    addPatient(sc);
                    break;
                case 2:
                    addDoctor(sc);
                    break;
                case 3:
                    scheduleAppointment(sc);
                    break;
                case 4:
                    viewPatients();
                    break;
                case 5:
                    viewDoctors();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please Try again.");
            }
        }while(choice!=0);

    }
    public static void addPatient(Scanner sc){
        System.out.println("Enter Patient Name: ");
        String name=sc.next();
        System.out.println("Enter Patient age: ");
        int age=sc.nextInt();
        System.out.println("Enter Patient Gender: ");
        char gen=sc.next().charAt(0);
        Patient p=new Patient(name,age,gen);
        patients.add(p);

    }
    public static void addDoctor(Scanner sc){
        System.out.println("Enter Doctor Name: ");
        String name=sc.next();
        System.out.println("Enter Speciality: ");
        String speciality=sc.next();
        Doctor p=new Doctor(name,speciality);
        doctors.add(p);
    }
    public static void scheduleAppointment(Scanner sc){
        System.out.println("Enter Patient Id: ");
        int patientId=sc.nextInt();
        System.out.println("Enter Doctor Id: ");
        int docId =sc.nextInt();
        System.out.println("Enter Date(YYYY-MM-DD)");
        String date=sc.next();
        Patient p=findPatientById(patientId);
        Doctor d=findDoctorById(docId);
        if(p!=null && d!=null){
            Appointment app=new Appointment(p,d,date);
            appointments.add(app);
            System.out.println("Appointment successfully done!");
        }else{
            System.out.println("Invalid Patient or Doctor Id!");
        }
    }
    public  static Patient findPatientById(int id){
        for(Patient p:patients){
            if(p.getId()==id) {
                return p;
            }
        }
        return null;
    }
    public  static Doctor findDoctorById(int id){
        for(Doctor d:doctors){
            if(d.getId()==id) {
                return d;
            }
        }
        return null;
    }
    public  static void viewPatients(){
        System.out.println("List of Patients: ");
        for(Patient p:patients){
            System.out.println(p);
        }
    }
    public static  void viewDoctors(){
        System.out.println("List of Doctors: ");
        for(Doctor d:doctors){
            System.out.println(d);
        }
    }
    public  static void viewAppointments(){
        System.out.println("List of Appointments: ");
        for(Appointment app:appointments){
            System.out.println(app);
        }
    }
}

