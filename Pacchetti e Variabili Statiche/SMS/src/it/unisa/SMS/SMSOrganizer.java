package it.unisa.SMS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SMSOrganizer {
    private final List <SMS> messaggi;

    public SMSOrganizer(){
        this.messaggi = new ArrayList<SMS>();
    }

    public void addSMSToOrganizer(SMS messaggio){
        messaggi.add(messaggio);
    }

    public List<SMS> getListByDate() {
        this.messaggi.sort(new Comparator<>() {
            @Override
            public int compare(SMS sms1, SMS sms2) {
                return sms1.getDate().compareTo(sms2.getDate());
            }
        });
        return this.messaggi;
    }

    public List<SMS> getListBySender(){
        this.messaggi.sort(new Comparator<>() {
            @Override
            public int compare(SMS sms1, SMS sms2) {
                return sms1.getSender().compareTo(sms2.getSender());
            }
        });
        return this.messaggi;
    }
}

