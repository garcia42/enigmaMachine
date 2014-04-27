package enigma;

/** Class that represents a rotor in the enigma machine.
 *  @author Jesus Garcia
 */

class Rotor {

    /** PRIVATE INSTANCE INT SETTINGS2 VARIABLE. */
    private int setting2;
    /** PRIVATE INSTANCE INT SELF2 VARIABLE. */
    private int self2;
    /** PRIVATE INSTANCE STRING[][] SPECS FROM PERMUTATION DATA. */
    private String[][] specs = PermutationData.ROTOR_SPECS;

    /** ROTOR CONSTRUCTOR TAKES SETTING AND SELF. */
    public Rotor(int setting, int self) {
        setting2 = setting;
        self2 = self;
    }
    /** THIS IS GETSPECS THAT RETURNS SPECS AND RETURN STRING[][]. */
    String[][] getSpecs() {
        return specs;
    }
    /** THIS IS SETTING2GET THAT WILL GET SETTING2 AND RETURN INT. */
    int setting2get() {
        return setting2;
    }
    /** THIS IS SELF2GET THAT WILL GET SELF2 AND RETURN INT. */
    int self2get() {
        return self2;
    }
    /** Size of alphabet used for plaintext and ciphertext. */
    static final int ALPHABET_SIZE = 26;

    /** Assuming that P is an integer in the range 0..25, returns the
     *  corresponding upper-case letter in the range A..Z. */
    static char toLetter(int p) {
        return (char) (p + 'A');
    }

    /** Assuming that C is an upper-case letter in the range A-Z, return the
     *  corresponding index in the range 0..25. Inverse of toLetter. */
    static int toIndex(char c) {
        return c - 'A';
    }

    /** Return my current rotational setting as an integer between 0
     *  and 25 (corresponding to letters 'A' to 'Z').  */
    int getSetting() {
        return this.setting2;
    }
    /** THIS IS A SET METHOD SETSETTING, IT TAKES ANYTHING INT.
        AND SETS SETTING2 TO ANYTHING. */
    void setSetting(int anything) {
        this.setting2 = anything;
    }

    /** Set getSetting() to POSN.  */
    void set(int posn) {
        assert 0 <= posn && posn < ALPHABET_SIZE;
        this.setting2 = posn;
    }

    /** Return the conversion of P (an integer in the range 0..25)
     *  according to my permutation. */
    int convertForward(int p) {
        int j = (this.setting2 + p) % ALPHABET_SIZE;
        char intermediate = specs[self2][1].charAt(j);
        int comp = (toIndex(intermediate) - this.setting2) % ALPHABET_SIZE;
        if (comp < 0) {
            return comp + ALPHABET_SIZE;
        }
        return comp;
    }

    /** Return the conversion of P (an integer in the range 0..25)
     *  according to the inverse of my permutation. */
    int convertBackward(int p) {
        int j = (this.setting2 + p) % ALPHABET_SIZE;
        char intermediate = specs[self2][2].charAt(j);
        int comp = (toIndex(intermediate) - this.setting2) % ALPHABET_SIZE;
        if (comp < 0) {
            return comp + ALPHABET_SIZE;
        }
        return comp;
    }

    /** Returns true iff I am positioned to allow the rotor to my left
     *  to advance. */
    boolean atNotch() {
        String notch = specs[self2][3];
        if (notch.indexOf(toLetter(setting2)) != -1) {
            return true;
        }
        return false;
    }

    /** Advance me one position. */
    void advanceSetting() {
        if (this.setting2 != ALPHABET_SIZE - 1) {
            this.setSetting(setting2 + 1);
        } else {
            this.setSetting(0);
        }
    }
}
