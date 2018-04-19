class MarsApplication {
    public static void main(String[] arguments) {
        MarsRobot spirit = new MarsRobot();

        spirit.status = "exploring";
        spirit.speed = 2;
        spirit.temperature = -60;
        spirit.showAttributes();

        System.out.println("Increasing speed to 3.");
        spirit.speed = 3;
        spirit.showAttributes();

        System.out.println("Changing temperature to -90");
        spirit.temperature = -90;
        spirit.showAttributes();

        System.out.println("Checking the temperature");
        spirit.checkTemperature();
        spirit.showAttributes();

        System.out.println("_________________________");
        System.out.println("_______Opportunity_______");
        System.out.println("_________________________");

        MarsRobot opportunity = new MarsRobot();

        opportunity.status = "struggling";
        opportunity.speed = 5;
        opportunity.temperature = 100;
        opportunity.showAttributes();
    }
}