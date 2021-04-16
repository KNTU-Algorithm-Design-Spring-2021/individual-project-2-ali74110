import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DictionaryLoader dictLoader = new DictionaryLoader();
//        List<String> dic = dictLoader.getWords();

        String bondCode = BondsCode.getBondCode();
        bondCode = bondCode.toLowerCase();
        int codeLen = bondCode.length();

        boolean [][] validSubSt = new boolean[codeLen][codeLen];
        for (int i = 0; i < codeLen; i++) {
            for (int j = i; j < codeLen ; j++) {
                validSubSt[i][j] = dictLoader.contains(bondCode.substring(i, j));
                if (validSubSt[i][j]){
                    System.out.print(bondCode.substring(i, j)+" ");
                    i=j-1;
                    break;
                }
            }
        }

    }
}
