public class InputTest {
    public static void main(String[] args) {
        String input = "ls -al";
        String[] argv_list=input.split(" ");
        try {
            ProcessBuilder process;
            process=new ProcessBuilder(argv_list);
            Process p=process.inheritIO().start();
            p.waitFor();
        } catch(Exception e) {
            System.out.println("Error in child process");
            e.printStackTrace();
        }
    }
}
