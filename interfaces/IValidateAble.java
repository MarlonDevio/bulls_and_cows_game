package bullscows.interfaces;



public interface IValidateAble <T,C ,R> {
    R validate(T input, C compare);
}
