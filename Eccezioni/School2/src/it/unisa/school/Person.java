package it.unisa.school;

public class Person {

    final private String name;
    final private String surname;
    final private int birthYear;
    final private String userId;
    final private String password;

    public Person(String name, String surname, int birthYear, String userId, String password) {

        if (userId.indexOf(' ') != -1 || userId.length() < 5)
            throw new IllegalArgumentException("Login dell’utente con formato errato");
        if (password.indexOf(' ') != -1 || password.length() < 5)
            throw new IllegalArgumentException("Password dell’utente con formato errato");
        if (name == null || surname == null || birthYear < 1900)
            throw new IllegalArgumentException();
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword(){
        return password;
    }



    @Override
    public String toString() {
        return "Nome='" + name + '\'' +
                ", Cognome='" + surname + '\'' +
                ", Anno di nascita=" + birthYear;
    }
}
