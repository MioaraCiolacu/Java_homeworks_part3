package com.itfactory;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FiguriGeometrice figuriGeometrice = null;
        Scanner cititor = new Scanner(System.in);
        System.out.println("Introduceti A, B sau C, unde A = triunghi, B = patrat, C = dreptunghi:");
        String figura = cititor.nextLine();
        if (figura.equalsIgnoreCase("A")) {
            System.out.println("Introduceti dimensiunile in aceasta ordine: cateta1, cateta2 si ipotenuza");
            int cateta1 = Integer.parseInt(cititor.nextLine());
            int cateta2 = Integer.parseInt(cititor.nextLine());
            int ipotenuza = Integer.parseInt(cititor.nextLine());
            figuriGeometrice = new Triunghi(cateta1, cateta2, ipotenuza);
        } else if (figura.equalsIgnoreCase("B")) {
            System.out.println("Introduceti lungimea muchiei:");
            int lungimePatrat = Integer.parseInt(cititor.nextLine());
            figuriGeometrice = new Patrat(lungimePatrat);
        } else if (figura.equalsIgnoreCase("C")) {
            System.out.println("Introduceti lungimea si latimea muchiilor:");
            int lungimeDreptunghi = Integer.parseInt(cititor.nextLine());
            int latimeDreptunghi = Integer.parseInt(cititor.nextLine());
            figuriGeometrice = new Dreptunghi(lungimeDreptunghi, latimeDreptunghi);
        }
        if (figuriGeometrice != null) {
            System.out.println("Perimetru figurii alese este: " + figuriGeometrice.calculeazaPerimetru());
        } else {
            System.out.println("Figura geometrica introdusa nu este valida.");
        }
    }
}


