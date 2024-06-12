// Time Complexity : O(L)  l is length of the word
// Space Complexity : O(no of words * length of each word)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Leetcode Problem: https://leetcode.com/problems/replace-words/

class Solution {
    //structure of the class
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    private void insert(TrieNode root, String word){
        TrieNode curr = root;
        for(int i = 0; i< word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];    
        }
        curr.isEnd = true;
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        //insert words in the dictionary
        TrieNode root = new TrieNode();
        for(String str : dictionary){
            insert(root, str);
        }
        //coming to sentence, splitting words based on spaces 
        //to get array of all the words
        String[] strArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = 0; i< strArr.length; i++){
            String word = strArr[i];
            TrieNode curr = root;
            StringBuilder replacement = new StringBuilder();
            //getting the character 1 by 1 from the word
            for(int k = 0; k<word.length(); k++){
                char c = word.charAt(k);
                if(curr.children[c-'a'] == null || curr.isEnd){
                break;
                }
                curr = curr.children[c-'a'];
                replacement.append(c);
            }
            if(curr.isEnd){
                result.append(replacement);
                result.append(" ");
            }else{
                result.append(word);
                result.append(" ");
            }
        }  
        return result.toString().trim();  

    }
}

//Using HashSet
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary);
        String[] str = sentence.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i=0;i< str.length;i++){

            String word = str[i];
            boolean flag = false;
            if(i > 0){
                sb.append(" ");
            }
            for(int j=0;j<word.length();j++) {
                String substr = word.substring(0,j+1);
                if(set.contains(substr)) {
                    sb.append(substr);
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                sb.append(word);
            }
        }

        return sb.toString();
    }
}
