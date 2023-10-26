public class Exp4{
    public static double Atoe(String s){
        double val =0.0, power = 0;
        int sign, i = 0, j, e;
        char c;
        sign = 1;
        if(s.charAt(i) == '+'|| s.charAt(i) == '-'){
            sign = (s.charAt(i) == '+')?1:-1;
            i++;
        }
        val = 0;
        while(i < s.length()){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                val = val * 10 + (s.charAt(i) - '0');
                i++;
            }
            else break;
        }
        if(i < s.length()){
            if(i < s.length() && s.charAt(i) == '.'){
                i++;
                power = 1;
                while(i < s.length()){
                    if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                        val = val * 10 + s.charAt(i) - '0';
                        power *= 10;
                        i++;
                    }
                    else break;
                }
                val = val / power;
            }
        }
        if(i < s.length()){
            if(s.charAt(i) == 'e'|| s.charAt(i) == 'E'){
                i++;
                if(i < s.length() && (s.charAt(i) == '+'|| s.charAt(i) == '-')){
                    c = s.charAt(i);
                    i++;
                }
                else c = '+';
                e = 0;
                    while(i < s.length()){
                        if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                            e = e * 10 + (s.charAt(i) - '0');
                            i++;
                        }
                        else break;
                    }
                    if(c == '+'){
                        for(j = e; j > 0; j--)
                            val *= 10;
                    }
                    else{
                        for(j = e; j > 0; j--)
                            val /= 10;
                    }
                }
            }
            return(val * sign);
        }
    
         public static void main(String[] args){
            System.out.println("");
            System.out.println("测试1");
            String s = "+1.345e-2";
            System.out.print("s:" + s);
            System.out.println("s转换的实数:" + Atoe(s));
            System.out.println("测试2");
            s = "-123";
            System.out.print("s:" + s);
            System.out.println("s转换的实数:" + Atoe(s));
            System.out.println("测试3");
            s = "-1.0e-3";
            System.out.print("s:" + s);
            System.out.println("s转换的实数:" + Atoe(s));
    }
}
