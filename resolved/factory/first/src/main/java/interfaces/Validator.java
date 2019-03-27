package interfaces;

public interface Validator<T> {
	default boolean isValid(T value) {
		return value != null;
	}
}
