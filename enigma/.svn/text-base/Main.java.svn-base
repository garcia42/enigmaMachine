package enigma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

/** Enigma simulator.
 *  @author Jesus Garcia
 */

public final class Main {

    /** THIS IS A HASHMAP THAT IS FROM PERMUTATION DATA. */
    private HashMap hashmap = PermutationData.hashCall();

    /** Process a sequence of encryptions and decryptions, as
     *  specified in the input from the standard input.  Print the
     *  results on the standard output. Exits normally if there are
     *  no errors in the input; otherwise with code 1. */
    public static void main(String[] unused) {
        Machine M;
        BufferedReader input =
            new BufferedReader(new InputStreamReader(System.in));

        M = null;

        try {
            while (true) {
                String line = input.readLine();
                if (line == null) {
                    break;
                }
                if (M != null && line.trim().length() == 0) {
                    System.out.println("");
                    continue;
                }
                if (isConfigurationLine(line)) {
                    M = new Machine();
                    configure(M, line);
                } else {
                    if (M == null) {
                        System.exit(1);
                    }
                    printMessageLine(M.convert(standardize(line)));
                }
            }
        } catch (IOException excp) {
            System.err.printf("Input error: %s%n", excp.getMessage());
            System.exit(1);
        }

    }

    /** Return true iff LINE is an Enigma configuration line. */
    private static boolean isConfigurationLine(String line) {
        String[] rotors = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII"};
        String[] array = line.split("\\s");
        if ((array.length != 7) || (!(array[0].equals("*")))) {
            return false;
        }

        if ((!(array[1].equals("B"))) && (!(array[1].equals("C")))) {
            return false;
        }

        if ((!(array[2].equals("BETA"))) && (!(array[2].equals("GAMMA")))) {
            return false;
        }
        int count = 0;
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                if (array[i].equals(rotors[j])) {
                    count++;
                    rotors[j] = " ";
                }
            }
        }
        if (count != 3) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (!(Character.isLetter(array[6].charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    /** Configure M according to the specification given on CONFIG,
     *  which must have the format specified in the assignment. */
    private static void configure(Machine M, String config) {
        String[] ary = config.split(" ");
        HashMap hashmap = PermutationData.hashCall();
        Rotor r1 = new Rotor(0, (int) hashmap.get(ary[1]));
        Rotor r2 = new Rotor(0, (int) hashmap.get(ary[2]));
        Rotor r3 = new Rotor(0, (int) hashmap.get(ary[3]));
        Rotor r4 = new Rotor(0, (int) hashmap.get(ary[4]));
        Rotor r5 = new Rotor(0, (int) hashmap.get(ary[5]));
        Rotor[] rotors = {r1, r2, r3, r4, r5};
        M.replaceRotors(rotors);
        M.setRotors(ary[6]);
    }
    /** Return the result of converting LINE to all upper case,
     *  removing all blanks and tabs.  It is an error if LINE contains
     *  characters other than letters and blanks. */
    private static String standardize(String line) throws IOException {
        int length = line.length();
        String line2 = line.toUpperCase().replaceAll("\\s", "").trim();
        for (int i = 0; i < line2.length(); i++) {
            char c = line2.charAt(i);
            if (!(Character.isLetter(c))) {
                throw new IOException("Message has non letters in it.");
            }
        }
        return line2;
    }


    /** Print MSG in groups of five (except that the last group may
     *  have fewer letters). */
    private static void printMessageLine(String msg) {
        String msg2 = msg;
        while (msg2.length() > 5) {
            System.out.print(msg2.substring(0, 5) + " ");
            msg2 = msg2.substring(5, msg2.length());
        }
        if (msg2.length() == 5) {
            System.out.print(msg2.substring(0, 5));
        } else {
            System.out.print(msg2);
        }
        System.out.println();
    }

    /** THIS IS A HASHMAP GETTER, HASHRETURN RETURNS A HAHMAP. */
    HashMap hashReturn() {
        return hashmap;
    }
}
