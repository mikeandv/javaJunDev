package lessons.lesson_16;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class LaunchStatExternalizable implements Externalizable {//Externalizable объект может изменяться (добавляться/удаляться свойства)

    private int launchCount;
    private Date lastLaunch;
    transient private String lastUser; //transient - свойство означает что поле ненужно сериализовать

    private static final long serialVersionUID = 0L;
    private static final int VERSION = 1;

    public void update() {
        launchCount++;
        lastLaunch = new Date();
        lastUser = System.getProperty("user.name");
    }

    public boolean isFirstLaunch() {
        return launchCount == 0 && lastLaunch == null;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(VERSION);
        out.writeInt(launchCount);
        out.writeObject(lastLaunch);
        out.writeUTF(lastUser);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        if (version > VERSION) {
            throw new IOException("unsupported version");
        }

        launchCount = in.readInt();
        lastLaunch = (Date) in.readObject();

        if(version > 0) {
            lastUser = in.readUTF();
        }

    }

    @Override
    public String toString() {
        return "LaunchStatExternalizable{" +
                "launchCount=" + launchCount +
                ", lastLaunch=" + lastLaunch +
                ", lastUser=" + lastUser +
                '}';
    }
}
