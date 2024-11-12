abstract class BankTransaction {
    // Metody abstrakcyjne, które muszą być zaimplementowane w klasie dziedziczącej
    abstract void insertCard();
    abstract void enterPIN();
    abstract void enterAmount();

    // Metody, które są zawsze wykonywane przez bank i mają gotową implementację
    public void acceptRequest() {
        System.out.println("Bank: Przyjęcie prośby o wypłatę.");
    }

    public void checkAccountBalance() {
        System.out.println("Bank: Sprawdzanie stanu konta.");
    }

    public void confirmWithdrawal() {
        System.out.println("Bank: Potwierdzenie możliwości wypłaty.");
    }

    // Metody abstrakcyjne dla pozostałych kroków
    abstract void dispenseCash();
    abstract void thankCustomer();

    // Metoda, która wykonuje pełną transakcję krok po kroku
    public final void performTransaction() {
        insertCard();
        enterPIN();
        enterAmount();
        acceptRequest();
        checkAccountBalance();
        confirmWithdrawal();
        dispenseCash();
        thankCustomer();
    }
}

class ATMTransaction extends BankTransaction {
    @Override
    void insertCard() {
        System.out.println("Bankomat: Proszę wprowadzić kartę.");
    }

    @Override
    void enterPIN() {
        System.out.println("Bankomat: Proszę wprowadzić kod PIN.");
    }

    @Override
    void enterAmount() {
        System.out.println("Bankomat: Proszę wprowadzić kwotę do wypłaty.");
    }

    @Override
    void dispenseCash() {
        System.out.println("Bankomat: Wypłacanie gotówki.");
    }

    @Override
    void thankCustomer() {
        System.out.println("Bankomat: Dziękujemy za skorzystanie z naszych usług.");
    }
}

class Application {
    public static void main(String[] args) {
        // Tworzymy obiekt ATMTransaction i wykonujemy pełną transakcję
        ATMTransaction transaction = new ATMTransaction();
        transaction.performTransaction();
    }
}