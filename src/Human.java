
    public class Human {
        private int age;
        private Car car;

        public Human(String age){
            this.age = Integer.valueOf(age);

        }
        public Human(Car car, String age){
            this.age = Integer.parseInt(age);
            this.car = car;

        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Car getCar() {
            return car;
        }

        public void setCar(Car car) {
            this.car = car;
        }

        public void displayInfo(){
            System.out.printf("Type ->Human-> Age: %-3d \n", age );
            if(car != null) {
                System.out.print("\t\t\t");
                car.displayInfo();
            }

        }
    }

