public class dog {
    String name;
    String eyeColor;
    String birthState;
    int age;
    double weightInPounds;
    String[] likesTo;

    public dog(String name, String eyeColor, String birthState, int age, double weightInPounds, String[] likesTo) {
        this.name = name;
        this.eyeColor = eyeColor;
        this.birthState = birthState;
        this.age = age;
        this.weightInPounds = weightInPounds;
        this.likesTo = likesTo;
    }

    public void welcome() {
        System.out.println("Hello! My name is " + name);
        System.out.println("I am " + age + " years old and I have " + eyeColor + " eyes.");
        System.out.println("I weigh " + weightInPounds + " pounds and was born in the lovely state of " + birthState);

        System.out.println("Here are some of the things I enjoy doing:");
        for (String element: likesTo) {
            System.out.println("\t- " + element);
        }
    }
}
