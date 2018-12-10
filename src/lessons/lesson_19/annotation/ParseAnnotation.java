package lessons.lesson_19.annotation;

public class ParseAnnotation {

    public static void main(String[] args) {
        User user = new User(User.Permission.ADMIN);

        Class<?> actionClass = DeleteAction.class;

        PermissionRequired permissionRequired = actionClass.getAnnotation(PermissionRequired.class);

        if(permissionRequired != null) {
            if(user.getPermission().equals(permissionRequired.value())){

                System.out.println("User grant delete permission");

            }
        }
    }
}
