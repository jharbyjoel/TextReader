import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {


    public static void main(String[] args) throws Exception {
        yourInfoHeader();


        System.out.println();

        System.out.println();
        System.out.println("======================================================");
        System.out.println("Data.txt output");
        System.out.println("======================================================");

        try {
            BufferedReader br = new BufferedReader(new FileReader("./data/data.txt"));
            String line;

            String strCurrentLine;

            while ((strCurrentLine = br.readLine()) != null) {
                System.out.println(strCurrentLine);
            }//end while
        } catch (IOException e) {

            e.printStackTrace();
        }

        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Human> humans = new ArrayList<>();
        ArrayList<Fruit> fruits = new ArrayList<>();
        ArrayList<Bowl> bowls = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("./data/data.txt"));
            String line;

            String strCurrentLine;

            while ((strCurrentLine = br.readLine()) != null) {
                String[] tokens = strCurrentLine.split(",");
                if (tokens[0].equals("Car")) {
                    cars.add(new Car(tokens[1], tokens[2], tokens[3]));
                } else if (tokens[0].equals("Human")) {
                    if (tokens.length <= 2) {
                        humans.add(new Human(tokens[1]));
                    } else {
                        Car c = new Car(tokens[4], tokens[5], tokens[6]);
                        humans.add(new Human(c, tokens[1]));
                        cars.add(c);
                    }
                } else if (tokens[0].equals("Fruit")) {
                    fruits.add(new Fruit(tokens[1], tokens[2]));


                } else if (tokens[0].equals("Bowl")) {
                    if (tokens.length <= 3) {
                        bowls.add(new Bowl(null, tokens[1], tokens[2]));

                    } else {
                        ArrayList<Fruit> fruitArray = new ArrayList<>();
                        for(int i = 5; i < tokens.length; i+=3){
                            Fruit bowlFruit1 = new Fruit(tokens[i],tokens[i+1]);
                            fruitArray.add(bowlFruit1);


                        }
                        bowls.add(new Bowl(fruitArray, tokens[1],tokens[2]));


                    }

                }


            }


        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println();
        System.out.println("================================================");
        System.out.println("Car List");
        System.out.println("================================================");

        for (Car currentcar : cars) {
            currentcar.displayInfo();


        }
        System.out.println();
        System.out.println("================================================");
        System.out.println("Human List");
        System.out.println("================================================");

        for (Human currentHuman : humans) {
            currentHuman.displayInfo();


        }
        System.out.println();
        System.out.println("==================================================");
        System.out.println("Fruit List");
        System.out.println("==================================================");
        for (Fruit currentFruits : fruits) {
            currentFruits.displayInfo();
        }
        System.out.println();
        System.out.println("==================================================");
        System.out.println("Bowl List");
        System.out.println("==================================================");
        for (Bowl currentBowl : bowls) {
            currentBowl.displayInfo();



        }
        System.out.println();
        System.out.println("==================================================");
        System.out.println("Youngest Human Without Car");
        System.out.println("==================================================");
        findYoungestHumanWithoutCar(humans).displayInfo();

        System.out.println();
        System.out.println("==================================================");
        System.out.println("Oldest Human with Car");
        System.out.println("==================================================");
        findOldestHumanWithoutCar(humans).displayInfo();

        System.out.println();
        System.out.println("==================================================");
        System.out.println("Bowl with the most fruit by weight");
        System.out.println("==================================================");
        bowlWithMostFruitWeight(bowls).displayInfo();
    }

    public static Human findYoungestHumanWithoutCar(ArrayList<Human>humans){
        int minAge = humans.get(1).getAge();
        int location = 0;
        int setLocation = 0;
        for(Human humanSearch : humans){
            if(humanSearch.getCar() == null){
                if (humanSearch.getAge() < minAge ){
                    minAge = humanSearch.getAge();
                     setLocation = location;
                }

            }
           location++;


        }
        return humans.get(setLocation);
    }
    public static Human findOldestHumanWithoutCar(ArrayList<Human>humans){
        int maxAge = humans.get(1).getAge();
        int location = 0;
        int setLocation = 0;
        for(Human humanSearch : humans){
            if(humanSearch.getCar() != null){
                if (humanSearch.getAge() > maxAge){
                    maxAge = humanSearch.getAge();
                    setLocation = location;
                }

            }
            location++;


        }
        return humans.get(setLocation);
    }
    public static Bowl bowlWithMostFruitWeight(ArrayList<Bowl>bowls){
        int bowlWithMostWeight = 0;
        int location = 0;
        int setLocation = 0;
        for(Object searchBowl : bowls) {
            if(((Bowl)searchBowl).getFruits() != null) {
                int addWeight = 0;
                for(Object fruitSearch : ((Bowl)searchBowl).getFruits()) {
                    addWeight += ((Fruit)fruitSearch).getWeight();
                    if(addWeight > bowlWithMostWeight) {
                        bowlWithMostWeight += ((Fruit)fruitSearch).getWeight();
                        setLocation = location;
                    }
                }
            }
            location++;
        }
        return bowls.get(setLocation);
    }


    public static void yourInfoHeader(){

        System.out.println("=================================================");
        System.out.println("PROGRAMMER: " + "Jharby Saravia");
        System.out.println("PANTHER ID: " + "6138385");
        System.out.println();
        System.out.println("CLASS: \t\t COP2210 ");
        System.out.println("SECTION: \t " + "U02");
        System.out.println("CLASSTIME: \t " + "TH/THU 5:00-7:40 PM");
        System.out.println();
        System.out.println("Assignment: " + "Lab 10");
        System.out.println();
        System.out.println("CERTIFICATION: \nI understand FIU's academic policies, and I certify");
        System.out.println("that this work is my own and that none of it is the");
        System.out.println("work of any other person.");
        System.out.println("=================================================");
        System.out.println();

    }


}
