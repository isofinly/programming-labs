package exceptions;

public class EnoughMidgetsException extends RuntimeException {

    public void getMassage(){
            String message = "There are not enough midgets to make a good meeting";
        System.out.println(message);
    }
}
