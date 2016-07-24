package org.young.hibernate.common;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.hibernate.id.IdentifierGenerationException;
import org.hibernate.id.IdentifierGeneratorHelper;
import org.hibernate.id.IntegralDataTypeHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * IdentifierGeneratorHelper ，final 类，不可继承
 *
 * @author by youngz
 *      on 2016年7月24日
 *
 * Package&FileName: org.young.hibernate.common.HIIdentifierGeneratorHelper
 */
public class HIIdentifierGeneratorHelper {

	public static IntegralDataTypeHolder getIntegralDataTypeHolder(
			Class integralType) {
		if ((integralType == Long.class) || (integralType == Integer.class)
				|| (integralType == Short.class)
				// 增加对String的判断
				|| (integralType == String.class)) {
			return new HIBasicHolder(integralType);
		}
		if (integralType == BigInteger.class)
			return new IdentifierGeneratorHelper.BigIntegerHolder();

		if (integralType == BigDecimal.class) {
			return new IdentifierGeneratorHelper.BigDecimalHolder();
		}

		throw new IdentifierGenerationException(
				"Unknown integral data type for ids : "
						+ integralType.getName());
	}

	public static class HIBasicHolder implements IntegralDataTypeHolder {
		private final Class exactType;
		private long value = 0L;

		public HIBasicHolder(Class exactType) {
			
			this.exactType = exactType;
			if ((exactType != Long.class) && (exactType != Integer.class)
					&& (exactType != Short.class)
					// 增加对String的判断
					&& (exactType != String.class)
					)
				throw new IdentifierGenerationException(
						"Invalid type for basic integral holder : " + exactType);
		}
		
		public long getActualLongValue() {
			return this.value;
		}

		public IntegralDataTypeHolder initialize(long value) {
			this.value = value;
			return this;
		}

		public IntegralDataTypeHolder initialize(ResultSet resultSet,
				long defaultValue) throws SQLException {
			long value = resultSet.getLong(1);
			if (resultSet.wasNull())
				value = defaultValue;

			return initialize(value);
		}

		public void bind(PreparedStatement preparedStatement, int position)
				throws SQLException {
			preparedStatement.setLong(position, this.value);
		}

		public IntegralDataTypeHolder increment() {
			checkInitialized();
			this.value += 1L;
			return this;
		}

		private void checkInitialized() {
			if (this.value == 0L)
				throw new IdentifierGenerationException(
						"integral holder was not initialized");
		}

		public IntegralDataTypeHolder add(long addend) {
			checkInitialized();
			this.value += addend;
			return this;
		}

		public IntegralDataTypeHolder decrement() {
			checkInitialized();
			this.value -= 1L;
			return this;
		}

		public IntegralDataTypeHolder subtract(long subtrahend) {
			checkInitialized();
			this.value -= subtrahend;
			return this;
		}

		public IntegralDataTypeHolder multiplyBy(IntegralDataTypeHolder factor) {
			return multiplyBy(IdentifierGeneratorHelper.extractLong(factor));
		}

		public IntegralDataTypeHolder multiplyBy(long factor) {
			checkInitialized();
			this.value *= factor;
			return this;
		}

		public boolean eq(IntegralDataTypeHolder other) {
			return eq(IdentifierGeneratorHelper.extractLong(other));
		}

		public boolean eq(long value) {
			checkInitialized();
			return (this.value == value);
		}

		public boolean lt(IntegralDataTypeHolder other) {
			return lt(IdentifierGeneratorHelper.extractLong(other));
		}

		public boolean lt(long value) {
			checkInitialized();
			return (this.value < value);
		}

		public boolean gt(IntegralDataTypeHolder other) {
			return gt(IdentifierGeneratorHelper.extractLong(other));
		}

		public boolean gt(long value) {
			checkInitialized();
			return (this.value > value);
		}

		public IntegralDataTypeHolder copy() {
			HIBasicHolder copy = new HIBasicHolder(this.exactType);
			copy.value = this.value;
			return copy;
		}

		public Number makeValue() {
			checkInitialized();
			if (this.exactType == Long.class)
				return Long.valueOf(this.value);
			
			// 增加对String的判断
			if (this.exactType == String.class) {
				return Long.valueOf(this.value);
			}

			if (this.exactType == Integer.class) {
				return Integer.valueOf((int) this.value);
			}

			return Short.valueOf((short) (int) this.value);
		}

		public Number makeValueThenIncrement() {
			Number result = makeValue();
			this.value += 1L;
			return result;
		}

		public Number makeValueThenAdd(long addend) {
			Number result = makeValue();
			this.value += addend;
			return result;
		}

		public String toString() {
			return "BasicHolder[" + this.exactType.getName() + "[" + this.value
					+ "]]";
		}

		public boolean equals(Object o) {
			if (this == o)
				return true;

			if ((o == null) || (super.getClass() != o.getClass())) {
				return false;
			}

			HIBasicHolder that = (HIBasicHolder) o;

			return (this.value == that.value);
		}

		public int hashCode() {
			return (int) (this.value ^ this.value >>> 32);
		}
	}
}
