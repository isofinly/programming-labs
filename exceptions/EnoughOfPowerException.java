package exceptions;

public class EnoughOfPowerException extends RuntimeException {

    public void getMassage(){
            String message = "The pump is not good enough to pump up the water";
        System.out.println(message);
    }
}

