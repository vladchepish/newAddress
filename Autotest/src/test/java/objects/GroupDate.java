package objects;

public class GroupDate {

    private String groupName;
    private String groupHeader;
    private String groupFooter;

    public String getGroupName() {
        return groupName;
    }

    public GroupDate setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public GroupDate setGroupHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }

    public String getGroupFooter() {
        return groupFooter;
    }

    public GroupDate setGroupFooter(String groupFooter) {
        this.groupFooter = groupFooter;
        return this;
    }
}
