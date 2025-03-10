import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int tc = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        
        for(int t = 0; t < tc; t++) { // 여러 개의 테스트 케이스 실행
            String str = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();
            
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                switch(c) {
                    case '<': 
                        if(iter.hasPrevious()) iter.previous(); 
                        break;
                    case '>': 
                        if(iter.hasNext()) iter.next(); 
                        break;
                    case '-': 
                        if(iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default: 
                        iter.add(c);
                        break;
                }
            }

            for(Character chr : list) {
                bw.write(chr);
            }
            bw.write("\n");
        }
        
        bw.flush();
        bw.close();
    }
}
