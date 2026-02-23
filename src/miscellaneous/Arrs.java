package miscellaneous;

class Arrs {
    public static void main(String[] args) {
        int sum = 0;
        int k = 0;
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                arr[i][j] = k;
                k++;
                if (i + j == 2) sum += arr[i][j];
                System.out.print(arr[i][j] + " ");
                if (j == 2) System.out.println();
            }
        System.out.println(sum);
    }
}