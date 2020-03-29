import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;

public class decode {

       public static String decrypt(String keyword1, String keyword2, String ciphertext){

           StringBuffer first = new StringBuffer();
           StringBuffer sec = new StringBuffer();

           for (int i = 0; i < ciphertext.length(); i++) {
               if (i == 0 || i % 2 == 0) {
                   first.append(ciphertext.charAt(i));
               } else {
                   sec.append(ciphertext.charAt(i));
               }
           }

           ArrayList<Integer> firstindex = new ArrayList<>();
           ArrayList<Integer> secindex = new ArrayList<>();

           for (int g = 0; g < first.length(); g++) {
               for (int i = 0; i < 5; i++) {
                   for (int j = 0; j < 5; j++) {
                       if (square.leftbot(keyword1)[i][j] == first.charAt(g)) {
                           firstindex.add(i);
                           firstindex.add(j);
                       }
                       if(square.righttop(keyword2)[i][j] == sec.charAt(g)){
                           secindex.add(i);
                           secindex.add(j);
                       }
                   }
               }
           }

           int[][] firstindexplain = new int[firstindex.size()/2][2];

           for(int i = 0; i < firstindexplain.length; i++){
               for(int j = 0; j < 2; j++){
                   firstindexplain[i][j] =firstindex.get(i * 2 + j);
               }
           }

           int[][] secindexplain = new int[secindex.size()/2][2];
           for(int i = 0; i < secindexplain.length; i++){
               for(int j = 0; j < 2; j++){
                   secindexplain[i][j] = secindex.get(i * 2 + j);
               }
           }

           ArrayList<Character> firstplain = new ArrayList<>();
           for(int i = 0; i < firstindexplain.length; i++){

               firstplain.add(square.leftop()[secindexplain[i][0]][firstindexplain[i][1]]);


           }

           ArrayList<Character> secplain = new ArrayList<>();

           for(int i = 0; i < secindexplain.length; i++){
               secplain.add(square.leftop()[firstindexplain[i][0]][secindexplain[i][1]]);

           }

           StringBuffer realplaintext = new StringBuffer();
           for(int i = 0 ; i < firstplain.size(); i++){
               realplaintext.append(firstplain.get(i));
               realplaintext.append(secplain.get(i));
           }

         String plain = realplaintext.toString();

           return plain;
       }


    public static void main(String[] args) {


        String key1 = "KEYWORD";
        String key2 = "EXAMPL";
        String cipherstring = "IDWTGH";



        StringBuffer first = new StringBuffer();
        StringBuffer sec = new StringBuffer();

        for (int i = 0; i < cipherstring.length(); i++) {


            if (i == 0 || i % 2 == 0) {
                first.append(cipherstring.charAt(i));
            } else {
                sec.append(cipherstring.charAt(i));
            }

        }



        ArrayList<Integer> firstindex = new ArrayList<>();
        ArrayList<Integer> secindex = new ArrayList<>();


        for (int g = 0; g < first.length(); g++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (square.leftbot(key1)[i][j] == first.charAt(g)) {
                        firstindex.add(i);
                        firstindex.add(j);
                    }
                    if(square.righttop(key2)[i][j] == sec.charAt(g)){
                        secindex.add(i);
                        secindex.add(j);
                    }

                }
            }
        }




       int[][] firstindexplain = new int[firstindex.size()/2][2];

        for(int i = 0; i < firstindexplain.length; i++){
            for(int j = 0; j < 2; j++){
                firstindexplain[i][j] =firstindex.get(i * 2 + j);
            }
        }

       int[][] secindexplain = new int[secindex.size()/2][2];
        for(int i = 0; i < secindexplain.length; i++){
            for(int j = 0; j < 2; j++){
                secindexplain[i][j] = secindex.get(i * 2 + j);
            }
        }




            ArrayList<Character> firstplain = new ArrayList<>();
        for(int i = 0; i < firstindexplain.length; i++){

                firstplain.add(square.leftop()[secindexplain[i][0]][firstindexplain[i][1]]);


        }

        ArrayList<Character> secplain = new ArrayList<>();

        for(int i = 0; i < secindexplain.length; i++){
            secplain.add(square.leftop()[firstindexplain[i][0]][secindexplain[i][1]]);

        }

       StringBuffer realplaintext = new StringBuffer();
        for(int i = 0 ; i < firstplain.size(); i++){
            realplaintext.append(firstplain.get(i));
            realplaintext.append(secplain.get(i));
        }

        System.out.println(realplaintext);



    }
}