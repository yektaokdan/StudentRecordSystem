package proje;
import java.util.*;
public class Main {
    public static class Node {
        int roll;
        String Name;
        String Dept;
        int Marks;
        Node next;
    }

    static Node head = new Node();

    static boolean check(int x) {
        if (head == null) {
            return false;
        }
        Node t = new Node();
        t = head;

        while (t != null) {
            if (t.roll == x) {
                return true;
            }
            t = t.next;
        }
        return false;
    }

    static void insertRecord(int roll, String Name, String Dept, int Marks) {
        if (check(roll)) {
            System.out.println("!! Bu bilgilere sahip ogrenci hali hazirda mevcut !!");
            return;
        }

        // Yeni node oluşturup ogrenci ekleme
        Node t = new Node();
        t.roll = roll;
        t.Name = Name;
        t.Dept = Dept;
        t.Marks = Marks;
        t.next = null;

        if (head == null
                || (head.roll >= t.roll)) {
            t.next = head;
            head = t;
        } else {
            Node c = head;
            while (c.next != null
                    && c.next.roll < t.roll) {
                c = c.next;
            }
            t.next = c.next;
            c.next = t;
        }

        System.out.println("Kayit basariyla eklendi.");
    }


    public static void Search_Record(int roll) {
        // eger head boş ise
        if (head == null) {
            System.out.println("Kayit yok.");
            return;
        }

        // Kalan durumlar
        else {
            Node p = head;
            while (p != null) {
                if (p.roll == roll) {
                    System.out.println("Ogrenci numara: ");
                    System.out.println(p.roll+"\n");

                    System.out.println("Isim: ");
                    System.out.println(p.Name+"\n");

                    System.out.println("Bolum: ");
                    System.out.println(p.Dept+"\n");

                    System.out.println("Genel not: ");
                    System.out.println(p.Marks+"\n");
                    return;
                }
                p = p.next;
            }

            if (p == null) {
                System.out.println("Kayit bulunamadi.");
            }

        }
    }

    public static void Show_Record() {
        Node p = head;
        if (p == null) {
            System.out.println("Kayit bulunamadi.");
        } else {
            System.out.println("Kayit icerigi..");


            // p nin boş olmaması durumu
            while (p != null) {
                System.out.println(" Numara: "+p.roll);
                System.out.println(" Isim: "+p.Name);
                System.out.println(" Bolum: "+p.Dept);
                System.out.println(" Not: "+p.Marks);
                p = p.next;
            }
        }
    }

    public static void Delete_Record(int roll) {
        Node t = head;
        Node p = null;

        // Silme işlemi baslangici
        if (t != null
                && t.roll == roll) {
            head = t.next;
            t = null;

            System.out.println("Kayit basariyla silindi..");
            System.exit(1);
        }

        // baslangic isleminden sonra gelen islem
        while (t != null && t.roll != roll) {
            p = t;
            t = t.next;
        }
        if (t == null) {
            System.out.println("Kayit bulunamadi..");

            p.next = t.next;

            t = null;
            System.out.println("Kayit silindi..");


        }


    }



    public static void main(String[] args) {

        head = null;
        String Name, Course;
        int Roll, Marks;

        // Input alınan menu kısmı
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("---- OGRENCI BILGI SISTEMINE HOSGELDINIZ ----\n[1] OGRENCI EKLEME \n[2] OGRENCI ARAMA \n[3] KAYIT GOSTERME\n[4] KAYIT SILME \n Lutfen bir secim yapiniz..");
            int secim=scanner.nextInt();


            //Input alıyoruz


            if (secim == 1) {
                Scanner scanner1=new Scanner(System.in);
                System.out.println("Ogrenci adi giriniz.");
                String ad=scanner1.next();
                Name=ad;

                Scanner scanner2=new Scanner(System.in);
                System.out.println("Ogrenci numarasi giriniz");
                int num=scanner2.nextInt();
                Roll=num;

                Scanner scanner3=new Scanner(System.in);
                System.out.println("Ogrenci bolumu giriniz.");
                String bolum=scanner3.next();
                Course=bolum;

                Scanner scanner4=new Scanner(System.in);
               System.out.println("Ogrencinin toplam notunu girin\n");
               int notToplam=scanner4.nextInt();
                Marks=notToplam;
                insertRecord(Roll, Name, Course, Marks);
            }

            else if (secim == 2) {
                Scanner scanner5=new Scanner(System.in);
                System.out.println("Aramak istediginiz ogrencinin numarasini giriniz..");
                int arama=scanner5.nextInt();
                Roll=arama;
                Search_Record(Roll);
            }
            else if (secim == 3) {
                Show_Record();
            }
            else if (secim == 4) {
                Scanner scanner6=new Scanner(System.in);
                System.out.println(" Silmek istediginiz ogrenci numarasini giriniz.");
                int ogrenciNumara=scanner6.nextInt();
                Roll=ogrenciNumara;
                Delete_Record(Roll);
            }


            else {
                System.out.println("Hatali giris yaptiniz lutfen tekrar deneyin..\n");
            }


        }
    }
}
