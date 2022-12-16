package interfaces;

import characters.*;

public interface hitable {
    
    public void hit(AnotherMidget anotherMidget);
    public void hit(PoliceCharacter anotherPolicemen);
    public void hit(Object hitted);
}
