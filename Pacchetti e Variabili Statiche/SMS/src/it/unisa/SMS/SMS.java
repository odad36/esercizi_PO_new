package it.unisa.SMS;

import java.util.GregorianCalendar;

public class SMS {
  private String mittente;
  private GregorianCalendar data;
  private int id;
  private String testo;
  private static int numeroMessaggi;

  public SMS(String mittente, GregorianCalendar data, String testo){
      this.mittente = mittente;
      this.data = data;
      this.testo = testo;
      this.id = numeroMessaggi++;
  }

  public GregorianCalendar getDate(){
      return this.data;
  }

  public String getSender(){
      return this.mittente;
  }
}