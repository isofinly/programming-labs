package interfaces;

public interface Shouting {
    default String Shout(Object object, String phrase){ 
        return null;
    };
}
