/*
Morgan Lumpkin
2/3/2021
I am the author of the assignment; however I received outside help from the following people: Nick Reck
I used the following websites as resources: https://www.it2051229.com/simpleshell.html -- referencing the simple shell outline
I discussed this problem with:
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class GcShell {
    public static void main(String[] args) throws java.io.IOException {
        System.out.print("gcshell> ");
        Scanner console = new Scanner(System.in);
        String cmd = console.nextLine();
        int count = 0;
        ArrayList<String> history = new ArrayList<String>();
        while(!(cmd.equals("quit"))) {
            String[] split = cmd.split(" ");
            if(cmd.equals("history") && !history.isEmpty()) {
                count++;
                history.add(count + ". " + cmd);
                for(String element: history) {
                    System.out.println(element);
                }
            }
            else if(split[0].equals("filecopy")) {
                count++;
                history.add(count + ". " + cmd);
                cmd = "./mybin/filecopy ./mybin/" + split[1] + " ./mybin/" + split[2];
                split = cmd.split(" ");
                try {
                    ProcessBuilder process = new ProcessBuilder();
                    process = new ProcessBuilder(split);
                    Process p =process.inheritIO().start();
                    p.waitFor();
                }
                catch(Exception e) {
                    //no need to print stack trace
                }
            }
            else if(split[0].equals("java")) {
                count++;
                history.add(count + ". " + cmd);
                cmd = "java -cp ./mybin FileCopy " + split[2] + " " + split[3];
                split = cmd.split(" ");
                try {
                    ProcessBuilder process = new ProcessBuilder();
                    process = new ProcessBuilder(split);
                    Process p =process.inheritIO().start();
                    p.waitFor();
                }
                catch(Exception e) {
                }
            }
            else if(cmd.equals("!!")) {
                if(history.isEmpty()) {
                    System.out.println("No commands in history.");
                }
                else {
                    cmd = history.get(count-1).substring(3);
                    try {
                        ProcessBuilder process = new ProcessBuilder();
                        process = new ProcessBuilder(split);
                        Process p =process.inheritIO().start();
                        p.waitFor();
                    }
                    catch(Exception e) {
                    }
                    count++;
                    history.add(count + ". " + cmd);
                }
            }
            else if(!(cmd.equals(""))) {
                try {
                    ProcessBuilder process = new ProcessBuilder();
                    process = new ProcessBuilder(split);
                    Process p =process.inheritIO().start();
                    p.waitFor();
                }
                catch(Exception e) {
                }
                count++;
                history.add(count + ". " + cmd);
            }
            System.out.print("gcshell> ");
            cmd = console.nextLine();
        }
    }
}
