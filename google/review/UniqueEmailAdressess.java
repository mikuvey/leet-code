//Topic: String Parsing, Transformation
//Understanding of split(), replace() methods is vital for this problem
//Time Complexity: O(N.M) where M is the size of maximum length of an email.
//More details or errors: https://docs.google.com/document/d/1OoJYKMvS977wwE8fbqzvdbaIfMAJqRLL98SDKYzPiaU/edit

import java.util.HashSet;

Package google.review;

class Solution {
    public int numUniqueEmails(String[] emails) {
        //Insert the transformed emails in hashSet
        
        Set<String> set = new HashSet<>();
        
        //Iterate over all the emails
        for(String email: emails){
            String[] currEmail = email.split("@");
            
            //Get only till the +
            String[] local = currEmail[0].split("\\+");
            
            set.add(local[0].replace(".", "") + "@" + currEmail[1]);
        }

        return set.size();
    }
}