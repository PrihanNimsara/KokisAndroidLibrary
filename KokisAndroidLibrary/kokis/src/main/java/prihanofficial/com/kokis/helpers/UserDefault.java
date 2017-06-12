package prihanofficial.com.kokis.helpers;


/**
 * Created by Prihan Nimsara on 6/12/2017.
 **/

public enum UserDefault {

    YES, NO;

    public static int getUserDefault(UserDefault userDefault) {
        switch (userDefault) {
            case YES:
                return 1;
            case NO:
                return 2;
        }
        return 1;
    }

}
