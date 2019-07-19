package Utils;

import objects.Contact;
import objects.Group;

import java.util.ArrayList;
import java.util.List;

import static Utils.DataGenerator.*;

public class CustomObjectsGenerator {

    public static Contact generateRandomContact(){
        return new Contact()
                .setFirstName(generateString(6))
                .setMiddleName(generateString(7))
                .setLastName(generateString(8))
                .setNickName(generateString(3))
                .setCompany(generateString(12))
                .setAddress(generateString(15))
                .setMobilePhone("+7" + geniratorNumeric(10))
                .setHomePhone("+8652" + geniratorNumeric(7))
                .setWorkPhone("+2341" + geniratorNumeric(7))
                .setFax("+1246" + geniratorNumeric(7))
                .setFirstEmail(generateEmail())
                .setSecondEmail(generateEmail())
                .setThirdEmail(generateEmail())
                .setHomepage(generateString(21))
                .setSecondAddress(generateString(15))
                .setSecondHome("+7" + geniratorNumeric(10))
                .setSecondNotes(generateString(45));
    }

    public static Group generateRandomGroup(){
        return  new Group().setGroupName(generateString(7))
                .setGroupHeader(generateString(6))
                .setGroupFooter(generateString(5));
    }

    public static List<Contact> generateListRandomContacts(int numberContatsInList){
        List<Contact> contactList = new ArrayList<Contact>();
        for (int i = 0; i < numberContatsInList; i++){
            contactList.add(generateRandomContact());
        }
        return contactList;
    }
}
