package interfaces;

import java.math.BigDecimal;

public interface Converter<T,Y> {

	Y convert(T value);
}
