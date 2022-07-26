package dmv.portal;

import java.util.Random;

public class LicenceNumberGenerator {
    public LicenceNumberGenerator(){

    }

    public String generator(){
        Random random = new Random();
        char randomChar1 = (char) (random.nextInt(26) + 'A');
        char randomChar2 = (char) (random.nextInt(26) + 'A');
        char randomChar3 = (char) (random.nextInt(26) + 'A');
        int number = random.nextInt(999999);
        String num2String = String.format("%06d",number);
        return randomChar1+""+randomChar2+num2String+randomChar3;
    }

    public static void main(String[] args){
        LicenceNumberGenerator licenceNumberGenerator = new LicenceNumberGenerator();

        System.out.println(licenceNumberGenerator.generator());
    }
}
