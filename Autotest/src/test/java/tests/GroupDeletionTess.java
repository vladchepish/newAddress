package tests;

import objects.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddGroupPage;
import pages.GroupsPage;
import pages.LoginPage;
import pages.SuccessCreationGroupPage;

import java.util.List;

import static Utils.CustomObjectsGenerator.generateRandomGroup;
import static lib.Compares.CompareTwoIntValue;

public class GroupDeletionTess extends TestBase {

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

    @Test(description = "Тест, который удаляет случайно выбранную группу")
    public void testGroupDeletion(){
        groupsPage = navigation.openGroupsPage();
        List<Group> groupsBefore = groupsPage.getGroupsList();
        groupsPage.selectGroupByPosition(groupsBefore.size() - 1);
        groupsPage.pressDeleteGroupBtn();
        groupsPage.checkMessageBox();
        navigation.openGroupsPage();
        List<Group> groupAfter = groupsPage.getGroupsList();
        CompareTwoIntValue(groupsBefore.size(), groupAfter.size()
                        + 1,
                "Количество групп после должно быть на одну меньше, чем количество групп до");
        groupsBefore.remove(groupsBefore.size() - 1);
        Assert.assertEquals(groupAfter, groupsBefore, "Списки групп должны совпадать");
    }
}
