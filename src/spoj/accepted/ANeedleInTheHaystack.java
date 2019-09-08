package spoj.accepted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * @ClassName ANeedleInTheHaystack
 * @Description NHAY - A Needle in the Haystack
 * Input
 * The input consists of a number of test cases. Each test case is composed of three lines, containing:
 *
 * the length of the needle,
 * the needle itself,
 * the haystack.
 *
 * Output
 * For each test case your program should output all positions of the needle's occurences within the haystack.
 * If a match is found, the output should contain the position of the first character of the match.
 * Characters in the haystack are numbered starting with zero.
 *
 * For a given test case, the positions output should be sorted in ascending order,
 * and each of these should be printed in a separate line.
 * For two different test cases, the positions should be separated by an empty line.
 * @Author NebulaPort
 * @Date 2019/8/28 15:17
 */
public class ANeedleInTheHaystack {
    public static void main(String[] args) throws IOException {

//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        String temp;
//
//        while ((temp=br.readLine())!=null){
//            int len = Integer.parseInt(temp);
//            String needle = br.readLine();
//            String haystack = br.readLine();

        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int len=in.nextInt();
            in.nextLine();
            String needle=in.nextLine();
            String haystack=in.nextLine();


            int i;
            int fromIndex=0;
            while(fromIndex<haystack.length()-len+2){
                i=haystack.indexOf(needle,fromIndex);
                if (i!=-1) {
                    fromIndex=i+1;  System.out.println(i);

                }else{
                    break;
                }

            }
            System.out.println();
        }

    }


}
