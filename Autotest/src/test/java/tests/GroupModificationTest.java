package tests;

import objects.Group;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddGroupPage;
import pages.GroupsPage;
import pages.LoginPage;
import pages.SuccessCreationGroupPage;

import static Utils.CustomObjectsGenerator.generateRandomGroup;

public class GroupModificationTest extends TestBase {

    private LoginPage loginPage;
    private GroupsPage groupsPage;
    private AddGroupPage addGroupPage;
    private SuccessCreationGroupPage successPage;

    @BeforeMethod
    public void loginMethod(){
        loginPage = navigation.openLoginPage();
        loginPage.login("admin", "secret");
    }

    @Test(description = "Тест модифицирует первую в списке группу")
    public void testGroupModification(){
        groupsPage = navigation.openGroupsPage();
        Group group = generateRandomGroup();
        groupsPage.selectFirstGroupInList();
        addGroupPage = groupsPage.pressEditGroupBtn();
        addGroupPage.fillGroupCreationFields(group);
        successPage = addGroupPage.pressUpdateBtn();
        successPage.clickOnReturnLink();
    }
}
