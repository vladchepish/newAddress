package tests;

import objects.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddGroupPage;
import pages.GroupsPage;
import pages.LoginPage;
import pages.SuccessCreationGroupPage;

import java.util.Comparator;
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

        group.setGroupId(groupAfter.stream().max(comparingInt(Group::getGroupId)).get().getGroupId());
        groupsBefore.add(group);
        Comparator<? super Group> byId = Comparator.comparingInt(Group::getGroupId);
        groupsBefore.sort(byId);
        groupAfter.sort(byId);
        Assert.assertEquals(groupAfter, groupsBefore,
                "После выполнения теста и добавления элемента в начальный списке - спики должны совпадать");
    }
}
