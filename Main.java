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

    private boolean CheckNumber(int num){
        return false;
    }

    private int[] RowIndex(int num){
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

    private int[] ColumnIndex(int num){
        int[] value = new int[(int) Math.sqrt(squares)];
        int temp = num;
        while(true){
            if(temp % squaresPerRow == 0){
                break;
            }
            temp--;
        }
        for(int i = 0; i < squaresPerRow; i++){
            value[i] = temp;
            temp++;
        }
        return value;
    }

    private int[] SectionIndex(int num){
        return switch(num){
            case 0, 1, 2 -> new int[]{0, 1, 2};
            case 3, 4, 5 -> new int[]{3, 4, 5};
            case 6, 7, 8 -> new int[]{6, 7, 8};
            default -> new int[0];
        };
    }

    public static void main(String[] args){
        new Main();
    }
}
