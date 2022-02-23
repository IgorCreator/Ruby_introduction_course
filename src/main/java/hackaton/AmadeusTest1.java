package hackaton;

public class AmadeusTest1 {

    /*
    * We are given a string S representing a phone number,
    * which we would like to reformat. String S consists of N characters:
    * digits, spaces and/or dashes. It contains at least two digits.
    * Spaces and dashes in string S can be ignored. We want to reformat
    * the given phone number in such a way that the digits are grouped in blocks
    * of length three, separated by single dashes. If necessary, the final block
    * or the last two blocks can be of length two.
    * */

    public static void main (String[] args) throws java.lang.Exception
    {
        String s = "00-44  48 5555 8361"; // => 004-448-555-583-61
        run(s);
        s = "0 - 22 1985--324"; // => 022-198-53-24
        run(s);
        s = "555372654";  // => 555-372-654
        run(s);
        s = "12-10 23 5555 8361"; // => 121-023-555-583-61
        run(s);
    }
    public static void run(String abc) {
        String hello = abc.replaceAll("[^a-zA-Z0-9]", "");
        hello = hello.replaceAll("(?<=\\G\\d{3})(?!$)", "-");
        System.out.println(hello.replaceAll("\\b(\\d{2})(\\d+)-(\\d)$", "$1-$2$3"));
    }
}
