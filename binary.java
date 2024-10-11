import java.util.*;
public class binary {
    public static String DecimalToBinaryPositive(int n){
        String b="";
        int i=n;
        while(i!=0){
            if(i%2==0)
            b="0"+b;
            else
            b="1"+b;
            i/=2;
        }
       // System.out.println(b);
        return b;
    }
    public static String DecimalToBinaryNegative(int n){
        n=n*(-1);
        String b;
        String pn=DecimalToBinaryPositive(n);
        b=TwosCompliment(pn);
       // System.out.println(b);
        return b;
    }
    public static String TwosCompliment(String s){
    String b="",c=""; //b is one's compliment of the negative binary number        
        for(int i=0;i<s.length();i++){ //Reversing 1's with 0's and vice versa
            if(s.charAt(i)=='0')
                b=b+'1';
            else if(s.charAt(i)=='1')
                b=b+'0';
        }
       // System.out.println(b);
        if(b.charAt(b.length()-1)=='0')
            b=b.substring(0,b.length()-1)+"1";

        else  if(b.charAt(b.length()-1)=='1'){
            for(int i=s.length()-1;i>=0;i--){
                if(s.charAt(i)=='0')
                    c="0"+c;
                else if(s.charAt(i)=='1'){
                    c=b.substring(0,i)+"1"+c;
                    break;
                }
            }
            b=c;
        }
        return b;
    }
    public static String DecimalToBinaryConverter(int n){
        String binary="";
        if(n>0){   
            binary=DecimalToBinaryPositive(n);
         //   System.out.println("Its binary is: "+binary);
            }
            else if (n<0){
            binary=DecimalToBinaryNegative(n);
          //  System.out.println("Its binary in 2's compliment form is: "+binary);
            }
            

            return binary;
    }
    public static String IncreaseNumberOfBitsEqual(String A,String B){
        String s="";
            for(int i=0;i<(A.length()-B.length());i++){
            s=s+"0";
            }
            s=s+B;       
       // System.out.println(A);
       // System.out.println(B);
        
        return s;
    }
    public static String ThreeBitSum(char A,char B,char C) {
        if((A=='1' && B=='0' && C=='0')||(A=='0' && B=='1' && C=='0')||(A=='0' && B=='0' && C=='1')||(A=='1' && B=='1' && C=='1'))
        return "1";
        else
        return"0";        
    }
    public static String ThreeBitCarry(char A,char B,char C) {
        if((A=='0' && B=='1' && C=='1')||(A=='1' && B=='0' && C=='1')||(A=='1' && B=='1' && C=='0')||(A=='1' && B=='1' && C=='1'))
        return "1";
        else
        return"0"; 
    }
    public static String AdderinBinary(String A,String B){ 
        String result="",Cin="0";
        if(A.length()<B.length())
            A=IncreaseNumberOfBitsEqual(B, A);
        else if(A.length()>B.length())
            B=IncreaseNumberOfBitsEqual(A, B);
        
        // System.out.println(A);
        // System.out.println(B);
      
        int i=A.length()-1;
        while(i>=0){
            result=ThreeBitSum(A.charAt(i), B.charAt(i), Cin.charAt(0))+result;
            Cin=ThreeBitCarry(A.charAt(i), B.charAt(i), Cin.charAt(0));
            i--;
        }
         result=Cin.concat(result);
        
    return result;
    }
    public static String AdderinDecimal(int x,int y){
        String a = DecimalToBinaryConverter(x);
        String b = DecimalToBinaryConverter(y);
        String result = AdderinBinary(a, b);
        return result;    
    }
    public static String SubtracterinBinary(String A,String B){
        if(A.length()<B.length())
            A=IncreaseNumberOfBitsEqual(B, A);
        else if(A.length()>B.length())
            B=IncreaseNumberOfBitsEqual(A, B);
        B=TwosCompliment(B);
        String result = AdderinBinary(A, B);
        return result;
    }
    public static String SubtracterinDecimal(int x,int y){
        String A = DecimalToBinaryConverter(x);
        String B = DecimalToBinaryConverter(y);
        if(A.length()<B.length())
            A=IncreaseNumberOfBitsEqual(B, A);
        else if(A.length()>B.length())
            B=IncreaseNumberOfBitsEqual(A, B);
            B=TwosCompliment(B);
        String result = AdderinBinary(A, B);
        return result;
    }

    
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.println("1.Decimal to binary");
        System.out.println("2.Binary Adder");
        System.out.println("3.Binary Subtracter");
        System.out.println("Enter choice");
        int ch=sc.nextInt();
        switch(ch){
            case 1:
            System.out.println("Enter the decimal Number");
            int n = sc.nextInt();
            String result = DecimalToBinaryConverter(n);
            if(n>0)
            System.out.println("Its binary form is: "+result);
            else if(n<0)
            System.out.println("Its binary in Two's compliment form is: "+result);
            else
            System.out.println("Its binary is 0");
            break;

            case 2:
            System.out.println("Choose Number System for input\n 1.In binary 2.In decimal");
            int ch2 = sc.nextInt();
            sc.nextLine();
            if(ch2 == 1){
                System.out.println("Enter two binary numbers");
                String a=sc.nextLine();
                String b=sc.nextLine();
                String finalResult = AdderinBinary(a, b);
                System.out.println("Answer = "+finalResult);

            }
            else if(ch2 == 2){
                System.out.println("Enter two decimal numbers");
                int a = sc.nextInt();
                int b = sc.nextInt();
                String finalResult = AdderinDecimal(a, b);
                System.out.println("Answer = "+finalResult);
            }
            else{
                System.out.print("Invalid input");
            }
            break;
            case 3:
            System.out.println("Choose Number System for input\n 1.In binary 2.In decimal");
            int ch3 = sc.nextInt();
            sc.nextLine();
            if(ch3 == 1){
                System.out.println("Enter two binary numbers to subtract");
                String a=sc.nextLine();
                String b=sc.nextLine();
                String finalResult = SubtracterinBinary(a, b);
                finalResult = finalResult.substring(1);
                System.out.println("Answer = "+finalResult);

            }
            else if(ch3 == 2){
                System.out.println("Enter two decimal numbers to subtract");
                int a = sc.nextInt();
                int b = sc.nextInt();
                String finalResult = SubtracterinDecimal(a, b);
                finalResult = finalResult.substring(1);
                System.out.println("Answer = "+finalResult);
            }else{
                System.out.print("Invalid input");
            }
            break;



        
        }
    }
}
