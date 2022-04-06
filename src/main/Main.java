package main;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsOne.SubscriptionChecker;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws
            IOException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException,
            NoSuchPaddingException,
            IllegalBlockSizeException,
            BadPaddingException,
            InvalidKeyException {
        SubscriptionChecker subscriptionChecker = new SubscriptionChecker();
        ObjectMapper objectMapper = new ObjectMapper();
        MyFileWriter myFileWriter = new MyFileWriter();

        // 1. Get Subscriptions in json
        String subscriptionsJson = subscriptionChecker.getSubscriptions(1);

        // 2a. Encrypt
        String encryptedSubscriptions = Security.encrypt(subscriptionsJson);

        // 2b. Save to file
        myFileWriter.writeToFile(encryptedSubscriptions, "src/main/encrypted_stuff.txt");

        // 3. Load the file and decrypt the data.
        String decryptedSubscriptions = Security.decrypt(myFileWriter.readFile("src/main/encrypted_stuff.txt"));

        // 4. Print out each subscription and whether or not the customer is subscribed to the console
        List<Subscription> subscriptionsObject = objectMapper.readValue(decryptedSubscriptions,
                                                                        new TypeReference<List<Subscription>>() {
                                                                        });
        subscriptionsObject.stream()
                           .forEach(subscription -> {
                               System.out.println(subscription.getName() + " isSubscribed: " + subscription.isSubscribed());
                           });
    }
}
