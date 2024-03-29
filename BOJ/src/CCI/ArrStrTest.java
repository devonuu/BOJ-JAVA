package CCI;

public class ArrStrTest {

    public static void main(String[] args) {
/*
        String str1 = "plea";
        String str2 = "ple";
        System.out.println(canEqual(str1, str2));
*/
/*
        String dupStr = "aabcccca";
        compactStr(dupStr);
*/
        int N = 4;
        int[][] image = new int[N][N];
        int count = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                image[i][j] = count;
                count++;
            }
        }
        int lessLen = N - 1;
        int[][] rotate = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotate[j][lessLen - i] = image[i][j];
            }
        }
        System.out.println("===original===");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==============\n");

        System.out.println("===rotate===");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(rotate[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==============\n");
    }

    private static void compactStr(String dupStr) {
        int cnt = 1;
        char target = dupStr.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(target);
        for (int i = 1; i < dupStr.length(); i++) {
            if (target == dupStr.charAt(i)){
                cnt++;
            }else {
                target = dupStr.charAt(i);
                sb.append(cnt).append(target);
                cnt = 1;
            }
        }
        sb.append(cnt);
        if (sb.length() > dupStr.length()){
            System.out.println(dupStr);
        }else{
            System.out.println(sb.toString());
        }
    }

    private static boolean canEqual(String str1, String str2) {
        int aLen = str1.length();
        int bLen = str2.length();

        if (Math.abs(aLen - bLen) > 1) {
            return false;
        }

        int cnt = 0;
        for (int i = 0; i < aLen; i++) {
            if (str1.charAt(i) != str2.charAt(i)){
                if (aLen == bLen){
                    cnt++;
                }else if (aLen > bLen){
                    StringBuilder sb = new StringBuilder(str1);
                    sb.replace(i, i + 1, "");
                    str1 = sb.toString();
                    aLen--;
                    i--;
                }else {
                    StringBuilder sb = new StringBuilder(str2);
                    sb.replace(i, i + 1, "");
                    str2 = sb.toString();
                    bLen--;
                    i--;
                }
            }
        }
        if (cnt > 1) {
            return false;
        }else{
            return true;
        }
    }
}
