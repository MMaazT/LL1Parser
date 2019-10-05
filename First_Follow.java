import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class First_Follow{
    public static void main(String args []){
        
        HashMap<String, String> derivations= new HashMap<String, String>();
        derivations.put("E","TE'");
        derivations.put("E'", "+TE'|#");
        derivations.put("T","FT'");
        derivations.put("T'", "*FT'|#");
        derivations.put("F","(E)|id");

        //System.out.println(derivations);
        findFirst(derivations);

    }

    public static void findFirst(HashMap<String, String> hm){
        //for each key in keySet, go the first terminal, and append it to the follow set for that key, ad append the follow set to an array.
        ArrayList followSets= new ArrayList();

        //do recursive calls for each e
        for (String ruleLeft : hm.keySet()) {
            findTerminal(hm, ruleLeft, followSets);
        }
        System.out.print(followSets);
    }

    public static void findTerminal(HashMap<String, String> hm, String ruleLeft, ArrayList arr){
        String first= hm.get(ruleLeft).length()==1 ? hm.get(ruleLeft).charAt(0)+"" : hm.get(ruleLeft).substring(0,2); 
        if(!(first.equals("E") || first.equals("E'") || first.equals("T") || first.equals("T'") || first.equals("F"))){
            HashMap<String, String> fs= new HashMap<>();
            //if(hm.get(ruleLeft).contains("|"){
               // String arr []= hm.get(ruleLeft).split("|");

            //}
            fs.put(ruleLeft,first.substring(0,1));
            arr.add(fs);
            //return;
        }
        else{
            findTerminal(hm, first, arr);
        }
    }
}