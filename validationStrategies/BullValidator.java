package bullscows.validationStrategies;

import bullscows.interfaces.IValidateAble;

import java.util.List;

public class BullValidator  implements IValidateAble<String, List<Character>, Integer> {

    @Override
    public Integer validate(String toValidate, List<Character> toCompare) {
        int count = 0;
        for(int i = 0; i < toValidate.length(); i++){
           count+= toValidate.charAt(i) == toCompare.get(i) ? 1 : 0;
        }
        return count;
    }
}
