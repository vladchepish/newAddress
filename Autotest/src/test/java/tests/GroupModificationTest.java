package tests;

import objects.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddGroupPage;
import pages.GroupsPage;
import pages.LoginPage;
import pages.SuccessCreationGroupPage;

import java.util.HashSet;
import java.util.List;

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
        List<Group> groupsBefore = groupsPage.getGroupsList();
        groupsPage.selectGroupByPosition(groupsBefore.size() - 1);
        Group group = generateRandomGroup();
        group.setGroupId(groupsBefore.get(groupsBefore.size() - 1).getGroupId());
        addGroupPage = groupsPage.pressEditGroupBtn();
        addGroupPage.fillGroupCreationFields(group);
        successPage = addGroupPage.pressUpdateBtn();
        successPage.clickOnReturnLink();
        List<Group> groupAfter = groupsPage.getGroupsList();
        CompareTwoIntValue(groupsBefore.size(), groupAfter.size(),
                "Количество групп не должно было измениться в процессе выполнения теста");
        groupsBefore.remove(groupsBefore.size() - 1);
        groupsBefore.add(group);
        Assert.assertEquals(new HashSet<>(groupAfter), new HashSet<>(groupsBefore),
                "После выполнения теста и замены элемента в финальном списке - спики должны совпадать");

    }
}
