package com.example.onehandedkeyboard;

import com.pixplicity.easyprefs.library.Prefs;

public class PrefUtils {

    public static void resetPrefs() {
        Prefs.clear();
    }

    public static void registerStartTime() {
        Prefs.putLong("startTime", System.currentTimeMillis());
    }

    public static void registerEndTime() {
        Prefs.putLong("endTime", System.currentTimeMillis());
    }

    public static void saveNewKeyboardTime() {
        Prefs.putLong("newKeyboardTime", (Prefs.getLong("endTime", 0) - Prefs.getLong("startTime", 0)));
    }

    public static void saveOldKeyboardTime() {
        Prefs.putLong("oldKeyboardTime", (Prefs.getLong("endTime", 0) - Prefs.getLong("startTime", 0)));
    }

    public static void saveNewKeyboardWrongCount() {
        Prefs.putInt("wrongNewKeyboard", Prefs.getInt("wrongChar", 0));
    }

    public static void saveOldKeyboardWrongCount() {
        Prefs.putInt("wrongOldKeyboard", Prefs.getInt("wrongChar", 0));
    }

    public static void addWrongCharCount() {
        int wrongCount = Prefs.getInt("wrongChar", 0);
        wrongCount++;
        Prefs.putInt("wrongChar", wrongCount);
    }

    public static void ressetWrongCharCount() {
        Prefs.remove("wrongChar");
    }

}
