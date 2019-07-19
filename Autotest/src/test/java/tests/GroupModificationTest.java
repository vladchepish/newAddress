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

public class GroupModificationTest extends TestBase {

    private LoginPage loginPage;
    private GroupsPage groupsPage;
    private AddGroupPage addGroupPage;
    private SuccessCreationGroupPage successPage;

    @BeforeMethod
    public void loginMethod(){
        loginPage = navigation.openLoginPage();
        loginPage.login("admin", "secret");
        groupsPage = navigation.openGroupsPage();
        if (groupsPage.countGroups() == 0) {
            Group groupZero = generateRandomGroup();
            addGroupPage = groupsPage.pressAddNewGroupBtn();
            addGroupPage.fillGroupCreationFields(groupZero);
            successPage = addGroupPage.pressEnterInformationBtn();
            successPage.clickOnReturnLink();
        }
    }

    @Test(description = "Тест модифицирует первую в списке группу")
    public void testGroupModification(){
        int groupNumberBefore = groupsPage.countGroups();
        Group group = generateRandomGroup();
        groupsPage.selectFirstGroupInList();
        addGroupPage = groupsPage.pressEditGroupBtn();
        addGroupPage.fillGroupCreationFields(group);
        successPage = addGroupPage.pressUpdateBtn();
        successPage.clickOnReturnLink();
        int groupNumberAfter = groupsPage.countGroups();
        CompareTwoIntValue(groupNumberBefore, groupNumberAfter,
                "Количество групп не должно было измениться в процессе выполнения теста");
    }
}
