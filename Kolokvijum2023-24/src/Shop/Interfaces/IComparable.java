package Shop.Interfaces;

import Exceptions.NotComparable;

public interface IComparable {
    boolean compare(Object object) throws NotComparable;
}
