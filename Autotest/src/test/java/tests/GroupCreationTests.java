package tests;

import objects.Group;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddGroupPage;
import pages.GroupsPage;
import pages.LoginPage;
import pages.SuccessCreationGroupPage;

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

    @Test(description = "Тест, который создаёт новую группу")
    public void testGroupCreation(){
        groupsPage = navigation.openGroupsPage();
        int groupNumberBefore = groupsPage.countGroups();
        Group group = generateRandomGroup();
        addGroupPage = groupsPage.pressAddNewGroupBtn();
        addGroupPage.fillGroupCreationFields(group);
        successPage = addGroupPage.pressEnterInformationBtn();
        successPage.clickOnReturnLink();
        int groupNumberAfter = groupsPage.countGroups();
        CompareTwoIntValue(groupNumberBefore + 1, groupNumberAfter,
                "Количество групп до должно быть на одну меньше, чем количество групп после");
    }
}
