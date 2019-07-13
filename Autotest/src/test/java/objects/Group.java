package objects;

public class Group {

    private String groupName;
    private String groupHeader;
    private String groupFooter;

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
}
