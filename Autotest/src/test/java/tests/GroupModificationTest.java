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
        if (dbHelper.getGroupsList().size() == 0) {
            addGroupPage = groupsPage.pressAddNewGroupBtn();
            addGroupPage.fillGroupCreationFields(generateRandomGroup());
            successPage = addGroupPage.pressEnterInformationBtn();
            successPage.clickOnReturnLink();
        }
    }

    @Test(description = "Тест модифицирует первую в списке группу")
    public void testGroupModification(){
        Set<Group> groupsBefore = dbHelper.getGroupSet();
        Group modifiedGroup = groupsBefore.iterator().next();
        Group group = generateRandomGroup();
        group.setGroupId(modifiedGroup.getGroupId());
        groupsPage.selectGroupById(modifiedGroup.getGroupId());
        addGroupPage = groupsPage.pressEditGroupBtn();
        addGroupPage.fillGroupCreationFields(group);
        successPage = addGroupPage.pressUpdateBtn();
        successPage.clickOnReturnLink();
        Set<Group> groupAfter = dbHelper.getGroupSet();
        CompareTwoIntValue(groupsBefore.size(), groupAfter.size(),
                "Количество групп не должно было измениться в процессе выполнения теста");
        groupsBefore.remove(modifiedGroup);
        groupsBefore.add(group);

        // (g1, g2) -> Integer.compare(g1.getGroupId(), g2.getGroupId()
        // equal to
        // Comparator.comparingInt(Group::getGroupId)
        //
        // сортировка списка
        //Comparator<? super Group> byId = Comparator.comparingInt(Group::getGroupId);
        //groupsBefore.sort(byId);
        //groupAfter.sort(byId);
        assertEquals(groupsBefore, groupAfter,
                "После выполнения теста и замены элемента в финальном списке - спики должны совпадать");

    }
}
