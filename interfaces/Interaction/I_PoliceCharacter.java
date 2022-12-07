package interfaces.Interaction;

import characters.*;

public interface I_PoliceCharacter {
    
    public void hit(PoliceCharacter anotherPolicemen);

    public void see(PoliceCharacter anotherPolicemen);

    public void useStick(PoliceCharacter anotherPolicemen);

    public void useGun(PoliceCharacter anotherPolicemen);

    public void punch(PoliceCharacter anotherPolicemen);
}
