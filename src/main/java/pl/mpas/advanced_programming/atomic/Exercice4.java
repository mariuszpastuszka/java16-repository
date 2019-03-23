package pl.mpas.advanced_programming.atomic;

class Person implements Cloneable {
    private String name;
    private String surname;

    private Person partner;

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public Person(String name, String surname, Person partner) {
        this.name = name;
        this.surname = surname;
        this.partner = partner;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Person performCloning() {
        Person newYou = null;
        try {
            newYou = (Person) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return newYou;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", partner=" + partner.name +
                '}';
    }
}

public class Exercice4 {

    public static void main(String[] args) {
        Person me = new Person("Mariusz", "P.", null);
        Person wife = new Person("M", "P.", me);
        me.setPartner(wife);

        System.out.println("Me: " + me);
        System.out.println("Wife: " + wife);

        Person clonedWife = wife.performCloning();
        System.out.println(clonedWife);
    }
}
