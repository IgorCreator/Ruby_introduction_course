package hackaton;

public class Tenor extends Singer{
    public static String sing() {
        return "fa";
    }

    public static void main(String[] args) {

        Singer s = new Tenor();
        Tenor t = new Tenor();

        System.out.println(t.sing() + " " + s.sing());
    }
}

class Singer {
    public static String sing() {
        return "la";
    }
}