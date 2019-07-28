package tests;

import objects.Group;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddGroupPage;
import pages.GroupsPage;
import pages.LoginPage;
import pages.SuccessCreationGroupPage;

import java.util.Set;

import static Utils.CustomObjectsGenerator.generateRandomGroup;
import static lib.Compares.CompareTwoIntValue;
import static org.testng.Assert.assertEquals;

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
        if (dbHelper.getGroupsList().size() == 0) {
            addGroupPage = groupsPage.pressAddNewGroupBtn();
            addGroupPage.fillGroupCreationFields(generateRandomGroup());
            successPage = addGroupPage.pressEnterInformationBtn();
            successPage.clickOnReturnLink();
        }
    }

    @Test(description = "Тест, который удаляет случайно выбранную группу")
    public void testGroupDeletion(){
        Set<Group> groupsBefore = dbHelper.getGroupSet();
        Group deletedGroup = groupsBefore.iterator().next();
        groupsPage.deleteGroup(deletedGroup);
        navigation.openGroupsPage();
        Set<Group> groupAfter = dbHelper.getGroupSet();
        CompareTwoIntValue(groupsBefore.size(), groupAfter.size() + 1,
                "Количество групп после должно быть на одну меньше, чем количество групп до");
        groupsBefore.remove(deletedGroup);
        assertEquals(groupAfter, groupsBefore,
                "Списки групп должны совпадать");
    }
}
