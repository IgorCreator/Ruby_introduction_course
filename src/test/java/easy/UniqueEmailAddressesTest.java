package easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueEmailAddressesTest {

    @Test
    public void numUniqueEmailsTest() {
        String [] input = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        UniqueEmailAddresses uniqueEmailAddresses = new UniqueEmailAddresses();

        assertEquals(2, uniqueEmailAddresses.numUniqueEmails(input));
    }
}