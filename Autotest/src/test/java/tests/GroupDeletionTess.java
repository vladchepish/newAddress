package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GroupsPage;
import pages.LoginPage;

import static lib.Compares.CompareTwoIntValue;

public class GroupDeletionTess extends TestBase {

    private LoginPage loginPage;
    private GroupsPage groupsPage;

    @BeforeMethod
    public void loginMethod(){
        loginPage = navigation.openLoginPage();
        loginPage.login("admin", "secret");
    }

    @Test(description = "Тест, который удаляет случайно выбранную группу")
    public void testGroupDeletion(){
        groupsPage = navigation.openGroupsPage();
        int groupNumberBefore = groupsPage.countGroups();
        groupsPage.selectFirstGroupInList();
        groupsPage.pressDeleteBtn();
        groupsPage.checkMessageBox();
        navigation.openGroupsPage();
        int groupNumberAfter = groupsPage.countGroups();
        CompareTwoIntValue(groupNumberBefore, groupNumberAfter + 1,
                "Количество групп после должно быть на одну меньше, чем количество групп до");
    }
}
