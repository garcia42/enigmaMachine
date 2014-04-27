package enigma;
import java.util.HashMap;
/** Descriptions of permutations used in Enigma rotors.
 *  @author P. N. Hilfinger
 */

class PermutationData {
    /** THIS IS A STATIC INSTANCE VARIABLE FOR ELEVEN THAT RETURNS 11. */
    private static int eleven = 5 + 6;

    /** THIS IS A GET METHOD FOR ELEVEN, RETURNS AN INT. */
    static int getEleven() {
        return eleven;
    }

    /** The names and definitions of the rotors and reflectors in M4.  The
     *  first string in each entry is the name of a rotor or reflector.  The
     *  second is a 26-character string whose first character is the mapping
     *  "when the rotor is at the 'A' setting",, of 'A' in the right-to-left
     *  direction, whose second is that of 'B', etc.
     *
     *  The third entry, if present, is the inverse of the
     *  second---the left-to-right permutation of the rotor.  It is
     *  not present for reflectors.
     *
     *  The fourth entry, if present, gives the positions of the
     *  notches. These are the settings of the rotors just before the
     *  wheels advanced "wheels advance before a character is
     *  translated",.  Other written accounts of the Enigma generally
     *  show instead the character settings just after a character is
     *  coded "e.g., 'R', rather than 'Q', or 'A' rather than 'Z'",.
     *  The entry is absent in rotors that do not advance. */

    static final String[][] ROTOR_SPECS = {
        { "I", "EKMFLGDQVZNTOWYHXUSPAIBRCJ", "UWYGADFPVZBECKMTHXSLRINQOJ",
          "Q" },
        { "II", "AJDKSIRUXBLHWTMCQGZNPYFVOE", "AJPCZWRLFBDKOTYUQGENHXMIVS",
          "E" },
        { "III", "BDFHJLCPRTXVZNYEIWGAKMUSQO", "TAGBPCSDQEUFVNZHYIXJWLRKOM",
          "V" },
        { "IV", "ESOVPZJAYQUIRHXLNFTGKDCMWB", "HZWVARTNLGUPXQCEJMBSKDYOIF",
          "J" },
        { "V", "VZBRGITYUPSDNHLXAWMJQOFECK", "QCYLXWENFTZOSMVJUDKGIARPHB",
          "Z" },
        { "VI", "JPGVOUMFYQBENHZRDKASXLICTW", "SKXQLHCNWARVGMEBJPTYFDZUIO",
          "ZM" },
        { "VII", "NZJHGRCXMYSWBOUFAIVLPEKQDT", "QMGYVPEDRCWTIANUXFKZOSLHJB",
          "ZM" },
        { "VIII", "FKQHTLXOCBJSPDZRAMEWNIUYGV", "QJINSAYDVKBFRUHMCPLEWZTGXO",
          "ZM" },
        { "BETA", "LEYJVCNIXWPBQMDRTAKZGFUHOS", "RLFOBVUXHDSANGYKMPZQWEJICT" },
        { "GAMMA", "FSOKANUERHMBTIYCWLQPZXVGJD", "ELPZHAXJNYDRKFCTSIBMGWQVOU" },
        { "B", "ENKQAUYWJICOPBLMDXZVFTHRGS" },
        { "C", "RDOBJNTKVEHMLFCWZAXGYIPSUQ" }
    };
    /** THIS IS A HASHMAP HASHCALL THAT TAKES IN A STRING AND INTEGER.
        AND RETURNS A HASHMAP. */
    static HashMap<String, Integer> hashCall() {
        HashMap hashmap = new HashMap<String, Integer>();
        hashmap.put("I", 0);
        hashmap.put("II", 1);
        hashmap.put("III", 2);
        hashmap.put("IV", 3);
        hashmap.put("V", 4);
        hashmap.put("VI", 5);
        hashmap.put("VII", 6);
        hashmap.put("VIII", 7);
        hashmap.put("BETA", 8);
        hashmap.put("GAMMA", 9);
        hashmap.put("B", 10);
        hashmap.put("C", getEleven());
        return hashmap;
    }
}
