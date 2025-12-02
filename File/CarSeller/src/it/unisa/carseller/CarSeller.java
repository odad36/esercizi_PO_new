package it.unisa.carseller;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;

public class CarSeller {
    private List<Car> cars;

    public CarSeller() {
        this.cars = new ArrayList<>();
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        this.cars = new ArrayList<>();
        Scanner in = new Scanner(file);
        while(in.hasNextLine()) {
            try {
                String brand = in.nextLine();
                String model = in.nextLine();
                int annoProduzione = Integer.parseInt(in.nextLine());
                double prezzo = Double.parseDouble((in.nextLine()));
                Car macchina = new Car(brand, model, annoProduzione, prezzo);
                cars.add(macchina);
            } catch (NoSuchElementException | NumberFormatException ex) {  //con queste riusciamo a gestire input errati oppure assenza di righe
                System.err.println("Il formato del file è errato!");
                ex.printStackTrace(); //stampa a schermo la traccia dell'eccezione
            }
        }
        in.close();
    }

    public void writeUserDataToFile(File file, boolean overwrite) throws FileNotFoundException, FileAlreadyExistsException {
        if(!overwrite){
            if (file.exists())
                throw new FileAlreadyExistsException("il file esiste");
        }
        writeUserDataToFile(file);
    }

    private void writeUserDataToFile(File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
            for (Car car : cars) {
                writer.println(car.getBrand());
                writer.println(car.getModel());
                writer.println(car.getManufacturingYear());
                writer.println(car.getPrice());
            }
        writer.close();
    }


    @SuppressWarnings("unchecked")
    public void readSerializedDataFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        try {
            this.cars = ((ArrayList<Car>) in.readObject());
            in.close();
        }
        catch(ClassNotFoundException ce){
            System.err.println("classe non trovata");
        }
        catch(IOException ioe){
            System.err.println("errore di I/O nella lettura");
        }
    }

    public void writeSerializedDataToFile(File file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        try {
            out.writeObject(cars);
            out.close();
        } catch (IOException e) {
            System.err.println("errore di I/O nella scrittura");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> returnCarByBrandAndModel(String brand, String model) {
        List<Car> suitableCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getBrand().equals(brand) && car.getModel().equals(model)) {
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }

    public List<Car> returnCarByBrandModelAndYear(String brand, String model, int manufacturingYear) {
        List<Car> suitableCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getBrand().equals(brand)
                    && car.getModel().equals(model)
                    && car.getManufacturingYear() >= manufacturingYear) {
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }

    public List<Car> returnCarByBrandAModelYearAndPrice(String brand, String model, int manufacturingYear, int minPrice, int maxPrice) {
        List<Car> suitableCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getBrand().equals(brand)
                    && car.getModel().equals(model)
                    && car.getManufacturingYear() >= manufacturingYear
                    && car.getPrice() >= minPrice
                    && car.getPrice() <= maxPrice) {
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }
}