package tests;

import objects.Group;
import org.testng.annotations.Test;
import pages.AddGroupPage;
import pages.GroupsPage;
import pages.LoginPage;
import pages.MainPage;

import static Utils.CustomObjectsGenerator.generateRandomGroup;
import static lib.Compares.CompareTwoIntValue;

public class GroupCreationTests extends TestBase {

    private LoginPage loginPage;
    private MainPage mainPage;
    private GroupsPage groupsPage;
    private AddGroupPage addGroupPage;

    @Test
    public void testContactCreation(){
        loginPage = navigation.openLoginPage();
        mainPage = loginPage.login("admin", "secret");
        groupsPage = navigation.openGroupsPage();
        int groupNumberBefore = groupsPage.countGroups();
        Group roup = generateRandomGroup();
        addGroupPage = groupsPage.pressAddNewGroupBtn()
                .fillGroupCreationFields(roup);
        groupsPage = addGroupPage.pressEnterInformationBtn()
                .clickOnReturnLink();
        int groupNumberAfter = groupsPage.countGroups();
        CompareTwoIntValue(groupNumberBefore + 1, groupNumberAfter,
                "Количество групп до должно быть на одну меньше, чем количество групп после");
    }

}
