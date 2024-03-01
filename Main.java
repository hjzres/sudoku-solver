import java.util.Scanner;

public class Main {
    public Main(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many squares are there in a section: ");
        int squares = sc.nextInt();
        int sections = 9;
        int[][] layout = new int[squares][sections];

        for(int i = 0; i < sections; i++){
            System.out.format("Tell me the numbers in section %d (0 if nothing)%n", i + 1);
            for(int j = 0; j < squares; j++){
                int num = sc.nextInt();
                layout[j][i] = num > 0 ? num : 0;
            }
        }

        for(int i = 0; i < sections; i++){
            for(int j = 0; j < squares; j++){
                System.out.print(layout[j][i] + ", ");
            }
            System.out.println();
        }

        sc.close();
    }

    public static void main(String[] args){
        new Main();
    }
}
