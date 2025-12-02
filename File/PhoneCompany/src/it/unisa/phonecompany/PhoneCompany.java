package it.unisa.phonecompany;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PhoneCompany {
    List<User> users;

    private final double minutePrice;
    private final double smsPrice;
    private final double gbPrice;

    public PhoneCompany(double minutePrice, double smsPrice, double gbPrice) {
        this.users = new ArrayList<>();
        this.minutePrice = minutePrice;
        this.smsPrice = smsPrice;
        this.gbPrice = gbPrice;
    }

    public List<User> getUsers() {
        return users;
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException { //nella throw list va inserito ciò che il metodo non gestisce internamente con le catch
        this.users = new ArrayList<User>();
        Scanner in = new Scanner(file);
        while(in.hasNextLine()) {
            try {
                int codice = Integer.parseInt(in.nextLine());
                String nome = in.nextLine();
                String cognome = in.nextLine();
                int minuti_consumati = Integer.parseInt(in.nextLine());
                int sms_inviati = Integer.parseInt(in.nextLine());
                double mb_consumati = Double.parseDouble(in.nextLine());
                User u = new User (codice, nome, cognome);
                u.setUsedMinutes(minuti_consumati);
                u.setUsedSMS(sms_inviati);
                u.setUsedMB(mb_consumati);
                users.add(u);
            }
            catch(NoSuchElementException | NumberFormatException e){
                System.err.println("Formato del file errato");
            }
        }
        in.close();
    }

    public void writeUserDataToFile(File file, boolean overwrite) throws FileNotFoundException, FileAlreadyExistsException {
        if(!overwrite) {
            if (file.exists())
                throw new FileAlreadyExistsException("il file esiste già");
            else
                writeUserDataToFile(file);
        }
        else{
            String tmpFileName = file.getParentFile().getName() + File.separator + "tmp_" + file.getName();
            File tmpFile = new File(tmpFileName);
            writeUserDataToFile(tmpFile);
            file.delete();
            tmpFile.renameTo(file);
        }
    }

    private void writeUserDataToFile(File file) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(file);
        for(User u: users) {
            out.println(u.getCode());
            out.println(u.getName());
            out.println(u.getLastName());
            out.println(u.getUsedMinutes());
            out.println(u.getUsedSMS());
            out.println(u.getUsedMB());
        }
        out.close();
    }

    @SuppressWarnings("unchecked")
    public void readSerializedDataFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream (file));
        this.users = (ArrayList<User>) in.readObject();
        in.close();
    }

    public void writeSerializedDataToFile(File file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream((new FileOutputStream(file)));
        out.writeObject(users);
        out.close();
    }

    public User findUserByCode(int code) {
        for (User user : this.users) {
            if (user.getCode() == code) {
                return user;
            }
        }
        return null;
    }

    public void computeUserCost(User user) {
        int usedMinutes = user.getUsedMinutes();
        int usedSMS = user.getUsedSMS();
        double usedMB = user.getUsedMB();
        user.setTotalCost(usedMinutes * minutePrice + usedSMS * smsPrice + usedMB * gbPrice / 1000);
    }
}
