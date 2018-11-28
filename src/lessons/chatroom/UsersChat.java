package lessons.chatroom;

public class UsersChat {
    private int chatId;
    private String name;
    private int adminId;

    public UsersChat(String name, int adminId) {
        this.name = name;
        this.adminId = adminId;
    }
//    public UsersChat(User user) {
//        this.name = "Chat by " + adminId;
//        this.adminId = user.;
//    }

    public String getName() {
        return name;
    }

    public int getAdminId() {
        return adminId;
    }
}
