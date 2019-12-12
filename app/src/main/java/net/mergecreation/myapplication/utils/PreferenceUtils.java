package net.mergecreation.myapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceUtils {

    public PreferenceUtils() {
    }

    /**
     * @param phoneNumber
     * @param context
     * @return
     */
    public static boolean savePhoneNumber(String phoneNumber, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prfsEditor = preferences.edit();
        prfsEditor.putString(Constants.USER_MOBILE, phoneNumber);
        prfsEditor.apply();
        return true;
    }

    /**
     * @param userName
     * @param context
     * @return
     */
    public static boolean saveUserName(String userName, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prfsEditor = preferences.edit();
        prfsEditor.putString(Constants.USER_NAME, userName);
        prfsEditor.apply();
        return true;
    }

    /**
     * @param userId
     * @param context
     * @return
     */
    public static boolean saveUserId(String userId, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prfsEditor = preferences.edit();
        prfsEditor.putString(Constants.USER_ID, userId);
        prfsEditor.apply();
        return true;
    }

    public static boolean saveUserAddress(String userAddress, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prfsEditor = preferences.edit();
        prfsEditor.putString(Constants.USER_ADDRESS, userAddress);
        prfsEditor.apply();
        return true;
    }

    /**
     * @param context
     * @return
     */
    public static String getPhoneNumber(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.USER_MOBILE, "");
    }

    /**
     * @param context
     * @return
     */
    public static String getUserName(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.USER_NAME, "");
    }

    /**
     * @param context
     * @return
     */
    public static String getUserId(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.USER_ID, "");
    }

    /**
     * @param context
     * @return
     */
    public static String getUserAddress(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.USER_ADDRESS, null);
    }
}
