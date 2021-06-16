package programmers.level1;

public class Num72410 {
//신규 아이디
    public static String solution(String new_id){
        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        //System.out.println("1단계 = " + new_id);
        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        for (int i = 0; i < new_id.length(); i++) {
            if ((new_id.charAt(i) >= 97 && new_id.charAt(i) <= 122)
                || new_id.charAt(i) == '-' || new_id.charAt(i) == '_'
                || new_id.charAt(i) == '.' || (new_id.charAt(i) - '0' >= 0 && new_id.charAt(i) - '0' <= 9)
            ){
                sb.append(new_id.charAt(i));
            }
        }
        //System.out.println("2단계 = " + sb.toString());
        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '.'){
                int count = 1;
                int endIndex = 0;
                for (int j = i + 1; j < sb.length(); j++) {
                    if (sb.charAt(j) == '.'){
                        count++;
                        endIndex = j;
                    }else {
                        break;
                    }
                }
                if (count > 1){
                    sb.replace(i, endIndex + 1, ".");
                }
            }
        }
        //System.out.println("3단계 = " + sb.toString());

        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (sb.charAt(0) == '.') sb.deleteCharAt(0);
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        //System.out.println("4단계 = " + sb.toString());

        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if ("".equals(sb.toString())) sb.append("a");
        //System.out.println("5단계 = " + sb.toString());

        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (sb.length() >= 16) sb = new StringBuilder(sb.substring(0, 15));
        if (sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        //System.out.println("6단계 = " + sb.toString());

        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if (sb.length() <= 2){
            String str = sb.charAt(sb.length() - 1) + "";
            while (sb.length() < 3){
                sb.append(str);
            }
        }
        //System.out.println("7단계 = " + sb.toString());
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "=.=";
        System.out.println(str);
        String result = solution(str);
        System.out.println(result);
    }
}
