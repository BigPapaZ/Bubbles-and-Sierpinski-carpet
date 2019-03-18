package zrandhawHWK5;

class Palindrome
{
    /*
    public static boolean isPalindrome(String s)
    {
        return isPalinHelper(s,0,s.length()-1);
    }
    */
    public static boolean isPalin(String s,int lowerIndex, int higherIndex)
    {
        if(lowerIndex >= higherIndex){return true;}
        else if(s.charAt(lowerIndex)!=s.charAt(higherIndex)){return false;}
        else{return isPalin(s,lowerIndex+1,higherIndex-1);}
    }
    
    public static void main(String args[])
    {
    String s = args[0].toLowerCase();
    if (isPalin(s,0,s.length()-1))
        System.out.println(s + " is a palindrome");
    else
        System.out.println(s + " is not a palindrome");
    }
}