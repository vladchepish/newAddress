package objects;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "group_list")
public class Group {

    @Column(name = "group_name")
    private String groupName;
    @Column(name = "group_header")
    @Type(type = "text")
    private String groupHeader;
    @Column(name = "group_footer")
    @Type(type = "text")
    private String groupFooter;
    @Id
    @Column(name = "group_id")
    private int groupId;

    public String getGroupName() {
        return groupName;
    }

    public Group setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public Group setGroupHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }

    public String getGroupFooter() {
        return groupFooter;
    }

    public Group setGroupFooter(String groupFooter) {
        this.groupFooter = groupFooter;
        return this;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupId == group.groupId &&
                Objects.equals(groupName, group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, groupId);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", groupId=" + groupId +
                '}';
    }

}
