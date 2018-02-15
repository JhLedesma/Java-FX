package Model;

import de.saxsys.mvvmfx.MvvmFX;

public class NotificationCenter {
    private static de.saxsys.mvvmfx.utils.notifications.NotificationCenter instance;

    public static de.saxsys.mvvmfx.utils.notifications.NotificationCenter getInstance() {
        if (instance == null) {
            instance = MvvmFX.getNotificationCenter();
        }
        return instance;
    }
}
