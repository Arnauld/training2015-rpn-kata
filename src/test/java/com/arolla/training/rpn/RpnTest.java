package com.arolla.training.rpn;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RpnTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private RpnCalculator rpnCalculator;

	@Before
	public void setUp() {
		rpnCalculator = new RpnCalculator();
	}

	@Test
	public void should_return_the_given_number() {
		// when
		List<Integer> result = rpnCalculator.evaluate("5");

		// then
		assertThat(result).containsExactly(5);
	}

	@Test
	public void should_return_the_given_numbers() {
		// when
		List<Integer> result = rpnCalculator.evaluate("5 12");

		// then
		assertThat(result).containsExactly(5, 12);
	}

	@Test
	public void should_return_given_numbers_sum_result() {
		// when
		List<Integer> result = rpnCalculator.evaluate("5 12 +");

		// then
		assertThat(result).containsExactly(17);
	}

	@Test
	public void should_return_given_numbers_including_one_sum() {
		// when
		List<Integer> result = rpnCalculator.evaluate("3 3 5 +");

		// then
		assertThat(result).containsExactly(3, 8);
	}

	@Test
	public void should_return_given_numbers_substraction_result() {
		// when
		List<Integer> result = rpnCalculator.evaluate("5 2 -");

		// then
		assertThat(result).containsExactly(3);
	}

	@Test
	public void should_return_given_numbers_multiplication_result() {
		// when
		List<Integer> result = rpnCalculator.evaluate("5 3 *");

		// then
		assertThat(result).containsExactly(15);
	}

	@Test
	public void should_return_given_numbers_division_result() {
		// when
		List<Integer> result = rpnCalculator.evaluate("10 2 /");

		// then
		assertThat(result).containsExactly(5);
	}

	@Test
	public void should_handle_complex_expressions() {
		assertThat(rpnCalculator.evaluate("7 3 + 3 * 3 /")).containsExactly(10);
	}

	@Test
	public void should_handle_complex_expressions__another_example() {
		assertThat(rpnCalculator.evaluate("3 5 8 * 7 + *")).containsExactly(141);
	}

	@Test
	public void should_reject_value_if_operand_count_is_invalid() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Cannot process operation, reason: operand missing.");

		// when
		rpnCalculator.evaluate("7 +");
	}

	@Test
	public void should_reject_value_if_operator_is_invalid() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Cannot process operation, reason: operator unknown.");

		// when
		rpnCalculator.evaluate("7 8 %");
	}

	@Test
	public void should_accept_custom_operator() {
		OperatorRegistry registry = new OperatorRegistry();
		registry.register(new MyToken("%"),
				(firstOperand, secondOperand) -> firstOperand % secondOperand);
		rpnCalculator = new RpnCalculator(registry);

		List<Integer> result = rpnCalculator.evaluate("10 4 %");
		assertThat(result).containsExactly(2);
	}

}
