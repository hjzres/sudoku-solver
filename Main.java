import java.util.Scanner;

public class Main {
    int sections = 9;
    Scanner sc = new Scanner(System.in);
    int squares;
    int squaresPerRow;
    public Main(){


        System.out.print("Enter how many squares are there in a section: ");
        squares = sc.nextInt();
        squaresPerRow = (int) Math.sqrt(squares);

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

    private int[] CheckPlace(int num){
        int[] value = new int[(int) Math.sqrt(squares)];
        int temp = num;
        while(true){
            if(temp - squaresPerRow < 0){
                break;
            }
            temp -= squaresPerRow;
        }
        for(int i = 0; i < squaresPerRow; i++){
            value[i] = temp;
            temp += squaresPerRow;
        }
        return value;
    }

    public static void main(String[] args){
        new Main();
    }
}
