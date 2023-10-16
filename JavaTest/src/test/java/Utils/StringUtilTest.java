package Utils;

class StringUtilTest {

    public static void main(String[] args){
        assertEquals(StringUtil.repeat("Hola", 3), "HolaHolaHola");


    }

    private static void assertEquals(String actual, String expected) {
        if (!actual.equals(expected)){
            throw new RuntimeException(actual + " is not equal to "+expected);
        }
    }
}