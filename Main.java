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

    private boolean CheckNumber(int num, int section){
        int[] rowIndex = RowNums(num);
        int[] columnIndex = ColumnNums(num);
        int[] sectionRow = SectionRow(section);
        int[] sectionColumn = SectionColumn(section);
        return false;
    }

    private int[] RowNums(int num){
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

    private int[] ColumnNums(int num){
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

    private int[] SectionRow(int num){
        return switch(num){
            case 0, 3, 6 -> new int[]{0, 3, 6};
            case 1, 4, 7 -> new int[]{1, 4, 7};
            case 2, 5, 8 -> new int[]{2, 5, 8};
            default -> new int[0];
        };
    }

    private int[] SectionColumn(int num){
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
