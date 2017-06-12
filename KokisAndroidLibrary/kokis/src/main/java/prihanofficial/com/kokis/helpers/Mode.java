package prihanofficial.com.kokis.helpers;


/**
 * Created by Prihan Nimsara on 6/12/2017.
 **/

public enum Mode {

    PRIVATE,WORLD_READABLE,WORLD_WRITEABLE,MULTI_PROCESS;

    public static int getMode(Mode mode){
        switch (mode){
            case  PRIVATE:
                return 0x0000;
            case WORLD_READABLE:
                return 0x0001;
            case WORLD_WRITEABLE:
                return 0x0002;
            case MULTI_PROCESS:
                return 0x0004;
        }
        return 0x0000;
    }

}
