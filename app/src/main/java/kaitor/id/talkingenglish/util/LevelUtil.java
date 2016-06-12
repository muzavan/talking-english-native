package kaitor.id.talkingenglish.util;

import java.util.ArrayList;
import java.util.logging.Level;

import kaitor.id.talkingenglish.level.fragment.LevelFragment;

/**
 * Created by user pc on 6/12/2016.
 */
public class LevelUtil {
    private ArrayList<LevelFragment> levels = new ArrayList<>();

    public LevelUtil(String topic){
        if(topic.equalsIgnoreCase("home")){

        }
        else if(topic.equalsIgnoreCase("fruits")){

        } else if(topic.equalsIgnoreCase("number")){

        } else if(topic.equalsIgnoreCase("transportation")){

        } else if(topic.equalsIgnoreCase("library")){

        } else if(topic.equalsIgnoreCase("hobbies")){

        } else if(topic.equalsIgnoreCase("factory")){

        } else if(topic.equalsIgnoreCase("hospital")){

        } else if(topic.equalsIgnoreCase("traffic")){

        } else if(topic.equalsIgnoreCase("family")){

        } else if(topic.equalsIgnoreCase("school")){

        } else if(topic.equalsIgnoreCase("supermarket")){

        }

    }

    private ArrayList<LevelFragment> getLevels(){
        return levels;
    }
}
