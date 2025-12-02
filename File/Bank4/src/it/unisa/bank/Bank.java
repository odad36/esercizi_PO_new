package it.unisa.bank;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bank {

    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount bankAccount) {
        this.accounts.add(bankAccount);
    }

    public BankAccount find(int accountNumber) {
        for (BankAccount ba : this.accounts) {
            if (ba.getAccountNumber() == accountNumber)
                return ba;
        }
        return null;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void deposit(int accountNumber, double amount) {
        BankAccount account = this.find(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, double amount) {
        BankAccount account = this.find(accountNumber);
        account.withdraw(amount);
    }

    public double getBalance(int accountNumber) {
        BankAccount account = this.find(accountNumber);
        return account.getBalance();
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount fromAccount = this.find(fromAccountNumber);
        BankAccount toAccount = this.find(toAccountNumber);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        this.accounts = new ArrayList<BankAccount>();
        Scanner in = new Scanner (file);
        while(in.hasNextLine()){
            try {
                int accountNumber = Integer.parseInt(in.nextLine());
                String customerName = in.nextLine();
                double balance = Double.parseDouble(in.nextLine());
                int accountNumber2 = Integer.parseInt(in.nextLine());
                String customerName2 = in.nextLine();
                double balance2 = Double.parseDouble(in.nextLine());
                double interestRate = Double.parseDouble(in.nextLine());
                int accountNumber3 = Integer.parseInt(in.nextLine());
                String customerName3 = in.nextLine();
                double balance3 = Double.parseDouble(in.nextLine());
                BankAccount a = new BankAccount (accountNumber, customerName, balance);
                BankAccount b = new SavingAccount (customerName2, interestRate);
                BankAccount c = new BankAccount(accountNumber3, customerName3, balance3);
                this.accounts.add(a);
                this.accounts.add(b);
                this.accounts.add(c);
            }
            catch (NoSuchElementException | NumberFormatException e) {
                System.err.println("errore nel formato del file");
            }
        }
        in.close();
    }

    public void writeUserDataToFile(File file, boolean overwrite) throws FileNotFoundException, FileAlreadyExistsException {
        if(!overwrite){
            if(file.exists())
                throw new FileAlreadyExistsException("il file esiste");
            else
                writeUserDataToFile(file);
        }
        else {
            String tmpFileName = file.getParentFile().getName() + File.separator + "tmp_" + file.getName();  //costruiamo il percorso del vecchio file in una stringa
            File tmpFile = new File(tmpFileName);    //creo un file temporaneo con il percorso del vecchio file
            writeUserDataToFile(tmpFile);  //scrivo tutto nel file temporaneo
            file.delete();   //cancello il file originale
            tmpFile.renameTo(file); //rinomino il file temporaneo con quello dell'orginale
        }
    }

    private void writeUserDataToFile(File file) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(file);
        for(BankAccount b: accounts) {
            if(b instanceof SavingAccount) {
                out.println(b.getAccountNumber());
                out.println(b.getCustomerName());
                out.println(b.getBalance());
                out.println(((SavingAccount) b).getInterestRate());
            }
            else {
                out.println(b.getAccountNumber());
                out.println(b.getCustomerName());
                out.println(b.getBalance());
            }
        }
        out.close();
    }

    @SuppressWarnings("unchecked")
    public void readSerializedDataFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        this.accounts = (ArrayList<BankAccount>) in.readObject();
        in.close();
    }

    public void writeSerializedDataToFile(File file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(accounts);
        out.close();
    }
}