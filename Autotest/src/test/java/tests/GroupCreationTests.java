package tests;

import objects.Group;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static Utils.CustomObjectsGenerator.generateRandomGroup;
import static lib.Compares.CompareTwoIntValue;

public class GroupCreationTests extends TestBase {

    private LoginPage loginPage;
    private GroupsPage groupsPage;
    private AddGroupPage addGroupPage;
    private SuccessCreationGroupPage successPage;

    @BeforeMethod
    public void loginMethod(){
        loginPage = navigation.openLoginPage();
        loginPage.login("admin", "secret");
    }

    @Test
    public void testContactCreation(){
        groupsPage = navigation.openGroupsPage();
        int groupNumberBefore = groupsPage.countGroups();
        Group roup = generateRandomGroup();
        addGroupPage = groupsPage.pressAddNewGroupBtn();
        addGroupPage.fillGroupCreationFields(roup);
        successPage = addGroupPage.pressEnterInformationBtn();
        successPage.clickOnReturnLink();
        int groupNumberAfter = groupsPage.countGroups();
        CompareTwoIntValue(groupNumberBefore + 1, groupNumberAfter,
                "Количество групп до должно быть на одну меньше, чем количество групп после");
    }

}
