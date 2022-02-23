package easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {

        Set<String> receivedAddress = new HashSet<>();

        for (String email : emails) {
            StringBuilder emailform = new StringBuilder();
            String[] split = email.split("@");
            emailform.append(formName(split[0]));
            emailform.append("@");
            emailform.append(getDomainEmail(split[1]));
            receivedAddress.add(emailform.toString());
        }
        return receivedAddress.size();
    }

    private String getDomainEmail(String domain) {
        return domain.replaceAll("\\.", "");
    }


    private String formName(String firstPartEmail) {
        String result = firstPartEmail.replaceAll("\\.", "");
        if (firstPartEmail.contains("+")) {
            result = result.substring(0, result.lastIndexOf("+"));
        }
        return result;
    }
}
