package prihanofficial.com.kokis.logics;


import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

import prihanofficial.com.kokis.helpers.Mode;
import prihanofficial.com.kokis.helpers.UserDefault;

/**
 * Created by Prihan Nimsara on 6/12/2017.
 **/

public final class Kokis {

    //region variables declare and initialize for use to library
    private static Kokis kokis;
    private static Context kokisContext;
    private static String kokisSharedPreferencesName;
    private static int kokisMode = -1;
    private static boolean kokisUserDefault = false;
    private static String kokisDefaultSharedPreferenceName = "KokisSharedPreferences";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static int mode = Mode.getMode(Mode.PRIVATE);
    //endregion

    //region basic structure build using this source code
    public static Kokis setContext(Context context) {
        kokisContext = context.getApplicationContext();
        if (kokis == null) {
            kokis = new Kokis();
        }
        return kokis;
    }

    public static Kokis setSharedPreferencesName(final String sharedPreferencesName) {
        kokisDefaultSharedPreferenceName = sharedPreferencesName;
        return kokis;
    }

    public static Kokis setMode(Mode modeGetFromModeEnum) {
        mode = Mode.getMode(modeGetFromModeEnum);
        if (mode == ContextWrapper.MODE_PRIVATE || mode == ContextWrapper.MODE_WORLD_READABLE || mode == ContextWrapper.MODE_WORLD_WRITEABLE || mode == ContextWrapper.MODE_MULTI_PROCESS) {
            kokisMode = mode;
        } else {
            throw new RuntimeException("Please, insert a mode");
        }
        return kokis;
    }

    public static Kokis setUseDefaultSharedPreference(UserDefault userDefault) {
        if (UserDefault.getUserDefault(userDefault) == 1) {
            kokisUserDefault = true;
        } else {
            kokisUserDefault = false;
        }
        return kokis;
    }

    public static void build() {
        if (kokisContext == null) {
            throw new RuntimeException("Please set a context.");
        }

        if (kokisSharedPreferencesName == null || kokisSharedPreferencesName.equals("")) {
            kokisDefaultSharedPreferenceName = kokisContext.getPackageName();
        }

        if (kokisUserDefault) {
            kokisDefaultSharedPreferenceName += kokisDefaultSharedPreferenceName;
        }

        if (kokisMode == -1) {
            kokisMode = Mode.getMode(Mode.PRIVATE);
        }

        Kokis.initializeSharedPreferences(kokisContext, kokisSharedPreferencesName, kokisMode);
    }

    private static void initializeSharedPreferences(Context context, String sharedPreferenceName, int mode) {
        sharedPreferences = context.getSharedPreferences(sharedPreferenceName, mode);
    }

    private static SharedPreferences getSharedPreferencesObject() {
        if (sharedPreferences != null) {
            return sharedPreferences;
        } else {
            throw new RuntimeException("Please correctly instantiate a shared preffrence");
        }
    }
    //endregion

    //region set data to sharedpreferences
    public static void setKokisInt(String key, int value) {
        final SharedPreferences.Editor editor = getSharedPreferencesObject().edit();
        editor.putInt(key,value);
        editor.commit();
    }

    public static void setKokisLong(String key, long value) {
        final SharedPreferences.Editor editor = getSharedPreferencesObject().edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static void setKokisFloat(String key, float value) {
        final SharedPreferences.Editor editor = getSharedPreferencesObject().edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public static void setKokisBoolean(String key, boolean value) {
        final SharedPreferences.Editor editor = getSharedPreferencesObject().edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void setKokisString(String key, String value) {
        final SharedPreferences.Editor editor = getSharedPreferencesObject().edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static  void setKokisByteArray(String key,byte[] value){
        String convertedByteString = convertByteArrayToString(value);
        final SharedPreferences.Editor editor = getSharedPreferencesObject().edit();
        editor.putString(key, convertedByteString);
        editor.commit();
    }

    public static void setKokisDouble(String key,double value){
        String converteddoubleString = convertDoubleToString(value);
        final SharedPreferences.Editor editor = getSharedPreferencesObject().edit();
        editor.putString(key, converteddoubleString);
        editor.commit();
    }

    public static void setKokisShort(String key, short value){
        String convertedShortString = convertShortToString(value);
        final SharedPreferences.Editor editor = getSharedPreferencesObject().edit();
        editor.putString(key, convertedShortString);
        editor.commit();
    }
    //endregion

    //region get data from sharedpreferences
    public static int getKokisInt(String key, int defaultValue) {
        return getSharedPreferencesObject().getInt(key, defaultValue);
    }

    public static long getKokisLong(String key, long defaultValue) {
        return getSharedPreferencesObject().getLong(key, defaultValue);
    }

    public static float getKokisFloat(String key, float defaultValue) {
        return getSharedPreferencesObject().getFloat(key, defaultValue);
    }

    public static boolean getKokisBoolean(String key, boolean defaultValue) {
        return getSharedPreferencesObject().getBoolean(key, defaultValue);
    }

    public static String getKokisString(String key, String defaultValue) {
        return getSharedPreferencesObject().getString(key, defaultValue);
    }

    public static byte[] getKokisByteArray(String key,String defaultValue){
        String stringData = getSharedPreferencesObject().getString(key, defaultValue);
        return conertStringToByteArray(stringData);
    }

    public static double getKokisDouble(String key,String defaultValue){
        String stringData =  getSharedPreferencesObject().getString(key, defaultValue);
        return convertStringToDouble(stringData);
    }

    public static short getKokisShort(String key, String defaultValue){
        String stringData =  getSharedPreferencesObject().getString(key, defaultValue);
        return convertStringToShort(stringData);
    }
    //endregion

    //region clear data from sharedpreferences
    public static void deleteKokisKey(String key) {
        final SharedPreferences.Editor editor = getSharedPreferencesObject().edit();
        editor.remove(key);
        editor.commit();
    }

    public static void clearAllKokisData() {
        final SharedPreferences.Editor editor = getSharedPreferencesObject().edit();
        editor.clear();
        editor.commit();
    }
    //endregion

    //region byte array convert to String and vice versa source code
    private static String convertByteArrayToString(byte[] byteValue) {
        String convertedStringValue = new String(byteValue);
        return convertedStringValue;
    }

    private static byte[] conertStringToByteArray(String stringValue){
        byte[] convertedbyteArray = stringValue.getBytes();
        return convertedbyteArray;
    }
    //endregion

    //region double convert to String and vice versa source code
    private static String convertDoubleToString(double doubleValue){
        String convertedStringValue = Double.toString(doubleValue);
        return convertedStringValue;
    }

    private static  double convertStringToDouble(String stringValue){
        double convertedDoubleValue = Double.parseDouble(stringValue);
        return convertedDoubleValue;
    }
    //endregion

    //region short covert to String and vice versa source code
    private static String convertShortToString(short shortValue){
        String convertedStringValue = Short.toString(shortValue);
        return convertedStringValue;
    }

    private static short convertStringToShort(String stringValue){
        short conertedShortValue = Short.parseShort(stringValue);
        return conertedShortValue;
    }
    //endregion

}
