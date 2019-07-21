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
import static java.util.Comparator.comparingInt;
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
        groupsPage = navigation.openGroupsPage();
    }

    @Test(description = "Тест, который создаёт новую группу")
    public void testGroupCreation(){
        List<Group> groupsBefore = groupsPage.getGroupsList();
        Group group = generateRandomGroup();
        addGroupPage = groupsPage.pressAddNewGroupBtn();
        addGroupPage.fillGroupCreationFields(group);
        successPage = addGroupPage.pressEnterInformationBtn();
        successPage.clickOnReturnLink();
        List<Group> groupAfter = groupsPage.getGroupsList();
        CompareTwoIntValue(groupsBefore.size() + 1, groupAfter.size(),
                "Количество групп до должно быть на одну меньше, чем количество групп после");

        int max = 0;
        for (Group g : groupAfter) {
            if (g.getGroupId() > max) {
                max = g.getGroupId();
            }
        }
        group.setGroupId(groupAfter.stream().max(comparingInt(Group::getGroupId)).get().getGroupId());
        groupsBefore.add(group);
        Assert.assertEquals(new HashSet<>(groupAfter), new HashSet<>(groupsBefore),
                "После выполнения теста и добавления элемента в начальный списке - спики должны совпадать");
    }
}
