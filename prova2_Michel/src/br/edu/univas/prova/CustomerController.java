package br.edu.univas.prova;

import java.util.Scanner;

import br.edu.univas.exception.PaymentMNAllowedException;
import br.edu.univas.intf.*;

public class CustomerController {
    public Customer createCustomer() throws PaymentMNAllowedException {
        Customer c = new Customer();
        Scanner l = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        c.setName(l.nextLine());
        System.out.println("Digite o ID ( ? )");
        c.setId(l.nextLong());
        l.nextLine();
        System.out.println("Digite o CPF");
        c.setCpf(l.nextLine());
        System.out.println("Digite o número correspondente ao meio de pagamento");
        System.out.println("1 - AccountDebit / 2 - BankSlip / 3 - CreditCard / 4 - Pix");
        int op = l.nextInt();
        l.nextLine();
        if (op >= 1 && op <= 4) {
            PaymentMethod pm = null;
            if (op == 1) {
                pm = new AccountDebit();
            } else if (op == 2) {
                pm = new BankSlip();
            } else if (op == 3) {
                pm = new CreditCard();
            } else if (op == 4) {
                pm = new Pix();
            }
            c.setPaymentMethod(pm);

        } else {
            l.close();
            throw new PaymentMNAllowedException("Método de Pagamento Inválido!");
        }
        l.close();
        return c;
    }
}
