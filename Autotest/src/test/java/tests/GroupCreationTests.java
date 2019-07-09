package tests;

import objects.GroupDate;
import org.testng.annotations.Test;
import pages.AddGroupPage;
import pages.GroupsPage;
import pages.LoginPage;
import pages.MainPage;

import static Utils.DataGenerator.*;
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
        groupsPage = mainPage.openGroupsPage();
        int groupNumberBefore = groupsPage.countGroups();
        addGroupPage = groupsPage.pressAddNewGroupBtn()
                .fillGroupCreationFields(
                        new GroupDate().setGroupName(generateString(7))
                                .setGroupHeader(generateString(6))
                                .setGroupFooter(generateString(5)));
        groupsPage = addGroupPage.pressEnterInformationBtn()
                .clickOnReturnLink();
        int groupNumberAfter = groupsPage.countGroups();
        CompareTwoIntValue(groupNumberBefore + 1, groupNumberAfter,
                "Количество групп до должно быть на одну меньше, чем количество групп после");
    }

}
