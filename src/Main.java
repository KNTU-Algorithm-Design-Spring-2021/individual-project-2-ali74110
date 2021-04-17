import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DictionaryLoader dictLoader = new DictionaryLoader();
//        List<String> dic = dictLoader.getWords();

        String bondCode = BondsCode.getBondCode();
        bondCode = bondCode.toLowerCase();
        int codeLen = bondCode.length();

        int [][] validSubSt = new int[codeLen][codeLen];
        for (int i = 0; i < codeLen ; i++) {
            for (int j = i+1; j <= codeLen ; j++) {
                if (dictLoader.contains(bondCode.substring(i,j))){
//                    System.out.println(bondCode.substring(i,j));
                    validSubSt[i][j-1] = bondCode.substring(i,j).length();
                }else {
                    validSubSt[i][j-1] = 0;
                }
            }
        }

        int x = -1 ,choice = 0;
        for (int i = 0; i < codeLen ; i++) {
            for (int j = i+1; j < codeLen ; j++) {
                if (validSubSt[i][j]>x){
                    x = validSubSt[i][j];
                    choice = j;
                }
            }
            if (x!=-1 && validSubSt[i][choice]!=0){
                System.out.print(bondCode.substring(i,choice+1)+" ");
                i = choice;
            }
            x=-1;
        }

    }
    static void findValidWords(DictionaryLoader dictLoader, int [][] validSubSt, String bondCode, int i, int j){
        if (i==bondCode.length() || j==-1){
            return;
        }
        System.out.println("i,j="+i+","+j);
        if (dictLoader.contains(bondCode.substring(i, j))){
            validSubSt[i][j] = bondCode.substring(i, j).length();
            System.out.print(bondCode.substring(i, j)+" ");
        }else {
            validSubSt[i][j] = 0;
            if (j>i+1){
                findValidWords(dictLoader, validSubSt, bondCode, i+1, j);
            }
            if (j-1>i){
                findValidWords(dictLoader, validSubSt, bondCode, i, j-1);
            }
        }
    }
}
