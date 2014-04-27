package enigma;

/** Class that represents a complete enigma machine.
 *  @author Jesus Garcia
 */

public final class Machine {

    /** this is a class variable for THIS . RIGHT ROTORS. */
    private Rotor right;

    /** this is a class variable for THIS . MIDDLE ROTORS. */
    private Rotor middle;

    /** this is a class variable for THIS . LEFT ROTORS. */
    private Rotor left;

    /** this is a class variable for THIS IS A ROTOR ROTORS. */
    private Rotor fixed;

    /** this is a class variable for REFLECTOR. */
    private Rotor reflector;

    /** ROTORARRAY ROTORARRAY[] PRIVATE STATIC VARIABLE.
    TRYING TO SET IT HERE. */
    private Rotor[] rotorArray = new Rotor[5];
    /** this is a GETTER METHOD FOR RIGHT, RETURNS A ROTOR. */

    Rotor getRight() {
        return right;
    }
    /** THIS IS A GETTER METHOD FOR LEFT, RETURNS A ROTOR. */
    Rotor getLeft() {
        return left;
    }
    /** THIS IS A GETTER METHOD FOR MIDDLE, RETURNS A ROTOR. */
    Rotor getMiddle() {
        return middle;
    }
    /** THIS IS A GETTER METHOD FOR REFLECTOR, RETURNS A ROTOR. */
    Rotor getReflector() {
        return reflector;
    }
    /** THIS IS A GETTER METHOD FOR FIXED, RETURNS A ROTOR. */
    Rotor getFixed() {
        return fixed;
    }


    /** Set my rotors to (from left to right) ROTORS.  Initially, the rotor.
    *settings are all 'A' sets ROTORS, a ROTOR[], to the rotors in MACHINE.*/
    void replaceRotors(Rotor[] rotors) {
        this.reflector = rotors[0];
        this.fixed = rotors[1];
        this.left = rotors[2];
        this.middle = rotors[3];
        this.right = rotors[4];
        setUpRotors(reflector, fixed, left, middle, right);
    }



    /** this is to TRY TO SET UP THE ROTOR ARRAY, SETUP ROTORS TAKES.
    PARAMETERS RELFECTOR2 FIXED2 RIGHT2 LEFT2 MIDDLE2 ALL ROTOR. */
    void setUpRotors(Rotor relfector2, Rotor fixed2,
        Rotor left2, Rotor middle2, Rotor right2) {
        rotorArray[0] = relfector2;
        rotorArray[1] = fixed2;
        rotorArray[2] = left2;
        rotorArray[3] = middle2;
        rotorArray[4] = right2;
    }



    /** Set my rotors according to SETTING, which must be a string of four
     *  upper-case letters. The first letter refers to the leftmost
     *  rotor setting.  */
    void setRotors(String setting) {
        this.fixed.setSetting(Rotor.toIndex(setting.charAt(0)));
        this.left.setSetting(Rotor.toIndex(setting.charAt(1)));
        this.middle.setSetting(Rotor.toIndex(setting.charAt(2)));
        this.right.setSetting(Rotor.toIndex(setting.charAt(3)));
        rotorArray[1].setSetting(Rotor.toIndex(setting.charAt(0)));
        rotorArray[2].setSetting(Rotor.toIndex(setting.charAt(1)));
        rotorArray[3].setSetting(Rotor.toIndex(setting.charAt(2)));
        rotorArray[4].setSetting(Rotor.toIndex(setting.charAt(3)));
    }



    /** Returns the encoding/decoding of MSG, updating the state of
     *  the rotors accordingly. */
    String convert(String msg) {

        String msg2 = msg.replace(" ", "");
        String msg3 = msg2.toUpperCase();
        char[] decoded = new char[msg3.length()];
        char[] msgary = msg3.toCharArray();

        int i;
        for (i = 0; i < msgary.length; i++) {
            if (rotorArray[3].atNotch()) {
                rotorArray[2].advanceSetting();
                rotorArray[3].advanceSetting();
            } else if (rotorArray[4].atNotch()) {
                rotorArray[3].advanceSetting();
            }
            rotorArray[4].advanceSetting();


            int current = Rotor.toIndex(msgary[i]);
            for (int backward = 4; backward > -1; backward--) {
                current = rotorArray[backward].convertForward(current);
            }
            for (int forward = 1; forward < 5; forward++) {
                current = rotorArray[forward].convertBackward(current);
            }
            decoded[i] = Rotor.toLetter(current);
        }
        String s = new String(decoded);
        return s;
    }
}
