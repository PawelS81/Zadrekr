package operations;

import interfaces.FactoryOperation;
import interfaces.Converter;
import interfaces.Validator;

public class MessagesOperations implements FactoryOperation {

	private final Converter converter;
	private final Validator validator;

	private MessagesOperations(MessagesOperationsBuilder builder) {
		this.converter = builder.converter;
		this.validator = builder.validator;
	}

	public static MessagesOperationsBuilder builder() {
		return new MessagesOperationsBuilder();
	}

	@Override
	public Converter getConverter() {
		return this.converter;
	}

	@Override
	public Validator getValidator() {
		return this.validator;
	}

	public static class MessagesOperationsBuilder {
		private Converter converter;
		private Validator validator;

		public MessagesOperationsBuilder converter(Converter c) {
			this.converter = c;
			return this;
		}

		public MessagesOperationsBuilder validator(Validator v) {
			this.validator = v;
			return this;
		}

		public MessagesOperations build() {
			return new MessagesOperations(this);
		}

	}
}
