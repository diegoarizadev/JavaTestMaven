package Utils;

import org.junit.Assert;
import org.junit.Test;
import org.n0rf3n.Utils.StringUtil;

public class StringUtilTest {

    @Test
    public void repeat_string_one(){

        Assert.assertEquals("Hola", StringUtil.repeat("Hola", 1));

    }

    @Test
    public void repeat_string_multiple_times(){

        Assert.assertEquals("HolaHolaHola", StringUtil.repeat("Hola", 3));

    }

    @Test
    public void repeat_string_zero_times(){

        Assert.assertEquals("", StringUtil.repeat("Hola", 0));

    }

    @Test(expected =  IllegalArgumentException.class)
    public void repeat_string_negative_times(){

        Assert.assertEquals("", StringUtil.repeat("Hola", -1));

    }

    @Test(expected = IllegalArgumentException.class)
    public void string_is_empty(){
        Assert.assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void string_is_not_empty(){
        Assert.assertFalse(StringUtil.isEmpty("hola"));

    }

    @Test
    public void string_clean_is_not_empty(){
        Assert.assertTrue(StringUtil.isEmpty(" "));

    }

    @Test(expected = IllegalArgumentException.class)
    public void string_null_is_not_empty(){
        String s = null;
        Assert.assertTrue(StringUtil.isEmpty(s));

    }

    @Test
    public void string_spaces_is_empty(){
        Assert.assertTrue(StringUtil.isEmpty("null hola"));

    }
}