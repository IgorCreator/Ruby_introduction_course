package easy;

public class HammingDistance {

    //The First Variant(wrote by Igor)
    public int hammingDistance(int x, int y) {
        System.out.println("decimal: x:" + x + " and y:" + y);
        char[] xQuantity = transformToBinary(x);
        char[] yQuantity = transformToBinary(y);
        char[] newChars;
        if (yQuantity.length > xQuantity.length) {
            newChars = changeMassiveByAddingElem(xQuantity, yQuantity.length);
            return compareArrays(newChars, yQuantity);
        } else {
            newChars = changeMassiveByAddingElem(yQuantity, xQuantity.length);
            return compareArrays(xQuantity, newChars);
        }
    }

    public char[] transformToBinary(int input) {
        String toBinaryString = Long.toBinaryString(input);
        char[] array = toBinaryString.toCharArray();
        System.out.print("binary:");
        System.out.println(array);
        return array;
    }

    public int compareArrays(char[] xQuantity, char[] yQuantity) {
        int result = 0;
        for (int index = 0; index < xQuantity.length; index++) {
            System.out.println("x:" + xQuantity[index] + " and y:" + yQuantity[index]);
            if (xQuantity[index] != yQuantity[index]) {
                result++;
            }
        }
        return result;
    }

    public char[] changeMassiveByAddingElem(char[] original, int length) {
        char[] result = new char[length];
        System.out.println("difference in: " + (length - original.length) + " symbol(s)");
        addZeroInBegining(result, length - original.length);
        System.arraycopy(original, 0, result, length - original.length, original.length);
        return result;
    }

    public void addZeroInBegining(char[] result, int i) {
        for (int index = 0; index < i+1; index++) {
            result[index] = '0';
        }
    }

    //The Second Variant(from Internet)
    public int hamDistSecondVar(int x, int y) {
        if((x^y)==0) return 0;
        return (x^y)%2 + hamDistSecondVar(x/2,y/2);
    }

    //The Third Variant(from Internet)
    public int hamDistThirdVar(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
