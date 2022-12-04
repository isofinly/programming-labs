package interfaces;

public interface Talkable {
    default String talk(Object object){ 
        return null;
    };
}
