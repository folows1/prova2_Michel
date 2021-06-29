package br.edu.univas.main;

import br.edu.univas.prova.*;

public class App {
    public static void main(String[] args) throws Exception {
        CustomerController cc = new CustomerController();

        cc.createCustomer();

        System.out.println("Foi!");
    }
}
